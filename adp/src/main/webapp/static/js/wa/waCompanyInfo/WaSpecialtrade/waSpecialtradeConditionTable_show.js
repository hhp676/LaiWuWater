var waSpecialtradeConditionTableDatagrid =  {};
//----需要悬浮提示的单元格
waSpecialtradeConditionTableDatagrid.tipCells = ["descr"];
waSpecialtradeConditionTableDatagrid.initwaSpecialtradeConditionTable = function(){
   	Hg.fixTableHeight("waSpecialtradeConditionTable_datagrid",true);
    //----------------------------------查询-----------------------------------------------------
	$("#waSpecialtradeConditionTable_toolbar [tag='search']").click(function(){
		 $('#waSpecialtradeConditionTable_datagrid').datagrid('load',{
             companyCode: $("[name='companyCode']").val(),
             companyName: $("[name='companyName']").val()
		 });
		 
	});
 
    //----------------------------------清空-----------------------------------------------------
	$("#waSpecialtradeConditionTable_toolbar [tag='clear']").click(function(){
		$('#waSpecialtradeConditionTableSearchForm').form('clear');
		$('#waSpecialtradeConditionTable_datagrid').datagrid("load",{});
	});
	 //-------------------------------------------增加---------------------------------------------------
	$("#waSpecialtradeConditionTable_toolbar [tag='add'],#waSpecialtradeConditionTable_contextMenu [tag='add']").click(function(){
		waSpecialtradeConditionTableDatagrid.mode = "add";
		var iconCls = $(this).attr("iconCls");
		var waSpecialtradeConditionTableDetailWin = new HgWin({id:"waSpecialtradeConditionTableDetailWin",title:"添加",width:850,height:400,iconCls:iconCls,url:"/wa/WaSpecialtradeConditionTable/waSpecialtradeConditionTableDetail/0"});
	});
	
	//-------------------------------------------修改---------------------------------------------------
	$("#waSpecialtradeConditionTable_toolbar [tag='edit'],#waSpecialtradeConditionTable_contextMenu [tag='edit']").click(function(){
		waSpecialtradeConditionTableDatagrid.mode = "edit";
		var row = $("#waSpecialtradeConditionTable_datagrid").datagrid("getSelected");
		if (!row) {
			$.messager.alert("提示","请选择一条数据","warning");
			return;
		}
		if (row.isFinal == 1) {
			$.messager.alert("提示","此条数据不可被修改","warning");
			return;
		}
		var id = row.specialId;
		var editUrl = "/wa/WaSpecialtradeConditionTable/waSpecialtradeConditionTableDetail/"+id;
		var iconCls = $(this).attr("iconCls");
		var waSpecialtradeConditionTableDetailWin = new HgWin({id:"waSpecialtradeConditionTableDetailWin",title:"修改",width:850,height:380,iconCls:iconCls,url:editUrl});
	});
	
	//-------------------------------------------查看详情---------------------------------------------------
	$("#waSpecialtradeConditionTable_toolbar [tag='view']").click(function(){
		waSpecialtradeConditionTableDatagrid.mode = "view";
		var row = $("#waSpecialtradeConditionTable_datagrid").datagrid("getSelected");
		if (!row) {
			$.messager.alert("提示","请选择一条数据","warning");
			return;
		}
		

		var id = row.specialId;
		var url = "/wa/WaSpecialtradeConditionTable/waSpecialtradeConditionTableDetail/"+id;
		var iconCls = $(this).attr("iconCls");
		var waSpecialtradeConditionTableDetailWin = new HgWin({id:"waSpecialtradeConditionTableDetailWin",title:"查看详情",width:850,height:380,iconCls:iconCls,url:url});
	});
	
	//-------------------------------------------删除---------------------------------------------------
	$("#waSpecialtradeConditionTable_toolbar [tag='del'],#waSpecialtradeConditionTable_contextMenu [tag='del']").click(function(){
		var row = $("#waSpecialtradeConditionTable_datagrid").datagrid("getSelected");
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
				var id = row.specialId;
				Hg.getJson("/wa/WaSpecialtradeConditionTable/delete",{id:id},function(data){
					if (data.success) {
						$.messager.ok("删除成功!",function(){
							$('#waSpecialtradeConditionTable_datagrid').datagrid("reload");
						});							
					} else {
						$.messager.alert("删除失败!",data.data);
					}
				});
			}
		});
		
		
	});
	
} 

waSpecialtradeConditionTableDatagrid.initwaSpecialtradeConditionTable();

waSpecialtradeConditionTableDatagrid.onLoadSuccess = function(data) {  
	Hg.showGridCellTip("waSpecialtradeConditionTable_datagrid",waSpecialtradeConditionTableDatagrid.tipCells);
}
Hg.removeMenu("waSpecialtradeConditionTable_contextMenu");

waSpecialtradeConditionTableDatagrid.onRowContextMenu = function(e,row){
	Hg.removeMenu("waSpecialtradeConditionTable_contextMenu");
	$('#waSpecialtradeConditionTable_datagrid').datagrid("selectRow",row);
	e.preventDefault();
	$('#waSpecialtradeConditionTable_contextMenu').menu('show', {
		left : e.pageX,
		top : e.pageY
	});
};

waSpecialtradeConditionTableDatagrid.onDblClickRow = function(){
	$("#waSpecialtradeConditionTable_toolbar [tag='view']").click();
};

