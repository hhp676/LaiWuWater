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
 		<table  id="waInterwaterInstallationTable_datagrid" singleSelect=true  fitColumns=true  toolbar='#waInterwaterInstallationTable_toolbar' 
 		    class="easyui-datagrid" data-options="url:'${ctx}/wa/WaInterwaterInstallationTable/list',
			onRowContextMenu:waInterwaterInstallationTableDatagrid.onRowContextMenu,
			onDblClickRow:waInterwaterInstallationTableDatagrid.onDblClickRow,
			onLoadSuccess:waInterwaterInstallationTableDatagrid.onLoadSuccess" 
			pagination="true" 
			pageSize="${defaultPageSize}" 
			pageList="${defaultPageList}">
       	 	<thead>
            <tr>
				<th data-options="field:'interwaterId',width:0, hidden:true" editor="{type:'hidden'}"><b></b></th>
                <th data-options="field:'companyCode',width:150" editor="{type:'textbox'}"><b>节水代码</b></th>
				<th data-options="field:'companyName',width:150" editor="{type:'textbox'}"><b>节水单位</b></th>
				<th data-options="field:'unitName',width:150" editor="{type:'textbox'}"><b>单位名称</b></th>
                <th data-options="field:'productName',width:150" editor="{type:'textbox'}"><b>项目名称</b></th>
                <th data-options="field:'handleTech',width:150" editor="{type:'textbox'}"><b>处理工艺</b></th>
                <th data-options="field:'recoverWaterCount',width:150" editor="{type:'textbox'}"><b>设计回用量水</b></th>
                <th data-options="field:'actWaterCount',width:150" editor="{type:'textbox'}"><b>实际回用水量（m3/日）</b></th>
                <th data-options="field:'runtime',width:150" editor="{type:'textbox'}"><b>投入运行时间</b></th>
                <th data-options="field:'investMoney',width:150" editor="{type:'textbox'}"><b>工程投资</b></th>
                <th data-options="field:'runCost',width:150" editor="{type:'textbox'}"><b>运行成本</b></th>
                <th data-options="field:'interwaterPrice',width:150" editor="{type:'textbox'}"><b>中水价格</b></th>
                <th data-options="field:'interwaterPiping',width:150" editor="{type:'textbox'}"><b>中水管网建设情况</b></th>
                <th data-options="field:'use',width:150" editor="{type:'textbox'}"><b>用途</b></th>
                <th data-options="field:'flag',width:150" editor="{type:'textbox'}"><b>备注</b></th>

            </tr>
            </thead>
        </table>
       	<div id="waInterwaterInstallationTable_toolbar" style="display: none;"> 
       		<div class="gridSearchBar" style="height: 40px;">
			<form id="waInterwaterInstallationTableSearchForm">
       			<table width="100%">
						<tr>
							<td width="60px" align="right"><span>节水代码:</span></td>
							<td width="120px;"><input name="interWaterCompanyCode"></td>
							<td width="120px" align="right"><span>单位名称:</span></td>
							<td><input name="interWaterCompanyName"></td>
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

<script type="text/javascript" src="${ctx}/static/js/wa/waCompanyInfo/waInterWater/waInterwaterInstallationTable_show.js"></script>
</body>

</html>