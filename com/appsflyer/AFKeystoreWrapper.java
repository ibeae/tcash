package com.appsflyer;

import android.content.Context;
import android.os.Build.VERSION;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;

class AFKeystoreWrapper {
    private static final String AF_KEYSTORE_EXTERNAL_DELIMITER = ",";
    private static final String AF_KEYSTORE_INTERNAL_DELIMITER = "=";
    private static final String AF_KEYSTORE_PREFIX = "com.appsflyer";
    public static final String AF_KEYSTORE_REINSTALL_COUNTER = "KSAppsFlyerRICounter";
    public static final String AF_KEYSTORE_UID = "KSAppsFlyerId";
    private static final String CN_ANDROID_SDK_O_APPS_FLYER = "CN=AndroidSDK, O=AppsFlyer";
    private static final int KEYSTORE_CERTIFICATE_VALIDITY_YEARS = 5;
    private static final String PROVIDER_ANDROID_KEY_STORE = "AndroidKeyStore";
    private static final String RSA_ALGORITHM = "RSA";
    private Context context;
    private KeyStore keystore;
    private final Object lock = new Object();
    private int reInstallCounter;
    private String uid;

    public AFKeystoreWrapper(Context context) {
        this.context = context;
        this.uid = "";
        this.reInstallCounter = 0;
        initKeyStore();
    }

    private void clearAllAFKeys() {
        synchronized (this.lock) {
            if (this.keystore != null) {
                try {
                    Enumeration aliases = this.keystore.aliases();
                    while (aliases.hasMoreElements()) {
                        String str = (String) aliases.nextElement();
                        if (isAppsFlyerPrefix(str)) {
                            AFLogger.afLog("Found AF key. Removing: " + str);
                            this.keystore.deleteEntry(str);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private void createKey(String str) {
        AFLogger.afLog("Creating a new key with alias: " + str);
        try {
            synchronized (this.lock) {
                if (this.keystore.containsAlias(str)) {
                    AFLogger.afLog("Alias already exists: " + str);
                } else {
                    Calendar instance = Calendar.getInstance();
                    Calendar instance2 = Calendar.getInstance();
                    instance2.add(1, 5);
                    AlgorithmParameterSpec algorithmParameterSpec = null;
                    if (VERSION.SDK_INT >= 23) {
                        algorithmParameterSpec = new Builder(str, 3).setCertificateSubject(new X500Principal(CN_ANDROID_SDK_O_APPS_FLYER)).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(instance.getTime()).setCertificateNotAfter(instance2.getTime()).build();
                    } else if (VERSION.SDK_INT >= 18) {
                        algorithmParameterSpec = new KeyPairGeneratorSpec.Builder(this.context).setAlias(str).setSubject(new X500Principal(CN_ANDROID_SDK_O_APPS_FLYER)).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                    }
                    KeyPairGenerator instance3 = KeyPairGenerator.getInstance(RSA_ALGORITHM, PROVIDER_ANDROID_KEY_STORE);
                    instance3.initialize(algorithmParameterSpec);
                    instance3.generateKeyPair();
                }
            }
        } catch (Exception e) {
            AFLogger.afLog("Exception " + e.getMessage() + " occurred");
        }
    }

    private void deleteKey(String str) {
        AFLogger.afLog("Deleting key with alias: " + str);
        try {
            synchronized (this.lock) {
                this.keystore.deleteEntry(str);
            }
        } catch (KeyStoreException e) {
            AFLogger.afLog("Exception " + e.getMessage() + " occurred");
        }
    }

    private String generateAliasString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.appsflyer").append(AF_KEYSTORE_EXTERNAL_DELIMITER);
        synchronized (this.lock) {
            stringBuilder.append(AF_KEYSTORE_UID).append(AF_KEYSTORE_INTERNAL_DELIMITER).append(this.uid).append(AF_KEYSTORE_EXTERNAL_DELIMITER);
            stringBuilder.append(AF_KEYSTORE_REINSTALL_COUNTER).append(AF_KEYSTORE_INTERNAL_DELIMITER).append(this.reInstallCounter);
        }
        return stringBuilder.toString();
    }

    private void initKeyStore() {
        AFLogger.afLog("Initialising KeyStore..");
        try {
            this.keystore = KeyStore.getInstance(PROVIDER_ANDROID_KEY_STORE);
            this.keystore.load(null);
            return;
        } catch (IOException e) {
        } catch (NoSuchAlgorithmException e2) {
        } catch (CertificateException e3) {
        } catch (KeyStoreException e4) {
        }
        AFLogger.afLog("Couldn't load keystore instance of type: AndroidKeyStore");
    }

    private boolean isAppsFlyerPrefix(String str) {
        return str.startsWith("com.appsflyer");
    }

    public void createFirstInstallData(String str) {
        this.uid = str;
        this.reInstallCounter = 0;
        createKey(generateAliasString());
    }

    public int getReInstallCounter() {
        int i;
        synchronized (this.lock) {
            i = this.reInstallCounter;
        }
        return i;
    }

    public String getUid() {
        String str;
        synchronized (this.lock) {
            str = this.uid;
        }
        return str;
    }

    public void incrementReInstallCounter() {
        String generateAliasString = generateAliasString();
        synchronized (this.lock) {
            this.reInstallCounter++;
            deleteKey(generateAliasString);
        }
        createKey(generateAliasString());
    }

    public boolean loadData() {
        boolean z;
        boolean z2 = true;
        synchronized (this.lock) {
            if (this.keystore != null) {
                try {
                    Enumeration aliases = this.keystore.aliases();
                    while (aliases.hasMoreElements()) {
                        String str = (String) aliases.nextElement();
                        if (str != null && isAppsFlyerPrefix(str)) {
                            String[] split = str.split(AF_KEYSTORE_EXTERNAL_DELIMITER);
                            if (split.length == 3) {
                                AFLogger.afLog("Found a matching AF key with alias:\n" + str);
                                try {
                                    String[] split2 = split[1].trim().split(AF_KEYSTORE_INTERNAL_DELIMITER);
                                    String[] split3 = split[2].trim().split(AF_KEYSTORE_INTERNAL_DELIMITER);
                                    if (split2.length == 2 && split3.length == 2) {
                                        this.uid = split2[1].trim();
                                        this.reInstallCounter = Integer.parseInt(split3[1].trim());
                                    }
                                    z = true;
                                } catch (Throwable th) {
                                    Object th2 = th;
                                    AFLogger.afLog("Couldn't list KeyStore Aliases: " + th2.getClass().getName());
                                    z = z2;
                                    return z;
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    z2 = false;
                    AFLogger.afLog("Couldn't list KeyStore Aliases: " + th2.getClass().getName());
                    z = z2;
                    return z;
                }
            }
            z = false;
        }
        return z;
    }

    public void setReInstallCounter(int i) {
        this.reInstallCounter = i;
    }

    public void setUid(String str) {
        this.uid = str;
    }
}
