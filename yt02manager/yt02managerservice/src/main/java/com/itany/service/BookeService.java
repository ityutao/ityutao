package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.exception.BookeExistException;
import com.itany.pojo.Book;
import com.itany.pojo.Examine;
import com.itany.pojo.ManagerUser;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

/**
 * Author:yutao@itany.com
 * Date:19-3-29 上午9:51
 * description:
 * version:1.0
 */
public interface BookeService {


    /**
     * 添加书籍以及相关信息
     * @param book
     * @param managerUser
     * @param file
     * @throws FileNotFoundException
     */
    public void addBook(Book book, ManagerUser managerUser, MultipartFile file) throws FileNotFoundException;

    /**
     * 条件查询,分页查询,模糊查询
     * @param page
     * @param rows
     * @param book
     * @return
     */
    public PageInfo<Book> findFindFuzz(Integer page, Integer rows,Book book);

    /**
     * book状态改为启用
     * @param book
     */
    void modifyEnable(Book book);

    /**
     * 书籍改为禁用
     * @param book
     */
    void modifyDisable(Book book);


    /**
     * 通过id查找书籍
     * @param book
     * @return
     */
    Book findById(Book book);


    /**
     * 修改书籍信息
     * @param book
     * @param file
     * @throws FileNotFoundException
     */
    void modifyById(Book book,MultipartFile file) throws FileNotFoundException;
}
