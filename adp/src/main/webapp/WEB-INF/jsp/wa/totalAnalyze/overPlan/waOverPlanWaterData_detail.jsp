<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>详细页面</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true" id="waMonthWaterData_layout">
    <div data-options="region:'center'" style="padding: 10 10 10 20px;">
        <form id="waMonthWaterData_form"  class="hgform">
           <input type="hidden" name="monthWaterId" value="${waMonthWaterData.monthWaterId}" id="monthWaterId"></input>
            <table class="hgtable">
                <tr>
                    <td width="130px;">单位名称<font>*</font>:</td>
                    <td>
                        <select name="companyId" style="width: 170px">
                            <c:forEach var="companyDataItem" items="${companyData}">
                                <option value="${companyDataItem.key}" <c:if test="${waMonthWaterData.companyId==companyDataItem.key}">selected</c:if>>${companyDataItem.value}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>时间月份<font>*</font>:</td>
                    <td><input type="text" style="width: 170px" name="monthDate" id="monthDate" placeholder="例如：201809" value="${waMonthWaterData.monthDate}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') " ></input></td>
                </tr>
                <tr>
                    <td>计划居民供水:</td>
                    <td><input type="text" style="width: 170px" name="planResidentWater" id="planResidentWater" value="${waMonthWaterData.planResidentWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>实际居民用水:</td>
                    <td><input type="text" style="width: 170px" name="actResidentWater" id="actResidentWater" value="${waMonthWaterData.actResidentWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>居民用水超出量:</td>
                    <td><input type="text" style="width: 170px" name="beyondResidentWater" id="beyondResidentWater" value="${waMonthWaterData.beyondResidentWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>居民用水收费标准:</td>
                    <td><input type="text" style="width: 170px" name="feeResidentWater" id="feeResidentWater" value="${waMonthWaterData.feeResidentWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>计划非居民供水:</td>
                    <td><input type="text" style="width: 170px" name="planNoResidentWater" id="planNoResidentWater" value="${waMonthWaterData.planNoResidentWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                     <td>实际非居民用水:</td>
                     <td><input type="text" style="width: 170px" name="actNoResidentWater" id="actNoResidentWater" value="${waMonthWaterData.actNoResidentWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                 </tr>
                <tr>
                    <td>非居民用水超出量:</td>
                    <td><input type="text" style="width: 170px" name="beyondNoResidentWater" id="beyondNoResidentWater" value="${waMonthWaterData.beyondNoResidentWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>非居民用水收费标准:</td>
                    <td><input type="text" style="width: 170px" name="feeNoResidentWater" id="feeNoResidentWater" value="${waMonthWaterData.feeNoResidentWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>计划教育用水:</td>
                    <td><input type="text" style="width: 170px" name="planEducationWater" id="planEducationWater" value="${waMonthWaterData.planEducationWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>实际教育用水:</td>
                    <td><input type="text" style="width: 170px" name="actEducationWater" id="actEducationWater" value="${waMonthWaterData.actEducationWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>教育用水超出量:</td>
                    <td><input type="text" style="width: 170px" name="beyondEducationWater" id="beyondEducationWater" value="${waMonthWaterData.beyondEducationWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>教育用水收费标准:</td>
                    <td><input type="text" style="width: 170px" name="feeEducationWater" id="feeEducationWater" value="${waMonthWaterData.feeEducationWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>计划特殊行业用水:</td>
                    <td><input type="text" style="width: 170px" name="planSpecialTradeWater" id="planSpecialTradeWater" value="${waMonthWaterData.planSpecialTradeWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>实际特殊行业用水:</td>
                    <td><input type="text" style="width: 170px" name="actSpecialTradeWater" id="actSpecialTradeWater" value="${waMonthWaterData.actSpecialTradeWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>特殊行业用水超出量:</td>
                    <td><input type="text" style="width: 170px" name="beyondSpecialTradeWater" id="beyondSpecialTradeWater" value="${waMonthWaterData.beyondSpecialTradeWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>
                <tr>
                    <td>特殊行业用水收费标准:</td>
                    <td><input type="text" style="width: 170px" name="feeSpecialTradeWater" id="feeSpecialTradeWater" value="${waMonthWaterData.feeSpecialTradeWater}" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'') "></input></td>
                </tr>

            </table>
        </form>
    </div>
    <div data-options="region:'south',border:false" style="text-align: right; padding: 5px 5px 5px; background-color: #e0e0e0;">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" tag="ok">保存</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" tag="cancel">取消</a>
    </div>

</div>
<script type="text/javascript">
    var monthWaterId = "${monthWaterId}";
</script>
<script type="text/javascript" src="${ctx}/static/js/wa/waterDataManagement/search/waOverPlanWaterData_detail.js"></script>
</body>

</html>
