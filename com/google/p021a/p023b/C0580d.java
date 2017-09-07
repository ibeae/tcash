package com.google.p021a.p023b;

import java.math.BigInteger;

public final class C0580d extends Number {
    private final String f618a;

    public C0580d(String str) {
        this.f618a = str;
    }

    public double doubleValue() {
        return Double.parseDouble(this.f618a);
    }

    public float floatValue() {
        return Float.parseFloat(this.f618a);
    }

    public int intValue() {
        try {
            return Integer.parseInt(this.f618a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f618a);
            } catch (NumberFormatException e2) {
                return new BigInteger(this.f618a).intValue();
            }
        }
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f618a);
        } catch (NumberFormatException e) {
            return new BigInteger(this.f618a).longValue();
        }
    }

    public String toString() {
        return this.f618a;
    }
}
