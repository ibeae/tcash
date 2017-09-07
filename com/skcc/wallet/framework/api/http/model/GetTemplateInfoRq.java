package com.skcc.wallet.framework.api.http.model;

public class GetTemplateInfoRq {
    private String apiMenuId;
    private CommonHeader commonHeader;
    private String subMenuId;

    public String getApiMenuId() {
        return this.apiMenuId;
    }

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getSubMenuId() {
        return this.subMenuId;
    }

    public void setApiMenuId(String str) {
        this.apiMenuId = str;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setSubMenuId(String str) {
        this.subMenuId = str;
    }
}
