package com.skcc.wallet.framework.api.http.model;

public class Denomination {
    private long amount = 0;
    private String denomId = null;
    private String name = null;

    public long getAmount() {
        return this.amount;
    }

    public String getDenomId() {
        return this.denomId;
    }

    public String getName() {
        return this.name;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setDenomId(String str) {
        this.denomId = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
