<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="utf-8"contentType="text/html; charset=utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	

  </head>
  <%
   SimpleDateFormat sf = new SimpleDateFormat("yyyy/mm/dd");
   String strDate = sf.format(new Date());
    %>
  <body>
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="rightheader">
						<p>&nbsp; 
							${strDate}
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="${pageContext.request.contextPath}/userList.do">Main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>

				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						User Detail:
					</h1>
					<table class="table">
						<tr>
							<td>
								姓名
							</td>
							<td>
								电话
							</td>
						</tr>
						<tr>
							<td>
								${requestScope.user.name}
							</td>
							<td>
								${requestScope.user.phone}
							</td>
						</tr>
					</table>
					<%
					User user1 = (User)session.getAttribute("login_success");
					User user = (User)request.getAttribute("user");
					if(user1.equals(user)){
					 %>
					<h1>
						Load Photo:
					</h1>
						<form action="upload.do" method="post"
							enctype="multipart/form-data">
							Upload File Name:
							<input type="file" name="file1" />
							<input type="submit" value="confirm" />
						</form>
					<%} %>
					<h1>
						view photo:
					</h1>
					<table>
								<tr>
									<td>
										<img src="upload/t1.jpg" width="300"
											height="200" />
									</td>
								</tr>
					</table>
				</div><h1>
				<a href="userList.do">return</a></h1>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
