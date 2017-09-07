package com.telkom.mwallet.coupon.helper;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

public final class C1477d implements OnCancelListener, OnClickListener, Runnable {
    private final Activity f3497a;

    public C1477d(Activity activity) {
        this.f3497a = activity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        run();
    }

    public void run() {
        this.f3497a.finish();
    }
}
