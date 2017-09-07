package com.skcc.wallet.framework.api.http.model;

import com.facebook.AppEventsConstants;

public class GetTcashUserInfoRs extends ResultRs {
    private String isRegisteredBankUserYn = null;
    private String isRegisteredTcashUserYn = null;
    private String tcashBalance = null;
    private String tcashStatus = null;

    public String getIsRegisteredBankUserYn() {
        return this.isRegisteredBankUserYn;
    }

    public String getIsRegisteredTcashUserYn() {
        return this.isRegisteredTcashUserYn;
    }

    public String getTCashBalance() {
        return this.tcashBalance == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : this.tcashBalance;
    }

    public String getTCashStatus() {
        return this.tcashStatus;
    }

    public void setIsRegisteredBankUserYn(String str) {
        this.isRegisteredBankUserYn = str;
    }

    public void setIsRegisteredTcashUserYn(String str) {
        this.isRegisteredTcashUserYn = str;
    }

    public void setTCashStatus(String str) {
        this.tcashStatus = str;
    }

    public void setTCashUserBalance(String str) {
        this.tcashBalance = str;
    }
}
