package cn.appManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.app.service.appinfo.AppInfoService;
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
	
	
	@RequestMapping(value="/appsInfo/showCategory/{parentId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg showCategory(@PathVariable Integer parentId){
		if(parentId != null && parentId>=0){
			List<AppCategoryVo> categoryList = appifs.queryAllByParentId(parentId);
			return Msg.success().addExtend("categoryList", categoryList);
		}
		return Msg.fail();
	}
	
}
