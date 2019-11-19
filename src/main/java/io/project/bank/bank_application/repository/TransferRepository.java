package io.project.bank.bank_application.repository;

import io.project.bank.bank_application.models.Account;
import io.project.bank.bank_application.models.Transfer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransferRepository extends MongoRepository<Transfer, String> {
    Transfer findBy_id(ObjectId id);
}
