package com.service;

import com.model.Customer;
import com.store.CustomerDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDB store;

    @Autowired
    public CustomerServiceImpl(CustomerDB store) {
        this.store = store;
    }

    @Transactional
    @Override
    public Customer getCustomer(int id) {
        return store.getCustomer(id);
    }

    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return store.getCustomers();
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == 0) {
            store.save(customer);
        } else {
            store.update(customer);
        }
        return customer;
    }

    @Transactional
    @Override
    public void delete(Customer customer) {
        store.delete(customer);
    }
}
