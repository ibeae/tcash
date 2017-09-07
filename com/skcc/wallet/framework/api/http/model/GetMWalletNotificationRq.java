package com.skcc.wallet.framework.api.http.model;

public class GetMWalletNotificationRq {
    private CommonHeader commonHeader;
    private int pageNo;
    private int rownum;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getRownum() {
        return this.rownum;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setPageNo(int i) {
        this.pageNo = i;
    }

    public void setRownum(int i) {
        this.rownum = i;
    }
}
