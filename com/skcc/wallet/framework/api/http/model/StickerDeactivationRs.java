package com.skcc.wallet.framework.api.http.model;

public class StickerDeactivationRs extends ResultRs {
    private String serialNumber;
    private String stickerUid;

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getStickerUid() {
        return this.stickerUid;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public void setStickerUid(String str) {
        this.stickerUid = str;
    }
}
