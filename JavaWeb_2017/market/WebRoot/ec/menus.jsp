<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="navbar cf log-mod-viewed ec_menus">
	<li class="navbar__item-w <%= "commodity".equals(type) ? "current" :"" %>">
		<a class="navbar__item" href="<%=basePath%>commodity/userQueryList" >
			<span class="nav-label">商品</span>
		</a>
	</li>
</ul>