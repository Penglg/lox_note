package com.laigaopeng.www.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class})
public class SpringConfig {
}
