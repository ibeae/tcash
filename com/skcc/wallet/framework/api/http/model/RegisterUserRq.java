package com.skcc.wallet.framework.api.http.model;

public class RegisterUserRq {
    private CommonHeader commonHeader;
    private MobileInfo mobileInfo;
    private String promoCode;
    private UserInfo userInfo;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public MobileInfo getMobileInfo() {
        return this.mobileInfo;
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setMobileInfo(MobileInfo mobileInfo) {
        this.mobileInfo = mobileInfo;
    }

    public void setPromoCode(String str) {
        this.promoCode = str;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
