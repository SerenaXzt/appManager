package cn.appManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.app.vo.Msg;

@Controller
public class CategoryController {

	@RequestMapping(value="/categorys/{parentId}",method=RequestMethod.GET)
	public Msg showCategoryByParent(@PathVariable("parentId") Integer parentId){
		return null;
	}
	
}
