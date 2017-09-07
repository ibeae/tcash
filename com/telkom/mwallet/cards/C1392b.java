package com.telkom.mwallet.cards;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.http.model.LoyaltyCard;
import com.skcc.wallet.framework.api.http.model.ServiceVo;
import com.skcc.wallet.framework.p062d.C1312a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1517c;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.tcash.fragment.C1386e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C1392b extends C1386e {
    private static final String f3083a = C1392b.class.getSimpleName();
    private ListView f3084b;
    private C1391a f3085c;
    private LoyaltyCard f3086j;
    private List<LoyaltyCard> f3087k;
    private List<LoyaltyCard> f3088l;
    private C1517c f3089m;
    private C1312a f3090n;
    private CardAddListActivity f3091o;
    private OnItemClickListener f3092p = new C13881(this);
    private C1326f f3093q = new C13892(this);

    class C13881 implements OnItemClickListener {
        final /* synthetic */ C1392b f3073a;

        C13881(C1392b c1392b) {
            this.f3073a = c1392b;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f3073a.f3086j = (LoyaltyCard) this.f3073a.f3087k.get(i);
            this.f3073a.f3089m = C1517c.m5654a((int) R.string.will_add_card);
            this.f3073a.f3089m.m5656a(this.f3073a.f3093q);
            this.f3073a.f3089m.m5657b(R.string.btn_yes);
            this.f3073a.f3089m.m5658c(R.string.btn_no);
            this.f3073a.f3089m.show(this.f3073a.getFragmentManager(), "notice_dialog_tag");
        }
    }

    class C13892 implements C1326f {
        final /* synthetic */ C1392b f3074a;

        C13892(C1392b c1392b) {
            this.f3074a = c1392b;
        }

        public void mo1485a() {
            if (this.f3074a.f3089m != null) {
                this.f3074a.f3089m.dismiss();
            }
            if (this.f3074a.f3086j != null) {
                this.f3074a.f3091o.m5111e(this.f3074a.f3086j.getMerchantId());
                this.f3074a.f3091o.m5112f(this.f3074a.f3086j.getLoyaltyCardProfileNo());
                this.f3074a.f3091o.mo1505o();
            }
        }

        public void mo1486b() {
            if (this.f3074a.f3089m != null) {
                this.f3074a.f3089m.dismiss();
            }
        }
    }

    private class C1391a extends ArrayAdapter<ServiceVo> {
        final /* synthetic */ C1392b f3079a;
        private LayoutInflater f3080b;
        private int f3081c;
        private List<LoyaltyCard> f3082d;

        class C1390a {
            public ImageView f3075a;
            public TextView f3076b;
            public TextView f3077c;
            final /* synthetic */ C1391a f3078d;

            C1390a(C1391a c1391a) {
                this.f3078d = c1391a;
            }
        }

        public C1391a(C1392b c1392b, Context context, int i) {
            this.f3079a = c1392b;
            super(context, i);
            this.f3081c = i;
            this.f3080b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        protected void m5231a(List<LoyaltyCard> list) {
            this.f3082d = list;
        }

        public int getCount() {
            return this.f3082d == null ? 0 : this.f3082d.size();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C1390a c1390a;
            if (view == null) {
                view = this.f3080b.inflate(this.f3081c, viewGroup, false);
                c1390a = new C1390a(this);
                c1390a.f3075a = (ImageView) view.findViewById(R.id.card_add_listitem_imageview);
                c1390a.f3076b = (TextView) view.findViewById(R.id.card_add_listitem_title);
                c1390a.f3077c = (TextView) view.findViewById(R.id.card_add_listitem_desc);
                view.setTag(c1390a);
            } else {
                c1390a = (C1390a) view.getTag();
            }
            this.f3079a.h.m4932a(this.f3079a.f3091o, c1390a.f3076b, 2);
            this.f3079a.h.m4932a(this.f3079a.f3091o, c1390a.f3077c, 1);
            this.f3079a.m5236a(((LoyaltyCard) this.f3082d.get(i)).getLoyaltyCardDefaultImageUrl(), c1390a.f3075a);
            c1390a.f3076b.setText(((LoyaltyCard) this.f3082d.get(i)).getLoyaltyCardName());
            c1390a.f3077c.setText(((LoyaltyCard) this.f3082d.get(i)).getLoyaltyCardDesc());
            return view;
        }
    }

    private void m5236a(String str, ImageView imageView) {
        if (str != null && str.startsWith("http")) {
            this.f3090n.m4786a(str, imageView);
        } else if (str != null) {
            try {
                C1216a.m4522b("imagesub", "image:  ");
                imageView.setImageDrawable(Drawable.createFromStream(getParentFragment().getActivity().getAssets().open(str), null));
            } catch (IOException e) {
            }
        }
    }

    private void m5238b(View view) {
        this.f3090n = new C1312a(getActivity().getApplication());
        this.f3084b = (ListView) view.findViewById(R.id.cardlist_listview);
        this.f3085c = new C1391a(this, this.f3091o, R.layout.view_card_add_listitem);
        this.f3084b.setAdapter(this.f3085c);
        this.f3084b.setOnItemClickListener(this.f3092p);
        if (this.f3088l != null) {
            m5244a(this.f3088l);
        }
    }

    public void m5244a(List<LoyaltyCard> list) {
        if (this.f3084b == null) {
            this.f3088l = list;
            return;
        }
        if (this.f3087k == null) {
            this.f3087k = new ArrayList();
        }
        this.f3087k.clear();
        this.f3087k.addAll(list);
        this.f3085c.m5231a(this.f3087k);
        this.f3085c.notifyDataSetChanged();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_card_add_list, null);
        m5208c(R.string.title_card_add);
        this.f3091o = (CardAddListActivity) getActivity();
        m5238b(inflate);
        return inflate;
    }

    public void onDestroy() {
        this.f3090n.m4785a();
        super.onDestroy();
    }
}
