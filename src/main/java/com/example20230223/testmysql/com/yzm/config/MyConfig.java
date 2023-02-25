package com.example20230223.testmysql.com.yzm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: yzm
 * @Date: 2023/2/24 - 02 - 24 - 23:20
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Autowired
    private TestMysqlInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }
}
