package com.niit.org.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.niit.org.bean.LiveRoom;
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
        // 鏈塻ession浼氳幏鍙栧綋鍓嶇殑session,娌℃湁灏变細鍒涘缓涓�涓猻ession
        HttpSession session = request.getSession();
        modelMap.addAttribute("roomId",roomId);
        LiveRoom room = ilrs.queryRoomById(roomId);
    	if (room == null) {
    		return "error";
    	} 
        return "liveroom";
    }
    
    @RequestMapping(value = "/isOnline",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> isOnline(@RequestParam("roomId")Integer roomId){
    	LiveRoom room = ilrs.queryRoomById(roomId);
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
