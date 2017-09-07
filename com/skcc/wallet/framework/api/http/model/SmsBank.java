package com.skcc.wallet.framework.api.http.model;

public class SmsBank {
    private String amount = null;
    private String bankCode = null;
    private String destinationName = null;
    private String destinationNo = null;

    public String getAmount() {
        return this.amount;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getDestinationName() {
        return this.destinationName;
    }

    public String getDestinationNo() {
        return this.destinationNo;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public void setDestinationName(String str) {
        this.destinationName = str;
    }

    public void setDestinationNo(String str) {
        this.destinationNo = str;
    }
}
