package com.skcc.wallet.framework.api.http.model;

public class SetSecurityAnswerRs extends ResultRs {
    private String securityQuestion;

    public String getSecurityQuestion() {
        return this.securityQuestion;
    }

    public void setSecurityQuestion(String str) {
        this.securityQuestion = str;
    }
}
