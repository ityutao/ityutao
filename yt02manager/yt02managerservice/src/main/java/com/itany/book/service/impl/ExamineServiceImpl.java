package com.itany.book.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.constant.Constant;
import com.itany.exception.ExamineException;
import com.itany.mapper.BookMapper;
import com.itany.mapper.BookSupplierMapper;
import com.itany.mapper.ExamineMapper;
import com.itany.pojo.Book;
import com.itany.pojo.BookSupplier;
import com.itany.pojo.Examine;
import com.itany.service.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:yutao@itany.com
 * Date:19-3-29 下午3:35
 * description:
 * version:1.0
 */
@Service
@Transactional(rollbackFor=Exception.class,propagation= Propagation.REQUIRED)
public class ExamineServiceImpl implements ExamineService {


    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookSupplierMapper bookSupplierMapper;

    @Transactional(readOnly=true)
    public PageInfo<Examine> findAllExamine(Integer page, Integer rows,Examine examine) {
        PageHelper.startPage(page, rows);
        List<Examine> examine1 = examineMapper.findAllExamine(examine);
        PageInfo<Examine> info=new PageInfo<Examine>(examine1);
        return info;
    }

    public void modifyFlag(Examine examine) throws ExamineException {
        Book book=new Book();
        book.setId(examine.getBookId());
        Book book1 = bookMapper.selectById(book);
        if(null==book1 ||book1.getFlag()== Constant.DEFAULT_STATUS_SHENHEBUTONGGUO){
            throw new ExamineException("审核不通过无法修改");
        }

        if(examine.getFlag()== Constant.DEFAULT_STATUS_YI)
        {
            book.setNumber(examine.getNumber()+book1.getNumber());
            bookMapper.updateById(book);

            BookSupplier bookSupplier = new BookSupplier();
            bookSupplier.setSupplierId(examine.getSupplierId());
            bookSupplier.setBookId(examine.getBookId());
            BookSupplier bookSupplier1 = bookSupplierMapper.selectByBookIdAndSupplierId(bookSupplier);

            if(null==bookSupplier1){
                bookSupplier.setNumber(examine.getNumber());
                bookSupplier.setSellNum(Constant.DEFAULT_BOOK_NUM);
                bookSupplierMapper.insertBookSupplier(bookSupplier);
            }else{
                bookSupplier.setNumber(bookSupplier1.getNumber()+examine.getNumber());
                bookSupplierMapper.updateBookSupplier(bookSupplier);
            }
        }
        examineMapper.updateFlag(examine);
    }
}
