package com.google.android.gcm;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class C0638a extends IntentService {
    private static WakeLock f779a;
    private static final Object f780b = C0638a.class;
    private static int f781d = 0;
    private static final Random f782e = new Random();
    private static final int f783f = ((int) TimeUnit.SECONDS.toMillis(3600));
    private static final String f784g = Long.toBinaryString(f782e.nextLong());
    private final String[] f785c;

    protected C0638a() {
        this(C0638a.m1313a("DynamicSenderIds"), null);
    }

    private C0638a(String str, String[] strArr) {
        super(str);
        this.f785c = strArr;
    }

    protected C0638a(String... strArr) {
        this(C0638a.m1314a(strArr), strArr);
    }

    private static String m1313a(String str) {
        StringBuilder append = new StringBuilder().append("GCMIntentService-").append(str).append("-");
        int i = f781d + 1;
        f781d = i;
        String stringBuilder = append.append(i).toString();
        Log.v("GCMBaseIntentService", "Intent service name: " + stringBuilder);
        return stringBuilder;
    }

    private static String m1314a(String[] strArr) {
        return C0638a.m1313a(C0639b.m1325a(strArr));
    }

    static void m1315a(Context context, Intent intent, String str) {
        synchronized (f780b) {
            if (f779a == null) {
                f779a = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "GCM_LIB");
            }
        }
        Log.v("GCMBaseIntentService", "Acquiring wakelock");
        f779a.acquire();
        intent.setClassName(context, str);
        context.startService(intent);
    }

    private void m1316b(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("registration_id");
        String stringExtra2 = intent.getStringExtra("error");
        String stringExtra3 = intent.getStringExtra("unregistered");
        Log.d("GCMBaseIntentService", "handleRegistration: registrationId = " + stringExtra + ", error = " + stringExtra2 + ", unregistered = " + stringExtra3);
        if (stringExtra != null) {
            C0639b.m1339i(context);
            C0639b.m1324a(context, stringExtra);
            mo1481c(context, stringExtra);
        } else if (stringExtra3 != null) {
            C0639b.m1339i(context);
            mo1482d(context, C0639b.m1337g(context));
        } else {
            Log.d("GCMBaseIntentService", "Registration error: " + stringExtra2);
            if (!"SERVICE_NOT_AVAILABLE".equals(stringExtra2)) {
                mo1480b(context, stringExtra2);
            } else if (mo1479a(context, stringExtra2)) {
                int j = C0639b.m1340j(context);
                int nextInt = f782e.nextInt(j) + (j / 2);
                Log.d("GCMBaseIntentService", "Scheduling registration retry, backoff = " + nextInt + " (" + j + ")");
                Intent intent2 = new Intent("com.google.android.gcm.intent.RETRY");
                intent2.putExtra(ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN, f784g);
                ((AlarmManager) context.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) nextInt), PendingIntent.getBroadcast(context, 0, intent2, 0));
                if (j < f783f) {
                    C0639b.m1327a(context, j * 2);
                }
            } else {
                Log.d("GCMBaseIntentService", "Not retrying failed operation");
            }
        }
    }

    protected void mo1477a(Context context, int i) {
    }

    protected abstract void mo1478a(Context context, Intent intent);

    protected boolean mo1479a(Context context, String str) {
        return true;
    }

    protected String[] m1320a(Context context) {
        if (this.f785c != null) {
            return this.f785c;
        }
        throw new IllegalStateException("sender id not set on constructor");
    }

    protected abstract void mo1480b(Context context, String str);

    protected abstract void mo1481c(Context context, String str);

    protected abstract void mo1482d(Context context, String str);

    public final void onHandleIntent(Intent intent) {
        String action;
        try {
            Context applicationContext = getApplicationContext();
            action = intent.getAction();
            if (action.equals("com.google.android.c2dm.intent.REGISTRATION")) {
                C0639b.m1334d(applicationContext);
                m1316b(applicationContext, intent);
            } else if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                action = intent.getStringExtra("message_type");
                if (action == null) {
                    mo1478a(applicationContext, intent);
                } else if (action.equals("deleted_messages")) {
                    action = intent.getStringExtra("total_deleted");
                    if (action != null) {
                        int parseInt = Integer.parseInt(action);
                        Log.v("GCMBaseIntentService", "Received deleted messages notification: " + parseInt);
                        mo1477a(applicationContext, parseInt);
                    }
                } else {
                    Log.e("GCMBaseIntentService", "Received unknown special message: " + action);
                }
            } else if (action.equals("com.google.android.gcm.intent.RETRY")) {
                action = intent.getStringExtra(ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN);
                if (!f784g.equals(action)) {
                    Log.e("GCMBaseIntentService", "Received invalid token: " + action);
                    synchronized (f780b) {
                        if (f779a != null) {
                            Log.v("GCMBaseIntentService", "Releasing wakelock");
                            f779a.release();
                        } else {
                            Log.e("GCMBaseIntentService", "Wakelock reference is null");
                        }
                    }
                    return;
                } else if (C0639b.m1336f(applicationContext)) {
                    C0639b.m1333c(applicationContext);
                } else {
                    C0639b.m1332b(applicationContext, m1320a(applicationContext));
                }
            }
        } catch (NumberFormatException e) {
            Log.e("GCMBaseIntentService", "GCM returned invalid number of deleted messages: " + action);
        } catch (Throwable th) {
            synchronized (f780b) {
                if (f779a != null) {
                    Log.v("GCMBaseIntentService", "Releasing wakelock");
                    f779a.release();
                } else {
                    Log.e("GCMBaseIntentService", "Wakelock reference is null");
                }
            }
        }
        synchronized (f780b) {
            if (f779a != null) {
                Log.v("GCMBaseIntentService", "Releasing wakelock");
                f779a.release();
            } else {
                Log.e("GCMBaseIntentService", "Wakelock reference is null");
            }
        }
    }
}
