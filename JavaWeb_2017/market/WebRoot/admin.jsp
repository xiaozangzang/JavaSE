<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>超市在线系统</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/manage.css">
</head>
<body>
<div class="admin_top">
    超市在线系统
</div>
<div class="login">
<div class="login_top">
    请登录
</div>
<div>
	<form action="<%=basePath %>systemAdmin/login" method="post">
    <table width="100%">
        <tr>
            <td width="40%" height="50px" align="center">用户名:</td>
            <td width="60%" align="left">
                <input type="text" name="username"/>
            </td>
        </tr>
        <tr>
            <td width="40%" height="50px" align="center">密码:</td>
            <td width="60%" align="left">
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit" class="submit">确定</button>
            </td>
        </tr>
    </table>
    </form>
</div>
</div>
</body>
</html>