package com.cc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.bean.SystemAdmin;
import com.cc.dao.SystemAdminMapper;

@Service
public class SystemAdminService {
	
	@Autowired
	private SystemAdminMapper systemAdminMapper;

	public SystemAdmin getUserByUsername(String username){
		return this.systemAdminMapper.getByUsername(username);
	}
	
	public void update(SystemAdmin admin){
		this.systemAdminMapper.update(admin);
	}
	
}
