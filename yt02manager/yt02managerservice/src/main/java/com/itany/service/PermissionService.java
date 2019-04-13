package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.Menus;
import com.itany.pojo.Permission;

import java.util.Set;
import java.util.TreeSet;

/**
 * Author:yutao@itany.com
 * Date:19-4-3 下午2:57
 * description:
 * version:1.0
 */
public interface PermissionService {


    /**
     * 递归查询所有导航菜单
     * @param parentId
     * @return
     */
    Set<Menus> findAllMenus(Integer parentId);



    PageInfo<Permission> findAllPermission(Integer page, Integer rows);
}
