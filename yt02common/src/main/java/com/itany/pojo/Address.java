package com.itany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author:zhangjiayao@itany.com
 * Date:19-3-27 下午5:52
 * description:
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    private Integer id;
    private String provincetext;
    private String citytext;
    private String regiontext;
    private String address;
    private Integer userid;
    private String phone;
    private User user;
}
