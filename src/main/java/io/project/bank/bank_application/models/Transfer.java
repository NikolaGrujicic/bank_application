package io.project.bank.bank_application.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Transfer {

    @Id
    private ObjectId _id;

    private ObjectId accountAid;
    private ObjectId accountBid;
    private int amountToTranfer;
    private int commision;
    private String message;
    private String transferType;

    public Transfer() {
    }

    public Transfer(ObjectId _id, ObjectId accountAid, ObjectId accountBid, int amountToTranfer, int commision, String message, String transferType) {
        this.amountToTranfer = amountToTranfer;
        this._id = _id;
        this.accountAid = accountAid;
        this.accountBid = accountBid;
        this.commision = commision;
        this.message = message;
        this.transferType = transferType;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCommision() {
        return commision;
    }

    public void setCommision(int commision) {
        this.commision = commision;
    }

    public int getAmountToTranfer() {
        return amountToTranfer;
    }

    public void setAmountToTranfer(int amountToTranfer) {
        this.amountToTranfer = amountToTranfer;
    }

    public ObjectId getTransferId() {
        return _id;
    }

    public void setTransferId(ObjectId _id) {
        this._id = _id;
    }

    public ObjectId getAccountAid() {
        return accountAid;
    }

    public void setAccountAid(ObjectId accountAid) {
        this.accountAid = accountAid;
    }

    public ObjectId getAccountBid() {
        return accountBid;
    }

    public void setAccountBid(ObjectId accountBid) {
        this.accountBid = accountBid;
    }
}
