package com.skcc.wallet.framework.api.http.model;

public class PurchaseWithTcashRs extends ResultRs {
    private TcashTransaction tcashTransaction;

    public TcashTransaction getTcashTransaction() {
        return this.tcashTransaction;
    }

    public void setTcashTransaction(TcashTransaction tcashTransaction) {
        this.tcashTransaction = tcashTransaction;
    }
}
