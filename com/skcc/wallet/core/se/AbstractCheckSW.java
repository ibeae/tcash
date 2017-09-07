package com.skcc.wallet.core.se;

import com.skcc.wallet.core.se.util.HexString;

public abstract class AbstractCheckSW {
    protected byte sw1;
    protected byte sw2;

    public AbstractCheckSW(byte[] bArr) {
        setSW(bArr);
    }

    public abstract void checkSW();

    public AbstractCheckSW setSW(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            this.sw1 = (byte) 0;
            this.sw2 = (byte) 0;
        } else {
            this.sw1 = HexString.trimByte(bArr[bArr.length - 2]);
            this.sw2 = HexString.trimByte(bArr[bArr.length - 1]);
        }
        return this;
    }
}
