package cn.app.service.appinfo;

import java.util.List;

import cn.app.pojo.AppInfo;
import cn.app.vo.AppCategoryVo;
import cn.app.vo.AppInfoVo;

public interface AppInfoService {

	//鏌ヨ鎵�鏈夌殑app鏁版嵁
	List<AppInfoVo> queryAll();
	
	List<AppCategoryVo> queryAllByParentId(Integer parentId);
	
	public int addApp(AppInfo appInfo);
	
	public int deleteApp(Long addId);
	
	public int selectBySoftwarename(String softwareName);
	
	int deleteVersion(Long id);
}
