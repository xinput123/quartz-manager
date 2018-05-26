package com.xinput.service;

import com.xinput.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinput
 * @date 2018-05-26 11:19
 */
@Service
public class DemoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 使用默认数据库demo
     *
     * @return
     */
    public List<Demo> query() {
        String sql = "select * from demo";
        return jdbcTemplate.query(sql, new Demo());
    }
}
