package com.skcc.wallet.framework.api.http.model;

public class CheckEligibilityRs extends ResultRs {
    private String nfcYn;
    private String tncUpgrade;
    private String versionUpgrade;

    public String getNfcYn() {
        return this.nfcYn;
    }

    public String getTncUpgrade() {
        return this.tncUpgrade;
    }

    public String getVersionUpgrade() {
        return this.versionUpgrade;
    }

    public void setNfcYn(String str) {
        this.nfcYn = str;
    }

    public void setTncUpgrade(String str) {
        this.tncUpgrade = str;
    }

    public void setVersionUpgrade(String str) {
        this.versionUpgrade = str;
    }
}
