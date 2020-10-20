package com.service;

import com.model.Customer;

import java.util.List;

public interface CustomerService {

    public Customer getCustomer(int id);

    public List<Customer> getCustomers();
}
