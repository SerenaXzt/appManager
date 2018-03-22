package cn.app.dao;

import java.util.List;

import cn.app.pojo.AppCategory;
import cn.app.vo.AppCategoryVo;

public interface AppCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);

    AppCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);
    
    List<AppCategoryVo> selectAllCategoryVo();
    
    List<AppCategoryVo> selectByParent(Integer parentId);
}