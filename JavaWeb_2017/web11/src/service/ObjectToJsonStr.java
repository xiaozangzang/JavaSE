package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Card;
import entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 将对象转换为json字符串
 *
 */
public class ObjectToJsonStr {
	public static void main(String[] args) {
		//将对象转为json字符串
		getObjectToJson1();
		//将集合或者数组转为json字符串
//		getObjectToJson1();
	}
	
	public  static void getObjectToJson1(){
		/**将数组转为json字符串*/
		/*User[] user = new User[2];
		user[0] = new User(1002, "王五", null);
		user[0].setCard(new Card("card1001"));
		user[1] = new User(1003, "宋江", null);
		user[1].setCard(new Card("card1002"));
		JSONArray ary = JSONArray.fromObject(user);
		System.out.println(ary.toString());*/
		/**将集合转为json字符串*/
		/*List<User> lists = new ArrayList<User>();
		User user1 = new User(1002, "王五", null);
		user1.setCard(new Card("card1001"));
		User user2 = new User(1003, "宋江", null);
		user2.setCard(new Card("card1002"));
		lists.add(user2);
		lists.add(user1);
		JSONArray ary = JSONArray.fromObject(lists);
		System.out.println(ary.toString());*/
		/**将散列表转为json字符串*/
		/*Map<String,User> maps = new HashMap<String, User>();
		User user1 = new User(1002, "王五", null);
		user1.setCard(new Card("card1001"));
		User user2 = new User(1003, "宋江", null);
		user2.setCard(new Card("card1002"));
		maps.put("user1", user1);
		maps.put("user2", user2);
		JSONArray ary = JSONArray.fromObject(maps);
		System.out.println(ary.toString());*/
		/**将散列表转为json字符串*/
		Map<String,List<User>> maps = new HashMap<String, List<User>>();
		List<User> lists = new ArrayList<User>();
		User user1 = new User(1002, "王五", null);
		user1.setCard(new Card("card1001"));
		User user2 = new User(1003, "宋江", null);
		user2.setCard(new Card("card1002"));
		lists.add(user2);
		lists.add(user1);
		List<User> list2 = new ArrayList<User>();
		User user3 = new User(1004, "孙悟空", null);
		user3.setCard(new Card("card1003"));
		User user4 = new User(1005, "武松", null);
		user4.setCard(new Card("card1004"));
		list2.add(user3);
		list2.add(user4);
		maps.put("str", lists);
		maps.put("str2", list2);
		JSONArray ary = JSONArray.fromObject(maps);
		System.out.println(ary.toString());
	} 
	
	

	public  static void getObjectToJson() {
		/*将对象转换为json字符串*/
		/*User user = new User(1001,"张三", null);
		JSONObject obj = JSONObject.fromObject(user);
		//{"id":1001,"name":"张三","time":null}
		System.out.println(obj.toString());*/
		
		
		//1.
		/*User user = new User(1001,"张三", null);
		user.setNum(new int[]{1,2,3,4});
		JSONObject obj = JSONObject.fromObject(user);
		//{"id":1001,"name":"张三","num":[1,2,3,4],"time":null}
		System.out.println(obj.toString());*/
		
		//2.
//		User user = new User(1001,"张三", null);
//		user.setCard(new Card("1112233"));
//		JSONObject obj = JSONObject.fromObject(user);
//		//{"card":{"cardNo":"1112233"},"id":1001,"name":"张三","num":[],"time":null}
//		System.out.println(obj.toString());
//		//3.
		//4.
		//5.
	}
}



