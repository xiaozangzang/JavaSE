<%
	Object obj = session.getAttribute("login_success");
	if(obj == null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
 %>
