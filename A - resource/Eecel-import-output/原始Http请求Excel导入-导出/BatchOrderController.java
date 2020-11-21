package com.joolun.cloud.mall.admin.controller;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joolun.cloud.common.core.constant.CommonConstants;
import com.joolun.cloud.common.core.util.R;
import com.joolun.cloud.common.log.annotation.SysLog;
import com.joolun.cloud.mall.admin.service.BatchOrderService;
import com.joolun.cloud.mall.admin.service.GoodsSpuService;
import com.joolun.cloud.mall.admin.service.UserInfoService;
import com.joolun.cloud.mall.common.entity.BatchOrder;
import com.joolun.cloud.mall.common.entity.GoodsSpu;
import com.joolun.cloud.mall.common.enums.OrderInfoEnum;
import com.joolun.cloud.mall.common.util.BaseController;
import com.joolun.cloud.mall.common.util.ExcelUtil;
import com.joolun.cloud.mall.common.util.KeyUtil;
import com.joolun.cloud.mall.common.util.PathUtil;
import com.joolun.cloud.weixin.common.util.ThirdSessionHolder;
import com.sun.deploy.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author: Wong
 * @ClassName: BatchOrderController
 * @Date: 2020/11/12 11:14
 * @Description: 团体(批量)订单
 * @Version: V1.0
 **/
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/batchorder")
@Api(value = "batchorder", tags = "团体订单")
public class BatchOrderController extends BaseController {



	/*
	 * @Author wong
	 * @Description //TODO 下载Excel文件模板
	 * @Date
	 * @Param response 响应  request  请求
	 * @return
	 * @throws
	 **/
	@ApiOperation(value = "下载Excel文件模板")
	@GetMapping("/downloadExcel")
	//	@PreAuthorize("@ato.hasAuthority('mall:batchOrder:downloadExcel')")
	public void downloadExcel(HttpServletResponse response, HttpServletRequest request) throws IOException {
		try {
			//获取模板地址
			String filePath = com.joolun.cloud.mall.common.util.PathUtil.getPorjectPath() + "base-mall\\base-mall-admin\\batchOrderExcelTemplate.xlsx";
			//判断模板是否存在
			File file = new File(filePath);
			if (!file.exists())
				throw new Exception("模板文件不存在!");
			//输入流转换
			InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
			//假如以中文名下载的话，设置下载文件名称
			String filename = "batchOrderExcelTemplate.xlsx";
			//转码，免得文件名中文乱码
			filename = URLEncoder.encode(filename, "UTF-8");
			//设置文件下载头
			response.addHeader("Content-Disposition", "attachment; filename=" + filename);
			//1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
			response.setContentType("multipart/form-data");
			//输出流输出文件
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			int len = 0;
			while ((len = bis.read()) != -1) {
				out.write(len);
				out.flush();
			}
			out.close();
		} catch (Exception e) {
			sendResponseErrorMsg(response, e);
		}
	}

