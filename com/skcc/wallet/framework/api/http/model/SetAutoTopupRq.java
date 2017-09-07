package com.skcc.wallet.framework.api.http.model;

public class SetAutoTopupRq {
    private Double balanceLevel;
    private CommonHeader commonHeader;
    private Double topupAmount;
    private Integer topupType;

    public Double getBalanceLevel() {
        return this.balanceLevel;
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public Double getTopupAmount() {
        return this.topupAmount;
    }

    public Integer getTopupType() {
        return this.topupType;
    }

    public void setBalanceLevel(Double d) {
        this.balanceLevel = d;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setTopupAmount(Double d) {
        this.topupAmount = d;
    }

    public void setTopupType(Integer num) {
        this.topupType = num;
    }
}
