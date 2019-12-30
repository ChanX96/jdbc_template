package com.chanx.jdbctemplate;

import com.chanx.dao.AccountDao;
import com.chanx.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateDemo4 {

    public static void main(String[] args) {

        // 1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 从容器中获取对象
        AccountDao ad = (AccountDao) ac.getBean("accountDao");
        // 3. 执行操作
        Account account = ad.findAccountById(1);
        System.out.println(account);
    }
}
