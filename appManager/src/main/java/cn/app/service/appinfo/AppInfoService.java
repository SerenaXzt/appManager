package cn.app.service.appinfo;

import java.util.List;

import cn.app.criteria.CriteriaApp;
import cn.app.pojo.AppInfo;
import cn.app.vo.AppCategoryVo;
import cn.app.vo.AppInfoVo;

public interface AppInfoService {

	//根据条件查询app信息
	List<AppInfoVo> queryAll(CriteriaApp ca);
	
	List<AppCategoryVo> queryAllByParentId(Integer parentId);
	
	public int addApp(AppInfo appInfo);
	
	public int deleteApp(Long addId);
	
	public int selectBySoftwarename(String softwareName);
	
	int deleteVersion(Long id);
	
	public int modifyAppPutOrDown(Integer appId, Integer opt);
	
	public AppInfoVo queryById(Integer appId);
	
	public int updateApp(AppInfo appInfo);
	
}
