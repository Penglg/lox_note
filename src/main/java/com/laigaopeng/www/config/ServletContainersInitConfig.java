package com.laigaopeng.www.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * Servlet容器类
 *
 */
@Configuration
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    /**
     * 加载SpringMVC的bean
     *
     * @return WebApplicationContext
     */
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext app = new AnnotationConfigWebApplicationContext();
        app.register(SpringMvcConfig.class);
        return app;
    }

    /**
     * 拦截所有请求给SpringMVC处理
     *
     * @return String
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 加载非SpringMVC加载的bean，寄Spring加载的bean
     *
     * @return WebApplicationContext
     */
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext app = new AnnotationConfigWebApplicationContext();
        app.register(SpringConfig.class);
        return app;
    }
}
