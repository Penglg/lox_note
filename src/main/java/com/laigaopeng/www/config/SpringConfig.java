package com.laigaopeng.www.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring配置核心类
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MyBatisConfig.class})
@EnableTransactionManagement
@ComponentScan({"com.laigaopeng.www.service"})
public class SpringConfig {
}
