package com.telkom.mwallet.coupon.p065a;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import com.skcc.wallet.core.p057a.C1216a;

final class C1439e implements PreviewCallback {
    private static final String f3305a = C1439e.class.getSimpleName();
    private final C1436b f3306b;
    private final boolean f3307c;
    private Handler f3308d;
    private int f3309e;

    C1439e(C1436b c1436b, boolean z) {
        this.f3306b = c1436b;
        this.f3307c = z;
    }

    void m5446a(Handler handler, int i) {
        this.f3308d = handler;
        this.f3309e = i;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a = this.f3306b.m5422a();
        if (!this.f3307c) {
            camera.setPreviewCallback(null);
        }
        if (this.f3308d != null) {
            this.f3308d.obtainMessage(this.f3309e, a.x, a.y, bArr).sendToTarget();
            this.f3308d = null;
            return;
        }
        C1216a.m4519a(f3305a, "Got preview callback, but no handler for it");
    }
}
