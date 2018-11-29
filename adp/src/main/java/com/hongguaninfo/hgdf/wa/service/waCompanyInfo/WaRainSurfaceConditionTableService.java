/*
 * File Name:WaRainSurfaceConditionTableService.java
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
import com.hongguaninfo.hgdf.wa.dao.waCompanyInfo.WaRainSurfaceConditionTableDao;
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaRainSurfaceConditionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * : wa_rain_surface_condition_table. <br />
 * service interface 层 <br />
 * Date: 2018年11月26日 下午9:43:51 <br />
 * @author  hhp
 * @since V1.0.0
 */
@Service("waRainSurfaceConditionTableService")
public class WaRainSurfaceConditionTableService {

	@Autowired
	private WaRainSurfaceConditionTableDao waRainSurfaceConditionTableDao;

	@Autowired
	private DbIdGenerator dbIdGenerator;
	
	/**
	 * REMARK
	 * 分页查询
	 * Show all content and can paging
	 * The following id to give priority to key !
	 */
	public List<WaRainSurfaceConditionTable> getWaRainSurfaceConditionTableList (BasePage<WaRainSurfaceConditionTable> basePage,
																				 WaRainSurfaceConditionTable vo, Map<String, Object> map) throws BizException {
		vo.setIsDelete(0);
        basePage.setFilters(vo);
        Page<WaRainSurfaceConditionTable> page = waRainSurfaceConditionTableDao.pageQuery(basePage);
        List<WaRainSurfaceConditionTable> list = page.getResult();
        /**for (WaRainSurfaceConditionTable bo : list) {
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
	public void addWaRainSurfaceConditionTable (WaRainSurfaceConditionTable waRainSurfaceConditionTable) throws BizException{
		 
		waRainSurfaceConditionTable.setIsDelete(0);
        waRainSurfaceConditionTable.setCrtTime(new Date());
        waRainSurfaceConditionTable.setUpdTime(new Date());
		waRainSurfaceConditionTableDao.save(waRainSurfaceConditionTable);
	}

	/**
	 * REMARK
	 * 修改
	 * update data
	 * Date need their conversion !
	 */
	public void updateWaRainSurfaceConditionTable (WaRainSurfaceConditionTable waRainSurfaceConditionTable) throws BizException{
 		waRainSurfaceConditionTable.setUpdTime(new Date());
		waRainSurfaceConditionTableDao.update(waRainSurfaceConditionTable);
	}

	/**
	 * REMARK
	 * 删除
	 * Through the id delete a data
	 */
	public void deleteWaRainSurfaceConditionTable(int id) throws BizException{
		waRainSurfaceConditionTableDao.delete(id);
	}
	
	/**
	 * REMARK
	 * 物理删除
	 * Through the id delete a data logic
	 */
	public void deleteWaRainSurfaceConditionTableLogic(int id) throws BizException{
        WaRainSurfaceConditionTable waRainSurfaceConditionTable = new WaRainSurfaceConditionTable();
        waRainSurfaceConditionTable.setUpdTime(new Date());
        waRainSurfaceConditionTable.setIsDelete(1);
        waRainSurfaceConditionTableDao.update(waRainSurfaceConditionTable);
	}	
	

	/**
	 * REMARK
	 * 查询实体信息
	 * Inquires the individual data
	 * Date need their conversion !
	 */
	public WaRainSurfaceConditionTable getWaRainSurfaceConditionTableById(int id) throws BizException{
		if (id == 0) {
            return null;
        }
        return waRainSurfaceConditionTableDao.getById(id);
	}

	public List<WaRainSurfaceConditionTable> getDataByCompanyId(int companyId) throws BizException{
		if (companyId == 0) {
			return null;
		}
		return waRainSurfaceConditionTableDao.getDataByCompanyId(companyId);
	}

}
