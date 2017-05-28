<%@ page import="java.util.*,com.entity.*" pageEncoding="utf-8"contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body>
		<%
			List<User> lists = new ArrayList<User>();
			User user = new User();
			user.setId(1001);
			user.setName("张思宁");
			user.setAge(24);
			User user1 = new User();
			user1.setId(1002);
			user1.setName("李四");
			user1.setAge(25);
			User user2 = new User();
			user2.setId(1003);
			user2.setName("王五");
			user2.setAge(26);
			Card card = new Card();
			card.setCardNo("111111111");
			card.setCardName("红桃");
			user.setCards(card);
			user.setInterset(new String[] { "篮球", "足球", "排球" });
			lists.add(user);
			lists.add(user1);
			lists.add(user2);
			request.setAttribute("myLists", lists);
			session.setAttribute("myUser", user);
		%>
		<!-- jstl标签的使用 -->
		<c:out value="zhangsan"></c:out>
		<c:out value="&lt;table&gt;" escapeXml="false"></c:out>
		<c:out value="<table>" escapeXml="true"></c:out>
		<c:out value="${myUser1.id}" default="no"></c:out>
		<hr>
		<c:set property="id" value="9999" var="myId" scope="request"></c:set>
		<c:out value="${requestScope.myId}"></c:out>
		<c:set property="name" value="王五" var="myName" scope="session"></c:set>
		<c:out value="${sessionScope.myName}"></c:out>
		<hr>
		<c:remove var="myName" scope="session" />
		<c:out value="${sessionScope.myName}"></c:out>
		<hr>
		<c:catch var="msg">
			<%
				Integer.parseInt("12abc");
			%>
		</c:catch>
		${msg}
		<hr>
		<%
			request.setAttribute("sex", "M");
			request.setAttribute("age", "23");
		%>
		<c:if test="${sex eq 'M'}" var="other">
			<c:if test="${age >= 23}" var="qi">
				<c:out value="is man,可以结婚" />
			</c:if>
			<c:if test="${!qi}">
				<c:out value="is man,年龄不够" />
			</c:if>
		</c:if>
		<c:if test="${!other}">
			<c:out value="Woman" />
		</c:if>
		<hr>

		<!-- 
  		stat:index从0开始  count从1开始
  	 -->
		<table border="1px">
			<tr>
				<td>
					num
				</td>
				<td>
					id
				</td>
				<td>
					name
				</td>
				<td>
					age
				</td>
			</tr>
			<c:forEach items="${myLists}" var="t" varStatus="stat">
				<tr>
					<td>
						${stat.count}
					</td>
					<td>
						${t.id}
					</td>
					<td>
						${t.name}
					</td>
					<td>
						${t.age}
					</td>
				</tr>
			</c:forEach>
		</table>
		<%
			pageContext.setAttribute("score", 40);
		%>
		
		<c:choose>
			<c:when test="${score >= 90}">
				<c:out value="优秀" default="好"></c:out>
			</c:when>
			<c:when test="${score >= 80 && score < 90}">
				<c:out value="良好" default="可以"></c:out>
			</c:when>
			<c:when test="${score >= 60 && score < 80}">
				<c:out value="及格" default="还行"></c:out>
			</c:when>
			<c:otherwise>
				<c:out value="不及格" default="哎。。。"></c:out>
			</c:otherwise>
		</c:choose>
		<c:if test="${score >= 90}" var="A">
			<c:out value="优秀" default="好"></c:out>
		</c:if>
		<c:if test="${!A}">
			<c:if test="${score >= 80 && score < 90}" var="B">
				<c:out value="良好" default="可以"></c:out>
			</c:if>
			<c:if test="${!B}">
				<c:if test="${score >= 60 && score < 80}" var="C">
					<c:out value="及格" default="还行"></c:out>
				</c:if>
				<c:if test="${!C}">
					<c:out value="不及格" default="哎。。。"></c:out>
			</c:if>
			</c:if>
		</c:if>


	</body>
</html>











