<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.cc.bean.*" %>
<% 
//当前路径
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//页面分类
String type = "";
//页面中文
String text = "修改个人信息";
//基础url
String baseUrl = basePath + "user/update";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>超市购物网</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<script type="text/javascript" src="../javascript/jquery.js"></script>
</head>
<body>

<div class="w">
	<div class="w100">
		<%@ include  file="./top.jsp"%>
		<%@ include  file="./menus.jsp"%>
		
	    <div class="content">
	  <div class="formPage" style="margin-left:300px;margin-top:100px">
		<form action="<%=baseUrl %>" method="POST">
				<input type="hidden" name="id" value="<%=session.getAttribute("userId") %>"/>
				<table>
					<tr>
						<td>名称：</td>
						<td><input type="text" name="username" value="<%=session.getAttribute("username") %>"/></td>
					</tr>
						<tr>
						<td>电话：</td>
						<td><input type="text" name="phone" value="<%=session.getAttribute("phone") %>"/></td>
					</tr>
						<tr>
						<td>地址：</td>
						<td><input type="text" name="address" value="<%=session.getAttribute("address") %>"/></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password" value=""/></td>
					</tr>
				   <tr>
						<td>确认密码：</td>
						<td><input type="password" name="repassword" value=""/></td>
					</tr>
					<tr>
						<td></td>
						<td><button class="submit" type="submit">确定</button></td>
					</tr>
				</table>
			</form>
		</div>
			
	    </div>
    </div>
</div>
</body>
</html>