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
		//����service�����������û�ƥ��
		BackendUser bu = buService.login(userCode, userPassword);
		if(null != bu){//��¼�ɹ�
			//����session
			session.setAttribute(Constants.USER_SESSION, bu);
			
			return "backPage";
		}else{
			//ҳ����ת��backLogin.jsp��������ʾ��Ϣ--ת��
			model.addAttribute("error", "�û��������벻��ȷ");
			return "redirect:/backLogin.jsp";
		}
	}
}
