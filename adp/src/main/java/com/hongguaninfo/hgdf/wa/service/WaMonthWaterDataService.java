/*
 * File Name:WaMonthWaterDataService.java
 * Package Name:com.hongguaninfo.hgdf.bud.service.wa
 * Date:2018年09月11日 下午8:49:44
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.service;


import com.hongguaninfo.hgdf.adp.core.base.BasePage;
import com.hongguaninfo.hgdf.adp.core.exception.BizException;
import com.hongguaninfo.hgdf.adp.entity.sys.SysDatadicItem;
import com.hongguaninfo.hgdf.adp.service.sys.SysDatadicItemService;
import com.hongguaninfo.hgdf.core.utils.StringUtil;
import com.hongguaninfo.hgdf.core.utils.logging.Log;
import com.hongguaninfo.hgdf.core.utils.logging.LogFactory;
import com.hongguaninfo.hgdf.core.utils.page.Page;
import com.hongguaninfo.hgdf.wa.dao.WaCompanyInfoDao;
import com.hongguaninfo.hgdf.wa.dao.WaMonthWaterDataDao;
import com.hongguaninfo.hgdf.wa.entity.WaCompanyInfo;
import com.hongguaninfo.hgdf.wa.entity.WaMonthWaterData;
import com.hongguaninfo.hgdf.wa.utils.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * : wa_month_water_data. <br />
 * service interface 层 <br />
 * Date: 2018年09月11日 下午8:49:44 <br />
 * @author  hhp
 * @since V1.0.0
 */
@Service("waMonthWaterDataService")
public class WaMonthWaterDataService {

	@Autowired
	private WaMonthWaterDataDao waMonthWaterDataDao;

	@Autowired
	private SysDatadicItemService sysDatadicItemBiz;

	@Autowired
	private WaCompanyInfoDao waCompanyInfoDao;

	private static final Log LOG = LogFactory.getLog(WaMonthWaterDataService.class);

	private DecimalFormat df = new DecimalFormat("#.##");
	/**
	 * REMARK
	 * 分页查询 超计划分析页面
	 * Show all content and can paging
	 * The following id to give priority to key !
	 */
	public List<WaMonthWaterData> getWaMonthWaterDataList (BasePage<WaMonthWaterData> basePage,
														   WaMonthWaterData vo, Map<String, Object> map) throws BizException {
		vo.setIsDelte(0);
		String monthnData = (StringUtil.isEmpty(vo.getWaYear())? "" : vo.getWaYear()) + "" + (StringUtil.isEmpty(vo.getWaMonth()) ? "" : "" + vo.getWaMonth());
        vo.setMonthDate(monthnData);

		basePage.setFilters(vo);
        Page<WaMonthWaterData> page = waMonthWaterDataDao.getOverPlanListPage(basePage);
		List<WaMonthWaterData> list = getOverPlanDataList(page);
		for (WaMonthWaterData data: list){
			data.setCompanyCode(data.getMonthWaterId() + "/"+data.getCompanyCode());
			data.setCompanyName(data.getMonthWaterId() + "/"+data.getCompanyName());
			data.setMonthDate(data.getMonthWaterId() + "/"+data.getMonthDate());
		}
        map.put("rows", list);
        map.put("total", page.getTotalCount());
        return list;
	}

	/**
	 * REMARK
	 * 月计划用水分页查询，去除月用水量为空数据
	 * Show all content and can paging
	 * The following id to give priority to key !
	 */
	public List<WaMonthWaterData> getWaMonthWaterPlanDataList (BasePage<WaMonthWaterData> basePage,
														   WaMonthWaterData vo, Map<String, Object> map) throws BizException {
		vo.setIsDelte(0);
		String monthnData = (StringUtil.isEmpty(vo.getWaYear())? "" : vo.getWaYear()) + "" + (StringUtil.isEmpty(vo.getWaMonth()) ? "" : "" + vo.getWaMonth());
		vo.setMonthDate(monthnData);

		basePage.setFilters(vo);
		Page<WaMonthWaterData> page = waMonthWaterDataDao.pagePlanDataQuery(basePage);
		List<WaMonthWaterData> list = getDataList(page);
		map.put("rows", list);
		map.put("total", page.getTotalCount());
		return list;
	}

	/**
	 * REMARK
	 * 月实际用水分页查询，去除月实际量为空数据
	 * Show all content and can paging
	 * The following id to give priority to key !
	 */
	public List<WaMonthWaterData> getWaMonthWaterActDataList (BasePage<WaMonthWaterData> basePage,
															   WaMonthWaterData vo, Map<String, Object> map) throws BizException {
		vo.setIsDelte(0);
		String monthnData = (StringUtil.isEmpty(vo.getWaYear())? "" : vo.getWaYear()) + "" + (StringUtil.isEmpty(vo.getWaMonth()) ? "" : "" + vo.getWaMonth());
		vo.setMonthDate(monthnData);

		basePage.setFilters(vo);
		Page<WaMonthWaterData> page = waMonthWaterDataDao.pageActDataQuery(basePage);
		List<WaMonthWaterData> list = getDataList(page);
		map.put("rows", list);
		map.put("total", page.getTotalCount());
		return list;
	}

