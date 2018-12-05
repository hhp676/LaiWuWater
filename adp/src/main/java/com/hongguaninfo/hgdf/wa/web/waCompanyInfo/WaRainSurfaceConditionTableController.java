/*
 * Project Name:hbm-base.
 * File Name:WaRainSurfaceConditionTableController.java
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
import com.hongguaninfo.hgdf.wa.entity.waCompanyInfo.WaRainSurfaceConditionTable;
import com.hongguaninfo.hgdf.wa.service.WaCompanyInfoService;
import com.hongguaninfo.hgdf.wa.service.waCompanyInfo.WaRainSurfaceConditionTableService;
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
 * WaRainSurfaceConditionTableController:。 <br />
 * controller 层 <br />
 * Date:2018年11月26日 下午9:43:51
 *
 * @author hhp
 * @since V1.0.0
 */
@Controller
@RequestMapping("/wa/WaRainSurfaceConditionTable")
public class WaRainSurfaceConditionTableController {

    /**
     *
     */
    private static final Log LOG = LogFactory.getLog(WaRainSurfaceConditionTableController.class);

    /**
     * Service。
     */
    @Autowired
    private WaRainSurfaceConditionTableService waRainSurfaceConditionTableService;
    @Autowired
    private WaCompanyInfoService waCompanyInfoService;
    /**
	 * REMARK
	 * 列表页面。
	 * @param response
	 * @param request
	 */
	@RequestMapping("/showWaRainSurfaceConditionTable")
	public String showWaRainSurfaceConditionTable (HttpServletRequest request, HttpServletResponse response, Model model) {
		OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BaseException {
                str = "wa/waCompanyInfo/WaRainSurface/waRainSurfaceConditionTable_show";
            }
        };
        return templete.operateModel();
	}
    /**
    * 分页数据。
    * @WaRainSurfaceConditionTable
    * @return 
    */
	@RequestMapping("/list")
    @ResponseBody
    public Map getWaRainSurfaceConditionTableList (final WaRainSurfaceConditionTable waRainSurfaceConditionTable , final BasePage pageRequest,
                                                   HttpServletResponse response, HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
                waRainSurfaceConditionTableService.getWaRainSurfaceConditionTableList(pageRequest, waRainSurfaceConditionTable, map);
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
    @UserLog(code = "addWaRainSurfaceConditionTable", name = "add WaRainSurfaceConditionTable", remarkClass = WaRainSurfaceConditionTable.class)
    public Map addWaRainSurfaceConditionTable (@Valid final WaRainSurfaceConditionTable vo, BindingResult result,
            HttpServletResponse response, final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request, result) {
            protected void doSomething() throws BizException {
                if (doValidate()) {
                    waRainSurfaceConditionTableService.addWaRainSurfaceConditionTable(vo);
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
    @UserLog(code = "editWaRainSurfaceConditionTable", name = "update WaRainSurfaceConditionTable", remarkClass = WaRainSurfaceConditionTable.class)
    public Map editWaRainSurfaceConditionTable (final WaRainSurfaceConditionTable vo, HttpServletResponse response,
            final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
				waRainSurfaceConditionTableService.updateWaRainSurfaceConditionTable(vo);    
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
    @UserLog(code = "deleteWaRainSurfaceConditionTable", name = "delete WaRainSurfaceConditionTable", remarkClass = Integer.class)
    public Map deleteWaRainSurfaceConditionTable (final Integer id, HttpServletResponse response,
            final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
            	waRainSurfaceConditionTableService.deleteWaRainSurfaceConditionTableLogic(id);    
            }
        };
        return templete.operate();
    }

	/**
	 * REMARK
	 * 详情信息
	 * Through the id inquires the out a data
	 */
	@RequestMapping(value = "/waRainSurfaceConditionTableDetail/{id}")
	public String showWaRainSurfaceConditionTableDetail (@PathVariable int id,
            HttpServletRequest request, HttpServletResponse response,
            Model model) throws BizException {
        model.addAttribute("rainSurfaceId", id);
        model.addAttribute("companyData", waCompanyInfoService.getComPanyMap());
        model.addAttribute("waRainSurfaceData",
         waRainSurfaceConditionTableService.getWaRainSurfaceConditionTableById(id));
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BaseException {
                 str = "wa/waCompanyInfo/WaRainSurface/waRainSurfaceConditionTable_detail";
            }
        };
        return templete.operateModel();
    }
}
