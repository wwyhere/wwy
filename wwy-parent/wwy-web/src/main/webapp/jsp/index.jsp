<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>系统管理</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
</head>
<body class="skin-blue sidebar-mini wysihtml5-supported">
    <div class="wrapper">
        <jsp:include page="${ctx}/jsp/common/header.jsp" flush="true" />
        <jsp:include page="${ctx}/jsp/common/leftSideBar.jsp" flush="true" />
        <div class="content-wrapper">欢迎使用后台管理系统!</div>
        <jsp:include page="${ctx}/jsp/common/footer.jsp" flush="true" />
    </div>
</body>
<script>
	
</script>
</html>