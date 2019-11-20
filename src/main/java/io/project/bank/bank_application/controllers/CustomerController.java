package io.project.bank.bank_application.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.project.bank.bank_application.models.Account;
import io.project.bank.bank_application.models.Customer;
import io.project.bank.bank_application.repository.AccountRepository;
import io.project.bank.bank_application.repository.BankRepository;
import io.project.bank.bank_application.repository.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/getAll")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomerById(@PathVariable("id") ObjectId id) {

        return customerRepository.findBy_id(id);
    }
    
}