	public String getDefaultVal(String data, List<SysDatadicItem> list){
		for (SysDatadicItem bo : list) {
			if (data.equals(bo.getItemValue())) {
				return bo.getItemName();
			}
		}
		return "";
	}

	/**
	 * 公共使用方法获取list返回值
	 * @param page
	 * @return
	 * @throws BizException
	 */
	public List<WaMonthWaterData> getDataList(Page<WaMonthWaterData> page) throws BizException {
		List<WaMonthWaterData> list = page.getResult();

		//查询是否超标/重点用户 字典项
		List<SysDatadicItem> isoverroofList = sysDatadicItemBiz.getListByGroupCode("IS_OVERROOF");
		List<SysDatadicItem> isimportList = sysDatadicItemBiz.getListByGroupCode("IS_IMPORT");

		for (WaMonthWaterData bo : list) {
			bo.setIsOverResidentWater(getDefaultVal(bo.getIsOverResidentWater(), isoverroofList));
			bo.setIsOverNoResidentWater(getDefaultVal(bo.getIsOverNoResidentWater(), isoverroofList));
			bo.setIsOverEducationWater(getDefaultVal(bo.getIsOverEducationWater(), isoverroofList));
			bo.setIsOverSpecialTradeWater(getDefaultVal(bo.getIsOverSpecialTradeWater(), isoverroofList));
			bo.setIsImport(getDefaultVal(bo.getIsImport(), isimportList));
		}
		return list;
	}

	/**
	 * 超计划分析获取list返回值
	 * @param page
	 * @return
	 * @throws BizException
	 */
	public List<WaMonthWaterData> getOverPlanDataList(Page<WaMonthWaterData> page) throws BizException {
		List<WaMonthWaterData> list = page.getResult();

		//查询是否超标/重点用户 字典项
		List<SysDatadicItem> isoverroofList = sysDatadicItemBiz.getListByGroupCode("IS_OVERROOF");
		List<SysDatadicItem> isimportList = sysDatadicItemBiz.getListByGroupCode("IS_IMPORT");

		for (WaMonthWaterData bo : list) {
			bo.setIndexOverRoof(getDefaultVal(bo.getIndexOverRoof(), isoverroofList));
//			bo.setIsImport(getDefaultVal(bo.getIsImport(), isimportList));
		}
		return list;
	}


	/**
	 * REMARK
	 * 新增信息
	 * Through the id inquires the out a data
	 * Date need their conversion !
	 * UserName is the current user name !
	 */
	public void addWaMonthWaterData (WaMonthWaterData waMonthWaterData, String doType) throws BizException{
		//先判断是否存在该月数据,存在即只更新计划用水操作
		try {
			WaMonthWaterData tmp = new WaMonthWaterData();
			tmp.setCompanyId(waMonthWaterData.getCompanyId());
			tmp.setMonthDate(waMonthWaterData.getMonthDate());
			tmp.setIsDelte(0);
			WaMonthWaterData resultTmp = new WaMonthWaterData();
			resultTmp = waMonthWaterDataDao.getWaListByEntity(tmp);
			if(null != resultTmp){  //判断当前单位当月数据是否已存在,存在即先删除在录入
				if ("plan".equals(doType)){  //计划用水操作，需要赋值新进的计划用水
//					resultTmp.setPlanMonthWater(waMonthWaterData.getPlanMonthWater());
					resultTmp.setPlanResidentWater(waMonthWaterData.getPlanResidentWater());
					resultTmp.setPlanNoResidentWater(waMonthWaterData.getPlanNoResidentWater());
					resultTmp.setPlanEducationWater(waMonthWaterData.getPlanEducationWater());
					resultTmp.setPlanSpecialTradeWater(waMonthWaterData.getPlanSpecialTradeWater());
				}else if("act".equals(doType)){ //实际用水操作，需要赋值新进来的实际用水
//					resultTmp.setActMonthWater(waMonthWaterData.getActMonthWater());
					resultTmp.setActResidentWater(waMonthWaterData.getActResidentWater());
					resultTmp.setActNoResidentWater(waMonthWaterData.getActNoResidentWater());
					resultTmp.setActEducationWater(waMonthWaterData.getActEducationWater());
					resultTmp.setActSpecialTradeWater(waMonthWaterData.getActSpecialTradeWater());
				}

				waMonthWaterDataDao.update(getEntityByFee(resultTmp));
				return;
			}

			///新增数据入库
//			waMonthWaterData.setIsOverroof("0");
			waMonthWaterData.setIsDelte(0);
			waMonthWaterData.setCrtTime(new Date());
			waMonthWaterData.setUpdTime(new Date());
			waMonthWaterDataDao.save((waMonthWaterData));
		}catch (Exception e){
			LOG.error("month actwater error=" + e);
		}
	}

