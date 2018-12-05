
waCompanyInfoDatagrid.initTotal = function(companyId, commFacWaterWaterId,interWaterId,rainSurfaceWaterId,planConditionWaterId,specialWaterId){
    var commFacWaterAdd = commFacWaterWaterId == 0;
    var interwaterAdd = interWaterId == 0;
    var rainSurfaceAdd = rainSurfaceWaterId == 0;
    var planConditionAdd = planConditionWaterId == 0;
    var specialAdd = specialWaterId == 0;

    $("#waCompanyInfo_totalInfoInsert_layout [tag='ok']").click(function(){

        // var resultBol1, resultBol12,resultBol13,resultBol14,resultBol15,resultBol16;
        if(commFacWaterAdd){
            debugger
            _savecommFacWaterData(true);
        }else{
            _savecommFacWaterData(false);
        }
      /*  if(interwaterAdd){
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
        }*/

        // $.messager.ok("保存数据成功!");
        // $("#waCompanyInfo_totalInfo_layout").parent().window("close");
    });

   /* //私有页面方法------------------------------------------------------------------------------------------------------
    function _saveWaterInfoData(isAdd) {
        //验证表单--------------------------------------------------
        if(!$('#commFacWater_form').validate().form()) return false;
        $("#commFacWater_form").block();   //遮罩层
        //提交数据--------------------------------------------------
        Hg.getJson("/wa/WaCompanyWaterDataNew/add",{},function(data){
            if (!data.success) {
                $("#commFacWater_form").unblock();
                // Hg.refreshSubmitToken("waCompanyWaterDataNew_edit_form");
                Hg.showErrorMsg("waCompanyWaterDataNew_edit_form",data.data);
            } else {
                alert("111");
                // console.log("数据保存成功");
               /!* $.messager.ok("保存数据成功!",function(){
                    $("#waCompanyWaterDataNew_edit_layout").parent().window("close");
                    $('#waCompanyWaterDataNew_datagrid').datagrid("reload");
                });*!/
            }
        });
    }*/


    function _savecommFacWaterData(isAdd){

        //验证公共设施用水表单--------------------------------------------------
        if(!$('#commFacWater_form').validate().form()) return false;
        $("#commFacWater_layout").block();
        //提交数据--------------------------------------------------
        var submitUrl = "/wa/WaCompanyWaterDataNew/add";
        if (!isAdd) submitUrl = "/wa/WaCompanyWaterDataNew/update";
        alert(submitUrl);
        Hg.getJson(submitUrl,$("#commFacWater_form").serializeArray(),function(data){
            if (!data.success) {
                $("#commFacWater_layout").unblock();
                Hg.refreshSubmitToken("commFacWater_form");
                Hg.showErrorMsg("commFacWater_form",data.data);
            } else {
                alert("suc");
                $.messager.ok("保存数据成功!",function(){
                    $("#waCompanyInfo_layout").parent().window("close");
                    $('#waCompanyInfo_datagrid').datagrid("reload");
                });
            }
        });
    }

    function _saveIndustryWater(isAdd){
        //验证工业用水表单--------------------------------------------------
        if(!$('#industryWater_form').validate().form()) return false;
        $("#industryWater_layout").block();
        //提交数据--------------------------------------------------
        var submitUrl = "/wa/WaIndustryWaterData/add";
        if (!isAdd) submitUrl = "/wa/WaIndustryWaterData/update";
        Hg.getJson(submitUrl,$("#industryWater_form").serializeArray(),function(data){
            if (!data.success) {
                // $("#industryWater_layout").unblock();
                // Hg.refreshSubmitToken("industryWater_form");
                // Hg.showErrorMsg("industryWater_form",data.data);
            } else {
                // _saveDormitoryWaterData(isAdd);
               /* $.messager.ok("保存数据成功!",function(){
                    /!*  $("#waCompanyInfo_layout").parent().window("close");
                     $('#waCompanyInfo_datagrid').datagrid("reload");*!/
                });*/
            }
        });
    }

    function _saveDormitoryWaterData(isAdd){
        //验证工业用水表单--------------------------------------------------
        if(!$('#dormitoryWater_form').validate().form()) return false;
        $("#dormitoryWater_layout").block();
        //提交数据--------------------------------------------------
        var submitUrl = "/wa/WaDormitoryWaterData/add";
        if (!isAdd) submitUrl = "/wa/WaDormitoryWaterData/update";
        Hg.getJson(submitUrl,$("#dormitoryWater_form").serializeArray(),function(data){
            if (!data.success) {
                $("#dormitoryWater_layout").unblock();
                Hg.refreshSubmitToken("dormitoryWater_form");
                Hg.showErrorMsg("dormitoryWater_form",data.data);
            } else {
                // $.messager.ok("保存数据成功!");
            }
        });
    }
//-------------取消操作------------------------------------------------
    $("#waCompanyInfo_totalInfo_layout [tag='cancel']").click(function(){
        $("#waCompanyInfo_totalInfo_layout").parent().window("close");
    });
}

waCompanyInfoDatagrid.initTotal(companyId, commFacWaterWaterId,interWaterId,rainSurfaceWaterId,planConditionWaterId,specialWaterId);