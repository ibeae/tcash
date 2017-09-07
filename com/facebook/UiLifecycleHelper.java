package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.p001a.C0035i;
import android.util.Log;
import com.facebook.Session.StatusCallback;
import com.facebook.internal.LikeActionController;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PendingCallStore;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;
import java.util.UUID;

public class UiLifecycleHelper {
    private static final String ACTIVITY_NULL_MESSAGE = "activity cannot be null";
    private static final String DIALOG_CALL_ID_SAVE_KEY = "com.facebook.UiLifecycleHelper.pendingFacebookDialogCallKey";
    private final Activity activity;
    private AppEventsLogger appEventsLogger;
    private final C0035i broadcastManager;
    private final StatusCallback callback;
    private UUID pendingFacebookDialogCallId;
    private PendingCallStore pendingFacebookDialogCallStore;
    private final BroadcastReceiver receiver;

    private class ActiveSessionBroadcastReceiver extends BroadcastReceiver {
        private ActiveSessionBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Session activeSession;
            if (Session.ACTION_ACTIVE_SESSION_SET.equals(intent.getAction())) {
                activeSession = Session.getActiveSession();
                if (activeSession != null && UiLifecycleHelper.this.callback != null) {
                    activeSession.addCallback(UiLifecycleHelper.this.callback);
                }
            } else if (Session.ACTION_ACTIVE_SESSION_UNSET.equals(intent.getAction())) {
                activeSession = Session.getActiveSession();
                if (activeSession != null && UiLifecycleHelper.this.callback != null) {
                    activeSession.removeCallback(UiLifecycleHelper.this.callback);
                }
            }
        }
    }

    public UiLifecycleHelper(Activity activity, StatusCallback statusCallback) {
        if (activity == null) {
            throw new IllegalArgumentException(ACTIVITY_NULL_MESSAGE);
        }
        this.activity = activity;
        this.callback = statusCallback;
        this.receiver = new ActiveSessionBroadcastReceiver();
        this.broadcastManager = C0035i.m60a((Context) activity);
        this.pendingFacebookDialogCallStore = PendingCallStore.getInstance();
        Settings.sdkInitialize(activity);
    }

    private void cancelPendingAppCall(Callback callback) {
        if (this.pendingFacebookDialogCallId != null) {
            PendingCall pendingCallById = this.pendingFacebookDialogCallStore.getPendingCallById(this.pendingFacebookDialogCallId);
            if (pendingCallById != null) {
                if (callback != null) {
                    Intent requestIntent = pendingCallById.getRequestIntent();
                    Intent intent = new Intent();
                    intent.putExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID, requestIntent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID));
                    intent.putExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION, requestIntent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION));
                    intent.putExtra(NativeProtocol.EXTRA_PROTOCOL_VERSION, requestIntent.getIntExtra(NativeProtocol.EXTRA_PROTOCOL_VERSION, 0));
                    intent.putExtra(NativeProtocol.STATUS_ERROR_TYPE, NativeProtocol.ERROR_UNKNOWN_ERROR);
                    FacebookDialog.handleActivityResult(this.activity, pendingCallById, pendingCallById.getRequestCode(), intent, callback);
                }
                stopTrackingPendingAppCall();
            }
        }
    }

    private boolean handleFacebookDialogActivityResult(int i, int i2, Intent intent, Callback callback) {
        if (this.pendingFacebookDialogCallId == null) {
            return false;
        }
        PendingCall pendingCallById = this.pendingFacebookDialogCallStore.getPendingCallById(this.pendingFacebookDialogCallId);
        if (pendingCallById == null || pendingCallById.getRequestCode() != i) {
            return false;
        }
        if (intent == null) {
            cancelPendingAppCall(callback);
            return true;
        }
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
        if (callIdFromIntent == null || !this.pendingFacebookDialogCallId.equals(callIdFromIntent)) {
            cancelPendingAppCall(callback);
        } else {
            FacebookDialog.handleActivityResult(this.activity, pendingCallById, i, intent, callback);
        }
        stopTrackingPendingAppCall();
        return true;
    }

    private void stopTrackingPendingAppCall() {
        this.pendingFacebookDialogCallStore.stopTrackingPendingCall(this.pendingFacebookDialogCallId);
        this.pendingFacebookDialogCallId = null;
    }

    public AppEventsLogger getAppEventsLogger() {
        Session activeSession = Session.getActiveSession();
        if (activeSession == null) {
            return null;
        }
        if (this.appEventsLogger == null || !this.appEventsLogger.isValidForSession(activeSession)) {
            if (this.appEventsLogger != null) {
                AppEventsLogger.onContextStop();
            }
            this.appEventsLogger = AppEventsLogger.newLogger(this.activity, activeSession);
        }
        return this.appEventsLogger;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent, null);
    }

    public void onActivityResult(int i, int i2, Intent intent, Callback callback) {
        Session activeSession = Session.getActiveSession();
        if (activeSession != null) {
            activeSession.onActivityResult(this.activity, i, i2, intent);
        }
        if (!LikeActionController.handleOnActivityResult(this.activity, i, i2, intent)) {
            handleFacebookDialogActivityResult(i, i2, intent, callback);
        }
    }

    public void onCreate(Bundle bundle) {
        Session activeSession = Session.getActiveSession();
        if (activeSession == null) {
            if (bundle != null) {
                activeSession = Session.restoreSession(this.activity, null, this.callback, bundle);
            }
            if (activeSession == null) {
                activeSession = new Session(this.activity);
            }
            Session.setActiveSession(activeSession);
        }
        if (bundle != null) {
            String string = bundle.getString(DIALOG_CALL_ID_SAVE_KEY);
            if (string != null) {
                this.pendingFacebookDialogCallId = UUID.fromString(string);
            }
            this.pendingFacebookDialogCallStore.restoreFromSavedInstanceState(bundle);
        }
    }

    public void onDestroy() {
    }

    public void onPause() {
        this.broadcastManager.m63a(this.receiver);
        if (this.callback != null) {
            Session activeSession = Session.getActiveSession();
            if (activeSession != null) {
                activeSession.removeCallback(this.callback);
            }
        }
    }

    public void onResume() {
        Session activeSession = Session.getActiveSession();
        if (activeSession != null) {
            if (this.callback != null) {
                activeSession.addCallback(this.callback);
            }
            if (SessionState.CREATED_TOKEN_LOADED.equals(activeSession.getState())) {
                activeSession.openForRead(null);
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_SET);
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_UNSET);
        this.broadcastManager.m64a(this.receiver, intentFilter);
    }

    public void onSaveInstanceState(Bundle bundle) {
        Session.saveSession(Session.getActiveSession(), bundle);
        if (this.pendingFacebookDialogCallId != null) {
            bundle.putString(DIALOG_CALL_ID_SAVE_KEY, this.pendingFacebookDialogCallId.toString());
        }
        this.pendingFacebookDialogCallStore.saveInstanceState(bundle);
    }

    public void onStop() {
        AppEventsLogger.onContextStop();
    }

    public void trackPendingDialogCall(PendingCall pendingCall) {
        if (this.pendingFacebookDialogCallId != null) {
            Log.i("Facebook", "Tracking new app call while one is still pending; canceling pending call.");
            cancelPendingAppCall(null);
        }
        if (pendingCall != null) {
            this.pendingFacebookDialogCallId = pendingCall.getCallId();
            this.pendingFacebookDialogCallStore.trackPendingCall(pendingCall);
        }
    }
}
