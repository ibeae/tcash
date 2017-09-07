package com.telkom.mwallet.coupon.helper;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.p031b.C1016a;
import com.google.p031b.C1199m;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.coupon.C1473h;
import com.telkom.mwallet.coupon.p065a.C1437c;
import java.util.Vector;

public final class C1484g extends Handler {
    private static final String f3513a = C1484g.class.getSimpleName();
    private final C1473h f3514b;
    private final C1476c f3515c;
    private C1483a f3516d = C1483a.SUCCESS;

    private enum C1483a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public C1484g(C1473h c1473h, Vector<C1016a> vector, String str) {
        this.f3514b = c1473h;
        this.f3515c = new C1476c(c1473h, vector, str, new C1487i(c1473h.m5577a()));
        this.f3515c.start();
        C1437c.m5428a().m5435c();
        m5599b();
    }

    private void m5599b() {
        if (this.f3516d == C1483a.SUCCESS) {
            this.f3516d = C1483a.PREVIEW;
            C1437c.m5428a().m5431a(this.f3515c.m5589a(), R.id.decode);
            C1437c.m5428a().m5434b(this, R.id.auto_focus);
            this.f3514b.m5583d();
        }
    }

    public void m5600a() {
        this.f3516d = C1483a.DONE;
        C1437c.m5428a().m5436d();
        Message.obtain(this.f3515c.m5589a(), R.id.quit).sendToTarget();
        try {
            this.f3515c.join();
        } catch (InterruptedException e) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case R.id.auto_focus:
                if (this.f3516d == C1483a.PREVIEW) {
                    C1437c.m5428a().m5434b(this, R.id.auto_focus);
                    return;
                }
                return;
            case R.id.decode_failed:
                this.f3516d = C1483a.PREVIEW;
                C1437c.m5428a().m5431a(this.f3515c.m5589a(), R.id.decode);
                return;
            case R.id.decode_succeeded:
                C1216a.m4519a(f3513a, "Got decode succeeded message");
                this.f3516d = C1483a.SUCCESS;
                Bundle data = message.getData();
                this.f3514b.m5579a((C1199m) message.obj, data == null ? null : (Bitmap) data.getParcelable("barcode_bitmap"));
                C1216a.m4519a(f3513a, "message = " + message.toString());
                return;
            case R.id.launch_product_query:
                C1216a.m4519a(f3513a, "Got product query message");
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String) message.obj));
                intent.addFlags(524288);
                this.f3514b.startActivity(intent);
                return;
            case R.id.restart_preview:
                C1216a.m4519a(f3513a, "Got restart preview message");
                m5599b();
                return;
            case R.id.return_scan_result:
                C1216a.m4519a(f3513a, "Got return scan result message");
                return;
            default:
                return;
        }
    }
}
