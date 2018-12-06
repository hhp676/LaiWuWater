<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>详细页面</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true" id="waCompanyWaterDataNew_edit_layout">
    <div data-options="region:'west'" style="">
        <form id="waCompanyWaterDataNew_edit_form"  name="waCompanyWaterDataNew_edit_form" class="hgform">
            <table fit=true name="waCompanyWaterDataNew_edit_Tab" id="waCompanyWaterDataNew_edit_Tab" singleSelect=false fitColumns=true>
                <thead>
                <input type="hidden"   name="companyWaterId" value="${companyWaterId}" id="companyWaterId"></input>
                <tr>
                    <td width="130px;">单位名称<font>*</font>:</td>
                    <td>
                        <select name="companyId" style="width: 170px">
                            <c:forEach var="companyDataItem" items="${companyData}">
                                <option value="${companyDataItem.key}" <c:if test="${waCompanyWaterDataNew.companyId==companyDataItem.key}">selected</c:if>>${companyDataItem.value}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="130px;">主产品名称<font>*</font>:</td>
                    <td><input type="text"   name="productName" value="${waCompanyWaterDataNew.productName}" id="productName"></input></td>
                </tr>
                <tr>
                    <td width="130px;">单位产品新水量m3/单位产品<font>*</font>:</td>
                    <td><input type="text"   name="newWaterCount" value="${waCompanyWaterDataNew.newWaterCount}" id="newWaterCount"></input></td>
                </tr>
                <tr>
                    <td width="130px;">全年产量<font>*</font>:</td>
                    <td><input type="text"   name="totalCount" value="${waCompanyWaterDataNew.totalCount}" id="totalCount"></input></td>
                </tr> <tr>
                    <td width="130px;">行业用水标准<font>*</font>:</td>
                    <td><input type="text"   name="waterStandard" value="${waCompanyWaterDataNew.waterStandard}" id="waterStandard"></input></td>
                </tr> <tr>
                    <td width="130px;">从业人员（人）<font>*</font>:</td>
                    <td><input type="text"   name="employee" value="${waCompanyWaterDataNew.employee}" id="employee"></input></td>
                </tr><tr>
                    <td width="130px;">工业新水量m3<font>*</font>:</td>
                    <td><input type="text"   name="gongyeWaterCount" value="${waCompanyWaterDataNew.gongyeWaterCount}" id="gongyeWaterCount"></input></td>
                </tr><tr>
                    <td width="130px;">工艺新水量<font>*</font>:</td>
                    <td><input type="text"   name="gongyiWaterCount" value="${waCompanyWaterDataNew.gongyiWaterCount}" id="gongyiWaterCount"></input></td>
                </tr><tr>
                    <td width="130px;">锅炉新水量<font>*</font>:</td>
                    <td><input type="text"   name="boilerWater" value="${waCompanyWaterDataNew.boilerWater}" id="boilerWater"></input></td>
                </tr><tr>
                    <td width="130px;">厂内生活水<font>*</font>:</td>
                    <td><input type="text"   name="factoryLiveWater" value="${waCompanyWaterDataNew.factoryLiveWater}" id="factoryLiveWater"></input></td>
                </tr><tr>
                    <td width="130px;">重复利用水量m3<font>*</font>:</td>
                    <td><input type="text"   name="reuseTotalAmount" value="${waCompanyWaterDataNew.reuseTotalAmount}" id="reuseTotalAmount"></input></td>
                </tr><tr>
                    <td width="130px;">利用率（%）<font>*</font>:</td>
                    <td><input type="text"   name="availability" value="${waCompanyWaterDataNew.availability}" id="availability"></input></td>
                </tr><tr>
                    <td width="130px;">间冷水循环量<font>*</font>:</td>
                    <td><input type="text"   name="interColdWaterLoopAmount" value="${waCompanyWaterDataNew.interColdWaterLoopAmount}" id="interColdWaterLoopAmount"></input></td>
                </tr><tr>
                    <td width="130px;">循环率（%）<font>*</font>:</td>
                    <td><input type="text"   name="circulRate" value="${waCompanyWaterDataNew.circulRate}" id="circulRate"></input></td>
                </tr><tr>
                    <td width="130px;">回用水量<font>*</font>:</td>
                    <td><input type="text"   name="freshWaterBackAmount" value="${waCompanyWaterDataNew.freshWaterBackAmount}" id="freshWaterBackAmount"></input></td>
                </tr><tr>
                    <td width="130px;">蒸气冷凝水回用量<font>*</font>:</td>
                    <td><input type="text"   name="steamCondenBackAmount" value="${waCompanyWaterDataNew.steamCondenBackAmount}" id="steamCondenBackAmount"></input></td>
                </tr><tr>
                    <td width="130px;">回用率（%）<font>*</font>:</td>
                    <td><input type="text"   name="recoverRate" value="${waCompanyWaterDataNew.recoverRate}" id="recoverRate"></input></td>
                </tr><tr>
                    <td width="130px;">节水量<font>*</font>:</td>
                    <td><input type="text"   name="saveAmount" value="${waCompanyWaterDataNew.saveAmount}" id="saveAmount"></input></td>
                </tr><tr>
                    <td width="130px;">节水设施投资（万元）<font>*</font>:</td>
                    <td><input type="text"   name="installMoney" value="${waCompanyWaterDataNew.installMoney}" id="installMoney"></input></td>
                </tr><tr>
                    <td width="130px;"> 用水计划卡号<font>*</font>:</td>
                    <td><input type="text"   name="waterPlanNo" value="${waCompanyWaterDataNew.waterPlanNo}" id="waterPlanNo"></input></td>
                </tr><%--<tr>
                    <td width="130px;">填报人<font>*</font>:</td>
                    <td><input type="text"   name="writePerson" value="${waCompanyWaterDataNew.writePerson}" id="writePerson"></input></td>
                </tr><tr>
                    <td width="130px;">填报时间<font>*</font>:</td>
                    <td><input type="text"   name="writeTime" value="${waCompanyWaterDataNew.writeTime}" id="writeTime"></input></td>
                </tr>--%>
                </thead>
            </table>
        </form>
    </div>
    <div data-options="region:'south',border:false" style="text-align: right; padding: 5px 5px 5px; background-color: #e0e0e0;">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" tag="ok">保存</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" tag="cancel">取消</a>
    </div>
</div>
<script type="text/javascript">
    var companyWaterId = "${companyWaterId}";
</script>
<script type="text/javascript" src="${ctx}/static/js/wa/waCompanyInfo/waterExamen/waCompanyWaterDataNew_edit.js"></script>
</body>
</html>
