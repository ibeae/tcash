package com.amobee.richmedia.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.amobee.adsdk.AdManager;
import com.amobee.adsdk.IAmobeeListener;
import com.amobee.adsdk.Log;
import com.amobee.richmedia.controller.OrmmaAssetController;
import java.io.InputStream;
import java.util.jar.JarFile;

public final class Browser extends Activity {
    private static final int BackwardId = 103;
    private static final int ButtonId = 100;
    private static final int ECLAIR_MR1 = 7;
    private static final int ForwardId = 102;
    public static final String SHOW_BACK_EXTRA = "open_show_back";
    public static final String SHOW_FORWARD_EXTRA = "open_show_forward";
    public static final String SHOW_REFRESH_EXTRA = "open_show_refresh";
    public static final String URL_EXTRA = "extra_url";
    private static final int WebViewId = 101;
    private int mDensityDpi;
    WebView mWebview;

    class C03571 implements OnClickListener {
        C03571() {
        }

        public void onClick(View view) {
            WebView webView = (WebView) Browser.this.findViewById(101);
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                Browser.this.finish();
            }
        }
    }

    class C03582 implements OnClickListener {
        C03582() {
        }

        public void onClick(View view) {
            ((WebView) Browser.this.findViewById(101)).goForward();
        }
    }

    class C03593 implements OnClickListener {
        C03593() {
        }

        public void onClick(View view) {
            ((WebView) Browser.this.findViewById(101)).reload();
        }
    }

    class C03604 implements OnClickListener {
        C03604() {
        }

        public void onClick(View view) {
            Browser.this.finish();
        }
    }

    class C03615 implements DownloadListener {
        C03615() {
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            Browser.this.startActivity(intent);
            Browser.this.finish();
        }
    }

    class C03626 extends WebViewClient {
        C03626() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ImageButton imageButton = (ImageButton) Browser.this.findViewById(Browser.ForwardId);
            Activity activity = (Activity) webView.getContext();
            CharSequence title = webView.getTitle();
            if (title == null || title.equals("")) {
                title = webView.getUrl();
            }
            activity.setTitle(title);
            if (webView.canGoForward()) {
                imageButton.setImageBitmap(Browser.bitmapFromJar(Browser.getUrlForScreenWithUrl("bitmaps/amobee_rightarrow.png", Browser.this.mDensityDpi)));
            } else {
                imageButton.setImageBitmap(Browser.bitmapFromJar(Browser.getUrlForScreenWithUrl("bitmaps/amobee_unrightarrow.png", Browser.this.mDensityDpi)));
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            ((ImageButton) Browser.this.findViewById(Browser.ForwardId)).setImageBitmap(Browser.bitmapFromJar(Browser.getUrlForScreenWithUrl("bitmaps/amobee_unrightarrow.png", Browser.this.mDensityDpi)));
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Log.m811d("Amobee internal browser Error: ", new StringBuilder(String.valueOf(str)).append(" :").append(str2).toString());
            Browser.this.finish();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            IAmobeeListener amobeeListener = AdManager.getInstance(null).getAmobeeListener();
            String toLowerCase = str.toLowerCase();
            try {
                if (toLowerCase.startsWith("wtai://wp/mc;")) {
                    toLowerCase = toLowerCase.replace("wtai://wp/mc;", "tel:");
                }
                if (toLowerCase.startsWith("tel:")) {
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse(toLowerCase));
                    if (amobeeListener != null) {
                        amobeeListener.amobeeOnLeavingApplication(null);
                    }
                    Browser.this.startActivity(intent);
                    Browser.this.finish();
                } else if (toLowerCase.startsWith("sms:")) {
                    r0 = new Intent("android.intent.action.VIEW");
                    if (amobeeListener != null) {
                        amobeeListener.amobeeOnLeavingApplication(null);
                    }
                    r0.setData(Uri.parse(str));
                    Browser.this.startActivity(r0);
                    Browser.this.finish();
                } else if (toLowerCase.startsWith("mailto:")) {
                    r0 = new Intent("android.intent.action.VIEW");
                    r0.setData(Uri.parse(str));
                    Browser.this.startActivity(r0);
                    Browser.this.finish();
                    if (amobeeListener != null) {
                        amobeeListener.amobeeOnLeavingApplication(null);
                    }
                } else {
                    try {
                        if (toLowerCase.startsWith("market://") || toLowerCase.contains("play.google.com/store/apps/details?id=")) {
                            r0 = new Intent("android.intent.action.VIEW");
                            r0.setData(Uri.parse(str));
                            Browser.this.startActivity(r0);
                            Browser.this.finish();
                            if (amobeeListener != null) {
                                amobeeListener.amobeeOnLeavingApplication(null);
                            }
                        } else {
                            webView.loadUrl(str);
                        }
                    } catch (Exception e) {
                        Log.m811d("OrmmaBrowser Error", "");
                        Browser.this.finish();
                    }
                }
            } catch (Exception e2) {
                Log.m811d("OrmmaBrowser Error: ", "click interaction is not supported ");
                Browser.this.finish();
            }
            return true;
        }
    }

    class C03677 extends WebChromeClient {
        FrameLayout mCustomViewContainer = null;
        VideoView mVideoView = null;
        ImageButton videoCloseButton = null;

        class C03631 implements OnKeyListener {
            C03631() {
            }

            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                C03677.this.closeVideo();
                Browser.this.mWebview.requestFocus();
                return true;
            }
        }

        class C03642 implements OnClickListener {
            C03642() {
            }

            public void onClick(View view) {
                C03677.this.onHideCustomView();
                C03677.this.closeVideo();
            }
        }

        class C03653 implements OnTouchListener {
            C03653() {
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        }

        class C03664 implements OnCompletionListener {
            C03664() {
            }

            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.stop();
                C03677.this.onHideCustomView();
                C03677.this.closeVideo();
                Log.m811d("Amobee Video", "onCompletion");
            }
        }

        C03677() {
        }

        void closeVideo() {
            if (this.videoCloseButton != null) {
                this.videoCloseButton.setVisibility(8);
                this.videoCloseButton = null;
            }
            if (this.mVideoView != null) {
                this.mVideoView.setVisibility(8);
                if (((ViewGroup) this.mVideoView.getParent()) != null) {
                    this.mVideoView = null;
                }
                this.mCustomViewContainer.setVisibility(8);
            }
            if (Browser.this.mWebview != null) {
                Browser.this.mWebview.setVisibility(0);
            }
        }

        public void onProgressChanged(WebView webView, int i) {
            Activity activity = (Activity) webView.getContext();
            activity.setTitle(webView.getUrl());
            activity.setProgress(i * 100);
        }

        public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
            if (view instanceof FrameLayout) {
                this.mCustomViewContainer = (FrameLayout) view;
                if (this.mCustomViewContainer.getFocusedChild() instanceof VideoView) {
                    VideoView videoView = (VideoView) this.mCustomViewContainer.getFocusedChild();
                    this.mCustomViewContainer.removeView(videoView);
                    videoView.setMediaController(null);
                    this.mCustomViewContainer.setVisibility(8);
                    this.mVideoView = videoView;
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    ViewGroup viewGroup = (ViewGroup) Browser.this.mWebview.getParent();
                    if (viewGroup != null) {
                        viewGroup.addView(videoView, layoutParams);
                    }
                    videoView.setVisibility(0);
                    videoView.bringToFront();
                    videoView.setOnKeyListener(new C03631());
                    this.videoCloseButton = new ImageButton(Browser.this.mWebview.getContext());
                    this.videoCloseButton.setImageBitmap(Browser.bitmapFromJar(Browser.getUrlForScreenWithUrl("bitmaps/amobee_x.png", AdManager.getDensityDpi(Browser.this.mWebview.getContext()))));
                    this.videoCloseButton.setBackgroundColor(0);
                    this.videoCloseButton.setOnClickListener(new C03642());
                    if (viewGroup != null) {
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 3;
                        viewGroup.addView(this.videoCloseButton, layoutParams);
                    }
                    this.videoCloseButton.bringToFront();
                    videoView.setOnTouchListener(new C03653());
                    videoView.setOnCompletionListener(new C03664());
                    videoView.start();
                    return;
                }
                ViewGroup viewGroup2 = (ViewGroup) Browser.this.mWebview.getRootView();
                if (viewGroup2 != null) {
                    viewGroup2.addView(view);
                }
            }
        }
    }

    class API7WebSettings {
        public API7WebSettings(WebSettings webSettings) {
            try {
                webSettings.setLoadWithOverviewMode(true);
            } catch (Exception e) {
            }
        }
    }

    public static Bitmap bitmapFromJar(String str) {
        InputStream inputStream;
        Throwable th;
        Bitmap bitmap = null;
        try {
            String file = OrmmaAssetController.class.getClassLoader().getResource(str).getFile();
            if (file.startsWith("file:")) {
                file = file.substring(5);
            }
            int indexOf = file.indexOf("!");
            if (indexOf > 0) {
                file = file.substring(0, indexOf);
            }
            JarFile jarFile = new JarFile(file);
            inputStream = jarFile.getInputStream(jarFile.getJarEntry(str));
            try {
                bitmap = BitmapFactory.decodeStream(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            inputStream = bitmap;
            if (inputStream != null) {
                inputStream.close();
            }
            return bitmap;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            inputStream = bitmap;
            th = th4;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        return bitmap;
    }

    static String getUrlForScreenWithUrl(String str, int i) {
        String toLowerCase = str.toLowerCase();
        return (i <= 320 || !toLowerCase.contains(".png")) ? (i <= 240 || !toLowerCase.contains(".png")) ? toLowerCase : toLowerCase.replace(".png", "2.png") : toLowerCase.replace(".png", "3.png");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(4);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mDensityDpi = displayMetrics.densityDpi;
        View relativeLayout = new RelativeLayout(this);
        this.mWebview = new WebView(this);
        this.mWebview.getSettings().setBuiltInZoomControls(true);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        Intent intent = getIntent();
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setId(100);
        linearLayout.setGravity(16);
        linearLayout.setWeightSum(100.0f);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(2, 100);
        linearLayout.setBackgroundDrawable(new BitmapDrawable(bitmapFromJar("bitmaps/amobee_bkgrnd.png")));
        relativeLayout.addView(this.mWebview, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(linearLayout, layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.weight = 25.0f;
        layoutParams.gravity = 16;
        layoutParams.topMargin = 5;
        View imageButton = new ImageButton(this);
        imageButton.setBackgroundColor(0);
        imageButton.setId(BackwardId);
        linearLayout.addView(imageButton, layoutParams);
        if (!intent.getBooleanExtra(SHOW_BACK_EXTRA, true)) {
            imageButton.setVisibility(8);
        }
        imageButton.setImageBitmap(bitmapFromJar(getUrlForScreenWithUrl("bitmaps/amobee_leftarrow.png", this.mDensityDpi)));
        imageButton.setOnClickListener(new C03571());
        View imageButton2 = new ImageButton(this);
        imageButton2.setBackgroundColor(0);
        imageButton2.setId(ForwardId);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 25.0f;
        layoutParams2.gravity = 16;
        layoutParams2.topMargin = 5;
        linearLayout.addView(imageButton2, layoutParams2);
        if (!intent.getBooleanExtra(SHOW_FORWARD_EXTRA, true)) {
            imageButton2.setVisibility(8);
        }
        imageButton2.setOnClickListener(new C03582());
        imageButton2 = new ImageButton(this);
        imageButton2.setImageBitmap(bitmapFromJar(getUrlForScreenWithUrl("bitmaps/amobee_refresh.png", this.mDensityDpi)));
        imageButton2.setBackgroundColor(0);
        layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 25.0f;
        layoutParams2.gravity = 16;
        layoutParams2.topMargin = 5;
        linearLayout.addView(imageButton2, layoutParams2);
        if (!intent.getBooleanExtra(SHOW_REFRESH_EXTRA, true)) {
            imageButton2.setVisibility(8);
        }
        imageButton2.setOnClickListener(new C03593());
        imageButton2 = new ImageButton(this);
        imageButton2.setImageBitmap(bitmapFromJar(getUrlForScreenWithUrl("bitmaps/amobee_close.png", this.mDensityDpi)));
        imageButton2.setBackgroundColor(0);
        layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 25.0f;
        layoutParams2.gravity = 16;
        layoutParams2.topMargin = 5;
        linearLayout.addView(imageButton2, layoutParams2);
        imageButton2.setOnClickListener(new C03604());
        getWindow().requestFeature(2);
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
        this.mWebview.setDownloadListener(new C03615());
        WebSettings settings = this.mWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        if (VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (VERSION.SDK_INT >= 7) {
            API7WebSettings aPI7WebSettings = new API7WebSettings(settings);
        }
        this.mWebview.setId(101);
        this.mWebview.setWebViewClient(new C03626());
        this.mWebview.loadUrl(intent.getStringExtra(URL_EXTRA));
        setContentView(relativeLayout);
        this.mWebview.setWebChromeClient(new C03677());
    }

    protected void onPause() {
        super.onPause();
        if (this.mWebview != null) {
            try {
                Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(this.mWebview, null);
            } catch (Exception e) {
            }
        }
        CookieSyncManager.getInstance().stopSync();
    }

    protected void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }
}
