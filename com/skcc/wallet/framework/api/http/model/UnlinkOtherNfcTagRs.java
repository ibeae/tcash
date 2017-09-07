package com.skcc.wallet.framework.api.http.model;

public class UnlinkOtherNfcTagRs extends ResultRs {
    private boolean unlinkDone;

    public boolean isUnlinkDone() {
        return this.unlinkDone;
    }

    public void setUnlinkDone(boolean z) {
        this.unlinkDone = z;
    }
}
