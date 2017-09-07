package com.skcc.wallet.framework.api.http.model;

import java.io.Serializable;

public class MCashTransactionDetail implements Serializable {
    private static final long serialVersionUID = 1;
    private String curr;
    private String date;
    private NameData[] nameDataList;
    private String tid;
    private String time;

    public String getCurr() {
        return this.curr;
    }

    public String getDate() {
        return this.date;
    }

    public NameData[] getNameDataList() {
        return this.nameDataList;
    }

    public String getTid() {
        return this.tid;
    }

    public String getTime() {
        return this.time;
    }

    public void setCurr(String str) {
        this.curr = str;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setNameDataList(NameData[] nameDataArr) {
        this.nameDataList = nameDataArr;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setTime(String str) {
        this.time = str;
    }
}
