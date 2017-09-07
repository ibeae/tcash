package com.telkom.mwallet.tcash.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.TransferType;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1549l;
import com.telkom.mwallet.dialog.C1552m;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.dialog.p063a.C1501j;
import com.telkom.mwallet.p064a.C1347a;
import com.telkom.mwallet.p064a.C1353f;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.TCashTransferActivity;

public class C1815m extends C1386e {
    private static final String f4801j = C1815m.class.getSimpleName();
    private static View f4802w = null;
    private String f4803A;
    private boolean f4804B = false;
    private String f4805C;
    private TransferType f4806D = null;
    private OnTouchListener f4807E = new C18111(this);
    private OnClickListener f4808F = new C18122(this);
    private C1501j f4809G = new C18133(this);
    private C1324e f4810H = new C18144(this);
    TCashTransferActivity f4811a;
    protected TransferType f4812b;
    protected String f4813c = null;
    private TextView f4814k;
    private EditText f4815l;
    private EditText f4816m;
    private EditText f4817n;
    private EditText f4818o;
    private EditText f4819p;
    private Button f4820q;
    private Button f4821r;
    private Button f4822s;
    private Button f4823t;
    private Button f4824u;
    private Button f4825v;
    private C1552m f4826x;
    private C1549l f4827y;
    private String f4828z = null;

    class C18111 implements OnTouchListener {
        final /* synthetic */ C1815m f4797a;

