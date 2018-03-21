package cn.app.dao;

import org.apache.ibatis.annotations.Param;

import cn.app.pojo.DevUser;

public interface DevUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);
    
    //根据用户名查询用户信息
    DevUser selectByCodeAndPwd(@Param("devCode")String devCode, @Param("password")String password);
}