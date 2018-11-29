/*
 * File Name:WaRainSurfaceConditionTableDao.java
 * Package Name:com.hongguaninfo.hgdf.bud.dao.wa
 * Date:2018年11月26日 下午8:52:13
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.dao.waCompanyInfo;

import com.hongguaninfo.hgdf.adp.core.base.BaseDao;
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaRainSurfaceConditionTable;
import com.hongguaninfo.hgdf.wa.mapper.waCompanyInfo.WaRainSurfaceConditionTableMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * : wa_rain_surface_condition_table. <br />
 * dao 层 <br />
 * Date: 2018年11月26日 下午8:52:13 <br />
 * @author hhp
 * @since V1.0.0
 */
@SuppressWarnings("unchecked")
@Repository("waRainSurfaceConditionTableDao")
public class WaRainSurfaceConditionTableDao extends BaseDao<WaRainSurfaceConditionTable, WaRainSurfaceConditionTableMapper, Integer> implements
		WaRainSurfaceConditionTableMapper{

    @Override
    public String getMapperNamesapce() {
        return WaRainSurfaceConditionTableMapper.class.getName().toString();
    }


    @Override
    public List<WaRainSurfaceConditionTable> getDataByCompanyId(int companyId) {
        return getMapperByType(WaRainSurfaceConditionTableMapper.class).getDataByCompanyId(companyId);
    }
}
