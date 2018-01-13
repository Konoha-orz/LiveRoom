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
import com.niit.org.bean.LiveRoom;
import com.niit.org.mapper.ICategory;
import com.niit.org.mapper.ILiveRoomService;

import com.niit.org.mapper.IUser;


@Controller

@RequestMapping("/createLiveroom")
public class CreateLiveroomController {

	@Resource
	private ICategory icategory;
	
	@Resource
	private IUser iuser;
	
	@Resource
	private ILiveRoomService iliveroom;
	
	
	
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
		LiveRoom liveroom = new LiveRoom();
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
			List<LiveRoom> liveroomList=iliveroom.getLiveroomByUserid(userid);
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
	private  ILiveRoomService iliveroom;
	@Resource
	private IUser iuser;
	@Resource
	private ICategory icategory;
	
	@RequestMapping(method=RequestMethod.GET)
	public String myLiveroom(HttpSession session,ModelMap map) {
		String username = session.getAttribute("username").toString();
		this.userid = iuser.getUser(username).get(0).getId();
		LiveRoom liveRoom=iliveroom.getLiveroomByUserid(userid).get(0);
		List<Category> list =icategory.getAll();
		map.addAttribute("categoryList", list);
		map.addAttribute("liveRoom",liveRoom);
		return "myLiveroom";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String myLiveroom(HttpServletRequest request,ModelMap map,HttpSession session) {
		String title = request.getParameter("title");
		String dscp = request.getParameter("dscp");
		String categoryname=request.getParameter("categoryname");
		String rtmpurl=request.getParameter("rtmpurl");
		String seriescode=request.getParameter("seriescode");
		LiveRoom liveroom = new LiveRoom();
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

