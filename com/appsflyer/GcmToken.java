package com.appsflyer;

class GcmToken {
    private static final int TOKEN_AGING_TIME = 2000;
    private String instanceId;
    private String token;
    private long tokenTimestamp;

    public GcmToken(long j, String str, String str2) {
        this.tokenTimestamp = j;
        this.token = str;
        this.instanceId = str2;
    }

    public GcmToken(String str, String str2, String str3) {
        if (str == null) {
            this.tokenTimestamp = 0;
        } else {
            this.tokenTimestamp = Long.valueOf(str).longValue();
        }
        this.token = str2;
        this.instanceId = str3;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getToken() {
        return this.token;
    }

    public long getTokenTimestamp() {
        return this.tokenTimestamp;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTokenTimestamp(long j) {
        this.tokenTimestamp = j;
    }

    public String toString() {
        return this.tokenTimestamp + "," + this.token + "," + this.instanceId;
    }

    public boolean update(long j, String str, String str2) {
        if (str.equals(this.token) || j - this.tokenTimestamp <= 2000) {
            return false;
        }
        this.tokenTimestamp = j;
        this.token = str;
        this.instanceId = str2;
        return true;
    }

    public boolean update(GcmToken gcmToken) {
        return update(gcmToken.getTokenTimestamp(), gcmToken.getToken(), gcmToken.getInstanceId());
    }
}
