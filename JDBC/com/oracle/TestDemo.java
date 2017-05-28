package com.oracle;

import java.sql.Connection;

public class TestDemo {
	public static void main(String[] args) {
		Connection conn = new Demo().getConnection();
	}

}
