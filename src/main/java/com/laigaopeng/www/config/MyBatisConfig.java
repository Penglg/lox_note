package com.laigaopeng.www.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * MyBatis配置类
 * 配置SqlSessionFactory与映射扫描接口的bean
 */
public class MyBatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        // 定义类型别名
        factoryBean.setTypeAliasesPackage("com.laigaopeng.www.pojo");
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        // 映射扫描接口
        msc.setBasePackage("com.laigaopeng.www.dao");
        return msc;
    }
}
