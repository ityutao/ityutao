package com.itany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:zhangjiayao@itany.com
 * Date:19-3-27 下午5:58
 * description:
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private Integer id;
    private String bookName;
    private String author;
    private Date publishDate;
    private Double groupPrice;
    private Double price;
    private String format;
    private String pageNumber;
    private String ISBN;
    private String barcode;
    private Integer layout;
    private Integer printingNumber;
    private String register;
    private String weight;
    private String bookIntroduce;
    private String authorIntroduce;
    private String catalog;
    private Integer typeId;
    private Date createTime;
    private Integer pressId;
    private Integer number;
    private String imgUrl;
    private Integer flag;
    private Integer recommend;
    private Press press;
    private BookType bookType;

    private Supplier supplier;

    private BookSupplier bookSupplier;
}
