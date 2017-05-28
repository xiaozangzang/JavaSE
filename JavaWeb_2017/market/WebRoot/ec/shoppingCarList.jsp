<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.cc.bean.*" %>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String baseUrl = basePath + "shoppingCar";
	//页面分类
	String type = "shoppingCar";	
	//从第几页开始
	int startNum = (Integer)request.getAttribute("startNum");
	//每页多少条
	int pageCount = (Integer)request.getAttribute("pageCount");
	//共有多少条记录
	int count = (Integer)request.getAttribute("count");
	//当前第几页
	int currentPage = (Integer)request.getAttribute("currentPage");
	//商品列表
	List<ShoppingCar> list = (List<ShoppingCar>)request.getAttribute("list");
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
						<th width="120px;">添加时间</th>
						<th width="140px;">数量</th>						
						<th width="100px;">价格</th>
						<th width="100px;">操作</th>
					</tr>
				</thead>
				<tbody>
				<%for(int i=0;i<list.size();i++){ %>
					
					<tr>
	    				<td id="<%=list.get(i).getId() %>" class="shoppingCarId"><%=list.get(i).getId() %></td>
	    			<td>
	    				<img src="<%=basePath %>img<%=list.get(i).getPicture() %>">
	    			</td>
	    			<td class="name">
	    				<%=list.get(i).getCommodityName()%>
	    			</td>
	    			<td class="time">
	    				<%=list.get(i).getCreationTime()%>
	    			</td>
	    			<td class="num">
	    				<span><%=list.get(i).getCount() %></span>
	    			</td>
	    			<td class="price shoppingCarPrice">
	    				<%=list.get(i).getPrice()%>
                	</td>
	    			<td class="menus">
	    				<a class="delete" data-id="<%=list.get(i).getId() %>">删除</a>
	    				<a class="order"  data-id="<%=list.get(i).getId() %>">下单</a>
	    			</td>
	    		</tr>
	    		<%} %>
				</tbody>
				
	    	</table>
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
	    	
	    </div>
    </div>
    
</div>
<script>
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


$('.order').click(function(e){
	var $target = $(e.currentTarget),
		id = $target.data('id');
	$.ajax({
		url:'<%=basePath%>shoppingCar/addOrder',
		data:{
			id:id
		},
		success:function(data){
			$('#' + id).parent().remove();
			alert('下单成功');
		},
		error:function(){
			alert('下单失败');
		}
	})
});


$('.delete').click(function(e){
	var $target = $(e.currentTarget),
		id = $target.data('id');
	$.ajax({
		url:'<%=basePath%>shoppingCar/delete',
		data:{
			id:id
		},
		success:function(data){
			$('#' + id).parent().remove();
			alert('删除成功');
		},
		error:function(){
			alert('删除失败');
		}
	})
});
</script>
</body>
</html>