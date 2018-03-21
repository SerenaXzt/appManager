package cn.app.dao;

import org.apache.ibatis.annotations.Param;

import cn.app.pojo.BackendUser;

public interface BackendUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    BackendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);
    
    BackendUser selectByCodeAndPwd(@Param("userCode")String userCode, @Param("userPassword")String userPassword);
}