package cn.app.dao;

import java.util.List;

import cn.app.pojo.AppVersion;
import cn.app.vo.AppVersionVo;

public interface AppVersionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    void insertSelective(AppVersion record);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);
    
    List<AppVersionVo> selectById(Long id);
}