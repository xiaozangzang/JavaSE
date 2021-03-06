<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<html>
  <head>
	    <!-- 使用ajax发送请求[get,post] -->
    <script type="text/javascript">
    	/**1、获取XMLHttpRequest对象*/
    	function getXmlHttpRequest(){
    		var xhr;
    		//ie以外的其他浏览器
    		if((typeof XMLHttpRequest) != 'undefined'){
    			xhr = new XMLHttpRequest();
    		}else{//ie浏览器
				xhr = new ActiveXObject('Microsoft.XMLHttp');
    		}
    		return xhr;
    	}
		/**验证用户名是否存在*/
		function validateName(){
			var xhr = getXmlHttpRequest();
			console.log(xhr);//在浏览器的控制台打印
			/**2、打开请求*/
			//由xhr对象发给服务器
			var url = "validUserName.do?username="+document.getElementById("nameId").value;
			//不管是火狐，还是ie，发送请求都采用utf-8对中文编码进行发送
			//true代表异步发请求，false代表同步发请求
			xhr.open("get",encodeURI(url),true);
			/**3、调用回调函数----注册监听器*/
			xhr.onreadystatechange = function(){//匿名函数
				//回调函数作用：获取服务器响应给浏览器的数据(文本或者是xml)，通
				//过dom的方式修改文档树   
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						//readyState属性代表请求发送的五个状态，当这个状态码为4的时候，整个请求响应结束
						//alert(xhr.readyState);
						//txt:就是接收到服务器返回的字符串[user exist,ok]
						var txt = xhr.responseText;//服务器给浏览器响应了一个text文本文件
						
						document.getElementById("registId").innerHTML=txt;
						//xhr.responseXML;服务器给浏览器响应了一个xml文件
					}else{
						document.getElementById("registId").innerHTML="系统错误";
					}
				}else{
					document.getElementById("registId").innerHTML="正在验证...";
				}
			};
			/**4、发送请求*/
			//如果是get请求，send方法中的请求参数必须是null
			xhr.send(null);
		}
		/**post请求*/
		function validatePwd(){
			var xhr = getXmlHttpRequest();
			var url = "validPwd.do";
			xhr.open("post",url,true);
			//设置消息头
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						var txt = xhr.responseText;
						document.getElementById("pwdId").innerHTML=txt;
					}else{
						document.getElementById("pwdId").innerHTML="系统有误。。。";
					}
				}else{
					document.getElementById("pwdId").innerHTML="验证中...";
				}
			};
			//发送请求参数
			xhr.send("MyPwd="+document.getElementById("pdId").value);
		}
    </script>
    
   
   
  </head>
  
  <body>
  	<h1>regist</h1>
  	<form action="regist.do" method="post">
  		<table>
  			<tr>
  				<td>username:</td>
  				<td><input id="nameId" type="text" name="name" onblur="validateName();"/></td>
  				<td><span style="color:red;" id="registId"></span></td>
  			</tr>
  			<tr>
  				<td>pwd:</td>
  				<td><input id="pdId" type="text" name="pwd" onblur="validatePwd();"/></td>
  				<td><span style="color:red;" id="pwdId"></span></td>
  			</tr>
  			<tr><td colspan="2" ><input type="submit" name="confirm"/></td></tr>
  		</table>
  	</form>
  </body>
</html>
