package com.amobee.richmedia.view;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.amobee.adsdk.AdManager;
import com.amobee.adsdk.AmobeeInterstitial;
import com.amobee.adsdk.Log;
import com.amobee.richmedia.controller.OrmmaController.Dimensions;
import com.amobee.richmedia.controller.OrmmaController.PlayerProperties;
import com.amobee.richmedia.controller.OrmmaController.Properties;
import com.amobee.richmedia.controller.OrmmaUtilityController;
import com.amobee.richmedia.controller.util.OrmmaPlayer;
import com.amobee.richmedia.controller.util.OrmmaPlayerListener;
import com.amobee.richmedia.controller.util.OrmmaUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.HttpResponseCode;

public final class AmobeeView extends WebView implements OnGlobalLayoutListener {
    public static final String ACTION_KEY = "action";
    private static final String AD_PATH = "AD_PATH";
    public static int CLOSE_AREA_SIZE = 50;
    private static final int CONFIG_SCREEN_SIZE = 1024;
    private static final String CURRENT_FILE = "_ormma_current";
    public static final String DIMENSIONS = "expand_dimensions";
    private static final int ECLAIR_MR1 = 7;
    private static final String ERROR_ACTION = "action";
    private static final String ERROR_MESSAGE = "message";
    private static final String EXPAND_PROPERTIES = "expand_properties";
    public static final String EXPAND_URL = "expand_url";
    private static final String GPP_3 = ".3gp";
    static final String LOG_TAG = "AmobeeView";
    private static final String MATROSKA = ".mkv";
    private static final int MESSAGE_ADD_CUSTOM_CLOSE = 1010;
    private static final int MESSAGE_CLOSE = 1001;
    private static final int MESSAGE_EXPAND = 1004;
    private static final int MESSAGE_HIDE = 1002;
    private static final int MESSAGE_OPEN = 1006;
    private static final int MESSAGE_PLAY_AUDIO = 1008;
    private static final int MESSAGE_PLAY_VIDEO = 1007;
    private static final int MESSAGE_RAISE_ERROR = 1009;
    private static final int MESSAGE_RESIZE = 1000;
    private static final int MESSAGE_SEND_EXPAND_CLOSE = 1005;
    private static final int MESSAGE_SHOW = 1003;
    private static final String MPEG_4 = ".mp4";
    private static final String MPEG_TS = ".ts";
    public static final String ORIENTATION = "expand_orientation";
    public static final String PLAYER_PROPERTIES = "player_properties";
    private static final String RESIZE_CUSTOM_ALLOW_OFF_SCREEN = "allowOffscreen";
    private static final String RESIZE_CUSTOM_CLOSE_POSITION = "customClosePosition";
    private static final String RESIZE_HEIGHT = "resize_height";
    private static final String RESIZE_OFFSET_X = "offsetX";
    private static final String RESIZE_OFFSET_Y = "offsetY";
    private static final String RESIZE_WIDTH = "resize_width";
    private static final String TAG = "OrmmaView";
    private static final String WEBM = ".webm";
    private static int[] attrs = new int[]{16843039, 16843040};
    public static boolean isExpanded = false;
    private static String mBridgeScriptPath;
    private static String mScriptPath;
    private static OrmmaPlayer player;
    public static boolean useInternalBrowser = false;
    protected int BACKGROUND_ID;
    protected int EXPAND_CLOSE_ID;
    protected int ORMMA_ID;
    protected int PLACEHOLDER_ID;
    protected int RESIZE_CLOSE_ID;
    public AmobeeInterstitial amobeeInterstitial = null;
    private boolean bGotLayoutParams;
    private boolean bKeyboardOut;
    private boolean bPageFinished;
    private ViewGroup content = null;
    public Bundle expandData = null;
    public boolean hasExpandedView = false;
    private int mContentViewHeight;
    private int mDefaultHeight;
    private int mDefaultWidth;
    private float mDensity;
    int mDensityDpi;
    boolean mDidChangeOrientation = false;
    private GestureDetector mGestureDetector;
    private Handler mHandler = new C03461();
    private int mIndex;
    private int mInitLayoutHeight;
    private int mInitLayoutWidth;
    private int mInterstitialRandom;
    private OrmmaViewListener mListener;
    private String mLocalFilePath;
    int mStatusBarHeight = 0;
    private TimeOut mTimeOut;
    boolean mUserGestureRequiredToOpenAds = false;
    boolean mUserTouchedTheView = false;
    private OrmmaUtilityController mUtilityController;
    public ViewState mViewState = ViewState.DEFAULT;
    WebChromeClient mWebChromeClient = null;
    WebViewClient mWebViewClient = new C03492();
    private String mapAPIKey;
    public DisplayMetrics metrics;
    public int originalAppOrientation = -2;
    public AmobeeView parentView = null;
    private FrameLayout placeHolder = null;
    private final HashSet<String> registeredProtocols = new HashSet();
    public Timer f437t;
    boolean useCustomClose = true;
    private ImageButton videoCloseButton = null;
    private int viewHeight = -1;
    private int viewWidth = -1;

    public interface OrmmaViewListener {
        void handleRequest(String str);

        boolean onEventFired();

        boolean onExpand();

        boolean onExpandClose();

        void onLeavingApplication();

        boolean onOverlay();

        boolean onPostitialClose();

        boolean onReady();

        boolean onResize();

        boolean onResizeClose();
    }

    class C03461 extends Handler {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$amobee$richmedia$view$AmobeeView$ViewState;

        static /* synthetic */ int[] $SWITCH_TABLE$com$amobee$richmedia$view$AmobeeView$ViewState() {
            int[] iArr = $SWITCH_TABLE$com$amobee$richmedia$view$AmobeeView$ViewState;
            if (iArr == null) {
                iArr = new int[ViewState.values().length];
                try {
                    iArr[ViewState.DEFAULT.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[ViewState.EXPANDED.ordinal()] = 3;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[ViewState.HIDDEN.ordinal()] = 4;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[ViewState.INTERSTITIAL.ordinal()] = 8;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[ViewState.LEFT_BEHIND.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[ViewState.LOADING.ordinal()] = 7;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[ViewState.OPENED.ordinal()] = 6;
                } catch (NoSuchFieldError e7) {
                }
                try {
                    iArr[ViewState.POSTITIAL.ordinal()] = 9;
                } catch (NoSuchFieldError e8) {
                }
                try {
                    iArr[ViewState.RESIZED.ordinal()] = 2;
                } catch (NoSuchFieldError e9) {
                }
                $SWITCH_TABLE$com$amobee$richmedia$view$AmobeeView$ViewState = iArr;
            }
            return iArr;
        }

        C03461() {
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1000:
                    if (!data.getString(AmobeeView.RESIZE_CUSTOM_CLOSE_POSITION).equals("none")) {
                        if (AmobeeView.this.changeContentAreaResize(data.getInt(AmobeeView.RESIZE_WIDTH), data.getInt(AmobeeView.RESIZE_HEIGHT), data.getString(AmobeeView.RESIZE_CUSTOM_CLOSE_POSITION), data.getInt(AmobeeView.RESIZE_OFFSET_X), data.getInt(AmobeeView.RESIZE_OFFSET_Y), data.getBoolean(AmobeeView.RESIZE_CUSTOM_ALLOW_OFF_SCREEN)) != null) {
                            AmobeeView.this.mViewState = ViewState.RESIZED;
                            if (AmobeeView.this.mListener != null) {
                                AmobeeView.this.mListener.onResize();
                                break;
                            }
                        }
                    }
                    if (AmobeeView.this.mViewState == ViewState.EXPANDED) {
                        AmobeeView.isExpanded = false;
                        if (AmobeeView.this.mListener != null) {
                            AmobeeView.this.mListener.onExpandClose();
                        }
                    }
                    AmobeeView.this.mViewState = ViewState.RESIZED;
                    LayoutParams layoutParams = AmobeeView.this.getLayoutParams();
                    layoutParams.height = data.getInt(AmobeeView.RESIZE_HEIGHT, layoutParams.height);
                    layoutParams.width = data.getInt(AmobeeView.RESIZE_WIDTH, layoutParams.width);
                    AmobeeView.this.injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({ state: 'resized', size: { width: " + layoutParams.width + ", " + "height: " + layoutParams.height + "}});");
                    AmobeeView.this.requestLayout();
                    break;
                    break;
                case AmobeeView.MESSAGE_CLOSE /*1001*/:
                    switch (C03461.$SWITCH_TABLE$com$amobee$richmedia$view$AmobeeView$ViewState()[AmobeeView.this.mViewState.ordinal()]) {
                        case 2:
                            AmobeeView.this.closeResized();
                            break;
                        case 3:
                            AmobeeView.this.closeExpanded();
                            break;
                        case 8:
                            AmobeeView.this.closeInterstitial();
                            break;
                        case 9:
                            AmobeeView.this.closePostitial();
                            break;
                        default:
                            break;
                    }
                case AmobeeView.MESSAGE_HIDE /*1002*/:
                    AmobeeView.this.setVisibility(4);
                    AmobeeView.this.injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({ state: 'hidden' });");
                    break;
                case AmobeeView.MESSAGE_SHOW /*1003*/:
                    AmobeeView.this.injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({ state: 'default' });");
                    AmobeeView.this.setVisibility(0);
                    break;
                case AmobeeView.MESSAGE_EXPAND /*1004*/:
                    AmobeeView.this.doExpand(data);
                    break;
                case AmobeeView.MESSAGE_SEND_EXPAND_CLOSE /*1005*/:
                    AmobeeView.isExpanded = false;
                    if (AmobeeView.this.mListener != null) {
                        AmobeeView.this.mListener.onExpandClose();
                        break;
                    }
                    break;
                case AmobeeView.MESSAGE_OPEN /*1006*/:
                    AmobeeView.this.mViewState = ViewState.LEFT_BEHIND;
                    break;
                case AmobeeView.MESSAGE_PLAY_VIDEO /*1007*/:
                    AmobeeView.this.playVideoImpl(data);
                    break;
                case AmobeeView.MESSAGE_PLAY_AUDIO /*1008*/:
                    AmobeeView.this.playAudioImpl(data);
                    break;
                case AmobeeView.MESSAGE_RAISE_ERROR /*1009*/:
                    String string = data.getString("message");
                    AmobeeView.this.injectJavaScriptRichMedia("window.ormmaview.fireErrorEvent(\"" + string + "\", \"" + data.getString("action") + "\")");
                    break;
                case AmobeeView.MESSAGE_ADD_CUSTOM_CLOSE /*1010*/:
                    AmobeeView.this.addCloseButton();
                    break;
            }
            super.handleMessage(message);
        }
    }

