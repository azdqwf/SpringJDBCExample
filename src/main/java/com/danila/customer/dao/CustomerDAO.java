package com.danila.customer.dao;

import com.danila.customer.model.Customer;


public interface CustomerDAO {
    void insert(Customer customer);

    Customer findByCustomerId(int custId);
}




