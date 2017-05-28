<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
	<script type="text/javascript">
		/**js创建对象方式一*/
		function getPerson(){
			var person = new Object();
			person.name = "张三";
			person.age = 25;
			person.address = "陕西省";
			alert(person.name+" "+person.address);
		}
		//getPerson();
		/**js创建对象方式二*/
		function Person(name,age){
			this.name = name;
			this.age = age;	
		}
		function getPerson1(){
			var p = new Person("李四",35);
			alert(p.name+" "+p.age);
		}
		//getPerson1();
		/**
			json：是一种数据交互的格式，可以进行轻量级的数据封装，完成
			浏览器与服务器之间的数据交互
		*/
		
		function getPerson2(){
		   //obj就是一个json对象
			/*
				class Person{
					public String name = "zs";
					public int age = 25;
					public String address = "sx";
				}
				Person p = new Person();
				p.name   p.age   p.address	
			*/
			var obj = {"name":"zs","age":25,"flag":true,"isNull":null};
			//如何获取json对象的数据
			alert(obj.name+" "+obj.age+" "+obj.flag+" "+obj.isNull);
			//json对象可以放对象
			/*
				class Person{
					public String name = "zs";
					public int age = 25;
					public String address = "sx";
					public num num;
				}
				class num{
					public int numId=1001;
					public int id = 10;
				}
				Person p = new Person();
				p.num.id
			*/
			
			obj = {"name":"lisi","num":{"numId":1001,"id":10},"age":23};
			alert(obj.num.numId);
			//可以创建一个数组
			/*
				class Person{
					User[] users = new User[2];
					users[0] = new User("zs","21");
					users[1] = new User("李四","25");
					List<User> lists = new ArrayList<User>();
					lists.add(new User("zs","21"));
					lists.add(new User("李四","25"));
				}
				class User{
					public String name = "zs";
					public String age = "21";
				}			
			*/
			obj = [{"name":"zs","age":"21"},{"name":"李四","age":"22"}];
			alert(obj[1].name);
			/*
			class Person{
				name = "zs";
				age = "25";
				num[] users = new num[2];
				users[0] = new User("zs","21");
				users[1] = new User("李四","25");
				List<num> lists = new ArrayList<num>();
				lists.add(new User("zs","21"));
				lists.add(new User("李四","25"));
			}
			class num{
				public int numId=1001;
				public int id = 10;
			}
			*/
			
			obj = {"name":"lisi","num":[{"numId":1001,"id":10},{"numId":1002,"id":11}],"age":23};
			alert(obj.num[1].id);
			//json字符串<--->json对象
			//必须将json字符串转成json对象
			obj = "{'name':'zs','age':24}";
			alert("----:"+obj.name);
		}
		getPerson2();
		
	</script>
  </head>
  
  <body>
    
  </body>
</html>