	/**
	 * 获取数据库里面的数据内容
	 * @param waMonthWaterData
	 * @return
	 */
	public WaMonthWaterData getEntityByFee(WaMonthWaterData waMonthWaterData){
//		float planWaterAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getPlanMonthWater())? "0": waMonthWaterData.getPlanMonthWater());
//		float actWaterAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getActMonthWater())? "0": waMonthWaterData.getActMonthWater());
		float planResidentAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getPlanResidentWater())? "0": waMonthWaterData.getPlanResidentWater());
		float planNoResidentAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getPlanNoResidentWater())? "0": waMonthWaterData.getPlanNoResidentWater());
		float planEduationAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getPlanEducationWater())? "0": waMonthWaterData.getPlanEducationWater());
		float planSpecialAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getPlanSpecialTradeWater())? "0": waMonthWaterData.getPlanSpecialTradeWater());

		float actResidentAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getActResidentWater())? "0": waMonthWaterData.getActResidentWater());
		float actNoResidentAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getActNoResidentWater())? "0": waMonthWaterData.getActNoResidentWater());
		float actEduationAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getActEducationWater())? "0": waMonthWaterData.getActEducationWater());
		float actSpecialAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getActSpecialTradeWater())? "0": waMonthWaterData.getActSpecialTradeWater());

//		float beyondAmount = actWaterAmount - planWaterAmount;
		float beyondResidentAmount = actResidentAmount - planResidentAmount;
		float beyondNoResidentAmount = actNoResidentAmount - planNoResidentAmount;
		float beyondEduationAmount = actEduationAmount - planEduationAmount;
		float beyondSpecialAmount = actSpecialAmount - planSpecialAmount;

//		String beyondResult = beyondAmount<0? "0" : String.valueOf(beyondAmount);
		String beyondResidentResult = beyondResidentAmount<0? "0" : String.valueOf(beyondResidentAmount);
		String beyondNoResidentResult = beyondNoResidentAmount<0? "0" : String.valueOf(beyondNoResidentAmount);
		String beyondEduationResult = beyondEduationAmount<0? "0" : String.valueOf(beyondEduationAmount);
		String beyondSpecialResult = beyondSpecialAmount<0? "0" : String.valueOf(beyondSpecialAmount);

//		waMonthWaterData.setBeyondAmount(beyondResult);
		waMonthWaterData.setBeyondResidentWater(beyondResidentResult);
		waMonthWaterData.setBeyondNoResidentWater(beyondNoResidentResult);
		waMonthWaterData.setBeyondEducationWater(beyondEduationResult);
		waMonthWaterData.setBeyondSpecialTradeWater(beyondSpecialResult);
		if (beyondResidentAmount > 0){  //计划<实际则超标
			waMonthWaterData.setIsOverResidentWater("1");
		}
		if (beyondNoResidentAmount > 0){  //计划<实际则超标
			waMonthWaterData.setIsOverNoResidentWater("1");
		}
		if (beyondEduationAmount> 0){  //计划<实际则超标
			waMonthWaterData.setIsOverEducationWater("1");
		}
		if (beyondSpecialAmount > 0){  //计划<实际则超标
			waMonthWaterData.setIsOverSpecialTradeWater("1");
		}

