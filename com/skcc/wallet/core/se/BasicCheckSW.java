package com.skcc.wallet.core.se;

public class BasicCheckSW extends AbstractCheckSW {
    public BasicCheckSW(byte[] bArr) {
        super(bArr);
    }

    public void checkSW() {
        if (this.sw1 != (byte) -112 || this.sw2 != (byte) 0) {
            if (this.sw1 == (byte) 98 && this.sw2 == (byte) -125) {
                throw new SException(-2);
            } else if (this.sw1 == (byte) 106 && this.sw2 == (byte) -126) {
                throw new SException(-17);
            } else {
                throw new SException(-1);
            }
        }
    }
}
