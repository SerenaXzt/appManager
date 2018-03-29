package cn.app.service.version;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.app.dao.AppInfoMapper;
import cn.app.dao.AppVersionMapper;
import cn.app.pojo.AppInfo;
import cn.app.pojo.AppVersion;
import cn.app.vo.AppVersionVo;
@Service
@Transactional
public class AppVersionServiceImpl implements AppVersionService {
	
	@Autowired
	private AppVersionMapper appvm;
	@Autowired
	private AppInfoMapper appInfoMapper;
	
	@Override
	public List<AppVersionVo> selectVersionById(Long id) {
		
		return appvm.selectById(id);
	}

	@Override
	public int addVersion(AppVersion appversion) {
		appvm.insertSelective(appversion);
		AppInfo appInfo = new AppInfo();
		appInfo.setVersionid(appversion.getId());
		appInfo.setId(appversion.getAppid());
		int flag = appInfoMapper.updateByPrimaryKeySelective(appInfo);
		return flag;
	}
	
}