//		waMonthWaterData.setFeeStandard(getBeyondFee(actWaterAmount, planWaterAmount));  //获取收费标准
		waMonthWaterData.setFeeResidentWater(getBeyondFee(actResidentAmount, planResidentAmount));
		waMonthWaterData.setFeeNoResidentWater(getBeyondFee(actNoResidentAmount, planNoResidentAmount));
		waMonthWaterData.setFeeEducationWater(getBeyondFee(actEduationAmount, planEduationAmount));
		waMonthWaterData.setFeeSpecialTradeWater(getBeyondFee(actSpecialAmount, planSpecialAmount));
		return waMonthWaterData;
	}

	public String getBeyondFee(float actWaterAmount, float planWaterAmount){
		String result = "";
		float beyondAmount = actWaterAmount - planWaterAmount;
		float beyondRate = (float) beyondAmount/planWaterAmount;
		if (actWaterAmount == 0 || planWaterAmount == 0 || actWaterAmount == 0.0 || planWaterAmount == 0.0){  //实际用水未生成情况下
			return "";
		}

		//情况1：未超计划用水
		if (beyondAmount<=0){
			result = "按照正常收费标准收费";//"正常收费用水量：" + actWaterAmount + "; ";
		}
		//超计划用水 水量在0-0.1之间
		if (beyondRate>0 && beyondRate <=0.1){
			result = "超计划10%内（含）部分，按照当地水资源标准1倍加收";//" 正常收费用水量："+ planWaterAmount +";\n 按当地水资费标准1倍加收量：" + beyondAmount;
		}
		else if (beyondRate>0.1 && beyondRate<=0.3){
			result =  "超计划10%至30%内（含）部分，按照当地水资源标准2倍加收";  //  " 正常收费用水量："+ planWaterAmount +";\n 按当地水资费标准1倍加收量：" + df.format(0.1*planWaterAmount) +";\n 按当地水资源资费标准2倍加收量: "+df.format((beyondRate-0.1)*planWaterAmount);
		}
		else if(beyondRate>0.3){
			result = "超计划30%以上部分，按照当地水资源标准3倍加收";  // " 正常收费用水量："+ planWaterAmount +";\n 按当地水资费标准1倍加收量：" + df.format(0.1*planWaterAmount) +";\n 按当地水资源资费标准2倍加收量: "+ df.format(0.2*planWaterAmount) +";\n 按当地水资源资费标准3倍加收量:" + df.format((beyondRate-0.3)*planWaterAmount);
		}
		return result;
	}
	/**
	 * REMARK
	 * 修改
	 * update data
	 * Date need their conversion !
	 */
	public void updateWaMonthWaterData (WaMonthWaterData waMonthWaterData, String doType) throws BizException{
		WaMonthWaterData tmp = new WaMonthWaterData();
//		tmp.setCompanyId(waMonthWaterData.getCompanyId());
		tmp.setMonthWaterId(waMonthWaterData.getMonthWaterId());
		tmp.setIsDelte(0);
		WaMonthWaterData resultTmp = new WaMonthWaterData();
		resultTmp = waMonthWaterDataDao.getWaListByEntity(tmp);

		if ("plan".equals(doType)){
//			waMonthWaterData.setActMonthWater(resultTmp.getActMonthWater());
			waMonthWaterData.setActResidentWater(resultTmp.getActResidentWater());
			waMonthWaterData.setActNoResidentWater(resultTmp.getActNoResidentWater());
			waMonthWaterData.setActEducationWater(resultTmp.getActEducationWater());
			waMonthWaterData.setActSpecialTradeWater(resultTmp.getActSpecialTradeWater());
		}else if("act".equals(doType)){
//			waMonthWaterData.setPlanMonthWater(resultTmp.getPlanMonthWater());
			waMonthWaterData.setPlanResidentWater(resultTmp.getPlanResidentWater());
			waMonthWaterData.setPlanNoResidentWater(resultTmp.getPlanNoResidentWater());
			waMonthWaterData.setPlanEducationWater(resultTmp.getPlanEducationWater());
			waMonthWaterData.setPlanSpecialTradeWater(resultTmp.getPlanSpecialTradeWater());
		}

 		waMonthWaterData.setUpdTime(new Date());
//		waMonthWaterData.setIsOverroof("0");
//		float planWaterAmount = Float.parseFloat(StringUtil.isEmpty(waMonthWaterData.getPlanMonthWater())? "0": waMonthWaterData.getPlanMonthWater());
//		float actWaterAmount = Float.parseFloat(StringUtil.isEmpty(waMonthWaterData.getActMonthWater())? "0": waMonthWaterData.getActMonthWater());
		float planResidentAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getPlanResidentWater())? "0": waMonthWaterData.getPlanResidentWater());
		float planNoResidentAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getPlanNoResidentWater())? "0": waMonthWaterData.getPlanNoResidentWater());
		float planEduationAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getPlanEducationWater())? "0": waMonthWaterData.getPlanEducationWater());
		float planSpecialAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getPlanSpecialTradeWater())? "0": waMonthWaterData.getPlanSpecialTradeWater());

		float actResidentAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getActResidentWater())? "0": waMonthWaterData.getActResidentWater());
		float actNoResidentAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getActNoResidentWater())? "0": waMonthWaterData.getActNoResidentWater());
		float actEduationAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getActEducationWater())? "0": waMonthWaterData.getActEducationWater());
		float actSpecialAmount = Float.valueOf(StringUtil.isEmpty(waMonthWaterData.getActSpecialTradeWater())? "0": waMonthWaterData.getActSpecialTradeWater());



//		float beyondAmount = actWaterAmount - planWaterAmount;
		float beyondResidentAmount = actResidentAmount - planResidentAmount;
		float beyondNoResidentAmount = actNoResidentAmount - planNoResidentAmount;
		float beyondEduationAmount = actEduationAmount - planEduationAmount;
		float beyondSpecialAmount = actSpecialAmount - planSpecialAmount;


//		String beyondResult = beyondAmount<0 ? "0" : String.valueOf(df.format(beyondAmount));
		String beyondResidentResult = beyondResidentAmount<0? "0" : String.valueOf(beyondResidentAmount);
		String beyondNoResidentResult = beyondNoResidentAmount<0? "0" : String.valueOf(beyondNoResidentAmount);
		String beyondEduationResult = beyondEduationAmount<0? "0" : String.valueOf(beyondEduationAmount);
		String beyondSpecialResult = beyondSpecialAmount<0? "0" : String.valueOf(beyondSpecialAmount);

