package io.project.bank.bank_application.repository;

import io.project.bank.bank_application.models.Bank;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRepository extends MongoRepository<Bank, String> {
    Bank findBy_id(ObjectId id);
}
