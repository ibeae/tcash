package com.skcc.wallet.framework.api;

import com.skcc.wallet.framework.C1302b;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class C1227c {
    private static final ReadWriteLock f2616b = new ReentrantReadWriteLock(true);
    private static final Lock f2617c = f2616b.readLock();
    private static final Lock f2618d = f2616b.writeLock();
    private C1302b f2619a;

    public C1227c(C1302b c1302b) {
        this.f2619a = c1302b;
    }

    public void m4536a() {
        f2618d.lock();
        try {
            this.f2619a.getSharedPreferences("CARD_BALANCE_INFO", 0).edit().clear().commit();
        } finally {
            f2618d.unlock();
        }
    }

    public void m4537a(String str, String str2) {
        f2618d.lock();
        try {
            this.f2619a.getSharedPreferences("CARD_BALANCE_INFO", 0).edit().putString(str, str2).commit();
        } finally {
            f2618d.unlock();
        }
    }

    public String m4538b(String str, String str2) {
        f2617c.lock();
        try {
            String string = this.f2619a.getSharedPreferences("CARD_BALANCE_INFO", 0).getString(str, str2);
            return string;
        } finally {
            f2617c.unlock();
        }
    }
}
