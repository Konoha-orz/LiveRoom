package com.niit.org.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.org.bean.User;
import com.niit.org.mapper.IUser;

@Controller

@RequestMapping("/createLiveroom")
public class CreateLiveroomController {

	@Resource
	private IUser iuser; 
	
	@RequestMapping()
	public String createLiveroom(ModelMap map) {
		List<User> list = iuser.getAll();
		map.addAttribute("userList", list);
		return "createLiveroom";
	}
	
}
