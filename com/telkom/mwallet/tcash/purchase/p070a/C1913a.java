package com.telkom.mwallet.tcash.purchase.p070a;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.tcash.purchase.TCashMerchantActivty;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1913a extends C1386e {
    private static final String f5453b = C1913a.class.getSimpleName();
    TCashMerchantActivty f5454a;
    private Button f5455c;
    private EditText f5456j;
    private EditText f5457k;
    private TextView f5458l;
    private Random2of6PinEditView f5459m;
    private ScrollView f5460n;
    private String f5461o;
    private String f5462p;
    private OnClickListener f5463q = new C19124(this);

    class C19081 implements OnTouchListener {
        final /* synthetic */ C1913a f5448a;

        class C19071 implements Runnable {
            final /* synthetic */ C19081 f5447a;

            C19071(C19081 c19081) {
                this.f5447a = c19081;
            }

            public void run() {
                this.f5447a.f5448a.f5456j.requestFocus();
            }
        }

        C19081(C1913a c1913a) {
            this.f5448a = c1913a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f5448a.f5460n.smoothScrollTo(0, this.f5448a.f5456j.getTop());
            this.f5448a.f5460n.post(new C19071(this));
            return false;
        }
    }

    class C19102 implements OnTouchListener {
        final /* synthetic */ C1913a f5450a;

        class C19091 implements Runnable {
            final /* synthetic */ C19102 f5449a;

            C19091(C19102 c19102) {
                this.f5449a = c19102;
            }

            public void run() {
                this.f5449a.f5450a.f5457k.requestFocus();
            }
        }

        C19102(C1913a c1913a) {
            this.f5450a = c1913a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f5450a.f5460n.smoothScrollTo(0, this.f5450a.f5457k.getTop());
            this.f5450a.f5460n.post(new C19091(this));
            return false;
        }
    }

    class C19113 implements OnKeyListener {
        final /* synthetic */ C1913a f5451a;

        C19113(C1913a c1913a) {
            this.f5451a = c1913a;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i != 66) {
                return false;
            }
            this.f5451a.f5459m.m8022a();
            return true;
        }
    }

    class C19124 implements OnClickListener {
        final /* synthetic */ C1913a f5452a;

        C19124(C1913a c1913a) {
            this.f5452a = c1913a;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_confirm_button:
                    if (this.f5452a.m7605g() && this.f5452a.f5459m.m8024c()) {
                        this.f5452a.f5454a.m7502g(this.f5452a.f5459m.getPin());
                        this.f5452a.f5454a.m7500e(this.f5452a.f5456j.getText().toString());
                        this.f5452a.f5454a.m7501f(this.f5452a.f5457k.getText().toString());
                        this.f5452a.f5454a.m7505p();
                        return;
                    }
                    return;
                case R.id.tcash_forget_pin_button:
                    this.f5452a.m5219p();
                    return;
                default:
                    return;
            }
        }
    }

    private void m7599b(View view) {
        this.f5460n = (ScrollView) view.findViewById(R.id.tcash_scroll);
        this.f5455c = (Button) view.findViewById(R.id.tcash_confirm_button);
        this.f5456j = (EditText) view.findViewById(R.id.tcash_purchase_id_number_edit);
        this.f5457k = (EditText) view.findViewById(R.id.tcash_amount_edittext);
        this.f5458l = (TextView) view.findViewById(R.id.tcash_forget_pin_button);
        this.f5459m = (Random2of6PinEditView) view.findViewById(R.id.pin_edit_view);
        C1347a.m4910a().m4912a(this.f5459m.getPinViews());
        this.f5455c.setText(R.string.btn_next);
        this.f5455c.setOnClickListener(this.f5463q);
        this.f5458l.setOnClickListener(this.f5463q);
        m7606b(this.f5461o);
        m7607c(this.f5462p);
        this.f5456j.requestFocus();
        getActivity().getWindow().setSoftInputMode(16);
        m7608d();
        m7609e();
    }

    private void m7603f() {
        this.f5459m.m8023b();
        this.f5456j.setBackgroundResource(R.drawable.edittext_selector_n);
        this.f5457k.setBackgroundResource(R.drawable.edittext_selector_n);
    }

    private boolean m7605g() {
        m7603f();
        if ("".equals(this.f5456j.getText().toString().trim())) {
            this.f5456j.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f5457k.getText().toString().trim())) {
            return true;
        } else {
            this.f5457k.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    public void m7606b(String str) {
        this.f5461o = str;
        if (this.f5456j != null) {
            this.f5456j.setText(str);
        }
    }

    public void m7607c(String str) {
        this.f5462p = str;
        if (this.f5457k != null) {
            this.f5457k.setText(str);
        }
    }

    public void m7608d() {
        this.f5456j.setOnTouchListener(new C19081(this));
        this.f5457k.setOnTouchListener(new C19102(this));
    }

    public void m7609e() {
        this.f5457k.setOnKeyListener(new C19113(this));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5454a = (TCashMerchantActivty) getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_merchant_first, null);
        m5202a((ViewGroup) inflate);
        m7599b(inflate);
        return inflate;
    }
}
