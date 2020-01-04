package com.example.mongoandmybatis.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/main");
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        配置哪些资源被保护，哪些资源需要权限
//        anon：不需要登录也可以访问相应的权限
//        authc：需要权限才能访问
//        /** ：所有文件及其子文件配置哪些资源被保护，哪些资源需要权限
//         anon：不需要登录也可以访问相应的权限
//         authc：需要权限才能访问
//         /** ：所有文件及其子文件
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/error", "authc");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm();
    }

//    @Bean
//    public CustomReal customRealm() {
//
//    }
}
