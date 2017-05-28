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
	String text = "系统管理员";
	//基础url
	String baseUrl = basePath + "systemAdmin";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>超市管理员</title>
	<link rel="stylesheet" type="text/css" href="../css/manage.css">
	<script type="text/javascript" src="../javascript/jquery.js"></script>
</head>
<body>

<%@ include  file="./top.jsp"%>
<%@ include  file="./left.jsp"%>
<div class="manage_right">
	<div class="content">
		<div class="formTitle">
			<span><%=text %>个人信息修改</span>
		</div>
		<div class="formPage">
		<form action="<%=baseUrl %>/update" method="POST">
				<input type="hidden" name="id" value="<%=session.getAttribute("userId") %>"/>
				<table>
					<tr>
						<td>密码：</td>
						<td><input type="text" name="password" value=""/></td>
					</tr>
						<tr>
						<td>确认密码：</td>
						<td><input type="text" name="password" value=""/></td>
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

</body>
</html>