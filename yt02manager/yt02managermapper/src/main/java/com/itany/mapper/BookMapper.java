package com.itany.mapper;

import com.itany.pojo.Book;

import java.util.List;

/**
 * Author:yutao@itany.com
 * Date:19-3-29 上午9:33
 * description:
 * version:1.0
 */
public interface BookMapper {
    /**
     * 添加书籍
     * @param book
     */
    public void insertBook(Book book);

    /**
     *
     * @param book
     * @return
     */
    public Book selectByISBN(Book book);


    public List<Book> selectFindFuzz(Book book);


    /**
     *
     * @param book
     */
    void updateEnable(Book book);

    /**
     *
     * @param book
     */
    void updateDisable(Book book);

    /**
     *
     * @param book
     * @return
     */
    Book selectById(Book book);

    /**
     *
     * @param book
     */
    void updateById(Book book);
}
