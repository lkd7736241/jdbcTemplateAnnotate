package com.sun.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * create by qiulisun on 2018/11/15.<br>
 */
@Configuration
@ComponentScan(basePackages = "com.sun")
public class SpringConfig {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/xiuzhenyuan?characterEncoding=UTF-8&useSSL=false&useAffectedRows=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "993972";

    @Bean(destroyMethod = "close")
    public ComboPooledDataSource getDataSource() {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(DRIVER);
            dataSource.setJdbcUrl(URL);
            dataSource.setUser(USERNAME);
            dataSource.setPassword(PASSWORD);

            dataSource.setMaxPoolSize(30);
            dataSource.setMinPoolSize(10);

            dataSource.setAutoCommitOnClose(false);
            dataSource.setCheckoutTimeout(10000);
            dataSource.setAcquireRetryAttempts(2);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
    	jdbcTemplate.setDataSource(this.getDataSource());
    	return jdbcTemplate;
    }
}
