/*
 * File Name:WaRainSurfaceConditionTableMapper.java
 * Package Name:com.hongguaninfo.hgdf.bud.mapper.wa
 * Date:2018年11月26日 下午8:52:13
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.mapper.waCompanyInfo;

import com.hongguaninfo.hgdf.adp.core.base.BaseSqlMapper;
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaRainSurfaceConditionTable;

import java.util.List;

/**
 * : wa_rain_surface_condition_table。 <br />
 * mapper 层 <br />
 * Date: 2018年11月26日 下午8:52:13 <br />
 *
 * @author  hhp
 * @since V1.0.0
 */
public interface WaRainSurfaceConditionTableMapper extends BaseSqlMapper {

    List<WaRainSurfaceConditionTable> getDataByCompanyId(int companyId);
}
