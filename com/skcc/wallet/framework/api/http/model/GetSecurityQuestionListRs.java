package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetSecurityQuestionListRs extends ResultRs {
    private List<SecurityQuestion> securityQuestionList;

    public List<SecurityQuestion> getSecurityQuestionList() {
        return this.securityQuestionList;
    }

    public void setSecurityQuestionList(List<SecurityQuestion> list) {
        this.securityQuestionList = list;
    }
}
