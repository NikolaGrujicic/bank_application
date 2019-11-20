package io.project.bank.bank_application;

import io.project.bank.bank_application.controllers.AccountController;
import io.project.bank.bank_application.models.Account;
import io.project.bank.bank_application.models.Transfer;
import io.project.bank.bank_application.repository.AccountRepository;
import io.project.bank.bank_application.repository.TransferRepository;
import org.assertj.core.api.Assertions;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BankApplicationTests {

	public AccountController accountController;

	@Mock
	AccountRepository accountRepository;

	@Mock
	TransferRepository transferRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		}


	@Test
	public void IntraBankTransferTest() throws Throwable {
		ObjectId accountIdA = ObjectId.get();
		ObjectId accountIdB = ObjectId.get();
		ObjectId customerIdA = ObjectId.get();
		ObjectId customerIdB = ObjectId.get();
		ObjectId bankIdA = ObjectId.get();

		Account account1 = new Account(accountIdA, "Account A", "Bank A", bankIdA, "Customer A", customerIdA, 1000);
		Account account2 = new Account(accountIdB, "Account B", "Bank A", bankIdA, "Customer B", customerIdB, 2000);

		Transfer transfer = new Transfer(ObjectId.get(), accountIdA, accountIdB, 200, 5, "success", "");

		Mockito.when(accountRepository.findBy_id(transfer.getAccountAid())).thenReturn(account1);
		Mockito.when(accountRepository.findBy_id(transfer.getAccountBid())).thenReturn(account2);

		Mockito.when(accountRepository.save(account1)).thenReturn(account1);
		Mockito.when(accountRepository.save(account2)).thenReturn(account2);

		Mockito.when(transferRepository.save(Mockito.isA(Transfer.class))).thenReturn(transfer);

		accountController = new AccountController(accountRepository, transferRepository);

		Transfer transferResult = accountController.transferMoney(transfer);

		Assertions.assertThat(transferResult).isNotNull();
	}


	@Test
	public void InterBankTransferTest() throws Throwable {
		ObjectId accountIdA = ObjectId.get();
		ObjectId accountIdB = ObjectId.get();
		ObjectId customerIdA = ObjectId.get();
		ObjectId customerIdB = ObjectId.get();
		ObjectId bankIdA = ObjectId.get();
		ObjectId bankIdB = ObjectId.get();

		Account account1 = new Account(accountIdA, "Account A", "Bank A", bankIdA, "Customer A", customerIdA, 1000);
		Account account2 = new Account(accountIdB, "Account B", "Bank A", bankIdB, "Customer B", customerIdB, 2000);

		Transfer transfer = new Transfer(ObjectId.get(), accountIdA, accountIdB, 200, 5, "success", "");

		Mockito.when(accountRepository.findBy_id(transfer.getAccountAid())).thenReturn(account1);
		Mockito.when(accountRepository.findBy_id(transfer.getAccountBid())).thenReturn(account2);

		Mockito.when(accountRepository.save(account1)).thenReturn(account1);
		Mockito.when(accountRepository.save(account2)).thenReturn(account2);

		Mockito.when(transferRepository.save(Mockito.isA(Transfer.class))).thenReturn(transfer);

		accountController = new AccountController(accountRepository, transferRepository);

		Transfer transferResult = accountController.transferMoney(transfer);

		Assertions.assertThat(transferResult).isNotNull();
	}

	@Test
	public void InterBankTransferFailTest() throws Throwable {
		ObjectId accountIdA = ObjectId.get();
		ObjectId accountIdB = ObjectId.get();
		ObjectId customerIdA = ObjectId.get();
		ObjectId customerIdB = ObjectId.get();
		ObjectId bankIdA = ObjectId.get();
		ObjectId bankIdB = ObjectId.get();

		Account account1 = new Account(accountIdA, "Account A", "Bank A", bankIdA, "Customer A", customerIdA, 10000);
		Account account2 = new Account(accountIdB, "Account B", "Bank A", bankIdB, "Customer B", customerIdB, 20000);

		Transfer transfer = new Transfer(ObjectId.get(), accountIdA, accountIdB, 2000, 5, "success", "");

		Mockito.when(accountRepository.findBy_id(transfer.getAccountAid())).thenReturn(account1);
		Mockito.when(accountRepository.findBy_id(transfer.getAccountBid())).thenReturn(account2);

		Mockito.when(accountRepository.save(account1)).thenReturn(account1);
		Mockito.when(accountRepository.save(account2)).thenReturn(account2);

		Mockito.when(transferRepository.save(Mockito.isA(Transfer.class))).thenReturn(transfer);

		accountController = new AccountController(accountRepository, transferRepository);

		Transfer transferResult = accountController.transferMoney(transfer);

		Assertions.assertThat(transferResult).isNotNull();
	}

}
