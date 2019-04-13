package com.itany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author:zhangjiayao@itany.com
 * Date:19-3-27 下午6:37
 * description:
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderBook implements Serializable {

    private Integer id;
    private Integer bookid;
    private Integer orderid;
    private Integer num;
    private float price;
    private Book book;
    private Order order;
}
