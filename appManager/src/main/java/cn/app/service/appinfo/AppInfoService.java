package cn.app.service.appinfo;

import java.util.List;

import cn.app.pojo.AppInfo;
import cn.app.vo.AppCategoryVo;
import cn.app.vo.AppInfoVo;

public interface AppInfoService {

	//查询所有的app数据
	List<AppInfoVo> queryAll();
	
	List<AppCategoryVo> queryAllByParentId(Integer parentId);
}
