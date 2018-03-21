package cn.app.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.app.dao.BackendUserMapper;
import cn.app.pojo.BackendUser;


@Service
public class BackUserServiceImpl implements BackUserService {
	@Autowired
	private BackendUserMapper bumapper;
	
	public void setUserMapper(BackendUserMapper bumapper) {
		this.bumapper = bumapper;
	}

	@Override
	public BackendUser login(String userCode, String userPassword) {
		BackendUser bu = null;
		try {
			bu = bumapper.selectByCodeAndPwd(userCode, userPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//∆•≈‰√‹¬Î
		
		return bu;
	}
}
