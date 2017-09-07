package com.skcc.wallet.framework.api.http.model;

public class SetUserProfileRq {
    private CommonHeader commonHeader;
    private SecurityQuestion securityQuestion = null;
    private UserInfo userInfo = null;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public SecurityQuestion getSecurityQuestion() {
        return this.securityQuestion;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setSecurityQuestion(SecurityQuestion securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
