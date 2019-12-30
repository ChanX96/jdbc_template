package com.chanx.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {

    public static void main(String[] args) {

        // 准备数据源: spring内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("123");

        // 1. 创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        // 设置数据源
        jt.setDataSource(ds);
        // 2. 执行操作
        jt.execute("INSERT INTO account(name, money) VALUES ('ccc', 1000)");
    }
}
