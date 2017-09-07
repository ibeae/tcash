package com.amobee.richmedia.controller;

import android.content.Context;
import android.os.StatFs;
import com.amobee.richmedia.view.AmobeeView;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.jar.JarFile;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class OrmmaAssetController extends OrmmaController {
    private static final char[] HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String mSubDir = null;

    public OrmmaAssetController(AmobeeView amobeeView, Context context) {
        super(amobeeView, context);
    }

    private String asHex(MessageDigest messageDigest) {
        int i = 0;
        byte[] digest = messageDigest.digest();
        char[] cArr = new char[(digest.length * 2)];
        for (int i2 = 0; i2 < digest.length; i2++) {
            int i3 = i + 1;
            cArr[i] = HEX_CHARS[(digest[i2] >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = HEX_CHARS[digest[i2] & 15];
        }
        return new String(cArr);
    }

    public static boolean deleteDirectory(File file) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    deleteDirectory(listFiles[i]);
                } else {
                    listFiles[i].delete();
                }
            }
        }
        return file.delete();
    }

    public static boolean deleteDirectory(String str) {
        return str != null ? deleteDirectory(new File(str)) : false;
    }

    private File getAssetDir(String str) {
        return new File(new StringBuilder(String.valueOf(this.mContext.getFilesDir().getPath())).append(File.separator).append(str).toString());
    }

    private String getAssetName(String str) {
        return str.lastIndexOf(File.separatorChar) >= 0 ? str.substring(str.lastIndexOf(File.separatorChar) + 1) : str;
    }

    private String getAssetPath(String str) {
        return str.lastIndexOf(File.separatorChar) >= 0 ? str.substring(0, str.lastIndexOf(File.separatorChar)) : "/";
    }

    private String getFilesDir() {
        return this.mContext.getFilesDir().getPath();
    }

    private HttpEntity getHttpEntity(String str) {
        try {
            return new DefaultHttpClient().execute(new HttpGet(str)).getEntity();
        } catch (Exception e) {
            return null;
        }
    }

    private String moveToAdDirectory(String str, String str2, String str3) {
        this.mSubDir = str3;
        File file = new File(new StringBuilder(String.valueOf(str2)).append(File.separator).append(str).toString());
        new File(new StringBuilder(String.valueOf(str2)).append(File.separator).append("ad").toString()).mkdir();
        File file2 = new File(new StringBuilder(String.valueOf(str2)).append(File.separator).append("ad").append(File.separator).append(str3).toString());
        file2.mkdir();
        file.renameTo(new File(file2, file.getName()));
        return file2.getPath() + File.separator;
    }

    public static String readFileAsString(String str) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        String str2 = "";
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            str2 = new StringBuilder(String.valueOf(str2)).append(readLine).toString();
        }
        bufferedReader.close();
        return str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addAsset(java.lang.String r6, java.lang.String r7) {
        /*
        r5 = this;
        r1 = r5.getHttpEntity(r7);
        r0 = 0;
        r0 = r1.getContent();	 Catch:{ Exception -> 0x0030, all -> 0x0039 }
        r2 = 0;
        r5.writeToDisk(r0, r6, r2);	 Catch:{ Exception -> 0x0030, all -> 0x0049 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0030, all -> 0x0049 }
        r3 = "OrmmaAdController.addedAsset('";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0030, all -> 0x0049 }
        r2 = r2.append(r6);	 Catch:{ Exception -> 0x0030, all -> 0x0049 }
        r3 = "' )";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0030, all -> 0x0049 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0030, all -> 0x0049 }
        r3 = r5.mOrmmaView;	 Catch:{ Exception -> 0x0030, all -> 0x0049 }
        r3.injectJavaScript(r2);	 Catch:{ Exception -> 0x0030, all -> 0x0049 }
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        r0.close();	 Catch:{ Exception -> 0x0045 }
    L_0x002c:
        r1.consumeContent();	 Catch:{ Exception -> 0x0047 }
    L_0x002f:
        return;
    L_0x0030:
        r2 = move-exception;
        if (r0 == 0) goto L_0x002c;
    L_0x0033:
        r0.close();	 Catch:{ Exception -> 0x0037 }
        goto L_0x002c;
    L_0x0037:
        r0 = move-exception;
        goto L_0x002c;
    L_0x0039:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x003d:
        if (r1 == 0) goto L_0x0042;
    L_0x003f:
        r1.close();	 Catch:{ Exception -> 0x0043 }
    L_0x0042:
        throw r0;
    L_0x0043:
        r1 = move-exception;
        goto L_0x0042;
    L_0x0045:
        r0 = move-exception;
        goto L_0x002c;
    L_0x0047:
        r0 = move-exception;
        goto L_0x002f;
    L_0x0049:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amobee.richmedia.controller.OrmmaAssetController.addAsset(java.lang.String, java.lang.String):void");
    }

    public int cacheRemaining() {
        StatFs statFs = new StatFs(this.mContext.getFilesDir().getPath());
        return statFs.getFreeBlocks() * statFs.getBlockSize();
    }

    public String copyTextFromJarIntoAssetDir(String str, String str2) {
        Throwable th;
        String str3 = null;
        InputStream inputStream;
        try {
            String file = OrmmaAssetController.class.getClassLoader().getResource(str2).getFile();
            if (file.startsWith("file:")) {
                file = file.substring(5);
            }
            int indexOf = file.indexOf("!");
            if (indexOf > 0) {
                file = file.substring(0, indexOf);
            }
            JarFile jarFile = new JarFile(file);
            inputStream = jarFile.getInputStream(jarFile.getJarEntry(str2));
            try {
                System.out.println("Stream = " + inputStream);
                str3 = writeToDisk(inputStream, str, false);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return str3;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            inputStream = str3;
            if (inputStream != null) {
                inputStream.close();
            }
            return str3;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            inputStream = str3;
            th = th4;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        return str3;
    }

    public void deleteOldAds() {
        if (this.mSubDir != null) {
            deleteDirectory(new File(getFilesDir() + File.separator + "ad" + File.separator + this.mSubDir));
        }
    }

    protected void finalize() {
        deleteOldAds();
        super.finalize();
    }

    public FileOutputStream getAssetOutputString(String str) {
        File assetDir = getAssetDir(getAssetPath(str));
        assetDir.mkdirs();
        return new FileOutputStream(new File(assetDir, getAssetName(str)));
    }

    public String getAssetPath() {
        return "file://" + this.mContext.getFilesDir() + "/";
    }

    public void removeAsset(String str) {
        File assetDir = getAssetDir(getAssetPath(str));
        assetDir.mkdirs();
        new File(assetDir, getAssetName(str)).delete();
        this.mOrmmaView.injectJavaScript("OrmmaAdController.assetRemoved('" + str + "' )");
    }

    public void stopAllListeners() {
    }

    public String writeToDisk(InputStream inputStream, String str, boolean z) {
        MessageDigest instance;
        FileOutputStream fileOutputStream = null;
        byte[] bArr = new byte[1024];
        if (z) {
            try {
                instance = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                instance = null;
            }
        } else {
            instance = null;
        }
        try {
            Object moveToAdDirectory;
            fileOutputStream = getAssetOutputString(str);
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                if (z && instance != null) {
                    instance.update(bArr);
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
            }
            String filesDir = getFilesDir();
            if (!z || instance == null) {
                String str2 = filesDir;
            } else {
                moveToAdDirectory = moveToAdDirectory(str, filesDir, asHex(instance));
            }
            return new StringBuilder(String.valueOf(moveToAdDirectory)).append(str).toString();
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e3) {
                }
            }
        }
    }

    public String writeToDiskWrap(InputStream inputStream, String str, boolean z, String str2, String str3, String str4) {
        int read;
        StringBuffer stringBuffer;
        byte[] bArr = new byte[1024];
        MessageDigest messageDigest = null;
        if (z) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileOutputStream fileOutputStream = null;
        while (true) {
            try {
                read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                if (z && messageDigest != null) {
                    messageDigest.update(bArr);
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e2) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                    }
                }
            }
        }
        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
        Object obj = byteArrayOutputStream2.indexOf("<html") >= 0 ? 1 : null;
        if (obj != null) {
            StringBuffer stringBuffer2 = new StringBuffer(byteArrayOutputStream2);
            read = stringBuffer2.indexOf("/amobee_richmedia_bridge.js");
            if (read > -1) {
                stringBuffer2.replace(read, "/amobee_richmedia_bridge.js".length() + read, "file:/" + str3);
            }
            read = stringBuffer2.indexOf("/amobee_richmedia.js");
            if (read > -1) {
                stringBuffer2.replace(read, "/amobee_richmedia.js".length() + read, "file:/" + str4);
            }
            stringBuffer = stringBuffer2;
        } else {
            stringBuffer = null;
        }
        Object obj2 = byteArrayOutputStream2.indexOf("mraid.js") >= 0 ? 1 : null;
        fileOutputStream = getAssetOutputString(str);
        if (obj == null) {
            fileOutputStream.write("<html>".getBytes());
            fileOutputStream.write("<head>".getBytes());
            fileOutputStream.write("<meta name='viewport' content='".getBytes());
            fileOutputStream.write("user-scalable=no, initial-scale=1.0' />".getBytes());
            fileOutputStream.write("<title>Advertisement</title> ".getBytes());
            if (byteArrayOutputStream2.indexOf("<script") > -1) {
                fileOutputStream.write(("<script src=\"file://" + str3 + "\" type=\"text/javascript\"></script>").getBytes());
                fileOutputStream.write(("<script src=\"file://" + str4 + "\" type=\"text/javascript\"></script>").getBytes());
            }
            if (obj2 != null) {
                fileOutputStream.write("<script type=\"text/javascript\">".getBytes());
                fileOutputStream.write("ormmaview.scriptFound = true;".getBytes());
                fileOutputStream.write("</script>".getBytes());
            }
            if (str2 != null) {
                fileOutputStream.write("<script type=\"text/javascript\">".getBytes());
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.write("</script>".getBytes());
            }
            fileOutputStream.write("</head>".getBytes());
            fileOutputStream.write("<body style=\"margin:0; padding:0; overflow:hidden; background-color:transparent;text-align:center\">".getBytes());
            fileOutputStream.write("<div> ".getBytes());
        }
        if (obj == null) {
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
        } else {
            fileOutputStream.write(stringBuffer.toString().getBytes());
        }
        if (obj == null) {
            fileOutputStream.write("</div> ".getBytes());
            fileOutputStream.write("</body> ".getBytes());
            fileOutputStream.write("</html> ".getBytes());
        }
        fileOutputStream.flush();
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (Exception e4) {
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e5) {
            }
        }
        String filesDir = getFilesDir();
        return (!z || messageDigest == null) ? filesDir : moveToAdDirectory(str, filesDir, asHex(messageDigest));
    }
}
