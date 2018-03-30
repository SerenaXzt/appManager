package cn.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import cn.app.pojo.BackendUser;
import cn.app.vo.UserInfoVo;
import cn.app.vo.UserVo;

public interface BackendUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    BackendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);
    
    BackendUser selectByCodeAndPwd(@Param("userCode")String userCode, @Param("userPassword")String userPassword);
    
    List<UserVo> selectAllUser();
    
    UserInfoVo selectById(Long id);
}