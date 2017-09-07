package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.p001a.C0035i;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

public class SessionTracker {
    private final C0035i broadcastManager;
    private final StatusCallback callback;
    private boolean isTracking;
    private final BroadcastReceiver receiver;
    private Session session;

    private class ActiveSessionBroadcastReceiver extends BroadcastReceiver {
        private ActiveSessionBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (Session.ACTION_ACTIVE_SESSION_SET.equals(intent.getAction())) {
                Session activeSession = Session.getActiveSession();
                if (activeSession != null) {
                    activeSession.addCallback(SessionTracker.this.callback);
                }
            }
        }
    }

    private class CallbackWrapper implements StatusCallback {
        private final StatusCallback wrapped;

        public CallbackWrapper(StatusCallback statusCallback) {
            this.wrapped = statusCallback;
        }

        public void call(Session session, SessionState sessionState, Exception exception) {
            if (this.wrapped != null && SessionTracker.this.isTracking()) {
                this.wrapped.call(session, sessionState, exception);
            }
            if (session == SessionTracker.this.session && sessionState.isClosed()) {
                SessionTracker.this.setSession(null);
            }
        }
    }

    public SessionTracker(Context context, StatusCallback statusCallback) {
        this(context, statusCallback, null);
    }

    SessionTracker(Context context, StatusCallback statusCallback, Session session) {
        this(context, statusCallback, session, true);
    }

    public SessionTracker(Context context, StatusCallback statusCallback, Session session, boolean z) {
        this.isTracking = false;
        this.callback = new CallbackWrapper(statusCallback);
        this.session = session;
        this.receiver = new ActiveSessionBroadcastReceiver();
        this.broadcastManager = C0035i.m60a(context);
        if (z) {
            startTracking();
        }
    }

    private void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_SET);
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_UNSET);
        this.broadcastManager.m64a(this.receiver, intentFilter);
    }

    public Session getOpenSession() {
        Session session = getSession();
        return (session == null || !session.isOpened()) ? null : session;
    }

    public Session getSession() {
        return this.session == null ? Session.getActiveSession() : this.session;
    }

    public boolean isTracking() {
        return this.isTracking;
    }

    public boolean isTrackingActiveSession() {
        return this.session == null;
    }

    public void setSession(Session session) {
        if (session != null) {
            if (this.session == null) {
                Session activeSession = Session.getActiveSession();
                if (activeSession != null) {
                    activeSession.removeCallback(this.callback);
                }
                this.broadcastManager.m63a(this.receiver);
            } else {
                this.session.removeCallback(this.callback);
            }
            this.session = session;
            this.session.addCallback(this.callback);
        } else if (this.session != null) {
            this.session.removeCallback(this.callback);
            this.session = null;
            addBroadcastReceiver();
            if (getSession() != null) {
                getSession().addCallback(this.callback);
            }
        }
    }

    public void startTracking() {
        if (!this.isTracking) {
            if (this.session == null) {
                addBroadcastReceiver();
            }
            if (getSession() != null) {
                getSession().addCallback(this.callback);
            }
            this.isTracking = true;
        }
    }

    public void stopTracking() {
        if (this.isTracking) {
            Session session = getSession();
            if (session != null) {
                session.removeCallback(this.callback);
            }
            this.broadcastManager.m63a(this.receiver);
            this.isTracking = false;
        }
    }
}
