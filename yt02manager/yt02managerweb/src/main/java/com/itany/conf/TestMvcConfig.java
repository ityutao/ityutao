package com.itany.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TestMvcConfig implements WebMvcConfigurer {

    //添加ViewController
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/showlist").setViewName("userlist");
        registry.addViewController("/showLogin").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/booklist").setViewName("booklist");
        registry.addViewController("/supplierExamine").setViewName("supplierExamine");
        registry.addViewController("/supplierPlatform").setViewName("supplierPlatform");
        registry.addViewController("/ShowSupplierList").setViewName("supplierlist");
        registry.addViewController("/ShowSupplierBookList").setViewName("supplierbooklist");
        registry.addViewController("/showManager").setViewName("manager");
        registry.addViewController("/showRole").setViewName("role");
        registry.addViewController("/showPermission").setViewName("permission");
        registry.addViewController("/showUserList").setViewName("userlist");
        registry.addViewController("/showOrderList").setViewName("orderlist");
    }
}
