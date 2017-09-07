package com.skcc.wallet.framework.api.http.model;

public class TypeInsurance {
    private String dataId;
    private String dataName;
    private long dataValue;
    private String menuId;

    public String getDataId() {
        return this.dataId;
    }

    public String getDataName() {
        return this.dataName;
    }

    public long getDataValue() {
        return this.dataValue;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public void setDataId(String str) {
        this.dataId = str;
    }

    public void setDataName(String str) {
        this.dataName = str;
    }

    public void setDataValue(long j) {
        this.dataValue = j;
    }

    public void setMenuId(String str) {
        this.menuId = str;
    }
}
