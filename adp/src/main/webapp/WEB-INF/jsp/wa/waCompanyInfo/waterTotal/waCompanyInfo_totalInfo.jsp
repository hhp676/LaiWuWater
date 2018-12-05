<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript" src="${ctx}/static/js/wa/jquery.PrintArea.js"></script>
<script type="text/javascript" src="${ctx}/static/js/wa/laydate.js"></script>
<html>
<head>
    <title>详细页面</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true" id="waCompanyInfo_totalInfo_layout">
    <div data-options="" style="">
        <div class="easyui-tabs" fit=true  id="waterinfoTab" tabPosition="top">
            <div title="企业用水情况调查"  id="commFacWater_layout" style="padding:2px;">
                <div>
                    <center> <h2>企业用水情况调查</h2></center>
                    节水代码： ${companyCode}
                    &nbsp; &nbsp; &nbsp;
                    填报单位（盖章）:${companyName}
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    用水计划卡号：
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    填报人：
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    填报时间：
                </div>
                <table border="1" align="center" style=" color:#333333; border-collapse: collapse;" fitColumns=true>
                    <tr>
                        <th style="width:70px">主产品名称</th>
                        <th>单位产品新水量m3/单位产品</th>
                        <th>全年产量</th>
                        <th>行业用水标准</th>
                        <th>从业人员（人）</th>
                        <th>工业新水量m3</th>
                        <th>工艺新水量</th>
                        <th>锅炉新水量</th>
                        <th>厂内生活水</th>
                        <th>重复利用水量m3</th>
                        <th>利用率（%）</th>
                        <th>间冷水循环量</th>
                        <th>循环率（%）</th>
                        <th>回用水量</th>
                        <th>蒸气冷凝水回用量</th>
                        <th>回用率（%）</th>
                        <th>节水量</th>
                        <th>节水设施投资（万元）</th>
                    </tr>
                    <c:forEach var="waCompanyWaterDataNew" items="${waCompanyWaterDataNewAll}">
                        <tr style="height:30px">
                            <td>${waCompanyWaterDataNew.productName}</td>
                            <td>${waCompanyWaterDataNew.newWaterCount}</td>
                            <td>${waCompanyWaterDataNew.totalCount}</td>
                            <td>${waCompanyWaterDataNew.waterStandard}</td>
                            <td>${waCompanyWaterDataNew.employee}</td>
                            <td>${waCompanyWaterDataNew.gongyeWaterCount}</td>
                            <td>${waCompanyWaterDataNew.gongyiWaterCount}</td>
                            <td>${waCompanyWaterDataNew.boilerWater}</td>
                            <td>${waCompanyWaterDataNew.factoryLiveWater}</td>
                            <td>${waCompanyWaterDataNew.reuseTotalAmount}</td>
                            <td>${waCompanyWaterDataNew.availability}</td>
                            <td>${waCompanyWaterDataNew.interColdWaterLoopAmount}</td>
                            <td>${waCompanyWaterDataNew.circulRate}</td>
                            <td>${waCompanyWaterDataNew.freshWaterBackAmount}</td>
                            <td>${waCompanyWaterDataNew.steamCondenBackAmount}</td>
                            <td>${waCompanyWaterDataNew.recoverRate}</td>
                            <td>${waCompanyWaterDataNew.saveAmount}</td>
                            <td>${waCompanyWaterDataNew.installMoney}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div title="中水回用设施情况调查" id="interwater_layout" style="padding:2px">
                <div >
                    <center> <h2>中水回用设施情况调查</h2></center>

                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    填报人：
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    填报时间：
                </div>
                <table border="1" align="center" style=" color:#333333; border-collapse: collapse;">
                    <tr  style="height:30px">
                        <th>企业（单位）小区</th>
                        <th>项目名称</th>
                        <th>处理工艺</th>
                        <th>设计回用量水（m3/日）</th>
                        <th>实际回用水量（m3/日）</th>
                        <th>投入运行时间</th>
                        <th>工程投资（万元）</th>
                        <th>运行成本（元/m3）</th>
                        <th>中水价格（元/m3）</th>
                        <th>中水管网建设情况（M）</th>
                        <th>用途</th>
                        <th>备注</th>
                    </tr>
                    <c:forEach var="interwater" items="${waInterwaterInstallation}">
                        <tr  style="height:30px">
                            <td style="width:100px">${interwater.companyName}</td>
                            <td style="width:50px">${interwater.productName}</td>
                            <td style="width:50px">${interwater.handleTech}</td>
                            <td style="width:50px">${interwater.recoverWaterCount}</td>
                            <td style="width:50px">${interwater.actWaterCount}</td>
                            <td style="width:50px">${interwater.runtime}</td>
                            <td style="width:50px">${interwater.investMoney}</td>
                            <td style="width:40px">${interwater.runCost}</td>
                            <td style="width:50px">${interwater.interwaterPrice}</td>
                            <td style="width:50px">${interwater.interwaterPiping}</td>
                            <td style="width:80px">${interwater.use}</td>
                            <td style="width:80px">${interwater.flag}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div title="雨水地表水使用情况调查" id="rainSurface_layout" style="padding:2px">
                <div >
                    <center> <h2>雨水地表水使用情况调查</h2></center>
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    填报人：
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    填报时间：
                </div>
                <table border="1" align="center" style=" color:#333333; border-collapse: collapse;">
                    <tr>
                        <th style="width:140px" rowspan="2">单位名称</th>
                        <th style="width:320px" colspan="4">雨水回收利用（m3/日）</th>
                        <th style="width:320px" colspan="4">地表水利用（m3/日）</th>
                        <th style="width:120px" rowspan="2">用途</th>
                        <th style="width:120px" rowspan="2">备注</th>
                    </tr>
                    <tr>
                        <th>储水容量m3</th>
                        <th>实际使用量（年）</th>
                        <th>投入使用时间</th>
                        <th>工程投资（万元）</th>
                        <th>储水容量m3</th>
                        <th>实际使用量</th>
                        <th>投入使用时间</th>
                        <th>工程投资（万元）</th>
                    </tr>
                    <c:forEach var="rainSurfaceData" items="${waRainSurfaceData}">
                        <tr style="height:30px">
                            <td style="width:130px">${rainSurfaceData.companyName}</td>
                            <td style="width:60px">${rainSurfaceData.rainWaterVolume}</td>
                            <td style="width:60px">${rainSurfaceData.rainActAmount}</td>
                            <td style="width:60px">${rainSurfaceData.rainUseTime}</td>
                            <td style="width:60px">${rainSurfaceData.rainProjectInvest}</td>
                            <td style="width:60px">${rainSurfaceData.surfaceWaterVolume}</td>
                            <td style="width:60px">${rainSurfaceData.surfaceActAmount}</td>
                            <td style="width:60px">${rainSurfaceData.surfaceUseTime}</td>
                            <td style="width:60px">${rainSurfaceData.surfaceProjectInvest}</td>
                            <td style="width:130px">${rainSurfaceData.purpose}</td>
                            <td style="width:130px">${rainSurfaceData.flag}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div title="用水计划执行情况调查" id="planCondition_layout" style="padding:2px">
                <div >
                    <center> <h2>用水计划执行情况调查</h2></center>
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    填报人：
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    填报时间：
                </div>
                <table border="1" align="center" style=" color:#333333; border-collapse: collapse;">
                    <tr>
                        <th style="width:120px">居民生活用水计划数量</th>
                        <th style="width:120px">居民生活用水实际用水量</th>
                        <th style="width:120px">非居民用水计划数量</th>
                        <th style="width:120px">非居民用水实际用水量</th>
                        <th style="width:120px">教育用水计划数量</th>
                        <th style="width:120px">教育用水实际用水量</th>
                        <th style="width:120px">特种用水计划数量</th>
                        <th style="width:120px">特种用水实际用水量</th>
                        <th style="width:120px">用水计划总计</th>
                        <th style="width:100px">实际用水量总计</th>
                        <th style="width:80px">节水量</th>
                    </tr>
                    <c:forEach var="planConditionData" items="${planConditionDataAll}">
                        <tr style="height:30px">
                            <td style="width:100px">${planConditionData.residentLivePlanAmount}</td>
                            <td style="width:60px">${planConditionData.residentActAmount}</td>
                            <td style="width:60px">${planConditionData.noResidentLivePlanAmount}</td>
                            <td style="width:60px">${planConditionData.noResidentActAmount}</td>
                            <td style="width:60px">${planConditionData.educationPlanAmount}</td>
                            <td style="width:60px">${planConditionData.educationActAmount}</td>
                            <td style="width:60px">${planConditionData.specialPlanAmount}</td>
                            <td style="width:60px">${planConditionData.specialActAmount}</td>
                            <td style="width:60px">${planConditionData.planWaterTotal}</td>
                            <td style="width:100px">${planConditionData.actWaterTotal}</td>
                            <td style="width:100px">${planConditionData.saveWaterAmount}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div title="特种行业情况调查" id="specialTradeCondition_layout" style="padding:2px">
                <div >
                    <center> <h2>特种行业情况调查</h2></center>
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    填报人：
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    填报时间：
                </div>
                <table border="1" align="center" style=" color:#333333; border-collapse: collapse;">
                    <tr>
                        <th  style="width:140px">用水户性质</th>
                        <th  style="width:140px">地址</th>
                        <th  style="width:140px">装表数</th>
                        <th  style="width:140px">用水量</th>
                        <th  style="width:140px">收费价格</th>
                        <th  style="width:170px">废水（尾水）是否处理回收</th>
                    </tr>
                    <c:forEach var="specialTradeConditionData" items="${specialTradeConditionDataAll}">
                        <tr style="height:30px">
                            <td style="width:130px">${specialTradeConditionData.waterType}</td>
                            <td style="width:130px">${specialTradeConditionData.address}</td>
                            <td style="width:130px">${specialTradeConditionData.tableAmount}</td>
                            <td style="width:130px">${specialTradeConditionData.waterAmount}</td>
                            <td style="width:130px">${specialTradeConditionData.price}</td>
                            <td style="width:130px">${specialTradeConditionData.isRecovery}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
    </div>
    <div data-options="region:'south',border:false" style="text-align: right; padding: 5px 5px 5px; background-color: #e0e0e0;">
        <shiro:hasPermission name="<%= Auths.WA_COMPANY_INFO_EDIT %>">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" tag="printTab"  onclick="printTab()">打印</a>
        </shiro:hasPermission>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" tag="cancel">取消</a>
    </div>

