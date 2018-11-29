<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
 <div title="列表">
 		<table  id="waRainSurfaceConditionTable_datagrid" singleSelect=true  fitColumns=true  toolbar='#waRainSurfaceConditionTable_toolbar' 
 		    class="easyui-datagrid" data-options="url:'${ctx}/wa/WaRainSurfaceConditionTable/list',
			onRowContextMenu:waRainSurfaceConditionTableDatagrid.onRowContextMenu,
			onDblClickRow:waRainSurfaceConditionTableDatagrid.onDblClickRow,
			onLoadSuccess:waRainSurfaceConditionTableDatagrid.onLoadSuccess" 
			pagination="true" 
			pageSize="${defaultPageSize}" 
			pageList="${defaultPageList}">
       	 	<thead>
            <tr>
                <th data-options="field:'rainSurfaceId',hidden:true" editor="{type:'hidden'}"><b></b></th>
				<th data-options="field:'companyCode',width:150" editor="{type:'textbox'}"><b>节水代码</b></th>
				<th data-options="field:'companyName',width:150" editor="{type:'textbox'}"><b>单位名称</b></th>
				<th data-options="field:'rainWaterVolume',width:150" editor="{type:'textbox'}"><b>雨水储水容量m3</b></th>
                <th data-options="field:'rainActAmount',width:150" editor="{type:'textbox'}"><b>雨水实际使用量（年）</b></th>
                <th data-options="field:'rainUseTime',width:150" editor="{type:'textbox'}"><b>雨水投入使用时间</b></th>
                <th data-options="field:'rainProjectInvest',width:150" editor="{type:'textbox'}"><b>雨水工程投资</b></th>
                <th data-options="field:'surfaceWaterVolume',width:150" editor="{type:'textbox'}"><b>地表水储水容量m3</b></th>
                <th data-options="field:'surfaceActAmount',width:150" editor="{type:'textbox'}"><b>地表水实际使用量（年）</b></th>
                <th data-options="field:'surfaceUseTime',width:150" editor="{type:'textbox'}"><b>地表水投入使用时间</b></th>
                <th data-options="field:'surfaceProjectInvest',width:150" editor="{type:'textbox'}"><b>地表水工程投资</b></th>
                <th data-options="field:'purpose',width:150" editor="{type:'textbox'}"><b>用途</b></th>
                <th data-options="field:'flag',width:150" editor="{type:'textbox'}"><b>备注</b></th>
            </tr>
            </thead>
        </table>
       	<div id="waRainSurfaceConditionTable_toolbar" style="display: none;"> 
       		<div class="gridSearchBar" style="height: 40px;">
			<form id="waRainSurfaceConditionTableSearchForm">
       			<table width="100%">
						<tr>
							<td width="60px" align="right"><span>节水代码:</span></td>
							<td width="120px;"><input name="companyCode"></td>
							<td width="120px" align="right"><span>单位名称:</span></td>
							<td><input name="companyName"></td>
							<td style="text-align: right;"><a class="easyui-linkbutton" iconCls="m-icon-search" tag="search">查询</a>
							&nbsp;
								<a class="easyui-linkbutton" iconCls="m-icon-clear" tag="clear">清空</a>
							</td>
						</tr>
					</table>
       	</form>
		</div>
    			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-star-add" plain="true" tag="add">添加</a>
    			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-star-edit" plain="true" tag="edit">修改</a>
    			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-star-del" plain="true" tag="del">删除</a>
       			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-list" plain="true" tag="view">查看详情</a>
    	</div>
      </div>
      <div id="sysRole_contextMenu" class="easyui-menu" style="width: 120px;">
  			<div iconCls="m-icon-star-add" tag="add">添加</div>
  			<div iconCls="m-icon-star-edit" tag="edit">修改</div>
	    	<div iconCls="m-icon-star-del" tag="del">删除</div>
	</div>
       					 
<script type="text/javascript" src="${ctx}/static/js/wa/waCompanyInfo/WaRainSurface/waRainSurfaceConditionTable_show.js"></script>
</body>

</html>