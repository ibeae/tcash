package com.google.p021a.p023b.p024a;

import com.google.p021a.aa;
import com.google.p021a.p025d.C0527a;
import com.google.p021a.p025d.C0530d;
import com.google.p021a.p025d.C0600c;
import java.math.BigInteger;

public final class C0519c extends C0516q<BigInteger> {
    public BigInteger m855a(C0527a c0527a) {
        if (c0527a.mo811f() == C0600c.NULL) {
            c0527a.mo815j();
            return null;
        }
        try {
            return new BigInteger(c0527a.mo813h());
        } catch (Throwable e) {
            throw new aa(e);
        }
    }

    public void m857a(C0530d c0530d, BigInteger bigInteger) {
        c0530d.mo822a((Number) bigInteger);
    }

    public /* synthetic */ Object mo804b(C0527a c0527a) {
        return m855a(c0527a);
    }
}
