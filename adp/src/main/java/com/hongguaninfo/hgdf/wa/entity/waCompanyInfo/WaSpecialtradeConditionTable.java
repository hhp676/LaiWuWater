/*
 * File Name:WaSpecialtradeConditionTable.java
 * Package Name:com.hongguaninfo.hgdf.bud.entity.wa
 * Date:2018年11月26日 下午9:43:51
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 */
package com.hongguaninfo.hgdf.wa.entity.waCompanyInfo;

import com.hongguaninfo.hgdf.adp.core.base.BaseEntity;

import java.util.Date;

/**
 * : wa_specialtrade_condition_table. <br />
 * entity 层 <br />
 * Date: 2018年11月26日 下午9:43:51 <br />
 *
 * @author  hhp
 * @since V1.0.0
 */
 
public class WaSpecialtradeConditionTable extends BaseEntity {

    /**
     * serialVersionUID.
     * @since V1.0.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * SPECIAL_ID_ : 。
     */
    private Integer specialId;
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
     * WATER_TYPE_ : 用水户性质。
     */
    private String waterType;
    /**
     * ADDRESS_ : 地址。
     */
    private String address;
    /**
     * TABLE_AMOUNT_ : 装表数。
     */
    private String tableAmount;
    /**
     * WATER_AMOUNT_ : 用水量。
     */
    private String waterAmount;
    /**
     * PRICE_ : 收费价格。
     */
    private String price;
    /**
     * IS_RECOVERY_ : 废水（尾水）是否处理回收。
     */
    private String isRecovery;
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

    public Integer getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Integer specialId) {
        this.specialId = specialId;
    }

        
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

        
    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

        
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

        
    public String getTableAmount() {
        return tableAmount;
    }

    public void setTableAmount(String tableAmount) {
        this.tableAmount = tableAmount;
    }

        
    public String getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(String waterAmount) {
        this.waterAmount = waterAmount;
    }

        
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

        
    public String getIsRecovery() {
        return isRecovery;
    }

    public void setIsRecovery(String isRecovery) {
        this.isRecovery = isRecovery;
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
