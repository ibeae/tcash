package com.p005a.p006a.p007a.p008a;

import com.p005a.p006a.p007a.p008a.p010b.C0206a;
import java.io.File;

public abstract class C0201a implements C0200b {
    protected File f280a;
    private C0206a f281b;

    public C0201a(File file, C0206a c0206a) {
        if (file == null) {
            throw new IllegalArgumentException(String.format("\"%s\" argument must be not null", new Object[]{"cacheDir"}));
        } else if (c0206a == null) {
            throw new IllegalArgumentException(String.format("\"%s\" argument must be not null", new Object[]{"fileNameGenerator"}));
        } else {
            this.f280a = file;
            this.f281b = c0206a;
        }
    }
}
