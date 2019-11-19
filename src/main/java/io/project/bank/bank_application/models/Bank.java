package io.project.bank.bank_application.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Bank {

    @Id
    private ObjectId _id;
    private String name;
    private ObjectId customer1;
    private ObjectId customer2;
    private ObjectId account1;
    private ObjectId account2;

    public Bank() {
    }

    public Bank(ObjectId _id, String name, ObjectId customer1, ObjectId customer2, ObjectId account1, ObjectId account2) {
        this._id = _id;
        this.name = name;
        this.customer1 = customer1;
        this.customer2 = customer2;
        this.account1 = account1;
        this.account2 = account2;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getCustomer1() {
        return customer1;
    }

    public void setCustomer1(ObjectId customer1) {
        this.customer1 = customer1;
    }

    public ObjectId getCustomer2() {
        return customer2;
    }

    public void setCustomer2(ObjectId customer2) {
        this.customer2 = customer2;
    }

    public ObjectId getAccount1() {
        return account1;
    }

    public void setAccount1(ObjectId account1) {
        this.account1 = account1;
    }

    public ObjectId getAccount2() {
        return account2;
    }

    public void setAccount2(ObjectId account2) {
        this.account2 = account2;
    }
}
