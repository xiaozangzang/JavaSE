<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
  	<title>异步请求--下拉列表</title>
  	<script type="text/javascript">
  		function getXmlHttpRequest(){
  			var xhr = null;
  			if((typeof XMLHttpRequest) != 'undefined'){
  				xhr = new XMLHttpRequest();
  			}else{
  				xhr = new ActiveXObject('M icrosoft.XMLHttp');
  			}
  			return xhr;
  		}
  		
  		function changes(obj){
  			var xhr = getXmlHttpRequest();
  			var url = "quto.do";
  			xhr.open("post", url, true);
  			//设置消息头
  			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  			xhr.onreadystatechange = function(){
  				//服务器响应给浏览器的数据在这里处理
  				//[将结果添加到s2下拉列表里面]
  				//text="mj:毛巾;ys:牙刷;xyf:洗衣粉;xfs:洗发水"
  				var text = xhr.responseText;
  				var ary = text.split(";");//[[mj:毛巾],[ys:牙刷]]
  				var s2 = document.getElementById("s2");
  				s2.innerHTML = "";
  				for(var i = 0; i < ary.length; i ++){
  					var strAry = ary[i];//[mj:毛巾]
  					var str = strAry.split(":");//[mj=毛巾]
  					//创建option对象，将option对象挂到s2下拉列表中
  					var op = new Option(str[1], str[0]);
  					s2.options[i] = op;
  				}
  			};
  			xhr.send("objName="+obj);
  		}
  	</script>
  </head>
  
  <body>
    <select id="s1" onchange="changes(this.value);">
    	<option value="car">汽车</option>
    	<option value="ryp">日用品</option>
    </select>
    <select id="s2">
    	
    </select>
    
    
  </body>
</html>
