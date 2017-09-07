package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class GetTcashOptionRs extends ResultRs {
    private List<BankCode> bankCodes;
    private List<Menu> menus;
    private List<TransferType> transferTypes;

    public List<BankCode> getBankCodes() {
        return this.bankCodes;
    }

    public List<Menu> getMenus() {
        return this.menus;
    }

    public List<TransferType> getTransferTypes() {
        return this.transferTypes;
    }

    public void setBankCodes(List<BankCode> list) {
        this.bankCodes = list;
    }

    public void setMenus(List<Menu> list) {
        this.menus = list;
    }

    public void setTransferTypes(List<TransferType> list) {
        this.transferTypes = list;
    }
}
