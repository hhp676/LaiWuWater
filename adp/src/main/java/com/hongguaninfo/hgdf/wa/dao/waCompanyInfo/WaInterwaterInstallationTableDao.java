/*
 * File Name:WaInterwaterInstallationTableDao.java
 * Package Name:com.hongguaninfo.hgdf.bud.dao.wa
 * Date:2018年11月26日 下午8:52:14
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.dao.waCompanyInfo;

import com.hongguaninfo.hgdf.adp.core.base.BaseDao;
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaInterwaterInstallationTable;
import com.hongguaninfo.hgdf.wa.mapper.waCompanyInfo.WaInterwaterInstallationTableMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * : wa_interwater_installation_table. <br />
 * dao 层 <br />
 * Date: 2018年11月26日 下午8:52:14 <br />
 * @author hhp
 * @since V1.0.0
 */
@SuppressWarnings("unchecked")
@Repository("waInterwaterInstallationTableDao")
public class WaInterwaterInstallationTableDao extends BaseDao<WaInterwaterInstallationTable, WaInterwaterInstallationTableMapper, Integer> implements
		WaInterwaterInstallationTableMapper{

    @Override
    public String getMapperNamesapce() {
        return WaInterwaterInstallationTableMapper.class.getName().toString();
    }


    @Override
    public List<WaInterwaterInstallationTable> getDataByCompanyId(int companyId) {
        return getMapperByType(WaInterwaterInstallationTableMapper.class).getDataByCompanyId(companyId);
    }
}