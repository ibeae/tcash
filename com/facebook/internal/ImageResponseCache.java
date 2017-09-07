package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache.Limits;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import twitter4j.HttpResponseCode;

class ImageResponseCache {
    static final String TAG = ImageResponseCache.class.getSimpleName();
    private static volatile FileLruCache imageCache;

    private static class BufferedHttpInputStream extends BufferedInputStream {
        HttpURLConnection connection;

        BufferedHttpInputStream(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, 8192);
            this.connection = httpURLConnection;
        }

        public void close() {
            super.close();
            Utility.disconnectQuietly(this.connection);
        }
    }

    ImageResponseCache() {
    }

    static void clearCache(Context context) {
        try {
            getCache(context).clearCache();
        } catch (IOException e) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + e.getMessage());
        }
    }

    static synchronized FileLruCache getCache(Context context) {
        FileLruCache fileLruCache;
        synchronized (ImageResponseCache.class) {
            if (imageCache == null) {
                imageCache = new FileLruCache(context.getApplicationContext(), TAG, new Limits());
            }
            fileLruCache = imageCache;
        }
        return fileLruCache;
    }

    static InputStream getCachedImageStream(URI uri, Context context) {
        InputStream inputStream = null;
        if (uri != null && isCDNURL(uri)) {
            try {
                inputStream = getCache(context).get(uri.toString());
            } catch (IOException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, e.toString());
            }
        }
        return inputStream;
    }

    static InputStream interceptAndCacheImageStream(Context context, HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        if (httpURLConnection.getResponseCode() == HttpResponseCode.OK) {
            URL url = httpURLConnection.getURL();
            inputStream = httpURLConnection.getInputStream();
            try {
                if (isCDNURL(url.toURI())) {
                    inputStream = getCache(context).interceptAndPut(url.toString(), new BufferedHttpInputStream(inputStream, httpURLConnection));
                }
            } catch (IOException e) {
            } catch (URISyntaxException e2) {
            }
        }
        return inputStream;
    }

    private static boolean isCDNURL(URI uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (host.endsWith("fbcdn.net")) {
                return true;
            }
            if (host.startsWith("fbcdn") && host.endsWith("akamaihd.net")) {
                return true;
            }
        }
        return false;
    }
}
