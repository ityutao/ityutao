package com.itany.service;

import com.itany.exception.ManagerUserNotExist;
import com.itany.pojo.ManagerUser;

/**
 * Author:yutao@itany.com
 * Date:19-3-27 下午2:15
 * description:
 * version:1.0
 */
public interface ManagerUserService {

    /**
     * 登陆user返回user
     * @param managerUser
     * @return
     * @throws ManagerUserNotExist
     */
    public ManagerUser login(ManagerUser managerUser) throws ManagerUserNotExist;
}
