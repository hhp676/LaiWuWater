/*
 * File Name:WaPlanConditionTable.java
 * Package Name:com.hongguaninfo.hgdf.bud.entity.wa
 * Date:2018年11月26日 下午9:43:51
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 */
package com.hongguaninfo.hgdf.wa.entity.waCompanyInfo;

import com.hongguaninfo.hgdf.adp.core.base.BaseEntity;

import java.util.Date;

/**
 * : wa_plan_condition_table. <br />
 * entity 层 <br />
 * Date: 2018年11月26日 下午9:43:51 <br />
 *
 * @author  hhp
 * @since V1.0.0
 */
 
public class WaPlanConditionTable extends BaseEntity {

    /**
     * serialVersionUID.
     * @since V1.0.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * PLAN_CONDTION_ID_ : 。
     */
    private Integer planCondtionId;
    /**
     * COMPANY_CODE_ : 节水代码。
     */
    private String companyCode;
    /**
     * COMPANY_NAME_ : 单位名称。
     */
    private String companyName;
    /**
     * COMPANY_ID_ : 。
     */
    private String companyId;
    /**
     * RESIDENT_LIVE_PLAN_AMOUNT_ : 居民生活用水计划数量。
     */
    private String residentLivePlanAmount;
    /**
     * RESIDENT_ACT_AMOUNT_ : 居民生活实际用水量。
     */
    private String residentActAmount;
    /**
     * NO_RESIDENT_LIVE_PLAN_AMOUNT_ : 非居民用水计划数量。
     */
    private String noResidentLivePlanAmount;
    /**
     * NO_RESIDENT_ACT_AMOUNT_ : 非居民用水实际用水量。
     */
    private String noResidentActAmount;
    /**
     * EDUCATION_PLAN_AMOUNT_ : 教育用水计划数量。
     */
    private String educationPlanAmount;
    /**
     * EDUCATION_ACT_AMOUNT_ : 教育用水实际用水量。
     */
    private String educationActAmount;
    /**
     * SPECIAL_PLAN_AMOUNT_ : 特种用水计划数量。
     */
    private String specialPlanAmount;
    /**
     * SPECIAL_ACT_AMOUNT_ : 特种用水实际用水量。
     */
    private String specialActAmount;
    /**
     * PLAN_WATER_TOTAL_ : 用水计划总计。
     */
    private String planWaterTotal;
    /**
     * ACT_WATER_TOTAL_ : 实际用水量总计。
     */
    private String actWaterTotal;
    /**
     * SAVE_WATER_AMOUNT_ : 节水量。
     */
    private String saveWaterAmount;
    /**
     * IS_DELETE_ : 。
     */
    private Integer isDelete;
    /**
     * CRT_TIME_ : 。
     */
    private Date crtTime;
    /**
     * UPD_TIME_ : 。
     */
    private Date updTime;

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

    public Integer getPlanCondtionId() {
        return planCondtionId;
    }

    public void setPlanCondtionId(Integer planCondtionId) {
        this.planCondtionId = planCondtionId;
    }

        
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

        
    public String getResidentLivePlanAmount() {
        return residentLivePlanAmount;
    }

    public void setResidentLivePlanAmount(String residentLivePlanAmount) {
        this.residentLivePlanAmount = residentLivePlanAmount;
    }

        
    public String getResidentActAmount() {
        return residentActAmount;
    }

    public void setResidentActAmount(String residentActAmount) {
        this.residentActAmount = residentActAmount;
    }

        
    public String getNoResidentLivePlanAmount() {
        return noResidentLivePlanAmount;
    }

    public void setNoResidentLivePlanAmount(String noResidentLivePlanAmount) {
        this.noResidentLivePlanAmount = noResidentLivePlanAmount;
    }

        
    public String getNoResidentActAmount() {
        return noResidentActAmount;
    }

    public void setNoResidentActAmount(String noResidentActAmount) {
        this.noResidentActAmount = noResidentActAmount;
    }

        
    public String getEducationPlanAmount() {
        return educationPlanAmount;
    }

    public void setEducationPlanAmount(String educationPlanAmount) {
        this.educationPlanAmount = educationPlanAmount;
    }

        
    public String getEducationActAmount() {
        return educationActAmount;
    }

    public void setEducationActAmount(String educationActAmount) {
        this.educationActAmount = educationActAmount;
    }

        
    public String getSpecialPlanAmount() {
        return specialPlanAmount;
    }

    public void setSpecialPlanAmount(String specialPlanAmount) {
        this.specialPlanAmount = specialPlanAmount;
    }

        
    public String getSpecialActAmount() {
        return specialActAmount;
    }

    public void setSpecialActAmount(String specialActAmount) {
        this.specialActAmount = specialActAmount;
    }

        
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

        
    public String getSaveWaterAmount() {
        return saveWaterAmount;
    }

    public void setSaveWaterAmount(String saveWaterAmount) {
        this.saveWaterAmount = saveWaterAmount;
    }

        
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
