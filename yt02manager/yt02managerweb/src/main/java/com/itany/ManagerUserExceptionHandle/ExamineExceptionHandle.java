package com.itany.ManagerUserExceptionHandle;

import com.itany.exception.ExamineException;
import com.itany.vo.ActionResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:yutao@itany.com
 * Date:19-4-4 上午9:17
 * description:
 * version:1.0
 */
@RestController
@ControllerAdvice
public class ExamineExceptionHandle {

    @ExceptionHandler(ExamineException.class)
    public ActionResult ExamineException(ExamineException e){
        ActionResult result=new ActionResult();
        result.setStatus(false);
        result.setMsg(e.getMessage());
        return result;

    }
}
