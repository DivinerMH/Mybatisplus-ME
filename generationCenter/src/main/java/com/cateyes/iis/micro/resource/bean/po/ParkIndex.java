package com.cateyes.iis.micro.resource.bean.po;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (IisParkIndex)Po
 *
 * @author CatEyes
 * @since 2023-10-17 11:11:49
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("iis_park_index")
public class ParkIndex implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "park_name")
    private String parkName;

    @TableField(value = "report_time")
    private Date reportTime;

    @TableField(value = "report_organize")
    private Integer reportOrganize;

    @TableField(value = "report_by")
    private Integer reportBy;

    @TableField(value = "scale_output")
    private Double scaleOutput;

    @TableField(value = "scale_output_arm")
    private Double scaleOutputArm;

    @TableField(value = "scale_output_accelerate")
    private Double scaleOutputAccelerate;

    @TableField(value = "scale_increment")
    private Double scaleIncrement;

    @TableField(value = "scale_increment_accelerate")
    private Double scaleIncrementAccelerate;

    @TableField(value = "full_aperture_tax")
    private Double fullApertureTax;

    @TableField(value = "full_aperture_tax_accelerate")
    private Double fullApertureTaxAccelerate;

    @TableField(value = "has_accumulated_output")
    private Double hasAccumulatedOutput;

    @TableField(value = "annual_output_arm")
    private Double annualOutputArm;

    @TableField(value = "industrial_investment")
    private Double industrialInvestment;

    @TableField(value = "industrial_investment_accelerate")
    private Double industrialInvestmentAccelerate;

    @TableField(value = "fixed_investment")
    private Double fixedInvestment;

    @TableField(value = "fixed_investment_accelerate")
    private Double fixedInvestmentAccelerate;

    @TableField(value = "industrial_appreve_area")
    private Double industrialAppreveArea;

    @TableField(value = "accumulated_land_use_index_area")
    private Double accumulatedLandUseIndexArea;

    @TableField(value = "urban_development_boundary_area")
    private Double urbanDevelopmentBoundaryArea;

    @TableField(value = "has_developed_area")
    private Double hasDevelopedArea;

    @TableField(value = "supply_industrial_land_area")
    private Double supplyIndustrialLandArea;

    @TableField(value = "supply_land_area")
    private Double supplyLandArea;

    @TableField(value = "new_levy_land_area")
    private Double newLevyLandArea;

    @TableField(value = "has_recovered_levied_land_area")
    private Double hasRecoveredLeviedLandArea;

    @TableField(value = "cultivated_land_area")
    private Double cultivatedLandArea;

    @TableField(value = "recovered_levied_land_area")
    private Double recoveredLeviedLandArea;

    @TableField(value = "accumulated_industrial_land_ratio")
    private Double accumulatedIndustrialLandRatio;

    @TableField(value = "new_standard_plant_area")
    private Double newStandardPlantArea;

    @TableField(value = "special_debt_obtain_quota")
    private Double specialDebtObtainQuota;

    @TableField(value = "infrastructure_project_building_total")
    private Double infrastructureProjectBuildingTotal;

    @TableField(value = "supporting_facilities_has_investment_total")
    private Double supportingFacilitiesHasInvestmentTotal;

    @TableField(value = "infrastructure_investment_total")
    private Double infrastructureInvestmentTotal;

    @TableField(value = "special_debt_obtain_quota_ratio")
    private Double specialDebtObtainQuotaRatio;

    @TableField(value = "scale_total")
    private Double scaleTotal;

    @TableField(value = "scale_add_total")
    private Double scaleAddTotal;

    @TableField(value = "investment_total")
    private Double investmentTotal;

    @TableField(value = "has_investment_total")
    private Double hasInvestmentTotal;

    @TableField(value = "project_industrial_building_total")
    private Double projectIndustrialBuildingTotal;

    @TableField(value = "project_building_has_investment_total")
    private Double projectBuildingHasInvestmentTotal;

    @TableField(value = "project_sign_total")
    private Double projectSignTotal;

    @TableField(value = "project_sign_approval_investment")
    private Double projectSignApprovalInvestment;

    @TableField(value = "project_start_up_total")
    private Double projectStartUpTotal;

    @TableField(value = "project_start_up_approval_investment")
    private Double projectStartUpApprovalInvestment;

    @TableField(value = "project_operation_total")
    private Double projectOperationTotal;

    @TableField(value = "project_operation_investment")
    private Double projectOperationInvestment;

    @TableField(value = "is_enable")
    private Integer isEnable;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "create_at", fill = FieldFill.INSERT)
    private Date createAt;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "update_at", fill = FieldFill.UPDATE)
    private Date updateAt;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

}
