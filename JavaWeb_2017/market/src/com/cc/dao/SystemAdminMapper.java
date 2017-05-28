package com.cc.dao;

import org.apache.ibatis.annotations.Param;

import com.cc.bean.SystemAdmin;


public interface SystemAdminMapper {
	
	public SystemAdmin getByUsername(@Param(value = "username") String username);
	
	public void update(SystemAdmin admin);
}