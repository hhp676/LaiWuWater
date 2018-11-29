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
 		<table  id="waPlanConditionTable_datagrid" singleSelect=true  fitColumns=true  toolbar='#waPlanConditionTable_toolbar' 
 		    class="easyui-datagrid" data-options="url:'${ctx}/wa/WaPlanConditionTable/list',
			onRowContextMenu:waPlanConditionTableDatagrid.onRowContextMenu,
			onDblClickRow:waPlanConditionTableDatagrid.onDblClickRow,
			onLoadSuccess:waPlanConditionTableDatagrid.onLoadSuccess" 
			pagination="true" 
			pageSize="${defaultPageSize}" 
			pageList="${defaultPageList}">
       	 	<thead>
            <tr>
                <th data-options="field:'planCondtionId',hidden:true" editor="{type:'hidden'}"><b></b></th>
                <th data-options="field:'residentLivePlanAmount',width:150" editor="{type:'textbox'}"><b>居民生活用水计划数量</b></th>
                <th data-options="field:'residentActAmount',width:150" editor="{type:'textbox'}"><b>居民生活实际用水量</b></th>
                <th data-options="field:'noResidentLivePlanAmount',width:150" editor="{type:'textbox'}"><b>非居民用水计划数量</b></th>
                <th data-options="field:'noResidentActAmount',width:150" editor="{type:'textbox'}"><b>非居民用水实际用水量</b></th>
                <th data-options="field:'educationPlanAmount',width:150" editor="{type:'textbox'}"><b>教育用水计划数量</b></th>
                <th data-options="field:'educationActAmount',width:150" editor="{type:'textbox'}"><b>教育用水实际用水量</b></th>
                <th data-options="field:'specialPlanAmount',width:150" editor="{type:'textbox'}"><b>特种用水计划数量</b></th>
                <th data-options="field:'specialActAmount',width:150" editor="{type:'textbox'}"><b>特种用水实际用水量</b></th>
                <th data-options="field:'planWaterTotal',width:150" editor="{type:'textbox'}"><b>用水计划总计</b></th>
                <th data-options="field:'actWaterTotal',width:150" editor="{type:'textbox'}"><b>实际用水量总计</b></th>
                <th data-options="field:'saveWaterAmount',width:150" editor="{type:'textbox'}"><b>节水量</b></th>
            </tr>
            </thead>
        </table>
       	<div id="waPlanConditionTable_toolbar" style="display: none;"> 
       		<div class="gridSearchBar" style="height: 40px;">
			<form id="waPlanConditionTableSearchForm">
       			<table width="100%">
						<tr>
							<td width="60px" align="right"><span>条件1:</span></td>
							<td width="120px;"><input name=" "></td>
							<td width="120px" align="right"><span>条件2:</span></td>
							<td><input name=" "></td>
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
       					 
<script type="text/javascript" src="${ctx}/static/js/wa/waCompanyInfo/WaPlanCondition/waPlanConditionTable_show.js"></script>
</body>

</html>