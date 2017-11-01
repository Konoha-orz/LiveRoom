package com.niit.org.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LiveController {


    @RequestMapping(value = "/liveroom",method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap){
        // 有session会获取当前的session,没有就会创建一个session
        HttpSession session = request.getSession();
        return "liveroom";
    }
    
    @RequestMapping(value = "/liveroom_test",method = RequestMethod.GET)
    public String index1(HttpServletRequest request, ModelMap modelMap){
        return "liveroom1";
    }
}
