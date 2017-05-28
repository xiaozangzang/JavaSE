<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="manage_left">
	
	<a href="<%=basePath%>commodity/queryList?userId=<%=session.getAttribute("userId") %>">
		<li class="<%= "commodity".equals(type) ? "current" :"" %>">商品管理</li>
	</a>
	<a href="<%=basePath%>order/queryAllList?userId=<%=session.getAttribute("userId") %>">
		<li class="<%= "order".equals(type) ? "current" :"" %>">订单管理</li>
	</a>
	<a href="<%=basePath%>bill/queryItem?userId=<%=session.getAttribute("userId") %>">
		<li class="<%= "bill".equals(type) ? "current" :"" %>">账单管理</li>
	</a>
</div>