package com.lesnyak.demo.service;


import com.lesnyak.demo.entity.Customer;
import com.lesnyak.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    public void delete(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public Customer getCustomerById (Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            return customer.get();
        }
        return null;
    }

    public Customer update(Customer newCustomer) {
        Optional<Customer> oldCustomer = customerRepository.findById(newCustomer.getId());
        Customer c = oldCustomer.get();
        if (oldCustomer.isPresent()) {
            c.setFirstName(newCustomer.getFirstName());
            c.setLastName(newCustomer.getLastName());
            c.setEmail(newCustomer.getEmail());
        }
        return customerRepository.save(c);
    }

    public List<Customer> sortByName () {
        return getAll().stream()
                .sorted(Comparator.comparing(Customer::getFirstName))
                .collect(Collectors.toList());
    }
}
