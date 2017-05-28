package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Person;
import com.util.DButils;

public class PersonDaoImp1 implements PersonDao {

	public void delete(int id) {
		// TODO Auto-generated method stub
		Connection conn = DButils.getConnection();
		String sql = "delete from person where id='" + id + "'";
		try {
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println("�����Ѿ���ɾ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Person> findAll() {
		// TODO Auto-generated method stub
		Connection conn = DButils.getConnection();
		String sql = "select id,name,salary,age from person";
		List<Person> lists = new ArrayList<Person>();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setSalary(rs.getString("salary"));
				p.setAge(rs.getString("age"));
				lists.add(p);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DButils.closeConnection(conn);
		return lists;
	}

	public Person findById(int id) {
		// TODO Auto-generated method stub
		Connection conn = DButils.getConnection();
		String sql = "select id,name,salary,age from person where id = '" + id
				+ "'";
		Person p = new Person();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setSalary(rs.getString("salary"));
				p.setAge(rs.getString("age"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public void save(Person p) {
		// TODO Auto-generated method stub
		Connection conn = DButils.getConnection();
		String sql = "insert into person(name,salary,age)values(?,?,?)";
		try {
			Statement stmt = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getSalary());
			ps.setString(3, p.getAge());
			int num = ps.executeUpdate();
//			System.out.println("��"+num+"�����ݲ������");
			DButils.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Person p) {
		// TODO Auto-generated method stub
		Connection conn = DButils.getConnection();
		String sql = "update person set name=?,salary=?,age=? where id = '"+p.getId()+"'";
		System.out.println("��Ҫ����"+p.toString());
		try {
			Statement stme = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getSalary());
			ps.setString(3, p.getAge());
			int num = ps.executeUpdate();
//			System.out.println("���ݱ�����");
			DButils.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
