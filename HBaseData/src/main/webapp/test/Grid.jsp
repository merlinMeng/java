<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String path= request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%= basePath%>">
<link rel="stylesheet" type="text/css" href="extjs/resources/css/ext-all.css">
<script type="text/javascript" src="extjs/ext-all-debug.js"></script>
<script type="text/javascript" src="test/Grid.js"></script>
</head>


<body>
	
</body>
</html>