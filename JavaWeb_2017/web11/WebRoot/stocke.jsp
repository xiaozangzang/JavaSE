<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
	<style type="text/css">
		#myId{
			border:solid 3px green;
			width:400px;
			height:200px
		}
	</style>
	<script type="text/javascript" src="js/prototype-1.6.0.3.js"></script>
	<script type="text/javascript">
		function getXmlHttpRequest(){
  			var xhr = null;
  			if((typeof XMLHttpRequest) != 'undefined'){
  				xhr = new XMLHttpRequest();
  			}else{
  				xhr = new ActiveXObject('Microsoft.XMLHttp');
  			}
  			return xhr;
  		}
  		function getStocke(){
  			var xhr = getXmlHttpRequest();
  			xhr.open("post","stocke",true);
  			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xhr.onreadystatechange = function(){
				//接收服务器返回的json字符串
				var txt = xhr.responseText;
				//将json字符串转为json对象
				var obj = txt.evalJSON();
				var sp = document.getElementById("spanId");
				var val="";
				for(var i = 0; i < obj.length; i ++){
					var str = obj[i];
					val += "编号："+str.card.cardNo+
						"<br/>股票名："+str.name+
					"<br/>价格："+str.price+
						"<br/>日期："+str.time+"<br/>";
				}
				sp.innerHTML = val;
			};
			xhr.send();  			
  		}
  		/** 设置计时器 */
  		var time;
  		function start(){
  			time = setInterval(getStocke, 1000);
  		}
  		function end(){
  		
  			clearTimeout(time);
  		}
	</script>
  </head>
  
  <body>
  <h1>股票随机滚动出现</h1>
	<div id="myId">
		<span id="spanId" style="color:red;"></span>
	</div>
	<input type="button" value="开始" onclick="start();"/><br/>
	<input type="button" value="结束" onclick="end();"/>
  </body>
</html>
