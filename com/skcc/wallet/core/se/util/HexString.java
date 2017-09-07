package com.skcc.wallet.core.se.util;

import com.facebook.AppEventsConstants;

public class HexString {
    private static final char[] DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String byteToHexString(byte b) {
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new String())).append(DIGITS[(b >> 4) & 15]).toString())).append(DIGITS[b & 15]).toString();
    }

    public static String bytesToHexString(byte[] bArr) {
        return bytesToHexString(bArr, 0, bArr.length, false);
    }

    public static String bytesToHexString(byte[] bArr, int i, int i2, boolean z) {
        String str = new String();
        int i3 = i + i2;
        while (i < i3) {
            str = new StringBuilder(String.valueOf(str)).append(byteToHexString(bArr[i])).toString();
            if (z) {
                str = new StringBuilder(String.valueOf(str)).append(" ").toString();
            }
            i++;
        }
        return str;
    }

    public static String bytesToHexString(byte[] bArr, boolean z) {
        return bytesToHexString(bArr, 0, bArr.length, z);
    }

    public static int bytesToInt(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            i3 = (i3 << 8) | (bArr[i2] & 255);
            i2++;
        }
        return i3;
    }

    public static byte hexStringToByte(String str) {
        if (str == null) {
            throw new Exception("input String is null");
        }
        int length = str.length();
        if (length == 1) {
            str = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO).append(str).toString();
        } else if (length > 2) {
            str = str.substring(0, 2);
        }
        byte[] bArr = new byte[1];
        return hexStringToBytes(str)[0];
    }

    public static byte[] hexStringToBytes(String str) {
        int length = str.length();
        Object obj = new byte[length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            byte digit = (byte) Character.digit(charAt, 16);
            if (digit == (byte) -1) {
                if (!Character.isWhitespace(charAt)) {
                    throw new IllegalArgumentException("Not HexString character: " + charAt);
                }
            } else if (i2 == 0) {
                i = (byte) (digit << 4);
                i2 = 1;
            } else {
                i = (byte) (i | digit);
                i2 = i3 + 1;
                obj[i3] = i;
                i3 = i2;
                i2 = 0;
            }
        }
        if (i2 != 0) {
            throw new IllegalArgumentException("odd number of characters.");
        }
        Object obj2 = new byte[i3];
        System.arraycopy(obj, 0, obj2, 0, i3);
        return obj2;
    }

    public static byte trimByte(byte b) {
        return (byte) (b & 255);
    }
}
