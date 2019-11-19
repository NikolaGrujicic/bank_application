package io.project.bank.bank_application.repository;

import io.project.bank.bank_application.models.Account;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
    Account findBy_id(ObjectId id);
}
