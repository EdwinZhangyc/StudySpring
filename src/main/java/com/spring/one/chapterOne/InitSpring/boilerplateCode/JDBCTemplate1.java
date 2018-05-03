package com.spring.one.chapterOne.InitSpring.boilerplateCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用模版能够让代码关注自身的职责
 * 使用模版后不需要在写样板式代码，如TestJDBC.java中所写
 *
 * 使用该类需要将jdbcTemplate引入该类
 */
public class JDBCTemplate1 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee getEmployeeById (long id) {
        return jdbcTemplate.queryForObject ("select * from emplyee where id = ?",
                new RowMapper<Employee>() {
                    public Employee mapRow (ResultSet rs, int rowNum) throws SQLException {
                        Employee employee = new Employee();
                        employee.setId(rs.getString("id"));
                        employee.setSalary(rs.getString("salary"));
                        return employee;
                    }
                }, id);
    }
}