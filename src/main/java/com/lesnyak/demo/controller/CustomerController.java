package com.lesnyak.demo.controller;


import com.lesnyak.demo.entity.Customer;
import com.lesnyak.demo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/all", "/", "/addAllList"})
    public String getAll(Model model) {
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/allSort")
    public String getSortByName(Model model) {
        List<Customer> customers = customerService.sortByName();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/add")
    public String addCustomer(Model model) {
            model.addAttribute("customer", new Customer());
        return "add-customer";
    }

    @GetMapping("/edit/{id}")
    public String addCustomerById(Model model, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            Customer customer = customerService.getCustomerById(id.get());
            model.addAttribute("customer", customer);
        }
        return "add-customer";
    }

    @PostMapping(path = "createOrUpdateCustomer")
    public String createOrUpdateCustomer(Customer customer) {
        logger.info("Last Name input " + customer.getLastName());
        if(customer.getId() != null) {
            customerService.update(customer);
        }
            customerService.save(customer);
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomerById(@PathVariable("id") Long id) {
        logger.info("delete the customer, id: " + id);
        customerService.delete(id);
        return "redirect:/all";
    }
}
