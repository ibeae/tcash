package com.appsflyer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.UUID;

public class Installation {
    private static final String INSTALLATION = "AF_INSTALLATION";
    private static String sID = null;

    private static String generateId(Context context) {
        return VERSION.SDK_INT >= 9 ? context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime + "-" + Math.abs(new Random().nextLong()) : UUID.randomUUID().toString();
    }

    public static synchronized String id(Context context) {
        String readInstallationSP;
        synchronized (Installation.class) {
            if (sID == null) {
                readInstallationSP = readInstallationSP(context);
                if (readInstallationSP != null) {
                    sID = readInstallationSP;
                } else {
                    File file = new File(context.getFilesDir(), INSTALLATION);
                    try {
                        if (file.exists()) {
                            sID = readInstallationFile(file);
                            file.delete();
                        } else {
                            sID = generateId(context);
                        }
                        writeInstallationSP(context, sID);
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            readInstallationSP = sID;
        }
        return readInstallationSP;
    }

    private static String readInstallationFile(File file) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        byte[] bArr = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.readFully(bArr);
                randomAccessFile.close();
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e) {
                    }
                }
            } catch (IOException e2) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e3) {
                    }
                }
                if (bArr == null) {
                    bArr = new byte[0];
                }
                return new String(bArr);
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            if (bArr == null) {
                bArr = new byte[0];
            }
            return new String(bArr);
        } catch (Throwable th3) {
            Throwable th4 = th3;
            randomAccessFile = null;
            th = th4;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        return new String(bArr);
    }

    private static String readInstallationSP(Context context) {
        return context.getSharedPreferences("appsflyer-data", 0).getString(INSTALLATION, null);
    }

    private static void writeInstallationFile(File file, Context context) {
        Throwable th;
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2;
        try {
            fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(generateId(context).getBytes());
                fileOutputStream2.close();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                    }
                }
            } catch (IOException e2) {
                if (fileOutputStream2 == null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (NameNotFoundException e4) {
                if (fileOutputStream2 == null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileOutputStream = fileOutputStream2;
                th = th3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            fileOutputStream2 = null;
            if (fileOutputStream2 == null) {
                fileOutputStream2.close();
            }
        } catch (NameNotFoundException e7) {
            fileOutputStream2 = null;
            if (fileOutputStream2 == null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th4) {
            th = th4;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    private static void writeInstallationSP(Context context) {
        writeInstallationSP(context, generateId(context));
    }

    @SuppressLint({"CommitPrefEdits"})
    private static void writeInstallationSP(Context context, String str) {
        Editor edit = context.getSharedPreferences("appsflyer-data", 0).edit();
        edit.putString(INSTALLATION, str);
        if (VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }
}
