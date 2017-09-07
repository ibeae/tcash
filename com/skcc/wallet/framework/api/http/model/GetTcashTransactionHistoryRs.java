package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetTcashTransactionHistoryRs extends ResultRs {
    private List<TcashTransaction> transactions;

    public List<TcashTransaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(List<TcashTransaction> list) {
        this.transactions = list;
    }
}
