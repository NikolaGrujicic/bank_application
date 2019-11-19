package io.project.bank.bank_application.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Customer {

    @Id
    private ObjectId _id;
    private String name;
    private ObjectId bank1;
    private ObjectId bank2;
    private ObjectId account1;
    private ObjectId account2;

    public Customer() {
    }

    public Customer(ObjectId _id, String name, ObjectId bank1, ObjectId bank2, ObjectId account1, ObjectId account2) {
        this._id = _id;
        this.name = name;
        this.bank1 = bank1;
        this.bank2 = bank2;
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

    public ObjectId getBank1() {
        return bank1;
    }

    public void setBank1(ObjectId bank1) {
        this.bank1 = bank1;
    }

    public ObjectId getBank2() {
        return bank2;
    }

    public void setBank2(ObjectId bank2) {
        this.bank2 = bank2;
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
