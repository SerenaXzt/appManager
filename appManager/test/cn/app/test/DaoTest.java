package cn.app.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.app.dao.AppCategoryMapper;
import cn.app.dao.AppInfoMapper;
import cn.app.dao.DevUserMapper;
import cn.app.pojo.AppInfo;
import cn.app.pojo.DevUser;
import cn.app.vo.AppCategoryVo;
import cn.app.vo.AppInfoVo;

public class DaoTest {

	
	@Test
	public void testDevUser(){
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		DevUserMapper mapper = (DevUserMapper) context.getBean("devUserMapper");
		DevUser user = mapper.selectByCodeAndPwd("test001", "123456");
		System.out.println(user.getDevcode()+"   "+user.getDevname());
		
		
		
		
	}
	
	
	@Test
	public void testApp(){
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		AppCategoryMapper appCategoryMapper = (AppCategoryMapper) context.getBean("appCategoryMapper");
		AppInfoMapper appInfoMapper = (AppInfoMapper) context.getBean("appInfoMapper");
		
		List<AppCategoryVo> acvList = appCategoryMapper.selectAllCategoryVo();
		AppInfoVo.setCategoryMap(acvList);
		List<AppInfoVo> appInfoList = appInfoMapper.selectAllApp(null);
		for(AppInfoVo info : appInfoList){
			System.out.println(info);
		}
		
	}
}
