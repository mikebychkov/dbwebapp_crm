package com.store;

import com.model.Customer;

import java.util.List;

public interface CustomerDB {

    public Customer getCustomer(int id);

    public List<Customer> getCustomers();
}
