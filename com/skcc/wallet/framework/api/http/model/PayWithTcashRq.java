package com.skcc.wallet.framework.api.http.model;

public class PayWithTcashRq {
    private CommonHeader commonHeader;
    private TcashTransactionRequest tcashTransactionRequest;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public TcashTransactionRequest getTcashTransactionRequest() {
        return this.tcashTransactionRequest;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setTcashTransactionRequest(TcashTransactionRequest tcashTransactionRequest) {
        this.tcashTransactionRequest = tcashTransactionRequest;
    }
}
