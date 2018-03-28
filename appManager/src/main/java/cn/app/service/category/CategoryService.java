package cn.app.service.category;

import java.util.List;

import cn.app.vo.AppCategoryVo;

public interface CategoryService {

	List<AppCategoryVo> queryByParent(Integer parentId);
	
	List<AppCategoryVo> queryAllCategory();
}