    class C03492 extends WebViewClient {

        class C03481 implements Runnable {

            class C03471 implements OnTouchListener {
                C03471() {
                }

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Log.m813i(AmobeeView.LOG_TAG, "background touch called");
                    return true;
                }
            }

            C03481() {
            }

            public void run() {
                ViewGroup access$7 = AmobeeView.this.content;
                if (access$7 == null) {
                    AmobeeView.this.closeExpanded();
                    return;
                }
                AmobeeView.this.mStatusBarHeight = AdManager.getStatusBarHeight(AmobeeView.this.getContext());
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                View frameLayout = new FrameLayout(AmobeeView.this.getContext());
                if (VERSION.SDK_INT >= 14) {
                    layoutParams.setMargins(0, AmobeeView.this.mStatusBarHeight, 0, 0);
                } else {
                    frameLayout.setPadding(0, AmobeeView.this.mStatusBarHeight, 0, 0);
                }
                frameLayout.setOnTouchListener(new C03471());
                frameLayout.addView(AmobeeView.this);
                access$7.addView(frameLayout, layoutParams);
                if (!AmobeeView.this.useCustomClose) {
                    AmobeeView.this.addCloseButton();
                }
                AmobeeView.this.mViewState = ViewState.EXPANDED;
                AmobeeView.isExpanded = true;
                AmobeeView.this.parentView.hasExpandedView = true;
            }
        }

        C03492() {
        }

        private boolean isUrlRequiresActionView(String str) {
            if (!str.startsWith("sms:") && !str.startsWith("mailto:") && !str.startsWith("market://") && !str.contains("play.google.com/store/apps/details?id=")) {
                return false;
            }
            if (AmobeeView.this.mListener != null) {
                AmobeeView.this.mListener.onLeavingApplication();
            } else if (AmobeeView.this.amobeeInterstitial != null && AmobeeView.this.mViewState == ViewState.INTERSTITIAL) {
                AmobeeView.this.amobeeInterstitial.interstitialClicked();
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                AmobeeView.this.getContext().startActivity(intent);
            } catch (Exception e) {
                Log.m811d(AmobeeView.TAG, "ACTION_VIEW not supported for url: " + str);
            }
            return true;
        }

        public String getMimeType(String str) {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
            return fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : null;
        }

        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        public void onPageFinished(WebView webView, String str) {
            AmobeeView.this.mDefaultHeight = (int) (((float) AmobeeView.this.getHeight()) / AmobeeView.this.mDensity);
            AmobeeView.this.mDefaultWidth = (int) (((float) AmobeeView.this.getWidth()) / AmobeeView.this.mDensity);
            AmobeeView.this.getCurrentPosition();
            AmobeeView.this.mUtilityController.init(AmobeeView.this.mDensity);
            AmobeeView.this.mUtilityController.handleCalendarEvent();
            if (AmobeeView.this.mViewState == ViewState.INTERSTITIAL && AmobeeView.this.amobeeInterstitial != null && str.toLowerCase().startsWith("file://")) {
                FrameLayout frameLayout = (FrameLayout) ((FrameLayout) ((Activity) AmobeeView.this.getContext()).getWindow().getDecorView().getRootView()).findViewById(AmobeeView.this.amobeeInterstitial.getRandom());
                if (frameLayout == null) {
                    Log.m811d(AdManager.TAG, "it is not the original context, interstitial will not be shown");
                } else {
                    frameLayout.setVisibility(0);
                }
            } else if (AmobeeView.this.parentView != null && AmobeeView.this.getParent() == null) {
                AmobeeView.this.parentView.post(new C03481());
            }
        }

        public synchronized void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (AmobeeView.this.mViewState == ViewState.INTERSTITIAL && AmobeeView.this.amobeeInterstitial != null) {
                String toLowerCase = str.toLowerCase();
                if (toLowerCase.contains("redirect") && toLowerCase.contains(AmobeeView.this.amobeeInterstitial.getRandom())) {
                    AmobeeView.this.closeInterstitial();
                } else if (toLowerCase.contains("actionpage")) {
                }
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (AmobeeView.this.parentView != null) {
                AmobeeView.this.closeExpanded();
            }
            Log.m811d(AmobeeView.LOG_TAG, "error:" + str);
            super.onReceivedError(webView, i, str, str2);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Intent intent;
            String toLowerCase = str.toLowerCase();
            if (AmobeeView.this.mViewState == ViewState.INTERSTITIAL && toLowerCase.contains("redirect") && toLowerCase.contains("n=" + AmobeeView.this.mInterstitialRandom)) {
                AmobeeView.this.closeInterstitial();
                return true;
            } else if ((AmobeeView.this.mViewState == ViewState.POSTITIAL || AmobeeView.this.mViewState == ViewState.INTERSTITIAL) && toLowerCase.contains("actionpage")) {
                return false;
            } else {
                if (!AmobeeView.this.mUserGestureRequiredToOpenAds || AmobeeView.this.mUserTouchedTheView) {
                    Uri parse = Uri.parse(str);
                    String replace;
                    try {
                        if (AmobeeView.this.mListener != null && AmobeeView.this.isRegisteredProtocol(parse)) {
                            AmobeeView.this.mListener.handleRequest(str);
                            return true;
                        } else if (AmobeeView.this.mViewState == ViewState.INTERSTITIAL && toLowerCase.startsWith("file://")) {
                            return false;
                        } else {
                            replace = toLowerCase.startsWith("wtai://wp/mc;") ? toLowerCase.replace("wtai://wp/mc;", "tel:") : toLowerCase;
                            try {
                                if (replace.startsWith("tel:")) {
                                    if (AmobeeView.this.mListener != null) {
                                        AmobeeView.this.mListener.onLeavingApplication();
                                    }
                                    if (AmobeeView.this.amobeeInterstitial != null && AmobeeView.this.mViewState == ViewState.INTERSTITIAL) {
                                        AmobeeView.this.amobeeInterstitial.interstitialClicked();
                                    }
                                    try {
                                        intent = new Intent("android.intent.action.DIAL", Uri.parse(replace));
                                        intent.addFlags(268435456);
                                        AmobeeView.this.getContext().startActivity(intent);
                                        return true;
                                    } catch (Exception e) {
                                        Log.m811d(AmobeeView.TAG, "interstitial - this click interaction is not supported");
                                        return true;
                                    }
                                } else if (isUrlRequiresActionView(replace)) {
                                    return true;
                                } else {
                                    if (AmobeeView.this.urlContainsVideo(parse.toString())) {
                                        if (AmobeeView.this.mListener != null) {
                                            AmobeeView.this.mListener.onLeavingApplication();
                                        } else if (AmobeeView.this.amobeeInterstitial != null && AmobeeView.this.mViewState == ViewState.INTERSTITIAL) {
                                            AmobeeView.this.amobeeInterstitial.interstitialClicked();
                                        }
                                        intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                                        intent.setDataAndType(Uri.parse(str), "video/*");
                                        intent.addFlags(268435456);
                                        AmobeeView.this.getContext().startActivity(intent);
                                        return true;
                                    }
                                    if (AmobeeView.useInternalBrowser) {
                                        AmobeeView.this.open(parse.toString(), true, true, true);
                                    } else {
                                        if (AmobeeView.this.mListener != null) {
                                            AmobeeView.this.mListener.onLeavingApplication();
                                        }
                                        intent = new Intent();
                                        intent.setAction("android.intent.action.VIEW");
                                        intent.setData(parse);
                                        intent.addFlags(268435456);
                                        AmobeeView.this.getContext().startActivity(intent);
                                    }
                                    if (AmobeeView.this.mViewState != ViewState.INTERSTITIAL || AmobeeView.this.amobeeInterstitial == null) {
                                        return true;
                                    }
                                    AmobeeView.this.amobeeInterstitial.interstitialClicked();
                                    return true;
                                }
                            } catch (Exception e2) {
                                try {
                                    if (AmobeeView.this.mListener != null) {
                                        AmobeeView.this.mListener.onLeavingApplication();
                                    }
                                    intent = new Intent();
                                    intent.setAction("android.intent.action.VIEW");
                                    intent.setData(parse);
                                    intent.addFlags(268435456);
                                    AmobeeView.this.getContext().startActivity(intent);
                                    return true;
                                } catch (Exception e3) {
                                    Log.m811d(AmobeeView.TAG, "this click interaction is not supported for url " + replace);
                                    return true;
                                }
                            }
                        }
                    } catch (Exception e4) {
                        replace = toLowerCase;
                        if (AmobeeView.this.mListener != null) {
                            AmobeeView.this.mListener.onLeavingApplication();
                        }
                        intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(parse);
                        intent.addFlags(268435456);
                        AmobeeView.this.getContext().startActivity(intent);
                        return true;
                    }
                }
                Log.m811d(AmobeeView.LOG_TAG, "Url blocked: " + toLowerCase);
                return true;
            }
        }
    }

