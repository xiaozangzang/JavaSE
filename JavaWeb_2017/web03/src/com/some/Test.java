package com.some;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String name = "����";
		name = URLEncoder.encode(name, "utf-8");//����
		//E5 BC A0   E4 B8 89
		System.out.println(name);
		name = URLDecoder.decode(name, "utf-8");//����
		System.out.println(name);
	}
}
