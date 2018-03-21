package cn.app.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.app.dao.DevUserMapper;
import cn.app.pojo.DevUser;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 * @author Administrator
 *
 */
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService{
	@Autowired
	private DevUserMapper devuserMapper;
	
	public void setUserMapper(DevUserMapper devuserMapper) {
		this.devuserMapper = devuserMapper;
	}

	@Override
	public DevUser login(String devCode, String password) {
		DevUser devuser = null;
		try {
			devuser = devuserMapper.selectByCodeAndPwd(devCode, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//匹配密码
		
		return devuser;
	}
}
