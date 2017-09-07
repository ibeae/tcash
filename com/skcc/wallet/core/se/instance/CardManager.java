package com.skcc.wallet.core.se.instance;

import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.core.se.ISEMedia;
import com.skcc.wallet.core.se.SException;
import com.skcc.wallet.core.se.util.HexString;
import java.io.IOException;

public class CardManager extends Applet {
    public CardManager(ISEMedia iSEMedia) {
        super(iSEMedia, "A000000151000000");
    }

    public CardManager(ISEMedia iSEMedia, String str) {
        super(iSEMedia, str);
    }

    public static String twistNibbleHexString(String str) {
        if (str == null || str.length() % 2 == 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i += 2) {
            stringBuffer.append(str.substring(i + 1, i + 2));
            stringBuffer.append(str.substring(i, i + 1));
        }
        return stringBuffer.toString();
    }

    public String getCIN() {
        byte[] bArr = (byte[]) null;
        selApplet();
        byte[] bArr2 = new byte[5];
        bArr2[0] = Byte.MIN_VALUE;
        bArr2[1] = (byte) -54;
        bArr2[3] = (byte) 69;
        try {
            Object exchangeAPDU = seMedia.exchangeAPDU(bArr2);
            closeApplet();
            if (exchangeAPDU != null && exchangeAPDU.length > 2) {
                this.swChecker.setSW(exchangeAPDU).checkSW();
                bArr = new byte[(exchangeAPDU.length - 2)];
                System.arraycopy(exchangeAPDU, 0, bArr, 0, bArr.length);
                C1216a.m4519a(TAG, "cin = " + HexString.bytesToHexString(bArr));
            }
            return HexString.bytesToHexString(bArr);
        } catch (IOException e) {
            throw new SException(-16);
        } catch (SException e2) {
            throw e2;
        } catch (Throwable th) {
            closeApplet();
        }
    }

    public String getCPLC() {
        byte[] bArr = (byte[]) null;
        if (selApplet() == null) {
            C1216a.m4519a(TAG, "channel is null.");
            return null;
        }
        byte[] bArr2 = new byte[5];
        bArr2[0] = Byte.MIN_VALUE;
        bArr2[1] = (byte) -54;
        bArr2[2] = (byte) -97;
        bArr2[3] = Byte.MAX_VALUE;
        try {
            Object exchangeAPDU = seMedia.exchangeAPDU(bArr2);
            closeApplet();
            if (exchangeAPDU != null && exchangeAPDU.length > 2) {
                this.swChecker.setSW(exchangeAPDU).checkSW();
                bArr = new byte[(exchangeAPDU.length - 2)];
                System.arraycopy(exchangeAPDU, 0, bArr, 0, bArr.length);
                C1216a.m4519a(TAG, "CPLC = " + HexString.bytesToHexString(bArr));
            }
            return HexString.bytesToHexString(bArr).toUpperCase();
        } catch (IOException e) {
            throw new SException(-16);
        } catch (SException e2) {
            throw e2;
        }
    }

    public String getICCID() {
        return "";
    }

    public String getIMSI() {
        byte[] bArr = (byte[]) null;
        Object hexStringToBytes = HexString.hexStringToBytes("A0000000871002FF47F00189000001FF");
        try {
            if (seMedia.openChannel(hexStringToBytes) == null) {
                C1216a.m4519a(TAG, "select applet USIM AID openChannel failed: " + hexStringToBytes);
                return null;
            }
            try {
                if (seMedia.exchangeAPDU(HexString.hexStringToBytes("00A40004026F07")) == null) {
                    C1216a.m4519a(TAG, "select IMSI File in SIM null failed");
                    seMedia.closeChannel();
                    return null;
                }
                Object exchangeAPDU = seMedia.exchangeAPDU(HexString.hexStringToBytes("00B0000000"));
                seMedia.closeChannel();
                C1216a.m4519a(TAG, "get IMSI resSelCM: " + exchangeAPDU);
                if (exchangeAPDU == null || exchangeAPDU.length <= 2) {
                    C1216a.m4519a(TAG, "get IMSI parsing fail!");
                    return null;
                }
                this.swChecker.setSW(exchangeAPDU).checkSW();
                Object obj = new byte[(exchangeAPDU.length - 3)];
                System.arraycopy(exchangeAPDU, 1, obj, 0, obj.length);
                String substring = twistNibbleHexString(HexString.bytesToHexString(obj)).substring(1);
                C1216a.m4519a(TAG, "IMSI = " + substring);
                return substring;
            } catch (SException e) {
                C1216a.m4519a(TAG, "get IMSI file SE Exception: " + hexStringToBytes);
                e.printStackTrace();
                throw e;
            } catch (IOException e2) {
                C1216a.m4519a(TAG, "get IMSI IO Exception: " + hexStringToBytes);
                e2.printStackTrace();
                throw new SException(-16);
            } catch (Throwable th) {
                seMedia.closeChannel();
            }
        } catch (SException e3) {
            C1216a.m4519a(TAG, "select applet USIM AID SE Exception: " + hexStringToBytes);
            e3.printStackTrace();
            throw e3;
        }
    }
}
