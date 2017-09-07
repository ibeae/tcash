package com.p005a.p006a.p007a.p008a;

import com.p005a.p006a.p007a.p008a.p010b.C0206a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class C0202c extends C0201a {
    private final AtomicInteger f282b;
    private final int f283c;
    private final Map<File, Long> f284d = Collections.synchronizedMap(new HashMap());

    class C02081 implements Runnable {
        final /* synthetic */ C0202c f285a;

        C02081(C0202c c0202c) {
            this.f285a = c0202c;
        }

        public void run() {
            int i = 0;
            File[] listFiles = this.f285a.a.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                while (i < length) {
                    File file = listFiles[i];
                    i2 += this.f285a.mo261a(file);
                    this.f285a.f284d.put(file, Long.valueOf(file.lastModified()));
                    i++;
                }
                this.f285a.f282b.set(i2);
            }
        }
    }

    public C0202c(File file, C0206a c0206a, int i) {
        super(file, c0206a);
        this.f283c = i;
        this.f282b = new AtomicInteger();
        m713a();
    }

    private void m713a() {
        new Thread(new C02081(this)).start();
    }

    protected abstract int mo261a(File file);
}
