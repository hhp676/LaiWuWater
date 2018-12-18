/*
 * File Name:WaMonthWaterData.java
 * Package Name:com.hongguaninfo.hgdf.bud.entity.wa
 * Date:2018年11月30日 上午9:01:16
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 */
package com.hongguaninfo.hgdf.wa.entity;

import com.hongguaninfo.hgdf.adp.core.base.BaseEntity;

import java.util.Date;

/**
 * : wa_month_water_data. <br />
 * entity 层 <br />
 * Date: 2018年11月30日 上午9:01:16 <br />
 *
 * @author  hhp
 * @since V1.0.0
 */
 
public class WaMonthWaterData extends BaseEntity {

    /**
     * serialVersionUID.
     * @since V1.0.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * MONTH_WATER_ID_ : 。
     */
    private Integer monthWaterId;
    /**
     * COMPANY_ID_ : 单位id。
     */
    private String companyId;

    /**
     * 节水代码
     */
    private String companyCode;

    /**
     * 单位名称
     */
    private String companyName;
    /**
     * 查询年份
     */
    private String waYear;

    /**
     * 查询月份
     */
    private String waMonth;
    /**
     * MONTH_DATE_ : 月份时间。
     */
    private String monthDate;
    /**
     * PLAN_RESIDENT_WATER_ : 计划居民供水。
     */
    private String planResidentWater;
    /**
     * PLAN_NO_RESIDENT_WATER_ : 计划非居民供水。
     */
    private String planNoResidentWater;
    /**
     * PLAN_EDUCATION_WATER_ : 计划教育用水。
     */
    private String planEducationWater;
    /**
     * PLAN_SPECIAL_TRADE_WATER_ : 计划特殊行业用水。
     */
    private String planSpecialTradeWater;
    /**
     * ACT_RESIDENT_WATER_ : 实际居民用水。
     */
    private String actResidentWater;
    /**
     * ACT_NO_RESIDENT_WATER_ : 实际非居民用水。
     */
    private String actNoResidentWater;
    /**
     * ACT_EDUCATION_WATER_ : 实际教育用水。
     */
    private String actEducationWater;
    /**
     * ACT_SPECIAL_TRADE_WATER_ : 实际特殊行业用水。
     */
    private String actSpecialTradeWater;
    /**
     * BEYOND_RESIDENT_WATER_ : 居民用水超出量。
     */
    private String beyondResidentWater;
    /**
     * BEYOND_NO_RESIDENT_WATER_ : 非居民用水超出量。
     */
    private String beyondNoResidentWater;
    /**
     * BEYOND_EDUCATION_WATER_ : 教育用水超出量。
     */
    private String beyondEducationWater;
    /**
     * BEYOND_SPECIAL_TRADE_WATER_ : 特殊行业用水超出量。
     */
    private String beyondSpecialTradeWater;
    /**
     * FEE_RESIDENT_WATER_ : 居民用水收费标准。
     */
    private String feeResidentWater;
    /**
     * FEE_NO_RESIDENT_WATER_ : 非居民用水收费。
     */
    private String feeNoResidentWater;
    /**
     * FEE_EDUCATION_WATER_ : 教育用水收费。
     */
    private String feeEducationWater;
    /**
     * FEE_SPECIAL_TRADE_WATER_ : 特殊行业用水收费。
     */
    private String feeSpecialTradeWater;
    /**
     * IS_OVER_RESIDENT_WATER_ : 居民用水是否超标。
     */
    private String isOverResidentWater;
    /**
     * IS_OVER_NO_RESIDENT_WATER_ : 非居民用水是否超标。
     */
    private String isOverNoResidentWater;
    /**
     * IS_OVER_EDUCATION_WATER_ : 教育用水是否超标。
     */
    private String isOverEducationWater;
    /**
     * IS_OVER_SPECIAL_TRADE_WATER_ : 特殊行业用水是否超标。
     */
    private String isOverSpecialTradeWater;
    /**
     * IS_DELTE_ : 。
     */
    private Integer isDelte;

