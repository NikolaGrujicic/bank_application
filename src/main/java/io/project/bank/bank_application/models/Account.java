package io.project.bank.bank_application.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Account {
    @Id
    private ObjectId _id;
    private String accountName;
    private String bankName;
    private ObjectId bankId;
    private String customerName;
    private ObjectId customerId;
    private int money;

    public Account() {
    }

    public Account(ObjectId _id,String accountName, String bankName, ObjectId bankId, String customerName, ObjectId customerId, int money) {
        this._id = _id;
        this.accountName = accountName;
        this.bankName = bankName;
        this.bankId = bankId;
        this.customerName = customerName;
        this.customerId = customerId;
        this.money = money;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ObjectId getBankId() {
        return bankId;
    }

    public void setBankId(ObjectId bankId) {
        this.bankId = bankId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ObjectId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(ObjectId customerId) {
        this.customerId = customerId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
