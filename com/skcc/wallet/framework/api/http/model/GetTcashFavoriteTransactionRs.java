package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetTcashFavoriteTransactionRs extends ResultRs {
    private List<TcashFavorite> tcashFavorites;

    public List<TcashFavorite> getTcashFavorites() {
        return this.tcashFavorites;
    }

    public void setTcashFavorites(List<TcashFavorite> list) {
        this.tcashFavorites = list;
    }
}
