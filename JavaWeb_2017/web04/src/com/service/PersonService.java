package com.service;

import java.util.List;

import com.entity.Person;
/*
 * ���ҵ����
 */
public interface PersonService {
	//�鿴
	public List<Person> findAll();
	//���
	public void save(Person p);
	//�����û�id�����û�
	public Person findById(int id);
	//�����û�id�޸��û�
	public void update(Person p);
	//ɾ��
	public void delete(int id);

}
