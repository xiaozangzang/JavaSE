<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*,com.entity.*;" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
 <body>
	<%  
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
			String strDate = sdf.format(new Date());  
		 %>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<%= strDate %>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="list.do">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
					<%
							Person p = new Person();
							p = (Person)request.getAttribute("p");
							 %>
					<form action="<%=request.getContextPath() %>/update.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									<input type="text"  class="inputgri" name="id" value="<%=p.getId() %>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="<%=p.getName() %>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="<%=p.getSalary() %>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									age:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="<%=p.getAge() %>"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Confirm" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
