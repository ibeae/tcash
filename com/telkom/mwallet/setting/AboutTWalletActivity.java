package com.telkom.mwallet.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;
import com.facebook.widget.FacebookDialog.ShareDialogBuilder;
import com.facebook.widget.FacebookDialog.ShareDialogFeature;
import com.facebook.widget.LoginButton;
import com.facebook.widget.LoginButton.UserInfoChangedCallback;
import com.facebook.widget.WebDialog.FeedDialogBuilder;
import com.facebook.widget.WebDialog.OnCompleteListener;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.C1302b;
import com.telkom.mwallet.R;
import com.telkom.mwallet.setting.twitter.C1703d;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class AboutTWalletActivity extends SlidingFrameActivity {
    private static final String f3960l = AboutTWalletActivity.class.getSimpleName();
    private GraphUser f3961A;
    private UiLifecycleHelper f3962B;
    private StatusCallback f3963C = new C16111(this);
    private Callback f3964D = new C16122(this);
    public C1703d f3965k;
    private C1630a f3966m;
    private final String f3967n = "com.facebook.samples.hellofacebook:PendingAction";
    private C1615a f3968o = C1615a.NONE;
    private LoginButton f3969z;

    class C16111 implements StatusCallback {
        final /* synthetic */ AboutTWalletActivity f3953a;

        C16111(AboutTWalletActivity aboutTWalletActivity) {
            this.f3953a = aboutTWalletActivity;
        }

        public void call(Session session, SessionState sessionState, Exception exception) {
            this.f3953a.m6068a(session, sessionState, exception);
            if (this.f3953a.m6075t() && this.f3953a.f3968o == C1615a.FEED) {
                this.f3953a.m6073r();
            }
        }
    }

    class C16122 implements Callback {
        final /* synthetic */ AboutTWalletActivity f3954a;

        C16122(AboutTWalletActivity aboutTWalletActivity) {
            this.f3954a = aboutTWalletActivity;
        }

        public void onComplete(PendingCall pendingCall, Bundle bundle) {
            C1216a.m4519a("HelloFacebook", "Success!");
        }

        public void onError(PendingCall pendingCall, Exception exception, Bundle bundle) {
            C1216a.m4519a("HelloFacebook", String.format("Error: %s", new Object[]{exception.toString()}));
        }
    }

    class C16133 implements UserInfoChangedCallback {
        final /* synthetic */ AboutTWalletActivity f3955a;

        C16133(AboutTWalletActivity aboutTWalletActivity) {
            this.f3955a = aboutTWalletActivity;
        }

        public void onUserInfoFetched(GraphUser graphUser) {
            C1216a.m4522b("Change ", " UserInfoChanged" + this.f3955a.m6075t());
            this.f3955a.f3961A = graphUser;
            C1216a.m4522b("call ", "user " + graphUser);
            if (this.f3955a.m6075t()) {
                this.f3955a.m6073r();
            }
        }
    }

    class C16144 implements OnCompleteListener {
        final /* synthetic */ AboutTWalletActivity f3956a;

        C16144(AboutTWalletActivity aboutTWalletActivity) {
            this.f3956a = aboutTWalletActivity;
        }

        public void onComplete(Bundle bundle, FacebookException facebookException) {
            if (facebookException == null) {
                String string = bundle.getString("post_id");
                if (string != null) {
                    Toast.makeText(this.f3956a, "Posted story, id: " + string, 0).show();
                } else {
                    Toast.makeText(this.f3956a.getApplicationContext(), "Publish cancelled", 0).show();
                }
            } else if (facebookException instanceof FacebookOperationCanceledException) {
                Toast.makeText(this.f3956a.getApplicationContext(), "Publish cancelled", 0).show();
            } else {
                Toast.makeText(this.f3956a.getApplicationContext(), "Error posting story", 0).show();
            }
        }
    }

    private enum C1615a {
        NONE,
        FEED
    }

    private void m6068a(Session session, SessionState sessionState, Exception exception) {
        C1216a.m4522b(f3960l, "onSessionStateChange " + m6075t());
    }

    private void m6073r() {
        if (FacebookDialog.canPresentShareDialog(getApplicationContext(), ShareDialogFeature.SHARE_DIALOG)) {
            this.f3962B.trackPendingDialogCall(((ShareDialogBuilder) new ShareDialogBuilder(this).setLink("https://developers.facebook.com/android")).build().present());
            return;
        }
        m6074s();
    }

    private void m6074s() {
        Bundle bundle = new Bundle();
        bundle.putString("name", getString(R.string.app_name_desc));
        bundle.putString("description", getString(R.string.body_message));
        bundle.putString("link", getString(R.string.app_link));
        bundle.putString("picture", getString(R.string.logo_image));
        ((FeedDialogBuilder) new FeedDialogBuilder((Context) this, Session.getActiveSession(), bundle).setOnCompleteListener(new C16144(this))).build().show();
    }

    private boolean m6075t() {
        Session activeSession = Session.getActiveSession();
        boolean z = activeSession != null && activeSession.isOpened();
        C1216a.m4522b(f3960l, "isSessionValid " + z);
        return z;
    }

    protected void mo1505o() {
        this.f3965k.m6411c();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f3962B.onActivityResult(i, i2, intent, this.f3964D);
    }

    public void onBackPressed() {
        C1216a.m4522b(f3960l, " onBackPressed >>>>>");
        finish();
    }

    public void onCreate(Bundle bundle) {
        this.f3962B = new UiLifecycleHelper(this, this.f3963C);
        this.f3962B.onCreate(bundle);
        this.f3966m = new C1630a();
        super.m5019a(this.f3966m);
        super.onCreate(bundle);
        this.f3965k = new C1703d(this);
        this.f3969z = new LoginButton(this);
        this.f3969z.setUserInfoChangedCallback(new C16133(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f3962B.onDestroy();
        C1216a.m4519a(f3960l, " in onDestroy >>>>>");
    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onPause() {
        super.onPause();
        this.f3962B.onPause();
        AppEventsLogger.deactivateApp(this);
        C1216a.m4519a(f3960l, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        this.f3962B.onResume();
        AppEventsLogger.activateApp(this);
        C1216a.m4522b(f3960l, "sess" + m6075t());
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f3962B.onSaveInstanceState(bundle);
    }

    public void m6077p() {
        if (((C1302b) getApplication()).m4744d().mo1466d()) {
            mo1505o();
        } else {
            m4979b(getString(R.string.no_network));
        }
    }

    public void m6078q() {
        if (m6075t()) {
            m6074s();
            this.f3968o = C1615a.NONE;
            return;
        }
        this.f3969z.callOnClick();
        this.f3968o = C1615a.FEED;
    }
}
