package com.danila.customer.config;

import com.danila.customer.dao.CustomerDAO;
import com.danila.customer.dao.impl.JdbcCustomerDAO;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@Import(DataAccessProperties.class)
@PropertySource(value = "/database.properties")

public class DataAccessConfig {



    @Bean
    DataSource dataSource(DataAccessProperties properties) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    CustomerDAO customerDAO(JdbcTemplate jdbcTemplate) {
        return new JdbcCustomerDAO(jdbcTemplate);
    }
}