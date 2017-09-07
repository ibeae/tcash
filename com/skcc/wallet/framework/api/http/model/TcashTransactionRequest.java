package com.skcc.wallet.framework.api.http.model;

import java.util.Map;

public class TcashTransactionRequest {
    private long amount;
    private String bankCode;
    private String denomId;
    private String destinationNo;
    private Map<String, String> etcParam;
    private String fee;
    private String menuId;
    private String regionId;
    private String tcashPin;
    private String tcashTransactionId;
    private String transferTypeId;

    public long getAmount() {
        return this.amount;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getDenomId() {
        return this.denomId;
    }

    public String getDestinationNo() {
        return this.destinationNo;
    }

    public Map<String, String> getEtcParam() {
        return this.etcParam;
    }

    public String getFee() {
        return this.fee;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public String getRegionId() {
        return this.regionId;
    }

    public String getTcashPin() {
        return this.tcashPin;
    }

    public String getTcashTransactionId() {
        return this.tcashTransactionId;
    }

    public String getTransferTypeId() {
        return this.transferTypeId;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public void setDenomId(String str) {
        this.denomId = str;
    }

    public void setDestinationNo(String str) {
        this.destinationNo = str;
    }

    public void setEtcParam(Map<String, String> map) {
        this.etcParam = map;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setMenuId(String str) {
        this.menuId = str;
    }

    public void setRegionId(String str) {
        this.regionId = str;
    }

    public void setTcashPin(String str) {
        this.tcashPin = str;
    }

    public void setTcashTransactionId(String str) {
        this.tcashTransactionId = str;
    }

    public void setTransferTypeId(String str) {
        this.transferTypeId = str;
    }
}
