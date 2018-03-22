package cn.app.service.appinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.app.dao.AppCategoryMapper;
import cn.app.dao.AppInfoMapper;
import cn.app.pojo.AppInfo;
import cn.app.vo.AppCategoryVo;
import cn.app.vo.AppInfoVo;

@Service
public class AppInfoServiceImpl implements AppInfoService {

	@Autowired
	private AppInfoMapper appInfoMapper;
	
	@Autowired
	private AppCategoryMapper appCategoryMapper;
	
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

}
