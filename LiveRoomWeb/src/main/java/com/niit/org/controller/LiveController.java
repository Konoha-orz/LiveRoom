package com.niit.org.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LiveController {


    @RequestMapping(value = "/chooseRoomId",method = RequestMethod.POST)
    public String test(HttpServletRequest request,@RequestParam("roomId") String roomId, ModelMap modelMap){
        HttpSession session = request.getSession();
        session.setAttribute("roomId",roomId);
        modelMap.addAttribute("roomId",roomId);
        return "liveroom";
    }

    @RequestMapping(value = "/chooseRoom",method = RequestMethod.GET)
    public String chooseRoomView() {
        return "chooseRoom";
    }
    @RequestMapping(value = "/login1",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> processAddUser (HttpServletRequest request,@RequestBody Map<String,Object> params) {
        String username=params.get("username").toString();
        Map<String, String> map = new HashMap<>();
        HttpSession session = request.getSession();
        // session.invalidate() 是用来清空session会话的
        // 一般使用session.removeAttribute()
        if (username.length() > 0) {
            session.setAttribute("username",username);
            map.put("status", "success");
        } else {
            // 否则直接返回
            map.put("status", "error");
        }
        return map;
    }
    @RequestMapping(value = "/logout1")
    @ResponseBody
    public Map<String, String> logout(HttpSession httpSession, HttpServletResponse httpServletResponse) throws IOException {
        httpSession.removeAttribute("username");
        Map<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }
    @RequestMapping(value = "/liveroom",method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap){
        // 有session会获取当前的session,没有就会创建一个session
        HttpSession session = request.getSession();
        return "liveroom";
    }
}
