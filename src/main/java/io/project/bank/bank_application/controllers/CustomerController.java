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

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BankRepository bankRepository;

    public Customer customerMarko;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") ObjectId id) {

        return customerRepository.findBy_id(id);
    }



    @RequestMapping(value = "/{customerId}/{accountId}", method = RequestMethod.PUT)
    public Customer tranferMoney(@PathVariable("customerId") ObjectId customerId,@PathVariable("accountId") ObjectId accountId) {
        Customer customer = customerRepository.findBy_id(customerId);
        Account customerAccount = accountRepository.findBy_id(customer.getAccount1());
        int accountBalance = customerAccount.getMoney();
        int newAccountBalance = accountBalance - 200;

        customerAccount.setMoney(newAccountBalance);
        accountRepository.save(customerAccount);

        return customer;
    }
}
