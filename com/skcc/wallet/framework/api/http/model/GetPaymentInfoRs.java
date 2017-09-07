package com.skcc.wallet.framework.api.http.model;

public class GetPaymentInfoRs extends ResultRs {
    private Menu menu;
    private TcashTransaction tcashTransaction;

    public Menu getMenu() {
        return this.menu;
    }

    public TcashTransaction getTcashTransaction() {
        return this.tcashTransaction;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setTcashTransaction(TcashTransaction tcashTransaction) {
        this.tcashTransaction = tcashTransaction;
    }
}
