package com.itany.conf;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.LinkedHashMap;

/**
 * Author:mazhengwei@itany.com
 * Date:19-4-12 上午10:52
 * description:
 * version:1.0
 */

@Configuration
public class ShiroConfig {

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean
            (@Qualifier("securityManager") SecurityManager securityManager){

        ShiroFilterFactoryBean bean = new  ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        bean.setLoginUrl("/manager/showLogin");
        bean.setUnauthorizedUrl("/fff");

        LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();

        map.put("/manager/showIndex","authc,perms[/]");
        map.put("/manager/ShowBookList","authc,perms[book:findAll]");
        map.put("/manager/showSupplierExamine","authc,perms[examine:findAllBySupplierId]");
        map.put("/manager/ShowSupplierPlatform","authc,perms[examine:findAll]");
        map.put("/manager/ShowSupplierList","authc,perms[supplier:findAll]");
        map.put("/manager/ShowSupplierBookList","authc,perms[book:findAllBySupplier]");
        map.put("/manager/showManager","authc,perms[managerUser:findAll]");
        map.put("/manager/showRole","authc,perms[role:findAll]");
        map.put("/manager/showPermission","authc,perms[permission:findAll]");
        map.put("/manager/showUserList","authc,perms[User:findAll]");
        map.put("/manager/showOrderList","authc,perms[order:findAll]");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }

    @Bean(name ="securityManager")
    public SecurityManager securityManager(@Qualifier("jdbcRealm") AuthorizingRealm realm){
        System.out.println("-------------securityManager------------------");
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean(name ="jdbcRealm")
    public JdbcRealm authRealm(@Qualifier("dataSource") DataSource dataSource){
        System.out.println("-------------jdbcRealm------------------");
        JdbcRealm jdbcRealm =new JdbcRealm();
        System.out.println("--------------JdbcRealm已经加载----------------");
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);
        jdbcRealm.setAuthenticationQuery("select password from t_manager_user where username=?");
        jdbcRealm.setUserRolesQuery("select r.name from t_manager_user u left join t_user_role ur on\n" +
                "\t\t\t\tu.id = ur.userid left join t_role r on ur.roleid=r.id where\n" +
                "\t\t\t\tu.username =?");
        jdbcRealm.setPermissionsQuery(" select p.sname from t_role r left join\n" +
                "\t\t\t\tt_role_permission rp on r.id = rp.roleid left join t_permission p\n" +
                "\t\t\t\ton p.id = rp.permissionid where r.name=?");
        return jdbcRealm;
    }
}
