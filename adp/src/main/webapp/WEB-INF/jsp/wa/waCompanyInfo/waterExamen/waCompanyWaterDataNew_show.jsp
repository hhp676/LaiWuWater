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
 		<table  id="waCompanyWaterDataNew_datagrid" singleSelect=true  fitColumns=true  toolbar='#waCompanyWaterDataNew_toolbar' 
 		    class="easyui-datagrid" data-options="url:'${ctx}/wa/WaCompanyWaterDataNew/list',
			onRowContextMenu:waCompanyWaterDataNewDatagrid.onRowContextMenu,
			onDblClickRow:waCompanyWaterDataNewDatagrid.onDblClickRow,
			onLoadSuccess:waCompanyWaterDataNewDatagrid.onLoadSuccess" 
			pagination="true" 
			pageSize="${defaultPageSize}" 
			pageList="${defaultPageList}">
       	 	<thead>
            <tr>
				<th data-options="field:'companyWaterId',width:0, hidden:true" editor="{type:'hidden', options:{required:true,missingMessage:'此输入项为必填项'}}"><b></b></th>
                <th data-options="field:'productName',width:150" editor="{type:'textbox'}"><b>主产品名称</b></th>
                <th data-options="field:'newWaterCount',width:150" editor="{type:'textbox'}"><b>单位产品新水量m3/单位产品</b></th>
                <th data-options="field:'gongyeWaterCount',width:150" editor="{type:'textbox'}"><b>工业新水量</b></th>
                <th data-options="field:'totalCount',width:150" editor="{type:'textbox'}"><b>全年产量</b></th>
                <th data-options="field:'waterStandard',width:150" editor="{type:'textbox'}"><b>行业用水标准</b></th>
                <th data-options="field:'employee',width:150" editor="{type:'textbox'}"><b>从业人员</b></th>
                <th data-options="field:'gongyiWaterCount',width:150" editor="{type:'textbox'}"><b>工艺新水量</b></th>
                <th data-options="field:'boilerWater',width:150" editor="{type:'textbox'}"><b>锅炉新水量</b></th>
                <th data-options="field:'factoryLiveWater',width:150" editor="{type:'textbox'}"><b>厂内生活水 </b></th>
                <th data-options="field:'reuseTotalAmount',width:150" editor="{type:'textbox'}"><b>重复利用水量</b></th>
                <th data-options="field:'availability',width:150" editor="{type:'textbox'}"><b>利用率</b></th>
                <th data-options="field:'interColdWaterLoopAmount',width:150" editor="{type:'textbox'}"><b>间冷水循环量</b></th>
                <th data-options="field:'circulRate',width:150" editor="{type:'textbox'}"><b>循环率</b></th>
                <th data-options="field:'freshWaterBackAmount',width:150" editor="{type:'textbox'}"><b>回水量 </b></th>
                <th data-options="field:'steamCondenBackAmount',width:150" editor="{type:'textbox'}"><b>蒸汽冷凝回水量 </b></th>
                <th data-options="field:'recoverRate',width:150" editor="{type:'textbox'}"><b>回用率</b></th>
                <th data-options="field:'saveAmount',width:150" editor="{type:'textbox'}"><b>节水量</b></th>
                <th data-options="field:'installMoney',width:150" editor="{type:'textbox'}"><b>节水设施投资</b></th>
                <th data-options="field:'companyName',width:150" editor="{type:'textbox'}"><b>填报单位</b></th>
                <th data-options="field:'waterPlanNo',width:150" editor="{type:'textbox'}"><b>用水计划卡号</b></th>
                <th data-options="field:'writePerson',width:150" editor="{type:'textbox'}"><b>填报人</b></th>
                <th data-options="field:'writeTime',width:150" editor="{type:'textbox'}"><b>填报时间</b></th>
            </tr>
            </thead>
        </table>
       	<div id="waCompanyWaterDataNew_toolbar" style="display: none;">
       		<div class="gridSearchBar" style="height: 40px;">
			<form id="wwaCompanyWaterDataNewSearchForm">
       			<table width="100%">
						<tr>
							<td width="100px" align="right"><span>主产品名称:</span></td>
							<td width="120px;"><input name="checkName"></td>
							<%--<td width="120px" align="right"><span>条件2:</span></td>
							<td><input name=" "></td>--%>
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
       			<%--<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-list" plain="true" tag="view">查看报表详情</a>--%>
    	</div>
      </div>
      <div id="sysRole_contextMenu" class="easyui-menu" style="width: 120px;">
  			<div iconCls="m-icon-star-add" tag="add">添加</div>
  			<div iconCls="m-icon-star-edit" tag="edit">修改</div>
	    	<div iconCls="m-icon-star-del" tag="del">删除</div>
	</div>
       					 
<script type="text/javascript" src="${ctx}/static/js/wa/waCompanyInfo/waterExamen/waCompanyWaterDataNew_show.js"></script>
</body>

</html>