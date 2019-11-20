package io.project.bank.bank_application.controllers;

import io.project.bank.bank_application.models.Customer;
import io.project.bank.bank_application.models.Transfer;
import io.project.bank.bank_application.repository.CustomerRepository;
import io.project.bank.bank_application.repository.TransferRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private TransferRepository transferRepository;

    public TransferController(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @GetMapping(value = "/getAll")
    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Transfer getTransferById(@PathVariable("id") ObjectId id) {
        return transferRepository.findBy_id(id);
    }
    
}
