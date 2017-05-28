<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="content-type" content="text/html;charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="css/styles.css" />
	</head>
	<%
	SimpleDateFormat sf  = new SimpleDateFormat("yyyy/mm/dd");
	String strDate = sf.format(new Date());
	 %>
	<body>
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="rightheader">
						<p>
							${strDate}
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">Main</a>
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
								Username
							</td>
							<td>
								Sex
							</td>
							<td>
								Age
							</td>
							<td>

							</td>
						</tr>
						<c:forEach items="${list}" var="user" varStatus="i">
							<tr class="row1">
								<td>
									${user.id}
								</td>
								<td>
									${user.userName}
								</td>
								<td>
									${user.sex}
								</td>
								<td>
									${user.age}
								</td>
								<td>
									<a href="detail.do?detailName=${user.userName}">详细</a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="退出系统"
							onclick="location='login.jsp'" />
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
