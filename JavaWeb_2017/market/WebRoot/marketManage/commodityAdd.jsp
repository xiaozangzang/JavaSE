<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.cc.bean.*" %>
<% 
	//当前路径
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List<CommodityCategory> list = (List<CommodityCategory>)request.getAttribute("list");
	//页面分类
	String type = "commodity";
	//页面中文
	String text = "商品";
	//基础url
	String baseUrl = basePath + "commodity";
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
		<div class="formTitle">
			<span>新建<%=text %></span>
		</div>
		<div class="formPage">
		<form action="<%=baseUrl %>/insert" method="POST" enctype="multipart/form-data">
				<table>
					<tr>
						<td>名称：</td>
						<td><input type="text" name="name" value=""/></td>
					</tr>
					<tr>
						<td>分类：</td>
						<td>
							<select name="categoryId">
							<%for(int i = 0; i<list.size();i++){%>
								<option value="<%=list.get(i).getId() %>"><%=list.get(i).getName() %></option>
							<% } %>	
							</select>
						</td>
					</tr>
					<tr>
						<td>价格：</td>
						<td><input type="text" name="price" value=""/></td>
					</tr>
					<tr>
						<td>描述：</td>
						<td><input type="text" name="description" value=""/></td>
					</tr>
					<tr>
						<td>图片：</td>
						<td><input name="picture" type="file" accept="image/*" /></td>
					</tr>
					<tr>
						<td></td>
						<td><button class="submit" type="submit">确定</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>

</body>
</html>