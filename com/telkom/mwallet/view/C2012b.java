package com.telkom.mwallet.view;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.widget.FacebookDialog;
import com.skcc.wallet.core.p057a.C1216a;

public class C2012b extends WebViewClient {
    private Context f5848a;

    public C2012b(Context context) {
        this.f5848a = context;
    }

    public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        Builder builder = new Builder(this.f5848a);
        builder.setMessage("Do you want to proceed anyway?");
        builder.setPositiveButton("continue", new OnClickListener(this) {
            final /* synthetic */ C2012b f5845b;

            public void onClick(DialogInterface dialogInterface, int i) {
                sslErrorHandler.proceed();
            }
        });
        builder.setNegativeButton(FacebookDialog.COMPLETION_GESTURE_CANCEL, new OnClickListener(this) {
            final /* synthetic */ C2012b f5847b;

            public void onClick(DialogInterface dialogInterface, int i) {
                sslErrorHandler.cancel();
            }
        });
        builder.create().show();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C1216a.m4522b("SSL", "sslurl " + str.toString());
        webView.loadUrl(str);
        return true;
    }
}
