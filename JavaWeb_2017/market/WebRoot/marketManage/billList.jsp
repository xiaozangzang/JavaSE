<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.cc.bean.*" %>
<% 
	//当前路径
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	//页面分类
	String type = "bill";	
	//基础url
	String baseUrl = basePath + "bill";
	//列表数据
	Bill item = (Bill)request.getAttribute("item");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>系统管理</title>
	<link rel="stylesheet" type="text/css" href="../css/manage.css">
	<script type="text/javascript" src="../javascript/jquery.js"></script>
</head>
<body>
<%@ include  file="./top.jsp"%>
<%@ include  file="./left.jsp"%>
<div class="manage_right">
	<div class="content">
		<!-- 用户列表 -->
		<div class="manageSearch">
			
		</div>
		<%if(item == null){%>
			当前无数据
		<%}else{%>
			<div class="manageList">
			<table>
				<thead>
					<tr role="row">
						<th>编号</th>
						<th>总价</th>
						<th>提成</th>
					</tr>
				</thead>
				<tbody>
					
					<tr>
						<td><%=item.getId() %></td>	
						<td><%=item.getTotalPrice() %></td>					
						<td><%=item.getCut() %></td>					
					</tr>			
				</tbody>
			</table>
		</div>
		<%} %>
	</div>
</div>
</body>
</html>