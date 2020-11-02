package com.service;

import com.model.Customer;
import com.store.CustomerDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

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

    @Override
    @Transactional
    public Customer save(Customer customer) {
        /*
        if (customer.getId() == 0) {
            store.save(customer);
        } else {
            store.update(customer);
        }
        */
        store.saveOrUpdate(customer);
        return customer;
    }

    @Override
    @Transactional
    public void delete(Customer customer) {
        store.deleteWithACurrentSession(customer);
    }

    @Override
    @Transactional
    public void delete(int id) {
        store.deleteWithACurrentSession(id);
    }
}
