package com.skcc.wallet.framework.api.http.model;

public class SecurityQuestion {
    private String answer;
    private String question;
    private String questionId;
    private String useYN;

    public SecurityQuestion(String str, String str2, String str3) {
        this.questionId = str;
        this.question = str2;
        this.answer = str3;
    }

    public String getAnswer() {
        return this.answer;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getQuestionId() {
        return this.questionId;
    }

    public String getUseYN() {
        return this.useYN;
    }

    public void setAnswer(String str) {
        this.answer = str;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

    public void setQuestionId(String str) {
        this.questionId = str;
    }

    public void setUseYN(String str) {
        this.useYN = str;
    }
}
