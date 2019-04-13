package com.itany.mapper;

import com.itany.pojo.ManagerUser;

/**
 * Author:yutao@itany.com
 * Date:19-3-27 下午2:18
 * description:
 * version:1.0
 */
public interface ManagerUserMapper {

    /**
     * 登陆返回user
     * @param managerUser
     * @return
     */
    public ManagerUser login(ManagerUser managerUser);

}
