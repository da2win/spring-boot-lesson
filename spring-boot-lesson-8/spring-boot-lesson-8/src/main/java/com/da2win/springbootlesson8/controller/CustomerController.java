package com.da2win.springbootlesson8.controller;

import com.da2win.springbootlesson8.entity.Customer;
import com.da2win.springbootlesson8.repository.CustomerRepository;
import com.da2win.springbootlesson8.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/all")
    public List<Customer> loadCustomers() {
        return customerRepository.findAll();
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        Long id = customer.getId();
        return customerService.getCustomerById(id);
    }
}
