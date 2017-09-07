package com.telkom.mwallet.tcash.purchase.p070a;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.Template;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.fragment.C1761d;
import com.telkom.mwallet.tcash.purchase.TCashPurchaseActivity;
import com.telkom.mwallet.tcash.purchase.TCashTicketActivity;
import com.telkom.mwallet.tcash.purchase.TCashTransportTravelActivity;
import java.util.ArrayList;
import java.util.List;

public class C1969x extends C1761d {
    private static final String f5735c = C1969x.class.getSimpleName();
    OnClickListener f5736a = new C19651(this);
    OnItemClickListener f5737b = new C19662(this);
    private Button f5738d;
    private TextView f5739e;
    private ListView f5740f;
    private LinearLayout f5741g;
    private ArrayList<Template> f5742h;
    private C1968a f5743i;
    private String f5744j;
    private boolean f5745k = false;

    class C19651 implements OnClickListener {
        final /* synthetic */ C1969x f5727a;

        C19651(C1969x c1969x) {
            this.f5727a = c1969x;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_purchase_menu_slide_button:
                    this.f5727a.onCancel(this.f5727a.getDialog());
                    return;
                default:
                    return;
            }
        }
    }

    class C19662 implements OnItemClickListener {
        final /* synthetic */ C1969x f5728a;

        C19662(C1969x c1969x) {
            this.f5728a = c1969x;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Template template = (Template) this.f5728a.f5742h.get(i);
            Intent intent;
            if ("2600".equals(template.getMenuId())) {
                intent = new Intent(this.f5728a.getActivity(), TCashTicketActivity.class);
                intent.putExtra("TCASH_SUB_MENU_ID", template.getSubMenuId());
                intent.putExtra(C1358h.f2939j, template.getLinkTemplate());
                intent.putExtra("TCASH_SUB_MENU_NAME", template.getSubMenuName());
                if (this.f5728a.f5745k) {
                    intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                }
                this.f5728a.startActivity(intent);
            } else if ("2700".equals(template.getMenuId())) {
                intent = new Intent(this.f5728a.getActivity(), TCashTransportTravelActivity.class);
                intent.putExtra("TCASH_SUB_MENU_ID", template.getSubMenuId());
                intent.putExtra(C1358h.f2939j, template.getLinkTemplate());
                intent.putExtra("TCASH_SUB_MENU_NAME", template.getSubMenuName());
                if (this.f5728a.f5745k) {
                    intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                }
                this.f5728a.startActivity(intent);
            } else {
                intent = new Intent(this.f5728a.getActivity(), TCashPurchaseActivity.class);
                intent.putExtra("TCASH_MENU_ID", template.getSubMenuId());
                intent.putExtra("TCASH_SUB_MENU_ID", template.getSubMenuId());
                intent.putExtra("TCASH_SUB_MENU_NAME", template.getSubMenuName());
                intent.putExtra("TCASH_TEMPLATE_ID", template.getLinkTemplate());
                if (this.f5728a.f5745k) {
                    intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                }
                this.f5728a.startActivity(intent);
            }
        }
    }

    public class C1968a extends ArrayAdapter<Template> {
        final /* synthetic */ C1969x f5732a;
        private final LayoutInflater f5733b;
        private final int f5734c;

        class C1967a {
            TextView f5729a;
            ImageView f5730b;
            final /* synthetic */ C1968a f5731c;

            C1967a(C1968a c1968a) {
                this.f5731c = c1968a;
            }
        }

        public C1968a(C1969x c1969x, Context context, int i, List<Template> list) {
            this.f5732a = c1969x;
            super(context, i, list);
            this.f5733b = LayoutInflater.from(context);
            this.f5734c = i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C1967a c1967a;
            if (view == null) {
                view = this.f5733b.inflate(this.f5734c, viewGroup, false);
                c1967a = new C1967a(this);
                c1967a.f5729a = (TextView) view.findViewById(R.id.tcash_menu_title_button);
                c1967a.f5730b = (ImageView) view.findViewById(R.id.tcash_menu_arrow_imageview);
                view.setTag(c1967a);
            } else {
                c1967a = (C1967a) view.getTag();
            }
            c1967a.f5729a.setText(((Template) getItem(i)).getSubMenuName());
            return view;
        }
    }

    private void m7873b(View view) {
        this.f5738d = (Button) view.findViewById(R.id.tcash_purchase_menu_slide_button);
        this.f5739e = (TextView) view.findViewById(R.id.sub_menu_title_textview);
        this.f5740f = (ListView) view.findViewById(R.id.tcash_purchase_menu_listview);
        this.f5741g = (LinearLayout) view.findViewById(R.id.tcash_purchase_menu_layout);
        this.f5743i = new C1968a(this, getActivity(), R.layout.view_tcash_menu_listitem, this.f5742h);
        this.f5740f.setAdapter(this.f5743i);
        this.f5738d.setOnClickListener(this.f5736a);
        this.f5740f.setOnItemClickListener(this.f5737b);
        m7875a(this.f5744j);
        m6762a(this.f5741g);
        m6761a((ViewGroup) view);
    }

    public void m7875a(String str) {
        this.f5744j = str;
        if (this.f5739e != null) {
            this.f5739e.setText(str);
        }
    }

    public void m7876a(ArrayList<Template> arrayList) {
        this.f5742h = arrayList;
    }

    public void m7877a(boolean z) {
        this.f5745k = z;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (TCashActivity.class.getSimpleName().equals(getActivity().getClass().getSimpleName())) {
            dismiss();
        } else {
            dismiss();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setGravity(81);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
        View inflate = layoutInflater.inflate(R.layout.fragment_tcash_purchase_submenu, viewGroup, false);
        m7873b(inflate);
        return inflate;
    }
}
