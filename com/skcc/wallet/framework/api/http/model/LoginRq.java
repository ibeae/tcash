package com.skcc.wallet.framework.api.http.model;

public class LoginRq {
    private String cMac;
    private CommonHeader commonHeader;
    private String imei;
    private String imsi;
    private String pushId;
    private String token;

    public String getCMac() {
        return this.cMac;
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getPushId() {
        return this.pushId;
    }

    public String getToken() {
        return this.token;
    }

    public void setCMac(String str) {
        this.cMac = str;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
