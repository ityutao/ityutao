package com.itany.controller;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.Book;
import com.itany.pojo.Examine;
import com.itany.pojo.ManagerUser;
import com.itany.service.BookeService;
import com.itany.vo.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Author:yutao@itany.com
 * Date:19-3-29 上午10:14/home/soft01/apache-tomcat-7.0.40/webapps
 * description:
 * version:1.0
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookeService bookeService;


    @RequestMapping("/addBook")
    @ResponseBody
    public ActionResult addBook(Book book, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws IOException {
        ActionResult result=new ActionResult();
//        String filename = file.getOriginalFilename();
//        someFile.transferTo("D:/"+filename.substring(filename.lastIndexOf(".")));
//        String fileName = someFile.getOriginalFilename();
//

//        String name = file.getName();
//        book.setImgUrl(name);
        ManagerUser managerUser= (ManagerUser) session.getAttribute("ManagerUser");
        bookeService.addBook(book,managerUser,file);
        result.setStatus(true);
        return result;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(@RequestParam(defaultValue="1")Integer page,
                                      @RequestParam(defaultValue="5")Integer rows,Book book)
    {
        Map<String,Object> map = new HashMap<>();
        PageInfo<Book> info = bookeService.findFindFuzz(page,rows,book);
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        return map;
    }
    @RequestMapping("/modifyEnable")
    @ResponseBody
    public ActionResult modifyEnable(Book book){
        ActionResult result = new ActionResult();
        bookeService.modifyEnable(book);
        result.setStatus(true);
        return result;
    }
    @RequestMapping("/modifyDisable")
    @ResponseBody
    public ActionResult modifyDisable(Book book){
        ActionResult result = new ActionResult();
        bookeService.modifyDisable(book);
        result.setStatus(true);
        return result;
    }
    @RequestMapping("/findById")
    @ResponseBody
    public ActionResult findById(Book book){
        ActionResult result = new ActionResult();
        Book id = bookeService.findById(book);
        result.setStatus(true);
        result.setData(id);
        return result;
    }
    @RequestMapping("/modifyById")
    @ResponseBody
    public ActionResult modifyById( Book book,@RequestParam(value = "file") MultipartFile file) throws FileNotFoundException {
        ActionResult result = new ActionResult();
        bookeService.modifyById(book,file);
        result.setStatus(true);
        return result;
    }

}
