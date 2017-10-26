package com.niit.org.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.org.bean.Account;
import com.niit.org.bean.Role;
import com.niit.org.mapper.IAccountService;
import com.niit.org.mapper.IRoleService;
import com.niit.org.service.IAccount;
import com.niit.org.util.JschUtil;

@Controller
public class IndexController {

	@Resource
	private IAccount accountService;
	
	@Resource
	private IRoleService irs;
	
	@Resource
	private IAccountService iac;
	
	@RequestMapping("/index")
	public String index(ModelMap resultMap) {
		
		
		//姝ゅ閫氳繃SSH澶栭儴璁块棶杩滅▼mysql鏈嶅姟鍣ㄩ渶瑕佺敤鍒癑SCH,鏈嶅姟鍣ㄧ涓婁笉闇�瑕�
		JschUtil sshutil=new JschUtil();
		
		//*************SSH绔彛杞帴寮�鍚�
		sshutil.open();
		
		List<Account> accountList = iac.getAll();//accountService.getCount();
            
		List<Role> roleList=irs.getAll();
		
		
		//**************SSH绔彛杞帴鍏抽棴
				sshutil.close();
				
		resultMap.addAttribute("account",accountList.get(2));
		resultMap.addAttribute("rolelist",roleList);
		resultMap.addAttribute("role1",roleList.get(0));
		return "index";
	}
	// 涓婚〉鏆傛椂鐢ㄨ緭鍏ユ埧闂村彿鏉ヨ繘鍏ュ叿浣撶殑鐩存挱闂�
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String chooseRoomView() {
        return "home";
    }
    // 杩涘叆鍏蜂綋鐨勬埧闂�
    @RequestMapping(value = "/chooseRoomId",method = RequestMethod.POST)
    public String enterRoom(HttpSession session,@RequestParam("roomId") String roomId, ModelMap modelMap){
        session.setAttribute("roomId",roomId);
        modelMap.addAttribute("roomId",roomId);
        return "redirect:/liveroom";
    }
}