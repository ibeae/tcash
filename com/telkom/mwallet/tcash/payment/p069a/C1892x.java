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
import com.telkom.mwallet.tcash.payment.TCashPaymentTemplateActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;
import java.util.List;

public class C1892x extends C1872q {
    private static final String f5317b = C1892x.class.getSimpleName();
    private static View f5318q = null;
    TCashPaymentTemplateActivity f5319a;
    private Button f5320c;
    private Button f5321j;
    private Button f5322k;
    private EditText f5323l;
    private TextView f5324m;
    private Random2of6PinEditView f5325n;
    private List<Region> f5326o = null;
    private Region f5327p = null;
    private C1536i f5328r;
    private String f5329s;
    private OnTouchListener f5330t = new C18891(this);
    private OnClickListener f5331u = new C18902(this);
    private C1499h f5332v = new C18913(this);

    class C18891 implements OnTouchListener {
        final /* synthetic */ C1892x f5314a;

        C18891(C1892x c1892x) {
            this.f5314a = c1892x;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f5314a.f5326o == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                C1892x.f5318q = view;
                return false;
            } else if (motionEvent.getAction() != 1) {
                return false;
            } else {
                if (view.equals(C1892x.f5318q)) {
                    switch (view.getId()) {
                        case R.id.tcash_pdam_area:
                        case R.id.tcash_pdam_area_picker_button:
                            if (this.f5314a.f5326o != null) {
                                this.f5314a.f5328r = C1536i.m5680a((int) R.string.choose_area);
                                this.f5314a.f5328r.m5684a(this.f5314a.f5332v);
                                this.f5314a.f5328r.m5685a(this.f5314a.f5326o);
                                this.f5314a.f5328r.show(this.f5314a.getFragmentManager(), "list_dialog_tag");
                                break;
                            }
                            return false;
                    }
                }
                C1892x.f5318q = null;
                return true;
            }
        }
    }

    class C18902 implements OnClickListener {
        final /* synthetic */ C1892x f5315a;

        C18902(C1892x c1892x) {
            this.f5315a = c1892x;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5315a.m7448f() && this.f5315a.f5325n.m8024c()) {
                        this.f5315a.f5319a.m7178g(this.f5315a.f5323l.getText().toString());
                        this.f5315a.f5319a.m7179j(this.f5315a.f5325n.getPin());
                        this.f5315a.f5319a.m7167a(this.f5315a.f5327p);
                        this.f5315a.f5319a.m7172a(this.f5315a.getString(R.string.payment_noti_padm_msg), this.f5315a.getString(R.string.pdam_id_no));
                        this.f5315a.f5319a.m7184q();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5315a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    class C18913 implements C1499h {
        final /* synthetic */ C1892x f5316a;

        C18913(C1892x c1892x) {
            this.f5316a = c1892x;
        }

        public void mo1552a(Region region) {
            this.f5316a.f5327p = region;
            this.f5316a.f5320c.setText(region.getRegionName());
            this.f5316a.f5320c.setLines(this.f5316a.f5320c.getLineCount());
            if (this.f5316a.f5328r != null) {
                this.f5316a.f5328r.dismiss();
            }
            this.f5316a.f5320c.focusSearch(130).requestFocus();
        }
    }

    private void m7442c(View view) {
        this.f5320c = (Button) view.findViewById(R.id.tcash_pdam_area);
        this.f5321j = (Button) view.findViewById(R.id.tcash_pdam_area_picker_button);
        this.f5322k = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5323l = (EditText) view.findViewById(R.id.tcash_payment_id_number);
        this.f5324m = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5325n = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5325n.getPinViews());
        this.f5322k.setText(R.string.btn_next);
        this.f5320c.setOnTouchListener(this.f5330t);
        this.f5321j.setOnTouchListener(this.f5330t);
        this.f5322k.setOnClickListener(this.f5331u);
        this.f5324m.setOnClickListener(this.f5331u);
        mo1558a(this.f5327p);
        mo1554b(this.f5329s);
        this.f5323l.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m7446e() {
        this.f5325n.m8023b();
        this.f5320c.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5323l.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7448f() {
        m7446e();
        if (this.f5326o == null || "".equals(this.f5320c.getText().toString().trim())) {
            this.f5320c.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f5323l.getText().toString().trim())) {
            return true;
        } else {
            this.f5323l.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    public void mo1558a(Region region) {
        this.f5327p = region;
        if (this.f5320c != null && region != null) {
            this.f5332v.mo1552a(region);
        }
    }

    public void mo1554b(String str) {
        this.f5329s = str;
        if (this.f5323l != null) {
            this.f5323l.setText(str);
        }
    }

    public void mo1559b(List<Region> list) {
        this.f5326o = list;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5319a = (TCashPaymentTemplateActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_template_first_7, null);
        m5202a((ViewGroup) inflate);
        m7442c(inflate);
        return inflate;
    }
}
