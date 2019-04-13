package com.itany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:yutao@itany.com
 * Date:19-3-27 下午6:04
 * description:
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier implements Serializable {

    private Integer id;
    private String name;
    private Integer flag;
    private String info;
    private String linkman;
    private String phone;
    private Date createTime;


}