</div>
<script type="text/javascript">
    var companyId = "${companyId}";
    var dormitoryWaterId ="${dormitoryWaterData.dormitoryWaterId}";
    var commFactilitiesId = "${commFacData.commFactilitiesId}";
    var industryWaterId = "${industryWaterData.industryWaterId}";
    var selectTab;
    var selectTabId;
    $('#waterinfoTab').tabs({
        border:false,
        onSelect:function(title,index){
            if(index == 0){
                selectTab = "commFacWater_layout";
            }else if (index == 1){
                selectTab = "interwater_layout";
            }else if (index == 2){
                selectTab = "rainSurface_layout";
            }else if (index == 3){
                selectTab = "planCondition_layout";
            }else if (index == 4){
                selectTab = "specialTradeCondition_layout";
            }
        }
    });

    printTab = function(){
        //mode:popup弹窗执行打印/popClose打印执行完毕自动关闭/extraHead头信息
        var options = { mode : 'popup', popClose : 'popup',
            extraHead : '<meta charset="utf-8" />,<meta http-equiv="X-UA-Compatible" content="IE=edge"/>' };
        //选择器可以书写多个,以英文逗号间隔,如:#area1,#area2也可以书写样式选择器

        $('#'+selectTab).printArea( options );
    }

</script>
<script type="text/javascript" src="${ctx}/static/js/wa/waCompanyInfo/waCompanyInfo_total.js"></script>
</body>

</html>
