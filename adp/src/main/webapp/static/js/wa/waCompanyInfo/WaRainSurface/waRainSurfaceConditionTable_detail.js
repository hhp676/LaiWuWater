
waRainSurfaceConditionTableDatagrid.initRainSurface = function(rainSurfaceId) {
    if (waRainSurfaceConditionTableDatagrid.mode == "edit") {
        // $("#waRainSurface_edit_layout [name='rainSurfaceId']").attr("disabled","disabled");
    }else if(waRainSurfaceConditionTableDatagrid.mode == "add"){
        rainSurfaceId = 0;
        $("#waRainSurface_edit_layout [name='rainSurfaceId']").val("");
    }else if(waRainSurfaceConditionTableDatagrid.mode == "view") {
        //查看详情时移除按钮
        $("#waRainSurface_edit_layout [tag='ok']").parent().remove();
    }
    Hg.refRepeatSubmit("waRainSurface_edit_form");//防止表单重复提交

    $('#waRainSurface_edit_form').validate({
        rules:{
            // planYear: { required: true ,rangelength:[1,100]},
            // companyName: { required: true ,rangelength:[1,100]}
        }
    });

    $("#waRainSurface_edit_layout [tag='ok']").click(function(){
        if (rainSurfaceId == 0) {
            _saveRainSurface(true);
        } else {
            _saveRainSurface(false);
        }
    });

    $("#waRainSurface_edit_layout [tag='cancel']").click(function(){
        $("#waRainSurface_edit_layout").parent().window("close");
    });


    //私有页面方法------------------------------------------------------------------------------------------------------
    function _saveRainSurface(isAdd) {
        //验证表单--------------------------------------------------
        if(!$('#waRainSurface_edit_form').validate().form()) return false;
        $("#waRainSurface_edit_layout").block();
        //提交数据--------------------------------------------------
        var submitUrl = "/wa/WaRainSurfaceConditionTable/add";
        if (!isAdd) submitUrl = "/wa/WaRainSurfaceConditionTable/update";
        Hg.getJson(submitUrl,$("#waRainSurface_edit_form").serializeArray(),function(data){
            if (!data.success) {
                $("#waRainSurface_edit_layout").unblock();
                Hg.refreshSubmitToken("waRainSurface_edit_form");
                Hg.showErrorMsg("waRainSurface_edit_form",data.data);
            } else {
                $.messager.ok("保存数据成功!",function(){
                    $("#waRainSurface_edit_layout").parent().window("close");
                    $('#waRainSurfaceConditionTable_datagrid').datagrid("reload");
                });
            }
        });
    }
};

waRainSurfaceConditionTableDatagrid.initRainSurface(rainSurfaceId);

//去除input标签的记录功能
$('input:not([autocomplete]),textarea:not([autocomplete]),select:not([autocomplete])').attr('autocomplete', 'off');

