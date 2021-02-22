package com.wangyj.api.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//声明配置类
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        //注册跨域拦截器
        InterceptorRegistration kuaYu = registry.addInterceptor(new KuaYuInterceptors());
        //设置拦截路径
        kuaYu.addPathPatterns("/**");

        //注册登录拦截器
        InterceptorRegistration login = registry.addInterceptor(new LoginInterceptors());
        //设置拦截路径
        login.addPathPatterns("/**");
        //设置哪些不拦截
        login.excludePathPatterns("/api/login/login");



    }
}
