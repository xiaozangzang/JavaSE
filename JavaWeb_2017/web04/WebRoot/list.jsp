<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*,com.entity.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
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
							<%=strDate %>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="list.do">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td colspan="2"align="center">
								Operation
							</td>
						</tr>
						<%
							List<Person> lists = 
							(List<Person>)request.getAttribute("lists");
							for(int i = 0; i < lists.size(); i ++){
								Person p = lists.get(i);
						%>
							<tr class="row<%=i%2+1%>">
								<td>
								<%=p.getId()%>
								
								</td>
								<td>
								<a href="<%=request.getContextPath() %>/view.do?viewId=<%=p.getId()%>"><%=p.getName() %></a></td>
								<td><%=p.getSalary() %></td>
								<td><%=p.getAge() %></td>
								<td>
									<a href="delete.do?delId=<%=p.getId()%>">delete emp</a></td>
									<td><a href="modify.do?modId=<%=p.getId() %>">update emp</a>
								</td>
							</tr>
					<%	
						}
					 %>
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='add.jsp'"/>
					</p>
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
