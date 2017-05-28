<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="manage_top">
	<div>
		超市管理系统
		<a style="float: right;font-size: 12px;" href="<%=basePath%>manage/updatePwd.jsp">
			修改密码
		</a>
		<span><%=(String)request.getSession().getAttribute("username") %>您好</span>
	</div>
</div>
