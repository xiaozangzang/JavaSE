package com.el;

public class MyFunction {
	/**
	 *   ƴ���ַ���
	 * @param str1  
	 * @param str2
	 * @return  ƴ�Ӻõ��ַ���
	 */
	public static String concat(String str1,String str2){
		return str1.concat(str2);
	}
	public static String toUpper(String str){
		return str.toUpperCase();
	}
	/**
	 * ���ַ���a1b2c3�е�����ȫ��ȫ���޳�������abc
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
	 * ���ַ���a1-b2-c3��-ȥ����ȥ����ĸ����������123
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
