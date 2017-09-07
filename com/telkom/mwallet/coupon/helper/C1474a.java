package com.telkom.mwallet.coupon.helper;

import android.content.Intent;
import com.google.p031b.C1016a;
import java.util.Vector;

public final class C1474a {
    static final Vector<C1016a> f3489a = new Vector(1);

    static {
        f3489a.add(C1016a.QR_CODE);
        f3489a.add(C1016a.UPC_A);
        f3489a.add(C1016a.UPC_E);
        f3489a.add(C1016a.EAN_13);
        f3489a.add(C1016a.EAN_8);
        f3489a.add(C1016a.RSS_14);
        f3489a.add(C1016a.CODE_128);
        f3489a.add(C1016a.CODE_39);
        f3489a.add(C1016a.CODE_93);
        f3489a.add(C1016a.CODABAR);
        f3489a.add(C1016a.ITF);
    }

    public static Vector<C1016a> m5587a(Intent intent) {
        return f3489a;
    }
}
