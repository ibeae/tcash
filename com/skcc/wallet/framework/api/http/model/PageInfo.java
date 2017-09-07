package com.skcc.wallet.framework.api.http.model;

public class PageInfo {
    private Integer pageNumber = null;
    private Integer pageSize = null;

    public PageInfo(int i, int i2) {
        this.pageNumber = Integer.valueOf(i);
        this.pageSize = Integer.valueOf(i2);
    }

    public int getPageNumber() {
        return this.pageNumber.intValue();
    }

    public int getPageSize() {
        return this.pageSize.intValue();
    }

    public void setPageNumber(Integer num) {
        this.pageNumber = num;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }
}
