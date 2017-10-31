package com.niit.org.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.org.bean.Account;
import com.niit.org.bean.Role;
import com.niit.org.mapper.IAccountService;
import com.niit.org.mapper.IRoleService;
import com.niit.org.service.IAccount;
import com.niit.org.util.JschUtil;

@Controller
public class IndexController {

	@Resource
	private IAccount accountService;
	
	@Resource
	private IRoleService irs;
	
	@Resource
	private IAccountService iac;
	
	@RequestMapping("/index")
	public String index(ModelMap resultMap) {
		
	
		
		List<Account> accountList = iac.getAll();//accountService.getCount();
            
		List<Role> roleList=irs.getAll();
		
				
		resultMap.addAttribute("account",accountList.get(2));
		resultMap.addAttribute("rolelist",roleList);
		resultMap.addAttribute("role1",roleList.get(0));
		return "index";
	}
	
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String chooseRoomView() {
        return "home";
    }
    
    @RequestMapping(value = "/chooseRoomId",method = RequestMethod.POST)
    public String enterRoom(HttpSession session,@RequestParam("roomId") String roomId, ModelMap modelMap){
        session.setAttribute("roomId",roomId);
        modelMap.addAttribute("roomId",roomId);
        return "redirect:/liveroom";
    }
}