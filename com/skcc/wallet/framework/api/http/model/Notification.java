package com.skcc.wallet.framework.api.http.model;

import java.io.Serializable;

public class Notification implements Serializable {
    private static final long serialVersionUID = 1;
    private String content;
    private String createdDate;
    private String notificationId;
    private String title;

    public String getContent() {
        return this.content;
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public String getNotificationId() {
        return this.notificationId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreatedDate(String str) {
        this.createdDate = str;
    }

    public void setNotificationId(String str) {
        this.notificationId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
