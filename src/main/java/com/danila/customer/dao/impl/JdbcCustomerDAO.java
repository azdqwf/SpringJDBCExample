package com.danila.customer.dao.impl;

import com.danila.customer.dao.CustomerDAO;
import com.danila.customer.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JdbcCustomerDAO implements CustomerDAO {
    private final JdbcTemplate jdbcTemplate;

    public JdbcCustomerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Customer customer) {

        String sql = "INSERT INTO customer " +
                "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, customer.getCustId(), customer.getName(), customer.getAge());

    }

    @Override
    public Customer findByCustomerId(int custId) {

        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{1},
                (resultSet, i) -> new Customer(resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getInt(3)));

    }
}




