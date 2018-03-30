package cn.app.service.user;

import java.util.List;

import cn.app.pojo.BackendUser;
import cn.app.vo.UserInfoVo;
import cn.app.vo.UserVo;



public interface BackUserService {
	/**
	 * 用户登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public BackendUser login(String userCode,String userPassword);
	
	/**
	 * 根据条件查询用户列表
	 * @param queryUserName
	 * @param queryUserRole
	 * @return
	 */
	List<UserVo> queryAll();
	
	UserInfoVo selectById(Long id);
	
	int addUser(BackendUser user);
	
	int modifyUser(BackendUser user);
	
	int deleteUser(Long id);
}
