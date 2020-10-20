package com.control;

import com.model.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("customer_list", service.getCustomers());
        return "list-customers";
    }

    @GetMapping("/add")
    public String createPage(Model model) {
        model.addAttribute("title", "Create Customer");
        model.addAttribute("customer", new Customer());
        return "edit";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") int id, Model model) {
        model.addAttribute("title", "Edit Customer");
        model.addAttribute("customer", service.getCustomer(id));
        return "edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer) {
        service.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        service.delete(service.getCustomer(id));
        return "redirect:/customer/list";
    }
}
