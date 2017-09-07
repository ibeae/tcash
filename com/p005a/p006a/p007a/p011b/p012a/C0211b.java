package com.p005a.p006a.p007a.p011b.p012a;

import android.graphics.Bitmap;
import com.p005a.p006a.p007a.p011b.C0209a;
import java.util.LinkedHashMap;

public class C0211b implements C0209a<String, Bitmap> {
    private final LinkedHashMap<String, Bitmap> f288a;
    private final int f289b;

    public C0211b(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f289b = i;
        this.f288a = new LinkedHashMap(0, 0.75f, true);
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", new Object[]{Integer.valueOf(this.f289b)});
    }
}
