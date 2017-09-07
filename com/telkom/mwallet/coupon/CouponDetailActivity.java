package com.telkom.mwallet.coupon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
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
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1245f;
import com.skcc.wallet.framework.api.http.model.CouponDetail;
import com.skcc.wallet.framework.api.http.model.GetCouponDetailRs;
import com.skcc.wallet.framework.api.http.model.RequestCouponDeleteRs;
import com.skcc.wallet.framework.api.http.model.RequestCouponDownloadRs;
import com.skcc.wallet.framework.api.http.model.RequestCouponRedemptionRs;
import com.skcc.wallet.framework.p062d.C1318b;
import com.telkom.mwallet.R;
import com.telkom.mwallet.TelkomApplication;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.p064a.C1358h.C1357c;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import java.io.IOException;
import java.text.SimpleDateFormat;
import twitter4j.HttpResponseCode;
import twitter4j.MediaEntity.Size;

@SuppressLint({"ParserError", "ParserError"})
public class CouponDetailActivity extends SlidingFrameActivity {
    private static final String f3204n = CouponDetailActivity.class.getSimpleName();
    private static final SimpleDateFormat f3205o = new SimpleDateFormat("yyyyMMddHHmmss");
    private boolean f3206A = false;
    private boolean f3207B = false;
    private C1423a f3208C = C1423a.NONE;
    private LoginButton f3209D;
    private GraphUser f3210E;
    private UiLifecycleHelper f3211F;
    private StatusCallback f3212G = new C14141(this);
    private Callback f3213H = new C14152(this);
    private FragmentManager f3214I;
    private C1298u f3215J;
    private C1318b f3216K;
    private C1459d f3217L;
    private CouponDetail f3218M;
    private C1446b f3219N;
    private OnClickListener f3220O = new C14185(this);
    private C1326f f3221P = new C14196(this);
    private C1326f f3222Q = new C14207(this);
    private C1326f f3223R = new C14218(this);
    private C1326f f3224S = new C14229(this);
    boolean f3225k = false;
    protected C1272r f3226l;
    boolean f3227m = false;
    private final String f3228z = "com.facebook.samples.hellofacebook:PendingAction";

    class C14141 implements StatusCallback {
        final /* synthetic */ CouponDetailActivity f3192a;

        C14141(CouponDetailActivity couponDetailActivity) {
            this.f3192a = couponDetailActivity;
        }

        public void call(Session session, SessionState sessionState, Exception exception) {
            this.f3192a.m5320a(session, sessionState, exception);
            if (this.f3192a.m5316G() && this.f3192a.f3208C == C1423a.FEED) {
                this.f3192a.m5314E();
            }
        }
    }

    class C14152 implements Callback {
        final /* synthetic */ CouponDetailActivity f3193a;

        C14152(CouponDetailActivity couponDetailActivity) {
            this.f3193a = couponDetailActivity;
        }

        public void onComplete(PendingCall pendingCall, Bundle bundle) {
            C1216a.m4519a("HelloFacebook", "Success!");
        }

        public void onError(PendingCall pendingCall, Exception exception, Bundle bundle) {
            C1216a.m4519a("HelloFacebook", String.format("Error: %s", new Object[]{exception.toString()}));
        }
    }

    class C14163 implements UserInfoChangedCallback {
        final /* synthetic */ CouponDetailActivity f3194a;

        C14163(CouponDetailActivity couponDetailActivity) {
            this.f3194a = couponDetailActivity;
        }

        public void onUserInfoFetched(GraphUser graphUser) {
            C1216a.m4522b("Change ", " UserInfoChanged" + this.f3194a.m5316G());
            this.f3194a.f3210E = graphUser;
            C1216a.m4522b("call ", "user " + graphUser);
            if (this.f3194a.m5316G()) {
                this.f3194a.m5314E();
            }
        }
    }

    class C14174 implements OnCompleteListener {
        final /* synthetic */ CouponDetailActivity f3195a;

        C14174(CouponDetailActivity couponDetailActivity) {
            this.f3195a = couponDetailActivity;
        }

