
waInterwaterInstallationTableDatagrid.initwaWaterData = function(interwaterId) {
    if (waInterwaterInstallationTableDatagrid.mode == "edit") {
        $("#waCompanyWaterDataNew_edit_layout [name='companyId']").attr("disabled","disabled");
    }else if(waInterwaterInstallationTableDatagrid.mode == "add"){
        interwaterId = 0;
        $("#waInterwater_edit_layout [name='interwaterId']").val("");
    }else if(waInterwaterInstallationTableDatagrid.mode == "view") {
        //查看详情时移除按钮
        $("#waInterwater_edit_layout [tag='ok']").parent().remove();
    }
    Hg.refRepeatSubmit("waInterwater_edit_form");//防止表单重复提交

    $('#waInterwater_edit_form').validate({
        rules:{
            // planYear: { required: true ,rangelength:[1,100]},
            // companyName: { required: true ,rangelength:[1,100]}
        }
    });

    $("#waInterwater_edit_layout [tag='ok']").click(function(){
        if (interwaterId == 0) {
            _sveInterwater(true);
        } else {
            _sveInterwater(false);
        }
    });


    $("#waInterwater_edit_layout [tag='cancel']").click(function(){
        $("#waInterwater_edit_layout").parent().window("close");
    });


    //私有页面方法------------------------------------------------------------------------------------------------------
    function _sveInterwater(isAdd) {
        //验证表单--------------------------------------------------
        if(!$('#waInterwater_edit_form').validate().form()) return false;
        $("#waInterwater_edit_layout").block();
        //提交数据--------------------------------------------------
        var submitUrl = "/wa/WaInterwaterInstallationTable/add";
        if (!isAdd) submitUrl = "/wa/WaInterwaterInstallationTable/update";
        Hg.getJson(submitUrl,$("#waInterwater_edit_form").serializeArray(),function(data){
            if (!data.success) {
                $("#waInterwater_edit_layout").unblock();
                Hg.refreshSubmitToken("waInterwater_edit_form");
                Hg.showErrorMsg("waInterwater_edit_form",data.data);
            } else {
                $.messager.ok("保存数据成功!",function(){
                    $("#waInterwater_edit_layout").parent().window("close");
                    $('#waInterwaterInstallationTable_datagrid').datagrid("reload");
                });
            }
        });
    }
};

waInterwaterInstallationTableDatagrid.initwaWaterData(interwaterId);

//去除input标签的记录功能
$('input:not([autocomplete]),textarea:not([autocomplete]),select:not([autocomplete])').attr('autocomplete', 'off');

