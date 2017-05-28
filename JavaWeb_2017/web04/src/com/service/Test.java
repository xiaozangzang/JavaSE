package com.service;

import java.util.List;

public class Test {
	public static void main(String[] args) {
			List list = new PersonServiceImp1().findAll();
			System.out.println(list.toString());
	}
}
