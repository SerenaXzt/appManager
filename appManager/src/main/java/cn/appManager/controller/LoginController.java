package cn.appManager.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.app.pojo.DevUser;
import cn.app.service.user.DevUserService;
import cn.app.tools.Constants;
import cn.app.vo.Msg;


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
		//����service�����������û�ƥ��
		DevUser du = devuserService.login(userCode, userPassword);
		if(null != du){//��¼�ɹ�
			//����session
			session.setAttribute(Constants.USER_SESSION, du);
			
			return "devPage";
		}else{
			//ҳ����ת��devLogin.jsp��������ʾ��Ϣ--ת��
			model.addAttribute("error", "�û��������벻��ȷ");
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
