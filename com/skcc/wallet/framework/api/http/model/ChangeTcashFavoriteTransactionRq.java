package com.skcc.wallet.framework.api.http.model;

public class ChangeTcashFavoriteTransactionRq {
    private CommonHeader commonHeader;
    private TcashFavorite tcashFavorite;

    public CommonHeader getCommonHeader() {
        return this.commonHeader;
    }

    public TcashFavorite getTcashFavorite() {
        return this.tcashFavorite;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }

    public void setTcashFavorite(TcashFavorite tcashFavorite) {
        this.tcashFavorite = tcashFavorite;
    }
}
