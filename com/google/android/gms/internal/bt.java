package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.AppEventsConstants;
import java.util.LinkedList;
import java.util.List;

public class bt {
    private static final String f1076a = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
    private static final Object f1077c = new Object();
    private static bt f1078d;
    private final C0711a f1079b;

    public class C0711a extends SQLiteOpenHelper {
        final /* synthetic */ bt f1075a;

        public C0711a(bt btVar, Context context, String str) {
            this.f1075a = btVar;
            super(context, str, null, 4);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(bt.f1076a);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            dq.m2117c("Database updated from version " + i + " to version " + i2);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(sQLiteDatabase);
        }
    }

    private bt(Context context) {
        this.f1079b = new C0711a(this, context, "google_inapp_purchase.db");
    }

    public static bt m1781a(Context context) {
        bt btVar;
        synchronized (f1077c) {
            if (f1078d == null) {
                f1078d = new bt(context);
            }
            btVar = f1078d;
        }
        return btVar;
    }

    public SQLiteDatabase m1783a() {
        try {
            return this.f1079b.getWritableDatabase();
        } catch (SQLiteException e) {
            dq.m2120e("Error opening writable conversion tracking database");
            return null;
        }
    }

    public br m1784a(Cursor cursor) {
        return cursor == null ? null : new br(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public List<br> m1785a(long j) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        synchronized (f1077c) {
            List<br> linkedList = new LinkedList();
            if (j <= 0) {
                return linkedList;
            }
            SQLiteDatabase a = m1783a();
            if (a == null) {
                return linkedList;
            }
            try {
                query = a.query("InAppPurchase", null, null, null, null, null, "record_time ASC", String.valueOf(j));
                try {
                    if (query.moveToFirst()) {
                        do {
                            linkedList.add(m1784a(query));
                        } while (query.moveToNext());
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        dq.m2120e("Error extracing purchase info: " + e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        return linkedList;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                dq.m2120e("Error extracing purchase info: " + e.getMessage());
                if (query != null) {
                    query.close();
                }
                return linkedList;
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    public void m1786a(br brVar) {
        if (brVar != null) {
            synchronized (f1077c) {
                SQLiteDatabase a = m1783a();
                if (a == null) {
                    return;
                }
                a.delete("InAppPurchase", String.format("%s = %d", new Object[]{"purchase_id", Long.valueOf(brVar.f1065a)}), null);
            }
        }
    }

    public int m1787b() {
        Cursor cursor = null;
        int i = 0;
        synchronized (f1077c) {
            SQLiteDatabase a = m1783a();
            if (a == null) {
            } else {
                try {
                    cursor = a.rawQuery("select count(*) from InAppPurchase", null);
                    if (cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } else {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (SQLiteException e) {
                    dq.m2120e("Error getting record count" + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1788b(com.google.android.gms.internal.br r7) {
        /*
        r6 = this;
        if (r7 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r1 = f1077c;
        monitor-enter(r1);
        r0 = r6.m1783a();	 Catch:{ all -> 0x000e }
        if (r0 != 0) goto L_0x0011;
    L_0x000c:
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0002;
    L_0x000e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        throw r0;
    L_0x0011:
        r2 = new android.content.ContentValues;	 Catch:{ all -> 0x000e }
        r2.<init>();	 Catch:{ all -> 0x000e }
        r3 = "product_id";
        r4 = r7.f1067c;	 Catch:{ all -> 0x000e }
        r2.put(r3, r4);	 Catch:{ all -> 0x000e }
        r3 = "developer_payload";
        r4 = r7.f1066b;	 Catch:{ all -> 0x000e }
        r2.put(r3, r4);	 Catch:{ all -> 0x000e }
        r3 = "record_time";
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x000e }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x000e }
        r2.put(r3, r4);	 Catch:{ all -> 0x000e }
        r3 = "InAppPurchase";
        r4 = 0;
        r2 = r0.insert(r3, r4, r2);	 Catch:{ all -> 0x000e }
        r7.f1065a = r2;	 Catch:{ all -> 0x000e }
        r0 = r6.m1787b();	 Catch:{ all -> 0x000e }
        r2 = (long) r0;	 Catch:{ all -> 0x000e }
        r4 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0048;
    L_0x0045:
        r6.m1789c();	 Catch:{ all -> 0x000e }
    L_0x0048:
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0002;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.bt.b(com.google.android.gms.internal.br):void");
    }

    public void m1789c() {
        Cursor query;
        SQLiteException e;
        Throwable th;
        synchronized (f1077c) {
            SQLiteDatabase a = m1783a();
            if (a == null) {
                return;
            }
            try {
                query = a.query("InAppPurchase", null, null, null, null, null, "record_time ASC", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            m1786a(m1784a(query));
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            dq.m2120e("Error remove oldest record" + e.getMessage());
                            if (query != null) {
                                query.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                dq.m2120e("Error remove oldest record" + e.getMessage());
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }
}
