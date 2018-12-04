<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>详细页面</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true" id="waInterwater_edit_layout">
	<div data-options="region:'west'" style="">
		<form id="waInterwater_edit_form"  name="waInterwater_edit_form" class="hgform">
			<table fit=true name="waInterwater_edit_Tab" id="waInterwater_edit_Tab" singleSelect=false fitColumns=true>
				<thead>
				<input type="hidden"   name="interwaterId" value="${interwaterId}" id="interwaterId"></input>
				<tr>
					<td width="130px;">单位名称<font>*</font>:</td>
					<td>
						<select name="companyId" style="width: 170px">
							<c:forEach var="companyDataItem" items="${companyData}">
								<option value="${companyDataItem.key}" <c:if test="${waInterWaterData.companyId==companyDataItem.key}">selected</c:if>>${companyDataItem.value}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="130px;">项目名称<font>*</font>:</td>
					<td><input type="text"   name="productName" value="${waInterWaterData.productName}" id="productName"></input></td>
				</tr>
				<tr>
					<td width="130px;">处理工艺<font>*</font>:</td>
					<td><input type="text"   name="handleTech" value="${waInterWaterData.handleTech}" id="handleTech"></input></td>
				</tr> <tr>
					<td width="130px;">设计回用量水<font>*</font>:</td>
					<td><input type="text"   name="recoverWaterCount" value="${waInterWaterData.recoverWaterCount}" id="recoverWaterCount"></input></td>
				</tr> <tr>
					<td width="130px;">实际回用水量（m3/日<font>*</font>:</td>
					<td><input type="text"   name="actWaterCount" value="${waInterWaterData.actWaterCount}" id="actWaterCount"></input></td>
				</tr><tr>
					<td width="130px;">投入运行时间<font>*</font>:</td>
					<td><input type="text"   name="runtime" value="${waInterWaterData.runtime}" id="runtime"></input></td>
				</tr><tr>
					<td width="130px;">工程投资<font>*</font>:</td>
					<td><input type="text"   name="investMoney" value="${waInterWaterData.investMoney}" id="investMoney"></input></td>
				</tr><tr>
					<td width="130px;">运行成本<font>*</font>:</td>
					<td><input type="text"   name="runCost" value="${waInterWaterData.runCost}" id="runCost"></input></td>
				</tr><tr>
					<td width="130px;">中水价格<font>*</font>:</td>
					<td><input type="text"   name="interwaterPrice" value="${waInterWaterData.interwaterPrice}" id="interwaterPrice"></input></td>
				</tr><tr>
					<td width="130px;">中水管网建设情况<font>*</font>:</td>
					<td><input type="text"   name="interwaterPiping" value="${waInterWaterData.interwaterPiping}" id="interwaterPiping"></input></td>
				</tr><tr>
					<td width="130px;">用途<font>*</font>:</td>
					<td><input type="text"   name="use" value="${waInterWaterData.use}" id="use"></input></td>
				</tr><tr>
					<td width="130px;">备注<font>*</font>:</td>
					<td><input type="text"   name="flag" value="${waInterWaterData.flag}" id="flag"></input></td>
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
    var interwaterId = "${interwaterId}";
</script>
<script type="text/javascript" src="${ctx}/static/js/wa/waCompanyInfo/waInterWater/waInterwaterInstallationTable_detail.js"></script>
</body>
</html>
