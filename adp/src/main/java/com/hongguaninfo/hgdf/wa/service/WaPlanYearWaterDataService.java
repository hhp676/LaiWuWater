/*
 * File Name:WaPlanYearWaterDataService.java
 * Package Name:com.hongguaninfo.hgdf.bud.service.wa
 * Date:2018年09月11日 下午8:49:44
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.service;


import com.hongguaninfo.hgdf.adp.core.base.BasePage;
import com.hongguaninfo.hgdf.adp.core.exception.BizException;
import com.hongguaninfo.hgdf.adp.core.utils.generator.DbIdGenerator;
import com.hongguaninfo.hgdf.core.utils.StringUtil;
import com.hongguaninfo.hgdf.core.utils.logging.Log;
import com.hongguaninfo.hgdf.core.utils.logging.LogFactory;
import com.hongguaninfo.hgdf.core.utils.page.Page;
import com.hongguaninfo.hgdf.wa.dao.WaCompanyInfoDao;
import com.hongguaninfo.hgdf.wa.dao.WaPlanYearWaterDataDao;
import com.hongguaninfo.hgdf.wa.entity.WaCompanyInfo;
import com.hongguaninfo.hgdf.wa.entity.WaPlanYearWaterData;
import com.hongguaninfo.hgdf.wa.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * : wa_plan_year_water_data. <br />
 * service interface 层 <br />
 * Date: 2018年09月11日 下午8:49:44 <br />
 * @author  hhp
 * @since V1.0.0
 */
@Service("waPlanYearWaterDataService")
public class WaPlanYearWaterDataService {

	@Autowired
	private WaPlanYearWaterDataDao waPlanYearWaterDataDao;

	@Autowired
	private DbIdGenerator dbIdGenerator;

	@Autowired
	private WaCompanyInfoDao waCompanyInfoDao;

	private DecimalFormat df = new DecimalFormat("#.##");

	private static final Log LOG = LogFactory.getLog(WaPlanYearWaterDataService.class);
	/**
	 * REMARK
	 * 分页查询
	 * Show all content and can paging
	 * The following id to give priority to key !
	 */
	public List<WaPlanYearWaterData> getWaPlanYearWaterDataList (BasePage<WaPlanYearWaterData> basePage,
																 WaPlanYearWaterData vo, Map<String, Object> map) throws BizException {
		vo.setIsDelte(0);
        basePage.setFilters(vo);
        Page<WaPlanYearWaterData> page = waPlanYearWaterDataDao.pageQuery(basePage);
        List<WaPlanYearWaterData> list = page.getResult();
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
	public void addWaPlanYearWaterData (WaPlanYearWaterData waPlanYearWaterData) throws BizException{


		waPlanYearWaterData.setIsDelte(0);
		WaPlanYearWaterData resultEntity = waPlanYearWaterDataDao.getByYearWaterData(waPlanYearWaterData);
		if(!StringUtil.isNull(resultEntity)){   //先删除后新增
			waPlanYearWaterDataDao.deleteByWaterData(resultEntity);
		}
		waPlanYearWaterData.setCrtTime(new Date());
		waPlanYearWaterData.setUpdTime(new Date());
		waPlanYearWaterDataDao.update(waPlanYearWaterData);
	}

	/**
	 * REMARK
	 * 修改
	 * update data
	 * Date need their conversion !
	 */
	public void updateWaPlanYearWaterData (WaPlanYearWaterData waPlanYearWaterData) throws BizException{
 		waPlanYearWaterData.setUpdTime(new Date());
		waPlanYearWaterData.setIsDelte(0);
		waPlanYearWaterDataDao.update(waPlanYearWaterData);
	}

	/**
	 * REMARK
	 * 删除
	 * Through the id delete a data
	 */
	public void deleteWaPlanYearWaterData(int id) throws BizException{
		waPlanYearWaterDataDao.delete(id);
	}

	/**
	 * 根据companyId逻辑删除
	 * @param companyId
	 * @throws BizException
	 */
	public void updatePlanYearDataByEntity(int companyId) throws BizException{
		WaPlanYearWaterData waPlanYearWaterData = new WaPlanYearWaterData();
		waPlanYearWaterData.setCompanyId(String.valueOf(companyId));
		waPlanYearWaterData.setIsDelte(1);
		waPlanYearWaterDataDao.updatePlanYearDataByEntity(waPlanYearWaterData);
	}

	/**
	 * REMARK
	 * 物理删除
	 * Through the id delete a data logic
	 */
	public void deleteWaPlanYearWaterDataLogic(int planWaterId) throws BizException{
        WaPlanYearWaterData waPlanYearWaterData = new WaPlanYearWaterData();
        waPlanYearWaterData.setPlanWaterId(planWaterId);
        waPlanYearWaterData.setUpdTime(new Date());
        waPlanYearWaterData.setIsDelte(1);
        waPlanYearWaterDataDao.update(waPlanYearWaterData);
	}	
	

	/**
	 * REMARK
	 * 查询实体信息
	 * Inquires the individual data
	 * Date need their conversion !
	 */
	public WaPlanYearWaterData getWaPlanYearWaterDataById(int id) throws BizException{
		if (id == 0) {
            return null;
        }
        return waPlanYearWaterDataDao.getById(id);
	}

	public List<WaPlanYearWaterData> getPlanWaterList(WaPlanYearWaterData waterData){
		return  waPlanYearWaterDataDao.getList(waterData);
	}

	/**
	 * 获取下一年的时间
	 * @return
	 */
	public static String getNextYear(){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 1);
		date = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date checkDate = date != null ? date : new Date();
		return dateFormat.format(checkDate);
	}

