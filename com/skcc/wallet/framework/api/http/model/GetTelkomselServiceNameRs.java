package com.skcc.wallet.framework.api.http.model;

public class GetTelkomselServiceNameRs extends ResultRs {
    private String serviceName = null;

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }
}
