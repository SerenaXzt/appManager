package cn.app.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.app.dao.DevUserMapper;
import cn.app.pojo.DevUser;

public class DaoTest {

	
	@Test
	public void testDevUser(){
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		DevUserMapper mapper = (DevUserMapper) context.getBean("devUserMapper");
		DevUser user = mapper.selectByCodeAndPwd("test001", "123456");
		System.out.println(user.getDevcode()+"   "+user.getDevname());
		
		
		
		
	}
}
