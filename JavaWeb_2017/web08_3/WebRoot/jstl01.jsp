<%@ page import="java.util.*" pageEncoding="utf-8"contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body>
		<h1><a href="<%=response.encodeURL("jstl02.jsp") %>">访问jstl02</a></h1>
		<h1><a href="<c:url value='/jstl02.jsp'/>">访问jstl02.jsp</a></h1>
		<c:import url="jstl02.jsp"></c:import>
	</body>
</html>











