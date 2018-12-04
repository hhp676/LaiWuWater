/*
 * Project Name:hbm-base.
 * File Name:WaPlanConditionTableController.java
 * Package Name:com.hongguaninfo.hgdf.bud.web.wa
 * Date:2018年11月26日 下午9:43:51
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.web.waCompanyInfo;

import com.hongguaninfo.hgdf.adp.core.aop.log.UserLog;
import com.hongguaninfo.hgdf.adp.core.base.BasePage;
import com.hongguaninfo.hgdf.adp.core.exception.BizException;
import com.hongguaninfo.hgdf.adp.core.interceptor.RepeatSubmitToken;
import com.hongguaninfo.hgdf.adp.core.templete.HttpTemplete;
import com.hongguaninfo.hgdf.adp.core.templete.OperateTemplete;
import com.hongguaninfo.hgdf.core.utils.exception.BaseException;
import com.hongguaninfo.hgdf.core.utils.logging.Log;
import com.hongguaninfo.hgdf.core.utils.logging.LogFactory;
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaPlanConditionTable;
import com.hongguaninfo.hgdf.wa.service.WaCompanyInfoService;
import com.hongguaninfo.hgdf.wa.service.waCompanyInfo.WaPlanConditionTableService;
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
 * WaPlanConditionTableController:。 <br />
 * controller 层 <br />
 * Date:2018年11月26日 下午9:43:51
 *
 * @author hhp
 * @since V1.0.0
 */
@Controller
@RequestMapping("/wa/WaPlanConditionTable")
public class WaPlanConditionTableController {

    private static final Log LOG = LogFactory.getLog(WaPlanConditionTableController.class);

    /**
     * Service。
     */
    @Autowired
    private WaPlanConditionTableService waPlanConditionTableService;

    @Autowired
    private WaCompanyInfoService waCompanyInfoService;

    /**
	 * REMARK
	 * 列表页面。
	 * @param response
	 * @param request
	 */
	@RequestMapping("/showWaPlanConditionTable")
	public String showWaPlanConditionTable (HttpServletRequest request, HttpServletResponse response, Model model) {
		OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BaseException {
                str = "wa/waCompanyInfo/WaPlanCondition/waPlanConditionTable_show";
            }
        };
        return templete.operateModel();
	}
    /**
    * 分页数据。
    * @WaPlanConditionTable
    * @return 
    */
	@RequestMapping("/list")
    @ResponseBody
    public Map getWaPlanConditionTableList (final WaPlanConditionTable waPlanConditionTable , final BasePage pageRequest,
                                            HttpServletResponse response, HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
                waPlanConditionTableService.getWaPlanConditionTableList(pageRequest, waPlanConditionTable, map);
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
    @RepeatSubmitToken(removeToken = true)
    @UserLog(code = "addWaPlanConditionTable", name = "add WaPlanConditionTable", remarkClass = WaPlanConditionTable.class)
    public Map addWaPlanConditionTable (@Valid final WaPlanConditionTable vo, BindingResult result,
            HttpServletResponse response, final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request, result) {
            protected void doSomething() throws BizException {
                if (doValidate()) {
                    waPlanConditionTableService.addWaPlanConditionTable(vo);
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
    @UserLog(code = "editWaPlanConditionTable", name = "update WaPlanConditionTable", remarkClass = WaPlanConditionTable.class)
    public Map editWaPlanConditionTable (final WaPlanConditionTable vo, HttpServletResponse response,
            final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
				waPlanConditionTableService.updateWaPlanConditionTable(vo);    
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
    @UserLog(code = "deleteWaPlanConditionTable", name = "delete WaPlanConditionTable", remarkClass = Integer.class)
    public Map deleteWaPlanConditionTable (final Integer id, HttpServletResponse response,
            final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
            	waPlanConditionTableService.deleteWaPlanConditionTableLogic(id);    
            }
        };
        return templete.operate();
    }

	/**
	 * REMARK
	 * 详情信息
	 * Through the id inquires the out a data
	 */
	@RequestMapping(value = "/waPlanConditionTableDetail/{id}")
	public String showWaPlanConditionTableDetail (@PathVariable int id,
            HttpServletRequest request, HttpServletResponse response,
            Model model) throws BizException {
        model.addAttribute("planCondtionId", id);
        model.addAttribute("companyData", waCompanyInfoService.getComPanyMap());
        model.addAttribute("waPlanConditionData",
         waPlanConditionTableService.getWaPlanConditionTableById(id));
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BaseException {
                 str = "wa/waCompanyInfo/WaPlanCondition/waPlanConditionTable_detail";
            }
        };
        return templete.operateModel();
    }
}
