package com.itany.controller;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.Menus;
import com.itany.pojo.Permission;
import com.itany.service.PermissionService;
import com.itany.vo.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author:yutao@itany.com
 * Date:19-4-3 下午3:05
 * description:
 * version:1.0
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;


    @ResponseBody
    @RequestMapping("/findAllMenus")
    public ActionResult findAllMenus(){

        ActionResult result = new ActionResult();
        Set<Menus> menus = permissionService.findAllMenus(0);
        result.setData(menus);
        return result;
    }
    @ResponseBody
    @RequestMapping("/findAllPermission")
    public Map<String,Object> findAllMenus(@RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "10") Integer rows){

        Map<String,Object> map=new HashMap<>();
        PageInfo<Permission> allPermission = permissionService.findAllPermission(page, rows);
        map.put("total",allPermission.getTotal());
        map.put("rows",allPermission.getList());
        return map;
    }

}
