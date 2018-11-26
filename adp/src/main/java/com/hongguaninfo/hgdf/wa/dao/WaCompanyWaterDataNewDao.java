/*
 * File Name:WaCompanyWaterDataNewDao.java
 * Package Name:com.hongguaninfo.hgdf.bud.dao.wa
 * Date:2018年11月24日 下午11:49:34
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.dao;

import com.hongguaninfo.hgdf.adp.core.base.BaseDao;
import com.hongguaninfo.hgdf.wa.entity.WaCompanyWaterDataNew;
import com.hongguaninfo.hgdf.wa.mapper.WaCompanyWaterDataNewMapper;
import org.springframework.stereotype.Repository;



/**
 * : wa_company_water_data_new. <br />
 * dao 层 <br />
 * Date: 2018年11月24日 下午11:49:34 <br />
 * @author hhp
 * @since V1.0.0
 */
@SuppressWarnings("unchecked")
@Repository("waCompanyWaterDataNewDao")
public class WaCompanyWaterDataNewDao extends BaseDao<WaCompanyWaterDataNew, WaCompanyWaterDataNewMapper, Integer> implements
		WaCompanyWaterDataNewMapper{

    @Override
    public String getMapperNamesapce() {
        return WaCompanyWaterDataNewMapper.class.getName().toString();
    }


}
