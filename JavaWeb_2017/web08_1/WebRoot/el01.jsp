<%@ page import="java.util.*,com.entity.*" pageEncoding="utf-8"%>
<html>
  <body>
    <%
    	User user = new User();
    	user.setId(1001);
    	user.setName("张思宁");
    	user.setAge(24);
    	Card card = new Card();
    	card.setCardNo("111111111");
    	card.setCardName("红桃");
    	user.setCards(card);
    	user.setInterset(new String[]{"篮球","足球","排球"});
    	session.setAttribute("myUser", user);
     %>
     <!-- 获取数据 -->
     <h3>通过java代码片段获取</h3>
     <%
     	User u = (User)session.getAttribute("myUser");
     	out.println("id:"+u.getId());
     	out.println("name:"+u.getName());
     	out.println("age:"+u.getAge());
     	out.println("cardNo:"+u.getCards().getCardNo());
     	out.println("cardName:"+u.getCards().getCardName());
      %>
     <br/>
     <!-- 
     	jsp九大隐含对象：
     	out,request,response,session,application,config,exception,
     	page,pageContext
     -->
     <!-- 
     	el表达式的隐含对象
     	pageContext,request,session,application四个对象中依次查找有没有
     	数据，有的话，不再向下查找。可以限定查找的范围，如果不写范围，会依次按照
     	上续内容查找，如果写了查找范围，如果在当前范围中查找不到，则不再继续向
     	下查找：
     	pageScope,requestScope,sessionScope,applicationScope
     	如果el写了以上四种中的一种，查找范围就限定在从此范围查找，如果找不到，则不再
     	向后查找，如果四种中的一种都没写，默认从pageContext,request，session,
     	application依次查找	
      -->
     
     <!-- 通过el表达式获取 -->
	 <h3>通过el表达式获取数据值</h3>
	  ${myUser}<br/>
	  id：${pageScope.myUser.id}<br/>
	  name:${myUser.name}<br/>
	  age:${applicationScope.myUser.age}<br/>
	  cardNo:${sessionScope.myUser.cards.cardNo}<br/>
	  cardName:${requestScope.myUser.cards.cardName}<br/> 
	  <!-- 使用[]获取数据值-->
	  name:${requestScope.myUser["name"]}<br/>  
  	  <!-- 使用[]可以获取数组的值  -->
  	  interset:${sessionScope.myUser.interset[0]}<br/>
  	  <!-- 使用[]可以在[]中使用变量 -->
  	  <%
  	  		session.setAttribute("str", "name");
  	   %>
  	   name:${myUser[str]}<br/>
  	   
  	   <!-- el隐含对象  param  paramValues -->
  	   <!-- 
  	   	http://localhost:8080/web08_1/el01.jsp?pageSize=20&id=111&id=222&id=333
  	    	String pageSize = request.getParameter("pageSize");
  	    	String[] ary = request.getParameterValues("id");
  	    -->
  	   pageSize:${param.pageSize}<br/>
  	   productId:${paramValues.id[1]}<br/>
  </body>
</html>







