package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetMWalletNotificationRs extends ResultRs {
    private List<Notification> notifications;

    public List<Notification> getNotifications() {
        return this.notifications;
    }

    public void setNotifications(List<Notification> list) {
        this.notifications = list;
    }
}
