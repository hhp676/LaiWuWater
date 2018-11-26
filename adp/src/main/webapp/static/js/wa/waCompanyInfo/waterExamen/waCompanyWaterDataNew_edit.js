
waCompanyWaterDataNewDatagrid.initwaWaterData = function(companyWaterId) {
    if (waCompanyWaterDataNewDatagrid.mode == "edit") {
        $("#waCompanyWaterDataNew_edit_layout [name='companyWaterId']").attr("disabled","disabled");
    }else if(waCompanyWaterDataNewDatagrid.mode == "add"){
        companyWaterId = 0;
        $("#waCompanyWaterDataNew_edit_layout [name='companyWaterId']").val("");
       
    }
    Hg.refRepeatSubmit("waCompanyWaterDataNew_edit_form");//防止表单重复提交

    $('#waCompanyWaterDataNew_edit_form').validate({
        rules:{
            // planYear: { required: true ,rangelength:[1,100]},
            // companyName: { required: true ,rangelength:[1,100]}
        }
    });

    $("#waCompanyWaterDataNew_edit_layout [tag='ok']").click(function(){
        if (companyWaterId == 0) {
            _saveWaWaterWater(true);
        } else {
            _saveWaWaterWater(false);
        }
    });


    $("#waCompanyWaterDataNew_edit_layout [tag='cancel']").click(function(){
        $("#waCompanyWaterDataNew_edit_layout").parent().window("close");
    });


    //私有页面方法------------------------------------------------------------------------------------------------------
    function _saveWaWaterWater(isAdd) {
        //验证表单--------------------------------------------------
        if(!$('#waCompanyWaterDataNew_edit_form').validate().form()) return false;
        $("#waCompanyWaterDataNew_edit_layout").block();
        //提交数据--------------------------------------------------
        var submitUrl = "/wa/WaCompanyWaterDataNew/add";
        if (!isAdd) submitUrl = "/wa/WaCompanyWaterDataNew/update";
        Hg.getJson(submitUrl,$("#waCompanyWaterDataNew_edit_form").serializeArray(),function(data){
            if (!data.success) {
                $("#waCompanyWaterDataNew_edit_layout").unblock();
                Hg.refreshSubmitToken("waCompanyWaterDataNew_edit_form");
                Hg.showErrorMsg("waCompanyWaterDataNew_edit_form",data.data);
            } else {
                $.messager.ok("保存数据成功!",function(){
                    $("#waCompanyWaterDataNew_edit_layout").parent().window("close");
                    $('#waCompanyWaterDataNew_datagrid').datagrid("reload");
                });
            }
        });
    }
};

waCompanyWaterDataNewDatagrid.initwaWaterData(companyWaterId);

//去除input标签的记录功能
$('input:not([autocomplete]),textarea:not([autocomplete]),select:not([autocomplete])').attr('autocomplete', 'off');

