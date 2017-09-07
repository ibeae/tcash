package com.skcc.wallet.framework.api.http;

import android.text.TextUtils;
import com.skcc.wallet.core.p057a.C1216a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import twitter4j.HttpResponseCode;

public class C1257o {
    private static int f2669a = 60000;
    private static int f2670b = 10240;
    private int f2671c;
    private byte[] f2672d;
    private C1246g f2673e;
    private final HostnameVerifier f2674f;

    class C12541 implements HostnameVerifier {
        final /* synthetic */ C1257o f2668a;

        C12541(C1257o c1257o) {
            this.f2668a = c1257o;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    static class C12552 implements X509TrustManager {
        C12552() {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            C1216a.m4519a("WalletHttpConnection", "trustAllHosts>> checkClientTrusted");
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            C1216a.m4519a("WalletHttpConnection", "trustAllHosts>> checkServerTrusted");
        }

        public X509Certificate[] getAcceptedIssuers() {
            C1216a.m4519a("WalletHttpConnection", "trustAllHosts>> getAcceptedIssuers");
            return new X509Certificate[0];
        }
    }

    public interface C1256a {
        void mo1474a(int i);

        void mo1475a(String str);

        void mo1476a(byte[] bArr);
    }

    public C1257o() {
        this.f2671c = -1;
        this.f2672d = null;
        this.f2674f = new C12541(this);
        this.f2671c = f2669a;
        this.f2672d = new byte[f2670b];
    }

    public C1257o(C1246g c1246g) {
        this.f2671c = -1;
        this.f2672d = null;
        this.f2674f = new C12541(this);
        this.f2671c = f2669a;
        this.f2672d = new byte[f2670b];
        this.f2673e = c1246g;
    }

    private HttpURLConnection m4604a(String str) {
        Exception e;
        URL url = new URL(str);
        if (!url.getProtocol().equals("https")) {
            return (HttpURLConnection) url.openConnection();
        }
        C1216a.m4519a("WalletHttpConnection", "httpConnect>> HTTPS connection!");
        HttpURLConnection httpURLConnection;
        try {
            if (str.contains("checkWalletUpdate")) {
                C1257o.m4605a();
                httpURLConnection = (HttpsURLConnection) url.openConnection();
                try {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(this.f2674f);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return httpURLConnection;
                }
            }
            TrustManager[] trustManagerArr = new TrustManager[]{new C1250k()};
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, null);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            if ("mwallet.telkomsel.com".endsWith("202.3.208.22")) {
                httpsURLConnection.setHostnameVerifier(this.f2674f);
            }
            if ("mwallet.telkomsel.com".endsWith("10.250.20.61")) {
                httpsURLConnection.setHostnameVerifier(this.f2674f);
            }
            if ("mwallet.telkomsel.com".endsWith("10.250.20.59")) {
                httpsURLConnection.setHostnameVerifier(this.f2674f);
            }
            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
            C1216a.m4519a("WalletHttpConnection", "httpConnect>> https is OK.");
            return httpURLConnection;
        } catch (Exception e3) {
            Exception exception = e3;
            httpURLConnection = null;
            e = exception;
            e.printStackTrace();
            return httpURLConnection;
        }
    }

