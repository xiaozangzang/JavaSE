<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//页面分类
	String type = "";	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>超市购物网</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>

<div class="w">
	<div class="w100">
		<%@ include  file="./top.jsp"%>
		<%@ include  file="./menus.jsp"%>
	    <div style="font-size:40px;font-weight: bold;color: red;margin:100px auto;  width: 450px;text-align: center;">
	    	欢迎使用超市购物网
	    </div>
    </div>
</div>

</body>
</html>