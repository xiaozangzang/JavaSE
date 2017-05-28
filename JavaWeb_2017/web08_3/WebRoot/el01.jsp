<%@ page import="java.util.*" pageEncoding="utf-8"contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="f" uri="http://zhang.zhi.peng/myFn" %>
<html>
	<body> 
		${1+1}<br/>
		${"abc"}<br/>
		"abc"+"def": ${f:concat("abc","def")}<br/>
		"abc": ${f:toUpper("abc")}<br/>
		abcdef的长度：${fn:length("abcdef") }<br/>
		返回a1b2c3中的字母：${f:removeNum("a1b2c3") }<br/>
		返回字符串中的数字：${f:returnNum("asdf-3fasd-sdaf33-34") }
		
	</body>
</html>











