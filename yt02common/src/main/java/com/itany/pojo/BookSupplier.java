package com.itany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author:zhangjiayao@itany.com
 * Date:19-3-27 下午5:39
 * description:
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSupplier implements Serializable {

    private Integer id;
    private Integer bookId;
    private Integer supplierId;
    private Integer sellNum;
    private Integer number;
    private Book book;
    private Supplier supplier;
}
