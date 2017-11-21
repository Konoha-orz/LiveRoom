package com.niit.org.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.org.bean.Category;
import com.niit.org.bean.Liveroom;
import com.niit.org.mapper.ICategory;
import com.niit.org.mapper.ILiveroom;
import com.niit.org.mapper.IUser;


@Controller

@RequestMapping("/createLiveroom")
public class CreateLiveroomController {

	@Resource
	private ICategory icategory;
	
	@Resource
	private IUser iuser;
	
	@Resource
	private ILiveroom iliveroom;
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String createLiveroom(HttpServletRequest request,HttpSession session) {
		String username=session.getAttribute("username").toString();
		int userid =iuser.getUser(username).get(0).getId();
		String title=request.getParameter("title").toString();
		String dscp=request.getParameter("dscp").toString();
		String categoryname=request.getParameter("categoryname").toString();
		String rtmpurl=request.getParameter("rtmpurl").toString();
		int status=0;
		Liveroom liveroom = new Liveroom();
		liveroom.setUserid(userid);
		liveroom.setUsername(username);
		liveroom.setTitle(title);
		liveroom.setDscp(dscp);
		liveroom.setCategoryname(categoryname);
		liveroom.setRtmpurl(rtmpurl);
		liveroom.setStatus(status);
		iliveroom.createLiveroom(liveroom);
		return "myLiveroom";
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String liveroom(ModelMap map,HttpSession session) {
		
		String username=session.getAttribute("username").toString();
		int userid =iuser.getUser(username).get(0).getId();
		
		try {
			List<Liveroom> liveroomList=iliveroom.getLiveroomByUserid(userid);
			int status=liveroomList.get(0).getStatus();		
			return "myLiveroom";
		
		}catch(Exception e){
			List<Category> list =icategory.getAll();
			map.addAttribute("categoryList", list);
			return "createLiveroom";
		
		}
	}
	
	
	
}


