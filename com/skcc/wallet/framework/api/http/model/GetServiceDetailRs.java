package com.skcc.wallet.framework.api.http.model;

public class GetServiceDetailRs extends ResultRs {
    private Menu menu;

    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
