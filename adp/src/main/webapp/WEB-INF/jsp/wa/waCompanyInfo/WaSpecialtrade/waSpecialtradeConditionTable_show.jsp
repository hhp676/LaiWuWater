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
 		<table  id="waSpecialtradeConditionTable_datagrid" singleSelect=true  fitColumns=true  toolbar='#waSpecialtradeConditionTable_toolbar' 
 		    class="easyui-datagrid" data-options="url:'${ctx}/wa/WaSpecialtradeConditionTable/list',
			onRowContextMenu:waSpecialtradeConditionTableDatagrid.onRowContextMenu,
			onDblClickRow:waSpecialtradeConditionTableDatagrid.onDblClickRow,
			onLoadSuccess:waSpecialtradeConditionTableDatagrid.onLoadSuccess" 
			pagination="true" 
			pageSize="${defaultPageSize}" 
			pageList="${defaultPageList}">
       	 	<thead>
            <tr>
                <th data-options="field:'specialId',hidden:true" editor="{type:'hidden'}"><b></b></th>
				<th data-options="field:'companyCode',width:150" editor="{type:'textbox'}"><b>节水代码</b></th>
				<th data-options="field:'companyName',width:150" editor="{type:'textbox'}"><b>单位名称</b></th>
                <th data-options="field:'waterType',width:150" editor="{type:'textbox'}"><b>用水户性质</b></th>
                <th data-options="field:'address',width:150" editor="{type:'textbox'}"><b>地址</b></th>
                <th data-options="field:'tableAmount',width:150" editor="{type:'textbox'}"><b>装表数</b></th>
                <th data-options="field:'waterAmount',width:150" editor="{type:'textbox'}"><b>用水量</b></th>
                <th data-options="field:'price',width:150" editor="{type:'textbox'}"><b>收费价格</b></th>
                <th data-options="field:'isRecovery',width:150" editor="{type:'textbox'}"><b>废水（尾水）是否处理回收</b></th>
            </tr>
            </thead>
        </table>
       	<div id="waSpecialtradeConditionTable_toolbar" style="display: none;"> 
       		<div class="gridSearchBar" style="height: 40px;">
			<form id="waSpecialtradeConditionTableSearchForm">
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
    			<%--<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-star-add" plain="true" tag="add">添加</a>--%>
    			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-star-edit" plain="true" tag="edit">修改</a>
    			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-star-del" plain="true" tag="del">删除</a>
    	</div>
      </div>
      <div id="sysRole_contextMenu" class="easyui-menu" style="width: 120px;">
  			<div iconCls="m-icon-star-add" tag="add">添加</div>
  			<div iconCls="m-icon-star-edit" tag="edit">修改</div>
	    	<div iconCls="m-icon-star-del" tag="del">删除</div>
	</div>
       					 
<script type="text/javascript" src="${ctx}/static/js/wa/waCompanyInfo/WaSpecialtrade/waSpecialtradeConditionTable_show.js"></script>
</body>

</html>