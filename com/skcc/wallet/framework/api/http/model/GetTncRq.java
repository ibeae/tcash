package com.skcc.wallet.framework.api.http.model;

public class GetTncRq {
    private CommonHeader commonHeader;
    private String fileName;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }
}
