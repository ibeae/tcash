package com.skcc.wallet.framework.api.http.model;

public class ChangeMWalletPinRq {
    private CommonHeader commonHeader;
    private String encryptedToken;
    private String token;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getEncryptedToken() {
        return this.encryptedToken;
    }

    public String getToken() {
        return this.token;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setEncryptedToken(String str) {
        this.encryptedToken = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
