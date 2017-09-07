package com.google.p021a.p023b.p024a;

import com.google.p021a.aa;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p025d.C0600c;
import java.math.BigDecimal;

public final class C0518b extends C0516q<BigDecimal> {
    public BigDecimal m851a(C0527a c0527a) {
        if (c0527a.mo811f() == C0600c.NULL) {
            c0527a.mo815j();
            return null;
        }
        try {
            return new BigDecimal(c0527a.mo813h());
        } catch (Throwable e) {
            throw new aa(e);
        }
    }

    public void m853a(C0530d c0530d, BigDecimal bigDecimal) {
        c0530d.mo822a((Number) bigDecimal);
    }

    public /* synthetic */ Object mo804b(C0527a c0527a) {
        return m851a(c0527a);
    }
}
