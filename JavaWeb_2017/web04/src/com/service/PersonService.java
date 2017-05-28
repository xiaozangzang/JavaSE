package com.service;

import java.util.List;

import com.entity.Person;
/*
 * 完成业务处理
 */
public interface PersonService {
	//查看
	public List<Person> findAll();
	//添加
	public void save(Person p);
	//根据用户id查找用户
	public Person findById(int id);
	//根据用户id修改用户
	public void update(Person p);
	//删除
	public void delete(int id);

}
