<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path= request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据管理</title>
	<base href="<%= basePath%>">
	<link rel="stylesheet" type="text/css" href="resources/extjs/resources/css/ext-all.css">
	<script type="text/javascript" src="resources/extjs/ext-all-debug.js"></script>
	<script type="text/javascript" src="resources/main/dapama/downdapama.js"></script>
</head>
<body>
		<div id="download"></div>
</body>
</html>