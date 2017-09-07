package com.skcc.wallet.core.se.instance;

public class CustomerPayTransaction {
    private String merchant = null;
    private String transactionAmount = null;
    private String transactionDate = null;
    private String transactionType = null;

    public String getMerchant() {
        return this.merchant;
    }

    public String getTransactionAmount() {
        return this.transactionAmount;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public void setMerchant(String str) {
        this.merchant = str;
    }

    public void setTransactionAmount(String str) {
        this.transactionAmount = str;
    }

    public void setTransactionDate(String str) {
        this.transactionDate = str;
    }

    public void setTransactionType(String str) {
        this.transactionType = str;
    }

    public String toString() {
        return "transactionDate::" + this.transactionDate + ", " + "transactionType::" + this.transactionType + ", " + "merchant::" + this.merchant + ", " + "transactionAmount::" + this.transactionAmount + "\n";
    }
}
