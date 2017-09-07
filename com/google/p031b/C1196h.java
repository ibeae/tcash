package com.google.p031b;

public abstract class C1196h {
    private final int f2585a;
    private final int f2586b;

    protected C1196h(int i, int i2) {
        this.f2585a = i;
        this.f2586b = i2;
    }

    public abstract byte[] mo1528a();

    public abstract byte[] mo1529a(int i, byte[] bArr);

    public final int m4500b() {
        return this.f2585a;
    }

    public final int m4501c() {
        return this.f2586b;
    }

    public boolean m4502d() {
        return false;
    }

    public C1196h m4503e() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        byte[] bArr = new byte[this.f2585a];
        StringBuilder stringBuilder = new StringBuilder(this.f2586b * (this.f2585a + 1));
        byte[] bArr2 = bArr;
        for (int i = 0; i < this.f2586b; i++) {
            bArr2 = mo1529a(i, bArr2);
            for (int i2 = 0; i2 < this.f2585a; i2++) {
                int i3 = bArr2[i2] & 255;
                char c = i3 < 64 ? '#' : i3 < 128 ? '+' : i3 < 192 ? '.' : ' ';
                stringBuilder.append(c);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
