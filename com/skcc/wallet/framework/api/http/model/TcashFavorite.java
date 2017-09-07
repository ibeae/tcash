package com.skcc.wallet.framework.api.http.model;

import java.io.Serializable;

public class TcashFavorite implements Serializable {
    private static final long serialVersionUID = 1;
    private long amount;
    private String bankCode;
    private String destinationNo;
    private String favoriteMenuId;
    private String favoriteMenuName;
    private String menuId;
    private String period;
    private String regionId;
    private String startDate;

    public long getAmount() {
        return this.amount;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getDestinationNo() {
        return this.destinationNo;
    }

    public String getFavoriteMenuId() {
        return this.favoriteMenuId;
    }

    public String getFavoriteMenuName() {
        return this.favoriteMenuName;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public String getPeriod() {
        return this.period;
    }

    public String getRegionId() {
        return this.regionId;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public void setDestinationNo(String str) {
        this.destinationNo = str;
    }

    public void setFavoriteMenuId(String str) {
        this.favoriteMenuId = str;
    }

    public void setFavoriteMenuName(String str) {
        this.favoriteMenuName = str;
    }

    public void setMenuId(String str) {
        this.menuId = str;
    }

    public void setPeriod(String str) {
        this.period = str;
    }

    public void setRegionId(String str) {
        this.regionId = str;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }
}
