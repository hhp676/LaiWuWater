
waCompanyInfoDatagrid.initTotal = function(companyId, commFacWaterWaterId,interWaterId,rainSurfaceWaterId,planConditionWaterId,specialWaterId){
    var commFacWaterAdd = commFacWaterWaterId == 0;
    var interwaterAdd = interWaterId == 0;
    var rainSurfaceAdd = rainSurfaceWaterId == 0;
    var planConditionAdd = planConditionWaterId == 0;
    var specialAdd = specialWaterId == 0;


    $("#waCompanyInfo_totalInfoInsert_layout [tag='ok']").click(function(){
        var resultBol1, resultBol12,resultBol13,resultBol14,resultBol15,resultBol16;

        if(commFacWaterAdd){
            _saveWaterInfoData(true, "commFacWater_form", "/wa/WaCompanyWaterDataNew/add");
        }else{
             _saveWaterInfoData(false, "commFacWater_form", "/wa/WaCompanyWaterDataNew/add");
        }
        if(interwaterAdd){
            _saveWaterInfoData(true,"interwater_form", "/wa/WaInterwaterInstallationTable/add");
        }else{
            _saveWaterInfoData(false);
        }
        if(rainSurfaceAdd){
            _saveWaterInfoData(true, "rainSurface_form", "/wa/WaRainSurfaceConditionTable/add");
        }else{
            _saveWaterInfoData(false);
        }
        if(planConditionAdd){
            _saveWaterInfoData(true, "planCondition_form", "/wa/WaPlanConditionTable/add");
        }else{
            _saveWaterInfoData(false);
        }
        if(specialAdd){
            _saveWaterInfoData(true, "special_form", "/wa/WaSpecialtradeConditionTable/add");
        }else{
            _saveWaterInfoData(false);
        }

        $.messager.ok("保存数据成功!");
        $("#waCompanyInfo_totalInfoInsert_layout").parent().window("close");
    });

    //私有页面方法------------------------------------------------------------------------------------------------------
    function _saveWaterInfoData(isAdd,formId, submitUrl) {
        //验证表单--------------------------------------------------
        if(!$('#'+formId).validate().form()) return false;
        $("#"+formId).block();   //遮罩层
        //提交数据--------------------------------------------------
        Hg.getJson(submitUrl,$("#"+formId).serializeArray(),function(data){
            if (!data.success) {
                $("#"+formId).unblock();
            } else {
                console.log("数据保存成功");
            }
        });
      /* $.ajax({
               url: G_CTX_PATH + submitUrl,
               type: 'post',
               dataType: 'json',
               contentType: "application/json",
               data: $("#"+formId).serializeArray(),
               async: true,
               success: function (data) {
                   console.log("数据保存成功");
               },
               error: function (data) {
                   $.messager.ok("数据保存失败!");
               }
       })*/
    }

//-------------取消操作------------------------------------------------
    $("#waCompanyInfo_totalInfoInsert_layout [tag='cancel']").click(function(){
        $("#waCompanyInfo_totalInfoInsert_layout").parent().window("close");
    });
}

waCompanyInfoDatagrid.initTotal(companyId, commFacWaterWaterId,interWaterId,rainSurfaceWaterId,planConditionWaterId,specialWaterId);