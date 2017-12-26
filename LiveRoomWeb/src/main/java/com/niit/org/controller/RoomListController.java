package com.niit.org.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.org.bean.Category;
import com.niit.org.dto.LiveRoomDTO;
import com.niit.org.service.CategoryService;
import com.niit.org.service.LiveRoomService;
import com.niit.org.util.SearchKeyJudgeUtil;


@Controller
@RequestMapping("/roomlist")
public class RoomListController {

	@Resource
	LiveRoomService liveRoomService;
	
	@Resource
	CategoryService categoryService;
	
	
	
	
	@RequestMapping(value = "/all")
    public String showAll(HttpSession session) {
    	List<LiveRoomDTO> roomList=liveRoomService.queryAllLiveRoom();
    	List<Category> categoryList=categoryService.getCategoryList();
    	session.setAttribute("categoryList", categoryList);
    	session.setAttribute("roomList", roomList);
		return "roomListPage";
    }
	
	
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String searchRoomByKey(HttpSession session,@RequestParam("searchKey") String searchKey, ModelMap modelMap){
    	List<LiveRoomDTO> roomList;
    	List<Category> categoryList=categoryService.getCategoryList();
    	session.setAttribute("categoryList", categoryList);
    	
    	if(SearchKeyJudgeUtil.isRoom(searchKey))
    	{   roomList=liveRoomService.queryRoomById(Integer.valueOf(searchKey));
    	    session.setAttribute("roomList", roomList);
    		return "roomListPage";
    	}
    	else {
              roomList=liveRoomService.searchByKey(searchKey);
              session.setAttribute("roomList", roomList);
              return "roomListPage";

    	}    	    		
    }
    
    
    @RequestMapping(value = "/category/{categoryname}")
    public String searchRoomByCategory(HttpSession session,@PathVariable("categoryname") String categoryName, ModelMap modelMap){
    	List<Category> categoryList=categoryService.getCategoryList();
    	session.setAttribute("categoryList", categoryList);
    	List<LiveRoomDTO> roomList;
    	roomList=liveRoomService.getListByType(categoryName);
    	session.setAttribute("roomList", roomList);
 		return "roomListPage";
    }
    
    
}
