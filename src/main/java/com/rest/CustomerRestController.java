package com.rest;

import com.ex.CustomerNotFoundException;
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
    public Customer create(@RequestBody Customer customer) {
        customer.setId(0);
        service.save(customer);
        return customer;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getAll() {
        return service.getCustomers();
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Customer getById(@PathVariable int id) {
        Customer rsl = service.getCustomer(id);
        if(rsl == null) throw new CustomerNotFoundException("Not found customer by id: " + id);
        return rsl;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.PUT)
    public Customer update(@RequestBody Customer customer) {
        service.save(customer);
        return customer;
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id) {
        Customer rsl = service.getCustomer(id);
        if(rsl == null) throw new CustomerNotFoundException("Not found customer by id: " + id);
        service.delete(id);
        return "Deleted customer with id: " + id;
    }
}
