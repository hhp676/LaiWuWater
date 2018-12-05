<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>详细页面</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true" id="waCompanyInfo_totalInfoInsert_layout">
    <div data-options="region:'west'" style="">
        <div  class="easyui-tabs" fit=true tabPosition="top">
            <div title="企业用水情况调查" id="commFacWater_layout" style="padding:2px">
                <%--<input type="hidden"   name="companyId" value="${companyId}" id="companyId"></input>--%>
                <form id="commFacWater_form"  class="hgform">
                    <input type="hidden"   name="companyId" value="${companyId}" id="companyId"></input>
                    <table fit=true name="commFacWaterTab" id="commFacWaterTab" singleSelect=false fitColumns=true>
                        <thead>
                        <tr>
                            <td width="200px;">主产品名称<font>*</font>:</td>
                            <td><input type="text"   name="productName" value="" id="commFacWaterTab_productName"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">单位产品新水量m3/单位产品<font>*</font>:</td>
                            <td><input type="text"   name="newWaterCount" value="" id="newWaterCount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">全年产量<font>*</font>:</td>
                            <td><input type="text"   name="totalCount" value="" id="totalCount"></input></td>
                        </tr> <tr>
                            <td width="200px;">行业用水标准<font>*</font>:</td>
                            <td><input type="text"   name="waterStandard" value="" id="waterStandard"></input></td>
                        </tr> <tr>
                            <td width="200px;">从业人员（人）<font>*</font>:</td>
                            <td><input type="text"   name="employee" value="" id="employee"></input></td>
                        </tr><tr>
                            <td width="200px;">工业新水量m3<font>*</font>:</td>
                            <td><input type="text"   name="gongyeWaterCount" value="" id="gongyeWaterCount"></input></td>
                        </tr><tr>
                            <td width="200px;">工艺新水量<font>*</font>:</td>
                            <td><input type="text"   name="gongyiWaterCount" value="" id="gongyiWaterCount"></input></td>
                        </tr><tr>
                            <td width="200px;">锅炉新水量<font>*</font>:</td>
                            <td><input type="text"   name="boilerWater" value="" id="boilerWater"></input></td>
                        </tr><tr>
                            <td width="200px;">厂内生活水<font>*</font>:</td>
                            <td><input type="text"   name="factoryLiveWater" value="" id="factoryLiveWater"></input></td>
                        </tr><tr>
                            <td width="200px;">重复利用水量m3<font>*</font>:</td>
                            <td><input type="text"   name="reuseTotalAmount" value="" id="reuseTotalAmount"></input></td>
                        </tr><tr>
                            <td width="200px;">利用率（%）<font>*</font>:</td>
                            <td><input type="text"   name="availability" value="" id="availability"></input></td>
                        </tr><tr>
                            <td width="200px;">间冷水循环量<font>*</font>:</td>
                            <td><input type="text"   name="interColdWaterLoopAmount" value="" id="interColdWaterLoopAmount"></input></td>
                        </tr><tr>
                            <td width="200px;">循环率（%）<font>*</font>:</td>
                            <td><input type="text"   name="circulRate" value="" id="circulRate"></input></td>
                        </tr><tr>
                            <td width="200px;">回用水量<font>*</font>:</td>
                            <td><input type="text"   name="freshWaterBackAmount" value="" id="freshWaterBackAmount"></input></td>
                        </tr><tr>
                            <td width="200px;">蒸气冷凝水回用量<font>*</font>:</td>
                            <td><input type="text"   name="steamCondenBackAmount" value="" id="steamCondenBackAmount"></input></td>
                        </tr><tr>
                            <td width="200px;">回用率（%）<font>*</font>:</td>
                            <td><input type="text"   name="recoverRate" value="" id="recoverRate"></input></td>
                        </tr><tr>
                            <td width="200px;">节水量<font>*</font>:</td>
                            <td><input type="text"   name="saveAmount" value="" id="saveAmount"></input></td>
                        </tr><tr>
                            <td width="200px;">节水设施投资（万元）<font>*</font>:</td>
                            <td><input type="text"   name="installMoney" value="" id="installMoney"></input></td>
                        </tr><tr>
                            <td width="200px;">填报人<font>*</font>:</td>
                            <td><input type="text"   name="writePerson" value="" id="commFacWaterTab_writePerson"></input></td>
                        </tr><tr>
                            <td width="200px;">填报时间<font>*</font>:</td>
                            <td><input type="text"   name="writeTime" value="" id="commFacWaterTab_writeTime"></input></td>
                        </tr>
                        </thead>
                    </table>
                </form>
            </div>

            <div title="中水回用设施情况调查" id="interwater_layout" style="padding:2px">
                <form id="interwater_form"  class="hgform">
                    <input type="hidden"   name="companyId" value="${companyId}" ></input>
                    <table fit=true name="interwaterWaterTab" id="interwaterWaterTab" singleSelect=false fitColumns=true>
                        <thead>
                        <tr>
                            <td width="200px;">企业（单位）小区<font>*</font>:</td>
                            <td><input type="text"   name="companyName" value="" id="interwaterWaterTab_companyName"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">项目名称<font>*</font>:</td>
                            <td><input type="text"   name="productName" value="" id="interwaterWaterTab_productName"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">处理工艺<font>*</font>:</td>
                            <td><input type="text"   name="handleTech" value="" id="handleTech"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">设计回用量水（m3/日）<font>*</font>:</td>
                            <td><input type="text"   name="recoverWaterCount" value="" id="recoverWaterCount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">实际回用水量（m3/日）<font>*</font>:</td>
                            <td><input type="text"   name="actWaterCount" value="" id="actWaterCount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">投入运行时间<font>*</font>:</td>
                            <td><input type="text"   name="runtime" value="" id="runtime"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">工程投资（万元）<font>*</font>:</td>
                            <td><input type="text"   name="investMoney" value="" id="investMoney"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">运行成本（元/m3）<font>*</font>:</td>
                            <td><input type="text"   name="runCost" value="" id="runCost"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">中水价格（元/m3）<font>*</font>:</td>
                            <td><input type="text"   name="interwaterPrice" value="" id="interwaterPrice"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">中水管网建设情况<font>*</font>:</td>
                            <td><input type="text"   name="interwaterPiping" value="" id="interwaterPiping"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">用途<font>*</font>:</td>
                            <td><input type="text"   name="use" value="" id="use"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">备注<font>*</font>:</td>
                            <td><input type="text"   name="flag" value="" id="interwaterWaterTab_flag"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">填报人<font>*</font>:</td>
                            <td><input type="text"   name="writePerson" value="" id="interwaterWaterTab_writePerson"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">填报时间<font>*</font>:</td>
                            <td><input type="text"   name="writeTime" value="" id="interwaterWaterTab_writeTime"></input></td>
                        </tr>
                        </thead>
                    </table>
                </form>
            </div>

            <div title="雨水地表水使用情况调查" id="rainSurface_layout" style="padding:2px">
                <form id="rainSurface_form" class="hgform">
                    <input type="hidden"   name="companyId" value="${companyId}" ></input>
                    <table fit=true name="rainSurfaceTab" id="rainSurfaceTab" singleSelect=false fitColumns=true>
                        <thead>
                        <tr>
                            <td width="200px;">单位名称<font>*</font>:</td>
                            <td><input type="text"   name="companyName" value="" id="rainSurfaceTab_companyName"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">雨水回收利用-储水容量m3<font>*</font>:</td>
                            <td><input type="text"   name="rainWaterVolume" value="" id="rainWaterVolume"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">雨水回收利用-实际使用量（年）<font>*</font>:</td>
                            <td><input type="text"   name="rainActAmount" value="" id="rainActAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">雨水回收利用-投入使用时间<font>*</font>:</td>
                            <td><input type="text"   name="rainUseTime" value="" id="rainUseTime"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">雨水回收利用-工程投资（万元）<font>*</font>:</td>
                            <td><input type="text"   name="rainProjectInvest" value="" id="rainProjectInvest"></input></td>
                        </tr>

                        <tr>
                            <td width="200px;">地表水利用-储水容量m3<font>*</font>:</td>
                            <td><input type="text"   name="surfaceWaterVolume" value="" id="surfaceWaterVolume"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">地表水利用-实际使用量（年）<font>*</font>:</td>
                            <td><input type="text"   name="surfaceActAmount" value="" id="surfaceActAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">地表水利用-投入使用时间<font>*</font>:</td>
                            <td><input type="text"   name="surfaceUseTime" value="" id="surfaceUseTime"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">地表水利用-工程投资（万元）<font>*</font>:</td>
                            <td><input type="text"   name="surfaceProjectInvest" value="" id="surfaceProjectInvest"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">用途<font>*</font>:</td>
                            <td><input type="text"   name="purpose" value="" id="purpose"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">备注<font>*</font>:</td>
                            <td><input type="text"   name="flag" value="" id="rainSurfaceTab_flag"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">填报人<font>*</font>:</td>
                            <td><input type="text"   name="writePerson" value="" id="rainSurfaceTab_writePerson"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">填报时间<font>*</font>:</td>
                            <td><input type="text"   name="writeTime" value="" id="rainSurfaceTab_writeTime"></input></td>
                        </tr>
                        </thead>
                    </table>
                </form>
            </div>

            <div title="用水计划执行情况调查" id="planCondition_layout" style="padding:2px">
                <form id="planCondition_form" class="hgform">
                    <input type="hidden"   name="companyId" value="${companyId}" ></input>
                    <table fit=true name="planConditionTab" id="planConditionTab" singleSelect=false fitColumns=true>
                        <thead>
                        <tr>
                            <td width="200px;">居民生活用水计划数量<font>*</font>:</td>
                            <td><input type="text"   name="residentLivePlanAmount" value="" id="residentLivePlanAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">居民生活用水实际用水量<font>*</font>:</td>
                            <td><input type="text"   name="residentActAmount" value="" id="residentActAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">非居民用水计划数量<font>*</font>:</td>
                            <td><input type="text"   name="noResidentLivePlanAmount" value="" id="noResidentLivePlanAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">非居民用水实际用水量<font>*</font>:</td>
                            <td><input type="text"   name="noResidentActAmount" value="" id="noResidentActAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">教育用水计划数量<font>*</font>:</td>
                            <td><input type="text"   name="educationPlanAmount" value="" id="educationPlanAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">教育用水实际用水量<font>*</font>:</td>
                            <td><input type="text"   name="educationActAmount" value="" id="educationActAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">特种用水计划数量<font>*</font>:</td>
                            <td><input type="text"   name="specialPlanAmount" value="" id="specialPlanAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">特种用水实际用水量<font>*</font>:</td>
                            <td><input type="text"   name="specialActAmount" value="" id="specialActAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">用水计划总计<font>*</font>:</td>
                            <td><input type="text"   name="planWaterTotal" value="" id="planWaterTotal"></input></td>
                        </tr> <tr>
                            <td width="200px;">实际用水量总计<font>*</font>:</td>
                            <td><input type="text"   name="actWaterTotal" value="" id="actWaterTotal"></input></td>
                        </tr><tr>
                            <td width="200px;">节水量<font>*</font>:</td>
                            <td><input type="text"   name="saveWaterAmount" value="" id="saveWaterAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">填报人<font>*</font>:</td>
                            <td><input type="text"   name="writePerson" value="" id="planConditionTab_writePerson"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">填报时间<font>*</font>:</td>
                            <td><input type="text"   name="writeTime" value="" id="planConditionTab_writeTime"></input></td>
                        </tr>
                        </thead>
                    </table>
                </form>
            </div>

            <div title="特种行业情况调查" id="special_layout" style="padding:2px">
                <form id="special_form" class="hgform">
                    <input type="hidden"   name="companyId" value="${companyId}" ></input>
                    <table fit=true name="specialTab" id="specialTab" singleSelect=false fitColumns=true>
                        <thead>
                        <tr>
                            <td width="200px;">用水户性质<font>*</font>:</td>
                            <td><input type="text"   name="waterType" value="" id="waterType"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">地址<font>*</font>:</td>
                            <td><input type="text"   name="address" value="" id="address"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">装表数<font>*</font>:</td>
                            <td><input type="text"   name="tableAmount" value="" id="tableAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">用水量<font>*</font>:</td>
                            <td><input type="text"   name="waterAmount" value="" id="waterAmount"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">收费价格<font>*</font>:</td>
                            <td><input type="text"   name="price" value="" id="price"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">废水（尾水）是否处理回收<font>*</font>:</td>
                            <td><input type="text"   name="isRecovery" value="" id="isRecovery"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">填报人<font>*</font>:</td>
                            <td><input type="text"   name="writePerson" value="" id="specialTab_writePerson"></input></td>
                        </tr>
                        <tr>
                            <td width="200px;">填报时间<font>*</font>:</td>
                            <td><input type="text"   name="writeTime" value="" id="specialTab_writeTime"></input></td>
                        </tr>
                        </thead>
                    </table>
                </form>
            </div>

        </div>
    </div>
    <div data-options="region:'south',border:false" style="text-align: right; padding: 5px 5px 5px; background-color: #e0e0e0;">
        <shiro:hasPermission name="<%= Auths.WA_COMPANY_INFO_EDIT %>">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" tag="ok">保存</a>
        </shiro:hasPermission>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" tag="cancel">取消</a>
    </div>

</div>
<script type="text/javascript">
    var companyId = "${companyId}";
    var commFacWaterWaterId = 0;
    var interWaterId = 0;
    var rainSurfaceWaterId = 0;
    var planConditionWaterId = 0;
    var specialWaterId = 0;
</script>
<script type="text/javascript" src="${ctx}/static/js/wa/waCompanyInfo/waCompanyInfo_total.js"></script>
</body>

</html>
