package com.itany.conf;

import com.itany.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TestMvcConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/user/findUsers");
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/showlist").setViewName("userlist");
        registry.addViewController("/showlogin").setViewName("login");
        registry.addViewController("/showregister").setViewName("register");
    }
}
