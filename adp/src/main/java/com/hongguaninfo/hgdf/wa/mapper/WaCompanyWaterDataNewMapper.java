/*
 * File Name:WaCompanyWaterDataNewMapper.java
 * Package Name:com.hongguaninfo.hgdf.bud.mapper.wa
 * Date:2018年11月24日 下午11:49:34
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.mapper;

import com.hongguaninfo.hgdf.adp.core.base.BaseSqlMapper;
import com.hongguaninfo.hgdf.wa.entity.WaCompanyWaterDataNew;

import java.util.List;

/**
 * : wa_company_water_data_new。 <br />
 * mapper 层 <br />
 * Date: 2018年11月24日 下午11:49:34 <br />
 *
 * @author  hhp
 * @since V1.0.0
 */
public interface WaCompanyWaterDataNewMapper extends BaseSqlMapper {

    List<WaCompanyWaterDataNew> getDataByCompanyId(int companyId);
}
