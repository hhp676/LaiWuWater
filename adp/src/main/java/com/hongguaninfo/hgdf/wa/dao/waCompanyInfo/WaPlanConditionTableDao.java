/*
 * File Name:WaPlanConditionTableDao.java
 * Package Name:com.hongguaninfo.hgdf.bud.dao.wa
 * Date:2018年11月26日 下午8:52:14
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.dao.waCompanyInfo;

import com.hongguaninfo.hgdf.adp.core.base.BaseDao;
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaPlanConditionTable;
import com.hongguaninfo.hgdf.wa.mapper.waCompanyInfo.WaPlanConditionTableMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * : wa_plan_condition_table. <br />
 * dao 层 <br />
 * Date: 2018年11月26日 下午8:52:14 <br />
 * @author hhp
 * @since V1.0.0
 */
@SuppressWarnings("unchecked")
@Repository("waPlanConditionTableDao")
public class WaPlanConditionTableDao extends BaseDao<WaPlanConditionTable, WaPlanConditionTableMapper, Integer> implements
		WaPlanConditionTableMapper{

    @Override
    public String getMapperNamesapce() {
        return WaPlanConditionTableMapper.class.getName().toString();
    }


    @Override
    public List<WaPlanConditionTable> getDataByCompanyId(int companyId) {
        return getMapperByType(WaPlanConditionTableMapper.class).getDataByCompanyId(companyId);
    }
}
