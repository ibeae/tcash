package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache.Limits;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

class UrlRedirectCache {
    private static final String REDIRECT_CONTENT_TAG = (TAG + "_Redirect");
    static final String TAG = UrlRedirectCache.class.getSimpleName();
    private static volatile FileLruCache urlRedirectCache;

    UrlRedirectCache() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void cacheUriRedirect(android.content.Context r5, java.net.URI r6, java.net.URI r7) {
        /*
        if (r6 == 0) goto L_0x0004;
    L_0x0002:
        if (r7 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 0;
        r1 = getCache(r5);	 Catch:{ IOException -> 0x0023, all -> 0x0028 }
        r2 = r6.toString();	 Catch:{ IOException -> 0x0023, all -> 0x0028 }
        r3 = REDIRECT_CONTENT_TAG;	 Catch:{ IOException -> 0x0023, all -> 0x0028 }
        r0 = r1.openPutStream(r2, r3);	 Catch:{ IOException -> 0x0023, all -> 0x0028 }
        r1 = r7.toString();	 Catch:{ IOException -> 0x0023, all -> 0x0030 }
        r1 = r1.getBytes();	 Catch:{ IOException -> 0x0023, all -> 0x0030 }
        r0.write(r1);	 Catch:{ IOException -> 0x0023, all -> 0x0030 }
        com.facebook.internal.Utility.closeQuietly(r0);
        goto L_0x0004;
    L_0x0023:
        r1 = move-exception;
        com.facebook.internal.Utility.closeQuietly(r0);
        goto L_0x0004;
    L_0x0028:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x002c:
        com.facebook.internal.Utility.closeQuietly(r1);
        throw r0;
    L_0x0030:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.UrlRedirectCache.cacheUriRedirect(android.content.Context, java.net.URI, java.net.URI):void");
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
        synchronized (UrlRedirectCache.class) {
            if (urlRedirectCache == null) {
                urlRedirectCache = new FileLruCache(context.getApplicationContext(), TAG, new Limits());
            }
            fileLruCache = urlRedirectCache;
        }
        return fileLruCache;
    }

    static URI getRedirectedUri(Context context, URI uri) {
        Throwable th;
        Object obj = null;
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        Closeable inputStreamReader;
        try {
            FileLruCache cache = getCache(context);
            String str = uri2;
            Closeable closeable = null;
            while (true) {
                try {
                    InputStream inputStream = cache.get(str, REDIRECT_CONTENT_TAG);
                    if (inputStream == null) {
                        break;
                    }
                    inputStreamReader = new InputStreamReader(inputStream);
                    try {
                        char[] cArr = new char[128];
                        StringBuilder stringBuilder = new StringBuilder();
                        while (true) {
                            int read = inputStreamReader.read(cArr, 0, cArr.length);
                            if (read <= 0) {
                                break;
                            }
                            stringBuilder.append(cArr, 0, read);
                        }
                        Utility.closeQuietly(inputStreamReader);
                        str = stringBuilder.toString();
                        closeable = inputStreamReader;
                        int i = 1;
                    } catch (URISyntaxException e) {
                    } catch (IOException e2) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (URISyntaxException e3) {
                    inputStreamReader = closeable;
                } catch (IOException e4) {
                    inputStreamReader = closeable;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = closeable;
                }
            }
            if (obj != null) {
                URI uri3 = new URI(str);
                Utility.closeQuietly(closeable);
                return uri3;
            }
            Utility.closeQuietly(closeable);
            return null;
        } catch (URISyntaxException e5) {
            inputStreamReader = null;
            Utility.closeQuietly(inputStreamReader);
            return null;
        } catch (IOException e6) {
            inputStreamReader = null;
            Utility.closeQuietly(inputStreamReader);
            return null;
        } catch (Throwable th4) {
            Throwable th5 = th4;
            inputStreamReader = null;
            th = th5;
            Utility.closeQuietly(inputStreamReader);
            throw th;
        }
    }
}
