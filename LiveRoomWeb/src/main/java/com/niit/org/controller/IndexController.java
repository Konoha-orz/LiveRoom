package com.niit.org.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.org.bean.Account;
import com.niit.org.bean.Role;
import com.niit.org.mapper.IAccountService;
import com.niit.org.mapper.IRoleService;
import com.niit.org.service.IAccount;
import com.niit.org.util.JschUtil;

@Controller

@RequestMapping("/index")

public class IndexController {

	@Resource
	private IAccount accountService;
	
	@Resource
	private IRoleService irs;
	
	@Resource
	private IAccountService iac;
	
	@RequestMapping()

	public String index(ModelMap resultMap) {
		
		
		//此处通过SSH外部访问远程mysql服务器需要用到JSCH,服务器端上不需要
		JschUtil sshutil=new JschUtil();
		
		//*************SSH端口转接开启
		sshutil.open();
		
		List<Account> accountList = iac.getAll();//accountService.getCount();
            
		List<Role> roleList=irs.getAll();
		
		
		//**************SSH端口转接关闭
				sshutil.close();
				
		resultMap.addAttribute("account",accountList.get(2));
		resultMap.addAttribute("rolelist",roleList);
		resultMap.addAttribute("role1",roleList.get(0));
		return "index";

	}

}