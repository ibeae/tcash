package com.skcc.wallet.framework.api.http.model;

public class GetTcashTopupInfoRs extends ResultRs {
    private SmsBank smsBank;

    public SmsBank getSmsBank() {
        return this.smsBank;
    }

    public void setSmsBank(SmsBank smsBank) {
        this.smsBank = smsBank;
    }
}
