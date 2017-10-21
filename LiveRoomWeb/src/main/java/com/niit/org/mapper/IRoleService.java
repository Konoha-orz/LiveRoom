package com.niit.org.mapper;

import java.util.List;

import com.niit.org.bean.Role;



public interface IRoleService {
	public List<Role> getAll();
	public int insertRole(Role role);
}
