package com.skcc.wallet.framework.api.http.model;

public class GetTcashTransactionHistoryRq {
    private CommonHeader commonHeader;
    private long pageNum = 1;
    private long rowPerPage = 5;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public long getPageNum() {
        return this.pageNum;
    }

    public long getRowPerPage() {
        return this.rowPerPage;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setPageNum(long j) {
        this.pageNum = j;
    }

    public void setRowPerPage(long j) {
        this.rowPerPage = j;
    }
}
