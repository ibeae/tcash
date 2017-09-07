package com.skcc.wallet.framework.api.http.model;

public class GetTcashPaymentTemplateRq {
    private CommonHeader commonHeader;
    private String menuId;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setMenuId(String str) {
        this.menuId = str;
    }
}
