package com.skcc.wallet.framework.api.http.model;

public class CheckWalletUpdateRs extends ResultRs {
    private String appDownloadUrl;
    private String appStoreUrl;
    private String timestamp;
    private String updateOptionYn;
    private String updateYn;
    private String version;

    public String getAppDownloadUrl() {
        return this.appDownloadUrl;
    }

    public String getAppStoreUrl() {
        return this.appStoreUrl;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getUpdateOptionYn() {
        return this.updateOptionYn;
    }

    public String getUpdateYn() {
        return this.updateYn;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppDownloadUrl(String str) {
        this.appDownloadUrl = str;
    }

    public void setAppStoreUrl(String str) {
        this.appStoreUrl = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setUpdateOptionYn(String str) {
        this.updateOptionYn = str;
    }

    public void setUpdateYn(String str) {
        this.updateYn = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
