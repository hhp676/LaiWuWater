<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page import="com.hongguaninfo.hgdf.adp.shiro.conf.*"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<c:set var="defaultPageSize" value="100"></c:set>
<c:set var="defaultPageList" value="[100,200,300]"></c:set>
<!--  全局 -->
<script>
    var G_CTX_PATH = "${ctx}";
</script>
