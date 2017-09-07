package com.skcc.wallet.framework.api.http.model;

public class GetTcashBalanceRs extends ResultRs {
    private int newNoticeCount;
    private long tcashBalance;

    public int getNewNoticeCount() {
        return this.newNoticeCount;
    }

    public long getTcashBalance() {
        return this.tcashBalance;
    }

    public void setNewNoticeCount(int i) {
        this.newNoticeCount = i;
    }

    public void setTcashBalance(long j) {
        this.tcashBalance = j;
    }
}