//		waMonthWaterData.setBeyondAmount(beyondResult);
		waMonthWaterData.setBeyondResidentWater(beyondResidentResult);
		waMonthWaterData.setBeyondNoResidentWater(beyondNoResidentResult);
		waMonthWaterData.setBeyondEducationWater(beyondEduationResult);
		waMonthWaterData.setBeyondSpecialTradeWater(beyondSpecialResult);
		/*if (beyondAmount > 0){  //计划<实际则超标
			waMonthWaterData.setIsOverroof("1");
		}*/
		if (beyondResidentAmount > 0){  //计划<实际则超标
			waMonthWaterData.setIsOverResidentWater("1");
		}
		if (beyondNoResidentAmount > 0){  //计划<实际则超标
			waMonthWaterData.setIsOverNoResidentWater("1");
		}
		if (beyondEduationAmount> 0){  //计划<实际则超标
			waMonthWaterData.setIsOverEducationWater("1");
		}
		if (beyondSpecialAmount > 0){  //计划<实际则超标
			waMonthWaterData.setIsOverSpecialTradeWater("1");
		}


//		waMonthWaterData.setFeeStandard(getBeyondFee(actWaterAmount, planWaterAmount));  //获取收费标准
		waMonthWaterData.setFeeResidentWater(getBeyondFee(actResidentAmount, planResidentAmount));
		waMonthWaterData.setFeeNoResidentWater(getBeyondFee(actNoResidentAmount, planNoResidentAmount));
		waMonthWaterData.setFeeEducationWater(getBeyondFee(actEduationAmount, planEduationAmount));
		waMonthWaterData.setFeeSpecialTradeWater(getBeyondFee(actSpecialAmount, planSpecialAmount));

		waMonthWaterDataDao.update(waMonthWaterData);
	}

	/**
	 * REMARK
	 * 删除
	 * Through the id delete a data
	 */
	public void deleteWaMonthWaterData(int id) throws BizException{
		waMonthWaterDataDao.delete(id);
	}

	/**
	 * REMARK
	 * 根据companyid逻辑删除
	 * Through the id delete a data
	 */
	public void updateMonthDataByEntity(int companyId) throws BizException{
		WaMonthWaterData waMonthWaterData = new WaMonthWaterData();
		waMonthWaterData.setCompanyId(String.valueOf(companyId));
		waMonthWaterData.setIsDelte(1);
		waMonthWaterDataDao.updateMonthDataByEntity(waMonthWaterData);
	}


	/**
	 * REMARK
	 * 物理删除
	 * Through the id delete a data logic
	 */
	public void deleteWaMonthWaterDataLogic(int monthWaterId, String doType) throws BizException{
        WaMonthWaterData waMonthWaterData = new WaMonthWaterData();
        waMonthWaterData.setUpdTime(new Date());

        if ("plan".equals(doType)){  //计划用水 需要将planwater清空
//        	waMonthWaterData.setPlanMonthWater("");
        	waMonthWaterData.setPlanResidentWater("");
        	waMonthWaterData.setPlanNoResidentWater("");
        	waMonthWaterData.setPlanEducationWater("");
        	waMonthWaterData.setPlanSpecialTradeWater("");
			waMonthWaterData.setIsDeletePlan(1);
		}else if("act".equals(doType)){  //实际用水，需要将actwater清空
//        	waMonthWaterData.setActMonthWater("");
			waMonthWaterData.setActResidentWater("");
			waMonthWaterData.setActNoResidentWater("");
			waMonthWaterData.setActEducationWater("");
			waMonthWaterData.setActSpecialTradeWater("");
			waMonthWaterData.setIsDeleteAct(1);
		}else {
			waMonthWaterData.setIsDeleteAct(1);
			waMonthWaterData.setIsDeletePlan(1);
		}
        waMonthWaterData.setMonthWaterId(monthWaterId);
		waMonthWaterData.setFeeResidentWater("");
		waMonthWaterData.setFeeNoResidentWater("");
		waMonthWaterData.setFeeEducationWater("");
		waMonthWaterData.setFeeSpecialTradeWater("");
		waMonthWaterData.setBeyondResidentWater("");
		waMonthWaterData.setBeyondNoResidentWater("");
		waMonthWaterData.setBeyondEducationWater("");
		waMonthWaterData.setBeyondSpecialTradeWater("");
		waMonthWaterData.setIsOverResidentWater("");
		waMonthWaterData.setIsOverNoResidentWater("");
		waMonthWaterData.setIsOverEducationWater("");
		waMonthWaterData.setIsOverSpecialTradeWater("");

        waMonthWaterDataDao.update(waMonthWaterData);
	}	
	

	/**
	 * REMARK
	 * 查询实体信息
	 * Inquires the individual data
	 * Date need their conversion !
	 */
	public WaMonthWaterData getWaMonthWaterDataById(WaMonthWaterData entity) throws BizException{
        return waMonthWaterDataDao.getWaListByEntity(entity);
	}

	/**
	 * 读取excel文件
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public String doReadXls(InputStream is) throws Exception{
		String result = "success";//返回结果标识
		try {
			HSSFWorkbook workBook = new HSSFWorkbook(is);
			HSSFSheet sheet = workBook.getSheetAt(0);

			for (int rowNum = 1;rowNum <= sheet.getLastRowNum();rowNum++) {
				HSSFRow row = sheet.getRow(rowNum);
				WaMonthWaterData waMonthWaterEntity = new WaMonthWaterData();
				if (row != null) {
					if(StringUtil.isEmpty(ExcelUtil.getCellValue(row.getCell(0)))){
						continue;
					}
					WaCompanyInfo com = new WaCompanyInfo();
					String companyCode = ExcelUtil.getCellValue(row.getCell(0));
					com.setCompanyCode(companyCode);
					WaCompanyInfo resultCom = waCompanyInfoDao.getEntityByCode(com);
					if (StringUtil.isNull(resultCom)){
						LOG.error("row is["+rowNum+"], companyCode ["+companyCode+"] is not exit");
						result = "第" + (rowNum+1) + "行，节水代码为 " + companyCode + " 的单位信息不存在，请修改";
						return result;
					}

					//根据code获取id后存入mysql
					waMonthWaterEntity.setCompanyId(String.valueOf(resultCom.getCompanyId()));
					waMonthWaterEntity.setMonthDate(ExcelUtil.getCellValue(row.getCell(2)));

					try {
//						waMonthWaterEntity.setActMonthWater(df.format(Float.parseFloat((StringUtils.isBlank(row.getCell(3).toString()))? "0": row.getCell(3).toString()))); //df.format(Float.parseFloat(
						waMonthWaterEntity.setActResidentWater(df.format(Float.parseFloat((StringUtils.isBlank(row.getCell(3).toString()))? "0": row.getCell(3).toString())));
						waMonthWaterEntity.setActNoResidentWater(df.format(Float.parseFloat((StringUtils.isBlank(row.getCell(4).toString()))? "0": row.getCell(4).toString())));
						waMonthWaterEntity.setActEducationWater(df.format(Float.parseFloat((StringUtils.isBlank(row.getCell(5).toString()))? "0": row.getCell(5).toString())));
						waMonthWaterEntity.setActSpecialTradeWater(df.format(Float.parseFloat((StringUtils.isBlank(row.getCell(6).toString()))? "0": row.getCell(6).toString())));
					}catch (Exception e){
						LOG.error("row is["+rowNum+"], companyCode ["+companyCode+"] is not exit");
						result = "第" + (rowNum+1) + "行，月实际用水量有问题，请修改";
						return result;
					}

					WaMonthWaterData tmp = new WaMonthWaterData();
					tmp.setCompanyId(waMonthWaterEntity.getCompanyId());
					tmp.setMonthDate(waMonthWaterEntity.getMonthDate());
					tmp.setIsDelte(0);
					WaMonthWaterData resultTmp = waMonthWaterDataDao.getWaListByEntity(tmp);
					if(null != resultTmp){  //判断当前单位当月数据是否已存在,存在即先删除在录入
//						resultTmp.setActMonthWater(waMonthWaterEntity.getActMonthWater());
						resultTmp.setActResidentWater(waMonthWaterEntity.getActResidentWater());
						resultTmp.setActNoResidentWater(waMonthWaterEntity.getActNoResidentWater());
						resultTmp.setActEducationWater(waMonthWaterEntity.getActEducationWater());
						resultTmp.setActSpecialTradeWater(waMonthWaterEntity.getActSpecialTradeWater());

//						float planWaterAmount = Float.valueOf(StringUtil.isEmpty(resultTmp.getPlanMonthWater())? "0": resultTmp.getPlanMonthWater());
//						float actWaterAmount = Float.valueOf(StringUtil.isEmpty(resultTmp.getActMonthWater())? "0": resultTmp.getActMonthWater());

						float planResidentAmount = Float.valueOf(StringUtil.isEmpty(resultTmp.getPlanResidentWater())? "0": resultTmp.getPlanResidentWater());
						float planNoResidentAmount = Float.valueOf(StringUtil.isEmpty(resultTmp.getPlanNoResidentWater())? "0": resultTmp.getPlanNoResidentWater());
						float planEduationAmount = Float.valueOf(StringUtil.isEmpty(resultTmp.getPlanEducationWater())? "0": resultTmp.getPlanEducationWater());
						float planSpecialAmount = Float.valueOf(StringUtil.isEmpty(resultTmp.getPlanSpecialTradeWater())? "0": resultTmp.getPlanSpecialTradeWater());

						float actResidentAmount = Float.valueOf(StringUtil.isEmpty(resultTmp.getActResidentWater())? "0": resultTmp.getActResidentWater());
						float actNoResidentAmount = Float.valueOf(StringUtil.isEmpty(resultTmp.getActNoResidentWater())? "0": resultTmp.getActNoResidentWater());
						float actEduationAmount = Float.valueOf(StringUtil.isEmpty(resultTmp.getActEducationWater())? "0": resultTmp.getActEducationWater());
						float actSpecialAmount = Float.valueOf(StringUtil.isEmpty(resultTmp.getActSpecialTradeWater())? "0": resultTmp.getActSpecialTradeWater());

					/*	float beyondResidentAmount = actResidentAmount - planResidentAmount;
						float beyondNoResidentAmount = actNoResidentAmount - planNoResidentAmount;
						float beyondEduationAmount = actEduationAmount - planEduationAmount;
						float beyondSpecialAmount = actSpecialAmount - planSpecialAmount;


						String beyondResidentResult = beyondResidentAmount<0? "0" : String.valueOf(beyondResidentAmount);
						String beyondNoResidentResult = beyondNoResidentAmount<0? "0" : String.valueOf(beyondNoResidentAmount);
						String beyondEduationResult = beyondEduationAmount<0? "0" : String.valueOf(beyondEduationAmount);
						String beyondSpecialResult = beyondSpecialAmount<0? "0" : String.valueOf(beyondSpecialAmount);

						waMonthWaterData.setBeyondResidentWater(beyondResidentResult);
						waMonthWaterData.setBeyondNoResidentWater(beyondNoResidentResult);
						waMonthWaterData.setBeyondEducationWater(beyondEduationResult);
						waMonthWaterData.setBeyondSpecialTradeWater(beyondSpecialResult);*/


