package com.itany.book.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.mapper.PermissionMapper;
import com.itany.pojo.Menus;
import com.itany.pojo.Permission;
import com.itany.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Author:yutao@itany.com
 * Date:19-4-3 下午2:57
 * description:
 * version:1.0
 */
@Service
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Transactional(readOnly = true)
    public Set<Menus> findAllMenus(Integer parentId) {
        Set<Menus> menus = permissionMapper.selectAllMenus(parentId);
        for(Menus m : menus){
            m.setIcon("icon-sys");
            System.out.println(m);
            for(Menus m1 : m.getMenus()){

                m1.setIcon("icon-nav");
            }
        }
        return menus;
    }

    
    @Transactional(readOnly = true)
    public PageInfo<Permission> findAllPermission(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Permission> permissions = permissionMapper.selectAllPermission();
        PageInfo<Permission> info=new PageInfo<Permission>(permissions);
        return info;
    }
}
