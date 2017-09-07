package com.amobee.richmedia.view;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.amobee.adsdk.AdManager;
import com.amobee.adsdk.Log;
import com.amobee.richmedia.view.AmobeeView.ViewState;

class AmobeeChromeClient extends WebChromeClient implements OnCompletionListener, OnErrorListener {
    private WebView interfazWeb;
    private CustomViewCallback mCallback;
    private LinearLayout mContentView;
    private FrameLayout mCustomViewContainer;
    int mStatusBarHeight = 0;
    VideoView mVideoView;
    private MediaController mediaController = null;
    private FrameLayout progressView = null;
    ImageButton videoCloseButton = null;

    class C03413 implements OnTouchListener {
        C03413() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    class C03435 implements OnFocusChangeListener {
        C03435() {
        }

        public void onFocusChange(View view, boolean z) {
            Log.m811d("VideoView on focus change", "view;" + view + ", hasFocus:" + z);
        }
    }

    public AmobeeChromeClient(WebView webView) {
        this.interfazWeb = webView;
        this.progressView = new FrameLayout(webView.getContext());
    }

    private void HideExpandCloseButton(AmobeeView amobeeView) {
        if (amobeeView != null && !amobeeView.useCustomClose) {
            FrameLayout frameLayout = (FrameLayout) amobeeView.getParent();
            if (frameLayout != null) {
                frameLayout = (FrameLayout) frameLayout.findViewById(amobeeView.EXPAND_CLOSE_ID);
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
            }
        }
    }

    void closeVideo(View view, AmobeeView amobeeView) {
        if (this.mCallback != null) {
            if (this.mCallback != null) {
                this.mCallback.onCustomViewHidden();
                this.mCallback = null;
            }
            if (!(view == null || ((ViewGroup) view.getParent()) == null)) {
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
            if (amobeeView != null) {
                ViewGroup viewGroup = (ViewGroup) amobeeView.getParent();
                if (viewGroup != null) {
                    FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(amobeeView.EXPAND_CLOSE_ID);
                    if (frameLayout != null) {
                        frameLayout.setVisibility(0);
                    }
                }
                amobeeView.setVisibility(0);
            }
        }
    }

    public void finishVideoPlay() {
        try {
            if (this.mVideoView != null) {
                this.mVideoView.stopPlayback();
            }
            onHideCustomView();
            closeVideo(this.videoCloseButton, (AmobeeView) this.interfazWeb);
            if (this.mCallback != null) {
                this.mCallback.onCustomViewHidden();
                this.mCallback = null;
            }
            if (this.mCustomViewContainer != null) {
                ViewGroup viewGroup = (ViewGroup) this.mCustomViewContainer.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.mCustomViewContainer);
                }
            }
        } catch (Exception e) {
        }
    }

