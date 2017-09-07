package com.skcc.wallet.framework.api.http.model;

public class ReportEligibilityFailRq {
    private String imei = null;
    private String imsi = null;
    private String modelName = null;
    private String msisdn = null;
    private String stackTrace = null;

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getModelName() {
        return this.modelName;
    }

    public String getMsisdn() {
        return this.msisdn;
    }

    public String getStackTrace() {
        return this.stackTrace;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public void setMsisdn(String str) {
        this.msisdn = str;
    }

    public void setStackTrace(String str) {
        this.stackTrace = str;
    }
}