    /**
     * 计划用水删除
     */
    private Integer isDeletePlan;
    /**
     * 实际用水删除
     */
    private Integer isDeleteAct;
    /**
     * CRT_TIME_ : 。
     */
    private Date crtTime;
    /**
     * UPD_TIME_ : 数据最后修改时间。
     */
    private Date updTime;

    /**
     * 是否是重点用户
     */
    private String isImport;

    /**
     * 展示指标名称
     */
    private String indexName;

    /**
     * 展示指标计划数值
     */
    private String indexPlanValue;
    /**
     * 展示指标实际数值
     */
    private String indexActValue;
    /**
     * 展示指标是否超标
     */
    private String indexOverRoof;
    /**
     * 展示指标收费标准
     */
    private String indexFee;
    /**
     * 展示指标超出数量
     */
    private String indexBeyondAmount;

    /**
     * 计划用水合计
     */
    private String planWaterTotal;

    /**
     * 实际用水合计
     */
    private String actWaterTotal;

    public String getPlanWaterTotal() {
        return planWaterTotal;
    }

    public void setPlanWaterTotal(String planWaterTotal) {
        this.planWaterTotal = planWaterTotal;
    }

    public String getActWaterTotal() {
        return actWaterTotal;
    }

    public void setActWaterTotal(String actWaterTotal) {
        this.actWaterTotal = actWaterTotal;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getIndexPlanValue() {
        return indexPlanValue;
    }

    public void setIndexPlanValue(String indexPlanValue) {
        this.indexPlanValue = indexPlanValue;
    }

    public String getIndexActValue() {
        return indexActValue;
    }

    public void setIndexActValue(String indexActValue) {
        this.indexActValue = indexActValue;
    }

    public String getIndexOverRoof() {
        return indexOverRoof;
    }

    public void setIndexOverRoof(String indexOverRoof) {
        this.indexOverRoof = indexOverRoof;
    }

    public String getIndexFee() {
        return indexFee;
    }

    public void setIndexFee(String indexFee) {
        this.indexFee = indexFee;
    }

    public String getIndexBeyondAmount() {
        return indexBeyondAmount;
    }

    public void setIndexBeyondAmount(String indexBeyondAmount) {
        this.indexBeyondAmount = indexBeyondAmount;
    }

    public Integer getIsDeletePlan() {
        return isDeletePlan;
    }

    public void setIsDeletePlan(Integer isDeletePlan) {
        this.isDeletePlan = isDeletePlan;
    }

    public Integer getIsDeleteAct() {
        return isDeleteAct;
    }

    public void setIsDeleteAct(Integer isDeleteAct) {
        this.isDeleteAct = isDeleteAct;
    }

    public String getIsImport() {
        return isImport;
    }

    public void setIsImport(String isImport) {
        this.isImport = isImport;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getMonthWaterId() {
        return monthWaterId;
    }

    public void setMonthWaterId(Integer monthWaterId) {
        this.monthWaterId = monthWaterId;
    }

    public String getWaYear() {
        return waYear;
    }

    public void setWaYear(String waYear) {
        this.waYear = waYear;
    }

    public String getWaMonth() {
        return waMonth;
    }

    public void setWaMonth(String waMonth) {
        this.waMonth = waMonth;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

        
    public String getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate;
    }

        
    public String getPlanResidentWater() {
        return planResidentWater;
    }

    public void setPlanResidentWater(String planResidentWater) {
        this.planResidentWater = planResidentWater;
    }

        
    public String getPlanNoResidentWater() {
        return planNoResidentWater;
    }

    public void setPlanNoResidentWater(String planNoResidentWater) {
        this.planNoResidentWater = planNoResidentWater;
    }

        
    public String getPlanEducationWater() {
        return planEducationWater;
    }

    public void setPlanEducationWater(String planEducationWater) {
        this.planEducationWater = planEducationWater;
    }

        
    public String getPlanSpecialTradeWater() {
        return planSpecialTradeWater;
    }

    public void setPlanSpecialTradeWater(String planSpecialTradeWater) {
        this.planSpecialTradeWater = planSpecialTradeWater;
    }

        
    public String getActResidentWater() {
        return actResidentWater;
    }

    public void setActResidentWater(String actResidentWater) {
        this.actResidentWater = actResidentWater;
    }

        
    public String getActNoResidentWater() {
        return actNoResidentWater;
    }

    public void setActNoResidentWater(String actNoResidentWater) {
        this.actNoResidentWater = actNoResidentWater;
    }

        
    public String getActEducationWater() {
        return actEducationWater;
    }

    public void setActEducationWater(String actEducationWater) {
        this.actEducationWater = actEducationWater;
    }

        
    public String getActSpecialTradeWater() {
        return actSpecialTradeWater;
    }

    public void setActSpecialTradeWater(String actSpecialTradeWater) {
        this.actSpecialTradeWater = actSpecialTradeWater;
    }

        
    public String getBeyondResidentWater() {
        return beyondResidentWater;
    }

    public void setBeyondResidentWater(String beyondResidentWater) {
        this.beyondResidentWater = beyondResidentWater;
    }

        
    public String getBeyondNoResidentWater() {
        return beyondNoResidentWater;
    }

    public void setBeyondNoResidentWater(String beyondNoResidentWater) {
        this.beyondNoResidentWater = beyondNoResidentWater;
    }

        
    public String getBeyondEducationWater() {
        return beyondEducationWater;
    }

    public void setBeyondEducationWater(String beyondEducationWater) {
        this.beyondEducationWater = beyondEducationWater;
    }

        
    public String getBeyondSpecialTradeWater() {
        return beyondSpecialTradeWater;
    }

    public void setBeyondSpecialTradeWater(String beyondSpecialTradeWater) {
        this.beyondSpecialTradeWater = beyondSpecialTradeWater;
    }

        
    public String getFeeResidentWater() {
        return feeResidentWater;
    }

    public void setFeeResidentWater(String feeResidentWater) {
        this.feeResidentWater = feeResidentWater;
    }

        
    public String getFeeNoResidentWater() {
        return feeNoResidentWater;
    }

    public void setFeeNoResidentWater(String feeNoResidentWater) {
        this.feeNoResidentWater = feeNoResidentWater;
    }

        
    public String getFeeEducationWater() {
        return feeEducationWater;
    }

    public void setFeeEducationWater(String feeEducationWater) {
        this.feeEducationWater = feeEducationWater;
    }

        
    public String getFeeSpecialTradeWater() {
        return feeSpecialTradeWater;
    }

    public void setFeeSpecialTradeWater(String feeSpecialTradeWater) {
        this.feeSpecialTradeWater = feeSpecialTradeWater;
    }

        
    public String getIsOverResidentWater() {
        return isOverResidentWater;
    }

    public void setIsOverResidentWater(String isOverResidentWater) {
        this.isOverResidentWater = isOverResidentWater;
    }

        
    public String getIsOverNoResidentWater() {
        return isOverNoResidentWater;
    }

    public void setIsOverNoResidentWater(String isOverNoResidentWater) {
        this.isOverNoResidentWater = isOverNoResidentWater;
    }

        
    public String getIsOverEducationWater() {
        return isOverEducationWater;
    }

    public void setIsOverEducationWater(String isOverEducationWater) {
        this.isOverEducationWater = isOverEducationWater;
    }

        
    public String getIsOverSpecialTradeWater() {
        return isOverSpecialTradeWater;
    }

    public void setIsOverSpecialTradeWater(String isOverSpecialTradeWater) {
        this.isOverSpecialTradeWater = isOverSpecialTradeWater;
    }

        
    public Integer getIsDelte() {
        return isDelte;
    }

    public void setIsDelte(Integer isDelte) {
        this.isDelte = isDelte;
    }

        
    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

        
    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    

}