        C18111(C1815m c1815m) {
            this.f4797a = c1815m;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                C1815m.f4802w = view;
            } else if (motionEvent.getAction() == 1) {
                if (view.equals(C1815m.f4802w)) {
                    switch (view.getId()) {
                        case R.id.tcash_bankcode_button:
                            this.f4797a.f4827y = C1549l.m5706a((int) R.string.title_search_dialog_bankcode);
                            this.f4797a.f4827y.m5708a(this.f4797a.f4810H);
                            this.f4797a.f4827y.show(this.f4797a.getFragmentManager(), "list_dialog_tag");
                            break;
                        case R.id.tcash_mobilenum_picker_button:
                            this.f4797a.startActivityForResult(new Intent("android.intent.action.PICK", Phone.CONTENT_URI), C1358h.f2944o);
                            break;
                        case R.id.tcash_transfer_type_button:
                        case R.id.tcash_transfer_type_picker_button:
                            this.f4797a.f4826x = C1552m.m5710a((int) R.string.select_transfer_type);
                            this.f4797a.f4826x.m5711a(this.f4797a.f4809G);
                            this.f4797a.f4826x.show(this.f4797a.getFragmentManager(), "list_dialog_tag");
                            break;
                    }
                }
                C1815m.f4802w = null;
                return true;
            }
            return false;
        }
    }

    class C18122 implements OnClickListener {
        final /* synthetic */ C1815m f4798a;

        C18122(C1815m c1815m) {
            this.f4798a = c1815m;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_set_favorite_button:
                    if (this.f4798a.f4824u.isSelected()) {
                        this.f4798a.f4824u.setSelected(false);
                        this.f4798a.f4819p.setVisibility(8);
                        return;
                    }
                    this.f4798a.f4824u.setSelected(true);
                    this.f4798a.f4819p.setText("");
                    this.f4798a.f4819p.setVisibility(0);
                    return;
                case R.id.tcash_transfer_next_button:
                    if (this.f4798a.m6949f()) {
                        this.f4798a.f4811a.m6633a(this.f4798a.f4812b);
                        if ("4200000".equals(this.f4798a.f4812b.getTransferTypeId())) {
                            this.f4798a.f4811a.m6642g(this.f4798a.f4822s.getText().toString());
                        } else if (!C1354g.m4952c(this.f4798a.f4817n)) {
                            this.f4798a.f4817n.requestFocus(this.f4798a.f4817n.length());
                            this.f4798a.f4817n.setBackgroundResource(R.drawable.field_sct_red);
                            return;
                        }
                        this.f4798a.f4811a.m6643j(this.f4798a.f4817n.getText().toString());
                        this.f4798a.f4811a.m6644k(this.f4798a.f4816m.getText().toString());
                        this.f4798a.f4811a.m6633a(this.f4798a.f4812b);
                        this.f4798a.f4811a.m6645l(this.f4798a.f4818o.getText().toString());
                        this.f4798a.f4811a.m6637a("name", this.f4798a.f4815l.getText().toString());
                        if (this.f4798a.f4824u.isSelected()) {
                            String obj = this.f4798a.f4819p.getText().toString();
                            if (obj.isEmpty()) {
                                obj = this.f4798a.getString(R.string.hint_favorite_title);
                            }
                            this.f4798a.f4811a.m6641f(obj);
                        } else {
                            this.f4798a.f4811a.m6648q();
                        }
                        C1353f.m4942b(this.f4798a.f4816m);
                        C1353f.m4942b(this.f4798a.f4818o);
                        C1353f.m4942b(this.f4798a.f4815l);
                        C1353f.m4942b(this.f4798a.f4817n);
                        C1353f.m4942b(this.f4798a.f4819p);
                        this.f4798a.f4811a.m6647p();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C18133 implements C1501j {
        final /* synthetic */ C1815m f4799a;

        C18133(C1815m c1815m) {
            this.f4799a = c1815m;
        }

        public void mo1551a(TransferType transferType) {
            this.f4799a.f4812b = transferType;
            this.f4799a.f4820q.setText(transferType.getName());
            if ("4100000".equals(transferType.getTransferTypeId())) {
                this.f4799a.f4822s.setVisibility(8);
                this.f4799a.f4823t.setVisibility(0);
                this.f4799a.f4817n.setHint(R.string.recipient);
                this.f4799a.f4817n.requestFocus();
            } else if ("4200000".equals(transferType.getTransferTypeId())) {
                this.f4799a.f4822s.setVisibility(0);
                this.f4799a.f4823t.setVisibility(8);
                this.f4799a.f4817n.setHint(R.string.recipient_account);
                this.f4799a.f4822s.requestFocus();
            }
            if (this.f4799a.f4826x != null) {
                this.f4799a.f4826x.dismiss();
            }
        }
    }

    class C18144 implements C1324e {
        final /* synthetic */ C1815m f4800a;

        C18144(C1815m c1815m) {
            this.f4800a = c1815m;
        }

        public void mo1483a(int i) {
        }

        public void mo1484a(String str) {
            this.f4800a.f4827y.dismiss();
            this.f4800a.f4822s.setText(str);
        }
    }

    private void m6943c(View view) {
        this.f4814k = (TextView) view.findViewById(R.id.tcash_customerid_text);
        this.f4820q = (Button) view.findViewById(R.id.tcash_transfer_type_button);
        this.f4821r = (Button) view.findViewById(R.id.tcash_transfer_type_picker_button);
        this.f4822s = (Button) view.findViewById(R.id.tcash_bankcode_button);
        this.f4823t = (Button) view.findViewById(R.id.tcash_mobilenum_picker_button);
        this.f4815l = (EditText) view.findViewById(R.id.tcash_name_edittext);
        this.f4816m = (EditText) view.findViewById(R.id.tcash_amount_edittext);
        C1347a.m4910a().m4914a(this.f4816m);
        this.f4817n = (EditText) view.findViewById(R.id.tcash_recipient_edittext);
        this.f4818o = (EditText) view.findViewById(R.id.tcash_comment_edittext);
        this.f4819p = (EditText) view.findViewById(R.id.tcash_title_favorite_edittext);
        this.f4824u = (Button) view.findViewById(R.id.tcash_set_favorite_button);
        this.f4825v = (Button) view.findViewById(R.id.tcash_transfer_next_button);
        this.f4820q.setOnTouchListener(this.f4807E);
        this.f4821r.setOnTouchListener(this.f4807E);
        this.f4822s.setOnTouchListener(this.f4807E);
        this.f4823t.setOnTouchListener(this.f4807E);
        this.f4824u.setOnClickListener(this.f4808F);
        this.f4825v.setOnClickListener(this.f4808F);
        this.f4814k.setText(this.f4828z);
        if (this.f4804B) {
            m6953h();
            this.f4817n.setText(this.f4813c);
            this.f4816m.setText(this.f4805C);
        } else {
            m6950g();
            if (this.f4813c != null) {
                this.f4817n.setText(this.f4813c);
            }
            this.f4816m.setText(this.f4805C);
            if (this.f4806D != null) {
                this.f4809G.mo1551a(this.f4806D);
            }
        }
        m5216m().m4982d().m4932a(getActivity().getApplicationContext(), this.f4820q, 2);
        m5216m().m4982d().m4932a(getActivity().getApplicationContext(), this.f4822s, 2);
    }

    private void m6947e() {
        this.f4820q.setBackgroundResource(R.drawable.edittext_selector_top);
        this.f4822s.setBackgroundResource(R.drawable.edittext_selector_middle);
        this.f4817n.setBackgroundResource(R.drawable.edittext_selector_middle);
        if (this.f4818o.getVisibility() == 0) {
            this.f4816m.setBackgroundResource(R.drawable.edittext_selector_middle);
        } else {
            this.f4816m.setBackgroundResource(R.drawable.edittext_selector_bottom);
        }
    }

    private boolean m6949f() {
        m6947e();
        if ("".equals(this.f4820q.getText().toString().trim())) {
            this.f4820q.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("4200000".equals(this.f4812b.getTransferTypeId()) && "".equals(this.f4822s.getText().toString().trim())) {
            this.f4822s.requestFocus();
            this.f4822s.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if ("".equals(this.f4817n.getText().toString().trim())) {
            this.f4817n.requestFocus();
            this.f4817n.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        } else if (!"".equals(this.f4816m.getText().toString().trim())) {
            return true;
        } else {
            this.f4816m.requestFocus();
            this.f4816m.setBackgroundResource(R.drawable.field_sct_red);
            return false;
        }
    }

    private void m6950g() {
        int i = 0;
        if (this.f4803A != null && !this.f4803A.isEmpty()) {
            TransferType[] transferTypeArr = new TransferType[]{new TransferType(getString(R.string.select_transfer_mobile), "4100000"), new TransferType(getString(R.string.select_transfer_bank), "4200000")};
            int length = transferTypeArr.length;
            while (i < length) {
                TransferType transferType = transferTypeArr[i];
                if (this.f4803A.equals(transferType.getTransferTypeId())) {
                    this.f4806D = transferType;
                    return;
                }
                i++;
            }
        }
    }

    private void m6953h() {
        this.f4820q.setText(R.string.select_transfer_mobile);
        this.f4809G.mo1551a(new TransferType(getString(R.string.select_transfer_mobile), "4100000"));
        this.f4822s.setVisibility(8);
        this.f4823t.setVisibility(0);
        this.f4817n.setHint(R.string.recipient);
        this.f4817n.requestFocus();
    }

    public void m6960a(boolean z) {
        this.f4804B = z;
    }

    public void m6961b(String str) {
        this.f4828z = str;
    }

    public void m6962c(String str) {
        this.f4803A = str;
    }

    public void m6963f(String str) {
        this.f4813c = str;
        if (this.f4817n != null) {
            this.f4817n.setText(str);
        }
    }

    public void m6964g(String str) {
        this.f4805C = str;
        if (this.f4816m != null) {
            this.f4816m.setText(this.f4805C);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == C1358h.f2944o && intent != null) {
            Cursor query = getActivity().getContentResolver().query(intent.getData(), null, null, null, null);
            if (query.moveToFirst()) {
                String string = query.getString(query.getColumnIndex("data1"));
                CharSequence string2 = query.getString(query.getColumnIndex("display_name"));
                this.f4817n.setText(C1354g.m4960k(string));
                if (string2 != null && !"".equals(string2)) {
                    this.f4815l.setVisibility(0);
                    this.f4818o.setVisibility(0);
                    this.f4815l.setText(string2);
                    this.f4816m.setBackgroundResource(R.drawable.edittext_selector_middle);
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4811a = (TCashTransferActivity) getActivity();
        String stringExtra = this.f4811a.getIntent().getStringExtra(C1358h.f2941l);
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_transfer_first, null);
        m5202a((ViewGroup) inflate);
        m6943c(inflate);
        if (C1358h.f2942m.equals(stringExtra)) {
            this.f4809G.mo1551a(new TransferType(getString(R.string.select_transfer_bank), "4200000"));
        }
        return inflate;
    }
}
