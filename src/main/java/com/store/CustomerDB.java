package com.store;

import com.model.Customer;

import java.util.List;

public interface CustomerDB {

    public Customer getCustomer(int id);

    public List<Customer> getCustomers();

    public Customer save(Customer customer);

    public Customer update(Customer customer);

    public Customer saveOrUpdate(Customer customer);

    public void delete(Customer customer);

    public void deleteWithACurrentSession(Customer customer);

    public void deleteWithACurrentSession(int id);
}
