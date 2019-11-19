package io.project.bank.bank_application.repository;

import io.project.bank.bank_application.models.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findBy_id(ObjectId id);
}
