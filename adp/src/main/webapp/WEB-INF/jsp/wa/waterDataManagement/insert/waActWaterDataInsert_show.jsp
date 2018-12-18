<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>用户列表页面</title>
</head>
<body>
	<div >
 		<table id="waMonthWaterData_datagrid_actInsert" singleSelect=false  fitColumns=true  toolbar='#waMonthWaterData_toolbar_actInsert'
 		    class="easyui-datagrid" data-options="url:'${ctx}/wa/WaMonthWaterData/actList'"
			pagination="true" 
			pageSize="${defaultPageSize}" 
			pageList="${defaultPageList}">
       	 	<thead>
            <tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'monthWaterId',width:0, hidden:true"><b></b></th>
				<th data-options="field:'companyCode',width:80" editor="{type:'textbox'}"><b>节水代码</b></th>
				<th data-options="field:'companyName',width:150" editor="{type:'textbox'}"><b>单位名称</b></th>
				<th data-options="field:'isImport'" editor="{type:'textbox'}"><b>重点用户</b></th>
				<th data-options="field:'monthDate',width:150" editor="{type:'textbox'}"><b>月份时间</b></th>
				<th data-options="field:'actResidentWater',width:150" editor="{type:'textbox'}"><b>实际居民用水</b></th>
				<th data-options="field:'actNoResidentWater',width:150" editor="{type:'textbox'}"><b>实际非居民用水</b></th>
				<th data-options="field:'actEducationWater',width:150" editor="{type:'textbox'}"><b>实际教育用水</b></th>
				<th data-options="field:'actSpecialTradeWater',width:150" editor="{type:'textbox'}"><b>实际特殊行业用水</b></th>
				<th data-options="field:'actWaterTotal',width:150" editor="{type:'textbox'}"><b>合计</b></th>
			</tr>
            </thead>
        </table>
       	<div id="waMonthWaterData_toolbar_actInsert" style="display: none;">
       		<div class="gridSearchBar" style="height: 40px;">
				<form id="waMonthWaterDataSearchForm_actInsert">
					<table width="100%">
						<tr>
							<td width="60px" align="right"><span>节水代码:</span></td>
							<td width="50px;"><input style="width: 120px" name="month_companyCodeMonth_actInsert"></td>
							<td width="60px" align="right"><span>单位名称:</span></td>
							<td width="50px;"><input style="width: 120px" name="month_companyNameMonth_actInsert"></td>
							<td width="60px" align="right"><span>年份:</span></td>
							<td width="50px;"><input style="width: 50px;" name="month_waYear_actInsert" id="month_waYear_actInsert"></td>
							<td width="30px" align="right"><span>月份:</span></td>
							<td width="40px;"><input style="width: 50px;"  name="month_waMonth_actInsert"></td>
							<td width="60px" align="right"><span>重点用户:</span></td>
							<td>
								<select name="month_isImportMonth_actInsert" style="width: 80px">
									<option selected = "selected" value="">全部</option>
									<option value="1">是</option>
									<option value="0">否</option>
								</select>
							</td>
							<td style="text-align: right;"><a class="easyui-linkbutton" iconCls="m-icon-search" tag="search">查询</a>
							&nbsp;
								<a class="easyui-linkbutton" iconCls="m-icon-clear" tag="clear">清空</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<shiro:hasPermission name="<%= Auths.WA_MONTH_WATER_DATA_ADD %>">
    			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-star-add" plain="true" tag="add">添加</a>
    		</shiro:hasPermission>
    		<shiro:hasPermission name="<%= Auths.WA_MONTH_WATER_DATA_EDIT %>">
    			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-star-edit" plain="true" tag="edit">修改</a>
    		</shiro:hasPermission>
    		<shiro:hasPermission name="<%= Auths.WA_MONTH_WATER_DATA_DELETE %>">
    			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-star-del" plain="true" tag="del">删除</a>
    		</shiro:hasPermission>

			<shiro:hasPermission name="<%= Auths.WA_MONTH_WATER_DATA_IMPORT %>">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-list" plain="true" tag="import">实际用水导入</a>
			</shiro:hasPermission>

	 	</div>
	 </div>

       					 
<script type="text/javascript" src="${ctx}/static/js/wa/waterDataManagement/insert/waActWaterData_insert.js/"></script>
<script type="text/javascript" src="${ctx}/static/js/wa/jquery.PrintArea.js"></script>
<script type="text/javascript" src="${ctx}/static/js/wa/laydate.js"></script>
<script type="text/javascript">

    $(function(){
        var currTime=new Date();
        var strDate=currTime.getFullYear()+"-"+(currTime.getMonth()+1);
        $('#planMonthWater').datebox({formatter:function(date){
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            m = m < 10 ? '0' + m : m;
            return y.toString() + '-' + m.toString();
        },parser:function(date){
            console.log(date);
            if (date) {
                return new Date(String(date).substring(0, 4) + '-'
                    + String(date).substring(5,7));
            } else {
                return new Date();
            }
        }});
        $('#planMonthWater').datebox('setValue',strDate);//默认加载当前月份

    });

	/* function onLoadSuccess(data){
        var merges = [{
            index: 2,
            rowspan: 2
        },{
            index: 5,
            rowspan: 2
        },{
            index: 7,
            rowspan: 2
        }];
        for(var i=0; i<merges.length; i++){
            $(this).datagrid('mergeCells',{
                index: merges[i].index,
                field: 'companyCode',
                rowspan: merges[i].rowspan
            });
        }
    }*/
</script>
</body>

</html>