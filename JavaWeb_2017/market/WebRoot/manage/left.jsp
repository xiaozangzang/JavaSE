<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="manage_left">
	<%-- <a href="<%=basePath%>supermarketManage/queryList">
		<li class="<%= "supermarketManage".equals(type) ? "current" :"" %>">超市管理员管理</li>
	</a> --%>
	<a href="<%=basePath%>supermarket/queryList">
		<li class="<%= "supermarket".equals(type) ? "current" :"" %>">超市管理</li>
	</a>
	<a href="<%=basePath%>commodityCategory/queryList">
		<li class="<%= "commodityCategory".equals(type) ? "current" :"" %>">商品分类管理</li>
	</a>
	<a href="<%=basePath%>bill/queryList">
		<li class="<%= "order".equals(type) ? "current" :"" %>">账单管理</li>
	</a>
</div>