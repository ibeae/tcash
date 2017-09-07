package com.skcc.wallet.framework.api.http.model;

public class GetUserProfileRs extends ResultRs {
    private SecurityQuestion securityQuestion = null;
    private UserInfo userInfo = null;

    public SecurityQuestion getSecurityQuestion() {
        return this.securityQuestion;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setSecurityQuestion(SecurityQuestion securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
