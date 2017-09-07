package com.skcc.wallet.framework.api.http.model;

public class SecurityQnA {
    private String securityAnswer;
    private String securityQuestion;

    public String getSecurityAnswer() {
        return this.securityAnswer;
    }

    public String getSecurityQuestion() {
        return this.securityQuestion;
    }

    public void setSecurityAnswer(String str) {
        this.securityAnswer = str;
    }

    public void setSecurityQuestion(String str) {
        this.securityQuestion = str;
    }
}
