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
		//����service�����������û�ƥ��
		BackendUser bu = buService.login(userCode, userPassword);
		if(null != bu && bu.getUsertype() == 1){//��¼�ɹ�
			//����session
			session.setAttribute(Constants.USER_SESSION, bu);
			
			return "backPage";
		}else{
			//ҳ����ת��backLogin.jsp��������ʾ��Ϣ--ת��
			model.addAttribute("error", "用户名或者密码不正确！");
			return "forward:/backLogin.jsp";
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
		//����service�����������û�ƥ��
		BackendUser bu = buService.login(userCode, userPassword);
		if(null != bu && bu.getUsertype() == 2){//��¼�ɹ�
			//����session
			session.setAttribute(Constants.USER_SESSION, bu);
			
			return "devPage";
		}else{
			//ҳ����ת��devLogin.jsp��������ʾ��Ϣ--ת��
			model.addAttribute("error", "用户名或者密码不正确！");
			return "forward:/devLogin.jsp";
		}
	}
	
	@RequestMapping(value="/devLogin/logOut",method=RequestMethod.GET)
	@ResponseBody
	public Msg logOut(HttpSession session){
		session.removeAttribute(Constants.USER_SESSION);
		return Msg.success();
	}
	
}
