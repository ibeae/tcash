package com.skcc.wallet.framework.api.http.model;

public class GetTcashSecurityQuestionRs extends ResultRs {
    private TcashSecurityQuestion tcashSecurityQuestion;

    public TcashSecurityQuestion getTcashSecurityQuestion() {
        return this.tcashSecurityQuestion;
    }

    public void setTcashSecurityQuestion(TcashSecurityQuestion tcashSecurityQuestion) {
        this.tcashSecurityQuestion = tcashSecurityQuestion;
    }
}
