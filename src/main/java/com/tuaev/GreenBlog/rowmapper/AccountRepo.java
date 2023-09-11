//package com.tuaev.GreenBlog.repo;
//
//import com.tuaev.GreenBlog.rowmapper.AccountRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@Repository
//public class AccountRepo {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public AccountRepo(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public Account findAccountById(long id){
//        String sql = "SELECT * FROM account WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
//    }
//
//    public List<Account> findAllAccounts(){
//        String sql = "SELECT * FROM account";
//        return jdbcTemplate.query(sql, new AccountRowMapper());
//    }
//
//    public void changeAmount(long id, BigDecimal amount){
//        String sql = "UPDATE account SET amount = ? WHERE id = ?";
//        jdbcTemplate.update(sql, amount, id);
//    }
//}
