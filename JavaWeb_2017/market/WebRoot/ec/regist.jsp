<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta charset="UTF-8">
<title>超市网</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<div class="w100">
    <div class="logo">
       	 超市购物网
        <!-- <b></b> -->
    </div>
    <div class="login-wrap">
        <div class="w">

        </div>
        <div class="w">
            <div class="login-form" style="top: 5px;">
                <div class="login-box">
                    <div class="mt">
                        <h1>超市购物网</h1>
                        <div class="extra-r">
                            <!-- <div class="regist-link"><a href="./jsp/ec/regist.jsp" ><b></b>立即注册</a></div> -->
                        </div>
                    </div>
                    <div class="msg-wrap">
                        <div class="msg-warn hide"><b></b></div>
                        <div class="msg-error hide"><b></b></div>
                    </div>
                    <div class="mc">
                        <div  class="form">
                            <form id="registForm" action="<%=basePath %>user/regist" method="post">
                                <div class="item item-fore1">
                                    <label class="login-label name-label"></label>
                                    <input id="name" type="text" class="text" name="username"  placeholder="用户名">
                                </div>
                                <div id="entry" class="item item-fore2">
                                    <label class="login-label pwd-label"></label>
                                    <input id="psd1" type="password" name="password" class="text"  placeholder="密码">
                                </div>
                                 
                                <div id="entry" class="item item-fore2">
                                    <label class="login-label pwd-label"></label>
                                    <input id="addr" type="text" name="address" class="text"  placeholder="地址">
                                </div>
                                <div id="entry" class="item item-fore2">
                                    <label class="login-label pwd-label"></label>
                                    <input id="tel" type="text" name="phone" class="text"  placeholder="电话">
                                </div>
                                <div class="item item-fore5">
                                    <div class="login-btn">
                                        <button type="submit" class="btn-img btn-entry" >注&nbsp;&nbsp;&nbsp;&nbsp;册</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="login-banner">
            <div class="w">
                <div id="banner-bg" class="i-inner">

                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>