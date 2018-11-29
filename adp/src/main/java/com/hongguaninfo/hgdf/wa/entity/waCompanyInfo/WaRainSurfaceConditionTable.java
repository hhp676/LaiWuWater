/*
 * File Name:WaRainSurfaceConditionTable.java
 * Package Name:com.hongguaninfo.hgdf.bud.entity.wa
 * Date:2018年11月26日 下午9:43:51
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 */
package com.hongguaninfo.hgdf.wa.entity.waCompanyInfo;

import com.hongguaninfo.hgdf.adp.core.base.BaseEntity;

import java.util.Date;

/**
 * : wa_rain_surface_condition_table. <br />
 * entity 层 <br />
 * Date: 2018年11月26日 下午9:43:51 <br />
 *
 * @author  hhp
 * @since V1.0.0
 */
 
public class WaRainSurfaceConditionTable extends BaseEntity {

    /**
     * serialVersionUID.
     * @since V1.0.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * RAIN_SURFACE_ID_ : 。
     */
    private Integer rainSurfaceId;
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
     * RAIN_WATER_VOLUME_ : 雨水储水容量m3。
     */
    private String rainWaterVolume;
    /**
     * RAIN_ACT_AMOUNT_ : 雨水实际使用量（年）。
     */
    private String rainActAmount;
    /**
     * RAIN_USE_TIME_ : 雨水投入使用时间。
     */
    private String rainUseTime;
    /**
     * RAIN_PROJECT_INVEST_ : 雨水工程投资。
     */
    private String rainProjectInvest;
    /**
     * SURFACE_WATER_VOLUME_ : 地表水储水容量m3。
     */
    private String surfaceWaterVolume;
    /**
     * SURFACE_ACT_AMOUNT_ : 地表水实际使用量（年）。
     */
    private String surfaceActAmount;
    /**
     * SURFACE_USE_TIME_ : 地表水投入使用时间。
     */
    private String surfaceUseTime;
    /**
     * SURFACE_PROJECT_INVEST_ : 地表水工程投资。
     */
    private String surfaceProjectInvest;
    /**
     * PURPOSE_ : 用途。
     */
    private String purpose;
    /**
     * FLAG_ : 备注。
     */
    private String flag;
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

    public Integer getRainSurfaceId() {
        return rainSurfaceId;
    }

    public void setRainSurfaceId(Integer rainSurfaceId) {
        this.rainSurfaceId = rainSurfaceId;
    }

        
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

        
    public String getRainWaterVolume() {
        return rainWaterVolume;
    }

    public void setRainWaterVolume(String rainWaterVolume) {
        this.rainWaterVolume = rainWaterVolume;
    }

        
    public String getRainActAmount() {
        return rainActAmount;
    }

    public void setRainActAmount(String rainActAmount) {
        this.rainActAmount = rainActAmount;
    }

        
    public String getRainUseTime() {
        return rainUseTime;
    }

    public void setRainUseTime(String rainUseTime) {
        this.rainUseTime = rainUseTime;
    }

        
    public String getRainProjectInvest() {
        return rainProjectInvest;
    }

    public void setRainProjectInvest(String rainProjectInvest) {
        this.rainProjectInvest = rainProjectInvest;
    }

        
    public String getSurfaceWaterVolume() {
        return surfaceWaterVolume;
    }

    public void setSurfaceWaterVolume(String surfaceWaterVolume) {
        this.surfaceWaterVolume = surfaceWaterVolume;
    }

        
    public String getSurfaceActAmount() {
        return surfaceActAmount;
    }

    public void setSurfaceActAmount(String surfaceActAmount) {
        this.surfaceActAmount = surfaceActAmount;
    }

        
    public String getSurfaceUseTime() {
        return surfaceUseTime;
    }

    public void setSurfaceUseTime(String surfaceUseTime) {
        this.surfaceUseTime = surfaceUseTime;
    }

        
    public String getSurfaceProjectInvest() {
        return surfaceProjectInvest;
    }

    public void setSurfaceProjectInvest(String surfaceProjectInvest) {
        this.surfaceProjectInvest = surfaceProjectInvest;
    }

        
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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
