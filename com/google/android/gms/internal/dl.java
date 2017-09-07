package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;

public final class dl {
    private final Context f1334a;
    private String f1335b;
    private final float f1336c;
    private float f1337d;
    private float f1338e;
    private float f1339f;
    private int f1340g;

    class C07492 implements OnClickListener {
        final /* synthetic */ dl f1333a;

        C07492(dl dlVar) {
            this.f1333a = dlVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public dl(Context context) {
        this.f1340g = 0;
        this.f1334a = context;
        this.f1336c = context.getResources().getDisplayMetrics().density;
    }

    public dl(Context context, String str) {
        this(context);
        this.f1335b = str;
    }

    private void m2089a() {
        Object obj;
        if (TextUtils.isEmpty(this.f1335b)) {
            obj = "No debug information";
        } else {
            Uri build = new Builder().encodedQuery(this.f1335b).build();
            StringBuilder stringBuilder = new StringBuilder();
            Map a = dk.m2062a(build);
            for (String str : a.keySet()) {
                stringBuilder.append(str).append(" = ").append((String) a.get(str)).append("\n\n");
            }
            obj = stringBuilder.toString().trim();
            if (TextUtils.isEmpty(obj)) {
                obj = "No debug information";
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1334a);
        builder.setMessage(obj);
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new OnClickListener(this) {
            final /* synthetic */ dl f1332b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f1332b.f1334a.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", obj), "Share via"));
            }
        });
        builder.setNegativeButton("Close", new C07492(this));
        builder.create().show();
    }

    private void m2090a(int i, float f, float f2) {
        if (i == 0) {
            this.f1340g = 0;
            this.f1337d = f;
            this.f1338e = f2;
            this.f1339f = f2;
        } else if (this.f1340g == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.f1338e) {
                    this.f1338e = f2;
                } else if (f2 < this.f1339f) {
                    this.f1339f = f2;
                }
                if (this.f1338e - this.f1339f > 30.0f * this.f1336c) {
                    this.f1340g = -1;
                    return;
                }
                if (this.f1340g == 0 || this.f1340g == 2) {
                    if (f - this.f1337d >= 50.0f * this.f1336c) {
                        this.f1337d = f;
                        this.f1340g++;
                    }
                } else if ((this.f1340g == 1 || this.f1340g == 3) && f - this.f1337d <= -50.0f * this.f1336c) {
                    this.f1337d = f;
                    this.f1340g++;
                }
                if (this.f1340g == 1 || this.f1340g == 3) {
                    if (f > this.f1337d) {
                        this.f1337d = f;
                    }
                } else if (this.f1340g == 2 && f < this.f1337d) {
                    this.f1337d = f;
                }
            } else if (i == 1 && this.f1340g == 4) {
                m2089a();
            }
        }
    }

    public void m2091a(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            m2090a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        m2090a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }

    public void m2092a(String str) {
        this.f1335b = str;
    }
}
