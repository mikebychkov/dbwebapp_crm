package com.rest;

import com.model.Customer;
import com.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private static final Logger logger = LogManager.getLogger(CustomerRestController.class);

    private final CustomerService service;

    @Autowired
    public CustomerRestController(CustomerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public void create(@RequestBody Customer customer) {
        service.save(customer);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getAll() {
        return service.getCustomers();
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Customer getById(@PathVariable int id) {
        return service.getCustomer(id);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.PUT)
    public void update(@RequestBody Customer customer) {
        service.save(customer);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
