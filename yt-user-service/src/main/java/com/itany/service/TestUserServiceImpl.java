package com.itany.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itany.constant.Constant;
import com.itany.dao.UserMapper;
import com.itany.exception.SmsCodeException;
import com.itany.exception.UserAlreadyLoginException;
import com.itany.exception.UserNotFoundException;
import com.itany.exception.UserPasswordException;
import com.itany.pojo.User;
import com.itany.user.api.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
public class TestUserServiceImpl implements TestUserService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private StringRedisTemplate template;

    @Override
    @Transactional(readOnly = true)
    public User login(User user) throws UserNotFoundException, UserAlreadyLoginException {

        //判断用户是否登陆过
        JSONObject possibleUser =  JSON.parseObject(template.opsForValue().get("USER_TOKEN::" + user.getUsername()));
        if(null != possibleUser){
            //说明已经登录过
            System.out.println(possibleUser);
            throw new UserAlreadyLoginException("用户已经登录，请先退出后再登录！");
        }
        User returnUser = userMapper.login(user);
        if(null == returnUser){
            throw new UserNotFoundException("用户名或密码错误！");
        }

        return returnUser;
    }

    @Override
    public List<User> findUsers() {
        return userMapper.findUserAll();
    }

    @Override
    public void register(User user,String code) throws UserPasswordException, SmsCodeException {
        String redisCode = template.opsForValue().get("PHONE_CODE:"+user.getPhone());
        if(!code.trim().equals(redisCode.trim())){
            throw new SmsCodeException("短信验证码错误");
        }
        user.setFlag(Constant.DEFAULT_USER_FLAG_ENABLE);
        userMapper.insertUser(user);
    }
}
