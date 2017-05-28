package com.service;

import java.util.List;

import com.dao.PersonDao;
import com.dao.PersonDaoImp1;
import com.entity.Person;

public class PersonServiceImp1 implements PersonService{
	private PersonDao dao ;//接口类型
	public PersonServiceImp1(){
		
	}
	public PersonServiceImp1(PersonDao dao){
		this.dao = dao;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public Person findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public void save(Person p) {
		// TODO Auto-generated method stub
		dao.save(p);
	}

	public void update(Person p) {
		// TODO Auto-generated method stub
		dao.update(p);
	}

}
