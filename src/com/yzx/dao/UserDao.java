package com.yzx.dao;

import com.yzx.model.user.User;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserDao extends SqlSessionDaoSupport implements Dao<User> {
    @Override
    public List<User> selectAll() {
        return getSqlSession().selectList("com.yzx.mapper.UserMapper.selectAll");
    }

    @Override
    public User selectById(@Param("uid") int uid){
        return getSqlSession().selectOne("com.yzx.mapper.UserMapper.selectByUid", uid);
    }

    public User userLogin(User user){
        return getSqlSession().selectOne("com.yzx.mapper.UserMapper.userLogin", user);
    }

    public List<User> selectAdminUser(@Param("s_id") int s_id){
        return getSqlSession().selectList("com.yzx.mapper.UserMapper.selectAdminUser", s_id);
    }

//    public Avatar selectAvatar(@Param("id") int id){
//        return getSqlSession().selectOne("com.yzx.mapper.UserMapper.selectAvatar", id);
//    }
}
