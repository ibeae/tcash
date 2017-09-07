package com.skcc.wallet.framework.api.http.model;

import java.io.Serializable;

public class ServiceVo implements Serializable {
    private static final long serialVersionUID = -4029187046014141169L;
    private String cardType;
    private String defaultYn;
    private String description;
    private String deviceAppletId;
    private String imgUrl;
    private String name;
    private String nfcYn;
    private String providerId;
    private String providerName;
    private String serviceId;
    private String status;
    private String tnc;

    public String getCardType() {
        return this.cardType;
    }

    public String getDefaultYn() {
        return this.defaultYn;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceAppletId() {
        return this.deviceAppletId;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getName() {
        return this.name;
    }

    public String getNfcYn() {
        return this.nfcYn;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTnc() {
        return this.tnc;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public void setDefaultYn(String str) {
        this.defaultYn = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDeviceAppletId(String str) {
        this.deviceAppletId = str;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNfcYn(String str) {
        this.nfcYn = str;
    }

    public void setProviderId(String str) {
        this.providerId = str;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTnc(String str) {
        this.tnc = str;
    }
}
