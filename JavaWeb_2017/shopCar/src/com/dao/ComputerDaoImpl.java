package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Computer;
import com.util.DBUtil;

public class ComputerDaoImpl implements ComputerDao{

	public List<Computer> findAll() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		List<Computer> lists = new ArrayList<Computer>();
		Computer c = null;
		String sql = "select id,model,picName,prodDesc,price from t_product";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			 c = new Computer();
			 c.setId(rs.getInt("id"));
			 c.setModel(rs.getString("model"));
			 c.setPicName(rs.getString("picName"));
			 c.setProdDesc(rs.getString("prodDesc"));
			 c.setPrice(rs.getDouble("price"));
			 lists.add(c);
		}
		return lists;
	}

	public Computer findByComputer(int buyId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		Computer c = null;
		String sql = "select id,model,picName,prodDesc,price from t_product where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, buyId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			 c = new Computer();
			 c.setId(rs.getInt("id"));
			 c.setModel(rs.getString("model"));
			 c.setPicName(rs.getString("picName"));
			 c.setProdDesc(rs.getString("prodDesc"));
			 c.setPrice(rs.getDouble("price"));
		}
		return c;
	}


}
