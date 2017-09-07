package com.skcc.wallet.framework.api.http.model;

import java.io.Serializable;

public class TopupInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private String balanceLevel;
    private String topupAmount;
    private Integer topupType;

    public String getBalanceLevel() {
        return this.balanceLevel;
    }

    public String getTopupAmount() {
        return this.topupAmount;
    }

    public Integer getTopupType() {
        return this.topupType;
    }

    public void setBalanceLevel(String str) {
        this.balanceLevel = str;
    }

    public void setTopupAmount(String str) {
        this.topupAmount = str;
    }

    public void setTopupType(Integer num) {
        this.topupType = num;
    }
}
