package com.niit.org.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.org.dto.LiveRoomDTO;
import com.niit.org.service.LiveRoomService;
import com.niit.org.util.SearchKeyJudgeUtil;


@Controller
@RequestMapping("/roomlist")
public class RoomListController {

	@Resource
	LiveRoomService liveRoomService;
	
	
	@RequestMapping(value = "/all")
    public String showAll(HttpSession session) {
    	List<LiveRoomDTO> roomList=liveRoomService.queryAllLiveRoom();
    	session.setAttribute("roomList", roomList);
		return "roomListPage";
    }
	
	
    @RequestMapping(value = "/roomid",method = RequestMethod.POST)
    public String enterRoom(HttpSession session,@RequestParam("searchKey") String searchKey, ModelMap modelMap){
    	List<LiveRoomDTO> roomList;
    	
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
}
