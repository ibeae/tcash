package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;

public class fj {
    private final byte[] f1581a = new byte[NotificationCompat.FLAG_LOCAL_ONLY];
    private int f1582b;
    private int f1583c;

    public fj(byte[] bArr) {
        int i;
        for (i = 0; i < NotificationCompat.FLAG_LOCAL_ONLY; i++) {
            this.f1581a[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < NotificationCompat.FLAG_LOCAL_ONLY; i2++) {
            i = ((i + this.f1581a[i2]) + bArr[i2 % bArr.length]) & 255;
            byte b = this.f1581a[i2];
            this.f1581a[i2] = this.f1581a[i];
            this.f1581a[i] = b;
        }
        this.f1582b = 0;
        this.f1583c = 0;
    }

    public void m2510a(byte[] bArr) {
        int i = this.f1582b;
        int i2 = this.f1583c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.f1581a[i]) & 255;
            byte b = this.f1581a[i];
            this.f1581a[i] = this.f1581a[i2];
            this.f1581a[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.f1581a[(this.f1581a[i] + this.f1581a[i2]) & 255]);
        }
        this.f1582b = i;
        this.f1583c = i2;
    }
}
