package com.niit.org.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.org.bean.LiveRoom;
import com.niit.org.bean.Role;
import com.niit.org.dto.LiveRoomDTO;
import com.niit.org.mapper.IAccountService;
import com.niit.org.mapper.ILiveRoomService;
import com.niit.org.mapper.IRoleService;

import com.niit.org.service.LiveRoomService;
import com.niit.org.util.JschUtil;
import com.niit.org.util.SearchKeyJudge;

@Controller
public class IndexController {

	
	
	@Resource
	private IRoleService irs;
	
	@Resource
	private IAccountService iac;
	
	
	
	@Resource
	private LiveRoomService lrs;
	
	@RequestMapping("/index")
	public String index(ModelMap resultMap,HttpSession session) {
		
	    HashMap<String,List<LiveRoomDTO>> roomMap=new HashMap<>();
		List<LiveRoomDTO> outsideList=lrs.getListByType("户外直播");
		List<LiveRoomDTO> gameList=lrs.getListByType("游戏");
		List<LiveRoomDTO> foodList=lrs.getListByType("美食");
		roomMap.put("outsideList", outsideList);
		roomMap.put("gameList", gameList);
		roomMap.put("foodList", foodList);
		session.setAttribute("roomMap", roomMap);
		
		
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
              List<LiveRoomDTO> roomlist=lrs.searchByKey(searchKey);
              
              session.setAttribute("roomlist", roomlist);
              return "roomListPage";

    	}
    	
    		
    }
}