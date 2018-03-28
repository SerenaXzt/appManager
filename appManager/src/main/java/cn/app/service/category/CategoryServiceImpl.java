package cn.app.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.app.dao.AppCategoryMapper;
import cn.app.vo.AppCategoryVo;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private AppCategoryMapper appCategoryMapper;
	
	@Override
	public List<AppCategoryVo> queryByParent(Integer parentId) {
		
		return null;
	}

	@Override
	public List<AppCategoryVo> queryAllCategory() {
		
		return appCategoryMapper.selectAllCategoryVo();
	}

	
}
