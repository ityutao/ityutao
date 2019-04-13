package com.itany.interceptor;

import com.itany.ApplicationContextHold;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception{

        StringRedisTemplate template = ApplicationContextHold.getBean(StringRedisTemplate.class);
        boolean flag = false;
        Cookie[] cks = request.getCookies();
        if(null != cks){
          for(int i=0;i<cks.length;i++){
              Cookie ck = cks[i];
              if("TT_TOKEN".equals(ck.getName())){
                      String str = template.opsForValue().get("USER_TOKEN::"+ck.getValue());
                      System.out.println("-------------"+str);
                  if(StringUtils.isEmpty(str)){
                      response.sendRedirect("http://localhost:9003/user/showlogin");
                  }
                      flag = true;
              }
          }
        }
        return flag;
    }
}
