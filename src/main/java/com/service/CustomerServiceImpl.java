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

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return store.getCustomer(id);
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return store.getCustomers();
    }
}
