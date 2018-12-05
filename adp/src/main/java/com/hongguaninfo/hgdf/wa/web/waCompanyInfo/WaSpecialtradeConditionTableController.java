/*
 * Project Name:hbm-base.
 * File Name:WaSpecialtradeConditionTableController.java
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
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaSpecialtradeConditionTable;
import com.hongguaninfo.hgdf.wa.service.WaCompanyInfoService;
import com.hongguaninfo.hgdf.wa.service.waCompanyInfo.WaSpecialtradeConditionTableService;
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
 * WaSpecialtradeConditionTableController:。 <br />
 * controller 层 <br />
 * Date:2018年11月26日 下午9:43:51
 *
 * @author hhp
 * @since V1.0.0
 */
@Controller
@RequestMapping("/wa/WaSpecialtradeConditionTable")
public class WaSpecialtradeConditionTableController {

    /**
     *
     */
    private static final Log LOG = LogFactory.getLog(WaSpecialtradeConditionTableController.class);

    /**
     * Service。
     */
    @Autowired
    private WaSpecialtradeConditionTableService waSpecialtradeConditionTableService;

    @Autowired
    private WaCompanyInfoService waCompanyInfoService;
    /**
	 * REMARK
	 * 列表页面。
	 * @param response
	 * @param request
	 */
	@RequestMapping("/showWaSpecialtradeConditionTable")
	public String showWaSpecialtradeConditionTable (HttpServletRequest request, HttpServletResponse response, Model model) {
		OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BaseException {
                str = "wa/waCompanyInfo/WaSpecialtrade/waSpecialtradeConditionTable_show";
            }
        };
        return templete.operateModel();
	}
    /**
    * 分页数据。
    * @WaSpecialtradeConditionTable
    * @return 
    */
	@RequestMapping("/list")
    @ResponseBody
    public Map getWaSpecialtradeConditionTableList (final WaSpecialtradeConditionTable waSpecialtradeConditionTable , final BasePage pageRequest,
                                                    HttpServletResponse response, HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
                waSpecialtradeConditionTableService.getWaSpecialtradeConditionTableList(pageRequest, waSpecialtradeConditionTable, map);
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
    @UserLog(code = "addWaSpecialtradeConditionTable", name = "add WaSpecialtradeConditionTable", remarkClass = WaSpecialtradeConditionTable.class)
    public Map addWaSpecialtradeConditionTable (@Valid final WaSpecialtradeConditionTable vo, BindingResult result,
            HttpServletResponse response, final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request, result) {
            protected void doSomething() throws BizException {
                if (doValidate()) {
                    waSpecialtradeConditionTableService.addWaSpecialtradeConditionTable(vo);
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
    @UserLog(code = "editWaSpecialtradeConditionTable", name = "update WaSpecialtradeConditionTable", remarkClass = WaSpecialtradeConditionTable.class)
    public Map editWaSpecialtradeConditionTable (final WaSpecialtradeConditionTable vo, HttpServletResponse response,
            final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
				waSpecialtradeConditionTableService.updateWaSpecialtradeConditionTable(vo);    
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
    @UserLog(code = "deleteWaSpecialtradeConditionTable", name = "delete WaSpecialtradeConditionTable", remarkClass = Integer.class)
    public Map deleteWaSpecialtradeConditionTable (final Integer id, HttpServletResponse response,
            final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
            	waSpecialtradeConditionTableService.deleteWaSpecialtradeConditionTableLogic(id);    
            }
        };
        return templete.operate();
    }

	/**
	 * REMARK
	 * 详情信息
	 * Through the id inquires the out a data
	 */
	@RequestMapping(value = "/waSpecialtradeConditionTableDetail/{id}")
	public String showWaSpecialtradeConditionTableDetail (@PathVariable int id,
            HttpServletRequest request, HttpServletResponse response,
            Model model) throws BizException {
        model.addAttribute("specialId", id);
        model.addAttribute("companyData", waCompanyInfoService.getComPanyMap());
        model.addAttribute("waSpecialtradeData",
         waSpecialtradeConditionTableService.getWaSpecialtradeConditionTableById(id));
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BaseException {
                 str = "wa/waCompanyInfo/WaSpecialtrade/waSpecialtradeConditionTable_detail";
            }
        };
        return templete.operateModel();
    }
}
