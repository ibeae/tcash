package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetVCardTransactionRs extends MyCardResult {
    private List<VCardTransaction> transactions;

    public List<VCardTransaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(List<VCardTransaction> list) {
        this.transactions = list;
    }
}
