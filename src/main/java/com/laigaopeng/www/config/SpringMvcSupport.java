package com.laigaopeng.www.config;

import com.laigaopeng.www.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * SpringMVC扩展类
 * 用于配置资源管理器
 *
 */
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
    }

    /**
     * 配置静态资源的放行
     *
     * @param registry 静态资源管理器
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/WEB-INF/**").addResourceLocations("/WEB-INF/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }
}
