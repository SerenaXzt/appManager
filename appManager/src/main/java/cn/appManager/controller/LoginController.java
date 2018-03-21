package cn.appManager.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.pojo.DevUser;
import cn.app.service.user.DevUserService;
import cn.app.tools.Constants;


@Controller
public class LoginController {
	@Resource
	private DevUserService devuserService;
	

	public void setUserService(DevUserService devuserService) {
		this.devuserService = devuserService;
	}

	@RequestMapping(value="/devLogin",method=RequestMethod.GET)
	public String login() {
		return "devPage";
	}
	
	@RequestMapping(value="/devLogin",method=RequestMethod.POST)
	public String login2(@RequestParam("userCode")String userCode,
			@RequestParam("userPassword")String userPassword,
			HttpSession session,
			Model model) {
		System.out.println("login ============ " );
		//调用service方法，进行用户匹配
		DevUser du = devuserService.login(userCode, userPassword);
		if(null != du){//登录成功
			//放入session
			session.setAttribute(Constants.USER_SESSION, du);
			
			return "devPage";
		}else{
			//页面跳转（devLogin.jsp）带出提示信息--转发
			model.addAttribute("error", "用户名或密码不正确");
			return "redirect:/devLogin.jsp";
		}
	}
}
