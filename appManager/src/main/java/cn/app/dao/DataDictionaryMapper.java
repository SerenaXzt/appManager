package cn.app.dao;

import java.util.List;

import cn.app.pojo.DataDictionary;

public interface DataDictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    DataDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);
    
    List<DataDictionary> queryAllByType();
}