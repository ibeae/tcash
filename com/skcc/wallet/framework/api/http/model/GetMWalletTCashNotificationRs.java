package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetMWalletTCashNotificationRs extends ResultRs {
    private List<TCashNotification> tcashNotifications;

    public List<TCashNotification> getTCashNotifications() {
        return this.tcashNotifications;
    }

    public void setTCashNotifications(List<TCashNotification> list) {
        this.tcashNotifications = list;
    }
}
