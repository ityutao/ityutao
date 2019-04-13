package com.itany.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itany.exception.SmsCodeException;
import com.itany.exception.UserAlreadyLoginException;
import com.itany.exception.UserNotFoundException;
import com.itany.exception.UserPasswordException;
import com.itany.pojo.User;
import com.itany.user.api.TestUserService;
import com.itany.vo.ActionResult;
import com.itny.utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class TestUserController {

    @Reference
    private TestUserService service;

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/login")
    public ActionResult login(User user, HttpServletResponse response) throws UserNotFoundException, UserAlreadyLoginException {
        ActionResult result=new ActionResult();
        if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
            result.setStatus(false);
            result.setMsg("用户名或者密码不能为空");
        }else {
            User loginuser = service.login(user);
            System.out.println(loginuser);
            loginuser.setPassword(null);
            String token =loginuser.getUsername();

            template.opsForValue().set("USER_TOKEN::" + token, JSON.toJSONString(loginuser),
                    1800, TimeUnit.SECONDS);

            Cookie ck = new Cookie("TT_TOKEN", token);
            ck.setPath("/");
            response.addCookie(ck);
            result.setStatus(true);
        }
       return result;
    }

    @RequestMapping("/register")
    public ActionResult getCode(User user,@RequestParam("code") String code) throws UserPasswordException, SmsCodeException {
        ActionResult result=new ActionResult();
        service.register(user,code);
        result.setStatus(true);
        return result;
    }
    @RequestMapping("/getCode")
    public ActionResult getCode(@RequestParam("phone") String phone){
        ActionResult result = new ActionResult();

        Random random=new Random();
        String verifyCode ="";
        for (int i=0;i<6;i++)
        {
            verifyCode+=random.nextInt(10);
        }

        //请求接口地址
        String url ="http://v.juhe.cn/sms/send";
        //请求参数
        Map params = new HashMap();
        //接收短信的手机号码
        params.put("mobile",phone);
        //短信模板ID，请参考个人中心短信模板设置
        params.put("tpl_id","147778");
        //变量名和变量值对
        params.put("tpl_value","%23code%23%3d"+verifyCode);
        //应用APPKEY(应用详细页查询)
        params.put("key","6e42f210743a6b89547809c5d0ce0984");
        String response = HttpClientUtils.doPost(url, params);
        JSONObject object = JSON.parseObject(response);

        if(object.getInteger("error_code") == 0){
            System.out.println(object.get("result"));

            //将短信验证码存储到redis中
            template.opsForValue().set("PHONE_CODE:"+phone, verifyCode,
                    300, TimeUnit.SECONDS);
            result.setStatus(true);
        }else{
            System.out.println(object.get("error_code")+":"+object.get("reason"));
            result.setStatus(false);
            result.setMsg(object.get("reason").toString());
        }
        return result;
    }




    @RequestMapping("/findUsers")
    public List<User> findUsers(){
       return service.findUsers();
    }

}
