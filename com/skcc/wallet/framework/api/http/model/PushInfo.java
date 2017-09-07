package com.skcc.wallet.framework.api.http.model;

public class PushInfo {
    private String pushId = null;
    private String pushType = null;

    public PushInfo(String str, String str2) {
    }

    public String getPushId() {
        return this.pushId;
    }

    public String getPushType() {
        return this.pushType;
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    public void setPushType(String str) {
        this.pushType = str;
    }
}