//						resultTmp.setFeeStandard(getBeyondFee(actWaterAmount, planWaterAmount));  //获取收费标准
						resultTmp.setFeeResidentWater(getBeyondFee(actResidentAmount, planResidentAmount));  //获取收费标准
						resultTmp.setFeeNoResidentWater(getBeyondFee(actNoResidentAmount, planNoResidentAmount));
						resultTmp.setFeeEducationWater(getBeyondFee(actEduationAmount, planEduationAmount));
						resultTmp.setFeeSpecialTradeWater(getBeyondFee(actSpecialAmount, planSpecialAmount));

//						String beyondAmount = (actWaterAmount - planWaterAmount)>=0 ? df.format(actWaterAmount - planWaterAmount): "0";
						String beyondResidentAmount = (actResidentAmount - planResidentAmount)>=0 ? df.format(actResidentAmount - planResidentAmount): "0";
						String beyondNoResidentAmount = (actNoResidentAmount - planNoResidentAmount)>=0 ? df.format(actNoResidentAmount - planNoResidentAmount): "0";
						String beyondEduationAmount = (actEduationAmount - planEduationAmount)>=0 ? df.format(actEduationAmount - planEduationAmount): "0";
						String beyondSpecialAmount = (actSpecialAmount - planSpecialAmount)>=0 ? df.format(actSpecialAmount - planSpecialAmount): "0";

						float beyondResidentAmount1 = actResidentAmount - planResidentAmount;
						float beyondNoResidentAmount1 = actNoResidentAmount - planNoResidentAmount;
						float beyondEduationAmount1 = actEduationAmount - planEduationAmount;
						float beyondSpecialAmount1 = actSpecialAmount - planSpecialAmount;

