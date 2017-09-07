package com.skcc.wallet.framework.api.http.model;

public class BankCode {
    private String bankCode = null;
    private String bankName = null;
    private String displayName = null;

    public BankCode(String str, String str2, String str3) {
        this.bankCode = str;
        this.bankName = str2;
        this.displayName = str3;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }
}
