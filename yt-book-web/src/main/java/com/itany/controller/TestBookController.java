package com.itany.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itany.book.service.IBookService;
import com.itany.vo.ActionResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by tyh on 2018/9/23.
 */
@RestController
@RequestMapping("/testbook")
public class TestBookController {

    @Reference
    private IBookService bookService;

    @RequestMapping("/addDoc")
    public ActionResult addDoc(){
        ActionResult ac = new ActionResult();
        bookService.addDoc();
        ac.setStatus(true);
        return ac;
    }


    @RequestMapping("/findDoc")
    public List<Map<String,String>> findDoc(){
           return bookService.findDoc();
    }

}
