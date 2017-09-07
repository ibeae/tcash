package com.skcc.wallet.framework.api;

import com.skcc.wallet.core.se.instance.CRSApplication;
import com.skcc.wallet.framework.C1302b;

public class C1226b {
    private static String f2613c = "CRSManager";
    private CRSApplication f2614a = null;
    private C1302b f2615b;

    public C1226b(CRSApplication cRSApplication, C1302b c1302b) {
        this.f2614a = cRSApplication;
        this.f2615b = c1302b;
    }

    public void m4534a(String str) {
        this.f2614a.activateApp(str);
    }

    public void m4535b(String str) {
        this.f2614a.deactivateApp(str);
    }
}
