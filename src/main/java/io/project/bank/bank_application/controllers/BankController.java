package io.project.bank.bank_application.controllers;

import io.project.bank.bank_application.models.Bank;
import io.project.bank.bank_application.repository.BankRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankRepository accountRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Bank getPetById(@PathVariable("id") ObjectId id) {
        return accountRepository.findBy_id(id);
    }
}
