package cn.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
    
    int selectBySoftwarename(String softwareName);
    
    int updateByPutOrDown(@Param("appId")Integer appId,@Param("opt")Integer opt);

    AppInfoVo selectById(Integer appId);
    
}