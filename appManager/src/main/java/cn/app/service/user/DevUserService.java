package cn.app.service.user;

//import java.util.List;

import cn.app.pojo.DevUser;

public interface DevUserService {
	/**
	 * 用户登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public DevUser login(String userCode,String userPassword);
	
	/**
	 * 根据条件查询用户列表
	 * @param queryUserName
	 * @param queryUserRole
	 * @return
	 */
}
