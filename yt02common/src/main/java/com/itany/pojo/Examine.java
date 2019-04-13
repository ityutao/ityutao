package com.itany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author:yutao@itany.com
 * Date:19-3-27 下午6:30
 * description:
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Examine implements Serializable {

    private Integer id;
    private Integer bookId;
    private Integer number;
    private String info;
    private Integer supplierId;
    private String title;
    private Integer flag;
    private Book book;
    private Supplier supplier;


}
