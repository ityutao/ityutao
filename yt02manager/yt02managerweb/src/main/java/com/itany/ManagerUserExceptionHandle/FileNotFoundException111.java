package com.itany.ManagerUserExceptionHandle;

import com.itany.vo.ActionResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

/**
 * Author:yutao@itany.com
 * Date:19-4-2 下午2:13
 * description:
 * version:1.0
 */
@RestController
@ControllerAdvice
public class FileNotFoundException111 {
    @ExceptionHandler(FileNotFoundException.class)
    public ActionResult FileNotFoundException(FileNotFoundException e){
        ActionResult result=new ActionResult();
        result.setMsg(e.getMessage());
        result.setStatus(false);
        return result;
    }
}
