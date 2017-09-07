package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetTcashSecurityQuestionListRs extends ResultRs {
    private List<TcashSecurityQuestion> tcashSecurityQuestionList;

    public List<TcashSecurityQuestion> getTcashSecurityQuestionList() {
        return this.tcashSecurityQuestionList;
    }

    public void setTcashSecurityQuestionList(List<TcashSecurityQuestion> list) {
        this.tcashSecurityQuestionList = list;
    }
}
