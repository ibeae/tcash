package com.skcc.wallet.core.se.instance;

import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.core.se.AbstractCheckSW;
import com.skcc.wallet.core.se.BasicCheckSW;
import com.skcc.wallet.core.se.ISEMedia;
import com.skcc.wallet.core.se.util.HexString;

public abstract class Applet {
    protected static final String TAG = Applet.class.getSimpleName();
    protected static ISEMedia seMedia;
    protected final int CLA = 0;
    protected final int DATA = 5;
    protected final int INS = 1;
    protected final int Lc = 4;
    protected final int P1 = 2;
    protected final int P2 = 3;
    protected String aid;
    protected boolean isSelectAid = false;
    protected AbstractCheckSW swChecker = new BasicCheckSW();

    public Applet(ISEMedia iSEMedia, String str) {
        if (iSEMedia == null || str == null || str.trim().length() < 1) {
            throw new IllegalArgumentException();
        }
        seMedia = iSEMedia;
        this.aid = str;
        this.isSelectAid = false;
    }

    protected void closeApplet() {
        this.isSelectAid = false;
        seMedia.closeChannel();
        C1216a.m4519a(TAG, "close applet : " + this.aid);
    }

    protected byte[] selApplet() {
        byte[] bArr = (byte[]) null;
        bArr = seMedia.openChannel(HexString.hexStringToBytes(this.aid));
        if (bArr == null) {
            C1216a.m4519a(TAG, "select card ok but.. res null?");
            this.isSelectAid = false;
        } else {
            this.isSelectAid = true;
        }
        return bArr;
    }
}
