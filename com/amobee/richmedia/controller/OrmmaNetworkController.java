package com.amobee.richmedia.controller;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.amobee.adsdk.Log;
import com.amobee.richmedia.controller.util.OrmmaNetworkBroadcastReceiver;
import com.amobee.richmedia.view.AmobeeView;

public class OrmmaNetworkController extends OrmmaController {
    private static /* synthetic */ int[] $SWITCH_TABLE$android$net$NetworkInfo$State = null;
    private static final String LOG_TAG = "AmobeeViewNetworkController";
    private OrmmaNetworkBroadcastReceiver mBroadCastReceiver;
    private ConnectivityManager mConnectivityManager;
    private IntentFilter mFilter;
    private int mNetworkListenerCount;

    static /* synthetic */ int[] $SWITCH_TABLE$android$net$NetworkInfo$State() {
        int[] iArr = $SWITCH_TABLE$android$net$NetworkInfo$State;
        if (iArr == null) {
            iArr = new int[State.values().length];
            try {
                iArr[State.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[State.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[State.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[State.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[State.SUSPENDED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[State.UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $SWITCH_TABLE$android$net$NetworkInfo$State = iArr;
        }
        return iArr;
    }

    public OrmmaNetworkController(AmobeeView amobeeView, Context context) {
        super(amobeeView, context);
        this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public String getNetwork() {
        String str = "unknown";
        try {
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                switch ($SWITCH_TABLE$android$net$NetworkInfo$State()[activeNetworkInfo.getState().ordinal()]) {
                    case 3:
                        str = "offline";
                        break;
                    case 6:
                        str = "unknown";
                        break;
                    default:
                        int type = activeNetworkInfo.getType();
                        if (type != 0) {
                            if (type == 1) {
                                str = "wifi";
                                break;
                            }
                        }
                        str = "cell";
                        break;
                        break;
                }
            }
            str = "offline";
            Log.m811d(LOG_TAG, "getNetwork: " + str);
        } catch (Exception e) {
        }
        return str;
    }

    public void onConnectionChanged() {
        this.mOrmmaView.injectJavaScriptRichMedia("window.ormmaview.fireChangeEvent({ network: '" + getNetwork() + "'});");
    }

    public void startNetworkListener() {
        if (this.mNetworkListenerCount == 0) {
            this.mBroadCastReceiver = new OrmmaNetworkBroadcastReceiver(this);
            this.mFilter = new IntentFilter();
            this.mFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        this.mNetworkListenerCount++;
        this.mContext.registerReceiver(this.mBroadCastReceiver, this.mFilter);
    }

    public void stopAllListeners() {
        this.mNetworkListenerCount = 0;
        try {
            this.mContext.unregisterReceiver(this.mBroadCastReceiver);
        } catch (Exception e) {
        }
    }

    public void stopNetworkListener() {
        this.mNetworkListenerCount--;
        if (this.mNetworkListenerCount == 0) {
            this.mContext.unregisterReceiver(this.mBroadCastReceiver);
            this.mBroadCastReceiver = null;
            this.mFilter = null;
        }
    }
}
