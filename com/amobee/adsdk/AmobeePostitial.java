package com.amobee.adsdk;

import android.content.Context;
import android.os.AsyncTask;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.amobee.pulse3d.Pulse3DView;
import com.amobee.pulse3d.Pulse3DViewListener;
import com.amobee.richmedia.view.AmobeeView;
import com.amobee.richmedia.view.AmobeeView.OrmmaViewListener;
import com.amobee.richmedia.view.AmobeeView.ViewState;
import java.util.HashMap;

public final class AmobeePostitial {
    private String mAdSpace;
    private Context mContext;
    private String mHtml;
    private AmobeePostitialListener mListener = new C03161();
    private ViewGroup mPlaceholder;

    class C03161 implements AmobeePostitialListener {
        C03161() {
        }

        public void postitialClicked(AmobeePostitial amobeePostitial) {
        }

        public void postitialClosed(AmobeePostitial amobeePostitial) {
        }

        public void postitialFailed(AmobeePostitial amobeePostitial) {
        }

        public void postitialOnKey(int i) {
        }

        public void postitialRecieved(AmobeePostitial amobeePostitial) {
        }
    }

    class C03172 implements AmobeePostitialListener {
        C03172() {
        }

        public void postitialClicked(AmobeePostitial amobeePostitial) {
        }

        public void postitialClosed(AmobeePostitial amobeePostitial) {
        }

        public void postitialFailed(AmobeePostitial amobeePostitial) {
        }

        public void postitialOnKey(int i) {
        }

        public void postitialRecieved(AmobeePostitial amobeePostitial) {
        }
    }

    static class CreatePulse3DAdapterWrapper {

        class C03201 implements Pulse3DViewListener {
            private final /* synthetic */ AmobeePostitialListener val$listener;
            private final /* synthetic */ AmobeePostitial val$postitial;
            private final /* synthetic */ ProgressBar val$progressBar;
            private final /* synthetic */ RelativeLayout val$progressBarHolder;

            C03201(AmobeePostitialListener amobeePostitialListener, AmobeePostitial amobeePostitial, ProgressBar progressBar, RelativeLayout relativeLayout) {
                this.val$listener = amobeePostitialListener;
                this.val$postitial = amobeePostitial;
                this.val$progressBar = progressBar;
                this.val$progressBarHolder = relativeLayout;
            }

            public void onEndTransition(Pulse3DView pulse3DView, boolean z) {
            }

            public void onFailLoadingSceneAtURL(Pulse3DView pulse3DView, String str, Error error) {
            }

            public void onFinishLoadingSceneAtURL(final Pulse3DView pulse3DView, String str) {
                final ProgressBar progressBar = this.val$progressBar;
                final RelativeLayout relativeLayout = this.val$progressBarHolder;
                pulse3DView.post(new Runnable() {
                    public void run() {
                        progressBar.setVisibility(8);
                        relativeLayout.setVisibility(8);
                        pulse3DView.setVisibility(0);
                        pulse3DView.willMoveOnScreen();
                    }
                });
            }

            public void onLeavingApplication(Pulse3DView pulse3DView) {
                final AmobeePostitialListener amobeePostitialListener = this.val$listener;
                final AmobeePostitial amobeePostitial = this.val$postitial;
                pulse3DView.post(new Runnable() {
                    public void run() {
                        amobeePostitialListener.postitialClicked(amobeePostitial);
                    }
                });
            }

            public void onStartTransition(Pulse3DView pulse3DView, boolean z) {
                if (!z) {
                    this.val$listener.postitialClosed(this.val$postitial);
                }
            }

            public boolean webLinkOutRequested(String str, boolean z) {
                return false;
            }
        }

        class C03212 implements OnKeyListener {
            private final /* synthetic */ AmobeePostitialListener val$listener;

            C03212(AmobeePostitialListener amobeePostitialListener) {
                this.val$listener = amobeePostitialListener;
            }

            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                this.val$listener.postitialOnKey(i);
                return false;
            }
        }

        CreatePulse3DAdapterWrapper() {
        }

