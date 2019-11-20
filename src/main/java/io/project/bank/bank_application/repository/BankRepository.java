package io.project.bank.bank_application.repository;

import io.project.bank.bank_application.models.Bank;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends MongoRepository<Bank, String> {
    Bank findBy_id(ObjectId id);
}
