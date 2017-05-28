<%@page import="java.util.*,com.bean.*,com.entity.*;"
	pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<html>
	<head>
		<meta http-equiv=Content-Type content="text/html; charset=utf-8" />
		<link href="css/main/style.css" type="text/css" rel="stylesheet" />
	</head>

	<body topMargin="10">
		<div id="append_parent"></div>
		<table cellSpacing="6" cellPadding="2" width="100%" border="0">
			<tbody>
				<tr>
					<td>
						<table class="guide" cellSpacing="0" cellPadding="0" width="100%"
							border="0">
							<tbody>
								<tr>
									<td>
										<a href='#'>t主页</a>&nbsp;/&nbsp;
										<a href='computer_list.html'>笔记本订购(WEB007)</a>&nbsp;/&nbsp;购物车信息
									</td>
								</tr>
							</tbody>
						</table>
						<br />



						<table class="tableborder" cellSpacing="0" cellPadding="0"
							width="100%" border="0">
							<tbody>
								<tr class="header">
									<td class="altbg2" colspan="6">
										购物车信息
									</td>
								</tr>
								<tbody>
									<tr>
										<td class="altbg1" width="20%">
											<b>型号</b>
										</td>
										<td class="altbg1" width="20%">
											<b>价格</b>
										</td>
										<td class="altbg1" width="10%">
											<b>数量</b>
										</td>
										<td class="altbg1" width="30">
											&nbsp;
										</td>
										<td class="altbg1" width="10%">
											&nbsp;
										</td>
										<td class="altbg1">
											&nbsp;
										</td>
									</tr>
								</tbody>

								<tbody>
									<%
										Cart cart = (Cart) session.getAttribute("cart");
										List<CartItem> lists = cart.getList();
										if (cart != null && lists.size() > 0) {
											{
												//有东西
												double totalPrice = 0;
												for (int i = 0; i < lists.size(); i++) {
													CartItem item = lists.get(i);
													Computer c = item.getComputer();
													totalPrice += c.getPrice() * item.getCount();
									%>
									<tr>
										<td class="altbg2"><%=c.getModel()%>
										</td>
										<td class="altbg2"><%=c.getPrice()%>
										</td>
										<td class="altbg2"><%=item.getCount()%>
										</td>
										<td class="altbg2">
											<input type="text" size="3" id="num_<%=c.getId()%>" />
										</td>
										<td class="altbg2">
											<a href="javascript:;"
												onclick="location='modify.do?id=<%=c.getId()%>&num=' + document.getElementById('num_<%=c.getId()%>').value;">更改数量</a>
										</td>
										<td class="altbg2">
											<a href="delete.do?id=<%=c.getId()%>">删除</a>
										</td>
									</tr>
									<%
										}
									%>
									<tr>
										<td class="altbg1" colspan="6">
											<b>总价格：￥</b><%=totalPrice%>
										</td>
									</tr>
									<%
										}
										} else {
									%>
									<tr>
										<td class="altbg2" colspan="6">
											<b>还没有选购商品</b>
										</td>
									</tr>
									<%
										}
									%>
								</tbody>
						</table>

						<br />
						<center>
							<input class="button" type="button" value="返回商品列表"
								name="settingsubmit"
								onclick="location.href= '<%=request.getContextPath()%>/list.do';">
							<input class="button" type="button" value="清空购物车"
								name="settingsubmit"
								onclick="location = '<%=request.getContextPath()%>/clear.do';">
						</center>
					</td>
				</tr>
			</tbody>
		</table>



		<div id="append_parent"></div>
		<table cellSpacing="6" cellPadding="2" width="100%" border="0">
			<tbody>
				<tr>
					<td>
						<table class="guide" cellSpacing="0" cellPadding="0" width="100%"
							border="0">
							<tbody>
								<tr align="center">
									<td>
										回收站
									</td>
								</tr>
							</tbody>
						</table>
						<br />
						<table class="tableborder" cellSpacing="0" cellPadding="0"
							width="100%" border="0">
							<tbody>
								<tr class="header">
									<td class="altbg2" colspan="6">
										购物车信息
									</td>
								</tr>

								<tbody>
									<tr>
										<td class="altbg1" width="25%">
											<b>型号</b>
										</td>
										<td class="altbg1" width="25%">
											<b>价格</b>
										</td>
										<td class="altbg1" width="25%">
											&nbsp;
										</td>
										<td class="altbg1" width="25%">
											&nbsp;
										</td>
										<td class="altbg1">
											&nbsp;
										</td>
									</tr>
								</tbody>
								<%
									List<CartItem> recoverList = cart.getRecoverList();
									if (cart != null && recoverList.size() > 0) {
										for (int i = 0; i < recoverList.size(); i++) {
											CartItem item = recoverList.get(i);
											Computer c = item.getComputer();
								%>
								<tbody>

									<tr>
										<td class="altbg2"><%=c.getModel() %>
										</td>
										<td class="altbg2"><%=c.getPrice() %>
										</td>
										<td class="altbg2">
											<a href="recover.do?recoverId=<%=c.getId() %>">加入购物车</a>
										</td>
										<td class="altbg2">
											<a href="remove.do?removeId=<%=c.getId() %>">删除</a>
										</td>
									</tr>
								</tbody>
								<%
									}
									}
								%>
							
						</table>

						<br />

					</td>
				</tr>
			</tbody>
		</table>

	</body>
</html>