        static void createPulse3DView(AmobeePostitial amobeePostitial, ViewGroup viewGroup, AmobeePostitialListener amobeePostitialListener, String str, Context context) {
            String str2 = "";
            int indexOf = str.indexOf("<Pulse3DFileLocation>") + "<Pulse3DFileLocation>".length();
            if (indexOf > -1) {
                str2 = str.substring(indexOf);
                indexOf = str2.indexOf("</Pulse3DFileLocation>");
                if (indexOf > -1) {
                    str2 = str2.substring(0, indexOf);
                }
            }
            View progressBar = new ProgressBar(context);
            View relativeLayout = new RelativeLayout(context);
            Pulse3DView pulse3DView = new Pulse3DView(context);
            pulse3DView.setPulse3DViewListener(new C03201(amobeePostitialListener, amobeePostitial, progressBar, relativeLayout));
            pulse3DView.setOnKeyListener(new C03212(amobeePostitialListener));
            relativeLayout.setLayoutParams(new LayoutParams(-1, -1));
            progressBar.setIndeterminate(true);
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, 1);
            progressBar.setLayoutParams(layoutParams);
            relativeLayout.addView(progressBar);
            viewGroup.addView(pulse3DView);
            viewGroup.addView(relativeLayout);
            progressBar.setVisibility(0);
            pulse3DView.loadSceneAtURL(str2, true, true);
        }
    }

    class loadPostitial extends AsyncTask<Void, Void, Void> {

        class C03221 implements OrmmaViewListener {
            C03221() {
            }

            public void handleRequest(String str) {
            }

            public boolean onEventFired() {
                return false;
            }

            public boolean onExpand() {
                return false;
            }

            public boolean onExpandClose() {
                return false;
            }

            public void onLeavingApplication() {
                AmobeePostitial.this.mListener.postitialClicked(AmobeePostitial.this);
            }

            public boolean onOverlay() {
                return false;
            }

            public boolean onPostitialClose() {
                AmobeePostitial.this.mListener.postitialClosed(AmobeePostitial.this);
                return true;
            }

            public boolean onReady() {
                return false;
            }

            public boolean onResize() {
                return false;
            }

            public boolean onResizeClose() {
                return false;
            }
        }

        class C03232 implements OnKeyListener {
            C03232() {
            }

            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                AmobeePostitial.this.mListener.postitialOnKey(i);
                return false;
            }
        }

        loadPostitial() {
        }

        protected Void doInBackground(Void... voidArr) {
            HashMap hashMap = new HashMap();
            String str = "";
            String str2 = "";
            HashMap requestPostitial = NetworkHelper.requestPostitial(AmobeePostitial.this.mAdSpace);
            if (requestPostitial == null) {
                AmobeePostitial.this.mListener.postitialFailed(AmobeePostitial.this);
            } else {
                if (requestPostitial.get(NetworkHelper.FRAGMENT) != null) {
                    str = (String) requestPostitial.get(NetworkHelper.FRAGMENT);
                    Log.m811d(AdManager.TAG, "Postitial fragment: " + str);
                }
                String str3 = str;
                str = requestPostitial.get(NetworkHelper.STATUS) != null ? (String) requestPostitial.get(NetworkHelper.STATUS) : str2;
                if (str3.equals("") || !str.equals("6200")) {
                    AmobeePostitial.this.mListener.postitialFailed(AmobeePostitial.this);
                } else {
                    AmobeePostitial.this.mHtml = str3;
                    AmobeePostitial.this.mListener.postitialRecieved(AmobeePostitial.this);
                }
            }
            return null;
        }

        protected void onPostExecute(Void voidR) {
            if (AmobeePostitial.this.mHtml != null && !AmobeePostitial.this.mHtml.equals("")) {
                AmobeePostitial.this.mPlaceholder.setBackgroundColor(-1);
                if (AmobeePostitial.this.mHtml.contains("<Pulse3DFileLocation>")) {
                    AmobeePostitial.createPulse3DAdapter(AmobeePostitial.this, AmobeePostitial.this.mPlaceholder, AmobeePostitial.this.mListener, AmobeePostitial.this.mHtml, AdManager.getInstance().getContext());
                    return;
                }
                View amobeeView = new AmobeeView(AmobeePostitial.this.mContext);
                amobeeView.mViewState = ViewState.POSTITIAL;
                amobeeView.setLayoutParams(new LayoutParams(-1, -1));
                amobeeView.setUserGestureRequiredToOpenAds(AdManager.getInstance(AmobeePostitial.this.mContext).getUserGestureRequiredToOpenAds());
                amobeeView.setListener(new C03221());
                amobeeView.setOnKeyListener(new C03232());
                amobeeView.loadString(AmobeePostitial.this.mHtml, null);
                AmobeePostitial.this.mPlaceholder.addView(amobeeView);
            }
        }
    }

    public AmobeePostitial(Context context) {
        this.mContext = context;
    }

    static void createPulse3DAdapter(AmobeePostitial amobeePostitial, ViewGroup viewGroup, AmobeePostitialListener amobeePostitialListener, String str, Context context) {
        CreatePulse3DAdapterWrapper.createPulse3DView(amobeePostitial, viewGroup, amobeePostitialListener, str, context);
    }

    public void getPostitial(ViewGroup viewGroup) {
        AdManager instance = AdManager.getInstance();
        if (instance == null || instance.parameters().getAdSpace() == null) {
            Log.m811d(AdManager.TAG, " AmobeePostitial - no ad space has been defined in the AdManager, adspace is mandatory in order to get ads.");
        } else {
            getPostitial(viewGroup, instance.parameters().getAdSpace());
        }
    }

    public void getPostitial(ViewGroup viewGroup, String str) {
        this.mPlaceholder = viewGroup;
        this.mAdSpace = str;
        if (this.mAdSpace == null) {
            Log.m811d(AdManager.TAG, "AmobeePostitial - The ad space field is mandatory in order to get ads.");
        } else {
            new loadPostitial().execute(new Void[0]);
        }
    }

    public void setListener(AmobeePostitialListener amobeePostitialListener) {
        if (amobeePostitialListener == null) {
            this.mListener = new C03172();
        } else {
            this.mListener = amobeePostitialListener;
        }
    }

    public void showPostitial() {
        int childCount = this.mPlaceholder.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (this.mPlaceholder.getChildAt(i).getClass() == AmobeeView.class) {
                ((AmobeeView) this.mPlaceholder.getChildAt(i)).setViewable(true);
                return;
            }
        }
    }
}
