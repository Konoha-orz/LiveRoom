package com.niit.org.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.org.bean.Role;
import com.niit.org.mapper.IRoleService;

@Controller

@RequestMapping("/insert")
public class InsertController {
	
	@Resource
	private IRoleService irs;
	
	@RequestMapping()
	public String insert(HttpServletRequest request) {
		
		String rolename=request.getParameter("rolename");
		String des=request.getParameter("des");
		
		Role role =new Role();
		role.setDescription(des);
		role.setRole_name(rolename);
		int result =irs.insertRole(role);
		
		return "insertSucess";
	}

}
