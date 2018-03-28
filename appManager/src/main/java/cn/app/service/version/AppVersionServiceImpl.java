package cn.app.service.version;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.app.dao.AppVersionMapper;
import cn.app.pojo.AppVersion;
import cn.app.vo.AppVersionVo;
@Service
public class AppVersionServiceImpl implements AppVersionService {
	
	@Autowired
	private AppVersionMapper appvm;
	
	@Override
	public List<AppVersionVo> selectVersionById(Long id) {
		
		return appvm.selectById(id);
	}

	@Override
	public int addVersion(AppVersion appversion) {
		int flag = appvm.insert(appversion);
		if(flag > 0) {
			System.out.println("version added");
		}
		return flag;
	}
	
}
