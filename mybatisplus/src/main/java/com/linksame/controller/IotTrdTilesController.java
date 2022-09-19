package com.linksame.controller;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.linksame.iot.common.core.constant.enums.BusinessEnum;
import com.linksame.iot.common.core.util.R;
import com.linksame.iot.common.log.annotation.SysLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linksame.entity.IotTrdTiles;
import com.linksame.vo.IotTrdTilesVO;
import com.linksame.dto.IotTrdTilesDTO;
import com.linksame.service.IIotTrdTilesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 3d-tiles �ļ����ݱ�(IotTrdTiles)����Ʋ�
 *
 * @author menghuan
 * @since 2022-08-26 10:47:27
 */
@AllArgsConstructor
@RestController
@RequestMapping("/iotTrdTiles")
@Api(value = "IotTrdTiles", tags = "3d-tiles �ļ����ݱ�ģ��")
public class IotTrdTilesController {

    /**
     * �������
     */
    private final IIotTrdTilesService iiotTrdTilesService;

    /**
     * ����3d-tiles �ļ����ݱ�
     *
     * @param iotTrdTilesDTO 3d-tiles �ļ����ݱ�������DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("����3d-tiles �ļ����ݱ�")
    @ApiOperation(value = "����3d-tiles �ļ����ݱ�")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotTrdTilesDTO", dataType = "IotTrdTilesDTO", required = true, value = "3d-tiles �ļ����ݱ����")})
    @PostMapping
    public R<Boolean> saveIotTrdTiles(@RequestBody IotTrdTilesDTO iotTrdTilesDTO) {
        return R.ok(iiotTrdTilesService.saveIotTrdTiles(iotTrdTilesDTO));
    }

    /**
     * ����id���߼���ɾ��3d-tiles �ļ����ݱ�
     *
     * @param id 3d-tiles �ļ����ݱ�id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("����id���߼���ɾ��3d-tiles �ļ����ݱ�")
    @ApiOperation(value = "����id���߼���ɾ��3d-tiles �ļ����ݱ�")
    @DeleteMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "3d-tiles �ļ����ݱ�id"))
    public R<Boolean> deleteIotTrdTiles(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotTrdTilesService.deleteIotTrdTiles(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * �޸�3d-tiles �ļ����ݱ�
     *
     * @param iotTrdTilesDTO 3d-tiles �ļ����ݱ�������DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @SysLog("�޸�3d-tiles �ļ����ݱ�")
    @ApiOperation(value = "�޸�3d-tiles �ļ����ݱ�")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotTrdTilesDTO", dataType = "IotTrdTilesDTO", required = true, value = "3d-tiles �ļ����ݱ����")})
    @PutMapping
    public R<Boolean> updateIotTrdTiles(@RequestBody IotTrdTilesDTO iotTrdTilesDTO) {
        return R.ok(iiotTrdTilesService.updateIotTrdTiles(iotTrdTilesDTO));
    }

    /**
     * ����id��ѯ3d-tiles �ļ����ݱ�����(������)
     *
     * @param id 3d-tiles �ļ����ݱ�id
     * @return 3d-tiles �ļ����ݱ�չʾ����IotTrdTilesVO
     */
    @ApiOperation(value = "����id��ѯ3d-tiles �ļ����ݱ�����(������)")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "3d-tiles �ļ����ݱ�id"))
    public R<IotTrdTilesVO> queryIotTrdTiles(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotTrdTilesService.queryIotTrdTiles(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * ����id��ѯ3d-tiles �ļ����ݱ�����(�����)
     *
     * @param id 3d-tiles �ļ����ݱ�id
     * @return 3d-tiles �ļ����ݱ�չʾ����IotTrdTilesVO
     */
    @ApiOperation(value = "����id��ѯ3d-tiles �ļ����ݱ�����(�����)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "3d-tiles �ļ����ݱ�id"))
    public R<IotTrdTilesVO> queryIotTrdTilesDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return R.ok(iiotTrdTilesService.queryIotTrdTilesDetail(id));
        }
        return R.failed(BusinessEnum.PARAMETER_NULL);
    }

    /**
     * �޲β�ѯ3d-tiles �ļ����ݱ��б�
     *
     * @return 3d-tiles �ļ����ݱ�չʾ���󼯺�IotTrdTilesVOList
     */
    @ApiOperation(value = "�޲β�ѯ3d-tiles �ļ����ݱ��б�")
    @GetMapping("/lists")
    public R<List<IotTrdTilesVO>> queryIotTrdTilesList() {
        return R.ok(iiotTrdTilesService.queryIotTrdTilesList());
    }

    /**
     * ������ѯ3d-tiles �ļ����ݱ��б�
     *
     * @param iotTrdTilesDTO 3d-tiles �ļ����ݱ�������DTO
     * @return 3d-tiles �ļ����ݱ�չʾ���󼯺�IotTrdTilesVOList
     */
    @ApiOperation(value = "������ѯ3d-tiles �ļ����ݱ��б�")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "iotTrdTilesDTO", dataType = "IotTrdTilesDTO", required = false, value = "3d-tiles �ļ����ݱ����")})
    @PostMapping("/lists/conditions")
    public R<List<IotTrdTilesVO>> queryListByConditions(@RequestBody IotTrdTilesDTO iotTrdTilesDTO) {
        // ����Ȩ��
        // iotTrdTilesDTO.setTenantId(CommonConverter.dataPermission(iotTrdTilesDTO.getTenantId()));
        return R.ok(iiotTrdTilesService.queryListByConditions(iotTrdTilesDTO));
    }

    /**
     * ��ҳ������ѯ3d-tiles �ļ����ݱ��б�
     *
     * @param iotTrdTilesDTO 3d-tiles �ļ����ݱ�������DTO
     * @return 3d-tiles �ļ����ݱ�չʾ���󼯺�IotTrdTilesVOList
     */
    @ApiOperation(value = "��ҳ������ѯ3d-tiles �ļ����ݱ��б�")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "page", dataType = "Page", required = true, value = "��ҳ����"),
            @ApiImplicitParam(paramType = "query", name = "iotTrdTilesDTO", dataType = "IotTrdTilesDTO", required = false, value = "3d-tiles �ļ����ݱ����")})
    @GetMapping("/page/conditions")
    public R<IPage<IotTrdTilesVO>> queryPageByConditions(Page page, IotTrdTilesDTO iotTrdTilesDTO) {
        // ����Ȩ��
        // iotTrdTilesDTO.setTenantId(CommonConverter.dataPermission(iotTrdTilesDTO.getTenantId()));
        return R.ok(iiotTrdTilesService.queryPageByConditions(page, iotTrdTilesDTO));
    }

    /**
     * ����Ȩ�ޣ�����ת��
     * �� tenantId == 1 ��ϵͳ�⻧,����Ϊ�� tenantId ��������� - 20.10.12
     * ��ʾ1����ǰ��ͬ��δ�ṩtenantId����,��tenantId���п�����Ϊ���ò���,����Ҫ��ν��д���
     * ��ʾ2���˴��Աȵķ��⻧���� tenantType
     * ��ʾ3��ϵͳ�⻧Ψһ��
     * ��ʾ4��������ɫ��Ӧ�ʲ��ṹ����Ȩ�� - 2021.08.19
     *
     * @param iotTrdTilesDTO ���
     * @return iotTrdTilesDTO ���������
     */
    private IotTrdTilesDTO dealParam(IotTrdTilesDTO iotTrdTilesDTO) {
        // ��һ�㴦��:��tenant���������,ֱ�Ӵӿ�ܻ�ȡ��ӦTenantId������Ϣ
        if (null == iotTrdTilesDTO.getTenantId()) {
            try {
                IotUser user = SecurityUtils.getUser();
                if (null != user.getTenantId()) {
                    iotTrdTilesDTO.setTenantId(user.getTenantId());
                }
                // ������ɫ�ʲ��ṹ����Ȩ�� - 2021.08.19
                // if (null != user.getRoleId()){
                // iotTrdTilesDTO.setAssertIdList(DataScopeComponent.assemblyParam(user.getRoleId()));
                // }
            } catch (Exception e) {
                e.printStackTrace();
                log.info("��ǰ�û���¼Ȩ����Ϣ��ȡ�쳣......");
            }
        }
        // �ڶ��㴦��:tenant�ǳ�������Ա�����,�Ƴ��⻧�߽�����,��ѯ����
        if (iotTrdTilesDTO.getTenantId() == 1) {
            iotTrdTilesDTO.setTenantId(null);
        }
        return iotTrdTilesDTO;
    }


}
