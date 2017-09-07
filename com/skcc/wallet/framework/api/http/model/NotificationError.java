package com.skcc.wallet.framework.api.http.model;

public class NotificationError {
    private String date;
    private String errorEventId;
    private String errorEventName;
    private String tid;
    private String time;

    public String getDate() {
        return this.date;
    }

    public String getErrorEventId() {
        return this.errorEventId;
    }

    public String getErrorEventName() {
        return this.errorEventName;
    }

    public String getTid() {
        return this.tid;
    }

    public String getTime() {
        return this.time;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setErrorEventId(String str) {
        this.errorEventId = str;
    }

    public void setErrorEventName(String str) {
        this.errorEventName = str;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setTime(String str) {
        this.time = str;
    }
}
