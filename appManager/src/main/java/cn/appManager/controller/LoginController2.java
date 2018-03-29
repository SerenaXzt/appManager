package cn.appManager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.app.pojo.BackendUser;
import cn.app.pojo.DevUser;
import cn.app.service.user.BackUserService;
import cn.app.service.user.DevUserService;
import cn.app.tools.Constants;
import cn.app.vo.Msg;


@Controller
public class LoginController2 {
	@Autowired
	private BackUserService buService;
	

	public void setUserService(BackUserService buService) {
		this.buService = buService;
	}

	@RequestMapping(value="/backLogin",method=RequestMethod.GET)
	public String login(@RequestParam("userCode")String userCode,
			@RequestParam("userPassword")String userPassword,
			HttpSession session,
			Model model) {
		return "backPage";
	}
	
	@RequestMapping(value="/backLogin",method=RequestMethod.POST)
	public String login2(@RequestParam("userCode")String userCode,
			@RequestParam("userPassword")String userPassword,
			HttpSession session,
			Model model) {
		System.out.println("login ============ " );
		//µ÷ÓÃservice·½·¨£¬½øÐÐÓÃ»§Æ¥Åä
		BackendUser bu = buService.login(userCode, userPassword);
		if(null != bu && bu.getUsertype() == 1){//µÇÂ¼³É¹¦
			//·ÅÈësession
			session.setAttribute(Constants.USER_SESSION, bu);
			
			return "backPage";
		}else{
			//Ò³ÃæÌø×ª£¨backLogin.jsp£©´ø³öÌáÊ¾ÐÅÏ¢--×ª·¢
			model.addAttribute("error", "ÓÃ»§Ãû»òÃÜÂë²»ÕýÈ·");
			return "redirect:/backLogin.jsp";
		}
	}
	
	@RequestMapping(value="/devLogin",method=RequestMethod.GET)
	public String login1(@RequestParam("userCode")String userCode,
			@RequestParam("userPassword")String userPassword,
			HttpSession session,
			Model model) {
		return "devPage";
	}
	
	@RequestMapping(value="/devLogin",method=RequestMethod.POST)
	public String login3(@RequestParam("userCode")String userCode,
			@RequestParam("userPassword")String userPassword,
			HttpSession session,
			Model model) {
		System.out.println("login ============ " );
		//ï¿½ï¿½ï¿½ï¿½serviceï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ã»ï¿½Æ¥ï¿½ï¿½
		BackendUser bu = buService.login(userCode, userPassword);
		if(null != bu && bu.getUsertype() == 2){//ï¿½ï¿½Â¼ï¿½É¹ï¿½
			//ï¿½ï¿½ï¿½ï¿½session
			session.setAttribute(Constants.USER_SESSION, bu);
			
			return "devPage";
		}else{
			//Ò³ï¿½ï¿½ï¿½ï¿½×ªï¿½ï¿½devLogin.jspï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ê¾ï¿½ï¿½Ï¢--×ªï¿½ï¿½
			model.addAttribute("error", "ï¿½Ã»ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ë²»ï¿½ï¿½È·");
			return "redirect:/devLogin.jsp";
		}
	}
	
	@RequestMapping(value="/devLogin/logOut",method=RequestMethod.GET)
	@ResponseBody
	public Msg logOut(HttpSession session){
		session.removeAttribute(Constants.USER_SESSION);
		return Msg.success();
	}
}
