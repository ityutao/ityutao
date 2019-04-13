package com.itany.mapper;

import com.itany.pojo.Menus;
import com.itany.pojo.Permission;

import java.util.List;
import java.util.Set;

/**
 * Author:yutao@itany.com
 * Date:19-4-3 上午10:20
 * description:
 * version:1.0
 */
public interface PermissionMapper {

    /**
     * 查询所有全县
     * @return
     */
     List<Permission> selectAllPermission();


    /**
     * 左侧导航菜单
     * @param parentId
     * @return
     */
     Set<Menus> selectAllMenus(Integer parentId);


     Permission selectById(Permission permission);


     void updateById(Permission permission);
}
