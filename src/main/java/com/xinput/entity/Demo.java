package com.xinput.entity;

import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xinput
 * @date 2018-05-26 09:50
 */
public class Demo implements RowMapper<Demo>, Serializable {
    private static final long serialVersionUID = 3902231231876792306L;

    private String id;
    private String demo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    @Override
    public Demo mapRow(ResultSet rs, int i) throws SQLException {
        Demo demo = new Demo();
        demo.setId(rs.getString("id"));
        demo.setDemo(rs.getString("demo"));
        return demo;
    }
}
