package io.project.bank.bank_application.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.project.bank.bank_application.models.Account;
import io.project.bank.bank_application.models.Customer;
import io.project.bank.bank_application.repository.AccountRepository;
import io.project.bank.bank_application.repository.BankRepository;
import io.project.bank.bank_application.repository.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") ObjectId id) {

        return customerRepository.findBy_id(id);
    }
    
}
