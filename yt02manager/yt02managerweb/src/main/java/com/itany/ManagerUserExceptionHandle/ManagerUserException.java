package com.itany.ManagerUserExceptionHandle;

import com.itany.exception.ManagerUserNotExist;
import com.itany.vo.ActionResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:yutao@itany.com
 * Date:19-3-27 下午3:13
 * description:
 * version:1.0
 */
@RestController
@ControllerAdvice
public class ManagerUserException {

    @ExceptionHandler(ManagerUserNotExist.class)
    public ActionResult ManagerUserNotExist(ManagerUserNotExist e){
        ActionResult result=new ActionResult();
        result.setMsg(e.getMessage());
        result.setStatus(false);
        return result;

    }

}
