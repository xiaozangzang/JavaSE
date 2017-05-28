<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="ec_top">
 	<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您,<%=(String)request.getSession().getAttribute("username") %></span>
 	<a style="float: right;font-size: 12px;" href="<%=basePath%>ec/updateInfo.jsp">
			修改个人信息
	</a>
 	<a href="<%=basePath%>shoppingCar/queryList">我的购物车</a>
 	<a href="<%=basePath%>order/queryList">我的订单</a>
</div>