    class C03525 implements Runnable {
        C03525() {
        }

        public void run() {
            AmobeeView.this.closeExpanded();
        }
    }

    class C03536 implements OnClickListener {
        C03536() {
        }

        public void onClick(View view) {
            ((FrameLayout) view).removeAllViews();
            ((FrameLayout) view.getParent()).removeView(view);
            AmobeeView.this.closeResized();
        }
    }

    class C03547 implements OnTouchListener {
        C03547() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            Log.m813i(AmobeeView.LOG_TAG, "background touch called");
            return true;
        }
    }

    class C03558 implements OnClickListener {
        C03558() {
        }

        public void onClick(View view) {
            ((ViewGroup) view).removeAllViews();
            ((ViewGroup) view.getParent()).removeView(view);
            if (AmobeeView.this.mViewState == ViewState.INTERSTITIAL) {
                AmobeeView.this.closeInterstitial();
            } else {
                AmobeeView.this.closeExpanded();
            }
        }
    }

    public enum ACTION {
        PLAY_AUDIO,
        PLAY_VIDEO
    }

    public static abstract class NewLocationReciever {
        public abstract void OnNewLocation(ViewState viewState);
    }

    class ScrollEater extends SimpleOnGestureListener {
        ScrollEater() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }
    }

    class TimeOut extends TimerTask {
        int mCount = 0;
        int mProgress = 0;

        TimeOut() {
        }

        public void run() {
            int progress = AmobeeView.this.getProgress();
            if (progress == 100) {
                cancel();
            } else if (this.mProgress == progress) {
                this.mCount++;
                if (this.mCount == 3) {
                    try {
                        AmobeeView.this.stopLoading();
                    } catch (Exception e) {
                        Log.m815w(AmobeeView.TAG, "error in stopLoading");
                    }
                    cancel();
                }
            }
            this.mProgress = progress;
        }
    }

    public enum ViewState {
        DEFAULT,
        RESIZED,
        EXPANDED,
        HIDDEN,
        LEFT_BEHIND,
        OPENED,
        LOADING,
        INTERSTITIAL,
        POSTITIAL
    }

    class downloadPicture extends AsyncTask<String, Void, Bitmap> {
        String url = null;

        downloadPicture() {
        }

        protected Bitmap doInBackground(String... strArr) {
            this.url = strArr[0];
            try {
                if (URLUtil.isValidUrl(this.url)) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(true);
                    httpURLConnection.connect();
                    return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                }
                AmobeeView.this.raiseError("Store picture failed.", "storePicture");
                return null;
            } catch (IOException e) {
                AmobeeView.this.raiseError("Store picture failed.", "storePicture");
            }
        }

        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                try {
                    if (Media.insertImage(AmobeeView.this.getContext().getContentResolver(), bitmap, this.url.substring(this.url.lastIndexOf("/") + 1), null) == null) {
                        AmobeeView.this.raiseError("Store picture failed.", "storePicture");
                        return;
                    }
                    return;
                } catch (Exception e) {
                    AmobeeView.this.raiseError("Store picture failed.", "storePicture");
                    return;
                }
            }
            AmobeeView.this.raiseError("Store picture failed.", "storePicture");
        }
    }

    public AmobeeView(Context context) {
        super(context);
        initialize();
    }

    public AmobeeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            initialize();
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, attrs);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, -1);
            if (dimensionPixelSize > 0 && dimensionPixelSize2 > 0) {
                this.mUtilityController.setMaxSize(dimensionPixelSize, dimensionPixelSize2);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public AmobeeView(Context context, OrmmaViewListener ormmaViewListener) {
        super(context);
        setListener(ormmaViewListener);
        initialize();
    }

    private FrameLayout changeContentArea(Dimensions dimensions) {
        this.mStatusBarHeight = AdManager.getStatusBarHeight(getContext());
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (viewGroup == null) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) getParent();
        if (viewGroup2 == null) {
            return null;
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensions.width, dimensions.height);
        if (viewGroup2 != null) {
            int childCount = viewGroup2.getChildCount();
            int i = 0;
            while (i < childCount && viewGroup2.getChildAt(i) != this) {
                i++;
            }
            this.mIndex = i;
            this.placeHolder = new FrameLayout(getContext());
            this.placeHolder.setId(this.PLACEHOLDER_ID);
            viewGroup2.addView(this.placeHolder, i, new LayoutParams(getWidth(), getHeight()));
            if (VERSION.SDK_INT >= 11) {
                onPause();
            }
            viewGroup2.removeView(this);
        }
        View frameLayout = new FrameLayout(getContext());
        frameLayout.setOnTouchListener(new C03547());
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(this.BACKGROUND_ID);
        int[] defaultPosition = getDefaultPosition();
        double d = (double) (((float) dimensions.f435x) * this.mDensity);
        if (Math.abs(d - ((double) defaultPosition[0])) < 1.0d) {
            d = (double) defaultPosition[0];
        }
        if (d < 0.0d) {
            d = 0.0d;
        }
        double d2 = (double) (((float) dimensions.f436y) * this.mDensity);
        if (Math.abs(d2 - ((double) defaultPosition[1])) < 1.0d) {
            d2 = (double) defaultPosition[1];
        }
        if (d2 < 0.0d) {
            d2 = 0.0d;
        }
        if (dimensions.height + 1 < this.metrics.heightPixels && (((double) this.metrics.heightPixels) - r4) - ((double) dimensions.height) <= 1.0d) {
            d2 = (double) (this.metrics.heightPixels - dimensions.height);
        }
        if (Integer.parseInt(VERSION.SDK) >= 14) {
            layoutParams.setMargins(0, this.mStatusBarHeight, 0, 0);
            frameLayout.setPadding((int) d, (int) d2, 0, 0);
        } else {
            frameLayout.setPadding((int) d, ((int) d2) + this.mStatusBarHeight, 0, 0);
        }
        frameLayout.addView(this, layoutParams);
        viewGroup.addView(frameLayout, layoutParams2);
        if (VERSION.SDK_INT >= 11) {
            onResume();
        }
        return frameLayout;
    }

    private FrameLayout changeContentAreaResize(int i, int i2, String str, int i3, int i4, boolean z) {
        double d;
        double d2;
        if (this.mViewState == ViewState.RESIZED) {
            this.mStatusBarHeight = AdManager.getStatusBarHeight(getContext());
            FrameLayout frameLayout = (FrameLayout) getParent();
            if (frameLayout == null) {
                return frameLayout;
            }
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(this.RESIZE_CLOSE_ID);
            if (frameLayout2 != null) {
                resizeCloseArea(str, frameLayout2);
            }
            d = (double) (((float) i3) * this.mDensity);
            d2 = (double) (((float) i4) * this.mDensity);
            if (!z) {
                Point fixResizeOffset = fixResizeOffset(d, d2, i2, i);
                d = (double) fixResizeOffset.x;
                d2 = (double) fixResizeOffset.y;
            }
            LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            if ((d < 0.0d || d2 < 0.0d) && Integer.parseInt(VERSION.SDK) >= 14) {
                ((FrameLayout.LayoutParams) frameLayout.getLayoutParams()).setMargins((int) d, ((int) d2) + this.mStatusBarHeight, 0, 0);
            } else {
                frameLayout.setPadding((int) d, ((int) d2) + this.mStatusBarHeight, 0, 0);
            }
            injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({ state: 'resized', size: { width: " + i + ", " + "height: " + i2 + "}});");
            requestLayout();
            return frameLayout;
        }
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (viewGroup == null) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) getParent();
        if (viewGroup2 == null) {
            return null;
        }
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i2);
        if (viewGroup2 != null) {
            int childCount = viewGroup2.getChildCount();
            int i5 = 0;
            while (i5 < childCount && viewGroup2.getChildAt(i5) != this) {
                i5++;
            }
            this.mIndex = i5;
            this.placeHolder = new FrameLayout(getContext());
            this.placeHolder.setId(this.PLACEHOLDER_ID);
            viewGroup2.addView(this.placeHolder, i5, new LayoutParams(getWidth(), getHeight()));
            if (VERSION.SDK_INT >= 11) {
                onPause();
            }
            viewGroup2.removeView(this);
        }
        View frameLayout3 = new FrameLayout(getContext());
        injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({ state: 'resized', size: { width: " + i + ", " + "height: " + i2 + "}});");
        LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        frameLayout3.setId(this.BACKGROUND_ID);
        d = (double) (((float) i3) * this.mDensity);
        d2 = (double) (((float) i4) * this.mDensity);
        if (!z) {
            fixResizeOffset = fixResizeOffset(d, d2, i2, i);
            d = (double) fixResizeOffset.x;
            d2 = (double) fixResizeOffset.y;
        }
        if ((d < 0.0d || d2 < 0.0d) && Integer.parseInt(VERSION.SDK) >= 14) {
            layoutParams3.setMargins((int) d, ((int) d2) + this.mStatusBarHeight, 0, 0);
        } else {
            frameLayout3.setPadding((int) d, ((int) d2) + this.mStatusBarHeight, 0, 0);
        }
        getSettings().setUseWideViewPort(false);
        frameLayout3.addView(this, layoutParams2);
        frameLayout3.addView(resizeCloseArea(str, null));
        viewGroup.addView(frameLayout3, layoutParams3);
        requestFocus(130);
        if (VERSION.SDK_INT >= 11) {
            onResume();
        }
        return frameLayout3;
    }

    private void closeExpandedOnUIThread() {
        post(new C03525());
    }

    private void closeResized() {
        this.mViewState = ViewState.DEFAULT;
        String str = "window.ormmaview.fireChangeEvent({ state: 'default', size: { width: " + this.mDefaultWidth + ", " + "height: " + this.mDefaultHeight + "}" + "});";
        Log.m811d(LOG_TAG, "closeResized: injection: " + str);
        injectJavaScriptRichMedia(str);
        if (((FrameLayout) getRootView().findViewById(this.BACKGROUND_ID)) != null) {
            if (this.mListener != null) {
                this.mListener.onResizeClose();
            }
            resetContents();
            return;
        }
        resetLayout();
    }

    private Point fixResizeOffset(double d, double d2, int i, int i2) {
        int[] defaultPosition = getDefaultPosition();
        double d3 = Math.abs(d - ((double) defaultPosition[0])) < 1.0d ? (double) defaultPosition[0] : d;
        if (d3 < 0.0d) {
            d3 = 0.0d;
        }
        double d4 = Math.abs(d2 - ((double) defaultPosition[1])) < 1.0d ? (double) defaultPosition[1] : d2;
        if (d4 < 0.0d) {
            d4 = 0.0d;
        }
        if (i + 1 < this.metrics.heightPixels && (((double) this.metrics.heightPixels) - r2) - ((double) i) <= 1.0d) {
            d4 = (double) (this.metrics.heightPixels - i);
        }
        if (i2 + 1 < this.metrics.widthPixels && (((double) this.metrics.widthPixels) - r0) - ((double) i2) <= 1.0d) {
            d3 = (double) (this.metrics.widthPixels - i2);
        }
        return new Point((int) d3, (int) d4);
    }

    private int getContentViewHeight() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        return viewGroup != null ? viewGroup.getHeight() : -1;
    }

    private void initialize() {
        this.mStatusBarHeight = AdManager.getStatusBarHeight(getContext());
        Random random = new Random();
        this.BACKGROUND_ID = random.nextInt(66666);
        do {
            this.PLACEHOLDER_ID = random.nextInt(66666);
        } while (this.PLACEHOLDER_ID == this.BACKGROUND_ID);
        while (true) {
            this.ORMMA_ID = random.nextInt(66666);
            if (this.ORMMA_ID != this.BACKGROUND_ID && this.ORMMA_ID != this.PLACEHOLDER_ID) {
                break;
            }
        }
        while (true) {
            this.RESIZE_CLOSE_ID = random.nextInt(66666);
            if (this.RESIZE_CLOSE_ID != this.BACKGROUND_ID && this.RESIZE_CLOSE_ID != this.PLACEHOLDER_ID && this.RESIZE_CLOSE_ID != this.ORMMA_ID) {
                break;
            }
        }
        while (true) {
            this.EXPAND_CLOSE_ID = random.nextInt(66666);
            if (this.EXPAND_CLOSE_ID != this.BACKGROUND_ID && this.EXPAND_CLOSE_ID != this.PLACEHOLDER_ID && this.EXPAND_CLOSE_ID != this.ORMMA_ID && this.EXPAND_CLOSE_ID != this.RESIZE_CLOSE_ID) {
                break;
            }
        }
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        this.mGestureDetector = new GestureDetector(new ScrollEater());
        setBackgroundColor(0);
        this.metrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.metrics);
        this.mDensity = this.metrics.density;
        int i = 160;
        if (this.metrics != null) {
            i = this.metrics.densityDpi;
        }
        this.mDensityDpi = i;
        this.bPageFinished = false;
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        requestFocus(130);
        setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (!view.hasFocus()) {
                            view.requestFocus();
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(false);
        if (VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        this.mUtilityController = new OrmmaUtilityController(this, getContext());
        addJavascriptInterface(this.mUtilityController, "ORMMAUtilityControllerBridge");
        setWebViewClient(this.mWebViewClient);
        if (VERSION.SDK_INT >= 7) {
            this.mWebChromeClient = new AmobeeChromeClient(this);
            API7WebSettings aPI7WebSettings = new API7WebSettings(settings);
        } else {
            this.mWebChromeClient = new WebChromeClient();
        }
        setWebChromeClient(this.mWebChromeClient);
        if (VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        setScriptPath();
        this.mContentViewHeight = getContentViewHeight();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        getViewTreeObserver().addOnGlobalFocusChangeListener(this);
        setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                new Intent("android.intent.action.VIEW").setDataAndType(Uri.parse(str), str4);
            }
        });
    }

    private boolean isRegisteredProtocol(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null) {
            return false;
        }
        Iterator it = this.registeredProtocols.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equalsIgnoreCase(scheme)) {
                return true;
            }
        }
        return false;
    }

    private void loadInputStream(InputStream inputStream) {
        try {
            this.mLocalFilePath = this.mUtilityController.writeToDiskWrap(inputStream, CURRENT_FILE, true, null, mBridgeScriptPath, mScriptPath);
            final String str = "file://" + this.mLocalFilePath + File.separator + CURRENT_FILE;
            this.parentView.post(new Runnable() {
                public void run() {
                    super.loadUrl(str);
                }
            });
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                }
            }
        } catch (IllegalStateException e2) {
            closeExpandedOnUIThread();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                }
            }
        } catch (IOException e4) {
            closeExpandedOnUIThread();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e5) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e6) {
                }
            }
        }
    }

    private void loadInputStream(InputStream inputStream, String str) {
        reset();
        try {
            this.mLocalFilePath = this.mUtilityController.writeToDiskWrap(inputStream, CURRENT_FILE, true, str, mBridgeScriptPath, mScriptPath);
            String str2 = "file://" + this.mLocalFilePath + File.separator + CURRENT_FILE;
            if (str != null) {
                injectJavaScript(str);
            }
            super.loadUrl(str2);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                }
            }
        } catch (IllegalStateException e2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                }
            }
        } catch (IOException e4) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e5) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e6) {
                }
            }
        }
    }

    private void reset() {
        restoreState();
        invalidate();
        if (this.mUtilityController != null) {
            this.mUtilityController.deleteOldAds();
            this.mUtilityController.stopAllListeners();
        }
        resetLayout();
    }

    private void resetLayout() {
        LayoutParams layoutParams = getLayoutParams();
        if (this.bGotLayoutParams) {
            layoutParams.height = this.mInitLayoutHeight;
            layoutParams.width = this.mInitLayoutWidth;
        }
        setVisibility(0);
        requestLayout();
    }

    private FrameLayout resizeCloseArea(String str, FrameLayout frameLayout) {
        if (frameLayout == null) {
            OnClickListener c03536 = new C03536();
            frameLayout = new FrameLayout(getContext());
            frameLayout.setBackgroundColor(0);
            frameLayout.setOnClickListener(c03536);
            frameLayout.setId(this.RESIZE_CLOSE_ID);
        }
        int i = (int) (((float) CLOSE_AREA_SIZE) * this.mDensity);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = getGravity(str);
        frameLayout.setLayoutParams(layoutParams);
        return frameLayout;
    }

    private void restoreState() {
        if (this.mViewState == ViewState.EXPANDED) {
            closeExpanded();
        } else if (this.mViewState == ViewState.RESIZED) {
            closeResized();
        }
    }

    private synchronized void setScriptPath() {
        if (mBridgeScriptPath == null) {
            mBridgeScriptPath = this.mUtilityController.copyTextFromJarIntoAssetDir("/js/amobee_richmedia_bridge.js", "js/amobee_richmedia_bridge.js");
        }
        if (mScriptPath == null) {
            mScriptPath = this.mUtilityController.copyTextFromJarIntoAssetDir("/js/amobee_richmedia.js", "js/amobee_richmedia.js");
        }
    }

    void addCloseButton() {
        if (this.mViewState == ViewState.POSTITIAL) {
            Log.m811d(TAG, "abort adding close button to postitial ad");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            final OnClickListener c03558 = new C03558();
            View frameLayout = new FrameLayout(getContext());
            frameLayout.setBackgroundColor(0);
            frameLayout.setOnClickListener(c03558);
            this.videoCloseButton = new ImageButton(getContext());
            this.videoCloseButton.setImageBitmap(Browser.bitmapFromJar(Browser.getUrlForScreenWithUrl("bitmaps/amobee_x.png", this.mDensityDpi)));
            this.videoCloseButton.setBackgroundColor(0);
            this.videoCloseButton.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (view.getParent() != null) {
                        c03558.onClick((View) view.getParent());
                    }
                }
            });
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            int i = (int) (((float) CLOSE_AREA_SIZE) * this.mDensity);
            LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.gravity = 53;
            if (this.parentView == null) {
                if (Integer.parseInt(VERSION.SDK) >= 14) {
                    layoutParams2.setMargins(0, this.mStatusBarHeight, 0, 0);
                } else {
                    viewGroup.setPadding(0, this.mStatusBarHeight, 0, 0);
                }
            }
            this.videoCloseButton.setLayoutParams(layoutParams);
            frameLayout.setLayoutParams(layoutParams2);
            frameLayout.addView(this.videoCloseButton);
            frameLayout.setId(this.EXPAND_CLOSE_ID);
            viewGroup.addView(frameLayout);
        }
    }

    public void close() {
        this.mHandler.sendEmptyMessage(MESSAGE_CLOSE);
    }

    protected synchronized void closeExpanded() {
        setOrientationDefault();
        if (this.parentView == null) {
            resetContents();
            injectCloseState();
        } else {
            String str = "window.ormmaview.fireChangeEvent({ state: 'default'});";
            Log.m811d(LOG_TAG, "closeExpanded: injection: " + str);
            injectJavaScriptRichMedia(str);
            this.parentView.removeExpndedUrl(this);
            this.parentView.injectCloseState();
            this.parentView.resetLayout();
        }
    }

    void closeInterstitial() {
        if (this.amobeeInterstitial != null) {
            this.mInterstitialRandom = this.amobeeInterstitial.getRandom();
            this.amobeeInterstitial.closeInterstitial();
        }
    }

    protected void closeOpened(View view) {
        ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).removeView(view);
        requestLayout();
    }

    public void closePostitial() {
        if (this.mListener != null) {
            this.mListener.onPostitialClose();
        }
    }

    public void deregisterProtocol(String str) {
        if (str != null) {
            this.registeredProtocols.remove(str.toLowerCase());
        }
    }

    public void destroy() {
    }

    public void doExpand(Bundle bundle) {
        if (this.mViewState == ViewState.RESIZED) {
            resetContents();
        }
        if (!isExpanded) {
            isExpanded = true;
            this.mViewState = ViewState.EXPANDED;
            Dimensions dimensions = (Dimensions) bundle.getParcelable(DIMENSIONS);
            final String string = bundle.getString(EXPAND_URL);
            Properties properties = (Properties) bundle.getParcelable(EXPAND_PROPERTIES);
            String string2 = bundle.getString(ORIENTATION);
            if (URLUtil.isValidUrl(string)) {
                ViewGroup viewGroup = (ViewGroup) getRootView();
                String str = "window.ormmaview.fireChangeEvent({ state: 'expanded' });";
                Log.m811d(LOG_TAG, "doExpand url: injection: " + str);
                injectJavaScriptRichMedia(str);
                final AmobeeView amobeeView = new AmobeeView(getContext());
                amobeeView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                amobeeView.content = viewGroup;
                amobeeView.parentView = this;
                if (!(properties == null || properties.useCustomClose)) {
                    amobeeView.useCustomClose = false;
                }
                amobeeView.getSettings().setUseWideViewPort(false);
                amobeeView.setOrientationProperties(string2);
                new Thread(new Runnable() {
                    public void run() {
                        amobeeView.loadExpandUrl(string);
                    }
                }).start();
            }
            if (this.parentView == null && !URLUtil.isValidUrl(string)) {
                FrameLayout changeContentArea;
                if (properties != null && (properties.width > -1 || properties.height > -1)) {
                    dimensions.width = (int) (((float) properties.width) * this.mDensity);
                    dimensions.height = (int) (((float) properties.height) * this.mDensity);
                }
                FrameLayout frameLayout = null;
                try {
                    changeContentArea = changeContentArea(dimensions);
                } catch (Exception e) {
                    changeContentArea = frameLayout;
                }
                if (changeContentArea == null) {
                    isExpanded = false;
                    this.mViewState = ViewState.DEFAULT;
                    return;
                }
                frameLayout = (FrameLayout) getParent();
                if (properties != null && properties.useBackground) {
                    changeContentArea.setBackgroundColor(properties.backgroundColor | (((int) (properties.backgroundOpacity * 255.0f)) * 268435456));
                }
                String str2 = "window.ormmaview.fireChangeEvent({ state: 'expanded', size: { width: " + ((int) (((float) dimensions.width) / this.mDensity)) + ", " + "height: " + ((int) (((float) dimensions.height) / this.mDensity)) + "}" + " });";
                Log.m811d(LOG_TAG, "doExpand: injection: " + str2);
                injectJavaScriptRichMedia(str2);
                isExpanded = true;
                if (!(properties == null || properties.useCustomClose)) {
                    this.useCustomClose = false;
                    addCloseButton();
                }
                setOrientationProperties(string2);
            }
            if (this.mListener != null) {
                this.mListener.onExpand();
            }
            this.mViewState = ViewState.EXPANDED;
            requestFocus(130);
        }
    }

    public void dump() {
    }

    public void expand(Dimensions dimensions, String str, Properties properties, String str2) {
        Message obtainMessage = this.mHandler.obtainMessage(MESSAGE_EXPAND);
        Bundle bundle = new Bundle();
        bundle.putParcelable(DIMENSIONS, dimensions);
        bundle.putString(EXPAND_URL, str);
        bundle.putParcelable(EXPAND_PROPERTIES, properties);
        bundle.putString(ORIENTATION, str2);
        obtainMessage.setData(bundle);
        this.mHandler.sendMessage(obtainMessage);
    }

    public ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) getContext().getSystemService("connectivity");
    }

    void getCurrentPosition() {
        this.mStatusBarHeight = AdManager.getStatusBarHeight(getContext());
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (viewGroup != null) {
            viewGroup.getLocationOnScreen(iArr2);
            getLocationOnScreen(iArr);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (this.viewWidth == -1) {
                this.viewWidth = getWidth();
                this.viewHeight = getHeight();
            }
            int i = (int) (((float) (iArr[0] - iArr2[0])) / displayMetrics.density);
            int i2 = (int) (((float) (iArr[1] - (iArr2[1] + this.mStatusBarHeight))) / displayMetrics.density);
            int i3 = (int) (((float) this.viewWidth) / displayMetrics.density);
            injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({currentPosition : {'x': " + i + ", 'y': " + i2 + ", 'width': " + i3 + ", 'height': " + ((int) (((float) this.viewHeight) / displayMetrics.density)) + "}});");
        }
    }

    public int[] getDefaultPosition() {
        this.mStatusBarHeight = AdManager.getStatusBarHeight(getContext());
        FrameLayout frameLayout = (FrameLayout) getRootView().findViewById(16908290);
        ViewGroup viewGroup = null;
        if (getRootView() != null) {
            viewGroup = (this.parentView == null || this.parentView.getRootView() == null) ? (ViewGroup) getRootView() : (FrameLayout) this.parentView.getRootView();
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int height;
        if (viewGroup != null) {
            viewGroup.getLocationInWindow(iArr);
            int width = viewGroup.getWidth();
            height = viewGroup.getHeight() - this.mStatusBarHeight;
            viewGroup.getLocationOnScreen(iArr2);
            setMaxSize(width, height);
        } else if (frameLayout != null) {
            frameLayout.getLocationInWindow(iArr);
            int width2 = frameLayout.getWidth();
            height = frameLayout.getHeight() - this.mStatusBarHeight;
            frameLayout.getLocationOnScreen(iArr2);
            setMaxSize(width2, height);
        }
        int[] iArr3 = new int[2];
        if (this.parentView != null) {
            this.parentView.getLocationInWindow(iArr3);
        } else {
            getLocationInWindow(iArr3);
        }
        return new int[]{iArr3[1] - (iArr[1] + this.mStatusBarHeight), iArr3[0] - iArr[0]};
    }

    int getGravity(String str) {
        return str.equals("top-left") ? 51 : !str.equals("top-right") ? str.equals("center") ? 17 : str.equals("bottom-left") ? 83 : str.equals("bottom-right") ? 85 : str.equals("top-center") ? 49 : str.equals("bottom-center") ? 81 : 53 : 53;
    }

    OrmmaPlayer getPlayer() {
        if (player != null) {
            player.releasePlayer();
        }
        player = new OrmmaPlayer(getContext());
        return player;
    }

    public String getSize() {
        return "{ width: " + ((int) (((float) getWidth()) / this.mDensity)) + ", " + "height: " + ((int) (((float) getHeight()) / this.mDensity)) + "}";
    }

    public String getState() {
        return this.mViewState.toString().toLowerCase();
    }

    public boolean getUserGestureRequiredToOpenAds() {
        return this.mUserGestureRequiredToOpenAds;
    }

    public boolean getUserTouchedTheView() {
        return this.mUserTouchedTheView;
    }

    public ViewState getViewState() {
        return this.mViewState;
    }

    public void hide() {
        this.mHandler.sendEmptyMessage(MESSAGE_HIDE);
    }

    public void hideMraidInterstitial() {
        String str = "window.ormmaview.fireChangeEvent({ state: 'hidden', viewable: false });";
        Log.m811d(LOG_TAG, "hideMraidInterstitial: injection: " + str);
        injectJavaScriptRichMedia(str);
    }

    public void hideVideo() {
        if (this.mWebChromeClient != null && (this.mWebChromeClient instanceof AmobeeChromeClient)) {
            ((AmobeeChromeClient) this.mWebChromeClient).closeVideo(((AmobeeChromeClient) this.mWebChromeClient).videoCloseButton, this);
        }
    }

    void injectCloseState() {
        String str = "window.ormmaview.fireChangeEvent({ state: 'default', size: { width: " + this.mDefaultWidth + ", " + "height: " + this.mDefaultHeight + "}" + "});";
        Log.m811d(LOG_TAG, "closeExpanded: injection: " + str);
        injectJavaScriptRichMedia(str);
        this.mViewState = ViewState.DEFAULT;
        this.mHandler.sendEmptyMessage(MESSAGE_SEND_EXPAND_CLOSE);
        setVisibility(0);
    }

    public void injectJavaScript(String str) {
        if (getUrl() != null && str != null) {
            if (VERSION.SDK_INT >= 19) {
                super.evaluateJavascript(str, null);
            } else {
                super.loadUrl("javascript:" + str);
            }
        }
    }

    public void injectJavaScriptRichMedia(String str) {
        injectJavaScript("if (typeof(window.ormmaview) !== 'undefined' && window.ormmaview){" + str + "}");
    }

    public boolean isExpanded() {
        return this.mViewState == ViewState.EXPANDED;
    }

    public boolean isPageFinished() {
        return this.bPageFinished;
    }

    public void loadExpandUrl(String str) {
        if (URLUtil.isValidUrl(str)) {
            this.bPageFinished = false;
            try {
                InputStream open;
                URL url = new URL(str);
                url.getFile();
                if (str.startsWith("file:///android_asset/")) {
                    open = getContext().getAssets().open(str.replace("file:///android_asset/", ""));
                } else {
                    open = url.openStream();
                }
                loadInputStream(open);
            } catch (MalformedURLException e) {
                closeExpandedOnUIThread();
            } catch (IOException e2) {
                closeExpandedOnUIThread();
            }
        }
    }

    public void loadFile(File file, String str) {
        try {
            loadInputStream(new FileInputStream(file), str);
        } catch (Exception e) {
        }
    }

    public void loadString(String str, final String str2) {
        this.mUserTouchedTheView = false;
        if (VERSION.SDK_INT < 11) {
            clearView();
        }
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        post(new Runnable() {
            public void run() {
                AmobeeView.this.loadInputStream(byteArrayInputStream, str2);
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                }
            }
        });
    }

    public void loadUrl(String str) {
        loadUrl(str, false, null);
    }

    public void loadUrl(String str, String str2) {
        loadUrl(str, false, str2);
    }

    public void loadUrl(String str, boolean z, String str2) {
        if (URLUtil.isValidUrl(str)) {
            if (!z) {
                this.bPageFinished = false;
                try {
                    InputStream open;
                    URL url = new URL(str);
                    url.getFile();
                    if (str.startsWith("file:///android_asset/")) {
                        open = getContext().getAssets().open(str.replace("file:///android_asset/", ""));
                    } else {
                        open = url.openStream();
                    }
                    loadInputStream(open, str2);
                    return;
                } catch (MalformedURLException e) {
                } catch (IOException e2) {
                    return;
                }
            }
            super.loadUrl(str);
            this.mUtilityController.ready();
        }
    }

    protected void onAttachedToWindow() {
        if (!this.bGotLayoutParams) {
            LayoutParams layoutParams = getLayoutParams();
            this.mInitLayoutHeight = layoutParams.height;
            this.mInitLayoutWidth = layoutParams.width;
            this.bGotLayoutParams = true;
        }
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        Log.m811d(TAG, "AmobeeViee detached, isExpanded: " + isExpanded + ", Parent: " + getParent());
        try {
            this.mUtilityController.stopAllListeners();
            super.onDetachedFromWindow();
        } catch (Exception e) {
        }
    }

    public void onGlobalFocusChanged(View view, View view2) {
        if (!(view2 instanceof AmobeeView)) {
            if (this.mViewState == ViewState.INTERSTITIAL || this.mViewState == ViewState.EXPANDED) {
                requestFocus();
            }
        }
    }

    public void onGlobalLayout() {
        this.mUtilityController.mDisplayController.getScreenSize();
        if (this.metrics.heightPixels - getContentViewHeight() > HttpResponseCode.MULTIPLE_CHOICES) {
            this.bKeyboardOut = true;
        } else {
            if ((this.mViewState == ViewState.DEFAULT && this.bKeyboardOut) || this.mViewState == ViewState.INTERSTITIAL || this.mViewState == ViewState.POSTITIAL) {
                ViewGroup viewGroup = (ViewGroup) getRootView();
                if (viewGroup != null) {
                    setMaxSize(viewGroup.getWidth(), viewGroup.getHeight());
                    this.mUtilityController.mDisplayController.onMaxSizeChanged();
                }
            }
            this.bKeyboardOut = false;
        }
        this.mUtilityController.mDisplayController.onOrientationMightBeChanged();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mWebChromeClient != null && (this.mWebChromeClient instanceof AmobeeChromeClient) && ((AmobeeChromeClient) this.mWebChromeClient).videoCloseButton != null) {
                ((AmobeeChromeClient) this.mWebChromeClient).finishVideoPlay();
                return true;
            } else if (this.mViewState == ViewState.INTERSTITIAL) {
                if (this.mWebChromeClient instanceof AmobeeChromeClient) {
                    ((AmobeeChromeClient) this.mWebChromeClient).finishVideoPlay();
                }
                closeInterstitial();
                return true;
            } else if (this.mViewState == ViewState.EXPANDED) {
                closeExpanded();
                return true;
            } else if (this.mViewState == ViewState.RESIZED) {
                closeResized();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.viewWidth = i;
        this.viewHeight = i2;
        if (this.metrics.heightPixels - getContentViewHeight() < HttpResponseCode.MULTIPLE_CHOICES) {
            getCurrentPosition();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mUserTouchedTheView = true;
        return super.onTouchEvent(motionEvent);
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        Log.m811d(LOG_TAG, "onVisibilityChanged " + i);
        if (this.mWebChromeClient == null || !(this.mWebChromeClient instanceof AmobeeChromeClient) || ((AmobeeChromeClient) this.mWebChromeClient).mVideoView == null || ((AmobeeChromeClient) this.mWebChromeClient).videoCloseButton == null) {
            if (i == 8) {
                hideVideo();
            }
            if (this.mViewState == ViewState.INTERSTITIAL && i == 8 && VERSION.SDK_INT >= 11) {
                closeInterstitial();
            }
            if (this.mViewState == ViewState.INTERSTITIAL && this.amobeeInterstitial != null) {
                this.mInterstitialRandom = this.amobeeInterstitial.getRandom();
                return;
            }
            return;
        }
        ((AmobeeChromeClient) this.mWebChromeClient).finishVideoPlay();
    }

    public void open(String str, boolean z, boolean z2, boolean z3) {
        Intent intent;
        try {
            if (urlContainsVideo(str)) {
                if (this.mListener != null) {
                    this.mListener.onLeavingApplication();
                }
                intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setDataAndType(Uri.parse(str), "video/*");
                intent.addFlags(268435456);
                getContext().startActivity(intent);
            } else if (this.mViewState == ViewState.POSTITIAL) {
                try {
                    if (this.mListener != null) {
                        this.mListener.onLeavingApplication();
                    }
                    intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    intent.addFlags(268435456);
                    getContext().startActivity(intent);
                } catch (Exception e) {
                    Log.m811d(LOG_TAG, "error:" + e.getMessage());
                }
            } else {
                intent = new Intent(getContext(), Browser.class);
                Log.m811d(TAG, "open:" + str);
                intent.putExtra(Browser.URL_EXTRA, str);
                intent.putExtra(Browser.SHOW_BACK_EXTRA, z);
                intent.putExtra(Browser.SHOW_FORWARD_EXTRA, z2);
                intent.putExtra(Browser.SHOW_REFRESH_EXTRA, z3);
                intent.addFlags(268435456);
                getContext().startActivity(intent);
                if (this.mListener != null && this.mViewState != ViewState.EXPANDED) {
                    this.mListener.onOverlay();
                }
            }
        } catch (Exception e2) {
            try {
                if (this.mListener != null) {
                    this.mListener.onLeavingApplication();
                }
                intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.addFlags(268435456);
                getContext().startActivity(intent);
            } catch (Exception e3) {
                Log.m811d(LOG_TAG, "error:" + e3.getMessage());
            }
        }
    }

    public void openMap(String str, boolean z) {
        Log.m811d(TAG, "Opening Map Url " + str);
        String convert = OrmmaUtils.convert(str.trim());
        if (z) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(convert));
                intent.setFlags(268435456);
                getContext().startActivity(intent);
            } catch (ActivityNotFoundException e) {
            }
        } else if (this.mapAPIKey == null) {
            Log.m811d(LOG_TAG, "Error: no Google Maps API Key provided for embedded map");
        }
    }

    public void playAudio(String str, boolean z, boolean z2, boolean z3, boolean z4, String str2, String str3) {
        Object playerProperties = new PlayerProperties();
        playerProperties.setProperties(false, z, z2, z4, z3, str2, str3);
        Bundle bundle = new Bundle();
        bundle.putString("action", ACTION.PLAY_AUDIO.toString());
        bundle.putString(EXPAND_URL, str);
        bundle.putParcelable(PLAYER_PROPERTIES, playerProperties);
        if (playerProperties.isFullScreen()) {
            try {
                Intent intent = new Intent(getContext(), AmobeeActionHandler.class);
                intent.putExtras(bundle);
                intent.addFlags(268435456);
                getContext().startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                return;
            }
        }
        Message obtainMessage = this.mHandler.obtainMessage(MESSAGE_PLAY_AUDIO);
        obtainMessage.setData(bundle);
        this.mHandler.sendMessage(obtainMessage);
    }

    public void playAudioImpl(Bundle bundle) {
        PlayerProperties playerProperties = (PlayerProperties) bundle.getParcelable(PLAYER_PROPERTIES);
        String string = bundle.getString(EXPAND_URL);
        View player = getPlayer();
        player.setPlayData(playerProperties, string);
        player.setLayoutParams(new LayoutParams(1, 1));
        ((ViewGroup) getParent()).addView(player);
        player.playAudio();
    }

    public void playVideo(String str) {
        try {
            if (URLUtil.isValidUrl(str)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (urlContainsVideo(str.toString())) {
                    intent.setDataAndType(Uri.parse(str), "video/*");
                }
                intent.addFlags(268435456);
                getContext().startActivity(intent);
                if (this.mListener != null) {
                    this.mListener.onLeavingApplication();
                }
            }
        } catch (Exception e) {
        }
    }

    public void playVideo(String str, boolean z, boolean z2, boolean z3, boolean z4, Dimensions dimensions, String str2, String str3) {
        Message obtainMessage = this.mHandler.obtainMessage(MESSAGE_PLAY_VIDEO);
        Object playerProperties = new PlayerProperties();
        playerProperties.setProperties(z, z2, z3, false, z4, str2, str3);
        Bundle bundle = new Bundle();
        bundle.putString(EXPAND_URL, str);
        bundle.putString("action", ACTION.PLAY_VIDEO.toString());
        bundle.putParcelable(PLAYER_PROPERTIES, playerProperties);
        if (dimensions != null) {
            bundle.putParcelable(DIMENSIONS, dimensions);
        }
        if (playerProperties.isFullScreen()) {
            try {
                Intent intent = new Intent(getContext(), AmobeeActionHandler.class);
                intent.putExtras(bundle);
                intent.addFlags(268435456);
                getContext().startActivity(intent);
            } catch (ActivityNotFoundException e) {
            }
        } else if (dimensions != null) {
            obtainMessage.setData(bundle);
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public void playVideoImpl(Bundle bundle) {
        PlayerProperties playerProperties = (PlayerProperties) bundle.getParcelable(PLAYER_PROPERTIES);
        Dimensions dimensions = (Dimensions) bundle.getParcelable(DIMENSIONS);
        String string = bundle.getString(EXPAND_URL);
        View player = getPlayer();
        player.setPlayData(playerProperties, string);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensions.width, dimensions.height);
        layoutParams.topMargin = dimensions.f435x;
        layoutParams.leftMargin = dimensions.f436y;
        player.setLayoutParams(layoutParams);
        View frameLayout = new FrameLayout(getContext());
        frameLayout.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.m813i(AmobeeView.LOG_TAG, "background touch called");
                return true;
            }
        });
        frameLayout.setId(this.BACKGROUND_ID);
        frameLayout.setPadding(dimensions.f435x, dimensions.f436y, 0, 0);
        ((FrameLayout) getRootView().findViewById(16908290)).addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(player);
        setVisibility(4);
        player.setListener(new OrmmaPlayerListener() {
            public void onComplete() {
                FrameLayout frameLayout = (FrameLayout) AmobeeView.this.getRootView().findViewById(AmobeeView.this.BACKGROUND_ID);
                ((ViewGroup) frameLayout.getParent()).removeView(frameLayout);
                AmobeeView.this.setVisibility(0);
            }

            public void onError() {
                onComplete();
            }

            public void onPrepared() {
            }
        });
        player.playVideo();
    }

    public void raiseError(String str, String str2) {
        Message obtainMessage = this.mHandler.obtainMessage(MESSAGE_RAISE_ERROR);
        Bundle bundle = new Bundle();
        bundle.putString("message", str);
        bundle.putString("action", str2);
        obtainMessage.setData(bundle);
        this.mHandler.sendMessage(obtainMessage);
    }

    public void registerProtocol(String str) {
        if (str != null) {
            this.registeredProtocols.add(str.toLowerCase());
        }
    }

    void removeExpndedUrl(AmobeeView amobeeView) {
        if (amobeeView.mWebChromeClient instanceof AmobeeChromeClient) {
            ((AmobeeChromeClient) this.mWebChromeClient).finishVideoPlay();
        }
        amobeeView.parentView.hasExpandedView = false;
        FrameLayout frameLayout = (FrameLayout) amobeeView.getParent();
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            ViewGroup viewGroup = (ViewGroup) getRootView();
            if (viewGroup != null) {
                viewGroup.removeView(frameLayout);
            }
        }
    }

    public void removeListener() {
        this.mListener = null;
    }

    public void resetContents() {
        try {
            if (this.mWebChromeClient instanceof AmobeeChromeClient) {
                ((AmobeeChromeClient) this.mWebChromeClient).finishVideoPlay();
            }
            ViewGroup viewGroup = (ViewGroup) getRootView();
            FrameLayout frameLayout = (FrameLayout) getRootView().findViewById(this.BACKGROUND_ID);
            synchronized (this) {
                frameLayout.removeAllViews();
                viewGroup.removeView(frameLayout);
                if (getParent() != null) {
                    ((ViewGroup) getParent()).removeView(this);
                }
                resetLayout();
                if (this.placeHolder != null) {
                    viewGroup = (ViewGroup) this.placeHolder.getParent();
                    LayoutParams layoutParams = this.placeHolder.getLayoutParams();
                    if (layoutParams.width != this.mInitLayoutWidth) {
                        layoutParams.width = -1;
                    }
                    viewGroup.addView(this, this.mIndex, layoutParams);
                    viewGroup.removeView(this.placeHolder);
                    viewGroup.invalidate();
                }
            }
        } catch (Exception e) {
            Log.m812e(LOG_TAG, "resetContents");
        }
    }

    public void resize(int i, int i2, String str, int i3, int i4, boolean z) {
        Message obtainMessage = this.mHandler.obtainMessage(1000);
        Bundle bundle = new Bundle();
        bundle.putInt(RESIZE_WIDTH, i);
        bundle.putInt(RESIZE_HEIGHT, i2);
        bundle.putString(RESIZE_CUSTOM_CLOSE_POSITION, str);
        bundle.putInt(RESIZE_OFFSET_X, i3);
        bundle.putInt(RESIZE_OFFSET_Y, i4);
        bundle.putBoolean(RESIZE_CUSTOM_ALLOW_OFF_SCREEN, z);
        obtainMessage.setData(bundle);
        this.mHandler.sendMessage(obtainMessage);
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        this.mLocalFilePath = bundle.getString(AD_PATH);
        super.loadUrl("file://" + this.mLocalFilePath + File.separator + CURRENT_FILE);
        return null;
    }

    public WebBackForwardList saveState(Bundle bundle) {
        bundle.putString(AD_PATH, this.mLocalFilePath);
        return null;
    }

    public void setInitSize() {
        LayoutParams layoutParams = getLayoutParams();
        this.mInitLayoutHeight = layoutParams.height;
        this.mInitLayoutWidth = layoutParams.width;
        this.bGotLayoutParams = true;
    }

    public void setListener(OrmmaViewListener ormmaViewListener) {
        this.mListener = ormmaViewListener;
    }

    public void setMapAPIKey(String str) {
        this.mapAPIKey = str;
    }

    public void setMaxSize(int i, int i2) {
        this.mUtilityController.setMaxSize(i, i2);
    }

    public void setOrientationDefault() {
        if (this.mDidChangeOrientation) {
            ((Activity) getContext()).setRequestedOrientation(this.originalAppOrientation);
            this.mDidChangeOrientation = false;
        }
    }

    public void setOrientationProperties(String str) {
        boolean booleanValue;
        int i;
        if (this.mViewState == ViewState.POSTITIAL) {
            Log.m811d(TAG, "abort setOrientationProperties on postitial");
            return;
        }
        String str2;
        boolean z;
        int i2;
        String str3 = "none";
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("allowOrientationChange");
            booleanValue = Boolean.valueOf(string).booleanValue();
            try {
                str3 = jSONObject.getString("forceOrientation");
                Log.m811d(TAG, "setOrientationProperties: setOrientationProperties" + str3 + "allowOrientationChange" + string);
                str2 = str3;
                z = booleanValue;
            } catch (JSONException e) {
                str2 = str3;
                z = booleanValue;
                i2 = ((Activity) getContext()).getPackageManager().getActivityInfo(((Activity) getContext()).getComponentName(), 128).configChanges;
                i = VERSION.SDK_INT;
                Log.m811d(TAG, "setOrientationProperties: abort, configChanges missing");
                return;
            }
        } catch (JSONException e2) {
            booleanValue = true;
            str2 = str3;
            z = booleanValue;
            i2 = ((Activity) getContext()).getPackageManager().getActivityInfo(((Activity) getContext()).getComponentName(), 128).configChanges;
            i = VERSION.SDK_INT;
            Log.m811d(TAG, "setOrientationProperties: abort, configChanges missing");
            return;
        }
        try {
            i2 = ((Activity) getContext()).getPackageManager().getActivityInfo(((Activity) getContext()).getComponentName(), 128).configChanges;
            i = VERSION.SDK_INT;
            if (i2 == 0 || (i2 & 128) == 0 || (i >= 13 && (i2 & CONFIG_SCREEN_SIZE) == 0)) {
                Log.m811d(TAG, "setOrientationProperties: abort, configChanges missing");
                return;
            }
        } catch (NameNotFoundException e3) {
        } catch (Exception e4) {
            Log.m811d(AdManager.TAG, "setOrientationProperties: abort, not supported on non Acitivy views");
            return;
        }
        this.originalAppOrientation = ((Activity) getContext()).getRequestedOrientation();
        if (!z) {
            this.mDidChangeOrientation = true;
            if (((Activity) getContext()).getResources().getConfiguration().orientation == 2) {
                ((Activity) getContext()).setRequestedOrientation(0);
            } else {
                ((Activity) getContext()).setRequestedOrientation(1);
            }
        }
        if (str2.equals("portrait")) {
            this.mDidChangeOrientation = true;
            ((Activity) getContext()).setRequestedOrientation(1);
        } else if (str2.equals("landscape")) {
            this.mDidChangeOrientation = true;
            ((Activity) getContext()).setRequestedOrientation(0);
        }
    }

    public void setUserGestureRequiredToOpenAds(boolean z) {
        this.mUserGestureRequiredToOpenAds = z;
    }

    public void setViewable(boolean z) {
        String str = "window.ormmaview.fireChangeEvent({ viewable: " + z + " });";
        Log.m811d(LOG_TAG, "setViewable: injection: " + str);
        injectJavaScriptRichMedia(str);
    }

    public void show() {
        this.mHandler.sendEmptyMessage(MESSAGE_SHOW);
    }

    public void storePicture(final String str) {
        if (this.mViewState == ViewState.POSTITIAL) {
            Log.m812e(LOG_TAG, "Store picture is not supported by the Postitial ad.");
            return;
        }
        try {
            DialogInterface.OnClickListener anonymousClass15 = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    new downloadPicture().execute(new String[]{str});
                }
            };
            DialogInterface.OnClickListener anonymousClass16 = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    AmobeeView.this.raiseError("Store picture canceled by the user.", "storePicture");
                }
            };
            Builder builder = new Builder(getContext());
            builder.setTitle("Store Picture");
            builder.setMessage("Would you like to save the picture to your photo album?");
            builder.setPositiveButton("yes", anonymousClass15);
            builder.setNegativeButton("no", anonymousClass16);
            builder.show();
        } catch (Exception e) {
            Log.m812e(LOG_TAG, "store picture failed");
        }
    }

    boolean urlContainsVideo(String str) {
        String toLowerCase = str.toLowerCase();
        return toLowerCase.endsWith(MATROSKA) || toLowerCase.endsWith(GPP_3) || toLowerCase.endsWith(WEBM) || toLowerCase.endsWith(MPEG_TS) || toLowerCase.endsWith(MPEG_4);
    }

    public void useCustomClose(boolean z) {
        if (!z) {
            this.mHandler.sendEmptyMessage(MESSAGE_ADD_CUSTOM_CLOSE);
        }
    }
}
