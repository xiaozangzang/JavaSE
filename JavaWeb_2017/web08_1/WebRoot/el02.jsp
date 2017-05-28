<%@ page import="java.util.*,com.entity.*" pageEncoding="utf-8"%>
<html>
  <body>
  	<!-- el表达式的算术运算 + - * / %-->
  	<h1>算术运算</h1>
  	<h4>6-3=${6-3}</h4>
  	<h4>6*3=${6*3}</h4>
  	<h4>6/3=${6/3}</h4>
  	<h4>6%3=${6%3}</h4>
  	<h4>${(6-3)*4/2-3}</h4>
  	<h4>3+3=${3+3}</h4>
  	<%--<h4>4+2=${"4"+"2a"}</h4> --%>
  	<h4>4+2=${"4"+"2"}</h4>
  	<%
  		request.setAttribute("str", "3");
  		request.setAttribute("str1", "8");
  	 %>
  	 <h4>${str+str1}</h4>
  	 
  	<h1>关系运算</h1>
  	
  	<h4>${str > str1}</h4>
  	<h4>${str gt str1}</h4>
  	<h4>${1 == 1}</h4>
  	<h4>${1 eq 1}</h4>
  	<h4>${"1" eq 1}</h4>
  	
  	<h1>逻辑运算</h1>
  	${(str1 > str) && (1 > 3)}
  	${(str1 > str) and (1 > 3)}
  	${!((str1 > str) || (1 > 3))}
  	${not ((str1 > str) || (1 > 3))}
  	
  	<!-- empty -->
	<h1>empty</h1>
	<!-- 字符串为空，empty为true -->
	 <%
	 	request.setAttribute("myStr", "");
	  %> 	
	  <h4>${empty myStr}</h4>
  	<!-- 集合为空，empty为true -->
  	<%
  		List lists = new ArrayList();
  		request.setAttribute("myList", lists);
  	 %>
  	 <h4>${empty myList}</h4>
  	 <!-- 查不到对应的数据，empty为true -->
  	 <h4>${empty myLists}</h4>
  </body>
</html>









