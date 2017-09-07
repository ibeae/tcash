package com.skcc.wallet.framework.api.http.model;

public class GetSecurityQuestionRs extends ResultRs {
    private SecurityQuestion securityQuestion;

    public SecurityQuestion getSecurityQuestion() {
        return this.securityQuestion;
    }

    public void setSecurityQuestion(SecurityQuestion securityQuestion) {
        this.securityQuestion = securityQuestion;
    }
}
