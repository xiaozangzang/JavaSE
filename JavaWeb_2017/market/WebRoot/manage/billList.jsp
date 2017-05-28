<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.cc.bean.*" %>
<% 
	//当前路径
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//从第几页开始
	int startNum = (Integer)request.getAttribute("startNum");
	//每页多少条
	int pageCount = (Integer)request.getAttribute("pageCount");
	//共有多少条记录
	int count = (Integer)request.getAttribute("count");
	//当前第几页
	int currentPage = (Integer)request.getAttribute("currentPage");
	//页面分类
	String type = "bill";	
	//基础url
	String baseUrl = basePath + "bill";
	//列表数据
	List<Bill> list = (List<Bill>)request.getAttribute("list");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>系统管理</title>
	<link rel="stylesheet" type="text/css" href="../css/manage.css">
	<script type="text/javascript" src="../javascript/jquery.js"></script>
</head>
<body>
<%@ include  file="./top.jsp"%>
<%@ include  file="./left.jsp"%>
<div class="manage_right">
	<div class="content">
		<!-- 用户列表 -->
		<div class="manageSearch">
			
		</div>
	
		<div class="manageList">
			<table>
				<thead>
					<tr role="row">
						<th>编号</th>
						<th>超市</th>
						<th>总价</th>
						<th>提成</th>
					</tr>
				</thead>
				<tbody>
					<%for(int i = 0;i<list.size();i++){%>
					<tr>
						<td><%=list.get(i).getId() %></td>
						<td><%=list.get(i).getSupermarketName() %></td>		
						<td><%=list.get(i).getTotalPrice() %></td>					
						<td><%=list.get(i).getCut() %></td>					
					</tr>	
					<%}%>			
				</tbody>
			</table>
			<%if(count==0){%>
				<div class="emptyData">暂无数据,请添加后查看~</div>
			<%}else{%>
				<div class="listFooter">
					<a id="prev" href="javascript:void(0);">
						<span class="prev"></span>
					</a>
					<div class="cut"></div>
					<span>第<strong><%=currentPage %></strong>页</span>
					<div class="cut"></div>
					<a id="next" href="javascript:void(0);">
						<span class="next"></span>
					</a>
					<div class="info">共<strong><%=count %></strong>条记录</div>
				</div>
			<%}%>
			
		</div>
	</div>
</div>
<script>
$(function(){
	var startNum = <%=startNum%>;
	var pageCount = <%=pageCount%>;
	var count = <%=count%>;
	var currentPage = <%=currentPage%>;

	$('#prev').click(function(e){
		if(startNum != 0){
			location.href = '<%=baseUrl%>/queryList?startNum=' + (startNum -pageCount)
		}
	});
	$('#next').click(function(e){
		if(currentPage * pageCount < count){
			location.href = '<%=baseUrl%>/queryList?startNum=' + (startNum + pageCount)
		}
	});

})
</script>
</body>
</html>