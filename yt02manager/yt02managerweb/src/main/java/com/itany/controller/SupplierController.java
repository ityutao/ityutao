package com.itany.controller;

import com.itany.pojo.Book;
import com.itany.pojo.Supplier;
import com.itany.service.SupplierService;
import com.itany.vo.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Author:yutao@itany.com
 * Date:19-4-3 上午11:52
 * description:
 * version:1.0
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/findAll")
    @ResponseBody
    public ActionResult findAll()  {
        ActionResult result=new ActionResult();
        List<Supplier> supplier = supplierService.findAllSupplier();
        result.setData(supplier);
        result.setStatus(true);

        return  result;


    }



}
