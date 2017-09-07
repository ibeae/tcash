package com.telkom.mwallet.coupon.helper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.p031b.C1062c;
import com.google.p031b.C1078l;
import com.google.p031b.C1084e;
import com.google.p031b.C1196h;
import com.google.p031b.C1197i;
import com.google.p031b.C1199m;
import com.google.p031b.p034c.C1059j;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.coupon.C1473h;
import com.telkom.mwallet.coupon.p065a.C1437c;
import java.util.Hashtable;
import java.util.Map;

final class C1475b extends Handler {
    private static final String f3490a = C1475b.class.getSimpleName();
    private final C1473h f3491b;
    private final C1197i f3492c = new C1197i();

    C1475b(C1473h c1473h, Hashtable<C1084e, Object> hashtable) {
        this.f3492c.m4508a((Map) hashtable);
        this.f3491b = c1473h;
    }

    private void m5588a(byte[] bArr, int i, int i2) {
        C1199m a;
        Object obj;
        Message obtain;
        Bundle bundle;
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        C1197i c1197i = null;
        C1196h a2 = C1437c.m5428a().m5430a(bArr2, i2, i);
        try {
            a = this.f3492c.m4505a(new C1062c(new C1059j(a2)));
        } catch (C1078l e) {
            obj = c1197i;
            if (a != null) {
                obtain = Message.obtain(this.f3491b.m5581b(), R.id.decode_failed);
                if (obtain == null) {
                    try {
                        obtain.sendToTarget();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
            C1216a.m4519a(f3490a, "Found barcode (" + (System.currentTimeMillis() - currentTimeMillis) + " ms):\n" + a.toString());
            obtain = Message.obtain(this.f3491b.m5581b(), R.id.decode_succeeded, a);
            bundle = new Bundle();
            bundle.putParcelable("barcode_bitmap", a2.m5598f());
            obtain.setData(bundle);
            obtain.sendToTarget();
            return;
        } catch (Exception e22) {
            e22.printStackTrace();
            obj = c1197i;
            if (a != null) {
                C1216a.m4519a(f3490a, "Found barcode (" + (System.currentTimeMillis() - currentTimeMillis) + " ms):\n" + a.toString());
                obtain = Message.obtain(this.f3491b.m5581b(), R.id.decode_succeeded, a);
                bundle = new Bundle();
                bundle.putParcelable("barcode_bitmap", a2.m5598f());
                obtain.setData(bundle);
                obtain.sendToTarget();
                return;
            }
            obtain = Message.obtain(this.f3491b.m5581b(), R.id.decode_failed);
            if (obtain == null) {
                obtain.sendToTarget();
            }
        } finally {
            c1197i = this.f3492c;
            c1197i.mo1415a();
        }
        if (a != null) {
            C1216a.m4519a(f3490a, "Found barcode (" + (System.currentTimeMillis() - currentTimeMillis) + " ms):\n" + a.toString());
            obtain = Message.obtain(this.f3491b.m5581b(), R.id.decode_succeeded, a);
            bundle = new Bundle();
            bundle.putParcelable("barcode_bitmap", a2.m5598f());
            obtain.setData(bundle);
            obtain.sendToTarget();
            return;
        }
        obtain = Message.obtain(this.f3491b.m5581b(), R.id.decode_failed);
        if (obtain == null) {
            obtain.sendToTarget();
        }
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case R.id.decode:
                m5588a((byte[]) message.obj, message.arg1, message.arg2);
                return;
            case R.id.quit:
                Looper.myLooper().quit();
                return;
            default:
                return;
        }
    }
}
