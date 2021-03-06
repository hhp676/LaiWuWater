/*
 * File Name:WaIndustryWaterDataService.java
 * Package Name:com.hongguaninfo.hgdf.bud.service.wa
 * Date:2018年09月14日 上午9:23:39
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.service.totalinfo;


import com.hongguaninfo.hgdf.adp.core.base.BasePage;
import com.hongguaninfo.hgdf.adp.core.exception.BizException;
import com.hongguaninfo.hgdf.adp.core.utils.generator.DbIdGenerator;
import com.hongguaninfo.hgdf.core.utils.page.Page;
import com.hongguaninfo.hgdf.wa.dao.totalinfo.WaIndustryWaterDataDao;
import com.hongguaninfo.hgdf.wa.entity.totalinfo.WaIndustryWaterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * : wa_industry_water_data. <br />
 * service interface 层 <br />
 * Date: 2018年09月14日 上午9:23:39 <br />
 * @author  hhp
 * @since V1.0.0
 */
@Service("waIndustryWaterDataService")
public class WaIndustryWaterDataService {

	@Autowired
	private WaIndustryWaterDataDao waIndustryWaterDataDao;

	@Autowired
	private DbIdGenerator dbIdGenerator;
	
	/**
	 * REMARK
	 * 分页查询
	 * Show all content and can paging
	 * The following id to give priority to key !
	 */
	public List<WaIndustryWaterData> getWaIndustryWaterDataList (BasePage<WaIndustryWaterData> basePage,
																 WaIndustryWaterData vo, Map<String, Object> map) throws BizException {
		vo.setIsDelete(0);
        basePage.setFilters(vo);
        Page<WaIndustryWaterData> page = waIndustryWaterDataDao.pageQuery(basePage);
        List<WaIndustryWaterData> list = page.getResult();
        /**for (WaIndustryWaterData bo : list) {
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
	public void addWaIndustryWaterData (WaIndustryWaterData waIndustryWaterData) throws BizException{
		 
		waIndustryWaterData.setIsDelete(0);
        waIndustryWaterData.setCrtTime(new Date());
		waIndustryWaterDataDao.save(waIndustryWaterData);
	}

	/**
	 * REMARK
	 * 修改
	 * update data
	 * Date need their conversion !
	 */
	public void updateWaIndustryWaterData (WaIndustryWaterData waIndustryWaterData) throws BizException{
 		waIndustryWaterData.setUptTime(new Date());
		waIndustryWaterDataDao.update(waIndustryWaterData);
	}

	/**
	 * REMARK
	 * 删除
	 * Through the id delete a data
	 */
	public void deleteWaIndustryWaterData(int id) throws BizException{
		waIndustryWaterDataDao.delete(id);
	}
	
	/**
	 * REMARK
	 * 物理删除
	 * Through the id delete a data logic
	 */
	public void deleteWaIndustryWaterDataLogic(int id) throws BizException{
        WaIndustryWaterData waIndustryWaterData = new WaIndustryWaterData();
        waIndustryWaterData.setUptTime(new Date());
        waIndustryWaterData.setIsDelete(1);
        waIndustryWaterDataDao.update(waIndustryWaterData);
	}	
	

	/**
	 * REMARK
	 * 查询实体信息
	 * Inquires the individual data
	 * Date need their conversion !
	 */
	public WaIndustryWaterData getWaIndustryWaterDataById(int id) throws BizException{
		if (id == 0) {
            return null;
        }
        return waIndustryWaterDataDao.getById(id);
	}

	public WaIndustryWaterData getIndustryDataByCompanyId(int companyId) throws BizException{
		if (companyId == 0) {
			return null;
		}
		return waIndustryWaterDataDao.getIndustryDataByCompanyId(companyId);
	}

}
