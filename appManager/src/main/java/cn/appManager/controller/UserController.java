package cn.appManager.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.app.pojo.AppInfo;
import cn.app.pojo.BackendUser;
import cn.app.pojo.DevUser;
import cn.app.service.user.BackUserService;
import cn.app.tools.Constants;
import cn.app.vo.AppInfoVo;
import cn.app.vo.Msg;
import cn.app.vo.UserInfoVo;
import cn.app.vo.UserVo;

@Controller
public class UserController {
	@Autowired
	private BackUserService buservice;
	
	@RequestMapping(value="/userManager",method=RequestMethod.GET)
	public String showUser(Model model) {
		System.out.println("userManager============");
		List<UserVo> list = buservice.queryAll();
		if(list != null) {
			model.addAttribute("allUser", list);
			return "user/user_manager";
		}
		return "error";
	}
	
	@RequestMapping(value="userInfo/{userId}",method=RequestMethod.GET)
	public String userInfo(@PathVariable("userId") Long id,Model model) {
		UserInfoVo userInfo = buservice.selectById(id);
		if(userInfo != null) {
			model.addAttribute("userInfo", userInfo);
			return "user/userInfo";
		}
		return "error";
	}
	
	@RequestMapping(value="/userModify",method=RequestMethod.POST)
	public String userModify(Model model,
			@Valid BackendUser user,HttpSession session) {
		System.out.println("modify===========");
		BackendUser buser = (BackendUser) session.getAttribute(Constants.USER_SESSION);
		user.setModifydate(new Date());
		user.setModifyby(buser.getUsertype());
		if(buservice.modifyUser(user) > 0) {
			return "redirect:/userManager";
		}
		return "error";
	}
	
	@RequestMapping(value="/userModify/{userId}",method=RequestMethod.GET)
	public String userModify2(@PathVariable("userId") Long id,Model model) {
		System.out.println("userModify============");
		UserInfoVo uservo = buservice.selectById(id);
		if(uservo != null) {
			model.addAttribute("userInfo", uservo);
		}
		
		return "user/user_modify";
	}

	@RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg deleteUser(@PathVariable("userId") Long userId) {
		System.out.println("delete===========");
		if(buservice.deleteUser(userId) > 0) {
			return Msg.success();
		}
		return Msg.fail();
	}
}
