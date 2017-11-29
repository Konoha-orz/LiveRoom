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
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Resource CategoryService categoryService;
	
    @RequestMapping(value = "/all")
    @ResponseBody
    public List<Category> chooseRoomView() {
        return categoryService.getCategoryList();
    }
    

}