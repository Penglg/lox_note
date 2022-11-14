package com.laigaopeng.www.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * SpringMVC核心配置类
 *
 */
@Configuration
@ComponentScan({"com.laigaopeng.www.controller", "com.laigaopeng.www.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
