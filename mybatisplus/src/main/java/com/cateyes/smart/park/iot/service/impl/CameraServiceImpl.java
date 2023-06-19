package com.cateyes.smart.park.iot.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
 * 摄像头(SpIotCamera)impl
 *
 * @author CatEyes
 * @since 2023-06-19 16:30:52
 */
@Service
@AllArgsConstructor
public class CameraServiceImpl extends ServiceImpl<CameraMapper, Camera> implements ICameraService {

    private CameraMapper cameraMapper;

    @Override
    public int saveCamera(ReqCameraDto reqDto) {
        List<Camera> list = cameraMapper.selectList(new LambdaQueryWrapper<Camera>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), Camera::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        Camera map = BeanMapperUtil.map(reqDto, Camera.class);
        cameraMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deleteCamera(Integer id) {
        Camera camera = cameraMapper.selectById(id);
        Assert.notNull(camera, ApiCode.NOT_FOUND);
        return cameraMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateCamera(ReqCameraDto reqDto) {
        Camera camera = cameraMapper.selectById(reqDto.getId());
        Assert.notNull(camera, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(camera.getName(), reqDto.getName())) {
            List<Camera> list =
                cameraMapper.selectList(Wrappers.<Camera>lambdaQuery().eq(Camera::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return cameraMapper.updateById(BeanMapperUtil.map(reqDto, Camera.class)) > 0;
    }

    @Override
    public RspCameraDto queryDetail(Integer id) {
        return cameraMapper.queryDetail(id);
    }

    @Override
    public List<RspCameraDto> queryList(ReqCameraDto reqDto) {
        List<RspCameraDto> list = cameraMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspCameraDto> queryPage(ReqCameraDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspCameraDto> queryPageConditions(ReqCameraDto reqDto) {
        Page<RspCameraDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspCameraDto> pageInfo = cameraMapper.queryByConditions(page, reqDto);
        PageInfo<RspCameraDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspCameraDto> list) {
        list.forEach(a -> {

        });
    }

}
