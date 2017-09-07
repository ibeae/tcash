package com.skcc.wallet.framework.api.http.model;

public class SetTcashSecurityAnswerRq {
    private CommonHeader commonHeader;
    private SecurityQuestion tcashSecurityQuestion;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public SecurityQuestion getTcashSecurityQuestion() {
        return this.tcashSecurityQuestion;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setTcashSecurityQuestion(SecurityQuestion securityQuestion) {
        this.tcashSecurityQuestion = securityQuestion;
    }
}
