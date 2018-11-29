waPlanConditionTableDatagrid.initPlanCondition = function(planCondtionId) {
    if (waPlanConditionTableDatagrid.mode == "edit") {
        $("#waPlanCondition_edit_layout [name='planCondtionId']").attr("disabled","disabled");
    }else if(waPlanConditionTableDatagrid.mode == "add"){
        planCondtionId = 0;
        $("#waPlanCondition_edit_layout [name='planCondtionId']").val("");

    }
    Hg.refRepeatSubmit("waPlanCondition_edit_form");//防止表单重复提交

    $('#waPlanCondition_edit_form').validate({
        rules:{
            // planYear: { required: true ,rangelength:[1,100]},
            // companyName: { required: true ,rangelength:[1,100]}
        }
    });

    $("#waPlanCondition_edit_layout [tag='ok']").click(function(){
        if (planCondtionId == 0) {
            _saveplanCondtion(true);
        } else {
            _saveplanCondtion(false);
        }
    });

    $("#waPlanCondition_edit_layout [tag='cancel']").click(function(){
        $("#waPlanCondition_edit_layout").parent().window("close");
    });


    //私有页面方法------------------------------------------------------------------------------------------------------
    function _saveplanCondtion(isAdd) {
        //验证表单--------------------------------------------------
        if(!$('#waPlanCondition_edit_form').validate().form()) return false;
        $("#waPlanCondition_edit_layout").block();
        //提交数据--------------------------------------------------
        var submitUrl = "/wa/WaPlanConditionTable/add";
        if (!isAdd) submitUrl = "/wa/WaPlanConditionTable/update";
        Hg.getJson(submitUrl,$("#waPlanCondition_edit_form").serializeArray(),function(data){
            if (!data.success) {
                $("#waPlanCondition_edit_layout").unblock();
                Hg.refreshSubmitToken("waPlanCondition_edit_form");
                Hg.showErrorMsg("waPlanCondition_edit_form",data.data);
            } else {
                $.messager.ok("保存数据成功!",function(){
                    $("#waPlanCondition_edit_layout").parent().window("close");
                    $('#waPlanConditionTable_datagrid').datagrid("reload");
                });
            }
        });
    }
};

waPlanConditionTableDatagrid.initPlanCondition(planCondtionId);

//去除input标签的记录功能
$('input:not([autocomplete]),textarea:not([autocomplete]),select:not([autocomplete])').attr('autocomplete', 'off');

