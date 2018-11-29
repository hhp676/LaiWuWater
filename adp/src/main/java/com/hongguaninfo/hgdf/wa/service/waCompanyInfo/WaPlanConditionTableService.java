/*
 * File Name:WaPlanConditionTableService.java
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
import com.hongguaninfo.hgdf.wa.dao.waCompanyInfo.WaPlanConditionTableDao;
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaPlanConditionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * : wa_plan_condition_table. <br />
 * service interface 层 <br />
 * Date: 2018年11月26日 下午9:43:51 <br />
 * @author  hhp
 * @since V1.0.0
 */
@Service("waPlanConditionTableService")
public class WaPlanConditionTableService {

	@Autowired
	private WaPlanConditionTableDao waPlanConditionTableDao;

	@Autowired
	private DbIdGenerator dbIdGenerator;
	
	/**
	 * REMARK
	 * 分页查询
	 * Show all content and can paging
	 * The following id to give priority to key !
	 */
	public List<WaPlanConditionTable> getWaPlanConditionTableList (BasePage<WaPlanConditionTable> basePage,
																   WaPlanConditionTable vo, Map<String, Object> map) throws BizException {
		vo.setIsDelete(0);
        basePage.setFilters(vo);
        Page<WaPlanConditionTable> page = waPlanConditionTableDao.pageQuery(basePage);
        List<WaPlanConditionTable> list = page.getResult();
        /**for (WaPlanConditionTable bo : list) {
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
	public void addWaPlanConditionTable (WaPlanConditionTable waPlanConditionTable) throws BizException{
		 
		waPlanConditionTable.setIsDelete(0);
        waPlanConditionTable.setCrtTime(new Date());
        waPlanConditionTable.setUpdTime(new Date());
		waPlanConditionTableDao.save(waPlanConditionTable);
	}

	/**
	 * REMARK
	 * 修改
	 * update data
	 * Date need their conversion !
	 */
	public void updateWaPlanConditionTable (WaPlanConditionTable waPlanConditionTable) throws BizException{
 		waPlanConditionTable.setUpdTime(new Date());
		waPlanConditionTableDao.update(waPlanConditionTable);
	}

	/**
	 * REMARK
	 * 删除
	 * Through the id delete a data
	 */
	public void deleteWaPlanConditionTable(int id) throws BizException{
		waPlanConditionTableDao.delete(id);
	}
	
	/**
	 * REMARK
	 * 物理删除
	 * Through the id delete a data logic
	 */
	public void deleteWaPlanConditionTableLogic(int id) throws BizException{
        WaPlanConditionTable waPlanConditionTable = new WaPlanConditionTable();
        waPlanConditionTable.setUpdTime(new Date());
        waPlanConditionTable.setIsDelete(1);
        waPlanConditionTableDao.update(waPlanConditionTable);
	}	
	

	/**
	 * REMARK
	 * 查询实体信息
	 * Inquires the individual data
	 * Date need their conversion !
	 */
	public WaPlanConditionTable getWaPlanConditionTableById(int id) throws BizException{
		if (id == 0) {
            return null;
        }
        return waPlanConditionTableDao.getById(id);
	}

	public List<WaPlanConditionTable> getDataByCompanyId(int companyId) throws BizException{
		if (companyId == 0) {
			return null;
		}
		return waPlanConditionTableDao.getDataByCompanyId(companyId);
	}
}
