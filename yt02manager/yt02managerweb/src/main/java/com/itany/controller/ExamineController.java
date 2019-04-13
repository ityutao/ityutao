package com.itany.controller;

import com.github.pagehelper.PageInfo;
import com.itany.exception.ExamineException;
import com.itany.pojo.Book;
import com.itany.pojo.Examine;
import com.itany.pojo.ManagerUser;
import com.itany.service.ExamineService;
import com.itany.vo.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:yutao@itany.com
 * Date:19-3-29 下午3:38
 * description:
 * version:1.0
 */
@Controller
@RequestMapping("/examine")
public class ExamineController {

    @Autowired
    private ExamineService examineService;

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(Book book,
                                      @RequestParam(defaultValue="1")Integer page,
                                      @RequestParam(defaultValue="5")Integer rows){

//        ManagerUser managerUser = (ManagerUser) session.getAttribute("ManagerUser");
//        Integer supplierId=managerUser.getSupplierid();
        Examine examine=new Examine();
        examine.setBook(book);
        Map<String,Object> map = new HashMap<>();
        PageInfo<Examine> info = examineService.findAllExamine(page, rows,examine);
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        return map;
    }
    @RequestMapping("/findFuzzAll")
    @ResponseBody
    public Map<String,Object> findFuzzAll(Book book,
                                      @RequestParam(defaultValue="1")Integer page,
                                      @RequestParam(defaultValue="5")Integer rows,HttpSession session){

        ManagerUser managerUser = (ManagerUser) session.getAttribute("ManagerUser");
        Integer supplierId=managerUser.getSupplierid();
        Examine examine=new Examine();
        examine.setSupplierId(supplierId);
        examine.setBook(book);
        Map<String,Object> map = new HashMap<>();
        PageInfo<Examine> info = examineService.findAllExamine(page, rows,examine);
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        System.out.println(book.getBookName());
        return map;
    }

    @ResponseBody
    @RequestMapping("/modifyFlag")
    public ActionResult modifyFlag(Examine examine) throws ExamineException {
        ActionResult result=new ActionResult();
        examineService.modifyFlag(examine);
        result.setStatus(true);
        return result;

    }

}
