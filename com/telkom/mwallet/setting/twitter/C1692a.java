package com.telkom.mwallet.setting.twitter;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class C1692a {

    class C16911 implements OnClickListener {
        final /* synthetic */ C1692a f4267a;

        C16911(C1692a c1692a) {
            this.f4267a = c1692a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void m6376a(Context context, String str, String str2, Boolean bool) {
        AlertDialog create = new Builder(context).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton("OK", new C16911(this));
        create.show();
    }
}
