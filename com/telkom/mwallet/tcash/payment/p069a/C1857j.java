package com.telkom.mwallet.tcash.payment.p069a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.Region;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1536i;
import com.telkom.mwallet.dialog.p063a.C1499h;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.payment.TCashPDAMActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;
import java.util.List;

public class C1857j extends C1386e {
    private static final String f5130b = C1857j.class.getSimpleName();
    private static View f5131q = null;
    TCashPDAMActivity f5132a;
    private Button f5133c;
    private Button f5134j;
    private Button f5135k;
    private EditText f5136l;
    private TextView f5137m;
    private Random2of6PinEditView f5138n;
    private List<Region> f5139o = null;
    private Region f5140p = null;
    private C1536i f5141r;
    private String f5142s;
    private OnTouchListener f5143t = new C18541(this);
    private OnClickListener f5144u = new C18552(this);
    private C1499h f5145v = new C18563(this);

    class C18541 implements OnTouchListener {
        final /* synthetic */ C1857j f5127a;

        C18541(C1857j c1857j) {
            this.f5127a = c1857j;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f5127a.f5139o == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                C1857j.f5131q = view;
                return false;
            } else if (motionEvent.getAction() != 1) {
                return false;
            } else {
                if (view.equals(C1857j.f5131q)) {
                    switch (view.getId()) {
                        case R.id.tcash_pdam_area:
                        case R.id.tcash_pdam_area_picker_button:
                            if (this.f5127a.f5139o != null) {
                                this.f5127a.f5141r = C1536i.m5680a((int) R.string.choose_area);
                                this.f5127a.f5141r.m5684a(this.f5127a.f5145v);
                                this.f5127a.f5141r.m5685a(this.f5127a.f5139o);
                                this.f5127a.f5141r.show(this.f5127a.getFragmentManager(), "list_dialog_tag");
                                break;
                            }
                            return false;
                    }
                }
                C1857j.f5131q = null;
                return true;
            }
        }
    }

    class C18552 implements OnClickListener {
        final /* synthetic */ C1857j f5128a;

        C18552(C1857j c1857j) {
            this.f5128a = c1857j;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5128a.m7275f() && this.f5128a.f5138n.m8024c()) {
                        this.f5128a.f5132a.m7101f(this.f5128a.f5136l.getText().toString());
                        this.f5128a.f5132a.m7102g(this.f5128a.f5138n.getPin());
                        this.f5128a.f5132a.m7094a(this.f5128a.f5140p);
                        this.f5128a.f5132a.m7104p();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5128a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    class C18563 implements C1499h {
        final /* synthetic */ C1857j f5129a;

        C18563(C1857j c1857j) {
            this.f5129a = c1857j;
        }

        public void mo1552a(Region region) {
            this.f5129a.f5140p = region;
            this.f5129a.f5133c.setText(region.getRegionName());
            this.f5129a.f5133c.setLines(this.f5129a.f5133c.getLineCount());
            if (this.f5129a.f5141r != null) {
                this.f5129a.f5141r.dismiss();
            }
            this.f5129a.f5133c.focusSearch(130).requestFocus();
        }
    }

    private void m7269c(View view) {
        this.f5133c = (Button) view.findViewById(R.id.tcash_pdam_area);
        this.f5134j = (Button) view.findViewById(R.id.tcash_pdam_area_picker_button);
        this.f5135k = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5136l = (EditText) view.findViewById(R.id.tcash_payment_id_number);
        this.f5137m = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5138n = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5138n.getPinViews());
        this.f5135k.setText(R.string.btn_next);
        this.f5133c.setOnTouchListener(this.f5143t);
        this.f5134j.setOnTouchListener(this.f5143t);
        this.f5135k.setOnClickListener(this.f5144u);
        this.f5137m.setOnClickListener(this.f5144u);
        m7279a(this.f5140p);
        m7281b(this.f5142s);
    }

    private void m7273e() {
        this.f5138n.m8023b();
        this.f5133c.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5136l.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7275f() {
        m7273e();
        if (this.f5139o == null || "".equals(this.f5133c.getText().toString().trim())) {
            this.f5133c.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f5136l.getText().toString().trim())) {
            return true;
        } else {
            this.f5136l.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    public void m7279a(Region region) {
        this.f5140p = region;
        if (this.f5133c != null && region != null) {
            this.f5145v.mo1552a(region);
        }
    }

    public void m7280a(List<Region> list) {
        this.f5139o = list;
    }

    public void m7281b(String str) {
        this.f5142s = str;
        if (this.f5136l != null) {
            this.f5136l.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5132a = (TCashPDAMActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_pdam_first, null);
        m5202a((ViewGroup) inflate);
        m7269c(inflate);
        return inflate;
    }
}
