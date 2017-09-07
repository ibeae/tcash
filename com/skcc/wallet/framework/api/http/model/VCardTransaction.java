package com.skcc.wallet.framework.api.http.model;

public class VCardTransaction {
    private String amount;
    private String transactionDate;

    public String getAmount() {
        return this.amount;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setTransactionDate(String str) {
        this.transactionDate = str;
    }
}
