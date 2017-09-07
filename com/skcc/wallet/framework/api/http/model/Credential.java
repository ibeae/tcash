package com.skcc.wallet.framework.api.http.model;

public class Credential {
    private String encryptedToken;
    private String imei;
    private String imsi;
    private String msisdn;
    private String token;

    public String getEncryptedToken() {
        return this.encryptedToken;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getMsisdn() {
        return this.msisdn;
    }

    public String getToken() {
        return this.token;
    }

    public void setEncryptedToken(String str) {
        this.encryptedToken = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setMsisdn(String str) {
        this.msisdn = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
