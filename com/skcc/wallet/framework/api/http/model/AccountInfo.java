package com.skcc.wallet.framework.api.http.model;

import java.io.Serializable;

public class AccountInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private String accountName;
    private String accountNumber;
    private String bsb;

    public String getAccountName() {
        return this.accountName;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getBsb() {
        return this.bsb;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public void setBsb(String str) {
        this.bsb = str;
    }
}
