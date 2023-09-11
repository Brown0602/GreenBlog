//package com.tuaev.GreenBlog.rowmapper;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import java.math.BigDecimal;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class AccountRowMapper implements RowMapper<Account> {
//    @Override
//    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Account account = new Account();
//        account.setId(rs.getInt("id"));
//        account.setName(rs.getString("name"));
//        account.setAmount(BigDecimal.valueOf(rs.getInt("amount")));
//        return account;
//    }
//}
