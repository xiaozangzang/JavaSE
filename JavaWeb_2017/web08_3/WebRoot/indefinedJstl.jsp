<%@ page import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="zhang" uri="http://zhangzhipeng/myJstl"%>
<!-- 自定义标签 -->
  	<%--
  		for(int i = 0; i < 10; i ++){
  			out.println("<h3>Hello World!!!</h3>");
  		}
  	 --%>
  	 <%
  	 	request.setAttribute("str", "你好");
  	  %>
  	<zhang:sayHello info="${str}" num="5" var="t">
  		${t}
  	</zhang:sayHello>

