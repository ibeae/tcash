package com.telkom.mwallet.tcash.payment.p069a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.Template;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.fragment.C1761d;
import com.telkom.mwallet.tcash.payment.TCashPaymentTemplateActivity;
import java.util.ArrayList;
import java.util.List;

public class C1871p extends C1761d {
    public static final String f5213a = C1871p.class.getSimpleName();
    private Button f5214b;
    private TextView f5215c;
    private ListView f5216d;
    private LinearLayout f5217e;
    private ArrayList<Template> f5218f;
    private C1870a f5219g;
    private String f5220h;
    private boolean f5221i = false;
    private OnClickListener f5222j = new C18681(this);
    private OnItemClickListener f5223k = new C18692(this);

    class C18681 implements OnClickListener {
        final /* synthetic */ C1871p f5208a;

        C18681(C1871p c1871p) {
            this.f5208a = c1871p;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_payment_submenu_slide_button:
                    this.f5208a.onCancel(this.f5208a.getDialog());
                    return;
                default:
                    return;
            }
        }
    }

    class C18692 implements OnItemClickListener {
        final /* synthetic */ C1871p f5209a;

        C18692(C1871p c1871p) {
            this.f5209a = c1871p;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Template template = (Template) this.f5209a.f5218f.get(i);
            Intent intent = new Intent(this.f5209a.getActivity(), TCashPaymentTemplateActivity.class);
            intent.putExtra("TCASH_MENU_NAME", template.getMenuName());
            intent.putExtra("TCASH_SUB_MENU_ID", template.getSubMenuId());
            intent.putExtra("TCASH_SUB_MENU_NAME", template.getSubMenuName());
            intent.putExtra("TCASH_TEMPLATE_ID", template.getLinkTemplate());
            if (this.f5209a.f5221i) {
                intent.putExtra(C1358h.f2940k, C1358h.f2943n);
            }
            this.f5209a.startActivity(intent);
        }
    }

    public class C1870a extends ArrayAdapter<Template> {
        final /* synthetic */ C1871p f5210a;
        private final LayoutInflater f5211b;
        private final int f5212c;

        public C1870a(C1871p c1871p, Context context, int i, List<Template> list) {
            this.f5210a = c1871p;
            super(context, i, list);
            this.f5211b = LayoutInflater.from(context);
            this.f5212c = i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = this.f5211b.inflate(this.f5212c, viewGroup, false);
            ((TextView) inflate.findViewById(R.id.tcash_menu_title_button)).setText(((Template) getItem(i)).getSubMenuName());
            return inflate;
        }
    }

    private void m7330b(View view) {
        this.f5214b = (Button) view.findViewById(R.id.tcash_payment_submenu_slide_button);
        this.f5215c = (TextView) view.findViewById(R.id.tcash_payment_submenu_title_txt);
        this.f5216d = (ListView) view.findViewById(R.id.tcash_payment_submenu_list);
        this.f5217e = (LinearLayout) view.findViewById(R.id.tcash_payment_submenu_layout);
        this.f5219g = new C1870a(this, getActivity(), R.layout.view_tcash_menu_listitem, this.f5218f);
        this.f5216d.setAdapter(this.f5219g);
        this.f5216d.setOnItemClickListener(this.f5223k);
        this.f5214b.setOnClickListener(this.f5222j);
        m7332a(this.f5220h);
        m6762a(this.f5217e);
        m6761a((ViewGroup) view);
    }

    public void m7332a(String str) {
        this.f5220h = str;
        if (this.f5215c != null) {
            this.f5215c.setText(str);
        }
    }

    public void m7333a(ArrayList<Template> arrayList) {
        this.f5218f = arrayList;
    }

    public void m7334a(boolean z) {
        this.f5221i = z;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (TCashActivity.class.getSimpleName().equals(getActivity().getClass().getSimpleName())) {
            ((TCashActivity) getActivity()).m6510a(this.f5221i, false);
        }
        dismiss();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_payment_submenu, viewGroup, false);
        m7330b(inflate);
        return inflate;
    }
}
