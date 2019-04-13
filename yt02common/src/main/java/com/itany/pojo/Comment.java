package com.itany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:zhangjiayao@itany.com
 * Date:19-3-27 下午6:24
 * description:
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {
    private Integer id;
    private String info;
    private Integer bookid;
    private Integer userid;
    private Integer level;
    private Date createtime;
    private Book book;
    private User user;
}
