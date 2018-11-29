/*
 * File Name:WaSpecialtradeConditionTableDao.java
 * Package Name:com.hongguaninfo.hgdf.bud.dao.wa
 * Date:2018年11月26日 下午8:52:14
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.dao.waCompanyInfo;

import com.hongguaninfo.hgdf.adp.core.base.BaseDao;
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaSpecialtradeConditionTable;
import com.hongguaninfo.hgdf.wa.mapper.waCompanyInfo.WaSpecialtradeConditionTableMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * : wa_specialtrade_condition_table. <br />
 * dao 层 <br />
 * Date: 2018年11月26日 下午8:52:14 <br />
 * @author hhp
 * @since V1.0.0
 */
@SuppressWarnings("unchecked")
@Repository("waSpecialtradeConditionTableDao")
public class WaSpecialtradeConditionTableDao extends BaseDao<WaSpecialtradeConditionTable, WaSpecialtradeConditionTableMapper, Integer> implements
		WaSpecialtradeConditionTableMapper{

    @Override
    public String getMapperNamesapce() {
        return WaSpecialtradeConditionTableMapper.class.getName().toString();
    }


    @Override
    public List<WaSpecialtradeConditionTable> getDataByCompanyId(int companyId) {
        return getMapperByType(WaSpecialtradeConditionTableMapper.class).getDataByCompanyId(companyId);
    }
}
