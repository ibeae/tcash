package com.skcc.wallet.framework.api.http.model;

public class NfcActivationRs extends ResultRs {
    private String serialNumber;

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }
}
