var waRainSurfaceConditionTableDatagrid =  {};
//----需要悬浮提示的单元格
waRainSurfaceConditionTableDatagrid.tipCells = ["descr"];
waRainSurfaceConditionTableDatagrid.initwaRainSurfaceConditionTable = function(){
   	Hg.fixTableHeight("waRainSurfaceConditionTable_datagrid",true);
    //----------------------------------查询-----------------------------------------------------
	$("#waRainSurfaceConditionTable_toolbar [tag='search']").click(function(){
		 $('#waRainSurfaceConditionTable_datagrid').datagrid('load',{
             companyCode: $("[name='companyCode']").val(),
             companyName: $("[name='companyName']").val()
		 });
		 
	});
 
    //----------------------------------清空-----------------------------------------------------
	$("#waRainSurfaceConditionTable_toolbar [tag='clear']").click(function(){
		$('#waRainSurfaceConditionTableForm').form('clear');
		$('#waRainSurfaceConditionTable_datagrid').datagrid("load",{});
	});
	 //-------------------------------------------增加---------------------------------------------------
	$("#waRainSurfaceConditionTable_toolbar [tag='add'],#waRainSurfaceConditionTable_contextMenu [tag='add']").click(function(){
		waRainSurfaceConditionTableDatagrid.mode = "add";
		var iconCls = $(this).attr("iconCls");
		var waRainSurfaceConditionTableDetailWin = new HgWin({id:"waRainSurfaceConditionTableDetailWin",title:"添加",width:850,height:400,iconCls:iconCls,url:"/wa/WaRainSurfaceConditionTable/waRainSurfaceConditionTableDetail/0"});
	});
	
	//-------------------------------------------修改---------------------------------------------------
	$("#waRainSurfaceConditionTable_toolbar [tag='edit'],#waRainSurfaceConditionTable_contextMenu [tag='edit']").click(function(){
		waRainSurfaceConditionTableDatagrid.mode = "edit";
		var row = $("#waRainSurfaceConditionTable_datagrid").datagrid("getSelected");
		if (!row) {
			$.messager.alert("提示","请选择一条数据","warning");
			return;
		}
		if (row.isFinal == 1) {
			$.messager.alert("提示","此条数据不可被修改","warning");
			return;
		}
		var id = row.rainSurfaceId;
		var editUrl = "/wa/WaRainSurfaceConditionTable/waRainSurfaceConditionTableDetail/"+id;
		var iconCls = $(this).attr("iconCls");
		var waRainSurfaceConditionTableDetailWin = new HgWin({id:"waRainSurfaceConditionTableDetailWin",title:"修改",width:850,height:380,iconCls:iconCls,url:editUrl});
	});
	
	//-------------------------------------------查看详情---------------------------------------------------
	$("#waRainSurfaceConditionTable_toolbar [tag='view']").click(function(){
		waRainSurfaceConditionTableDatagrid.mode = "view";
		var row = $("#waRainSurfaceConditionTable_datagrid").datagrid("getSelected");
		if (!row) {
			$.messager.alert("提示","请选择一条数据","warning");
			return;
		}
		var id = row.rainSurfaceId;
		var url = "/wa/WaRainSurfaceConditionTable/waRainSurfaceConditionTableDetail/"+id;
		var iconCls = $(this).attr("iconCls");
		var waRainSurfaceConditionTableDetailWin = new HgWin({id:"waRainSurfaceConditionTableDetailWin",title:"查看详情",width:850,height:380,iconCls:iconCls,url:url});
	});
	
	//-------------------------------------------删除---------------------------------------------------
	$("#waRainSurfaceConditionTable_toolbar [tag='del'],#waRainSurfaceConditionTable_contextMenu [tag='del']").click(function(){
		var row = $("#waRainSurfaceConditionTable_datagrid").datagrid("getSelected");
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
				var id = row.rainSurfaceId;
				Hg.getJson("/wa/WaRainSurfaceConditionTable/delete",{id:id},function(data){
					if (data.success) {
						$.messager.ok("删除成功!",function(){
							$('#waRainSurfaceConditionTable_datagrid').datagrid("reload");
						});							
					} else {
						$.messager.alert("删除失败!",data.data);
					}
				});
			}
		});
		
		
	});
	
} 

waRainSurfaceConditionTableDatagrid.initwaRainSurfaceConditionTable();

waRainSurfaceConditionTableDatagrid.onLoadSuccess = function(data) {  
	Hg.showGridCellTip("waRainSurfaceConditionTable_datagrid",waRainSurfaceConditionTableDatagrid.tipCells);
}
Hg.removeMenu("waRainSurfaceConditionTable_contextMenu");

waRainSurfaceConditionTableDatagrid.onRowContextMenu = function(e,row){
	Hg.removeMenu("waRainSurfaceConditionTable_contextMenu");
	$('#waRainSurfaceConditionTable_datagrid').datagrid("selectRow",row);
	e.preventDefault();
	$('#waRainSurfaceConditionTable_contextMenu').menu('show', {
		left : e.pageX,
		top : e.pageY
	});
};

waRainSurfaceConditionTableDatagrid.onDblClickRow = function(){
	$("#waRainSurfaceConditionTable_toolbar [tag='view']").click();
};

