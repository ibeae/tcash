package com.telkom.mwallet.coupon.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.internal.ServerProtocol;
import com.telkom.mwallet.coupon.p066b.C1444a;

public class C1486h {
    private Context f3518a;

    class C1485a extends SQLiteOpenHelper {
        final /* synthetic */ C1486h f3517a;

        public C1485a(C1486h c1486h, Context context) {
            this.f3517a = c1486h;
            super(context, "scanner_history.db", null, 2);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE history (id INTEGER PRIMARY KEY, content TEXT, type TEXT, display TEXT, timestamp INTEGER);");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS history");
            onCreate(sQLiteDatabase);
        }
    }

    public C1486h(Context context) {
        this.f3518a = context;
    }

    public void m5601a(C1444a c1444a) {
        if (c1444a != null) {
            SQLiteDatabase writableDatabase = new C1485a(this, this.f3518a).getWritableDatabase();
            try {
                writableDatabase.delete("history", "content=?", new String[]{c1444a.m5459a()});
                ContentValues contentValues = new ContentValues();
                contentValues.put("content", c1444a.m5459a());
                contentValues.put("type", c1444a.m5463b().toString());
                contentValues.put(ServerProtocol.DIALOG_PARAM_DISPLAY, c1444a.m5465c());
                contentValues.put("timestamp", Long.valueOf(c1444a.m5466d()));
                writableDatabase.insert("history", "timestamp", contentValues);
            } finally {
                writableDatabase.close();
            }
        }
    }
}
