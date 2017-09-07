package com.skcc.wallet.framework.api.http.model;

public class TcashTransaction {
    private String amount;
    private String destinationNo;
    private String fee;
    private String info;
    private String transactionDate;
    private String transactionId;
    private String type;

    public String getAmount() {
        return this.amount;
    }

    public String getDestinationNo() {
        return this.destinationNo;
    }

    public String getFee() {
        return this.fee;
    }

    public String getInfo() {
        return this.info;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getType() {
        return this.type;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setDestinationNo(String str) {
        this.destinationNo = str;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setTransactionDate(String str) {
        this.transactionDate = str;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
