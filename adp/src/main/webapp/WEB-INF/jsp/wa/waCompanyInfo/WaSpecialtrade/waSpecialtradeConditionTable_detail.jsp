<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>详细页面</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true" id="waSpecialtrade_edit_layout">
	<div data-options="region:'west'" style="">
		<form id="waSpecialtrade_edit_form"  name="waSpecialtrade_edit_form" class="hgform">
			<table fit=true name="waSpecialtrade_edit_Tab" id="waSpecialtrade_edit_Tab" singleSelect=false fitColumns=true>
				<thead>
				<input type="hidden"   name="specialId" value="${specialId}" id="specialId"></input>
				<tr>
					<td width="130px;">单位名称<font>*</font>:</td>
					<td>
						<select name="companyId" style="width: 170px">
							<c:forEach var="companyDataItem" items="${companyData}">
								<option value="${companyDataItem.key}" <c:if test="${waSpecialtradeData.companyId==companyDataItem.key}">selected</c:if>>${companyDataItem.value}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="130px;">用水户性质<font>*</font>:</td>
					<td><input type="text"   name="waterType" value="${waSpecialtradeData.waterType}" id="waterType"></input></td>
				</tr>
				<tr>
					<td width="130px;">地址<font>*</font>:</td>
					<td><input type="text"   name="address" value="${waSpecialtradeData.address}" id="address"></input></td>
				</tr>
				<tr>
					<td width="130px;">装表数<font>*</font>:</td>
					<td><input type="text"   name="tableAmount" value="${waSpecialtradeData.tableAmount}" id="tableAmount"></input></td>
				</tr> <tr>
					<td width="130px;">用水量<font>*</font>:</td>
					<td><input type="text"   name="waterAmount" value="${waSpecialtradeData.waterAmount}" id="waterAmount"></input></td>
				</tr> <tr>
					<td width="130px;">收费价格<font>*</font>:</td>
					<td><input type="text"   name="price" value="${waSpecialtradeData.price}" id="price"></input></td>
				</tr><tr>
					<td width="130px;">废水（尾水）是否处理回收<font>*</font>:</td>
					<td><input type="text"   name="isRecovery" value="${waSpecialtradeData.isRecovery}" id="isRecovery"></input></td>
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
    var specialId = "${specialId}";
</script>
<script type="text/javascript" src="${ctx}/static/js/wa/waCompanyInfo/WaSpecialtrade/waSpecialtradeConditionTable_detail.js"></script>
</body>
</html>
