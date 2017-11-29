package com.niit.org.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.niit.org.bean.LiveRoom;
import com.niit.org.mapper.ILiveRoomService;
import com.niit.org.util.ThumbNailUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LiveController {



	@Resource
	private ILiveRoomService ilrs;
	
    @RequestMapping(value = "/liveroom/{id}",method = RequestMethod.GET)
    public String index(@PathVariable("id") Integer roomId,HttpServletRequest request, ModelMap modelMap){

        LiveRoom room = ilrs.queryRoomById(roomId);
        modelMap.addAttribute("room_info",room);
        // 进入直播间有两种方式（检索进入，url输入进入），判断房间是否存在
        if (room == null) {
        	return "404";
        }
        return "liveroom";
    }
    // 主播是否在线
    @RequestMapping(value = "/isOnline",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> isOnline(@RequestParam("roomId")Integer roomId){
        LiveRoom room = ilrs.queryRoomById(roomId);
    	Map<String, Object> map = new HashMap<>();
    	if (room == null) {
    		map.put("code", 0);
    	} else {
    		map.put("code", 1);
    		map.put("room_status", room.getStatus());
    	}
    	return map;
    }
}
