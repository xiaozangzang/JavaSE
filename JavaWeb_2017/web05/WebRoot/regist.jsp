<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@page import="java.util.logging.SimpleFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<%
	SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
	String dateStr = sd.format(new Date());
	 %>
	<body>
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="rightheader">
						<p>
							${dateStr}
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="<%=request.getContextPath()%>/regist.jsp">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="<%=request.getContextPath()%>/regist.do"
						method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
									<span style="color: red;">${register_err}</span>

								</td>

							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="m"
										checked="checked" />
									女
									<input type="radio" class="inputgri" name="sex" value="f" />
								</td>
							</tr>

							<tr>
								<td valign="middle" align="right">
									验证码:
									<img src="CheckCode" src="image" id="imageId" />
									<!--   <a href="javascript:;"
										onclick="document.getElementById('imageId').src='CheckCode?'+Math.random()">换一张</a>
										-->
									
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" />
									
									<span style="color: red;">${code_err}</span>
								</td>

							</tr>
						</table>

						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
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
