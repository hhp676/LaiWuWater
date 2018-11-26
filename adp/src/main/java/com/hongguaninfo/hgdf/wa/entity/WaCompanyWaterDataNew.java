/*
 * File Name:WaCompanyWaterDataNew.java
 * Package Name:com.hongguaninfo.hgdf.bud.entity.wa
 * Date:2018年11月24日 下午11:56:23
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 */
package com.hongguaninfo.hgdf.wa.entity;

import com.hongguaninfo.hgdf.adp.core.base.BaseEntity;

import java.util.Date;

/**
 * : wa_company_water_data_new. <br />
 * entity 层 <br />
 * Date: 2018年11月24日 下午11:56:23 <br />
 *
 * @author  hhp
 * @since V1.0.0
 */
 
public class WaCompanyWaterDataNew extends BaseEntity {

    /**
     * serialVersionUID.
     * @since V1.0.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * COMPANY_WATER_ID_ : 。
     */
    private Integer companyWaterId;
    /**
     * PRODUCT_NAME_ : 主产品名称。
     */
    private String productName;
    /**
     * NEW_WATER_COUNT_ : 单位产品新水量m3/单位产品。
     */
    private String newWaterCount;
    /**
     * GONGYE_WATER_COUNT_ : 工业新水量。
     */
    private String gongyeWaterCount;
    /**
     * TOTAL_COUNT_ : 全年产量。
     */
    private String totalCount;
    /**
     * WATER_STANDARD_ : 行业用水标准。
     */
    private String waterStandard;
    /**
     * EMPLOYEE_ : 从业人员。
     */
    private String employee;
    /**
     * GONGYI_WATER_COUNT_ : 工艺新水量。
     */
    private String gongyiWaterCount;
    /**
     * BOILER_WATER_ : 锅炉新水量。
     */
    private String boilerWater;
    /**
     * FACTORY_LIVE_WATER_ : 厂内生活水 。
     */
    private String factoryLiveWater;
    /**
     * REUSE_TOTAL_AMOUNT_ : 重复利用水量。
     */
    private String reuseTotalAmount;
    /**
     * AVAILABILITY_ : 利用率。
     */
    private String availability;
    /**
     * INTER_COLD_WATER_LOOP_AMOUNT_ : 间冷水循环量。
     */
    private String interColdWaterLoopAmount;
    /**
     * CIRCUL_RATE_ : 循环率。
     */
    private String circulRate;
    /**
     * FRESH_WATER_BACK_AMOUNT_ : 回水量 。
     */
    private String freshWaterBackAmount;
    /**
     * STEAM_CONDEN_BACK_AMOUNT_ : 蒸汽冷凝回水量 。
     */
    private String steamCondenBackAmount;
    /**
     * RECOVER_RATE_ : 回用率。
     */
    private String recoverRate;
    /**
     * SAVE_AMOUNT_ : 节水量。
     */
    private String saveAmount;
    /**
     * INSTALL_MONEY_ : 节水设施投资。
     */
    private String installMoney;
    /**
     * COMPANY_NAME_ : 填报单位。
     */
    private String companyName;
    /**
     * WATER_PLAN_NO_ : 用水计划卡号。
     */
    private String waterPlanNo;
    /**
     * WRITE_PERSON_ : 填报人。
     */
    private String writePerson;
    /**
     * WRITE_TIME_ : 填报时间。
     */
    private String writeTime;
    /**
     * IS_DELETE_ : 。
     */
    private Integer isDelete;
    /**
     * CRT_TIME_ : 。
     */
    private Date crtTime;
    /**
     * UPD_TIME_ : 数据最后修改时间。
     */
    private Date updTime;
 

    public Integer getCompanyWaterId() {
        return companyWaterId;
    }

    public void setCompanyWaterId(Integer companyWaterId) {
        this.companyWaterId = companyWaterId;
    }

        
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

        
    public String getNewWaterCount() {
        return newWaterCount;
    }

    public void setNewWaterCount(String newWaterCount) {
        this.newWaterCount = newWaterCount;
    }

        
    public String getGongyeWaterCount() {
        return gongyeWaterCount;
    }

    public void setGongyeWaterCount(String gongyeWaterCount) {
        this.gongyeWaterCount = gongyeWaterCount;
    }

        
    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

        
    public String getWaterStandard() {
        return waterStandard;
    }

    public void setWaterStandard(String waterStandard) {
        this.waterStandard = waterStandard;
    }

        
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

        
    public String getGongyiWaterCount() {
        return gongyiWaterCount;
    }

    public void setGongyiWaterCount(String gongyiWaterCount) {
        this.gongyiWaterCount = gongyiWaterCount;
    }

        
    public String getBoilerWater() {
        return boilerWater;
    }

    public void setBoilerWater(String boilerWater) {
        this.boilerWater = boilerWater;
    }

        
    public String getFactoryLiveWater() {
        return factoryLiveWater;
    }

    public void setFactoryLiveWater(String factoryLiveWater) {
        this.factoryLiveWater = factoryLiveWater;
    }

        
    public String getReuseTotalAmount() {
        return reuseTotalAmount;
    }

    public void setReuseTotalAmount(String reuseTotalAmount) {
        this.reuseTotalAmount = reuseTotalAmount;
    }

        
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

        
    public String getInterColdWaterLoopAmount() {
        return interColdWaterLoopAmount;
    }

    public void setInterColdWaterLoopAmount(String interColdWaterLoopAmount) {
        this.interColdWaterLoopAmount = interColdWaterLoopAmount;
    }

        
    public String getCirculRate() {
        return circulRate;
    }

    public void setCirculRate(String circulRate) {
        this.circulRate = circulRate;
    }

        
    public String getFreshWaterBackAmount() {
        return freshWaterBackAmount;
    }

    public void setFreshWaterBackAmount(String freshWaterBackAmount) {
        this.freshWaterBackAmount = freshWaterBackAmount;
    }

        
    public String getSteamCondenBackAmount() {
        return steamCondenBackAmount;
    }

    public void setSteamCondenBackAmount(String steamCondenBackAmount) {
        this.steamCondenBackAmount = steamCondenBackAmount;
    }

        
    public String getRecoverRate() {
        return recoverRate;
    }

    public void setRecoverRate(String recoverRate) {
        this.recoverRate = recoverRate;
    }

        
    public String getSaveAmount() {
        return saveAmount;
    }

    public void setSaveAmount(String saveAmount) {
        this.saveAmount = saveAmount;
    }

        
    public String getInstallMoney() {
        return installMoney;
    }

    public void setInstallMoney(String installMoney) {
        this.installMoney = installMoney;
    }

        
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

        
    public String getWaterPlanNo() {
        return waterPlanNo;
    }

    public void setWaterPlanNo(String waterPlanNo) {
        this.waterPlanNo = waterPlanNo;
    }

        
    public String getWritePerson() {
        return writePerson;
    }

    public void setWritePerson(String writePerson) {
        this.writePerson = writePerson;
    }

        
    public String getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(String writeTime) {
        this.writeTime = writeTime;
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
