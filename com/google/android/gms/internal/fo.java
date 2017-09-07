package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class fo {
    private final fl f1596a;
    private final SecureRandom f1597b;

    public class C0808a extends Exception {
        final /* synthetic */ fo f1595a;

        public C0808a(fo foVar) {
            this.f1595a = foVar;
        }

        public C0808a(fo foVar, Throwable th) {
            this.f1595a = foVar;
            super(th);
        }
    }

    public fo(fl flVar, SecureRandom secureRandom) {
        this.f1596a = flVar;
        this.f1597b = secureRandom;
    }

    static void m2530a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] m2531a(String str) {
        try {
            byte[] a = this.f1596a.mo963a(str, false);
            if (a.length != 32) {
                throw new C0808a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            m2530a(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C0808a(this, e);
        }
    }

    public byte[] m2532a(byte[] bArr, String str) {
        if (bArr.length != 16) {
            throw new C0808a(this);
        }
        try {
            byte[] a = this.f1596a.mo963a(str, false);
            if (a.length <= 16) {
                throw new C0808a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (Throwable e) {
            throw new C0808a(this, e);
        } catch (Throwable e2) {
            throw new C0808a(this, e2);
        } catch (Throwable e22) {
            throw new C0808a(this, e22);
        } catch (Throwable e222) {
            throw new C0808a(this, e222);
        } catch (Throwable e2222) {
            throw new C0808a(this, e2222);
        } catch (Throwable e22222) {
            throw new C0808a(this, e22222);
        } catch (Throwable e222222) {
            throw new C0808a(this, e222222);
        }
    }
}
