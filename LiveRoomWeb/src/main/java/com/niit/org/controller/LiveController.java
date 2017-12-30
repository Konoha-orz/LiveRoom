package com.niit.org.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.niit.org.bean.LiveRoom;
import com.niit.org.dto.LiveRoomDTO;
import com.niit.org.mapper.ILiveRoomService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LiveController {

	@Resource
	private ILiveRoomService ilrs;
	
    @RequestMapping(value = "/liveroom/{id}",method = RequestMethod.GET)
    public String index(@PathVariable("id") Integer roomId,HttpServletRequest request, ModelMap modelMap){
        
        HttpSession session = request.getSession();
        modelMap.addAttribute("roomId",roomId);
        LiveRoomDTO room = ilrs.queryRoomById(roomId).get(0);
    	return "liveroom";
    }
    
    @RequestMapping(value = "/isOnline",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> isOnline(@RequestParam("roomId")Integer roomId){
    	LiveRoomDTO room = ilrs.queryRoomById(roomId).get(0);
    	Map<String, Object> map = new HashMap<>();
    	if (room == null) {
    		map.put("code", 0);
    	} else {
    		map.put("code", 1);
    		map.put("room_info", room);
    	}
    	return map;
    }
}
