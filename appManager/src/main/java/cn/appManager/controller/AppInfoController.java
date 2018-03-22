package cn.appManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.app.service.appinfo.AppInfoService;
import cn.app.vo.AppCategoryVo;
import cn.app.vo.AppInfoVo;

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
	
}
