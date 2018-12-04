var waCompanyWaterDataNewDatagrid =  {};
//----需要悬浮提示的单元格
waCompanyWaterDataNewDatagrid.tipCells = ["descr"];
waCompanyWaterDataNewDatagrid.initwaCompanyWaterDataNew = function(){
   	Hg.fixTableHeight("waCompanyWaterDataNew_datagrid",true);
    //----------------------------------查询-----------------------------------------------------
	$("#waCompanyWaterDataNew_toolbar [tag='search']").click(function(){
		 $('#waCompanyWaterDataNew_datagrid').datagrid('load',{
             productName: $("[name='checkName']").val(),
		 });
		 
	});
 
    //----------------------------------清空-----------------------------------------------------
	$("#waCompanyWaterDataNew_toolbar [tag='clear']").click(function(){
		$('#waCompanyWaterDataNewForm').form('clear');
		$('#waCompanyWaterDataNew_datagrid').datagrid("load",{});
	});
	 //-------------------------------------------增加---------------------------------------------------
	$("#waCompanyWaterDataNew_toolbar [tag='add'],#waCompanyWaterDataNew_contextMenu [tag='add']").click(function(){
		waCompanyWaterDataNewDatagrid.mode = "add";
		var iconCls = $(this).attr("iconCls");
		var waCompanyWaterDataNewDetailWin = new HgWin({id:"waCompanyWaterDataNewDetailWin",title:"添加",width:850,height:400,iconCls:iconCls,url:"/wa/WaCompanyWaterDataNew/waCompanyWaterDataNewDetail/0"});
	});
	
	//-------------------------------------------修改---------------------------------------------------
	$("#waCompanyWaterDataNew_toolbar [tag='edit'],#waCompanyWaterDataNew_contextMenu [tag='edit']").click(function(){
		waCompanyWaterDataNewDatagrid.mode = "edit";
		var row = $("#waCompanyWaterDataNew_datagrid").datagrid("getSelected");
		if (!row) {
			$.messager.alert("提示","请选择一条数据","warning");
			return;
		}
		if (row.isFinal == 1) {
			$.messager.alert("提示","此条数据不可被修改","warning");
			return;
		}
		var id = row.companyWaterId;
		var editUrl = "/wa/WaCompanyWaterDataNew/waCompanyWaterDataNewDetail/"+id;
		var iconCls = $(this).attr("iconCls");
		var waCompanyWaterDataNewDetailWin = new HgWin({id:"waCompanyWaterDataNewDetailWin",title:"修改",width:850,height:380,iconCls:iconCls,url:editUrl});
	});
	
	//-------------------------------------------查看详情---------------------------------------------------
	$("#waCompanyWaterDataNew_toolbar [tag='view']").click(function(){
		waCompanyWaterDataNewDatagrid.mode = "view";
		var row = $("#waCompanyWaterDataNew_datagrid").datagrid("getSelected");
		if (!row) {
			$.messager.alert("提示","请选择一条数据","warning");
			return;
		}
		

		var id = row.companyWaterId;
		var url = "/wa/WaCompanyWaterDataNew/waCompanyWaterDataNewDetail/"+id;
		var iconCls = $(this).attr("iconCls");
		var waCompanyWaterDataNewDetailWin = new HgWin({id:"waCompanyWaterDataNewDetailWin",title:"查看详情",width:1050,height:380,iconCls:iconCls,url:url});
	});
	
	//-------------------------------------------删除---------------------------------------------------
	$("#waCompanyWaterDataNew_toolbar [tag='del'],#waCompanyWaterDataNew_contextMenu [tag='del']").click(function(){
		var row = $("#waCompanyWaterDataNew_datagrid").datagrid("getSelected");
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
				var id = row.companyWaterId;
				Hg.getJson("/wa/WaCompanyWaterDataNew/delete",{id:id},function(data){
					if (data.success) {
						$.messager.ok("删除成功!",function(){
							$('#waCompanyWaterDataNew_datagrid').datagrid("reload");
						});							
					} else {
						$.messager.alert("删除失败!",data.data);
					}
				});
			}
		});
		
		
	});
	
} 

waCompanyWaterDataNewDatagrid.initwaCompanyWaterDataNew();

waCompanyWaterDataNewDatagrid.onLoadSuccess = function(data) {  
	Hg.showGridCellTip("waCompanyWaterDataNew_datagrid",waCompanyWaterDataNewDatagrid.tipCells);
}
Hg.removeMenu("waCompanyWaterDataNew_contextMenu");

waCompanyWaterDataNewDatagrid.onRowContextMenu = function(e,row){
	Hg.removeMenu("waCompanyWaterDataNew_contextMenu");
	$('#waCompanyWaterDataNew_datagrid').datagrid("selectRow",row);
	e.preventDefault();
	$('#waCompanyWaterDataNew_contextMenu').menu('show', {
		left : e.pageX,
		top : e.pageY
	});
};

waCompanyWaterDataNewDatagrid.onDblClickRow = function(){
	$("#waCompanyWaterDataNew_toolbar [tag='view']").click();
};

