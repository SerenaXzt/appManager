package cn.app.dao;

import java.util.List;

import cn.app.criteria.CriteriaApp;
import cn.app.pojo.AppInfo;
import cn.app.vo.AppInfoVo;

public interface AppInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);
    
    List<AppInfoVo> selectAllApp(CriteriaApp capp);
}