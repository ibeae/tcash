package com.skcc.wallet.framework.api.http.model;

public class Region {
    private String regionId = null;
    private String regionName = null;

    public String getRegionId() {
        return this.regionId;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionId(String str) {
        this.regionId = str;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }
}