    private static void m4605a() {
        C1216a.m4519a("WalletHttpConnection", "trustAllHosts>>");
        TrustManager[] trustManagerArr = new TrustManager[]{new C12552()};
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m4606a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    private void m4607a(HttpURLConnection httpURLConnection, String str, C1256a c1256a) {
        InputStream inputStream = httpURLConnection.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream outputStream = null;
        if (!TextUtils.isEmpty(str)) {
            outputStream = new FileOutputStream(new File(str));
        }
        int contentLength = httpURLConnection.getContentLength();
        C1216a.m4519a("WalletHttpConnection", "Content Length :: " + contentLength);
        int i = 0;
        int i2 = 0;
        while (true) {
            int read = inputStream.read(this.f2672d, 0, this.f2672d.length);
            if (read < 0) {
                break;
            }
            if (outputStream != null) {
                outputStream.write(this.f2672d, 0, read);
            }
            byteArrayOutputStream.write(this.f2672d, 0, read);
            if (c1256a != null) {
                read += i2;
                i2 = (read * 100) / contentLength;
                if (i < i2) {
                    c1256a.mo1474a(i2);
                }
                i = i2;
                i2 = read;
            }
        }
        if (outputStream != null) {
            outputStream.close();
        }
        inputStream.close();
        if (c1256a != null) {
            c1256a.mo1476a(byteArrayOutputStream.toByteArray());
        }
    }

    private void m4608a(HttpURLConnection httpURLConnection, String str, byte[] bArr) {
        if (bArr == null) {
            throw new IOException("Request is null");
        }
        httpURLConnection.setConnectTimeout(this.f2671c);
        httpURLConnection.setReadTimeout(this.f2671c);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("Cookie", str);
        }
        if (bArr != null && bArr.length > 0) {
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = null;
            try {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
    }

    private String m4609b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(this.f2672d, 0, this.f2672d.length);
            if (read < 0) {
                String trim = new String(byteArrayOutputStream.toByteArray(), "UTF-8").trim();
                byteArrayOutputStream.close();
                inputStream.close();
                return trim;
            }
            byteArrayOutputStream.write(this.f2672d, 0, read);
        }
    }

    private void m4610b(String str) {
        synchronized (Object.class) {
            int length = str.length();
            if (length < 2000) {
                C1216a.m4519a("WalletHttpConnection", "Response :: " + str);
            } else {
                int i;
                int i2 = length / 2000;
                int i3 = length % 2000;
                for (i = 0; i < i2; i++) {
                    int i4 = i * 2000;
                    int i5 = i4 + 2000;
                    if (i == 0) {
                        C1216a.m4519a("WalletHttpConnection", "Response :: " + str.substring(i4, i5));
                    } else {
                        C1216a.m4519a("WalletHttpConnection", "\t" + str.substring(i4, i5));
                    }
                }
                if (i3 != 0) {
                    i = length - i3;
                    C1216a.m4519a("WalletHttpConnection", "\t" + str.substring(i, i + i3));
                }
            }
        }
    }

    private String m4611c(HttpURLConnection httpURLConnection) {
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            C1216a.m4519a("WalletHttpConnection", "Http header is null!");
            return null;
        }
        List list = (List) headerFields.get(headerFields.containsKey("Set-Cookie") ? "Set-Cookie" : "set-cookie");
        if (list == null) {
            C1216a.m4519a("WalletHttpConnection", "Cookies is null!");
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        int i = 0;
        while (i < size) {
            stringBuffer.append(((String) list.get(i)).substring(0, ((String) list.get(i)).indexOf(";")) + (i < size + -1 ? ";" : ""));
            i++;
        }
        String stringBuffer2 = stringBuffer.toString();
        C1216a.m4519a("WalletHttpConnection", "Cookie from Http header.(real ssl) :: " + stringBuffer2);
        return stringBuffer2;
    }

