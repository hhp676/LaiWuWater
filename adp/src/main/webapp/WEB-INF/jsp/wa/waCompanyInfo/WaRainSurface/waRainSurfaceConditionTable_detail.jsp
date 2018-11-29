<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>详细页面</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true" id="waRainSurface_edit_layout">
	<div data-options="region:'west'" style="">
		<form id="waRainSurface_edit_form"  name="waRainSurface_edit_form" class="hgform">
			<table fit=true name="waRainSurface_edit_Tab" id="waRainSurface_edit_Tab" singleSelect=false fitColumns=true>
				<thead>
				<input type="hidden"   name="rainSurfaceId" value="${rainSurfaceId}" id="rainSurfaceId"></input>
				<tr>
					<td width="130px;">单位名称<font>*</font>:</td>
					<td><input type="text"   name="companyName" value="${waRainSurfaceData.companyName}" id="companyName"></input></td>
				</tr>
				<tr>
					<td width="130px;">雨水储水容量m3<font>*</font>:</td>
					<td><input type="text"   name="rainWaterVolume" value="${waRainSurfaceData.rainWaterVolume}" id="rainWaterVolume"></input></td>
				</tr>
				<tr>
					<td width="130px;">雨水实际使用量（年）<font>*</font>:</td>
					<td><input type="text"   name="rainActAmount" value="${waRainSurfaceData.rainActAmount}" id="rainActAmount"></input></td>
				</tr> <tr>
					<td width="130px;">雨水投入使用时间<font>*</font>:</td>
					<td><input type="text"   name="rainUseTime" value="${waRainSurfaceData.rainUseTime}" id="rainUseTime"></input></td>
				</tr> <tr>
					<td width="130px;">雨水工程投资<font>*</font>:</td>
					<td><input type="text"   name="rainProjectInvest" value="${waRainSurfaceData.rainProjectInvest}" id="rainProjectInvest"></input></td>
				</tr><tr>
					<td width="130px;">地表水储水容量m3<font>*</font>:</td>
					<td><input type="text"   name="surfaceWaterVolume" value="${waRainSurfaceData.surfaceWaterVolume}" id="surfaceWaterVolume"></input></td>
				</tr><tr>
					<td width="130px;">地表水实际使用量（年）<font>*</font>:</td>
					<td><input type="text"   name="surfaceActAmount" value="${waRainSurfaceData.surfaceActAmount}" id="surfaceActAmount"></input></td>
				</tr><tr>
					<td width="130px;">地表水投入使用时间<font>*</font>:</td>
					<td><input type="text"   name="surfaceUseTime" value="${waRainSurfaceData.surfaceUseTime}" id="surfaceUseTime"></input></td>
				</tr><tr>
					<td width="130px;">地表水工程投资<font>*</font>:</td>
					<td><input type="text"   name="surfaceProjectInvest" value="${waRainSurfaceData.surfaceProjectInvest}" id="surfaceProjectInvest"></input></td>
				</tr><tr>
					<td width="130px;">用途<font>*</font>:</td>
					<td><input type="text"   name="purpose" value="${waRainSurfaceData.purpose}" id="purpose"></input></td>
				</tr><tr>
					<td width="130px;">备注<font>*</font>:</td>
					<td><input type="text"   name="flag" value="${waRainSurfaceData.flag}" id="flag"></input></td>
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
    var rainSurfaceId = "${rainSurfaceId}";
</script>
<script type="text/javascript" src="${ctx}/static/js/wa/waCompanyInfo/WaRainSurface/waRainSurfaceConditionTable_detail.js"></script>
</body>
</html>
