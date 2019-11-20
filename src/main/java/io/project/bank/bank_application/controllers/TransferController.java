package io.project.bank.bank_application.controllers;

import io.project.bank.bank_application.models.Customer;
import io.project.bank.bank_application.models.Transfer;
import io.project.bank.bank_application.repository.CustomerRepository;
import io.project.bank.bank_application.repository.TransferRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private TransferRepository transferRepository;

    public TransferController(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Transfer getTransferById(@PathVariable("id") ObjectId id) {

        return transferRepository.findBy_id(id);
    }
    
}
