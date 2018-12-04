
waSpecialtradeConditionTableDatagrid.initSpecialtrade = function(specialId) {
    if (waSpecialtradeConditionTableDatagrid.mode == "edit") {
        $("#waCompanyWaterDataNew_edit_layout [name='companyId']").attr("disabled","disabled");
    }else if(waSpecialtradeConditionTableDatagrid.mode == "add"){
        specialId = 0;
        $("#waSpecialtrade_edit_layout [name='specialId']").val("");

    }
    Hg.refRepeatSubmit("waSpecialtrade_edit_form");//防止表单重复提交

    $('#waSpecialtrade_edit_form').validate({
        rules:{
            // planYear: { required: true ,rangelength:[1,100]},
            // companyName: { required: true ,rangelength:[1,100]}
        }
    });

    $("#waSpecialtrade_edit_layout [tag='ok']").click(function(){
        if (specialId == 0) {
            _saveSpecialtrade(true);
        } else {
            _saveSpecialtrade(false);
        }
    });


    $("#waSpecialtrade_edit_layout [tag='cancel']").click(function(){
        $("#waSpecialtrade_edit_layout").parent().window("close");
    });


    //私有页面方法------------------------------------------------------------------------------------------------------
    function _saveSpecialtrade(isAdd) {
        //验证表单--------------------------------------------------
        if(!$('#waSpecialtrade_edit_form').validate().form()) return false;
        $("#waSpecialtrade_edit_layout").block();
        //提交数据--------------------------------------------------
        var submitUrl = "/wa/WaSpecialtradeConditionTable/add";
        if (!isAdd) submitUrl = "/wa/WaSpecialtradeConditionTable/update";
        Hg.getJson(submitUrl,$("#waSpecialtrade_edit_form").serializeArray(),function(data){
            if (!data.success) {
                $("#waSpecialtrade_edit_layout").unblock();
                Hg.refreshSubmitToken("waSpecialtrade_edit_form");
                Hg.showErrorMsg("waSpecialtrade_edit_form",data.data);
            } else {
                $.messager.ok("保存数据成功!",function(){
                    $("#waSpecialtrade_edit_layout").parent().window("close");
                    $('#waSpecialtradeConditionTable_datagrid').datagrid("reload");
                });
            }
        });
    }
};

waSpecialtradeConditionTableDatagrid.initSpecialtrade(specialId);

//去除input标签的记录功能
$('input:not([autocomplete]),textarea:not([autocomplete]),select:not([autocomplete])').attr('autocomplete', 'off');

