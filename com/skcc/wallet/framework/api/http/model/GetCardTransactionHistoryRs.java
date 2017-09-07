package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetCardTransactionHistoryRs extends ResultRs {
    private List<NfcHistoryVo> histories;

    public List<NfcHistoryVo> getHistories() {
        return this.histories;
    }

    public void setHistories(List<NfcHistoryVo> list) {
        this.histories = list;
    }
}
