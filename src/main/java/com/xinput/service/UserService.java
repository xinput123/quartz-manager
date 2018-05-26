package com.xinput.service;

import com.xinput.config.database.TargetDataSource;
import com.xinput.entity.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinput
 * @date 2017-06-25 14:58
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @TargetDataSource(name = "ds1")
    public List<User1> query() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new User1());
    }
}
