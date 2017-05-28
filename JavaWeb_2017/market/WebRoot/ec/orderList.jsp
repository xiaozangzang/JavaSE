<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.cc.bean.*" %>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String baseUrl = basePath + "order";
	//页面分类
	String type = "order";	
	
	//商品列表
	List<ServiceOrder> list = (List<ServiceOrder>)request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>超市购物网</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<script type="text/javascript" src="../javascript/jquery.js"></script>
</head>
<body>
<div class="w">
	<div class="w100">
		<%@ include  file="./top.jsp"%>
	    <%@ include  file="./menus.jsp"%>
	    <div class="ec_content">
	    	<table class="shoppingCar"  boder="0" cellpadding="0" cellspacing="0">
	    		<thead>
					<tr role="row">
						<th width="25px;">编号</th>
						<th width="120px;">图片</th>
						<th width="100px;">名称</th>						
						<th width="120px;">下单时间</th>
						<th width="120px;">状态</th>
						<th width="120px;">配送方式</th>
					</tr>
				</thead>
				<tbody>
				<%for(int i=0;i<list.size();i++){ %>
					<tr>
	    				<td id="<%=list.get(i).getId() %>" class="shoppingCarId"><%=list.get(i).getId() %></td>
	    			<td>
	    				<img src="<%=basePath %>img<%=list.get(i).getPicture()%>">
	    			</td>
	    			<td class="name">
	    				<%=list.get(i).getCommodityName()%>
	    			</td>
	    			<td class="time">
	    				<%=list.get(i).getCreationtime()%>
	    			</td>
	    			<td class="num">
	    				<span><%=list.get(i).getStatus()%></span>
	    			</td>
	    			<td class="price shoppingCarPrice">
	    				<%=list.get(i).getSendType()%>
                	</td>
	    		</tr>
	    		<%} %>
				</tbody>
	    	</table>
	    </div>
    </div>
    
</div>
</body>
</html>