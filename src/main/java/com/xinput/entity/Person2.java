package com.xinput.entity;

import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 存储在数据库ds2中
 *
 * @author xinput
 * @date 2017-06-25 14:55
 */
public class Person2 implements RowMapper<Person2>, Serializable {
    private static final long serialVersionUID = -2711922378023281245L;

    private String id;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Person2 mapRow(ResultSet rs, int i) throws SQLException {
        Person2 p = new Person2();
        p.setId(rs.getString("id"));
        p.setAddress(rs.getString("address"));
        return p;
    }
}
