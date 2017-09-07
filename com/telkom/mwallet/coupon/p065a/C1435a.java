package com.telkom.mwallet.coupon.p065a;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import com.skcc.wallet.core.p057a.C1216a;

final class C1435a implements AutoFocusCallback {
    private static final String f3279a = C1435a.class.getSimpleName();
    private Handler f3280b;
    private int f3281c;

    C1435a() {
    }

    void m5416a(Handler handler, int i) {
        this.f3280b = handler;
        this.f3281c = i;
    }

    public void onAutoFocus(boolean z, Camera camera) {
        if (this.f3280b != null) {
            this.f3280b.sendMessageDelayed(this.f3280b.obtainMessage(this.f3281c, Boolean.valueOf(z)), 1500);
            this.f3280b = null;
            return;
        }
        C1216a.m4519a(f3279a, "Got auto-focus callback, but no handler for it");
    }
}
