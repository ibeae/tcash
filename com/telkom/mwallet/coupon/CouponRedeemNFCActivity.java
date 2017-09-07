package com.telkom.mwallet.coupon;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.tech.NfcF;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class CouponRedeemNFCActivity extends SlidingFrameActivity {
    private static final String f3254k = CouponRedeemNFCActivity.class.getSimpleName();
    private C1462e f3255A;
    private C1326f f3256B = new C14291(this);
    private String f3257l = null;
    private NfcAdapter f3258m;
    private PendingIntent f3259n;
    private IntentFilter[] f3260o;
    private String[][] f3261z;

    class C14291 implements C1326f {
        final /* synthetic */ CouponRedeemNFCActivity f3253a;

        C14291(CouponRedeemNFCActivity couponRedeemNFCActivity) {
            this.f3253a = couponRedeemNFCActivity;
        }

        public void mo1485a() {
            if (this.f3253a.h != null) {
                this.f3253a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    private void m5396a(Intent intent) {
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
        if (parcelableArrayExtra != null && parcelableArrayExtra != null) {
            NdefMessage[] ndefMessageArr = new NdefMessage[parcelableArrayExtra.length];
            for (int i = 0; i < parcelableArrayExtra.length; i++) {
                ndefMessageArr[i] = (NdefMessage) parcelableArrayExtra[i];
                m5397a(ndefMessageArr[i]);
            }
        }
    }

    private void m5397a(NdefMessage ndefMessage) {
        for (NdefRecord ndefRecord : ndefMessage.getRecords()) {
            byte[] payload = ndefRecord.getPayload();
            String str = new String(ndefRecord.getType());
            Toast.makeText(this, new String(payload), 1).show();
            if (payload.length != 24) {
                C1216a.m4519a(f3254k, "invalid NFC");
                return;
            }
            if (str.equalsIgnoreCase("T")) {
                C1216a.m4519a(f3254k, "processNfc");
                this.f3257l = new String(payload, 3, 21);
                String substring = this.f3257l.substring(0, 6);
                String substring2 = this.f3257l.substring(6, 15);
                str = this.f3257l.substring(15);
                if (getIntent().getStringExtra("CampaignId").equals(substring2)) {
                    Toast.makeText(this, "campaignKey: " + substring + "\ncampaignId: " + substring2 + "\nbranchId: " + str, 1).show();
                    m5398a(substring, str);
                } else {
                    this.h = m4967a(this.f3256B, (int) R.string.msg_invalid_campaign);
                }
            }
        }
    }

    private void m5398a(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("CAMPAIGNKEY", str);
        intent.putExtra("BRANCHID", str2);
        setResult(-1, intent);
        finish();
    }

    private void m5400o() {
        this.f3258m = NfcAdapter.getDefaultAdapter(this);
        Intent intent = new Intent(this, CouponRedeemNFCActivity.class);
        intent.setFlags(536870912);
        this.f3259n = PendingIntent.getActivity(this, 0, intent, 0);
        try {
            new IntentFilter("android.nfc.action.NDEF_DISCOVERED").addDataType("*/*");
            this.f3260o = new IntentFilter[]{new IntentFilter("android.nfc.action.NDEF_DISCOVERED")};
            String[][] strArr = new String[1][];
            strArr[0] = new String[]{NfcF.class.getName()};
            this.f3261z = strArr;
            intent = getIntent();
            if (intent != null) {
                if ("android.nfc.action.TAG_DISCOVERED".equals(intent.getAction())) {
                    m5396a(intent);
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException("fail", e);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 3:
                    intent.putExtra("LastCalledMenu", 3);
                    setResult(-1, intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        this.f3255A = new C1462e();
        super.m5019a(this.f3255A);
        super.onCreate(bundle);
        m5400o();
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            m5396a(intent);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.f3258m != null) {
            this.f3258m.disableForegroundDispatch(this);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.f3258m != null) {
            this.f3258m.enableForegroundDispatch(this, this.f3259n, this.f3260o, this.f3261z);
        }
    }
}
