package com.skcc.wallet.framework.api.http.model;

public class RemoveTcashFavoriteTransactionRq {
    private CommonHeader commonHeader;
    private String favoriteMenuId;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public String getFavoriteMenuId() {
        return this.favoriteMenuId;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setFavoriteMenuId(String str) {
        this.favoriteMenuId = str;
    }
}
