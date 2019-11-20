package io.project.bank.bank_application.controllers;

import io.project.bank.bank_application.models.Account;
import io.project.bank.bank_application.models.Transfer;
import io.project.bank.bank_application.repository.AccountRepository;
import io.project.bank.bank_application.repository.TransferRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountRepository accountRepository;

    private TransferRepository transferRepository;



    public AccountController(AccountRepository accountRepository, TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @GetMapping(value = "/getAll")
    public List<Account> getAllBanks() {
        return accountRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Account getAccountById(@PathVariable("id") ObjectId id)
    {
        return accountRepository.findBy_id(id);
    }

    @PostMapping(path = "/transfer", consumes = "application/json", produces = "application/json")
    public Transfer transferMoney( @RequestBody Transfer transfer) {
        Transfer newTransfer = new Transfer();
        try {
            Account account1 = new Account();
            Account account2 = new Account();

            account1 = accountRepository.findBy_id(transfer.getAccountAid());

            account2 = accountRepository.findBy_id(transfer.getAccountBid());

            accountRepository.save(account1);
            accountRepository.save(account2);

            int amountToTranfer = transfer.getAmountToTranfer();

            int commision = 0;

            String message = "success";
            String transferType = "";

            int accountBalance1 = account1.getMoney();
            int accountBalance2 = account2.getMoney();

            ObjectId account1BankId = account1.getBankId();
            ObjectId account2BankId = account2.getBankId();

            if(account1BankId.equals(account2BankId)) {
                accountBalance1 = accountBalance1 - amountToTranfer;
                accountBalance2 = accountBalance2 + amountToTranfer;
                message = "success";
                transferType = "Intra-bank transfer";
            } else if (amountToTranfer <= 1000){
                commision = 5;
                accountBalance1 = accountBalance1 - amountToTranfer - commision;
                accountBalance2 = accountBalance2 + amountToTranfer;
                transferType = "Inter-bank transfer";
            } else {
                accountBalance1 = account1.getMoney();
                accountBalance2 = account2.getMoney();
                amountToTranfer = 0;
                message = "cannot transfer more than 1000$ to foreign account";
                transferType = "Inter-bank transfer";
            }

            account1.setMoney(accountBalance1);
            account2.setMoney(accountBalance2);

            accountRepository.save(account1);
            accountRepository.save(account2);

            newTransfer = new Transfer(ObjectId.get(), account1.get_id(), account2.get_id(), amountToTranfer, commision, message, transferType);

            transferRepository.save(newTransfer);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return newTransfer;
    }



}
