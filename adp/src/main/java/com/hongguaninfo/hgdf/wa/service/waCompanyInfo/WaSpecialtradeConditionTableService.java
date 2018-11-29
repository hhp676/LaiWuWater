/*
 * File Name:WaSpecialtradeConditionTableService.java
 * Package Name:com.hongguaninfo.hgdf.bud.service.wa
 * Date:2018年11月26日 下午9:43:51
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.service.waCompanyInfo;


import com.hongguaninfo.hgdf.adp.core.base.BasePage;
import com.hongguaninfo.hgdf.adp.core.exception.BizException;
import com.hongguaninfo.hgdf.adp.core.utils.generator.DbIdGenerator;
import com.hongguaninfo.hgdf.core.utils.page.Page;
import com.hongguaninfo.hgdf.wa.dao.waCompanyInfo.WaSpecialtradeConditionTableDao;
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaSpecialtradeConditionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * : wa_specialtrade_condition_table. <br />
 * service interface 层 <br />
 * Date: 2018年11月26日 下午9:43:51 <br />
 * @author  hhp
 * @since V1.0.0
 */
@Service("waSpecialtradeConditionTableService")
public class WaSpecialtradeConditionTableService {

	@Autowired
	private WaSpecialtradeConditionTableDao waSpecialtradeConditionTableDao;

	@Autowired
	private DbIdGenerator dbIdGenerator;
	
	/**
	 * REMARK
	 * 分页查询
	 * Show all content and can paging
	 * The following id to give priority to key !
	 */
	public List<WaSpecialtradeConditionTable> getWaSpecialtradeConditionTableList (BasePage<WaSpecialtradeConditionTable> basePage,
																				   WaSpecialtradeConditionTable vo, Map<String, Object> map) throws BizException {
		vo.setIsDelete(0);
        basePage.setFilters(vo);
        Page<WaSpecialtradeConditionTable> page = waSpecialtradeConditionTableDao.pageQuery(basePage);
        List<WaSpecialtradeConditionTable> list = page.getResult();
        /**for (WaSpecialtradeConditionTable bo : list) {
            bo.setIsFinalStr(sysDatadicItemBiz.getItemNameByValue("LOGIC_TAG",
                    bo.getIsFinal() + ""));
        }*/
        map.put("rows", list);
        map.put("total", page.getTotalCount());
        return list;
	}
    
	/**
	 * REMARK
	 * 新增信息
	 * Through the id inquires the out a data
	 * Date need their conversion !
	 * UserName is the current user name !
	 */
	public void addWaSpecialtradeConditionTable (WaSpecialtradeConditionTable waSpecialtradeConditionTable) throws BizException{
		 
		waSpecialtradeConditionTable.setIsDelete(0);
        waSpecialtradeConditionTable.setCrtTime(new Date());
        waSpecialtradeConditionTable.setUpdTime(new Date());
		waSpecialtradeConditionTableDao.save(waSpecialtradeConditionTable);
	}

	/**
	 * REMARK
	 * 修改
	 * update data
	 * Date need their conversion !
	 */
	public void updateWaSpecialtradeConditionTable (WaSpecialtradeConditionTable waSpecialtradeConditionTable) throws BizException{
 		waSpecialtradeConditionTable.setUpdTime(new Date());
		waSpecialtradeConditionTableDao.update(waSpecialtradeConditionTable);
	}

	/**
	 * REMARK
	 * 删除
	 * Through the id delete a data
	 */
	public void deleteWaSpecialtradeConditionTable(int id) throws BizException{
		waSpecialtradeConditionTableDao.delete(id);
	}
	
	/**
	 * REMARK
	 * 物理删除
	 * Through the id delete a data logic
	 */
	public void deleteWaSpecialtradeConditionTableLogic(int id) throws BizException{
        WaSpecialtradeConditionTable waSpecialtradeConditionTable = new WaSpecialtradeConditionTable();
        waSpecialtradeConditionTable.setUpdTime(new Date());
        waSpecialtradeConditionTable.setIsDelete(1);
        waSpecialtradeConditionTableDao.update(waSpecialtradeConditionTable);
	}	
	

	/**
	 * REMARK
	 * 查询实体信息
	 * Inquires the individual data
	 * Date need their conversion !
	 */
	public WaSpecialtradeConditionTable getWaSpecialtradeConditionTableById(int id) throws BizException{
		if (id == 0) {
            return null;
        }
        return waSpecialtradeConditionTableDao.getById(id);
	}

	public List<WaSpecialtradeConditionTable> getDataByCompanyId(int companyId) throws BizException{
		if (companyId == 0) {
			return null;
		}
		return waSpecialtradeConditionTableDao.getDataByCompanyId(companyId);
	}
}