	/*
	 * @Author wong
	 * @Description //TODO 导入Excel文件
	 * @Date
	 * @Param
	 * @return Result
	 * @throws
	 **/
	@ApiOperation(value = "导入Excel文件")
	@PostMapping("/import")
	public R<List> importBatchOrder(@RequestParam MultipartFile file) {
		List<R> rs = new ArrayList<>();
		try {
			//获取类型
			String ext = FilenameUtils.getExtension(file.getOriginalFilename());
			//拼接文件名
			String reName = RandomStringUtils.randomAlphanumeric(32).toLowerCase() + "." + ext;
			//获取绝对路径
			String realPath = PathUtil.getPorjectPath();
			//获取文件
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, reName));
			//读取Excel文件内容,存在list中
			List<Map<String, String>> list = ExcelUtil.readAllExcel(realPath + reName);
			BatchOrder	batchOrder = new BatchOrder();
			//团体订单编号
			batchOrder.setBatchOrderId("TTDD" + IdUtil.getSnowflake(0,0).nextIdStr());
			//遍历数据
			for (Map<String, String> map : list) {
				batchOrder.setId(IdUtil.getSnowflake(0,0).nextIdStr());
				//查导入商品对象
				GoodsSpu goodsSpu = goodsSpuService.selectById(map.get("cell1"));
				//判断商品ID是否存在
//				if (goodsSpuService.selectBySpuId(map.get("cell1"))){
				if (goodsSpu != null &&goodsSpu.getId() != null && goodsSpu.getId().equals(map.get("cell1"))){
					//商品是否已经逻辑删除（0：未删除；1：已删除）
					if (goodsSpu.getDelFlag() != null && goodsSpu.getDelFlag().equals("0")){
						//判断商品是否上架（1是 0否）
						if (goodsSpu.getShelf() != null && goodsSpu.getShelf().equals("1")){
							//配置支付状态:是否支付0、未支付 1、已支付
							batchOrder.setIsPay(CommonConstants.NO);
							//判断是否为虚拟商品 0 否 1 是'
							if (goodsSpu.getIsVirtual() != null && goodsSpu.getIsVirtual().equals("1")){
								//订单待核销状态,状态0、待付款 1、待发货 2、待收货 3、已完成 5、已取消 6、退款中 7、待核销 10、待成团
								batchOrder.setStatus(OrderInfoEnum.STATUS_7.getValue());
							}else {
								//不为虚拟商品 标记状态
								batchOrder.setStatus(OrderInfoEnum.STATUS_0.getValue());
							}
							//标记商品价格
							if (goodsSpu.getPriceUp() == null || goodsSpu.getPriceUp().equals("0")){
								rs.add(R.failed("此产品:" + map.get("cell1") + "价格不能为负数 或 null"));
							}else {
								//最高标价,精确定位不到sku销售价格
								batchOrder.setSalesPrice(goodsSpu.getPriceUp());
							}
							//订单编号
							batchOrder.setOrderNo("DDBH" + IdUtil.getSnowflake(0,0).nextIdStr());
							//逻辑删
							batchOrder.setDelFlag(CommonConstants.STATUS_NORMAL);
							//运费金额
							batchOrder.setFreightPrice(BigDecimal.ZERO);
							//订单创建时间
							batchOrder.setCreateTime(LocalDateTime.now());
							//商品名称
							batchOrder.setGoodsName(goodsSpu.getName());
							//用户ID
							batchOrder.setUserId(map.get("cell0"));
							//商品ID
							batchOrder.setGoodsId(map.get("cell1"));
							//商品数量
							batchOrder.setGoodsNum(map.get("cell2"));
							//地址
							batchOrder.setAddress(map.get("cell3"));
							//存入数据
							batchOrderService.save(batchOrder);
						}else {
							rs.add(R.failed("此商品已下架:" + map.get("cell1")));
						}
					}else {
						rs.add(R.failed("此商品已删除:" + map.get("cell1")));
					}
				}else {
					rs.add(R.failed("此商品不存在:" + map.get("cell1")));
				}
			}
		} catch (Exception e) {
			return R.failed("状态码:"+CommonConstants.FAIL + ">>>批量导入失败:" + e.getMessage());
		}
		return R.ok(rs);
	}

	/*
	 * @Author wong
	 * @Description //TODO 导出Excel文件
	 * @Date
	 * @Param response 响应
	 * @return  Result
	 * @throws
	 **/
//	@PostMapping("/export/{id}")
//	public void export(HttpServletResponse response, @PathVariable String id) {
	@ApiOperation(value = "导出Excel文件")
	@PostMapping("/export")
	public void export(HttpServletResponse response) {
		try {
			//全部导出
			List<BatchOrder> batchOrderList = batchOrderService.list();
			//根据ID选择导出
//          List<BatchOrder> batchOrderServicelist = batchOrderService.findExcelListByPlatformId(id);
			XSSFWorkbook wb = ExcelUtil.createExcel(batchOrderList, BatchOrder.class, null);

			String filename = getExcelName("OutBatchOrder.xlsx");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + KeyUtil.random(16));
			ExcelUtil.writeExcel(response, filename, wb);
		} catch (Exception e) {
			sendResponseErrorMsg(response, e);
		}
	}

	/*
	 * @Author wong
	 * @Description //TODO 转化为excel名称
	 * @Date
	 * @Param
	 * @return
	 * @throws
	 **/
	private String getExcelName(String filename) throws UnsupportedEncodingException {
		String excelName = StringUtils.join(Collections.singleton(filename), ".xlsx");
		return URLEncoder.encode(excelName, "UTF-8");
	}

}
