package com.skcc.wallet.framework.api.http.model;

public class TcashSecurityQuestion extends SecurityQuestion {
    public TcashSecurityQuestion(String str, String str2, String str3) {
        setAnswer(str3);
        setQuestionId(str);
        setQuestion(str2);
    }
}
