package com.niit.org.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.org.bean.Liveroom;
import com.niit.org.bean.Subscription;
import com.niit.org.mapper.ILiveroom;
import com.niit.org.mapper.ISubscription;
import com.niit.org.mapper.IUser;


@Controller
@RequestMapping("mySub")
public class MySubController {
	
	@Resource
	private IUser iuser;
	
	@Resource
	private ISubscription isub;
	
	@Resource
	private ILiveroom iliveroom;

	@RequestMapping()
	public String mySub(HttpSession session,ModelMap map) {
		String username=session.getAttribute("username").toString();
		int userid =iuser.getUser(username).get(0).getId();
		List<Subscription> list=isub.getSubLiveroomId(userid);
		List<Liveroom> list2= new ArrayList<Liveroom>();
		for(int i =0;i<list.size();i++) {
//			System.out.println(iuser.getUserById(list.get(i).getUserid()).get(0).getUsername()+","+iliveroom.getLiveroom(list.get(i).getLiveroomid()).get(0).getTitle()+","+iliveroom.getLiveroom(list.get(i).getLiveroomid()).get(0).getCategoryname()+","+iliveroom.getLiveroom(list.get(i).getLiveroomid()).get(0).getDesc()+","+iliveroom.getLiveroom(list.get(i).getLiveroomid()).get(0).getStatus());
			list2.add(iliveroom.getLiveroom(list.get(i).getLiveroomid()).get(0));
		}
		
/*		for(int i=0;i<list2.size();i++) {
			System.out.println((i+1)+","+list2.get(i).getTitle()+","+list2.get(i).getCategoryname()+","+list2.get(i).getStatus());
		}*/
		map.addAttribute("SubLiveroomList", list2);	
		return "mySub";
	}
	
}
