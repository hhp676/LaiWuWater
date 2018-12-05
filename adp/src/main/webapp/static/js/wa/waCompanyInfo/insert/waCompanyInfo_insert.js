//@ sourceURL=waCompanyInfo_show.js
var waCompanyInfoDatagrid =  {};
//----需要悬浮提示的单元格
waCompanyInfoDatagrid.tipCells = ["descr"];
waCompanyInfoDatagrid.initwaCompanyInfo_insert = function(){
   	Hg.fixTableHeight("waCompanyInfo_datagrid_insert",true);
    //----------------------------------查询-----------------------------------------------------
	$("#waCompanyInfo_toolbar_insert [tag='search']").click(function(){
		 $('#waCompanyInfo_datagrid_insert').datagrid('load',{
             companyCode: $("[name='com_companyCode_insert']").val(),
             companyName: $("[name='com_companyName_insert']").val(),
             isImport: $("[name='com_isImport_insert']").val()
		 });
	});

    //----------------------------------清空-----------------------------------------------------
	$("#waCompanyInfo_toolbar_insert [tag='clear']").click(function(){
		$('#waCompanyInfoSearchForm_insert').form('clear');
		$('#waCompanyInfo_datagrid_insert').datagrid("load",{});
	});
	 //-------------------------------------------增加---------------------------------------------------
	$("#waCompanyInfo_toolbar_insert [tag='add'],#waCompanyInfo_contextMenu_insert [tag='add']").click(function(){
		waCompanyInfoDatagrid.mode = "add";
		var iconCls = $(this).attr("iconCls");
		var waCompanyInfoDetailWin = new HgWin({id:"waCompanyInfoDetailWin",title:"添加",width:850,height:400,iconCls:iconCls,url:"/wa/WaCompanyInfo/waCompanyInfoDetail/0"});
	});

    //--------------------------------节水信息录入------------------------------------------------------------------
    $("#waCompanyInfo_toolbar_insert [tag='saveWaterView']").click(function(){
        waCompanyInfoDatagrid.mode = "saveWaterView";
        var row = $("#waCompanyInfo_datagrid_insert").datagrid("getSelected");
        if (!row) {
            $.messager.alert("提示","请选择一条数据","warning");
            return;
        }
        var companyId = row.companyId;
        var url = "/wa/WaCompanyInfo/showsaveWaterView/"+companyId;
        var iconCls = $(this).attr("iconCls");
        var saveWaterViewWin = new HgWin({id:"saveWaterViewWin",title:"节水信息录入",width:800,height:350,iconCls:iconCls,url:url});
    });

	/*
	//-------------------------------------------修改---------------------------------------------------
	$("#waCompanyInfo_toolbar [tag='edit'],#waCompanyInfo_contextMenu [tag='edit']").click(function(){
		waCompanyInfoDatagrid.mode = "edit";
		var row = $("#waCompanyInfo_datagrid").datagrid("getSelected");
		if (!row) {
			$.messager.alert("提示","请选择一条数据","warning");
			return;
		}
		if (row.isFinal == 1) {
			$.messager.alert("提示","此条数据不可被修改","warning");
			return;
		}
		var companyId = row.companyId;
		var editUrl = "/wa/WaCompanyInfo/waCompanyInfoDetail/"+companyId;
		var iconCls = $(this).attr("iconCls");
		var waCompanyInfoDetailWin = new HgWin({id:"waCompanyInfoDetailWin",title:"修改",width:850,height:380,iconCls:iconCls,url:editUrl});
	});
	
	//-------------------------------------------查看详情---------------------------------------------------
	$("#waCompanyInfo_toolbar [tag='view']").click(function(){
		waCompanyInfoDatagrid.mode = "view";
		var row = $("#waCompanyInfo_datagrid").datagrid("getSelected");
		if (!row) {
			$.messager.alert("提示","请选择一条数据","warning");
			return;
		}

		var companyId = row.companyId;
		var url = "/wa/WaCompanyInfo/waCompanyInfoDetail/"+companyId;
		var iconCls = $(this).attr("iconCls");
		var waCompanyInfoDetailWin = new HgWin({id:"waCompanyInfoDetailWin",title:"查看详情",width:850,height:380,iconCls:iconCls,url:url});
	});

    //-------------------------------------------用水情况统计信息---------------------------------------------------
    $("#waCompanyInfo_toolbar [tag='statisticsView']").click(function(){
        waCompanyInfoDatagrid.mode = "statisticsView";
        var row = $("#waCompanyInfo_datagrid").datagrid("getSelected");
        if (!row) {
            $.messager.alert("提示","请选择一条数据","warning");
            return;
        }

        var companyId = row.companyId;
        var url = "/wa/WaCompanyInfo/totalInfoDetail/"+companyId;
        var iconCls = $(this).attr("iconCls");
        var totalInfoDetailWin = new HgWin({id:"totalInfoDetailWin",title:"查看详情",width:850,height:380,iconCls:iconCls,url:url});
    });

	//-------------------------------------------删除---------------------------------------------------
	$("#waCompanyInfo_toolbar [tag='del'],#waCompanyInfo_contextMenu [tag='del']").click(function(){
		var row = $("#waCompanyInfo_datagrid").datagrid("getSelected");
		if (!row) {
			$.messager.alert("提示","请选择一条数据","warning");
			return;
		}
		if (row.isFinal == 1) {
			$.messager.alert("提示","此条数据不可被修改","warning");
			return;
		}
		$.messager.confirm("删除确认", "确认删除此条数据?", function(r){
			if (r){
				var companyId = row.companyId;
				Hg.getJson("/wa/WaCompanyInfo/delete",{companyId:companyId},function(data){
					if (data.success) {
						$.messager.ok("删除成功!",function(){
							$('#waCompanyInfo_datagrid').datagrid("reload");
						});							
					} else {
						$.messager.alert("删除失败!",data.data);
					}
				});
			}
		});
	});
*/
	//---------------------导入----------------------------------------------------------
    $("#waCompanyInfo_toolbar_insert [tag='import']").click(function(){
        waCompanyInfoDatagrid.mode = "import";
        var iconCls = $(this).attr("iconCls");
        var url = "/wa/WaCompanyInfo/showImportExcel/";
        var waCompanyInfoWin = new HgWin({id:"waCompanyInfoWin",title:"批量导入",width:500,height:180,iconCls:iconCls,url:url});

    });
} 

waCompanyInfoDatagrid.initwaCompanyInfo_insert();

waCompanyInfoDatagrid.onLoadSuccess = function(data) {
	Hg.showGridCellTip("waCompanyInfo_datagrid_insert",waCompanyInfoDatagrid_insert.tipCells);
}
Hg.removeMenu("waCompanyInfo_contextMenu");
/*

waCompanyInfoDatagrid.onRowContextMenu = function(e,row){
	Hg.removeMenu("waCompanyInfo_contextMenu");
	$('#waCompanyInfo_datagrid').datagrid("selectRow",row);
	e.preventDefault();
	$('#waCompanyInfo_contextMenu').menu('show', {
		left : e.pageX,
		top : e.pageY
	});
};

waCompanyInfoDatagrid.onDblClickRow = function(){
	$("#waCompanyInfo_toolbar [tag='view']").click();
};
*/

//去除input标签的记录功能
$('input:not([autocomplete]),textarea:not([autocomplete]),select:not([autocomplete])').attr('autocomplete', 'off');
