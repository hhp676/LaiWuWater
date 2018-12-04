<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>详细页面</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true" id="waPlanCondition_edit_layout">
	<div data-options="region:'west'" style="">
		<form id="waPlanCondition_edit_form"  name="waPlanCondition_edit_form" class="hgform">
			<table fit=true name="waPlanCondition_edit_Tab" id="waPlanCondition_edit_Tab" singleSelect=false fitColumns=true>
				<thead>
					<input type="hidden"   name="planCondtionId" value="${planCondtionId}" id="planCondtionId"></input>
					<tr>
						<td width="130px;">单位名称<font>*</font>:</td>
						<td>
							<select name="companyId" style="width: 170px">
								<c:forEach var="companyDataItem" items="${companyData}">
									<option value="${companyDataItem.key}" <c:if test="${waPlanConditionData.companyId==companyDataItem.key}">selected</c:if>>${companyDataItem.value}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td width="130px;">居民生活用水计划数量<font>*</font>:</td>
						<td><input type="text"   name="residentLivePlanAmount" value="${waPlanConditionData.residentLivePlanAmount}" id="residentLivePlanAmount"></input></td>
					</tr>
					<tr>
						<td width="130px;">居民生活实际用水量<font>*</font>:</td>
						<td><input type="text"   name="residentActAmount" value="${waPlanConditionData.residentActAmount}" id="residentActAmount"></input></td>
					</tr> <tr>
						<td width="130px;">非居民用水计划数量<font>*</font>:</td>
						<td><input type="text"   name="noResidentLivePlanAmount" value="${waPlanConditionData.noResidentLivePlanAmount}" id="noResidentLivePlanAmount"></input></td>
					</tr> <tr>
						<td width="130px;">非居民用水实际用水量<font>*</font>:</td>
						<td><input type="text"   name="noResidentActAmount" value="${waPlanConditionData.noResidentActAmount}" id="noResidentActAmount"></input></td>
					</tr><tr>
						<td width="130px;">教育用水计划数量<font>*</font>:</td>
						<td><input type="text"   name="educationPlanAmount" value="${waPlanConditionData.educationPlanAmount}" id="educationPlanAmount"></input></td>
					</tr><tr>
						<td width="130px;">教育用水实际用水量<font>*</font>:</td>
						<td><input type="text"   name="educationActAmount" value="${waPlanConditionData.educationActAmount}" id="educationActAmount"></input></td>
					</tr><tr>
						<td width="130px;">特种用水计划数量<font>*</font>:</td>
						<td><input type="text"   name="specialPlanAmount" value="${waPlanConditionData.specialPlanAmount}" id="specialPlanAmount"></input></td>
					</tr><tr>
						<td width="130px;">特种用水实际用水量<font>*</font>:</td>
						<td><input type="text"   name="specialActAmount" value="${waPlanConditionData.specialActAmount}" id="specialActAmount"></input></td>
					</tr><tr>
						<td width="130px;">用水计划总计<font>*</font>:</td>
						<td><input type="text"   name="planWaterTotal" value="${waPlanConditionData.planWaterTotal}" id="planWaterTotal"></input></td>
					</tr><tr>
						<td width="130px;">实际用水量总计<font>*</font>:</td>
						<td><input type="text"   name="actWaterTotal" value="${waPlanConditionData.actWaterTotal}" id="actWaterTotal"></input></td>
					</tr><tr>
						<td width="130px;">节水量<font>*</font>:</td>
						<td><input type="text"   name="saveWaterAmount" value="${waPlanConditionData.saveWaterAmount}" id="saveWaterAmount"></input></td>
					</tr>
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
    var planCondtionId = "${planCondtionId}";
</script>
<script type="text/javascript" src="${ctx}/static/js/wa/waCompanyInfo/WaPlanCondition/waPlanConditionTable_detail.js"></script>
</body>
</html>
