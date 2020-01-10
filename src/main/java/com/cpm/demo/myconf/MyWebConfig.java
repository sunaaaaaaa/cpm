package com.cpm.demo.myconf;

import com.cpm.demo.component.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootConfiguration
public class MyWebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
     //用来配置静态资源
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //注册拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login","/registry");
    }
}