//						String isoverroof = (actWaterAmount - planWaterAmount)>=0 ? "1" : "0";
						if (beyondResidentAmount1 > 0){  //计划<实际则超标
							resultTmp.setIsOverResidentWater("1");
						}
						if (beyondNoResidentAmount1 > 0){  //计划<实际则超标
							resultTmp.setIsOverNoResidentWater("1");
						}
						if (beyondEduationAmount1 > 0){  //计划<实际则超标
							resultTmp.setIsOverEducationWater("1");
						}
						if (beyondSpecialAmount1 > 0){  //计划<实际则超标
							resultTmp.setIsOverSpecialTradeWater("1");
						}

						resultTmp.setBeyondResidentWater(beyondResidentAmount);
						resultTmp.setBeyondNoResidentWater(beyondNoResidentAmount);
						resultTmp.setBeyondEducationWater(beyondEduationAmount);
						resultTmp.setBeyondEducationWater(beyondSpecialAmount);
//						resultTmp.setBeyondAmount(beyondAmount);
//						resultTmp.setIsOverroof(isoverroof);
						waMonthWaterDataDao.update(resultTmp);
					}else {
						//不存在则新增
						waMonthWaterEntity.setIsDelte(0);
						waMonthWaterEntity.setCrtTime(new Date());
						waMonthWaterEntity.setUpdTime(new Date());
						waMonthWaterDataDao.save(waMonthWaterEntity);
					}

				}
			}

		}catch (Exception e){
			LOG.error("act water error==" + e);
			return "实际用水数据导入失败，请重新操作";
		}
		return result;
	}

	public String insertTagFile(MultipartFile file){
		try {
			return insertXlsContnetList(file.getInputStream());
		}catch (Exception e){
			LOG.error("获取数据出错", e);
			return "获取数据失败";
		}
	}

	/**
	 * 获取实体类
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public String insertXlsContnetList(InputStream is) throws Exception{
		String result = "success";
		try {
			HSSFWorkbook workBook = new HSSFWorkbook(is);
			HSSFSheet sheet = workBook.getSheetAt(0);

			for (int rowNum = 1;rowNum <= sheet.getLastRowNum();rowNum++) {
				WaMonthWaterData waMonthWaterEntity = new WaMonthWaterData();
				HSSFRow row = sheet.getRow(rowNum);
				if (row != null) {
					if(StringUtil.isEmpty(ExcelUtil.getCellValue(row.getCell(0)))){
						continue;
					}
					WaCompanyInfo com = new WaCompanyInfo();
					com.setCompanyCode(ExcelUtil.getCellValue(row.getCell(0)));
					WaCompanyInfo resultCom = waCompanyInfoDao.getEntityByCode(com);
					//根据code获取id后存入mysql
					if (StringUtil.isNull(resultCom)){
						LOG.error("get company is null, companycode = " + com.getCompanyCode());
						return "第" + (rowNum+1) +"行，节水代码为" + com.getCompanyCode() + "单位信息不存在，请重新输入";
					}

					waMonthWaterEntity.setCompanyId(String.valueOf(resultCom.getCompanyId()));
					waMonthWaterEntity.setMonthDate(ExcelUtil.getCellValue(row.getCell(2)));
					waMonthWaterEntity.setIsDelte(0);
					String planRedientWater="", planNoRedientWwater="", planEducationWater="", planSpecialWater = "";
					try {
						planRedientWater = df.format(Float.parseFloat((StringUtils.isBlank(row.getCell(3).toString()))? "0": row.getCell(3).toString()));
						planNoRedientWwater = df.format(Float.parseFloat((StringUtils.isBlank(row.getCell(4).toString()))? "0": row.getCell(4).toString()));
						planEducationWater = df.format(Float.parseFloat((StringUtils.isBlank(row.getCell(5).toString()))? "0": row.getCell(5).toString()));
						planSpecialWater = df.format(Float.parseFloat((StringUtils.isBlank(row.getCell(6).toString()))? "0": row.getCell(6).toString()));

					}catch (Exception e){
						LOG.error("next month planwater error " + e);
						return  "第" + (rowNum+1) +"行，节水代码为" + com.getCompanyCode() + "的计划用水量有问题，请重新输入";
					}

					//根据条件查询是否存在*单位 *月份 的信息
					WaMonthWaterData checkData = getWaMonthWaterDataById(waMonthWaterEntity);
					if(null != checkData){ //存在
						waMonthWaterEntity.setMonthWaterId(checkData.getMonthWaterId());
//						waMonthWaterEntity.setActMonthWater(checkData.getActMonthWater());
//						waMonthWaterEntity.setPlanMonthWater(planMonthWater);  //新增计划用水
						waMonthWaterEntity.setActResidentWater(checkData.getActResidentWater());
						waMonthWaterEntity.setActNoResidentWater(checkData.getActNoResidentWater());
						waMonthWaterEntity.setActEducationWater(checkData.getActEducationWater());
						waMonthWaterEntity.setActSpecialTradeWater(checkData.getActSpecialTradeWater());

//						waMonthWaterEntity.setPlanMonthWater(planMonthWater);  //新增计划用水
						waMonthWaterEntity.setPlanResidentWater(planRedientWater);
						waMonthWaterEntity.setPlanNoResidentWater(planNoRedientWwater);
						waMonthWaterEntity.setPlanEducationWater(planEducationWater);
						waMonthWaterEntity.setPlanSpecialTradeWater(planSpecialWater);
						//存在情况下更新

						updateWaMonthWaterData(waMonthWaterEntity, "");
					}else {
						//不存在情况下新增
//						waMonthWaterEntity.setPlanMonthWater(planMonthWater);  //读取新增计划用水
						waMonthWaterEntity.setPlanResidentWater(planRedientWater);
						waMonthWaterEntity.setPlanNoResidentWater(planNoRedientWwater);
						waMonthWaterEntity.setPlanEducationWater(planEducationWater);
						waMonthWaterEntity.setPlanSpecialTradeWater(planSpecialWater);
						///新增数据入库
//						waMonthWaterEntity.setIsOverroof("0");
						waMonthWaterEntity.setIsDelte(0);
//						waMonthWaterEntity.setCrtTime(new Date());
//						waMonthWaterEntity.setUpdTime(new Date());
						waMonthWaterDataDao.save(waMonthWaterEntity);
					}
				}
			}
		}catch (Exception e){
			LOG.error("next planwater error>>" + e);
			return "批量录入下月计划用水失败";
		}
		return result;
	}

}
