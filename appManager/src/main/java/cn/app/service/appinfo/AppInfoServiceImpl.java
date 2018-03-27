package cn.app.service.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.app.dao.AppCategoryMapper;
import cn.app.dao.AppInfoMapper;
import cn.app.dao.AppVersionMapper;
import cn.app.pojo.AppInfo;
import cn.app.vo.AppCategoryVo;
import cn.app.vo.AppInfoVo;

@Service
public class AppInfoServiceImpl implements AppInfoService {

	@Autowired
	private AppInfoMapper appInfoMapper;
	
	@Autowired
	private AppCategoryMapper appCategoryMapper;
	
	@Autowired
	private AppVersionMapper appVersionMapper;
	
	@Autowired
	AppInfo appInfo;
	
	@Override
	public List<AppInfoVo> queryAll() {
		List<AppCategoryVo> acvList = appCategoryMapper.selectAllCategoryVo();
		AppInfoVo.setCategoryMap(acvList);
		List<AppInfoVo> appInfoList = appInfoMapper.selectAllApp(null);
		return appInfoList;
	}

	@Override
	public List<AppCategoryVo> queryAllByParentId(Integer parentId) {
		
		return appCategoryMapper.selectByParent(parentId);
	}

	@Override
	public int addApp(AppInfo app) {
		int flag = 0;
		try {
			flag = appInfoMapper.insert(app);
			if(flag > 0){
				System.out.println("add success!");
			}else{
				System.out.println("add failed!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	@Override
	public int deleteApp(Long appId) {
		int flag = 0;
		try {
			flag = appInfoMapper.deleteByPrimaryKey(appId);
			if(flag > 0){
				System.out.println("app delete success!");
			}else{
				System.out.println("app delete failed!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public int selectBySoftwarename(String softwareName) {
		int flag = 0;
		try {
			flag = appInfoMapper.selectBySoftwarename(softwareName);
			if(flag > 0){
				System.out.println("app已存在========");
			}else{
				System.out.println("app可以添加========");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public int deleteVersion(Long id) {
		int flag = 0;
		try {
			flag = appVersionMapper.deleteByPrimaryKey(id);
			if(flag > 0){
				System.out.println("version delete success!");
			}else{
				System.out.println("version delete failed!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public AppInfo getAppById(Long id) {
		try {
			appInfo = appInfoMapper.selectByPrimaryKey(id);
			if(appInfo == null) {
				System.out.println("no app match found!");
			}else {
				System.out.println("pulling appInfo success!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appInfo;
	}

}
