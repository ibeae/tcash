package com.skcc.wallet.framework.api.http.model;

public class GetMsisdnRq {
    private String imei = null;
    private String imsi = null;

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }
}
