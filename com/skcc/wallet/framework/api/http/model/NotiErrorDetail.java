package com.skcc.wallet.framework.api.http.model;

import java.io.Serializable;

public class NotiErrorDetail implements Serializable {
    private static final long serialVersionUID = 1;
    private String amount;
    private String date;
    private String details;
    private String time;

    public String getAmount() {
        return this.amount;
    }

    public String getDate() {
        return this.date;
    }

    public String getDetails() {
        return this.details;
    }

    public String getTime() {
        return this.time;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDetails(String str) {
        this.details = str;
    }

    public void setTime(String str) {
        this.time = str;
    }
}
