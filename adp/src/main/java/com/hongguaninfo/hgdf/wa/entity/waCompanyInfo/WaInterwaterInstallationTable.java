/*
 * File Name:WaInterwaterInstallationTable.java
 * Package Name:com.hongguaninfo.hgdf.bud.entity.wa
 * Date:2018年11月26日 下午9:43:51
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 */
package com.hongguaninfo.hgdf.wa.entity.waCompanyInfo;

import com.hongguaninfo.hgdf.adp.core.base.BaseEntity;

import java.util.Date;

/**
 * : wa_interwater_installation_table. <br />
 * entity 层 <br />
 * Date: 2018年11月26日 下午9:43:51 <br />
 *
 * @author  hhp
 * @since V1.0.0
 */
 
public class WaInterwaterInstallationTable extends BaseEntity {

    /**
     * serialVersionUID.
     * @since V1.0.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * INTERWATER_ID_ : 。
     */
    private Integer interwaterId;
    /**
     * COMPANY_ID_ : companyid。
     */
    private String companyId;
    /**
     * COMPANY_CODE_ : 节水代码。
     */
    private String companyCode;
    /**
     * COMPANY_NAME_ : 单位名称。
     */
    private String companyName;

    /**
     * PRODUCT_NAME_ : 项目名称。
     */
    private String productName;
    /**
     * HANDLE_TECH_ : 处理工艺。
     */
    private String handleTech;
    /**
     * RECOVER_WATER_COUNT_ : 设计回用量水。
     */
    private String recoverWaterCount;
    /**
     * ACT_WATER_COUNT_ : 实际回用水量（m3/日）。
     */
    private String actWaterCount;
    /**
     * RUNTIME_ : 投入运行时间。
     */
    private String runtime;
    /**
     * INVEST_MONEY_ : 工程投资。
     */
    private String investMoney;
    /**
     * RUN_COST_ : 运行成本。
     */
    private String runCost;
    /**
     * INTERWATER_PRICE_ : 中水价格。
     */
    private String interwaterPrice;
    /**
     * INTERWATER_PIPING_ : 中水管网建设情况。
     */
    private String interwaterPiping;
    /**
     * USE_ : 用途。
     */
    private String use;
    /**
     * FLAG_ : 备注。
     */
    private String flag;
    /**
     * IS_DELETE_ : 。
     */
    private Integer isDelete;
    /**
     * CRT_TME_ : 。
     */
    private Date crtTme;
    /**
     * UPD_TIME_ : 。
     */
    private Date updTime;
    /**
     * WRITE_PERSON_ : 填报人。
     */
    private String writePerson;
    /**
     * WRITE_TIME_ : 填报时间。
     */
    private String writeTime;

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
        
    public Integer getInterwaterId() {
        return interwaterId;
    }

    public void setInterwaterId(Integer interwaterId) {
        this.interwaterId = interwaterId;
    }

        
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

        
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

        
    public String getHandleTech() {
        return handleTech;
    }

    public void setHandleTech(String handleTech) {
        this.handleTech = handleTech;
    }

        
    public String getRecoverWaterCount() {
        return recoverWaterCount;
    }

    public void setRecoverWaterCount(String recoverWaterCount) {
        this.recoverWaterCount = recoverWaterCount;
    }

        
    public String getActWaterCount() {
        return actWaterCount;
    }

    public void setActWaterCount(String actWaterCount) {
        this.actWaterCount = actWaterCount;
    }

        
    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

        
    public String getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(String investMoney) {
        this.investMoney = investMoney;
    }

        
    public String getRunCost() {
        return runCost;
    }

    public void setRunCost(String runCost) {
        this.runCost = runCost;
    }

        
    public String getInterwaterPrice() {
        return interwaterPrice;
    }

    public void setInterwaterPrice(String interwaterPrice) {
        this.interwaterPrice = interwaterPrice;
    }

        
    public String getInterwaterPiping() {
        return interwaterPiping;
    }

    public void setInterwaterPiping(String interwaterPiping) {
        this.interwaterPiping = interwaterPiping;
    }

        
    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

        
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

        
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

        
    public Date getCrtTme() {
        return crtTme;
    }

    public void setCrtTme(Date crtTme) {
        this.crtTme = crtTme;
    }

        
    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    

}
