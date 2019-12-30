package com.chanx.dao.impl;

import com.chanx.dao.AccountDao;
import com.chanx.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(Integer id) {

        return jdbcTemplate.query("SELECT * FROM account WHERE id=?", new BeanPropertyRowMapper<Account>(Account.class), id).get(0);
    }

    public Account findAccountByName(String name) {

        List<Account> accounts = jdbcTemplate.query("SELECT * FROM account WHERE name=?", new BeanPropertyRowMapper<Account>(Account.class), name);
        // name结果集分类讨论
        if (accounts == null) {
            return null;
        } else if (accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {

        jdbcTemplate.update("UPDATE account SET name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }
}
