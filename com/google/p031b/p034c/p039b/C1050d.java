package com.google.p031b.p034c.p039b;

import java.util.ArrayList;
import java.util.List;

public final class C1050d {
    private final C1047a f2182a;
    private final List<C1048b> f2183b = new ArrayList();

    public C1050d(C1047a c1047a) {
        this.f2182a = c1047a;
        this.f2183b.add(new C1048b(c1047a, new int[]{1}));
    }

    private C1048b m3844a(int i) {
        if (i >= this.f2183b.size()) {
            C1048b c1048b = (C1048b) this.f2183b.get(this.f2183b.size() - 1);
            C1048b c1048b2 = c1048b;
            for (int size = this.f2183b.size(); size <= i; size++) {
                c1048b2 = c1048b2.m3836b(new C1048b(this.f2182a, new int[]{1, this.f2182a.m3821a((size - 1) + this.f2182a.m3829d())}));
                this.f2183b.add(c1048b2);
            }
        }
        return (C1048b) this.f2183b.get(i);
    }

    public void m3845a(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        C1048b a = m3844a(i);
        Object obj = new int[length];
        System.arraycopy(iArr, 0, obj, 0, length);
        obj = new C1048b(this.f2182a, obj).m3831a(i, 1).m3839c(a)[1].m3833a();
        int length2 = i - obj.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(obj, 0, iArr, length + length2, obj.length);
    }
}
