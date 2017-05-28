package com.el;

public class MyFunction {
	/**
	 *   拼接字符串
	 * @param str1  
	 * @param str2
	 * @return  拼接好的字符串
	 */
	public static String concat(String str1,String str2){
		return str1.concat(str2);
	}
	public static String toUpper(String str){
		return str.toUpperCase();
	}
	/**
	 * 将字符串a1b2c3中的数字全部全部剔除，返回abc
	 */
	public static String removeNum(String str){
		String str1 ="";
		for(int i = 0;i < str.length();i++){
			if(str.charAt(i) >'9' || str.charAt(i) < '0'){
				str1 += str.charAt(i);
			}
		}
		System.out.println(str1);
		return str1;
	}
	
	/**
	 * 将字符串a1-b2-c3的-去掉，去掉字母，返回数字123
	 */
	public static String returnNum(String str){
		String str1 = "";
		for(int i = 0;i < str.length();i++){
			if(str.charAt(i) <= '9' && str.charAt(i) >= '0'){
				str1 +=str.charAt(i);
			}
		}
		System.out.println(str1);
		return str1;
	}
}
