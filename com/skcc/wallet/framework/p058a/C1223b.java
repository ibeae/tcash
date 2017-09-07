package com.skcc.wallet.framework.p058a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.C1224a.C1221a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

public class C1223b extends SQLiteOpenHelper {
    private static final ReentrantLock f2608d = new ReentrantLock();
    String f2609a = null;
    String f2610b = null;
    private Context f2611c;

    public C1223b(Context context) {
        super(context, "myCoupon.db", null, 2);
        this.f2611c = context;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar instance = Calendar.getInstance();
        this.f2609a = simpleDateFormat.format(instance.getTime());
        instance.add(5, 15);
        this.f2610b = simpleDateFormat.format(instance.getTime());
    }

    private void m4528a(SQLiteStatement sQLiteStatement, int i, String str) {
        if (str != null) {
            sQLiteStatement.bindString(i, str);
        } else {
            sQLiteStatement.bindNull(i);
        }
    }

    public int m4529a() {
        f2608d.lock();
        SQLiteDatabase sQLiteDatabase = null;
        String[] strArr = new String[]{this.f2610b};
        try {
            sQLiteDatabase = getWritableDatabase();
            int delete = sQLiteDatabase.delete("tblCouponImage", "expiryDate < ?", strArr);
            C1216a.m4519a("MyCouponDB", "remove>> rows::" + delete);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e) {
                }
            }
            f2608d.unlock();
            return delete;
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e2) {
                }
            }
            f2608d.unlock();
        }
    }

    public long m4530a(String str, byte[] bArr) {
        SQLiteDatabase writableDatabase;
        Throwable th;
        SQLiteStatement sQLiteStatement = null;
        f2608d.lock();
        try {
            writableDatabase = getWritableDatabase();
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(this.f2611c.getString(C1221a.insertCouponImage));
                sQLiteStatement = writableDatabase.compileStatement(stringBuffer.toString());
                sQLiteStatement.bindString(1, str);
                sQLiteStatement.bindBlob(2, bArr);
                long executeInsert = sQLiteStatement.executeInsert();
                C1216a.m4519a("MyCouponDB", "insert>> rowNum::" + executeInsert);
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
                f2608d.unlock();
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
                f2608d.unlock();
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
            f2608d.unlock();
            throw th;
        }
    }

    public byte[] m4531a(String str) {
        SQLiteDatabase readableDatabase;
        Exception exception;
        byte[] bArr;
        Exception exception2;
        Throwable th;
        f2608d.lock();
        Cursor rawQuery;
        try {
            readableDatabase = getReadableDatabase();
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String[] strArr = new String[]{str};
                stringBuffer.append(this.f2611c.getString(C1221a.selectCouponImage)).append(' ').append(this.f2611c.getString(C1221a.whereCouponImageUrl));
                C1216a.m4519a("MyCouponDB", "getCouponImage>> ");
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
                    f2608d.unlock();
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (readableDatabase != null) {
                        try {
                            readableDatabase.close();
                        } catch (Exception e5) {
                        }
                    }
                    f2608d.unlock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                rawQuery = null;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                f2608d.unlock();
                throw th;
            }
            try {
                if (rawQuery.moveToNext()) {
                    byte[] blob = rawQuery.getBlob(0);
                    try {
                        C1216a.m4519a("MyCouponDB", "getCouponImage>> couponImageUrl::" + str);
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
                        f2608d.unlock();
                        return bArr;
                    }
                }
                bArr = null;
                try {
                    rawQuery.close();
                    if (bArr != null) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(this.f2611c.getString(C1221a.updateCouponImageUsed)).append(' ').append(this.f2611c.getString(C1221a.whereCouponImageUrl));
                        SQLiteStatement compileStatement = readableDatabase.compileStatement(stringBuffer2.toString());
                        m4528a(compileStatement, 1, this.f2610b);
                        m4528a(compileStatement, 2, str);
                        compileStatement.execute();
                        compileStatement.clearBindings();
                    }
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
                    f2608d.unlock();
                } catch (Exception e9) {
                    exception2 = e9;
                    exception2.printStackTrace();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                    f2608d.unlock();
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
                f2608d.unlock();
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
            f2608d.unlock();
            return bArr;
        } catch (Throwable th4) {
            th = th4;
            rawQuery = null;
            readableDatabase = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (readableDatabase != null) {
                readableDatabase.close();
            }
            f2608d.unlock();
            throw th;
        }
        return bArr;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        String string = this.f2611c.getString(C1221a.createCouponTable);
        String string2 = this.f2611c.getString(C1221a.CouponImageTable);
        sQLiteDatabase.execSQL(string);
        sQLiteDatabase.execSQL(string2);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(this.f2611c.getString(C1221a.dropCouponIf));
        sQLiteDatabase.execSQL(this.f2611c.getString(C1221a.dropCouponImageIf));
        onCreate(sQLiteDatabase);
    }
}
