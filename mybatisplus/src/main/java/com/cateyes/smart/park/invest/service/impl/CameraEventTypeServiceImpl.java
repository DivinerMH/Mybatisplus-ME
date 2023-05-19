package com.cateyes.smart.park.invest.service.impl;

    
    






import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import com.cateyes.smart.park.base.api.ApiCode;
import com.cateyes.smart.park.core.util.Assert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cateyes.smart.park.base.bean.vo.PageInfo;
import com.cateyes.smart.park.base.util.BeanMapperUtil;

/**
 * (SpIotCameraEventType)impl
 *
 * @author CatEyes
 * @since 2023-05-19 15:20:42
 */
@Service
@AllArgsConstructor
public class CameraEventTypeServiceImpl extends ServiceImpl<CameraEventTypeMapper, CameraEventType> implements ICameraEventTypeService{

	@Resource
    private CameraEventTypeMapper cameraEventTypeMapper;
	
	@Override
    public int saveCameraEventType(ReqCameraEventTypeDto reqDto){
        List<CameraEventType> list = cameraEventTypeMapper.selectList(
            new LambdaQueryWrapper<CameraEventType>().eq(StringUtils.isNotBlank(reqDto.getName()), CameraEventType::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        return cameraEventTypeMapper.insert(BeanMapperUtil.map(reqDto, CameraEventType.class));
    }

    @Override
    public Boolean deleteCameraEventType(Integer id){
        CameraEventType cameraEventType = cameraEventTypeMapper.selectById(id);
        Assert.notNull(cameraEventType, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return cameraEventTypeMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateCameraEventType(ReqCameraEventTypeDto reqDto){
        CameraEventType cameraEventType = cameraEventTypeMapper.selectById(reqDto.getId());
        Assert.notNull(cameraEventType, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        if (reqDto.getName() != null && !StringUtils.equals(cameraEventType.getName(), reqDto.getName())) {
            List<CameraEventType> list =
                cameraEventTypeMapper.selectList(Wrappers.<CameraEventType>lambdaQuery().eq(CameraEventType::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), ApiCode.INVEST_INDUSTRY_NAME_REPEAT);
        }
        return cameraEventTypeMapper.updateById(BeanMapperUtil.map(reqDto, CameraEventType.class)) > 0;
    }
    
    @Override
    public RspCameraEventTypeDto queryDetail(Integer id){
        return cameraEventTypeMapper.queryDetail(id);
    }

    @Override
    public List<RspCameraEventTypeDto> queryList(ReqCameraEventTypeDto reqDto) {
        return cameraEventTypeMapper.queryList(reqDto);
    }
    
    @Override
    public PageInfo<RspCameraEventTypeDto> queryPage(ReqCameraEventTypeDto reqDto) {
        return queryPageConditions(reqDto);
    }
    
    private PageInfo<RspCameraEventTypeDto> queryPageConditions(ReqCameraEventTypeDto reqDto) {
        Page<RspCameraEventTypeDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspCameraEventTypeDto> pageInfo = cameraEventTypeMapper.queryByConditions(page, reqDto);
        PageInfo<RspCameraEventTypeDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        return pageResult;
    }

}
