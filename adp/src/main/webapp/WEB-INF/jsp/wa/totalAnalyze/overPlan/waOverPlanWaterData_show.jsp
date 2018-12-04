<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>用户列表页面</title>
</head>
<body>
	<div >
 		<table id="waMonthWaterData_datagrid_overPlan" singleSelect=false  fitColumns=true  toolbar='#waMonthWaterData_toolbar_overPlan'
 		    class="easyui-datagrid" data-options="url:'${ctx}/wa/WaMonthWaterData/list'"
			pagination="true" 
			pageSize="${defaultPageSize}" 
			pageList="${defaultPageList}">
       	 	<thead>
            <tr>
				<th data-options="field:'monthWaterId',checkbox:true"><b></b></th>
				<th data-options="field:'companyCode',width:80, formatter:getCompanyDate" editor="{type:'textbox'}"><b>节水代码</b></th>
				<th data-options="field:'companyName',width:150, formatter:getCompanyDate" editor="{type:'textbox'}"><b>单位名称</b></th>
				<%--<th data-options="field:'isImport'" editor="{type:'textbox'}"><b>重点用户</b></th>--%>
				<th data-options="field:'monthDate',width:150, formatter:getCompanyDate" editor="{type:'textbox'}"><b>月份时间</b></th>
                <th data-options="field:'indexName',width:150" editor="{type:'textbox'}"><b>用水类型</b></th>
				<th data-options="field:'indexPlanValue',width:150" editor="{type:'textbox'}"><b>计划月份用水量</b></th>
				<th data-options="field:'indexActValue',width:150" editor="{type:'textbox'}"><b>实际月份用水量</b></th>
				<th data-options="field:'indexOverRoof',width:150" editor="{type:'textbox'}"><b>是否超标</b></th>
				<th data-options="field:'indexBeyondAmount',width:150" editor="{type:'textbox'}"><b>超出计划用水量</b></th>
				<th data-options="field:'indexFee',width:150" editor="{type:'textbox'}"><b>收费标准</b></th>
		    </tr>
            </thead>
        </table>
       	<div id="waMonthWaterData_toolbar_overPlan" style="display: none;">
       		<div class="gridSearchBar" style="height: 40px;">
				<form id="waMonthWaterDataSearchForm_overPlan">
					<table width="100%">
						<tr>
							<td width="60px" align="right"><span>节水代码:</span></td>
							<td width="50px;"><input style="width: 120px" name="month_companyCodeMonth_overPlan"></td>
							<td width="60px" align="right"><span>单位名称:</span></td>
							<td width="50px;"><input style="width: 120px" name="month_companyNameMonth_overPlan"></td>
							<td width="60px" align="right"><span>年份:</span></td>
							<td width="50px;"><input style="width: 50px;" name="month_waYear_overPlan" id="month_waYear_overPlan"></td>
							<td width="30px" align="right"><span>月份:</span></td>
							<td width="40px;"><input style="width: 50px;"  name="month_waMonth_overPlan"></td>
							<%--<td width="60px" align="right"><span>重点用户:</span></td>
							<td>
								<select name="month_isImportMonth_overPlan" style="width: 80px">
									<option selected = "selected" value="">全部</option>
									<option value="1">是</option>
									<option value="0">否</option>
								</select>
							</td>
							<td width="60px" align="right"><span>是否超标:</span></td>
							<td><select name="month_isOverroof_overPlan" style="width: 80px">
								<option selected="selected" value="">全部</option>
								<option value="1">是</option>
								<option value="0">否</option>
							</select></td>--%>
							<td style="text-align: right;"><a class="easyui-linkbutton" iconCls="m-icon-search" tag="search">查询</a>
							&nbsp;
								<a class="easyui-linkbutton" iconCls="m-icon-clear" tag="clear">清空</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<%--<shiro:hasPermission name="<%= Auths.WA_MONTH_WATER_DATA_ADD %>">
    			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-star-add" plain="true" tag="add">添加</a>
    		</shiro:hasPermission>--%>
    		<shiro:hasPermission name="<%= Auths.WA_MONTH_WATER_DATA_EDIT %>">
    			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-star-edit" plain="true" tag="edit">修改</a>
    		</shiro:hasPermission>
    		<shiro:hasPermission name="<%= Auths.WA_MONTH_WATER_DATA_DELETE %>">
    			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-star-del" plain="true" tag="del">删除</a>
    		</shiro:hasPermission>
    		<shiro:hasPermission name="<%= Auths.WA_MONTH_WATER_DATA_VIEW %>">
       			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-list" plain="true" tag="view">查看详情</a>
       		</shiro:hasPermission>
			<shiro:hasPermission name="<%= Auths.WA_MONTH_WATER_DATA_PRINT %>">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="m-icon-list" plain="true" tag="print">打印</a>
			</shiro:hasPermission>
	 	</div>
	 </div>

       					 
<script type="text/javascript" src="${ctx}/static/js/wa/totalAnalyze/overPlan/waOverPlanWaterData_show.js"></script>
<script type="text/javascript" src="${ctx}/static/js/wa/jquery.PrintArea.js"></script>
<script type="text/javascript" src="${ctx}/static/js/wa/laydate.js"></script>
<script type="text/javascript">
    function getCompanyDate(val,row){
        return val.split("/")[1];
    };

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

    /**
	 * 动态合并表格数据
     */
    $('#waMonthWaterData_datagrid_overPlan').datagrid({ pagination: true,
        onLoadSuccess: function (data) {
            if (data.rows.length > 0) {
                //调用mergeCellsByField()合并单元格
                mergeCellsByField("waMonthWaterData_datagrid_overPlan", "monthWaterId,companyCode,companyName,monthDate");
            }
        }
    });

    function mergeCellsByField(tableID, colList) {
        var ColArray = colList.split(",");
        var tTable = $("#" + tableID);
        var TableRowCnts = tTable.datagrid("getRows").length;
        var tmpA;
        var tmpB;
        var PerTxt = "";
        var CurTxt = "";
        var alertStr = "";
        for (j = ColArray.length - 1; j >= 0; j--) {
            PerTxt = "";
            tmpA = 1;
            tmpB = 0;
            for (i = 0; i <= TableRowCnts; i++) {
                if (i == TableRowCnts) {
                    CurTxt = "";
                }
                else {
                    CurTxt = tTable.datagrid("getRows")[i][ColArray[j]];
                }
                if (PerTxt == CurTxt) {
                    tmpA += 1;
                }
                else {
                    tmpB += tmpA;

                    tTable.datagrid("mergeCells", {
                        index: i - tmpA,
                        field: ColArray[j],　　//合并字段
                        rowspan: tmpA,
                        colspan: null
                    });
                    tTable.datagrid("mergeCells", { //根据ColArray[j]进行合并
                        index: i - tmpA,
                        field: "Ideparture",
                        rowspan: tmpA,
                        colspan: null
                    });

                    tmpA = 1;
                }
                PerTxt = CurTxt;
            }
        }
    }

</script>
</body>

</html>