    public C1242c m4612a(C1243d c1243d, String str) {
        C1216a.m4519a("WalletHttpConnection", "current cookie :: " + str);
        C1242c c1242c = new C1242c();
        if (c1243d == null) {
            C1216a.m4519a("WalletHttpConnection", "Error :: HttpTask is null.");
            c1242c.m4566a(-1);
            c1242c.m4567a("HttpTask is null.");
        } else {
            try {
                C1216a.m4519a("WalletHttpConnection", "URL :: " + c1243d.m4575b());
                HttpURLConnection a = m4604a(c1243d.m4575b());
                String a2 = c1243d.m4573a();
                try {
                    byte[] bytes = a2.getBytes("UTF-8");
                    C1216a.m4519a("WalletHttpConnection", "Request :: " + a2);
                    C1216a.m4519a("WalletHttpConnection", "cookie ::" + str);
                    try {
                        m4608a(a, str, bytes);
                        try {
                            c1242c.m4566a(a.getResponseCode());
                            c1242c.m4567a(a.getResponseMessage());
                            if (c1242c.m4565a() == HttpResponseCode.OK) {
                                long currentTimeMillis = System.currentTimeMillis();
                                try {
                                    c1242c.m4569b(m4609b(a));
                                    C1216a.m4519a("WalletHttpConnection", "Request-Response Time :: " + (((double) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0d) + "s");
                                    c1242c.m4571c(m4611c(a));
                                    m4610b(c1242c.m4570c());
                                } catch (IOException e) {
                                    C1216a.m4519a("WalletHttpConnection", "Error :: connection ok but response failed. (IO Exp):: " + e.getMessage());
                                    c1242c.m4566a(-7);
                                    c1242c.m4567a(e.getMessage());
                                }
                            }
                            C1216a.m4519a("WalletHttpConnection", "HTTP Response Code :: " + c1242c.m4565a() + ", Message :: " + c1242c.m4568b());
                        } catch (IOException e2) {
                            C1216a.m4519a("WalletHttpConnection", "Error :: set code and message IO Exception :: " + e2.getMessage());
                            c1242c.m4566a(-8);
                            c1242c.m4567a(e2.getMessage());
                        }
                    } catch (IOException e22) {
                        C1216a.m4519a("WalletHttpConnection", "Error :: Send Request :: " + e22.getMessage());
                        m4606a(a);
                        c1242c.m4566a(-4);
                        c1242c.m4567a(e22.getMessage());
                    }
                } catch (UnsupportedEncodingException e3) {
                    C1216a.m4519a("WalletHttpConnection", "Error :: Make Request");
                    m4606a(a);
                    c1242c.m4566a(-3);
                    c1242c.m4567a(e3.getMessage());
                }
            } catch (MalformedURLException e4) {
                C1216a.m4519a("WalletHttpConnection", "Error :: Http Connect");
                c1242c.m4566a(-5);
                c1242c.m4567a(e4.getMessage());
            } catch (IOException e222) {
                C1216a.m4519a("WalletHttpConnection", "Error :: Http Connect");
                c1242c.m4566a(-6);
                c1242c.m4567a(e222.getMessage());
            }
        }
        return c1242c;
    }

    public C1242c m4613a(String str, String str2, String str3, C1256a c1256a) {
        C1216a.m4519a("WalletHttpConnection", "current cookie :: " + str3);
        C1242c c1242c = new C1242c();
        try {
            C1216a.m4519a("WalletHttpConnection", "URL :: " + str);
            HttpURLConnection a = m4604a(str);
            if (!TextUtils.isEmpty(str3)) {
                a.setRequestProperty("Cookie", str3);
            }
            try {
                c1242c.m4566a(a.getResponseCode());
                c1242c.m4567a(a.getResponseMessage());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    m4607a(a, str2, c1256a);
                    C1216a.m4519a("WalletHttpConnection", "Request-Response Time :: " + (((double) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0d) + "s");
                    C1216a.m4519a("WalletHttpConnection", "HTTP Response Code :: " + c1242c.m4565a() + ", Message :: " + c1242c.m4568b());
                } catch (IOException e) {
                    C1216a.m4519a("WalletHttpConnection", "Error :: set code and message IO Exception :: " + e.getMessage());
                    if (c1256a != null) {
                        c1256a.mo1475a(e.getMessage());
                    }
                    c1242c.m4566a(-8);
                    c1242c.m4567a(e.getMessage());
                }
            } catch (IOException e2) {
                C1216a.m4519a("WalletHttpConnection", "Error :: set code and message IO Exception :: " + e2.getMessage());
                if (c1256a != null) {
                    c1256a.mo1475a(e2.getMessage());
                }
                c1242c.m4566a(-8);
                c1242c.m4567a(e2.getMessage());
            }
        } catch (MalformedURLException e3) {
            C1216a.m4519a("WalletHttpConnection", "Error :: Http Connect");
            if (c1256a != null) {
                c1256a.mo1475a(e3.getMessage());
            }
            c1242c.m4566a(-5);
            c1242c.m4567a(e3.getMessage());
        } catch (IOException e22) {
            C1216a.m4519a("WalletHttpConnection", "Error :: Http Connect");
            if (c1256a != null) {
                c1256a.mo1475a(e22.getMessage());
            }
            c1242c.m4566a(-6);
            c1242c.m4567a(e22.getMessage());
        }
        return c1242c;
    }
}
