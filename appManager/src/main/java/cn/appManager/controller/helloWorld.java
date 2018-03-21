package cn.appManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.app.dao.AppMapper;
import cn.app.pojo.App;

@Controller
public class helloWorld {
	
	@Autowired
	private AppMapper appMapper;
	
	@RequestMapping("/appInfo")
	public String show(Model model) {
//		App app = appMapper.selectOne(48);
//		System.out.println(app);
//		model.addAttribute("app", app);
		return "backPage";
	}
}
