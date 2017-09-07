package com.telkom.mwallet.setting.twitter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.widget.WebDialog;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1265o;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;

public class C1707f extends Dialog {
    static final float[] f4311a = new float[]{20.0f, 60.0f};
    static final float[] f4312b = new float[]{40.0f, 60.0f};
    static final LayoutParams f4313c = new LayoutParams(-1, -1);
    private String f4314d;
    private C1265o f4315e;
    private ImageView f4316f;
    private WebView f4317g;
    private FrameLayout f4318h;
    private C1359a f4319i;

    class C17051 implements OnClickListener {
        final /* synthetic */ C1707f f4309a;

        C17051(C1707f c1707f) {
            this.f4309a = c1707f;
        }

        public void onClick(View view) {
            this.f4309a.f4315e.mo1540d();
            this.f4309a.dismiss();
        }
    }

    private class C1706a extends WebViewClient {
        final /* synthetic */ C1707f f4310a;

        private C1706a(C1707f c1707f) {
            this.f4310a = c1707f;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            C1216a.m4522b("Twitter-WebView", "Webview finished URL: " + str);
            this.f4310a.f4319i.m4990k();
            this.f4310a.f4318h.setBackgroundColor(0);
            this.f4310a.f4317g.setVisibility(0);
            this.f4310a.f4316f.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            C1216a.m4522b("Twitter-WebView", "Webview loading URL: " + str);
            this.f4310a.f4319i.m4973a(this.f4310a.f4319i, this.f4310a.f4319i.getString(R.string.twitter_connect));
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.f4310a.dismiss();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C1216a.m4522b("twDialog", "twDialogUrl Redirect URL: " + str);
            CharSequence charSequence = "denied";
            CharSequence charSequence2 = "oauth_token";
            if (str.startsWith("http://m.telkomsel.com/")) {
                if (str.contains(charSequence2)) {
                    this.f4310a.f4315e.mo1539a(str);
                } else if (str.contains(charSequence)) {
                    this.f4310a.f4315e.mo1540d();
                }
                this.f4310a.dismiss();
                return true;
            } else if (str.contains("https://api.twitter.com/oauth/authorize")) {
                return false;
            } else {
                this.f4310a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }
        }
    }

    public C1707f(Context context, String str, C1265o c1265o) {
        super(context, WebDialog.DEFAULT_THEME);
        this.f4314d = str;
        this.f4315e = c1265o;
        this.f4319i = (C1359a) context;
    }

    private void m6417a() {
        this.f4316f = new ImageView(getContext());
        this.f4316f.setOnClickListener(new C17051(this));
        this.f4316f.setImageDrawable(getContext().getResources().getDrawable(R.drawable.close));
        this.f4316f.setVisibility(4);
    }

    private void m6418a(int i) {
        View linearLayout = new LinearLayout(getContext());
        this.f4317g = new WebView(getContext());
        this.f4317g.setVerticalScrollBarEnabled(false);
        this.f4317g.setHorizontalScrollBarEnabled(false);
        this.f4317g.setWebViewClient(new C1706a());
        this.f4317g.getSettings().setJavaScriptEnabled(true);
        this.f4317g.loadUrl(this.f4314d);
        C1216a.m4522b("twDialog", "twDialogUrl : " + this.f4314d);
        this.f4317g.setLayoutParams(f4313c);
        this.f4317g.setVisibility(4);
        this.f4317g.getSettings().setSavePassword(false);
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f4317g);
        this.f4318h.addView(linearLayout);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f4318h = new FrameLayout(getContext());
        m6417a();
        m6418a(this.f4316f.getDrawable().getIntrinsicWidth() / 2);
        this.f4318h.addView(this.f4316f, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.f4318h, new ViewGroup.LayoutParams(-1, -1));
    }
}
