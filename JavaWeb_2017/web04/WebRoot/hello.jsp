<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		
		<%
			for (int i = 0; i < 10; i++) {
		%>
		"
		<h1>
			hello world 你好
		</h1>
		<%
			}
		%>
		<h2>
			1 + 1 =
			<%=(1 + 1)%></h2>
		<div style="background-color: blue;width: 50%;font:italic;">
		<h1>
			<%
				out.println(new Date().toLocaleString());
			%>
		</h1>
		</div>
	</body>
</html>