        public void onComplete(Bundle bundle, FacebookException facebookException) {
            if (facebookException == null) {
                String string = bundle.getString("post_id");
                if (string != null) {
                    Toast.makeText(this.f3195a.getApplicationContext(), "Posted story, id: " + string, 0).show();
                } else {
                    Toast.makeText(this.f3195a.getApplicationContext(), "Publish cancelled", 0).show();
                }
            } else if (facebookException instanceof FacebookOperationCanceledException) {
                Toast.makeText(this.f3195a.getApplicationContext(), "Publish cancelled", 0).show();
            } else {
                Toast.makeText(this.f3195a.getApplicationContext(), "Error posting story", 0).show();
            }
        }
    }

    class C14185 implements OnClickListener {
        final /* synthetic */ CouponDetailActivity f3196a;

        C14185(CouponDetailActivity couponDetailActivity) {
            this.f3196a = couponDetailActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.activity_coupon_detail_delete_button:
                    this.f3196a.i = this.f3196a.m4977b(this.f3196a.f3223R, R.string.coupon_delete_confirm, true);
                    return;
                case R.id.activity_coupon_detail_save_button:
                    this.f3196a.m5347a(true);
                    return;
                case R.id.activity_coupon_detail_tnc_button:
                    Intent intent = new Intent(this.f3196a, CouponTnCActivity.class);
                    intent.putExtra("coupon_tnc", this.f3196a.f3218M.getTncUrl());
                    this.f3196a.startActivity(intent);
                    return;
                case R.id.activity_coupon_detail_use_button:
                    this.f3196a.f3217L = new C1459d();
                    this.f3196a.f3217L.m5527a(this.f3196a.getApplicationContext());
                    this.f3196a.f3217L.setStyle(0, R.style.tcash_menu_dialog);
                    this.f3196a.f3217L.show(this.f3196a.f3214I, null);
                    return;
                default:
                    return;
            }
        }
    }

    class C14196 implements C1326f {
        final /* synthetic */ CouponDetailActivity f3197a;

        C14196(CouponDetailActivity couponDetailActivity) {
            this.f3197a = couponDetailActivity;
        }

        public void mo1485a() {
            if (this.f3197a.h != null) {
                this.f3197a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C14207 implements C1326f {
        final /* synthetic */ CouponDetailActivity f3198a;

        C14207(CouponDetailActivity couponDetailActivity) {
            this.f3198a = couponDetailActivity;
        }

        public void mo1485a() {
            if (this.f3198a.h != null) {
                this.f3198a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    class C14218 implements C1326f {
        final /* synthetic */ CouponDetailActivity f3199a;

        C14218(CouponDetailActivity couponDetailActivity) {
            this.f3199a = couponDetailActivity;
        }

        public void mo1485a() {
            if (this.f3199a.i != null) {
                this.f3199a.i.dismiss();
            }
            this.f3199a.m5357v();
        }

        public void mo1486b() {
            if (this.f3199a.i != null) {
                this.f3199a.i.dismiss();
            }
        }
    }

    class C14229 implements C1326f {
        final /* synthetic */ CouponDetailActivity f3200a;

        C14229(CouponDetailActivity couponDetailActivity) {
            this.f3200a = couponDetailActivity;
        }

        public void mo1485a() {
            if (this.f3200a.h != null) {
                this.f3200a.h.dismiss();
            }
            if (!this.f3200a.a.m4898i().isEnabled()) {
                this.f3200a.startActivity(new Intent("android.settings.NFC_SETTINGS"));
            } else if (!this.f3200a.a.m4898i().isNdefPushEnabled()) {
                this.f3200a.startActivity(new Intent("android.settings.NFCSHARING_SETTINGS"));
            }
            this.f3200a.finish();
        }

        public void mo1486b() {
        }
    }

    private enum C1423a {
        NONE,
        FEED
    }

    private void m5313D() {
        this.f3214I = getSupportFragmentManager();
        this.f3215J = this.a.m4739a();
        this.f3226l = this.a.m4745e();
        this.f3216K = new C1318b(this.a);
        String stringExtra = getIntent().getStringExtra("CampaignId");
        String stringExtra2 = getIntent().getStringExtra("MerchantId");
        m4972a((Context) this, (int) R.string.loading);
        this.f3215J.m4717d(stringExtra, stringExtra2, this);
    }

    private void m5314E() {
        if (FacebookDialog.canPresentShareDialog(getApplicationContext(), ShareDialogFeature.SHARE_DIALOG)) {
            this.f3211F.trackPendingDialogCall(((ShareDialogBuilder) new ShareDialogBuilder(this).setLink("https://developers.facebook.com/android")).build().present());
            return;
        }
        m5315F();
    }

    private void m5315F() {
        Bundle bundle = new Bundle();
        bundle.putString("name", getString(R.string.app_name_desc));
        bundle.putString("description", getString(R.string.body_message));
        bundle.putString("link", getString(R.string.app_link));
        bundle.putString("picture", getString(R.string.logo_image));
        ((FeedDialogBuilder) new FeedDialogBuilder((Context) this, Session.getActiveSession(), bundle).setOnCompleteListener(new C14174(this))).build().show();
    }

    private boolean m5316G() {
        Session activeSession = Session.getActiveSession();
        boolean z = activeSession != null && activeSession.isOpened();
        C1216a.m4522b(f3204n, "isSessionValid " + z);
        return z;
    }

    private void m5320a(Session session, SessionState sessionState, Exception exception) {
        C1216a.m4522b(f3204n, "onSessionStateChange " + m5316G());
    }

    private void m5322a(String str, String str2, String str3) {
        if (this.f3215J == null) {
            if (this.a == null) {
                this.a = (TelkomApplication) getApplication();
            }
            this.f3215J = this.a.m4739a();
        }
        if (str.isEmpty()) {
            this.h = m4967a(this.f3222Q, (int) R.string.invalid_campaignkey);
            return;
        }
        m4972a((Context) this, (int) R.string.loading);
        this.f3215J.m4696a(this.f3218M.getCampaignId(), this.f3218M.getMerchantId(), this.f3218M.getCouponSerialNo(), this.f3218M.getCouponProfileNo(), str3, this.f3218M.getCouponInstanceId(), str, str2, this);
    }

    public void mo1487a() {
        m4990k();
        if (this.f3206A || this.f3207B) {
            this.f3206A = false;
            this.f3207B = false;
        }
        this.h = m4967a(this.f3221P, (int) R.string.no_network);
    }

    public void mo1488a(String str) {
        m4972a((Context) this, (int) R.string.loading);
    }

    public void mo1489a(String str, int i, String str2, String str3, Object obj) {
        this.f3226l.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if (this.f3206A || this.f3207B) {
            this.f3206A = false;
            this.f3207B = false;
        }
        this.h = m4969a(this.f3221P, "" + str3);
    }

    public void m5345a(String str, ImageView imageView) {
        if (str != null && str.startsWith("http")) {
            this.f3216K.m4808a(str, imageView);
        } else if (str != null) {
            try {
                C1216a.m4522b("imagesub", "image:  ");
                imageView.setImageDrawable(Drawable.createFromStream(getAssets().open(str), null));
            } catch (IOException e) {
            }
        }
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a(f3204n, "onSuccessNetwork");
        this.f3226l.m4647a("time for update", System.currentTimeMillis());
        m4990k();
        if ("requestCouponDownload".equalsIgnoreCase(str)) {
            RequestCouponDownloadRs requestCouponDownloadRs = (RequestCouponDownloadRs) obj;
            this.f3218M.setCouponInstanceId(requestCouponDownloadRs.getCouponInstanceId());
            this.f3218M.setCouponSerialNo(requestCouponDownloadRs.getCouponSerialNo());
            this.f3218M.setExpiryDate(requestCouponDownloadRs.getExpiryDate());
            this.f3218M.setCouponUserStatus(C1357c.f2925a);
            this.f3219N.m5483e();
            if (this.f3225k) {
                this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_coupon_saved);
                this.h.m5651a(this.f3221P);
                this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            }
            this.f3226l.m4647a(C1358h.f2937h, System.currentTimeMillis());
            this.f3226l.m4648a(C1358h.f2936g, "" + String.valueOf(requestCouponDownloadRs.getCount()));
            m5026i("" + requestCouponDownloadRs.getCount());
            if (this.f3206A) {
                m5355t();
            }
            if (this.f3207B) {
                m5356u();
            }
        } else if ("getCouponDetail".equalsIgnoreCase(str)) {
            this.f3218M = ((GetCouponDetailRs) obj).getCoupon();
            this.f3219N.m5481a(this.f3218M);
        } else if ("requestCouponDelete".equalsIgnoreCase(str)) {
            RequestCouponDeleteRs requestCouponDeleteRs = (RequestCouponDeleteRs) obj;
            this.f3218M.setCouponUserStatus(C1357c.f2927c);
            this.f3219N.m5484f();
            this.f3226l.m4647a(C1358h.f2937h, System.currentTimeMillis());
            this.f3226l.m4648a(C1358h.f2936g, String.valueOf(requestCouponDeleteRs.getCount()));
            m5026i(String.valueOf(requestCouponDeleteRs.getCount()));
        } else if ("requestCouponRedemption".equalsIgnoreCase(str)) {
            this.f3218M.setCouponSerialNo(((RequestCouponRedemptionRs) obj).getCouponSerialNo());
            this.f3218M.setCouponUserStatus(C1357c.f2926b);
            this.h = C1514b.m5648a((int) R.string.title_success, (int) R.string.msg_coupon_redeemed);
            this.h.m5651a(this.f3221P);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            this.f3219N.m5485g();
            m5015A();
        }
    }

    void m5347a(boolean z) {
        m4972a((Context) this, (int) R.string.loading);
        this.f3225k = z;
        this.f3215J.m4690a(this.f3218M.getCampaignId(), this.f3218M.getMerchantId(), this.f3218M.getCouponProfileNo(), (C1245f) this);
    }

    public void mo1491b() {
        m4990k();
        if (this.f3206A || this.f3207B) {
            this.f3206A = false;
            this.f3207B = false;
        }
        this.h = m4967a(this.f3221P, (int) R.string.no_response);
    }

    public void mo1492c() {
        m4990k();
        if (this.f3206A || this.f3207B) {
            this.f3206A = false;
            this.f3207B = false;
        }
        m4989j();
    }

    void mo1505o() {
        if (this.f3219N.m5488j()) {
            m5347a(false);
        }
        startActivityForResult(new Intent(this, CouponRedeemPINActivity.class), 3);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C1216a.m4522b(f3204n, "coupon detail " + i);
        String stringExtra;
        String stringExtra2;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    stringExtra = intent.getStringExtra("SCAN_RESULT");
                    stringExtra2 = intent.getStringExtra("SCAN_RESULT_FORMAT");
                    if (stringExtra.length() != 21) {
                        this.h = m4967a(this.f3221P, (int) R.string.msg_invalid_code);
                        return;
                    }
                    Toast makeText = Toast.makeText(this, "Content:" + stringExtra + " Format:" + stringExtra2, 1);
                    makeText.setGravity(48, 25, HttpResponseCode.BAD_REQUEST);
                    makeText.show();
                    String substring = stringExtra.substring(0, 6);
                    String substring2 = stringExtra.substring(6, 15);
                    stringExtra = stringExtra.substring(15);
                    if (substring2.equals(this.f3218M.getCampaignId())) {
                        C1216a.m4522b(f3204n, "coupon couponCampaignKey " + substring);
                        m5322a(substring, stringExtra, stringExtra2);
                        return;
                    }
                    this.h = m4967a(this.f3221P, (int) R.string.msg_invalid_campaign);
                    return;
                } else if (i2 == 0) {
                    Toast makeText2 = Toast.makeText(this, "Scan was Cancelled!", 1);
                    makeText2.setGravity(48, 25, HttpResponseCode.BAD_REQUEST);
                    makeText2.show();
                    return;
                } else {
                    return;
                }
            case 2:
                if (i2 == -1) {
                    if (intent.getIntExtra("LastCalledMenu", 0) != 3) {
                        stringExtra = intent.getStringExtra("CAMPAIGNKEY");
                        stringExtra2 = intent.getStringExtra("BRANCHID");
                        C1216a.m4522b(f3204n, "coupon couponCampaignKey " + stringExtra);
                        m5322a(stringExtra, stringExtra2, "nfc");
                        break;
                    }
                    stringExtra = this.f3218M.getCouponCampaignKey();
                    stringExtra2 = intent.getStringExtra("BRANCHID");
                    C1216a.m4522b(f3204n, "coupon couponCampaignKey " + stringExtra);
                    m5322a(stringExtra, stringExtra2, "pin");
                    break;
                }
                break;
            case 3:
                C1216a.m4522b(f3204n, "coupon resultCode " + i2);
                if (i2 == -1) {
                    stringExtra = this.f3218M.getCouponCampaignKey();
                    stringExtra2 = intent.getStringExtra("BRANCHID");
                    C1216a.m4522b(f3204n, "coupon couponCampaignKey " + stringExtra);
                    m5322a(stringExtra, stringExtra2, "pin");
                    return;
                }
                return;
        }
        this.f3211F.onActivityResult(i, i2, intent, this.f3213H);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.f3211F = new UiLifecycleHelper(this, this.f3212G);
        this.f3211F.onCreate(bundle);
        this.f3219N = new C1446b();
        super.m5019a(this.f3219N);
        super.onCreate(bundle);
        m5313D();
        if ("Y".equals(this.f3226l.m4651b("is_nfc_yn", "N"))) {
            this.f3227m = true;
        } else {
            this.f3227m = false;
        }
        C1216a.m4522b("nfccheck ", "nfc check " + this.f3227m);
        this.f3209D = new LoginButton(this);
        this.f3209D.setUserInfoChangedCallback(new C14163(this));
    }

    protected void onDestroy() {
        this.f3216K.m4807a();
        super.onDestroy();
        this.f3211F.onDestroy();
        C1216a.m4519a(f3204n, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        this.f3211F.onPause();
        AppEventsLogger.deactivateApp(this);
        C1216a.m4519a(f3204n, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        this.f3211F.onResume();
        AppEventsLogger.activateApp(this);
        if (this.f3206A) {
            this.f3206A = false;
            Intent intent = new Intent(this, CouponListActivity.class);
            intent.putExtra("COUPON_LIST_MODE", Size.CROP);
            intent.setFlags(603979776);
            startActivity(intent);
            finish();
        }
        C1216a.m4522b(f3204n, "sess" + m5316G());
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f3211F.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    void m5351p() {
        if (this.f3219N.m5488j()) {
            m5347a(false);
        }
        startActivity(new Intent(this, CouponRedeemQRActivity.class));
    }

    void m5352q() {
        if (this.a.m4898i() != null) {
            if (!this.a.m4898i().isEnabled()) {
                this.h = m4968a(this.f3224S, (int) R.string.nfc_turned_off, false);
                return;
            } else if (VERSION.SDK_INT >= 16 && !this.a.m4898i().isNdefPushEnabled()) {
                this.h = m4968a(this.f3224S, (int) R.string.nfc_turned_off, false);
                return;
            }
        }
        if (this.f3219N.m5488j()) {
            m5347a(false);
        }
        Intent intent = new Intent(this, CouponRedeemNFCActivity.class);
        intent.putExtra("CampaignId", this.f3218M.getCampaignId());
        intent.putExtra("PIN_REDEEM", this.f3218M.getPinRedemptionYn());
        startActivityForResult(intent, 2);
    }

    void m5353r() {
        this.f3206A = true;
        if (this.f3218M.getCouponSerialNo() == null) {
            m5347a(false);
        } else if (this.f3206A) {
            m5355t();
        }
    }

    public void m5354s() {
        this.f3207B = true;
        if (this.f3219N.m5488j()) {
            m5347a(false);
        } else {
            m5356u();
        }
    }

    void m5355t() {
        String str = "*654*9*" + this.f3218M.getCouponSerialNo() + "*" + this.f3218M.getCampaignId() + "%23";
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + str));
        startActivity(intent);
    }

    void m5356u() {
        this.f3207B = false;
        Intent intent = new Intent(this, CouponBarcodeActivity.class);
        intent.putExtra("COUPON_SERIAL", this.f3218M.getCouponSerialNo());
        intent.putExtra("coupon_codetype", this.f3218M.getBarcodeType());
        intent.putExtra("PIN_REDEEM", this.f3218M.getPinRedemptionYn());
        startActivityForResult(intent, 2);
    }

    protected void m5357v() {
        m4972a((Context) this, (int) R.string.loading);
        this.f3215J.m4713c(this.f3218M.getCampaignId(), this.f3218M.getMerchantId(), this.f3218M.getCouponProfileNo(), this.f3218M.getCouponSerialNo(), this.f3218M.getCouponInstanceId(), this);
    }

    public void m5358w() {
        this.i = m4977b(this.f3223R, R.string.coupon_delete_confirm, true);
    }

    public void m5359x() {
        if (m5316G()) {
            m5315F();
            this.f3208C = C1423a.NONE;
            return;
        }
        this.f3209D.callOnClick();
        this.f3208C = C1423a.FEED;
    }
}
