package com.skcc.wallet.framework.api.http.model;

public class MobileInfo {
    private String imei = null;
    private String imsi = null;
    private String modelNo = null;
    private String osVer = null;
    private String pushId = null;
    private String pushType = "GCM";
    private String walletVersion = null;

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getModelNo() {
        return this.modelNo;
    }

    public String getOsVer() {
        return this.osVer;
    }

    public String getPushId() {
        return this.pushId;
    }

    public String getPushType() {
        return this.pushType;
    }

    public String getWalletVersion() {
        return this.walletVersion;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setModelNo(String str) {
        this.modelNo = str;
    }

    public void setOsVer(String str) {
        this.osVer = str;
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    public void setWalletVersion(String str) {
        this.walletVersion = str;
    }
}
