package com.skcc.wallet.core.se.instance;

import android.support.v4.app.NotificationCompat;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.core.se.ISEMedia;
import com.skcc.wallet.core.se.util.HexString;

public class Vsdc extends Applet {
    private Data data = new Data();
    private int transactionATC = -1;
    private TransactionData transactionData = new TransactionData();
    private byte transactionMAX = (byte) 0;
    private byte transactionSFI = (byte) 0;

    class Data {
        private String cardNumber = "";
        private String expirationDate = "";
        private String holderName = "";

        Data() {
        }
    }

    public static class Pos {
        int position = 0;
    }

    class TransactionData {
        private String transactionAmount = "";
        private String transactionDate = "";
        private String transactionName = "";
        private String transactionType = "";

        TransactionData() {
        }
    }

    public static class TransactionParser {
        public static void parse(byte[] bArr, TransactionData transactionData) {
            if (bArr.length >= 3) {
                r1 = new byte[6];
                System.arraycopy(bArr, 3, r1, 0, 6);
                int parseInt = Integer.parseInt(HexString.bytesToHexString(r1));
                parseInt -= (parseInt / 100) * 100;
                transactionData.transactionAmount = String.format("$%d.%02d", new Object[]{Integer.valueOf(r1), Integer.valueOf(parseInt)});
                r1 = new byte[3];
                System.arraycopy(bArr, 17, r1, 0, 3);
                String bytesToHexString = HexString.bytesToHexString(r1);
                transactionData.transactionDate = String.format("%s/%s/20%s", new Object[]{bytesToHexString.substring(4, 6), bytesToHexString.substring(2, 4), bytesToHexString.substring(0, 2)});
                r1 = new byte[1];
                System.arraycopy(bArr, 20, r1, 0, 1);
                if (r1[0] == (byte) 0) {
                    transactionData.transactionType = "Purchase";
                } else {
                    transactionData.transactionType = "Refund";
                }
                Object obj = new byte[20];
                System.arraycopy(bArr, 21, obj, 0, 20);
                transactionData.transactionName = new String(obj).trim();
            }
        }
    }

    public static class VsdcParser {
        private static final int CASE_NOT_FOUND = -1;
        private static final int CASE_TAG_CVV2 = 5;
        private static final int CASE_TAG_EXPIRATION_DATE = 4;
        private static final int CASE_TAG_HEADER = 0;
        private static final int CASE_TAG_HEADER2 = 1;
        private static final int CASE_TAG_HOLDER_NAME = 3;
        private static final int CASE_TAG_PAN = 2;
        private static final int CASE_TAG_RECORD_TEMPLATE = 6;
        private static final int CASE_TAG_TRACK2_DATA = 7;
        private static final byte[][] TAGS;
        private static byte[] TAG_CVV2 = new byte[]{(byte) -33, (byte) 1};
        private static byte[] TAG_EXPIRATION_DATE = new byte[]{(byte) 95, (byte) 36};
        private static final byte TAG_HEADER = (byte) 119;
        private static byte[] TAG_HEADER2 = new byte[]{(byte) -65, (byte) 94};
        private static byte[] TAG_HOLDER_NAME = new byte[]{(byte) 95, (byte) 32};
        private static final byte TAG_PAN = (byte) 90;
        private static final byte TAG_RECORD_TEMPLATE = (byte) 112;
        private static final byte TAG_TRACK2_DATA = (byte) 87;

        static {
            r0 = new byte[8][];
            r0[0] = new byte[]{TAG_HEADER};
            r0[1] = TAG_HEADER2;
            r0[2] = new byte[]{TAG_PAN};
            r0[3] = TAG_HOLDER_NAME;
            r0[4] = TAG_EXPIRATION_DATE;
            r0[5] = TAG_CVV2;
            r0[6] = new byte[]{TAG_RECORD_TEMPLATE};
            r0[7] = new byte[]{TAG_TRACK2_DATA};
            TAGS = r0;
        }

