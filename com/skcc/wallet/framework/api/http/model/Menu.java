package com.skcc.wallet.framework.api.http.model;

import java.util.List;

public class Menu {
    private List<DataPackage> dataPackages;
    private List<Denomination> denominations;
    private String description = null;
    private String menuId = null;
    private List<Region> regions;
    private List<TypeInsurance> typeInsurances;

    public List<DataPackage> getDataPackages() {
        return this.dataPackages;
    }

    public List<Denomination> getDenominations() {
        return this.denominations;
    }

    public String getDescription() {
        return this.description;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public List<Region> getRegions() {
        return this.regions;
    }

    public List<TypeInsurance> getTypeInsurances() {
        return this.typeInsurances;
    }

    public void setDataPackages(List<DataPackage> list) {
        this.dataPackages = list;
    }

    public void setDenominations(List<Denomination> list) {
        this.denominations = list;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setMenuId(String str) {
        this.menuId = str;
    }

    public void setRegions(List<Region> list) {
        this.regions = list;
    }

    public void setTypeInsurances(List<TypeInsurance> list) {
        this.typeInsurances = list;
    }
}
