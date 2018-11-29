/*
 * Project Name:hbm-base.
 * File Name:WaCompanyWaterDataNewController.java
 * Package Name:com.hongguaninfo.hgdf.bud.web.wa
 * Date:2018年11月24日 下午11:56:23
 * Copyright (c) 2016, hongguaninfo.com All Rights Reserved.
 *
 */
package com.hongguaninfo.hgdf.wa.web;

import com.hongguaninfo.hgdf.adp.core.aop.log.UserLog;
import com.hongguaninfo.hgdf.adp.core.base.BasePage;
import com.hongguaninfo.hgdf.adp.core.exception.BizException;
import com.hongguaninfo.hgdf.adp.core.interceptor.RepeatSubmitToken;
import com.hongguaninfo.hgdf.adp.core.templete.HttpTemplete;
import com.hongguaninfo.hgdf.adp.core.templete.OperateTemplete;
import com.hongguaninfo.hgdf.core.utils.exception.BaseException;
import com.hongguaninfo.hgdf.core.utils.logging.Log;
import com.hongguaninfo.hgdf.core.utils.logging.LogFactory;
import com.hongguaninfo.hgdf.wa.entity.WaCompanyWaterDataNew;
import com.hongguaninfo.hgdf.wa.service.WaCompanyWaterDataNewService;
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
 * WaCompanyWaterDataNewController:。 <br />
 * controller 层 <br />
 * Date:2018年11月24日 下午11:56:23
 *
 * @author hhp
 * @since V1.0.0
 */
@Controller
@RequestMapping("/wa/WaCompanyWaterDataNew")
public class WaCompanyWaterDataNewController {

    /**
     *
     */
    private static final Log LOG = LogFactory.getLog(WaCompanyWaterDataNewController.class);

    /**
     * Service。
     */
    @Autowired
    private WaCompanyWaterDataNewService waCompanyWaterDataNewService;

    /**
	 * REMARK
	 * 列表页面。
	 * @param response
	 * @param request
	 */
	@RequestMapping("/showWaCompanyWaterDataNew")
	public String showWaCompanyWaterDataNew (HttpServletRequest request, HttpServletResponse response, Model model) {
		OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BaseException {
                str = "wa/waCompanyInfo/waterExamen/waCompanyWaterDataNew_show";
            }
        };
        return templete.operateModel();
	}
    /**
    * 分页数据。
    * @WaCompanyWaterDataNew
    * @return 
    */
	@RequestMapping("/list")
    @ResponseBody
    public Map getWaCompanyWaterDataNewList (final WaCompanyWaterDataNew waCompanyWaterDataNew , final BasePage pageRequest,
                                             HttpServletResponse response, HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
                waCompanyWaterDataNewService.getWaCompanyWaterDataNewList(pageRequest, waCompanyWaterDataNew, map);
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
    @UserLog(code = "addWaCompanyWaterDataNew", name = "add WaCompanyWaterDataNew", remarkClass = WaCompanyWaterDataNew.class)
    public Map addWaCompanyWaterDataNew (@Valid final WaCompanyWaterDataNew vo, BindingResult result,
            HttpServletResponse response, final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request, result) {
            protected void doSomething() throws BizException {
                if (doValidate()) {
                    waCompanyWaterDataNewService.addWaCompanyWaterDataNew(vo);
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
    @UserLog(code = "editWaCompanyWaterDataNew", name = "update WaCompanyWaterDataNew", remarkClass = WaCompanyWaterDataNew.class)
    public Map editWaCompanyWaterDataNew (final WaCompanyWaterDataNew vo, HttpServletResponse response,
            final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
				waCompanyWaterDataNewService.updateWaCompanyWaterDataNew(vo);    
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
    @UserLog(code = "deleteWaCompanyWaterDataNew", name = "delete WaCompanyWaterDataNew", remarkClass = Integer.class)
    public Map deleteWaCompanyWaterDataNew (final Integer id, HttpServletResponse response,
            final HttpServletRequest request) {
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BizException {
            	waCompanyWaterDataNewService.deleteWaCompanyWaterDataNewLogic(id);    
            }
        };
        return templete.operate();
    }

	/**
	 * REMARK
	 * 详情信息
	 * Through the id inquires the out a data
	 */
	@RequestMapping(value = "/waCompanyWaterDataNewDetail/{id}")
	public String showWaCompanyWaterDataNewDetail (@PathVariable int id,
            HttpServletRequest request, HttpServletResponse response,
            Model model) throws BizException {
        model.addAttribute("companyWaterId", id);
        model.addAttribute("waCompanyWaterDataNew",
         waCompanyWaterDataNewService.getWaCompanyWaterDataNewById(id));
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BaseException {
                 str = "wa/waCompanyInfo/waterExamen/waCompanyWaterDataNew_detail";
            }
        };
        return templete.operateModel();
    }

   /* *//**
     * REMARK
     * 修改信息
     * Through the id inquires the out a data
     *//*
    @RequestMapping(value = "/waCompanyWaterDataEdit/{id}")
    public String showWaCompanyWaterDataEdit (@PathVariable int id,
                                                   HttpServletRequest request, HttpServletResponse response,
                                                   Model model) throws BizException {
        model.addAttribute("companyWaterId", id);
        model.addAttribute("waCompanyWaterDataNew",
                waCompanyWaterDataNewService.getWaCompanyWaterDataNewById(id));
        OperateTemplete templete = new HttpTemplete(request) {
            protected void doSomething() throws BaseException {
                str = "wa/waCompanyInfo/waterExamen/waCompanyWaterDataNew_detail";
            }
        };
        return templete.operateModel();
    }*/
}
