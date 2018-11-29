/*
 * File Name:WaInterwaterInstallationTableService.java
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
import com.hongguaninfo.hgdf.wa.dao.waCompanyInfo.WaInterwaterInstallationTableDao;
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaInterwaterInstallationTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * : wa_interwater_installation_table. <br />
 * service interface 层 <br />
 * Date: 2018年11月26日 下午9:43:51 <br />
 * @author  hhp
 * @since V1.0.0
 */
@Service("waInterwaterInstallationTableService")
public class WaInterwaterInstallationTableService {

	@Autowired
	private WaInterwaterInstallationTableDao waInterwaterInstallationTableDao;

	@Autowired
	private DbIdGenerator dbIdGenerator;
	
	/**
	 * REMARK
	 * 分页查询
	 * Show all content and can paging
	 * The following id to give priority to key !
	 */
	public List<WaInterwaterInstallationTable> getWaInterwaterInstallationTableList (BasePage<WaInterwaterInstallationTable> basePage,
																					 WaInterwaterInstallationTable vo, Map<String, Object> map) throws BizException {
		vo.setIsDelete(0);
        basePage.setFilters(vo);
        Page<WaInterwaterInstallationTable> page = waInterwaterInstallationTableDao.pageQuery(basePage);
        List<WaInterwaterInstallationTable> list = page.getResult();
        /**for (WaInterwaterInstallationTable bo : list) {
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
	public void addWaInterwaterInstallationTable (WaInterwaterInstallationTable waInterwaterInstallationTable) throws BizException{
		 
		waInterwaterInstallationTable.setIsDelete(0);
        waInterwaterInstallationTable.setUpdTime(new Date());
		waInterwaterInstallationTableDao.save(waInterwaterInstallationTable);
	}

	/**
	 * REMARK
	 * 修改
	 * update data
	 * Date need their conversion !
	 */
	public void updateWaInterwaterInstallationTable (WaInterwaterInstallationTable waInterwaterInstallationTable) throws BizException{
 		waInterwaterInstallationTable.setUpdTime(new Date());
		waInterwaterInstallationTableDao.update(waInterwaterInstallationTable);
	}

	/**
	 * REMARK
	 * 删除
	 * Through the id delete a data
	 */
	public void deleteWaInterwaterInstallationTable(int id) throws BizException{
		waInterwaterInstallationTableDao.delete(id);
	}
	
	/**
	 * REMARK
	 * 物理删除
	 * Through the id delete a data logic
	 */
	public void deleteWaInterwaterInstallationTableLogic(int id) throws BizException{
        WaInterwaterInstallationTable waInterwaterInstallationTable = new WaInterwaterInstallationTable();
        waInterwaterInstallationTable.setInterwaterId(id);
        waInterwaterInstallationTable.setUpdTime(new Date());
        waInterwaterInstallationTable.setIsDelete(1);
        waInterwaterInstallationTableDao.update(waInterwaterInstallationTable);
	}	
	

	/**
	 * REMARK
	 * 查询实体信息
	 * Inquires the individual data
	 * Date need their conversion !
	 */
	public WaInterwaterInstallationTable getWaInterwaterInstallationTableById(int id) throws BizException{
		if (id == 0) {
            return null;
        }
        return waInterwaterInstallationTableDao.getById(id);
	}

	public List<WaInterwaterInstallationTable> getDataByCompanyId(int companyId) throws BizException{
		if (companyId == 0) {
			return null;
		}
		return waInterwaterInstallationTableDao.getDataByCompanyId(companyId);
	}
}
