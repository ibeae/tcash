package com.skcc.wallet.framework.api.http.model;

public class DataPackage {
    private long dataCapacity;
    private String menuId;
    private String packageId;
    private String packageName;

    public long getDataCapacity() {
        return this.dataCapacity;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setDataCapacity(long j) {
        this.dataCapacity = j;
    }

    public void setMenuId(String str) {
        this.menuId = str;
    }

    public void setPackageId(String str) {
        this.packageId = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }
}
