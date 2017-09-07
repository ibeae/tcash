package com.telkom.mwallet.tcash.tap.p072b;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.C0136d;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.TelkomApplication;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.C1518d.C1517c;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.home.C1385b;
import com.telkom.mwallet.p064a.C1350d;
import com.telkom.mwallet.tcash.tap.ActivationActivity;
import com.telkom.mwallet.tcash.tap.p071a.C1975a.C1974a;
import com.telkom.mwallet.tcash.tap.p071a.C1976b;
import com.telkom.mwallet.tcash.tap.p071a.C1977c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import twitter4j.MediaEntity.Size;

public class C2004d extends C1385b {
    private static final String f5809a = C2004d.class.getSimpleName();
    private C0136d f5810b;
    private ImageButton f5811c;
    private TextView f5812j;
    private TextView f5813k;
    private C1977c f5814l;
    private SimpleOnGestureListener f5815m = new C20028(this);

    class C19951 implements OnTouchListener {
        final /* synthetic */ C2004d f5795a;

        C19951(C2004d c2004d) {
            this.f5795a = c2004d;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f5795a.f5810b == null) {
                this.f5795a.f5810b = new C0136d(this.f5795a.getActivity(), this.f5795a.f5815m);
            }
            return this.f5795a.f5810b.m448a(motionEvent);
        }
    }

    class C19962 implements Runnable {
        final /* synthetic */ C2004d f5796a;

        C19962(C2004d c2004d) {
            this.f5796a = c2004d;
        }

        public void run() {
            switch (this.f5796a.f5814l.m7898a()) {
                case STICKER:
                    this.f5796a.m7993e();
                    return;
                case NFC:
                    this.f5796a.m7995f();
                    return;
                default:
                    this.f5796a.m7991d();
                    return;
            }
        }
    }

    class C20028 extends SimpleOnGestureListener {
        final /* synthetic */ C2004d f5807a;

        C20028(C2004d c2004d) {
            this.f5807a = c2004d;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            int i = 102;
            C1974a a = this.f5807a.f5814l.m7898a();
            if (C1974a.STICKER == a) {
                if (this.f5807a.m8003j()) {
                    Intent intent;
                    if (!this.f5807a.m7999h()) {
                        intent = new Intent("android.settings.NFC_SETTINGS");
                    } else if (this.f5807a.m8002i()) {
                        intent = new Intent(this.f5807a.getActivity(), ActivationActivity.class);
                        intent.putExtra("extra_activation", 2);
                        intent.setFlags(536870912);
                        i = 100;
                    } else {
                        intent = new Intent("android.settings.NFCSHARING_SETTINGS");
                    }
                    this.f5807a.startActivityForResult(intent, i);
                } else {
                    this.f5807a.m8011s();
                }
            } else if (C1974a.NFC == a) {
                this.f5807a.m8012t();
            }
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (C1974a.NONE != this.f5807a.f5814l.m7898a()) {
                this.f5807a.m8009q();
            } else if (this.f5807a.m8003j()) {
                this.f5807a.m8010r();
            } else {
                Intent intent = new Intent(this.f5807a.getActivity(), ActivationActivity.class);
                intent.putExtra("extra_activation", 1);
                intent.setFlags(536870912);
                this.f5807a.startActivityForResult(intent, 100);
            }
            return true;
        }
    }

    private SpannableString m7986a(Pattern pattern, String str) {
        SpannableString spannableString = new SpannableString(str);
        int color = getResources().getColor(R.color.black);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            spannableString.setSpan(new ForegroundColorSpan(color), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }

    private String m7987a(boolean z, String str) {
        if (!z) {
            return getString(R.string.tcash_tap_state_disabled);
        }
        return String.format(getString(R.string.tcash_tap_state_enabled), new Object[]{str});
    }

    private String m7989b(boolean z, String str) {
        if (!z) {
            return getString(R.string.tcash_tap_info_disabled);
        }
        return String.format(getString(R.string.tcash_tap_info_enabled), new Object[]{str});
    }

    private void m7991d() {
        this.f5811c.setImageResource(R.drawable.img_tcashtap_off);
        this.f5812j.setText(m7986a(Pattern.compile(getString(R.string.tcash_tap_state_pattern)), m7987a(false, null)));
        this.f5813k.setText(m7986a(Pattern.compile(getString(R.string.tcash_tap_info_pattern)), m7989b(false, null)));
    }

    private void m7993e() {
        this.f5811c.setImageResource(R.drawable.img_tcashtap_on);
        this.f5812j.setText(m7986a(Pattern.compile(getString(R.string.tcash_tap_state_pattern)), m7987a(true, getString(R.string.tcash_tap_tcash_sticker))));
        this.f5813k.setText(m7986a(Pattern.compile(getString(R.string.tcash_tap_info_pattern)), m7989b(true, getString(R.string.tcash_tap_nfc_phone))));
    }

    private void m7995f() {
        if (m8003j()) {
            this.f5811c.setImageResource(R.drawable.img_tcashtap_on);
            this.f5812j.setText(m7986a(Pattern.compile(getString(R.string.tcash_tap_state_pattern)), m7987a(true, getString(R.string.tcash_tap_nfc_phone))));
            this.f5813k.setText(m7986a(Pattern.compile(getString(R.string.tcash_tap_info_pattern)), m7989b(true, getString(R.string.tcash_tap_sticker))));
            return;
        }
        m8008p();
    }

    private NfcAdapter m7997g() {
        return ((TelkomApplication) getActivity().getApplication()).m4898i();
    }

    private boolean m7999h() {
        return m7997g().isEnabled();
    }

    private boolean m8002i() {
        return m7997g().isNdefPushEnabled();
    }

    private boolean m8003j() {
        return m7997g() != null;
    }

    private void m8008p() {
        final C1514b a = C1514b.m5647a((int) R.string.tcash_tap_popup_nfc_to_non_nfc);
        a.setCancelable(false);
        a.m5651a(new C1326f(this) {
            final /* synthetic */ C2004d f5798b;

            public void mo1485a() {
                a.dismiss();
                Intent intent = new Intent(this.f5798b.getActivity(), ActivationActivity.class);
                intent.putExtra("extra_activation", 1);
                intent.setFlags(536870912);
                this.f5798b.startActivityForResult(intent, 100);
            }

            public void mo1486b() {
                a.dismiss();
            }
        });
        a.show(m5215l(), "notice_dialog_tag");
    }

    private void m8009q() {
        final C1517c a = C1517c.m5654a((int) R.string.tcash_tap_popup_deactivation_alert);
        a.m5657b(R.string.btn_yes);
        a.m5658c(R.string.btn_no);
        a.m5656a(new C1326f(this) {
            final /* synthetic */ C2004d f5800b;

            public void mo1485a() {
                a.dismiss();
                int i = C1974a.STICKER == this.f5800b.f5814l.m7898a() ? 3 : 4;
                Intent intent = new Intent(this.f5800b.getActivity(), ActivationActivity.class);
                intent.putExtra("extra_activation", i);
                intent.setFlags(536870912);
                this.f5800b.startActivityForResult(intent, Size.CROP);
            }

            public void mo1486b() {
                a.dismiss();
            }
        });
        a.show(m5215l(), "notice_dialog_tag");
    }

    private void m8010r() {
        final C1517c a = C1517c.m5654a((int) R.string.tcash_tap_popup_activation_nfc);
        a.m5657b(R.string.btn_yes);
        a.m5658c(R.string.btn_no);
        a.m5656a(new C1326f(this) {
            final /* synthetic */ C2004d f5802b;

            public void mo1485a() {
                Intent intent;
                int i = 102;
                a.dismiss();
                if (!this.f5802b.m7999h()) {
                    intent = new Intent("android.settings.NFC_SETTINGS");
                } else if (this.f5802b.m8002i()) {
                    intent = new Intent(this.f5802b.getActivity(), ActivationActivity.class);
                    intent.putExtra("extra_activation", 2);
                    intent.setFlags(536870912);
                    i = 100;
                } else {
                    intent = new Intent("android.settings.NFCSHARING_SETTINGS");
                }
                this.f5802b.startActivityForResult(intent, i);
            }

            public void mo1486b() {
                a.dismiss();
                Intent intent = new Intent(this.f5802b.getActivity(), ActivationActivity.class);
                intent.putExtra("extra_activation", 1);
                intent.setFlags(536870912);
                this.f5802b.startActivityForResult(intent, 100);
            }
        });
        a.show(m5215l(), "notice_dialog_tag");
    }

    private void m8011s() {
        final C1514b a = C1514b.m5647a((int) R.string.tcash_tap_popup_cannot_change_to_nfc);
        a.m5651a(new C1326f(this) {
            final /* synthetic */ C2004d f5804b;

            public void mo1485a() {
                a.dismiss();
            }

            public void mo1486b() {
                a.dismiss();
            }
        });
        a.show(m5215l(), "notice_dialog_tag");
    }

    private void m8012t() {
        final C1517c a = C1517c.m5654a((int) R.string.tcash_tap_popup_change_sticker_to_nfc);
        a.m5657b(R.string.btn_yes);
        a.m5658c(R.string.btn_no);
        a.m5656a(new C1326f(this) {
            final /* synthetic */ C2004d f5806b;

            public void mo1485a() {
                a.dismiss();
                Intent intent = new Intent(this.f5806b.getActivity(), ActivationActivity.class);
                intent.putExtra("extra_activation", 1);
                intent.setFlags(536870912);
                this.f5806b.startActivityForResult(intent, 100);
            }

            public void mo1486b() {
                a.dismiss();
            }
        });
        a.show(m5215l(), "notice_dialog_tag");
    }

    public void m8013a(C1977c c1977c) {
        this.f5814l = c1977c;
        new Handler().post(new C19962(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 100:
            case Size.CROP /*101*/:
                if (-1 == i2) {
                    m8013a(new C1976b(getActivity()).m7894a());
                    return;
                } else {
                    m8013a(this.f5814l);
                    return;
                }
            case 102:
                if (m8003j() && m7999h() && m8002i()) {
                    Intent intent2 = new Intent(getActivity(), ActivationActivity.class);
                    intent2.putExtra("extra_activation", 2);
                    intent2.setFlags(536870912);
                    startActivityForResult(intent2, 100);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_tap, null);
        C1350d.m4929a().m4933a(getActivity(), (ViewGroup) inflate);
        this.f5811c = (ImageButton) inflate.findViewById(R.id.tcash_tap_image_button);
        this.f5811c.setOnTouchListener(new C19951(this));
        this.f5812j = (TextView) inflate.findViewById(R.id.tcash_tap_state_text);
        this.f5813k = (TextView) inflate.findViewById(R.id.tcash_tap_info_text);
        m5208c(R.string.tcash_tap);
        m7991d();
        return inflate;
    }
}
