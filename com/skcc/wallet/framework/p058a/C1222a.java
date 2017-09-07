package com.skcc.wallet.framework.p058a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.C1224a.C1221a;
import java.util.concurrent.locks.ReentrantLock;

public class C1222a extends SQLiteOpenHelper {
    private static final ReentrantLock f2606b = new ReentrantLock();
    private Context f2607a;

    public C1222a(Context context) {
        super(context, "cardImageDB.db", null, 2);
        this.f2607a = context;
    }

    public long m4526a(String str, byte[] bArr) {
        Throwable th;
        SQLiteStatement sQLiteStatement = null;
        f2606b.lock();
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = getWritableDatabase();
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(this.f2607a.getString(C1221a.insertCardImage));
                sQLiteStatement = writableDatabase.compileStatement(stringBuffer.toString());
                sQLiteStatement.bindString(1, str);
                sQLiteStatement.bindBlob(2, bArr);
                long executeInsert = sQLiteStatement.executeInsert();
                C1216a.m4519a("CardImageDB", "insert>> rowNum::" + executeInsert);
                sQLiteStatement.clearBindings();
                sQLiteStatement.close();
                writableDatabase.close();
                if (sQLiteStatement != null) {
                    try {
                        sQLiteStatement.close();
                    } catch (Exception e) {
                    }
                }
                if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                    } catch (Exception e2) {
                    }
                }
                f2606b.unlock();
                return executeInsert;
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteStatement != null) {
                    try {
                        sQLiteStatement.close();
                    } catch (Exception e3) {
                    }
                }
                if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                    } catch (Exception e4) {
                    }
                }
                f2606b.unlock();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            writableDatabase = null;
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            f2606b.unlock();
            throw th;
        }
    }

    public byte[] m4527a(String str) {
        SQLiteDatabase readableDatabase;
        Exception exception;
        byte[] bArr;
        Exception exception2;
        Throwable th;
        Cursor cursor = null;
        f2606b.lock();
        Cursor rawQuery;
        try {
            readableDatabase = getReadableDatabase();
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String[] strArr = new String[]{str};
                stringBuffer.append(this.f2607a.getString(C1221a.selectCardImage)).append(' ').append(this.f2607a.getString(C1221a.whereCardImageUrl));
                C1216a.m4519a("CardImageDB", "getCardImage>> ");
                rawQuery = readableDatabase.rawQuery(stringBuffer.toString(), strArr);
            } catch (Exception e) {
                rawQuery = null;
                exception = e;
                bArr = null;
                exception2 = exception;
                try {
                    exception2.printStackTrace();
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e2) {
                        }
                    }
                    if (readableDatabase != null) {
                        try {
                            readableDatabase.close();
                        } catch (Exception e3) {
                        }
                    }
                    f2606b.unlock();
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (readableDatabase != null) {
                        try {
                            readableDatabase.close();
                        } catch (Exception e5) {
                        }
                    }
                    f2606b.unlock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                f2606b.unlock();
                throw th;
            }
            try {
                if (rawQuery.moveToNext()) {
                    byte[] blob = rawQuery.getBlob(0);
                    try {
                        C1216a.m4519a("CardImageDB", "getCardImage>> cardImageUrl::" + str);
                        bArr = blob;
                    } catch (Exception e6) {
                        exception = e6;
                        bArr = blob;
                        exception2 = exception;
                        exception2.printStackTrace();
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        if (readableDatabase != null) {
                            readableDatabase.close();
                        }
                        f2606b.unlock();
                        return bArr;
                    }
                }
                bArr = null;
                try {
                    rawQuery.close();
                    readableDatabase.close();
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e7) {
                        }
                    }
                    if (readableDatabase != null) {
                        try {
                            readableDatabase.close();
                        } catch (Exception e8) {
                        }
                    }
                    f2606b.unlock();
                } catch (Exception e9) {
                    exception2 = e9;
                    exception2.printStackTrace();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                    f2606b.unlock();
                    return bArr;
                }
            } catch (Exception e62) {
                exception = e62;
                bArr = null;
                exception2 = exception;
                exception2.printStackTrace();
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                f2606b.unlock();
                return bArr;
            }
        } catch (Exception e622) {
            rawQuery = null;
            readableDatabase = null;
            exception = e622;
            bArr = null;
            exception2 = exception;
            exception2.printStackTrace();
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (readableDatabase != null) {
                readableDatabase.close();
            }
            f2606b.unlock();
            return bArr;
        } catch (Throwable th4) {
            th = th4;
            readableDatabase = null;
            if (cursor != null) {
                cursor.close();
            }
            if (readableDatabase != null) {
                readableDatabase.close();
            }
            f2606b.unlock();
            throw th;
        }
        return bArr;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.f2607a.getString(C1221a.CardImageTable));
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(this.f2607a.getString(C1221a.dropCardImageIf));
        onCreate(sQLiteDatabase);
    }
}
