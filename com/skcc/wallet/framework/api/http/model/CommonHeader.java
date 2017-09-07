package com.skcc.wallet.framework.api.http.model;

public class CommonHeader {
    private String customerId = null;
    private String locale = null;
    private String msisdn = null;
    private String pin = null;
    private String tid = null;

    public CommonHeader(String str) {
        this.tid = str;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getMsisdn() {
        return this.msisdn;
    }

    public String getPin() {
        return this.pin;
    }

    public String getTid() {
        return this.tid;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    public void setMsisdn(String str) {
        this.msisdn = str;
    }

    public void setPin(String str) {
        this.pin = str;
    }

    public void setTid(String str) {
        this.tid = str;
    }
}
