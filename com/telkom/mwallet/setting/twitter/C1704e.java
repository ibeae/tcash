package com.telkom.mwallet.setting.twitter;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.skcc.wallet.core.p057a.C1216a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import twitter4j.HttpResponseCode;

public class C1704e extends Application {
    private static int f4308a = 720;

    public static Bitmap m6414a(File file) {
        if (!file.exists()) {
            return null;
        }
        C1216a.m4522b("getImage", "f.exist  " + file.getName());
        Options options = new Options();
        options.inSampleSize = 1;
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            C1216a.m4522b("getImage", "decode  " + decodeStream);
            return decodeStream;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    static String m6415a(String str, String str2, C1697c c1697c) {
        Throwable th;
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        Object httpGet = new HttpGet(str);
        try {
            HttpResponse execute = defaultHttpClient.execute(httpGet);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode != HttpResponseCode.OK) {
                C1216a.m4524d("ImageDownloader", "Error " + statusCode + " while retrieving bitmap from " + str);
                return null;
            }
            C1216a.m4522b("getImage", "download try...  " + str);
            HttpEntity entity = execute.getEntity();
            if (entity != null) {
                InputStream content;
                try {
                    content = entity.getContent();
                    try {
                        C1216a.m4522b("getImage", "download>savefile  " + str2);
                        synchronized (c1697c) {
                            OutputStream fileOutputStream = new FileOutputStream(str2);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = content.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                        content.close();
                        C1216a.m4522b("getImage", "download>file saved  ");
                        if (content != null) {
                            content.close();
                        }
                        entity.consumeContent();
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    content = null;
                    if (content != null) {
                        content.close();
                    }
                    entity.consumeContent();
                    throw th;
                }
            }
            return null;
        } catch (Exception e) {
            httpGet.abort();
            C1216a.m4521a("ImageDownloader", "Error while retrieving bitmap from " + str, e.toString());
            e.printStackTrace();
        }
    }
}
