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
<script type="text/javascript" src="test/form.js"></script>
</head>


<body>
	<div id ='toolbar'></div>
	<div>
	<!-- 	<input id='enabledBtn' type="button" value='启动工具栏'>
		<input id='disenabledBtn' type="button" value='禁用工具栏'> -->
		
	</div>
	<div id ='form'></div>
</body>
</html>