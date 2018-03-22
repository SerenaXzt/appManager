package cn.appManager.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.app.pojo.AppInfo;
import cn.app.pojo.DevUser;
import cn.app.service.appinfo.AppInfoService;
import cn.app.tools.Constants;
import cn.app.vo.AppCategoryVo;
import cn.app.vo.AppInfoVo;
import cn.app.vo.Msg;

@Controller
public class AppInfoController {

	@Autowired
	private AppInfoService appifs;

	@RequestMapping(value="/appsInfo",method=RequestMethod.GET)
	public String showAllApp(Model model){
		List<AppInfoVo> list  = appifs.queryAll();
		model.addAttribute("appInfoVoList", list);
		return "appList/devUserAppList";
	}
	
	@RequestMapping(value="/appAdd",method=RequestMethod.GET)
	public String gotoAddApp(){
		return "app_add";
	}
	
	@RequestMapping(value="/appAdd",method=RequestMethod.POST)
	public String gotoAddApp2(@Valid AppInfo appInfo,BindingResult bindingResult,
			HttpSession session) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("=======had errors=======");
			return "app_add";
		}
		
		System.out.println("add()================");
		
		DevUser devuser = (DevUser)session.getAttribute(Constants.USER_SESSION);
		appInfo.setCreationdate(new Date());
		appInfo.setCreatedby(devuser.getId());
		if(appifs.addApp(appInfo) > 0){
			return "redirect:/appsInfo";
		}else{
			return "app_add";
		}
	}
	
	
	@RequestMapping(value="/showCategory/{parentId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg showCategory(@PathVariable Integer parentId){
		if(parentId != null && parentId>=0){
			List<AppCategoryVo> categoryList = appifs.queryAllByParentId(parentId);
			return Msg.success().addExtend("categoryList", categoryList);
		}
		return Msg.fail();
	}
	
	@RequestMapping(value="/deleteApp",method=RequestMethod.GET)
	public String deleteApp() {
		return"/appsInfo";
	}
	
	@RequestMapping(value="/deleteApp",method=RequestMethod.POST)
	@ResponseBody
	public String deleteApp2(@Valid AppInfo appInfo,BindingResult bindingResult,
			HttpSession session) {
		if(bindingResult.hasErrors()) {
			System.out.println("=======had errors=======");
			
			return "/appsInfo";
		}
		return"/appsInfo";
	}
	
<<<<<<< HEAD
}
=======
}
>>>>>>> branch 'master' of https://github.com/SerenaXzt/appManager.git
