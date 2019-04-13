package com.itany.book.service.impl;

import com.itany.exception.ManagerUserNotExist;
import com.itany.mapper.ManagerUserMapper;
import com.itany.pojo.ManagerUser;
import com.itany.service.ManagerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author:yutao@itany.com
 * Date:19-3-27 下午2:24
 * description:
 * version:1.0
 */

@Service
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
public class ManagerUserServiceImpl implements ManagerUserService {

    @Autowired
    private ManagerUserMapper managerUserMapper;

    @Transactional(readOnly=true)
    public ManagerUser login(ManagerUser managerUser) throws ManagerUserNotExist {

        ManagerUser managerUser1 = managerUserMapper.login(managerUser);
        if(managerUser1==null)
        {
            throw new ManagerUserNotExist("用户不存在");
        }

        return managerUser1;
    }
}
