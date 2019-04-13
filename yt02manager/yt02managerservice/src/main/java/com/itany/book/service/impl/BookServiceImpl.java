package com.itany.book.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.constant.Constant;
import com.itany.exception.BookeExistException;
import com.itany.mapper.BookMapper;
import com.itany.mapper.BookSupplierMapper;
import com.itany.mapper.ExamineMapper;
import com.itany.pojo.Book;
import com.itany.pojo.BookSupplier;
import com.itany.pojo.Examine;
import com.itany.pojo.ManagerUser;
import com.itany.service.BookeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Author:yutao@itany.com
 * Date:19-3-29 上午9:54
 * description:
 * version:1.0
 */

@Service
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookeService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private ExamineMapper examineMapper;
    /**
     *
     * @param book
     */
    public void addBook(Book book, ManagerUser managerUser, MultipartFile file) throws FileNotFoundException {
        Book book1 = bookMapper.selectByISBN(book);
//        BookSupplier bookSupplier=new BookSupplier();
        Examine examine=new Examine();
        examine.setSupplierId(managerUser.getSupplierid());
        examine.setFlag(Constant.DEFAULT_STATUS_DAI);
        examine.setNumber(book.getNumber());
        examine.setTitle("["+book.getBookName()+"]审核");
//        examine.setInfo(book.getBookName()+"信息");
        if(book1==null){
            book.setNumber(0);
            book.setPressId(1);
            book.setFlag(Constant.DEFAULT_STATUS_DAI);
            try {
                String filename = file.getOriginalFilename();
                file.transferTo(new File("/home/soft01/apache-tomcat-7.0.40/webapps/img/"+
                        UUID.randomUUID().toString() +
                        filename.substring(filename.lastIndexOf("."))));
                book.setImgUrl(filename);
                bookMapper.insertBook(book);
                examine.setBookId(book.getId());
            } catch (IOException e) {
                throw new FileNotFoundException("资源不能为空");
            }
//            bookSupplier.setBookId(book.getId());
//            bookSupplier.setSupplierId(managerUser.getSupplierid());
//            bookSupplier.setSellNum(Constant.DEFAULT_SELLNUM);
//            book.setNumber(bookSupplier.getNumber());
//            bookSupplierMapper.insertBookSupplier(bookSupplier);
        }else {
            examine.setBookId(book1.getId());
        }
        examineMapper.insertExamine(examine);
    }

    @Transactional(readOnly=true)
    public PageInfo<Book> findFindFuzz(Integer page, Integer rows,Book book) {
        PageHelper.startPage(page, rows);
        List<Book> books= bookMapper.selectFindFuzz(book);
        PageInfo<Book> info=new PageInfo<Book>(books);
        return info;
    }

    public void modifyEnable(Book book) {
        book.setFlag(Constant.DEFAULT_STATUS_YI);
        bookMapper.updateEnable(book);
    }

    public void modifyDisable(Book book) {
        book.setFlag(Constant.DEFAULT_STATUS_DAI);
        bookMapper.updateDisable(book);

    }

    public Book findById(Book book) {
        Book book1 = bookMapper.selectById(book);
        return book1;
    }

    public void modifyById(Book book,MultipartFile file) throws FileNotFoundException {

        try {
            String originalFilename = file.getOriginalFilename();
            file.transferTo(new File("/home/soft01/apache-tomcat-7.0.40/webapps/img/"+UUID.randomUUID().toString() +
                    originalFilename.substring(originalFilename.lastIndexOf("."))));
            book.setImgUrl(originalFilename);
            bookMapper.updateById(book);
        } catch (IOException e) {
            throw new FileNotFoundException("文件不能唯kong");
        }
    }


}