	/**
	 * 去除待计算年的list
	 * @param yearList
	 * @return
	 */
	public static List<WaPlanYearWaterData> getYearWaterList(List<WaPlanYearWaterData> yearList){
		List<WaPlanYearWaterData> resultYearList = new ArrayList<>();
		String nextYear = getNextYear();
		for (WaPlanYearWaterData data: yearList) {
			if (!data.getPlanYear().equals(nextYear)){
				resultYearList.add(data);
			}
		}
		return resultYearList;
	}
	/**
	 * excel文件遍历
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public String doReadXls(InputStream is) throws Exception{
		try {
			String resultCon = "success";
			HSSFWorkbook workBook = new HSSFWorkbook(is);
			HSSFSheet sheet = workBook.getSheetAt(0);

			for (int rowNum = 1;rowNum <= sheet.getLastRowNum();rowNum++) {
				HSSFRow row = sheet.getRow(rowNum);
				WaPlanYearWaterData waPlanYearWaterData = new WaPlanYearWaterData();
				if (row != null) {
					String companyCode = ExcelUtil.getCellValue(row.getCell(0));
					if(StringUtil.isEmpty(companyCode)){
						continue;
					}
					WaCompanyInfo com = new WaCompanyInfo();

					com.setCompanyCode(companyCode);
					WaCompanyInfo resultCom = waCompanyInfoDao.getEntityByCode(com);
					if (StringUtil.isNull(resultCom)){
						LOG.error("row is["+rowNum+"], companyCode ["+companyCode+"] is not exit");
						resultCon = "第" + (rowNum+1) + "行，节水代码为 " + companyCode + " 的单位信息不存在，请修改";
						return resultCon;
					}

					//根据code获取id后拼装list
					waPlanYearWaterData.setCompanyId(String.valueOf(resultCom.getCompanyId()));
					waPlanYearWaterData.setPlanYear(ExcelUtil.getCellValue(row.getCell(2)));
					//判断年计划用水量是否正常
					try {
						waPlanYearWaterData.setPlanYearAvgWater(df.format(Float.parseFloat((StringUtil.isNull(row.getCell(3)))? "0": row.getCell(3).toString())));
					}catch (Exception e){
						LOG.error("row is["+rowNum+"], companyCode ["+companyCode+"] is not exit");
						resultCon = "第" + (rowNum+1) + "行，计划用水量有问题，请修改";
						return resultCon;
					}

					try {
						WaPlanYearWaterData tmp = new WaPlanYearWaterData();
						tmp.setCompanyId(waPlanYearWaterData.getCompanyId());
						tmp.setPlanYear(waPlanYearWaterData.getPlanYear());
//						tmp.setIsDelte(0);
						//判断当前单位当年数据是否已存在,存在即更新操作，不存在则新增
						List<WaPlanYearWaterData> resultTmpList= waPlanYearWaterDataDao.getList(tmp);
						if(resultTmpList.size()>0){
							tmp.setPlanWaterId(resultTmpList.get(0).getPlanWaterId());
							tmp.setPlanYearAvgWater(waPlanYearWaterData.getPlanYearAvgWater());
							tmp.setIsDelte(0);
							waPlanYearWaterDataDao.update(tmp);
						}else {
							waPlanYearWaterData.setIsDelte(0);
							addWaPlanYearWaterData(waPlanYearWaterData);
						}
					}catch (Exception e){
						LOG.error("import mysql is error" +e);
						return "录入至系统失败，请检查文件数据";
					}

				}
			}

			return resultCon;
		}catch (Exception e){
			LOG.error("import error---" + e);
			return "导入失败，请检查文件数据";
		}
	}

}
