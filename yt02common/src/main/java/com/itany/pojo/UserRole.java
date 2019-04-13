package com.itany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author:zhangjiayao@itany.com
 * Date:19-3-27 下午6:52
 * description:
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole implements Serializable {

    private Integer id;
    private Integer userid;
    private Integer roleid;
    private Role role;
    private ManagerUser managerUser;
}
