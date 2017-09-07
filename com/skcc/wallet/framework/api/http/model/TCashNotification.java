package com.skcc.wallet.framework.api.http.model;

import java.io.Serializable;

public class TCashNotification implements Serializable {
    private static final long serialVersionUID = 1;
    private String content;
    private String tCashNotificationId;
    private String title;

    public String getContent() {
        return this.content;
    }

    public String getTCashNotificationId() {
        return this.tCashNotificationId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setTCashNotificationId(String str) {
        this.tCashNotificationId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
