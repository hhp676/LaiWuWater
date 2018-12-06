
waCompanyInfoDatagrid.initTotal = function(companyId, commFacWaterWaterId,interWaterId,rainSurfaceWaterId,planConditionWaterId,specialWaterId){
    var commFacWaterAdd = commFacWaterWaterId == 0;
    var interwaterAdd = interWaterId == 0;
    var rainSurfaceAdd = rainSurfaceWaterId == 0;
    var planConditionAdd = planConditionWaterId == 0;
    var specialAdd = specialWaterId == 0;
    //定义规则：企业用水情况调查
    $('#commFacWater_form').validate({
        rules: {
            productName: {required: true, rangelength: [1, 100]},
            newWaterCount: {required: true, rangelength: [1, 100]},
            totalCount: {required: true, rangelength: [1, 100]},
            waterStandard: {required: true, rangelength: [1, 100]},
            employee: {required: true, rangelength: [1, 100]},
            gongyeWaterCount: {required: true, rangelength: [1, 100]},
            gongyiWaterCount: {required: true, rangelength: [1, 100]},
            boilerWater: {required: true, rangelength: [1, 100]},
            factoryLiveWater: {required: true, rangelength: [1, 100]},
            reuseTotalAmount: {required: true, rangelength: [1, 100]},
            availability: {required: true, rangelength: [1, 100]},
            interColdWaterLoopAmount: {required: true, rangelength: [1, 100]},
            steamCondenBackAmount: {required: true, rangelength: [1, 100]},
            freshWaterBackAmount: {required: true, rangelength: [1, 100]},
            recoverRate: {required: true, rangelength: [1, 100]},
            saveAmount: {required: true, rangelength: [1, 100]},
            installMoney: {required: true, rangelength: [1, 100]}

        }
    });


//定义规则：中水回用设施情况调查
    $('#interwater_form').validate({
        rules: {
            unitName: {required: true, rangelength: [1, 100]},
            productName: {required: true, rangelength: [1, 100]},
            handleTech: {required: true, rangelength: [1, 100]},
            recoverWaterCount: {required: true, rangelength: [1, 100]},
            actWaterCount: {required: true, rangelength: [1, 100]},
            runtime: {required: true, rangelength: [1, 100]},
            investMoney: {required: true, rangelength: [1, 100]},
            runCost: {required: true, rangelength: [1, 100]},
            interwaterPrice: {required: true, rangelength: [1, 100]},
            interwaterPiping: {required: true, rangelength: [1, 100]},
            use: {required: true, rangelength: [1, 100]},
            flag: {required: true, rangelength: [1, 100]}

        }
    });

    //定义规则：雨水地表水使用情况调查
    $('#rainSurface_form').validate({
        rules: {
            unitName: {required: true, rangelength: [1, 100]},
            rainWaterVolume: {required: true, rangelength: [1, 100]},
            rainActAmount: {required: true, rangelength: [1, 100]},
            rainUseTime: {required: true, rangelength: [1, 100]},
            rainProjectInvest: {required: true, rangelength: [1, 100]},
            surfaceWaterVolume: {required: true, rangelength: [1, 100]},
            surfaceActAmount: {required: true, rangelength: [1, 100]},
            surfaceUseTime: {required: true, rangelength: [1, 100]},
            surfaceProjectInvest: {required: true, rangelength: [1, 100]},
            purpose: {required: true, rangelength: [1, 100]},
            flag: {required: true, rangelength: [1, 100]}

        }
    });

    //定义规:用水计划执行情况调查
    $('#planCondition_form').validate({
        rules: {
            residentLivePlanAmount: {required: true, rangelength: [1, 100]},
            residentActAmount: {required: true, rangelength: [1, 100]},
            noResidentLivePlanAmount: {required: true, rangelength: [1, 100]},
            noResidentActAmount: {required: true, rangelength: [1, 100]},
            educationPlanAmount: {required: true, rangelength: [1, 100]},
            educationActAmount: {required: true, rangelength: [1, 100]},
            specialPlanAmount: {required: true, rangelength: [1, 100]},
            specialActAmount: {required: true, rangelength: [1, 100]},
            planWaterTotal: {required: true, rangelength: [1, 100]},
            actWaterTotal: {required: true, rangelength: [1, 100]},
            saveWaterAmount: {required: true, rangelength: [1, 100]}
        }
    });

    //定义规则:特种行业情况调查
    $('#special_form').validate({
        rules: {
            waterType: {required: true, rangelength: [1, 100]},
            address: {required: true, rangelength: [1, 100]},
            tableAmount: {required: true, rangelength: [1, 100]},
            waterAmount: {required: true, rangelength: [1, 100]},
            price: {required: true, rangelength: [1, 100]},
            isRecovery: {required: true, rangelength: [1, 100]}
        }
    });

    $("#waCompanyInfo_totalInfoInsert_layout [tag='ok']").click(function(){
        var resultBol, resultBol2,resultBol3,resultBol4,resultBol5;

        if(commFacWaterAdd){
            resultBol = _saveWaterInfoData(true, "commFacWater_form", "/wa/WaCompanyWaterDataNew/add");
        }else{
            resultBol = _saveWaterInfoData(false, "commFacWater_form", "/wa/WaCompanyWaterDataNew/add");
        }
        if(interwaterAdd){
            resultBol2 = _saveWaterInfoData(true,"interwater_form", "/wa/WaInterwaterInstallationTable/add");
        }else{
            resultBol2 =  _saveWaterInfoData(false);
        }
        if(rainSurfaceAdd){
            resultBol3 = _saveWaterInfoData(true, "rainSurface_form", "/wa/WaRainSurfaceConditionTable/add");
        }else{
            resultBol3 = _saveWaterInfoData(false);
        }
        if(planConditionAdd){
            resultBol4 = _saveWaterInfoData(true, "planCondition_form", "/wa/WaPlanConditionTable/add");
        }else{
            resultBol4 = _saveWaterInfoData(false);
        }
        if(specialAdd){
            resultBol5 = _saveWaterInfoData(true, "special_form", "/wa/WaSpecialtradeConditionTable/add");
        }else{
            resultBol5 = _saveWaterInfoData(false);
        }

        if (resultBol && resultBol2 && resultBol3 && resultBol4 && resultBol5){
            saveComDataInfo("commFacWater_form", "/wa/WaCompanyWaterDataNew/add");
            saveComDataInfo("interwater_form", "/wa/WaInterwaterInstallationTable/add");
            saveComDataInfo("rainSurface_form", "/wa/WaRainSurfaceConditionTable/add");
            saveComDataInfo("planCondition_form", "/wa/WaPlanConditionTable/add");
            saveComDataInfo("special_form", "/wa/WaSpecialtradeConditionTable/add");

            $.messager.ok("保存数据成功!");
            $("#waCompanyInfo_totalInfoInsert_layout").parent().window("close");
        }else {
            // $.messager.ok("保存数据失败!");
        }

    });

    //私有页面方法------------------------------------------------------------------------------------------------------
    function _saveWaterInfoData(isAdd,formId, submitUrl) {
        //验证表单--------------------------------------------------
        if(!$('#'+formId).validate().form()){
            $("#"+formId).unblock();   //去除遮罩层
            return false;
        }else{
            return true;
        }

    }
//提交数据--------------------------------------------------
    function saveComDataInfo(formId, submitUrl) {
        $("#"+formId).block();   //遮罩层

        Hg.getJson(submitUrl,$("#"+formId).serializeArray(),function(data){
            if (!data.success) {
                $("#"+formId).unblock();
            } else {
                console.log("数据保存成功");
            }
        });
    }
//-------------取消操作------------------------------------------------
    $("#waCompanyInfo_totalInfoInsert_layout [tag='cancel']").click(function(){
        $("#waCompanyInfo_totalInfoInsert_layout").parent().window("close");
    });
}

waCompanyInfoDatagrid.initTotal(companyId, commFacWaterWaterId,interWaterId,rainSurfaceWaterId,planConditionWaterId,specialWaterId);