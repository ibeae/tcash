package com.skcc.wallet.framework.api;

import com.skcc.wallet.framework.C1302b;
import com.skcc.wallet.framework.p061c.C1305b;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class C1272r {
    private static final ReadWriteLock f2695b = new ReentrantReadWriteLock(true);
    private static final Lock f2696c = f2695b.readLock();
    private static final Lock f2697d = f2695b.writeLock();
    private C1302b f2698a;

    public C1272r(C1302b c1302b) {
        this.f2698a = c1302b;
    }

    public void m4645a() {
        f2697d.lock();
        try {
            this.f2698a.getSharedPreferences("WALLET_SETTING", 4).edit().clear().commit();
        } finally {
            f2697d.unlock();
        }
    }

    public void m4646a(String str) {
        f2697d.lock();
        try {
            this.f2698a.getSharedPreferences("WALLET_SETTING", 4).edit().remove(str).commit();
        } finally {
            f2697d.unlock();
        }
    }

    public void m4647a(String str, long j) {
        f2697d.lock();
        try {
            this.f2698a.getSharedPreferences("WALLET_SETTING", 4).edit().putLong(str, j).commit();
        } finally {
            f2697d.unlock();
        }
    }

    public void m4648a(String str, String str2) {
        try {
            f2697d.lock();
            new C1305b(this.f2698a, "WALLET_SETTING", "mW4II3t123").m4758b(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            m4653c(str, str2);
        } finally {
            f2697d.unlock();
        }
    }

    public void m4649a(String str, boolean z) {
        f2697d.lock();
        try {
            this.f2698a.getSharedPreferences("WALLET_SETTING", 4).edit().putBoolean(str, z).commit();
        } finally {
            f2697d.unlock();
        }
    }

    public long m4650b(String str, long j) {
        f2696c.lock();
        try {
            long j2 = this.f2698a.getSharedPreferences("WALLET_SETTING", 4).getLong(str, j);
            return j2;
        } finally {
            f2696c.unlock();
        }
    }

    public String m4651b(String str, String str2) {
        String a;
        try {
            f2696c.lock();
            a = new C1305b(this.f2698a, "WALLET_SETTING", "mW4II3t123").m4753a(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            a = m4654d(str, str2);
        } finally {
            f2696c.unlock();
        }
        return a;
    }

    public boolean m4652b(String str, boolean z) {
        f2696c.lock();
        try {
            boolean z2 = this.f2698a.getSharedPreferences("WALLET_SETTING", 4).getBoolean(str, z);
            return z2;
        } finally {
            f2696c.unlock();
        }
    }

    public void m4653c(String str, String str2) {
        f2697d.lock();
        try {
            this.f2698a.getSharedPreferences("WALLET_SETTING", 4).edit().putString(str, str2).commit();
        } finally {
            f2697d.unlock();
        }
    }

    public String m4654d(String str, String str2) {
        f2696c.lock();
        try {
            String string = this.f2698a.getSharedPreferences("WALLET_SETTING", 4).getString(str, str2);
            return string;
        } finally {
            f2696c.unlock();
        }
    }
}
