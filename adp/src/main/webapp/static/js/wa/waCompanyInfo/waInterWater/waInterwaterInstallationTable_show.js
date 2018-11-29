var waInterwaterInstallationTableDatagrid =  {};
//----需要悬浮提示的单元格
waInterwaterInstallationTableDatagrid.tipCells = ["descr"];
waInterwaterInstallationTableDatagrid.initwaInterwaterInstallationTable = function(){
   	Hg.fixTableHeight("waInterwaterInstallationTable_datagrid",true);
    //----------------------------------查询-----------------------------------------------------
	$("#waInterwaterInstallationTable_toolbar [tag='search']").click(function(){
		 $('#waInterwaterInstallationTable_datagrid').datagrid('load',{
             companyCode: $("[name='interWaterCompanyCode']").val(),
             companyName: $("[name='interWaterCompanyName']").val()

		 });
		 
	});
 
    //----------------------------------清空-----------------------------------------------------
	$("#waInterwaterInstallationTable_toolbar [tag='clear']").click(function(){
		$('#waInterwaterInstallationTableForm').form('clear');
		$('#waInterwaterInstallationTable_datagrid').datagrid("load",{});
	});
	 //-------------------------------------------增加---------------------------------------------------
	$("#waInterwaterInstallationTable_toolbar [tag='add'],#waInterwaterInstallationTable_contextMenu [tag='add']").click(function(){
		waInterwaterInstallationTableDatagrid.mode = "add";
		var iconCls = $(this).attr("iconCls");
		var waInterwaterInstallationTableDetailWin = new HgWin({id:"waInterwaterInstallationTableDetailWin",title:"添加",width:850,height:400,iconCls:iconCls,url:"/wa/WaInterwaterInstallationTable/waInterwaterInstallationTableDetail/0"});
	});
	
	//-------------------------------------------修改---------------------------------------------------
	$("#waInterwaterInstallationTable_toolbar [tag='edit'],#waInterwaterInstallationTable_contextMenu [tag='edit']").click(function(){
		waInterwaterInstallationTableDatagrid.mode = "edit";
		var row = $("#waInterwaterInstallationTable_datagrid").datagrid("getSelected");
		if (!row) {
			$.messager.alert("提示","请选择一条数据","warning");
			return;
		}
		if (row.isFinal == 1) {
			$.messager.alert("提示","此条数据不可被修改","warning");
			return;
		}
		var interwaterId = row.interwaterId;
		var editUrl = "/wa/WaInterwaterInstallationTable/waInterwaterInstallationTableDetail/"+interwaterId;
		var iconCls = $(this).attr("iconCls");
		var waInterwaterInstallationTableDetailWin = new HgWin({id:"waInterwaterInstallationTableDetailWin",title:"修改",width:850,height:380,iconCls:iconCls,url:editUrl});
	});
	
	//-------------------------------------------查看详情---------------------------------------------------
	$("#waInterwaterInstallationTable_toolbar [tag='view']").click(function(){
		waInterwaterInstallationTableDatagrid.mode = "view";
		var row = $("#waInterwaterInstallationTable_datagrid").datagrid("getSelected");
		if (!row) {
			$.messager.alert("提示","请选择一条数据","warning");
			return;
		}
		

		var id = row.interwaterId;
		var url = "/wa/WaInterwaterInstallationTable/waInterwaterInstallationTableDetail/"+id;
		var iconCls = $(this).attr("iconCls");
		var waInterwaterInstallationTableDetailWin = new HgWin({id:"waInterwaterInstallationTableDetailWin",title:"查看详情",width:850,height:380,iconCls:iconCls,url:url});
	});
	
	//-------------------------------------------删除---------------------------------------------------
	$("#waInterwaterInstallationTable_toolbar [tag='del'],#waInterwaterInstallationTable_contextMenu [tag='del']").click(function(){
		var row = $("#waInterwaterInstallationTable_datagrid").datagrid("getSelected");
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
				var id = row.interwaterId;
				Hg.getJson("/wa/WaInterwaterInstallationTable/delete",{id:id},function(data){
					if (data.success) {
						$.messager.ok("删除成功!",function(){
							$('#waInterwaterInstallationTable_datagrid').datagrid("reload");
						});							
					} else {
						$.messager.alert("删除失败!",data.data);
					}
				});
			}
		});
		
		
	});
	
} 

waInterwaterInstallationTableDatagrid.initwaInterwaterInstallationTable();

waInterwaterInstallationTableDatagrid.onLoadSuccess = function(data) {  
	Hg.showGridCellTip("waInterwaterInstallationTable_datagrid",waInterwaterInstallationTableDatagrid.tipCells);
}
Hg.removeMenu("waInterwaterInstallationTable_contextMenu");

waInterwaterInstallationTableDatagrid.onRowContextMenu = function(e,row){
	Hg.removeMenu("waInterwaterInstallationTable_contextMenu");
	$('#waInterwaterInstallationTable_datagrid').datagrid("selectRow",row);
	e.preventDefault();
	$('#waInterwaterInstallationTable_contextMenu').menu('show', {
		left : e.pageX,
		top : e.pageY
	});
};

waInterwaterInstallationTableDatagrid.onDblClickRow = function(){
	$("#waInterwaterInstallationTable_toolbar [tag='view']").click();
};

