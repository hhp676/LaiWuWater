/*
 * File Name:WaPlanConditionTableMapper.java
 * Package Name:com.hongguaninfo.hgdf.bud.mapper.wa
 * Date:2018年11月26日 下午8:52:14
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.mapper.waCompanyInfo;

import com.hongguaninfo.hgdf.adp.core.base.BaseSqlMapper;
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaPlanConditionTable;

import java.util.List;

/**
 * : wa_plan_condition_table。 <br />
 * mapper 层 <br />
 * Date: 2018年11月26日 下午8:52:14 <br />
 *
 * @author  hhp
 * @since V1.0.0
 */
public interface WaPlanConditionTableMapper extends BaseSqlMapper {

    List<WaPlanConditionTable> getDataByCompanyId(int companyId);
}
