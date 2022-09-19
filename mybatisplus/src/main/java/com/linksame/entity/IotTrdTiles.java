package com.linksame.entity;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 3d-tiles �ļ����ݱ�(IotTrdTiles)��ʵ����
 *
 * @author menghuan
 * @since 2022-08-26 10:47:22
 */
@Data
@ApiModel(value = "3d-tiles �ļ����ݱ�ʵ����")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotTrdTiles implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ����id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "����id", name = "id")
    private Integer id;
    /**
     * ƽ̨�⻧id�����ݱ߽磩
     */
    @ApiModelProperty(value = "ƽ̨�⻧id�����ݱ߽磩", name = "tenantId")
    private Integer tenantId;
    /**
     * ���ͣ�0-��ͨ3Dģ�� 1-����3Dģ��
     */
    @ApiModelProperty(value = "���ͣ�0-��ͨ3Dģ�� 1-����3Dģ��", name = "type")
    private String type;
    /**
     * �ʲ��ṹid
     */
    @ApiModelProperty(value = "�ʲ��ṹid", name = "structureId")
    private Integer structureId;
    /**
     * 3d-tiles �ļ�����
     */
    @ApiModelProperty(value = "3d-tiles �ļ�����", name = "name")
    private String name;
    /**
     * 3d-tiles ���ݸ�ʽ��0-3dTiles 1-����
     */
    @ApiModelProperty(value = "3d-tiles ���ݸ�ʽ��0-3dTiles 1-����", name = "abbrDataFormat")
    private String abbrDataFormat;
    /**
     * 3d-tiles ���·��
     */
    @ApiModelProperty(value = "3d-tiles ���·��", name = "abbrUrl")
    private String abbrUrl;
    /**
     * 3d-tiles ���·�����ⲿ��Դ��
     */
    @ApiModelProperty(value = "3d-tiles ���·�����ⲿ��Դ��", name = "abbrUrlOuter")
    private String abbrUrlOuter;
    /**
     * ��Դ��ʶ : 0-�ڲ���Դ 1-�ⲿ��Դ
     */
    @ApiModelProperty(value = "��Դ��ʶ : 0-�ڲ���Դ 1-�ⲿ��Դ", name = "resourceIcon")
    private String resourceIcon;
    /**
     * ���ȣ�tiles_position��
     */
    @ApiModelProperty(value = "���ȣ�tiles_position��", name = "lng")
    private String lng;
    /**
     * ά�ȣ�tiles_position��
     */
    @ApiModelProperty(value = "ά�ȣ�tiles_position��", name = "lat")
    private String lat;
    /**
     * �߶ȣ�tiles_position��
     */
    @ApiModelProperty(value = "�߶ȣ�tiles_position��", name = "height")
    private String height;
    /**
     * ����tiles_position��
     */
    @ApiModelProperty(value = "����tiles_position��", name = "heading")
    private String heading;
    /**
     * �������ʲ��ṹ��ϵ Json
     */
    @ApiModelProperty(value = "�������ʲ��ṹ��ϵ Json", name = "buildStructure")
    private String buildStructure;
    /**
     * ״̬��0-���� 1-����
     */
    @ApiModelProperty(value = "״̬��0-���� 1-����", name = "status")
    private String status;
    /**
     * ����ʱ��
     */
    @ApiModelProperty(value = "����ʱ��", name = "createTime")
    private LocalDateTime createTime;
    /**
     * �޸�ʱ��
     */
    @ApiModelProperty(value = "�޸�ʱ��", name = "updateTime")
    private LocalDateTime updateTime;
    /**
     * �߼�ɾ��0-���� 1-ɾ��
     */
    @TableLogic
    @ApiModelProperty(value = "�߼�ɾ��0-���� 1-ɾ��", name = "delFlag")
    private String delFlag;

}
