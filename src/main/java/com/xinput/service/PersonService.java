package com.xinput.service;

import com.xinput.config.database.TargetDataSource;
import com.xinput.entity.Person2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinput
 * @date 2017-06-25 14:59
 */
@Service
public class PersonService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @TargetDataSource(name = "ds2")
    public List<Person2> query() {
        String sql = "select * from person";
        return jdbcTemplate.query(sql, new Person2());
    }
}