        private static int findTag(Pos pos, byte[] bArr) {
            byte[][] bArr2 = TAGS;
            int length = bArr2.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte[] bArr3 = bArr2[i];
                if (HexString.trimByte(bArr[pos.position]) == bArr3[0]) {
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
            C1216a.m4519a("gg", "visa parsing start!");
            Pos pos = new Pos();
            int length = bArr.length;
            while (pos.position < length) {
                int findTag = findTag(pos, bArr);
                if (findTag != -1) {
                    int i = pos.position;
                    pos.position = i + 1;
                    byte b = bArr[i];
                    Object obj;
                    switch (findTag) {
                        case 0:
                            C1216a.m4519a("gg", "CASE_TAG_HEADER");
                            break;
                        case 1:
                            C1216a.m4519a("gg", "CASE_TAG_HEADER2");
                            break;
                        case 2:
                            C1216a.m4519a("gg", "CASE_TAG_PAN");
                            obj = new byte[b];
                            System.arraycopy(bArr, pos.position, obj, 0, b);
                            data.cardNumber = HexString.bytesToHexString(obj);
                            pos.position += b;
                            break;
                        case 3:
                            obj = new byte[b];
                            System.arraycopy(bArr, pos.position, obj, 0, b);
                            data.holderName = new String(obj);
                            pos.position += b;
                            break;
                        case 4:
                            C1216a.m4519a("gg", "CASE_TAG_EXPIRATION_DATE");
                            obj = new byte[b];
                            System.arraycopy(bArr, pos.position, obj, 0, b);
                            String bytesToHexString = HexString.bytesToHexString(obj);
                            data.expirationDate = String.format("20%s/%s/%s", new Object[]{bytesToHexString.substring(0, 2), bytesToHexString.substring(2, 4), bytesToHexString.substring(4, 6)});
                            pos.position += b;
                            break;
                        case 5:
                            C1216a.m4519a("gg", "CASE_TAG_CVV2");
                            break;
                        case 6:
                            break;
                        case 7:
                            byte b2 = (byte) 0;
                            while (b2 < b && HexString.trimByte((byte) (bArr[pos.position + b2] & 240)) != (byte) -48) {
                                b2++;
                            }
                            Object obj2 = new byte[b2];
                            System.arraycopy(bArr, pos.position, obj2, 0, obj2.length);
                            data.cardNumber = HexString.bytesToHexString(obj2);
                            obj2 = new byte[3];
                            System.arraycopy(bArr, b2 + pos.position, obj2, 0, 3);
                            data.expirationDate = HexString.bytesToHexString(obj2).substring(1, 5);
                            pos.position += b;
                            break;
                        default:
                            break;
                    }
                }
                C1216a.m4519a("gg", "CASE_NOT_FOUND:" + pos + ", posision:" + pos.position);
                return;
            }
        }
    }

    public Vsdc(ISEMedia iSEMedia, String str) {
        super(iSEMedia, str);
    }

    private void parseRecode(byte[] bArr) {
        VsdcParser.parse(bArr, this.data);
    }

