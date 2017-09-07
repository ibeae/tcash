package com.telkom.mwallet.coupon.helper;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.google.p031b.C1196h;

public final class C1482f extends C1196h {
    private final byte[] f3504a;
    private final int f3505b;
    private final int f3506c;
    private final int f3507d;
    private final int f3508e;

    public C1482f(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            this.f3504a = bArr;
            this.f3505b = i;
            this.f3506c = i2;
            this.f3507d = i3;
            this.f3508e = i4;
        } else {
            this.f3504a = bArr;
            this.f3505b = i;
            this.f3506c = i2;
            this.f3507d = i3;
            this.f3508e = i4;
        }
    }

    public byte[] mo1528a() {
        int i = 0;
        int b = m4500b();
        int c = m4501c();
        if (b == this.f3505b && c == this.f3506c) {
            return this.f3504a;
        }
        int i2 = b * c;
        Object obj = new byte[i2];
        int i3 = (this.f3508e * this.f3505b) + this.f3507d;
        if (b == this.f3505b) {
            System.arraycopy(this.f3504a, i3, obj, 0, i2);
            return obj;
        }
        Object obj2 = this.f3504a;
        while (i < c) {
            System.arraycopy(obj2, i3, obj, i * b, b);
            i3 += this.f3505b;
            i++;
        }
        return obj;
    }

    public byte[] mo1529a(int i, byte[] bArr) {
        if (i < 0 || i >= m4501c()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        Object obj;
        int b = m4500b();
        if (bArr == null || bArr.length < b) {
            obj = new byte[b];
        }
        System.arraycopy(this.f3504a, ((this.f3508e + i) * this.f3505b) + this.f3507d, obj, 0, b);
        return obj;
    }

    public Bitmap m5598f() {
        int b = m4500b();
        int c = m4501c();
        int[] iArr = new int[(b * c)];
        byte[] bArr = this.f3504a;
        int i = (this.f3508e * this.f3505b) + this.f3507d;
        for (int i2 = 0; i2 < c; i2++) {
            int i3 = i2 * b;
            for (int i4 = 0; i4 < b; i4++) {
                iArr[i3 + i4] = ((bArr[i + i4] & 255) * 65793) | -16777216;
            }
            i += this.f3505b;
        }
        Bitmap createBitmap = Bitmap.createBitmap(b, c, Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, b, 0, 0, b, c);
        return createBitmap;
    }
}
