/*
 * Project Name:hbm-base.
 * File Name:WaInterwaterInstallationTableController.java
 * Package Name:com.hongguaninfo.hgdf.bud.web.wa
 * Date:2018年11月26日 下午9:43:51
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.web.waCompanyInfo;

import com.hongguaninfo.hgdf.adp.core.aop.log.UserLog;
import com.hongguaninfo.hgdf.adp.core.base.BasePage;
import com.hongguaninfo.hgdf.adp.core.exception.BizException;
import com.hongguaninfo.hgdf.adp.core.templete.HttpTemplete;
import com.hongguaninfo.hgdf.adp.core.templete.OperateTemplete;
import com.hongguaninfo.hgdf.core.utils.exception.BaseException;
import com.hongguaninfo.hgdf.core.utils.logging.Log;
import com.hongguaninfo.hgdf.core.utils.logging.LogFactory;
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaInterwaterInstallationTable;
import com.hongguaninfo.hgdf.wa.service.WaCompanyInfoService;
import com.hongguaninfo.hgdf.wa.service.waCompanyInfo.WaInterwaterInstallationTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;


/**
 * WaInterwaterInstallationTableController:。 <br />
 * controller 层 <br />
 * Date:2018年11月26日 下午9:43:51
 *
 * @author hhp
 * @since V1.0.0
 */
@Controller
@RequestMapping("/wa/WaInterwaterInstallationTable")
public class WaInterwaterInstallationTableController {

    /**
     *
     */
    private static final Log LOG = LogFactory.getLog(WaInterwaterInstallationTableController.class);

    /**
     * Service。
     */
    @Autowired
    private WaInterwaterInstallationTableService waInterwaterInstallationTableService;

    @Autowired
    private WaCompanyInfoService waCompanyInfoService;
    /**
	 * REMARK
	 * 列表页面。
	 * @param response
	 * @param request
	 */
	@RequestMapping("/showWaInterwaterInstallationTable")
	public String showWaInterwaterInstallationTable (HttpServletRequest request, HttpServletResponse response, Model model) {
		OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BaseException {
                str = "wa/waCompanyInfo/waInterWater/waInterwaterInstallationTable_show";
            }
        };
        return templete.operateModel();
	}
    /**
    * 分页数据。
    * @WaInterwaterInstallationTable
    * @return 
    */
	@RequestMapping("/list")
    @ResponseBody
    public Map getWaInterwaterInstallationTableList (final WaInterwaterInstallationTable waInterwaterInstallationTable , final BasePage pageRequest,
                                                     HttpServletResponse response, HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
                waInterwaterInstallationTableService.getWaInterwaterInstallationTableList(pageRequest, waInterwaterInstallationTable, map);
            }
        };
        return templete.operate();
    }
    /**
	 * REMARK
	 *
	 * 新增
	 */
    @RequestMapping("/add")
    @ResponseBody
//    @RepeatSubmitToken(removeToken = true)
    @UserLog(code = "addWaInterwaterInstallationTable", name = "add WaInterwaterInstallationTable", remarkClass = WaInterwaterInstallationTable.class)
    public Map addWaInterwaterInstallationTable (@Valid final WaInterwaterInstallationTable vo, BindingResult result,
            HttpServletResponse response, final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request, result) {
            protected void doSomething() throws BizException {
                if (doValidate()) {
                    waInterwaterInstallationTableService.addWaInterwaterInstallationTable(vo);
                }
            }
        };
        return templete.operate();
    }

	/**
	 * REMARK
	 *
	 * 修改
	 */
    @RequestMapping("/update")
    @ResponseBody
    @UserLog(code = "editWaInterwaterInstallationTable", name = "update WaInterwaterInstallationTable", remarkClass = WaInterwaterInstallationTable.class)
    public Map editWaInterwaterInstallationTable (final WaInterwaterInstallationTable vo, HttpServletResponse response,
            final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
				waInterwaterInstallationTableService.updateWaInterwaterInstallationTable(vo);    
            }
        };
        return templete.operate();
    }
    /**
	 * REMARK
	 * 删除
	 * Through the id delete a data
	 */
    @RequestMapping("/delete")
    @ResponseBody
    @UserLog(code = "deleteWaInterwaterInstallationTable", name = "delete WaInterwaterInstallationTable", remarkClass = Integer.class)
    public Map deleteWaInterwaterInstallationTable (final Integer id, HttpServletResponse response,
            final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
            	waInterwaterInstallationTableService.deleteWaInterwaterInstallationTableLogic(id);    
            }
        };
        return templete.operate();
    }

	/**
	 * REMARK
	 * 详情信息
	 * Through the id inquires the out a data
	 */
	@RequestMapping(value = "/waInterwaterInstallationTableDetail/{interwaterId}")
	public String showWaInterwaterInstallationTableDetail (@PathVariable int interwaterId,
            HttpServletRequest request, HttpServletResponse response,
            Model model) throws BizException {
        model.addAttribute("interwaterId", interwaterId);
        model.addAttribute("companyData", waCompanyInfoService.getComPanyMap());
        model.addAttribute("waInterWaterData",
         waInterwaterInstallationTableService.getWaInterwaterInstallationTableById(interwaterId));
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BaseException {
                 str = "wa/waCompanyInfo/waInterWater/waInterwaterInstallationTable_detail";
            }
        };
        return templete.operateModel();
    }
}
