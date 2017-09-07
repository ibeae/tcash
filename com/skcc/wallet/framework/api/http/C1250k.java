package com.skcc.wallet.framework.api.http;

import java.math.BigInteger;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class C1250k implements X509TrustManager {
    private String f2660a = "3082010a0282010100d18763eda942966df2ffc1e27bb7d55ea2e822b57861907df54691c10d212cd0d006f702b7909ee8e6308938e9df6e13063fa3f96b1dc9fa3b467bfed5774748315f753d794135310a4441be4c6238f83bbbbae4ada4aeb2e8077aed3bd054c0fe492fa8b35cbab4125aa6bcee861acab3d911c1d160d9cbaf96ff0a4d67e9b534d77ce89828d4f4678e26b8f300e94e95ee48f7f8b61a2d9115d3388932eabe7359f9dc976e4c00d167eae4de6488f3271ec9aca2d3c8aa6c016f5b9df59fee4ced7d4a19c102f8e6526d365a27d7624e55c2864374e0966d427b9a75894b0d13c97448dd97a0a91c486ca2f7aa29dded92d3ce0c1b4d139b9e7dce048661810203010001";
    private String f2661b = "30820122300d06092a864886f70d01010105000382010f003082010a0282010100d18763eda942966df2ffc1e27bb7d55ea2e822b57861907df54691c10d212cd0d006f702b7909ee8e6308938e9df6e13063fa3f96b1dc9fa3b467bfed5774748315f753d794135310a4441be4c6238f83bbbbae4ada4aeb2e8077aed3bd054c0fe492fa8b35cbab4125aa6bcee861acab3d911c1d160d9cbaf96ff0a4d67e9b534d77ce89828d4f4678e26b8f300e94e95ee48f7f8b61a2d9115d3388932eabe7359f9dc976e4c00d167eae4de6488f3271ec9aca2d3c8aa6c016f5b9df59fee4ced7d4a19c102f8e6526d365a27d7624e55c2864374e0966d427b9a75894b0d13c97448dd97a0a91c486ca2f7aa29dded92d3ce0c1b4d139b9e7dce048661810203010001";

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (x509CertificateArr == null) {
            throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null");
        } else if (x509CertificateArr.length <= 0) {
            throw new IllegalArgumentException("checkServerTrusted: X509Certificate is empty");
        } else if (str == null || !str.contains("RSA")) {
            throw new CertificateException("checkServerTrusted: AuthType is not RSA");
        } else {
            try {
                TrustManagerFactory.getInstance("X509").init((KeyStore) null);
                String bigInteger = new BigInteger(1, ((RSAPublicKey) x509CertificateArr[0].getPublicKey()).getEncoded()).toString(16);
                boolean equalsIgnoreCase = this.f2660a.equalsIgnoreCase(bigInteger);
                boolean equalsIgnoreCase2 = this.f2661b.equalsIgnoreCase(bigInteger);
                if (!equalsIgnoreCase && !equalsIgnoreCase2) {
                    throw new CertificateException("checkServerTrusted: Expected public key: " + this.f2660a + ", got public key:" + bigInteger);
                }
            } catch (Throwable e) {
                e.printStackTrace();
                throw new CertificateException(e);
            }
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
