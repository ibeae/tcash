package com.skcc.wallet.framework.api.http.model;

import java.io.Serializable;

public class NfcHistoryVo implements Serializable {
    private static final long serialVersionUID = 1;
    private String amount;
    private String cardType;
    private String creationTime;
    private String customerId;
    private String deviceAppletId;
    private String serviceId;
    private String tid;

    public String getAmount() {
        return this.amount;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getCreationTime() {
        return this.creationTime;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getDeviceAppletId() {
        return this.deviceAppletId;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public String getTid() {
        return this.tid;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public void setCreationTime(String str) {
        this.creationTime = str;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public void setDeviceAppletId(String str) {
        this.deviceAppletId = str;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }

    public void setTid(String str) {
        this.tid = str;
    }
}
