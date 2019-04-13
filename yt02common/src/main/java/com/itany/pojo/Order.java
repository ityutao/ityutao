package com.itany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author:zhangjiayao@itany.com
 * Date:19-3-27 下午6:34
 * description:
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private Integer id;
    private String no;
    private String alipayno;
    private Integer userid;
    private Integer addressid;
    private String info;
    private float price;
    private Integer flag;
    private User user;
    private Address address;
}
