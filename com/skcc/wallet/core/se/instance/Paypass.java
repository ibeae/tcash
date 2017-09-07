package com.skcc.wallet.core.se.instance;

import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.core.se.ISEMedia;
import com.skcc.wallet.core.se.util.HexString;
import java.nio.charset.Charset;

public class Paypass extends Applet {
    private Data data = new Data();

    class Data {
        private String cardNumber = "";
        private String expirationDate = "";
        private String holderName = "";

        Data() {
        }
    }

    public static class PaypassParser {
        private static final int CASE_NOT_FOUND = -1;
        private static final int CASE_TAG_RECORD_EXP = 1;
        private static final int CASE_TAG_RECORD_PAN = 0;
        private static final byte[][] TAGS = new byte[][]{TAG_RECORD_PAN, TAG_RECORD_EXP};
        private static final byte[] TAG_RECORD_EXP = new byte[]{(byte) 95, (byte) 36};
        private static final byte[] TAG_RECORD_PAN = new byte[]{(byte) -33, (byte) 3};
        private static final byte TAG_RECORD_TEMPLATE = (byte) 112;
        private static final byte TAG_TRACK2_DATA1 = (byte) 86;
        private static final byte[] TAG_TRACK2_DATA2 = new byte[]{(byte) -97, (byte) 107};
        private static final byte[] TAG_UNKNOWN1 = new byte[]{(byte) -97, (byte) 108};
        private static final byte[] TAG_UNKNOWN2 = new byte[]{(byte) -97, (byte) 98};
        private static final byte[] TAG_UNKNOWN3 = new byte[]{(byte) -97, (byte) 99};
        private static final byte[] TAG_UNKNOWN4 = new byte[]{(byte) -97, (byte) 100};
        private static final byte[] TAG_UNKNOWN5 = new byte[]{(byte) -97, (byte) 101};
        private static final byte[] TAG_UNKNOWN6 = new byte[]{(byte) -97, (byte) 102};

        private static int findTag(Pos pos, byte[] bArr) {
            byte[][] bArr2 = TAGS;
            int length = bArr2.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte[] bArr3 = bArr2[i];
                byte trimByte = HexString.trimByte(bArr[pos.position]);
                C1216a.m4519a("gg", "b:" + trimByte + ",tag[0]" + bArr3[0]);
                if (trimByte == bArr3[0]) {
                    if (bArr3.length == 1) {
                        pos.position++;
                        return i2;
                    } else if (HexString.trimByte(bArr[pos.position + 1]) == bArr3[1]) {
                        pos.position += 2;
                        return i2;
                    }
                }
                i++;
                i2++;
            }
            return -1;
        }

        public static void parse(byte[] bArr, Data data) {
            Pos pos = new Pos();
            int length = bArr.length;
            pos.position = 130;
            while (pos.position < length) {
                int findTag = findTag(pos, bArr);
                if (findTag != -1) {
                    int i = pos.position;
                    pos.position = i + 1;
                    byte b = bArr[i];
                    Object obj;
                    switch (findTag) {
                        case 0:
                            C1216a.m4519a("gg", "CASE_TAG_RECORD_PAN");
                            obj = new byte[b];
                            System.arraycopy(bArr, pos.position, obj, 0, b);
                            data.cardNumber = new String(obj, Charset.forName("UTF-8")).replaceAll("\\p{Space}", "");
                            pos.position += b;
                            break;
                        case 1:
                            C1216a.m4519a("gg", "CASE_TAG_RECORD_EXP");
                            obj = new byte[b];
                            System.arraycopy(bArr, pos.position, obj, 0, b);
                            data.expirationDate = new String(obj, Charset.forName("UTF-8"));
                            pos.position += b;
                            break;
                        default:
                            break;
                    }
                }
                return;
            }
        }
    }

    public static class Pos {
        int position = 0;
    }

    public Paypass(ISEMedia iSEMedia, String str) {
        super(iSEMedia, str);
    }

    private void parseRecode(byte[] bArr) {
        PaypassParser.parse(bArr, this.data);
    }

    public String getCardNumber() {
        return this.data.cardNumber;
    }

    public void getData() {
        try {
            selApplet();
            byte[] bArr = new byte[5];
            bArr[0] = (byte) -127;
            bArr[1] = (byte) -54;
            bArr[2] = (byte) -33;
            bArr[3] = (byte) 71;
            bArr = seMedia.exchangeAPDU(bArr);
            this.swChecker.setSW(bArr).checkSW();
            parseRecode(bArr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeApplet();
        }
    }

    public String getExpirationDate() {
        return this.data.expirationDate;
    }

    public String getHolderName() {
        return this.data.holderName;
    }
}
