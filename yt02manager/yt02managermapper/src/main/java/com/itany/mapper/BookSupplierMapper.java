package com.itany.mapper;

import com.itany.pojo.BookSupplier;
import com.itany.pojo.ManagerUser;

/**
 * Author:yutao@itany.com
 * Date:19-3-29 上午10:22
 * description:
 * version:1.0
 */
public interface BookSupplierMapper {

    /**
     * 添加书籍及供应商
     * @param bookSupplier
     */
    public void insertBookSupplier(BookSupplier bookSupplier);

    /**
     * 通过bookid和supplierid查询booksupplier
     * @param bookSupplier
     * @return
     */
    BookSupplier selectByBookIdAndSupplierId(BookSupplier bookSupplier);

    /**
     * 更新number
     * @param bookSupplier
     */
    void updateBookSupplier(BookSupplier bookSupplier);
}
