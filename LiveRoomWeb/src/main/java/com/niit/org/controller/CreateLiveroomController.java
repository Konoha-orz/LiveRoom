package com.niit.org.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		String rtmpurl="rtmp://120.78.81.233/live";
		String seriescode=String.valueOf(userid);
		int status=0;
		Liveroom liveroom = new Liveroom();
		liveroom.setUserid(userid);
		liveroom.setTitle(title);
		liveroom.setDscp(dscp);
		liveroom.setCategoryname(categoryname);
		liveroom.setRtmpurl(rtmpurl);
		liveroom.setStatus(status);
		liveroom.setSeriescode(seriescode);
		iliveroom.createLiveroom(liveroom);
		return "redirect:/myLiveroom";
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String liveroom(ModelMap map,HttpSession session) {
		
		String username=session.getAttribute("username").toString();
		int userid =iuser.getUser(username).get(0).getId();
		
		try {
			List<Liveroom> liveroomList=iliveroom.getLiveroomByUserid(userid);
			int status=liveroomList.get(0).getStatus();		
			return "redirect:/myLiveroom";
		
		}catch(Exception e){
			List<Category> list =icategory.getAll();
			map.addAttribute("categoryList", list);
			return "createLiveroom";
		
		}
	}	
}

@Controller
@RequestMapping("/myLiveroom")
class MyLiveroomController {
	
	int userid;
	
	@Resource
	private ILiveroom iliveroom;
	@Resource
	private IUser iuser;
	@Resource
	private ICategory icategory;
	
	@RequestMapping(method=RequestMethod.GET)
	public String myLiveroom(HttpSession session,ModelMap map) {
		String username = session.getAttribute("username").toString();
		this.userid = iuser.getUser(username).get(0).getId();
		String title=iliveroom.getLiveroomByUserid(userid).get(0).getTitle();
		String dscp=iliveroom.getLiveroomByUserid(userid).get(0).getDscp();
		String categoryname=iliveroom.getLiveroomByUserid(userid).get(0).getCategoryname();
		String rtmpurl = iliveroom.getLiveroomByUserid(userid).get(0).getRtmpurl();
		String seriescode = iliveroom.getLiveroomByUserid(userid).get(0).getSeriescode();
		int status= iliveroom.getLiveroomByUserid(userid).get(0).getStatus();
		List<Category> list =icategory.getAll();
		map.addAttribute("categoryList", list);
		map.addAttribute("title", title);
		map.addAttribute("dscp", dscp);
		session.setAttribute("categoryname", categoryname);
		session.setAttribute("status", status);
		map.addAttribute("rtmpurl", rtmpurl);
		map.addAttribute("seriescode", seriescode);
		return "myLiveroom";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String myLiveroom(HttpServletRequest request,ModelMap map,HttpSession session) {
		String title = request.getParameter("title");
		String dscp = request.getParameter("dscp");
		String categoryname=request.getParameter("categoryname");
		String rtmpurl=request.getParameter("rtmpurl");
		String seriescode=request.getParameter("seriescode");
		Liveroom liveroom = new Liveroom();
		liveroom.setUserid(userid);
		liveroom.setTitle(title);
		liveroom.setDscp(dscp);
		liveroom.setCategoryname(categoryname);
		liveroom.setRtmpurl(rtmpurl);
		liveroom.setSeriescode(seriescode);
		iliveroom.updateLiveroom(liveroom);
		return "redirect:/myLiveroom";
	}
	
	@ResponseBody
	@RequestMapping("/changestatus")
	public String changestatus() {
		String flag="open";
		try {
		int status = iliveroom.getLiveroomByUserid(userid).get(0).getStatus();
		if(status == 1) {
			iliveroom.closeLiveroom(userid);
			flag="close";
		}else {
			iliveroom.openLiveroom(userid);
		}
		}catch(Exception e) {
			flag="error";
		}
		return flag;
	}
}

