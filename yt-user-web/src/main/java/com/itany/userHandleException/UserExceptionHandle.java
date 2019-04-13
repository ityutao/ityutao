package com.itany.userHandleException;

import com.itany.exception.*;
import com.itany.vo.ActionResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:yutao@itany.com
 * Date:19-4-11 下午3:22
 * description:
 * version:1.0
 */
@RestController
@ControllerAdvice
public class UserExceptionHandle {

    @ExceptionHandler(UserNotFoundException.class)
    public ActionResult UserNotFoundException(UserNotFoundException e){
        ActionResult result=new ActionResult();
        result.setStatus(false);
        result.setMsg(e.getMessage());
        return result;

    }

    @ExceptionHandler(UserAlreadyLoginException.class)
    public ActionResult UserAlreadyLoginException(UserAlreadyLoginException e){
        ActionResult result=new ActionResult();
        result.setStatus(false);
        result.setMsg(e.getMessage());
        return result;

    }
    @ExceptionHandler(UserPasswordException.class)
    public ActionResult UserPasswordException(UserPasswordException e){
        ActionResult result=new ActionResult();
        result.setStatus(false);
        result.setMsg(e.getMessage());
        return result;

    }
    @ExceptionHandler(SmsCodeException.class)
    public ActionResult SmsCodeException(SmsCodeException e){
        ActionResult result=new ActionResult();
        result.setStatus(false);
        result.setMsg(e.getMessage());
        return result;

    }
}
