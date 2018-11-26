<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>详细页面</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true" id="waCompanyWaterDataNew_detail">
    <div data-options="region:'west'" style="">
        <div >
            <center> <h2>企业用水情况调查</h2></center>

            填报单位（盖章）:${waCompanyWaterDataNew.productName}
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            用水计划卡号：${waCompanyWaterDataNew.waterPlanNo}
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            填报人：${waCompanyWaterDataNew.writePerson}
            &nbsp; &nbsp; &nbsp; &nbsp;
            填报时间：${waCompanyWaterDataNew.writeTime}
        </div>
        <table border="1" align="center" style=" color:#333333; border-collapse: collapse;">
            <tr>
                <th>主产品名称</th>
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
            <tr>
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

        </table>

    </div>

</body>
</html>
