package com.skcc.wallet.framework.api.http.model;

public class Conditions {
    private Integer count;
    private String endDate;
    private String startDate;
    private Integer tid;

    public Integer getCount() {
        return this.count;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public Integer getTid() {
        return this.tid;
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public void setTid(Integer num) {
        this.tid = num;
    }
}
