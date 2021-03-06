<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>ajax</title>
</head>
<body>

	<div class="easyui-layout" data-options="fit:true" id="userGroupDetail_layout">
	    <div data-options="region:'east',split:true" style="width:360px">
		   <div  class="easyui-tabs" fit=true tabPosition="top">
			<div title="设置用户" style="padding:2px">
            	<table title="" fit=true class="easyui-treegrid"  singleSelect=false fitColumns=true data-options="url: '${ctx}/innerpage/userdata.json',method: 'get',idField: 'id',treeField: 'name'">
        			<thead>
            			<tr>
            				<th data-options="field:'ck',checkbox:true"></th>
            				<th data-options="field:'name'" width="300">名称</th>             			
            			</tr>
        			</thead>
    			</table>
            </div>
        	<div title="设置角色" style="padding:2px">
            	<table title="" fit=true class="easyui-datagrid"  singleSelect=false fitColumns=true data-options="url: '${ctx}/innerpage/role.json',method: 'get'">
        			<thead>
            			<tr>
            				<th data-options="field:'ck',checkbox:true"></th>
            				<th data-options="field:'name'">名称</th> 
            				<th data-options="field:'desc',width:150">角色描述</th>            			
            			</tr>
        			</thead>
    			</table>
        	</div>
        	<div title="设置权限" style="padding:2px">
            	 <table title="" fit=true class="easyui-treegrid"  singleSelect=false fitColumns=true data-options="url: '${ctx}/innerpage/auth.json',method: 'get',idField: 'id',treeField: 'name'">
        		<thead>
            			<tr>
            				<th data-options="field:'ck',checkbox:true"></th>            				
                			<th data-options="field:'name'" width=230>权限名称</th>              			
            			</tr>
        			</thead>
    			</table>
        	</div>
        	<div title="负权限" style="padding:2px">
            	 <table title="" fit=true class="easyui-treegrid"  singleSelect=false fitColumns=true data-options="url: '${ctx}/innerpage/auth.json',method: 'get',idField: 'id',treeField: 'name'">
        		<thead>
            			<tr>
            				<th data-options="field:'ck',checkbox:true"></th>            				
                			<th data-options="field:'name'" width=230>权限名称</th>              			
            			</tr>
        			</thead>
    			</table>
        	</div>
		</div>
		</div>
		<div data-options="region:'center'" title="基本信息" style="padding: 5px;">
			<form action="">
				<table class="hgtable">
					<tr><td width="110px;">用户组名称:</td><td><input class="easyui-validatebox" type="text" name="name" data-options="required:true"></input></td></tr>
					<tr><td>用户组code:</td><td><input class="easyui-validatebox" type="text" name="name" data-options="required:true"></input></td></tr>
					<tr><td>所属部门:</td><td><input class="easyui-combotree" data-options="url:'${ctx}/innerpage/tree_data1.json',method:'get',required:true" style="width:300px;"></td></tr>
					<tr><td>父id:</td><td><input class="easyui-validatebox" type="text" name="name" data-options="required:true" disabled="disabled" value="1"></input></td></tr>
					<tr><td>描述:</td><td><textarea name="message" style="height:30px;width:300px;"></textarea></td></tr>
					<tr><td></td><td></td></tr>
				</table>
			</form>
		</div>
		<div data-options="region:'south',border:false" style="text-align: right; padding: 5px 5px 5px; background-color: #e0e0e0;">
			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" tag="ok">保存</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" tag="cancel">取消</a>
		</div>
		
	</div>

	<script type="text/javascript">
		$("#userGroupDetail_layout [tag='ok']").click(function(){
			alert("ok1");
		});
		$("#userGroupDetail_layout [tag='cancel']").click(function(){
			$("#userGroupDetail_layout").parent().window("close");
		});
	</script>
</body>

</html>
