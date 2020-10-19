package com.control;

import com.store.CustomerDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerDB store;

    @Autowired
    public CustomerController(CustomerDB store) {
        this.store = store;
    }

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("customer_list", store.getCustomers());
        return "list-customers";
    }
}
