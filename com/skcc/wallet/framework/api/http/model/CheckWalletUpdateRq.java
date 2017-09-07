package com.skcc.wallet.framework.api.http.model;

public class CheckWalletUpdateRq {
    private CommonHeader commonHeader;
    private String osType;
    private String version;
    private String walletId;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getOsType() {
        return this.osType;
    }

    public String getVersion() {
        return this.version;
    }

    public String getWalletId() {
        return this.walletId;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setOsType(String str) {
        this.osType = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setWalletId(String str) {
        this.walletId = str;
    }
}
