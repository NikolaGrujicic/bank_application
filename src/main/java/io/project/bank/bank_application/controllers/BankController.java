package io.project.bank.bank_application.controllers;

import io.project.bank.bank_application.models.Bank;
import io.project.bank.bank_application.repository.BankRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    private BankRepository bankRepository;

    public BankController(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @GetMapping(value = "/getAll")
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Bank getBankById(@PathVariable("id") ObjectId id) {
        return bankRepository.findBy_id(id);
    }

}