    public void getCDIData() {
        try {
            byte[] bArr = new byte[5];
            bArr[0] = Byte.MIN_VALUE;
            bArr[1] = (byte) -54;
            bArr[2] = (byte) -97;
            bArr[3] = (byte) 80;
            this.swChecker.setSW(seMedia.exchangeAPDU(bArr)).checkSW();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCardNumber() {
        return this.data.cardNumber;
    }

    public void getData() {
        try {
            selApplet();
            getCDIData();
            byte[] bArr = new byte[5];
            bArr[0] = Byte.MIN_VALUE;
            bArr[1] = (byte) -40;
            bArr[2] = (byte) 1;
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

    public int getTransactionATC() {
        return this.transactionATC;
    }

    public String getTransactionAmount() {
        return this.transactionData.transactionAmount;
    }

    public String getTransactionDate() {
        return this.transactionData.transactionDate;
    }

    public java.util.Vector<com.skcc.wallet.core.se.instance.CustomerPayTransaction> getTransactionHistory() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r1 = 1;
        r6.selApplet();	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r0 = new java.util.Vector;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r0.<init>();	 Catch:{ Exception -> 0x0084, all -> 0x008d }
    L_0x0009:
        r2 = r6.transactionMAX;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2 = r2 + 1;
        if (r1 < r2) goto L_0x0013;
    L_0x000f:
        r6.closeApplet();
    L_0x0012:
        return r0;
    L_0x0013:
        r2 = r6.transactionATC;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        if (r1 > r2) goto L_0x000f;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
    L_0x0017:
        r2 = 5;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2 = new byte[r2];	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = 0;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r4 = -128; // 0xffffffffffffff80 float:NaN double:NaN;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = 1;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r4 = -78;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = 2;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2[r3] = r1;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = 3;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r4 = -92;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = seMedia;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2 = r3.exchangeAPDU(r2);	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = r6.swChecker;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = r3.setSW(r2);	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3.checkSW();	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = r6.transactionData;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        com.skcc.wallet.core.se.instance.Vsdc.TransactionParser.parse(r2, r3);	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2 = new com.skcc.wallet.core.se.instance.CustomerPayTransaction;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2.<init>();	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = r6.transactionData;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = r3.transactionAmount;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2.setTransactionAmount(r3);	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = r6.transactionData;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = r3.transactionDate;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2.setTransactionDate(r3);	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = r6.transactionData;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = r3.transactionType;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2.setTransactionType(r3);	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = r6.transactionData;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = r3.transactionName;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2.setMerchant(r3);	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r0.add(r2);	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r3 = "gg";	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r5 = "visa transaction::";	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2 = r4.append(r2);	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        com.skcc.wallet.core.p057a.C1216a.m4519a(r3, r2);	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r1 = r1 + 1;
        r1 = (byte) r1;
        goto L_0x0009;
    L_0x0084:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0084, all -> 0x008d }
        r6.closeApplet();
        r0 = 0;
        goto L_0x0012;
    L_0x008d:
        r0 = move-exception;
        r6.closeApplet();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.skcc.wallet.core.se.instance.Vsdc.getTransactionHistory():java.util.Vector<com.skcc.wallet.core.se.instance.CustomerPayTransaction>");
    }

    public String getTransactionName() {
        return this.transactionData.transactionName;
    }

    public String getTransactionType() {
        return this.transactionData.transactionType;
    }

    public void getTrasactionLog() {
        try {
            selApplet();
            byte[] bArr = new byte[5];
            bArr[0] = Byte.MIN_VALUE;
            bArr[1] = (byte) -54;
            bArr[2] = (byte) -97;
            bArr[3] = (byte) 77;
            bArr = seMedia.exchangeAPDU(bArr);
            this.swChecker.setSW(bArr).checkSW();
            this.transactionSFI = bArr[3];
            this.transactionMAX = bArr[4];
            bArr = new byte[5];
            bArr[0] = Byte.MIN_VALUE;
            bArr[1] = (byte) -54;
            bArr[2] = (byte) -97;
            bArr[3] = (byte) 54;
            Object exchangeAPDU = seMedia.exchangeAPDU(bArr);
            this.swChecker.setSW(exchangeAPDU).checkSW();
            Object obj = new byte[2];
            System.arraycopy(exchangeAPDU, 3, obj, 0, 2);
            this.transactionATC = (obj[0] * NotificationCompat.FLAG_LOCAL_ONLY) + obj[1];
            C1216a.m4519a("gg", "transactionSFI:" + this.transactionSFI);
            C1216a.m4519a("gg", "transactionMAX:" + this.transactionMAX);
            C1216a.m4519a("gg", "transactionATC::" + this.transactionATC);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeApplet();
        }
    }

    public void verifyPIN() {
        try {
            Object hexStringToBytes = HexString.hexStringToBytes("0020E0800824FFFFFFFFFFFFFF");
            C1216a.m4519a(TAG, "visa verifyPIN : " + hexStringToBytes);
            this.swChecker.setSW(seMedia.exchangeAPDU(hexStringToBytes)).checkSW();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
