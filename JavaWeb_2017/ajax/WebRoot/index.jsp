<%@ page language="java" import="java.util.*" pageEncoding="utf-8%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
	//1.获取a节点，并为其添加onclick响应函数
	window.onload = function() {
		document.getElementsByTagName("a")[0].onclick = function() {

			//创建一个XMLHttpRequest对象
			var request = new XMLHttpRequest();
			//4.准备发送请求的数据：url
			var url = this.href;
			var method = "GET";
			//5.调用XMLHttpRequest对象的open方法
			request.open(method, url);
			//6.调用XMLHttpRequest对象的send方法
			request.send(null);
			//7.为XMLHttpRequest对象添加onreadystatechange函数
			request.onreadystatechange = function() {
				alert(request.readyState);
				//8.判断响应是否完成：XMLHttpRequest对象的onreadystate属性值为4的时候
				if (request.readyState == 4) {
					//9.再判断响应是否可用：XMLHttpRequest对象的status属性值位200
					if (request.status == 200 || request.status == 304) {
						//打印输出结果
						alert(request.responseText);
					}
				}
			}
			//2.取消节点的行为
			return false;
		}
	}
</script>


	</head>

	<body>
		<a href="ajaxhello.txt">ajaxhello</a>
	</body>
</html>
