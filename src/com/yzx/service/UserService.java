package com.yzx.service;

import com.alibaba.fastjson.JSONObject;
import com.yzx.dao.RedisDao;
import com.yzx.dao.UserDao;
import com.yzx.model.user.User;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private List<User> users;
    private UserDao userDao;
    private User user;
    private List<User> nonAdminUser;
    private RedisDao redisDao;

    public RedisDao getRedisDao() {
        return redisDao;
    }

    public void setRedisDao(RedisDao redisDao) {
        this.redisDao = redisDao;
    }

    public List<User> getNonAdminUser() {
        return nonAdminUser;
    }

    public void setNonAdminUser(int s_id) {
        this.nonAdminUser = userDao.selectAdminUser(s_id);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser() {
        return user;
    }

    public List<User> getUsers() {
        return users;
    }

    private void setUsers() {
        this.users = userDao.selectAll();
    }

    private void setUser(int uid) {
        this.user = userDao.selectById(uid);
    }

    private void setUserByName(User user){
        String userJson = redisDao.get("user_" + user.getName());
        if (StringUtils.isEmpty(userJson)) {
            this.user = userDao.userLogin(user);
            if (this.user != null) {
                redisDao.set("user_" + this.user.getName(), JSONObject.toJSONString(this.user));
                redisDao.set("user_id_" + this.user.getId(), JSONObject.toJSONString(this.user));
            }
        }
        else {
            User realUser = JSONObject.parseObject(userJson, User.class);
            this.user = realUser.getPassword().equals(user.getPassword()) ? realUser : null;
        }
    }

    public Map<String, User> getUserMap(int uid) {
        Map<String, User> result = new HashMap<>();
        setUser(uid);
        result.put("user", user);
        return result;
    }

    public User getUserByName(User u){
        setUserByName(u);
        return this.user;
    }


//    public Avatar setAvatar(int id){
//
//    }


}
