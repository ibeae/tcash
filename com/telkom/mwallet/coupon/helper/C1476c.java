package com.telkom.mwallet.coupon.helper;

import android.os.Handler;
import android.os.Looper;
import com.google.p031b.C1016a;
import com.google.p031b.C1084e;
import com.google.p031b.C1201p;
import com.telkom.mwallet.coupon.C1473h;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

final class C1476c extends Thread {
    private final C1473h f3493a;
    private final Hashtable<C1084e, Object> f3494b = new Hashtable(3);
    private Handler f3495c;
    private final CountDownLatch f3496d = new CountDownLatch(1);

    C1476c(C1473h c1473h, Vector<C1016a> vector, String str, C1201p c1201p) {
        Object vector2;
        this.f3493a = c1473h;
        if (vector == null || vector.isEmpty()) {
            vector2 = new Vector();
            vector2.addAll(C1474a.f3489a);
        }
        this.f3494b.put(C1084e.POSSIBLE_FORMATS, vector2);
        if (str != null) {
            this.f3494b.put(C1084e.CHARACTER_SET, str);
        }
        this.f3494b.put(C1084e.NEED_RESULT_POINT_CALLBACK, c1201p);
    }

    Handler m5589a() {
        try {
            this.f3496d.await();
        } catch (InterruptedException e) {
        }
        return this.f3495c;
    }

    public void run() {
        Looper.prepare();
        this.f3495c = new C1475b(this.f3493a, this.f3494b);
        this.f3496d.countDown();
        Looper.loop();
    }
}
