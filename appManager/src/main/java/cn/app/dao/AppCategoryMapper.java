package cn.app.dao;

import cn.app.pojo.AppCategory;

public interface AppCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);

    AppCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);
}