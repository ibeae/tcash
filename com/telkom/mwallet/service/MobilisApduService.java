package com.telkom.mwallet.service;

import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.provider.Settings.Secure;
import com.appsflyer.ServerParameters;
import com.telkom.mwallet.tcash.tap.p071a.C1975a.C1974a;
import com.telkom.mwallet.tcash.tap.p071a.C1976b;
import com.telkom.mwallet.tcash.tap.p071a.C1977c;
import java.util.Arrays;
import java.util.Locale;

public class MobilisApduService extends HostApduService {
    static final String f3944a = MobilisApduService.class.getSimpleName();
    private static final byte[] f3945b = m6060b("9000");
    private static final byte[] f3946c = m6060b("0000");
    private static final byte[] f3947d = m6058a("F0000000014D505041592E535953");
    private C1976b f3948e;

    public static byte[] m6058a(String str) {
        return m6060b("00A40400" + String.format("%02X", new Object[]{Integer.valueOf(str.length() / 2)}) + str);
    }

    public static byte[] m6059a(byte[] bArr, byte[]... bArr2) {
        int length = bArr.length;
        for (byte[] length2 : bArr2) {
            length += length2.length;
        }
        Object copyOf = Arrays.copyOf(bArr, length);
        int length3 = bArr.length;
        length = length3;
        for (Object obj : bArr2) {
            System.arraycopy(obj, 0, copyOf, length, obj.length);
            length += obj.length;
        }
        return copyOf;
    }

    public static byte[] m6060b(String str) {
        int length = str.length();
        if (length % 2 == 1) {
            throw new IllegalArgumentException("Hex string must have even number of characters");
        }
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public void onCreate() {
        super.onCreate();
        this.f3948e = new C1976b(getApplicationContext());
    }

    public void onDeactivated(int i) {
    }

    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        if (!Arrays.equals(f3947d, bArr)) {
            return f3946c;
        }
        C1977c a = this.f3948e.m7894a();
        if (a == null || C1974a.NFC != a.m7898a()) {
            return f3946c;
        }
        String toUpperCase = Secure.getString(getContentResolver(), ServerParameters.ANDROID_ID).toUpperCase(Locale.US);
        return m6059a(m6060b(String.format("%02X", new Object[]{Integer.valueOf(toUpperCase.length() / 2)})), m6060b(toUpperCase), f3945b);
    }
}
