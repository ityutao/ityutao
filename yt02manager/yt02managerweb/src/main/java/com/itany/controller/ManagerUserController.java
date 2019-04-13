package com.itany.controller;

import com.itany.exception.ManagerUserNotExist;
import com.itany.pojo.ManagerUser;
import com.itany.service.ManagerUserService;
import com.itany.vo.ActionResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:yutao@itany.com
 * Date:19-3-27 下午2:33
 * description:
 * version:1.0
 */
@Controller
@RequestMapping("/managerUser")
public class ManagerUserController {

    @Autowired
    private ManagerUserService managerUserService;

    @RequestMapping("/managerLogin")
    @ResponseBody
    public ActionResult login(ManagerUser managerUser, HttpSession session) throws ManagerUserNotExist {

        ActionResult result=new ActionResult();
        ManagerUser user = managerUserService.login(managerUser);
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());

        SecurityUtils.getSubject().login(token);
//        session.setAttribute("ManagerUser",user);
        result.setData(user);
        result.setStatus(true);
        return result;
    }



}
