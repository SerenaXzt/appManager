package cn.app.service.version;

import java.util.List;

import cn.app.pojo.AppVersion;
import cn.app.vo.AppVersionVo;

public interface AppVersionService {
	List<AppVersionVo> selectVersionById(Long id);
	
	int addVersion(AppVersion appversion);
}
