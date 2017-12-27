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

import com.niit.org.bean.Account;
import com.niit.org.bean.Category;
import com.niit.org.bean.LiveRoom;
import com.niit.org.bean.Role;
import com.niit.org.dto.LiveRoomDTO;
import com.niit.org.mapper.IAccountService;
import com.niit.org.mapper.ILiveRoomService;
import com.niit.org.mapper.IRoleService;
import com.niit.org.service.CategoryService;
import com.niit.org.service.LiveRoomService;
import com.niit.org.util.JschUtil;
import com.niit.org.util.SearchKeyJudgeUtil;

@Controller
public class IndexController {

	
	
	@Resource
	private IRoleService irs;
	
	@Resource
	private IAccountService iac;
	
	@Resource
	CategoryService categoryService;
	
	
	@Resource
	private LiveRoomService liveRoomService;
	
	@RequestMapping("/index")
	public String index(ModelMap resultMap,HttpSession session) {
		
	    HashMap<String,List<LiveRoomDTO>> roomMap=new HashMap<>();
		List<LiveRoomDTO> outsideList=liveRoomService.getListByType("户外直播",4);
		List<LiveRoomDTO> gameList=liveRoomService.getListByType("游戏",4);
		List<LiveRoomDTO> foodList=liveRoomService.getListByType("美食",4);
		List<LiveRoomDTO> hotList=liveRoomService.getHotList();
		roomMap.put("outsideList", outsideList);
		roomMap.put("gameList", gameList);
		roomMap.put("foodList", foodList);
		roomMap.put("hotList", hotList);
		session.setAttribute("roomMap", roomMap);
		List<Category> categoryList=categoryService.getCategoryList();
    	session.setAttribute("categoryList", categoryList);
		
		
		return "index";
	}
	
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String chooseRoomView() {
        return "home";
    }
    

}