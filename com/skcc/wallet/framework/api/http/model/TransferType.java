package com.skcc.wallet.framework.api.http.model;

public class TransferType {
    private String name = null;
    private String transferTypeId = null;

    public TransferType(String str, String str2) {
        this.name = str;
        this.transferTypeId = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getTransferTypeId() {
        return this.transferTypeId;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTransferTypeId(String str) {
        this.transferTypeId = str;
    }
}
