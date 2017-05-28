<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.cc.bean.*" %>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String baseUrl = basePath + "commodity";
	//页面分类
	String type = "commodity";	
	//从第几页开始
	int startNum = (Integer)request.getAttribute("startNum");
	//每页多少条
	int pageCount = (Integer)request.getAttribute("pageCount");
	//共有多少条记录
	int count = (Integer)request.getAttribute("count");
	//当前第几页
	int currentPage = (Integer)request.getAttribute("currentPage");
	//商品列表
	List<Commodity> list = (List<Commodity>)request.getAttribute("list");
	
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
		
		<!-- <div>
			<input type="text" >
			<button id="search">查询</button>
		</div> -->	
		
	    <div class="ec_content">
	    	<%for(int i = 0;i<list.size();i++){%>
	    	<div class="block">
				<img src="<%=basePath%>img<%=list.get(i).getPicture()%>" width="140" height="200">
				<div class="info">
					<div class="title">名       称：<%=list.get(i).getName() %></div>
					<div class="category">类型：<%=list.get(i).getCategoryName()%></div>
					<div class="supermarketName">超市：<%=list.get(i).getSupermaketName() %></div>
					<div class="salesCount">销量：<%=list.get(i).getSalesCount() %></div>				
					<div class="price">价格：￥<%=list.get(i).getPrice() %></div>
					<a class="add_buy_car" data-id="<%=list.get(i).getId() %>" data-price="<%=list.get(i).getPrice()%>" >
						<span class="buyCar"></span>
					</a>
				</div>
			</div>
			<%} %>
			
			
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

	$('.add_buy_car').click(function(e){
		var $target = $(e.currentTarget),
			id = $target.data('id'),
			price = $target.data('price');
		$.ajax({
			url:'<%=basePath%>shoppingCar/add',
			data:{
				commodityId:id
			},
			success:function(data){
				alert('添加成功');
			},
			error:function(){
				alert('添加失败');
			}
		})
	});
	$('#prev').click(function(e){
		if(startNum != 0){
			location.href = '<%=baseUrl%>/userQueryList?startNum=' + (startNum -pageCount)
		}
	});
	$('#next').click(function(e){
		if(currentPage * pageCount < count){
			location.href = '<%=baseUrl%>/userQueryList?startNum=' + (startNum + pageCount)
		}
	});
})
</script>
</body>
</html>