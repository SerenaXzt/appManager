package cn.appManager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.pojo.BackendUser;
import cn.app.service.user.BackUserService;
import cn.app.tools.Constants;


@Controller
public class LoginController2 {
	@Autowired
	private BackUserService buService;
	

	public void setUserService(BackUserService buService) {
		this.buService = buService;
	}

	@RequestMapping(value="/backLogin",method=RequestMethod.GET)
	public String login() {
		return "backPage";
	}
	
	@RequestMapping(value="/backLogin",method=RequestMethod.POST)
	public String login2(@RequestParam("userCode")String userCode,
			@RequestParam("userPassword")String userPassword,
			HttpSession session,
			Model model) {
		System.out.println("login ============ " );
		//调用service方法，进行用户匹配
		BackendUser bu = buService.login(userCode, userPassword);
		if(null != bu){//登录成功
			//放入session
			session.setAttribute(Constants.USER_SESSION, bu);
			
			return "backPage";
		}else{
			//页面跳转（backLogin.jsp）带出提示信息--转发
			model.addAttribute("error", "用户名或密码不正确");
			return "redirect:/backLogin.jsp";
		}
	}
}
