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
import com.niit.org.bean.LiveRoom;
import com.niit.org.bean.Role;
import com.niit.org.dto.LiveRoomDTO;
import com.niit.org.mapper.IAccountService;
import com.niit.org.mapper.ILiveRoomService;
import com.niit.org.mapper.IRoleService;
import com.niit.org.service.IAccount;
import com.niit.org.util.JschUtil;
import com.niit.org.util.SearchKeyJudge;

@Controller
public class IndexController {

	@Resource
	private IAccount accountService;
	
	@Resource
	private IRoleService irs;
	
	@Resource
	private IAccountService iac;
	
	@Resource
	private ILiveRoomService ilrs;
	
	@RequestMapping("/index")
	public String index(ModelMap resultMap,HttpSession session) {
		
	
		List<LiveRoom> roomlist=ilrs.queryAllLiveRoom();
		session.setAttribute("roomlist", roomlist);
		resultMap.addAttribute("roomlist",roomlist);
		
		return "index";
	}
	
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String chooseRoomView() {
        return "home";
    }
    
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String enterRoom(HttpSession session,@RequestParam("searchKey") String searchKey, ModelMap modelMap){
        
    	SearchKeyJudge scJudge=new SearchKeyJudge();
    	if(scJudge.isRoom(searchKey))
    	{   
    		return "redirect:/liveroom/"+searchKey;
    	}
    	else {
              List<LiveRoomDTO> roomlist=ilrs.searchByKey(searchKey);
              
              session.setAttribute("roomlist", roomlist);
              return "roomListPage";

    	}
    	
    		
    }
}