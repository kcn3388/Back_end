package com.suzumiya.controller;

import com.alibaba.fastjson.JSONObject;
import com.suzumiya.dao.RedisDao;
import com.suzumiya.model.user.Token;
import com.suzumiya.model.user.User;
import com.suzumiya.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class UserController {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    private RedisDao redisDao = (RedisDao) ac.getBean("redisDao");
    private UserService service = (UserService) ac.getBean("userService");

    private User getUser(String token) {
        redisDao.expire("token_" + token, 1800);
        return JSONObject.parseObject(redisDao.get("token_" + token), User.class);
    }


    @RequestMapping(value = "/api/user", method = {RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public ModelAndView getUserByUid(@RequestParam(value = "id") int id) {
        Map<String, User> map = service.getUserMap(id);
        return new ModelAndView(new MappingJackson2JsonView(), map);
    }


    @RequestMapping(value = "/api/user", method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin
    public ModelAndView userLogin(@RequestBody User user){
        String token = System.currentTimeMillis() + user.getName();
        Map<String, String> currentMap = new HashMap<>();
        Set<String> tokens = redisDao.keys("token_*");
        User tmp;
        for (String tok : tokens) {
            tmp = JSONObject.parseObject(redisDao.get(tok), User.class);
            if (tmp.getName().equals(user.getName()))
                redisDao.del(tok);
        }
        User u = service.getUserByName(user);
        if (u != null) {
            redisDao.set("token_" + token, JSONObject.toJSONString(u));
            redisDao.expire("token_" + token, 1800);
            currentMap.put("token", token);
        }
        else {
            currentMap.put("token", null);
        }

        return new ModelAndView(new MappingJackson2JsonView(), currentMap);
    }

    @RequestMapping(value = "/api/token", method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin
    public ModelAndView userLoginStatus(@RequestBody Token token){
        User user = getUser(token.getToken());
        Map<String, User> map = new HashMap<>();
        map.put("user", user);
        return new ModelAndView(new MappingJackson2JsonView(), map);
    }

    @RequestMapping(value = "/api/logout", method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin
    public String userLogout(@RequestBody Token token){
        String name = null;
        try {
            name = getUser(token.getToken()).getName();
            redisDao.del("token_" + token.getToken());
        }catch (Exception e){
            e.printStackTrace();
        }
        return name;
    }
}
