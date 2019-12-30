package com.chanx.jdbctemplate;

import com.chanx.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的CRUD操作
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {

        // 1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 从容器中获取对象
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        // 3. 执行操作
        // 保存
//        jt.update("INSERT INTO account(name,money) VALUES (?,?)", "eee", 3333f);
        // 更新
//        jt.update("UPDATE account SET name=?,money=? WHERE id=?", "test", 4567F, 8);
        // 删除
//        jt.update("DELETE FROM account WHERE id=?", 8);
        // 查询所有
//        List<Account> accounts = jt.query("SELECT * FROM account WHERE money>?", new AccountRowMapper(), 500f);
//        List<Account> accounts = jt.query("SELECT * FROM account WHERE money>?", new BeanPropertyRowMapper<Account>(Account.class), 500f);
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
        // 查询一个
//        List<Account> accounts = jt.query("SELECT * FROM account WHERE id=?", new BeanPropertyRowMapper<Account>(Account.class), 1);
//        System.out.println(accounts.isEmpty() ? "null" : accounts.get(0));
        // 查询返回一行一列但是不加group by子句
        Integer count = jt.queryForObject("SELECT COUNT(*) FROM account where money>?", Integer.class, 800F);
        System.out.println(count);
    }
}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account> {

    /**
     * 将结果集的数据封装到Account中，由Spring把每个Account加入到集合中
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}
