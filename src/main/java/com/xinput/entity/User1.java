package com.xinput.entity;

import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 存储在数据库ds1中
 *
 * @author xinput
 * @date 2017-06-25 14:42
 */
public class User1 implements RowMapper<User1>, Serializable {
    private static final long serialVersionUID = -3745232844015644742L;

    private String id;
    private String name;
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public User1 mapRow(ResultSet rs, int i) throws SQLException {
        User1 u = new User1();
        u.setId(rs.getString("id"));
        u.setName(rs.getString("name"));
        u.setAge(rs.getInt("age"));
        return u;
    }
}
