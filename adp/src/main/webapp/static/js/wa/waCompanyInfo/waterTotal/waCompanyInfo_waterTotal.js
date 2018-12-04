//@ sourceURL=waCompanyInfo_show.js
var waCompanyInfoDatagrid =  {};
//----需要悬浮提示的单元格
waCompanyInfoDatagrid.tipCells = ["descr"];
waCompanyInfoDatagrid.initwaCompanyInfo = function(){
   	Hg.fixTableHeight("waCompanyInfo_datagrid_waterTotal",true);
    //----------------------------------查询-----------------------------------------------------
	$("#waCompanyInfo_toolbar_waterTotal [tag='search']").click(function(){
		 $('#waCompanyInfo_datagrid_waterTotal').datagrid('load',{
             companyCode: $("[name='com_companyCode_waterTotal']").val(),
             companyName: $("[name='com_companyName_waterTotal']").val(),
             isImport: $("[name='com_isImport_waterTotal']").val()
		 });
	});

    //----------------------------------清空-----------------------------------------------------
	$("#waCompanyInfo_toolbar_waterTotal [tag='clear']").click(function(){
		$('#waCompanyInfoSearchForm_waterTotal').form('clear');
		$('#waCompanyInfo_datagrid_waterTotal').datagrid("load",{});
	});

    //-------------------------------------------用水情况统计信息---------------------------------------------------
    $("#waCompanyInfo_toolbar_waterTotal [tag='statisticsView']").click(function(){
        waCompanyInfoDatagrid.mode = "statisticsView";
        var row = $("#waCompanyInfo_datagrid_waterTotal").datagrid("getSelected");
        if (!row) {
            $.messager.alert("提示","请选择一条数据","warning");
            return;
        }

        var companyId = row.companyId;
        var url = "/wa/WaCompanyInfo/totalInfoDetail/"+companyId;
        var iconCls = $(this).attr("iconCls");
        var totalInfoDetailWin = new HgWin({id:"totalInfoDetailWin",title:"用水信息统计",width:1100,height:550,iconCls:iconCls,url:url});
    });

} 

waCompanyInfoDatagrid.initwaCompanyInfo();

waCompanyInfoDatagrid.onLoadSuccess = function(data) {  
	Hg.showGridCellTip("waCompanyInfo_datagrid_waterTotal",waCompanyInfoDatagrid.tipCells);
}
// Hg.removeMenu("waCompanyInfo_contextMenu");

waCompanyInfoDatagrid.onRowContextMenu = function(e,row){
	$('#waCompanyInfo_datagrid_waterTotal').datagrid("selectRow",row);
	e.preventDefault();
	$('#waCompanyInfo_contextMenu_waterTotal').menu('show', {
		left : e.pageX,
		top : e.pageY
	});
};

//去除input标签的记录功能
$('input:not([autocomplete]),textarea:not([autocomplete]),select:not([autocomplete])').attr('autocomplete', 'off');