    public View getVideoLoadingProgressView() {
        return super.getVideoLoadingProgressView();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
        this.mCustomViewContainer.setVisibility(8);
        onHideCustomView();
        closeVideo(this.videoCloseButton, (AmobeeView) this.interfazWeb);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (!(consoleMessage == null || consoleMessage.message() == null)) {
            Log.m811d("AmobeeView", consoleMessage.message());
        }
        return true;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 100 && this.interfazWeb != null) {
            AmobeeView amobeeView = (AmobeeView) this.interfazWeb;
            onHideCustomView();
            closeVideo(this.videoCloseButton, amobeeView);
        }
        return true;
    }

    public void onHideCustomView() {
        super.onHideCustomView();
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        AmobeeView amobeeView = (AmobeeView) webView;
        if (!amobeeView.mUserGestureRequiredToOpenAds || amobeeView.mUserTouchedTheView) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        Log.m811d("AmobeeView", "JsAlert blocked: " + str + ", message: " + str2);
        jsResult.cancel();
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        AmobeeView amobeeView = (AmobeeView) webView;
        if (!amobeeView.mUserGestureRequiredToOpenAds || amobeeView.mUserTouchedTheView) {
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
        Log.m811d("AmobeeView", "JsConfirm blocked: " + str + ", message: " + str2);
        jsResult.cancel();
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AmobeeView amobeeView = (AmobeeView) webView;
        if (!amobeeView.mUserGestureRequiredToOpenAds || amobeeView.mUserTouchedTheView) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        Log.m811d("AmobeeView", "JsPrompt blocked: " + str + ", message: " + str2);
        jsPromptResult.cancel();
        return true;
    }

    public void onShowCustomView(final View view, CustomViewCallback customViewCallback) {
        if (((AmobeeView) this.interfazWeb).mViewState == ViewState.POSTITIAL) {
            Log.m811d("AmobeeVideoView", "Inline video is not supported by the Postitial ad");
            return;
        }
        super.onShowCustomView(view, customViewCallback);
        try {
            this.mCallback = customViewCallback;
            FrameLayout frameLayout = (FrameLayout) this.interfazWeb.getParent();
            if (view instanceof FrameLayout) {
                this.mCustomViewContainer = (FrameLayout) view;
                final AmobeeView amobeeView;
                LayoutParams layoutParams;
                if (this.mCustomViewContainer.getFocusedChild() instanceof VideoView) {
                    VideoView videoView = (VideoView) this.mCustomViewContainer.getFocusedChild();
                    amobeeView = (AmobeeView) this.interfazWeb;
                    this.mCustomViewContainer.removeView(videoView);
                    videoView.setMediaController(null);
                    this.mCustomViewContainer.setVisibility(8);
                    this.mVideoView = videoView;
                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    ViewGroup viewGroup = (ViewGroup) this.interfazWeb.getParent();
                    if (viewGroup != null) {
                        viewGroup = (ViewGroup) this.interfazWeb.getParent();
                        viewGroup.addView(videoView, layoutParams);
                    }
                    videoView.setVisibility(0);
                    videoView.bringToFront();
                    videoView.setOnKeyListener(new OnKeyListener() {
                        public boolean onKey(View view, int i, KeyEvent keyEvent) {
                            if (i != 4) {
                                return false;
                            }
                            AmobeeChromeClient.this.closeVideo(view, amobeeView);
                            AmobeeChromeClient.this.interfazWeb.requestFocus();
                            return true;
                        }
                    });
                    if (amobeeView != null) {
                        if (amobeeView.isExpanded()) {
                            HideExpandCloseButton(amobeeView);
                        }
                        this.videoCloseButton = new ImageButton(this.interfazWeb.getContext());
                        this.videoCloseButton.setImageBitmap(Browser.bitmapFromJar(Browser.getUrlForScreenWithUrl("bitmaps/amobee_x.png", amobeeView.mDensityDpi)));
                        this.videoCloseButton.setBackgroundColor(0);
                        this.videoCloseButton.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                AmobeeChromeClient.this.onHideCustomView();
                                AmobeeChromeClient.this.closeVideo(AmobeeChromeClient.this.videoCloseButton, amobeeView);
                            }
                        });
                        if (viewGroup != null) {
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 3;
                            viewGroup.addView(this.videoCloseButton, layoutParams);
                        }
                        this.videoCloseButton.bringToFront();
                    }
                    videoView.setOnErrorListener(this);
                    videoView.setOnTouchListener(new C03413());
                    videoView.setOnCompletionListener(new OnCompletionListener() {
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.stop();
                            AmobeeChromeClient.this.onHideCustomView();
                            AmobeeChromeClient.this.closeVideo(AmobeeChromeClient.this.videoCloseButton, amobeeView);
                            Log.m811d("Amobee Video", "onCompletion");
                        }
                    });
                    videoView.start();
                    return;
                } else if (this.interfazWeb != null) {
                    ViewGroup viewGroup2 = (ViewGroup) this.interfazWeb.getRootView();
                    amobeeView = (AmobeeView) this.interfazWeb;
                    if (amobeeView.isExpanded()) {
                        HideExpandCloseButton(amobeeView);
                        amobeeView.setVisibility(8);
                    }
                    if (viewGroup2 != null) {
                        viewGroup2.addView(view);
                        if (this.mCustomViewContainer.getChildCount() > 0) {
                            this.mCustomViewContainer.getChildAt(0).setOnFocusChangeListener(new C03435());
                            this.mCustomViewContainer.getChildAt(0).setOnKeyListener(new OnKeyListener() {
                                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                                    if (i != 4) {
                                        return false;
                                    }
                                    AmobeeChromeClient.this.closeVideo(view, amobeeView);
                                    AmobeeChromeClient.this.interfazWeb.requestFocus();
                                    return true;
                                }
                            });
                        }
                        this.videoCloseButton = new ImageButton(this.interfazWeb.getContext());
                        this.videoCloseButton.setImageBitmap(Browser.bitmapFromJar(Browser.getUrlForScreenWithUrl("bitmaps/amobee_x.png", ((AmobeeView) this.interfazWeb).mDensityDpi)));
                        this.videoCloseButton.setBackgroundColor(0);
                        new FrameLayout.LayoutParams(-2, -2).gravity = 53;
                        int density = (int) (((float) AmobeeView.CLOSE_AREA_SIZE) * AdManager.getDensity(view.getContext()));
                        OnClickListener c03457 = new OnClickListener() {
                            public void onClick(View view) {
                                AmobeeChromeClient.this.closeVideo(view, amobeeView);
                            }
                        };
                        View frameLayout2 = new FrameLayout(view.getContext());
                        frameLayout2.setBackgroundColor(0);
                        layoutParams = new FrameLayout.LayoutParams(density, density);
                        layoutParams.gravity = 53;
                        this.mStatusBarHeight = AdManager.getStatusBarHeight(view.getContext());
                        if (Integer.parseInt(VERSION.SDK) >= 14) {
                            layoutParams.setMargins(0, this.mStatusBarHeight, 0, 0);
                        } else {
                            view.setPadding(0, this.mStatusBarHeight, 0, 0);
                        }
                        frameLayout2.setLayoutParams(layoutParams);
                        this.videoCloseButton.setOnClickListener(c03457);
                        frameLayout2.addView(this.videoCloseButton);
                        ((FrameLayout) view).addView(frameLayout2);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            Log.m814v("AmobeeVideoView", "View is not FrameLayout");
        } catch (Exception e) {
            Log.m811d("AmobeeVideoView", "error");
        }
    }
}
