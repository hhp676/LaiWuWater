/*
 * File Name:WaCompanyWaterDataNewService.java
 * Package Name:com.hongguaninfo.hgdf.bud.service.wa
 * Date:2018年11月24日 下午11:56:23
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.service;


import com.hongguaninfo.hgdf.adp.core.base.BasePage;
import com.hongguaninfo.hgdf.adp.core.exception.BizException;
import com.hongguaninfo.hgdf.adp.core.utils.generator.DbIdGenerator;
import com.hongguaninfo.hgdf.core.utils.page.Page;
import com.hongguaninfo.hgdf.wa.dao.WaCompanyWaterDataNewDao;
import com.hongguaninfo.hgdf.wa.entity.WaCompanyWaterDataNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * : wa_company_water_data_new. <br />
 * service interface 层 <br />
 * Date: 2018年11月24日 下午11:56:23 <br />
 * @author  hhp
 * @since V1.0.0
 */
@Service("waCompanyWaterDataNewService")
public class WaCompanyWaterDataNewService {

	@Autowired
	private WaCompanyWaterDataNewDao waCompanyWaterDataNewDao;

	@Autowired
	private DbIdGenerator dbIdGenerator;
	
	/**
	 * REMARK
	 * 分页查询
	 * Show all content and can paging
	 * The following id to give priority to key !
	 */
	public List<WaCompanyWaterDataNew> getWaCompanyWaterDataNewList (BasePage<WaCompanyWaterDataNew> basePage,
																	 WaCompanyWaterDataNew vo, Map<String, Object> map) throws BizException {
		vo.setIsDelete(0);
        basePage.setFilters(vo);
        Page<WaCompanyWaterDataNew> page = waCompanyWaterDataNewDao.pageQuery(basePage);
        List<WaCompanyWaterDataNew> list = page.getResult();
        /**for (WaCompanyWaterDataNew bo : list) {
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
	public void addWaCompanyWaterDataNew (WaCompanyWaterDataNew waCompanyWaterDataNew) throws BizException{
		 
		waCompanyWaterDataNew.setIsDelete(0);
        waCompanyWaterDataNew.setCrtTime(new Date());
        waCompanyWaterDataNew.setUpdTime(new Date());
		waCompanyWaterDataNewDao.save(waCompanyWaterDataNew);
	}

	/**
	 * REMARK
	 * 修改
	 * update data
	 * Date need their conversion !
	 */
	public void updateWaCompanyWaterDataNew (WaCompanyWaterDataNew waCompanyWaterDataNew) throws BizException{
 		waCompanyWaterDataNew.setUpdTime(new Date());
		waCompanyWaterDataNewDao.update(waCompanyWaterDataNew);
	}

	/**
	 * REMARK
	 * 删除
	 * Through the id delete a data
	 */
	public void deleteWaCompanyWaterDataNew(int id) throws BizException{
		waCompanyWaterDataNewDao.delete(id);
	}
	
	/**
	 * REMARK
	 * 物理删除
	 * Through the id delete a data logic
	 */
	public void deleteWaCompanyWaterDataNewLogic(int id) throws BizException{
        WaCompanyWaterDataNew waCompanyWaterDataNew = new WaCompanyWaterDataNew();
        waCompanyWaterDataNew.setUpdTime(new Date());
        waCompanyWaterDataNew.setIsDelete(1);
        waCompanyWaterDataNew.setCompanyWaterId(id);
        waCompanyWaterDataNewDao.update(waCompanyWaterDataNew);
	}	
	

	/**
	 * REMARK
	 * 查询实体信息
	 * Inquires the individual data
	 * Date need their conversion !
	 */
	public WaCompanyWaterDataNew getWaCompanyWaterDataNewById(int id) throws BizException{
		if (id == 0) {
            return null;
        }
        return waCompanyWaterDataNewDao.getById(id);
	}
}
