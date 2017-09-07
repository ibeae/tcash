package com.telkom.mwallet.cards;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.http.model.VCardTransaction;
import com.skcc.wallet.framework.p062d.C1312a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.fragment.C1386e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C1413k extends C1386e {
    private static final String f3178a = C1413k.class.getSimpleName();
    private View f3179b;
    private ImageView f3180c;
    private TextView f3181j;
    private ListView f3182k;
    private C1412a f3183l;
    private List<VCardTransaction> f3184m = new ArrayList();
    private C1312a f3185n;
    private String f3186o;
    private String f3187p;
    private CardTransactionHistoryActivity f3188q;

    public class C1412a extends ArrayAdapter<VCardTransaction> {
        final /* synthetic */ C1413k f3175a;
        private final LayoutInflater f3176b;
        private final int f3177c;

        class C1411a {
            TextView f3172a;
            TextView f3173b;
            final /* synthetic */ C1412a f3174c;

            C1411a(C1412a c1412a) {
                this.f3174c = c1412a;
            }
        }

        public C1412a(C1413k c1413k, Context context, int i, List<VCardTransaction> list) {
            this.f3175a = c1413k;
            super(context, i, list);
            this.f3177c = i;
            this.f3176b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C1411a c1411a;
            if (view == null) {
                view = this.f3176b.inflate(this.f3177c, viewGroup, false);
                c1411a = new C1411a(this);
                c1411a.f3172a = (TextView) view.findViewById(R.id.card_transaction_history_listitem_date_textview);
                c1411a.f3173b = (TextView) view.findViewById(R.id.card_transaction_history_listitem_amount_textview);
                this.f3175a.h.m4932a(this.f3175a.f3188q, c1411a.f3172a, 4);
                this.f3175a.h.m4932a(this.f3175a.f3188q, c1411a.f3173b, 4);
                view.setTag(c1411a);
            } else {
                c1411a = (C1411a) view.getTag();
            }
            VCardTransaction vCardTransaction = (VCardTransaction) getItem(i);
            c1411a.f3172a.setText(C1354g.m4953d(vCardTransaction.getTransactionDate()));
            c1411a.f3173b.setText(C1354g.m4955f(vCardTransaction.getAmount()));
            return view;
        }
    }

    private void m5298b(View view) {
        this.f3185n = new C1312a(getActivity().getApplication());
        this.f3179b = view.findViewById(R.id.vertical_line);
        this.f3180c = (ImageView) view.findViewById(R.id.card_img);
        this.f3181j = (TextView) view.findViewById(R.id.card_number_textview);
        this.f3182k = (ListView) view.findViewById(R.id.card_transaction_history_listview);
        this.f3183l = new C1412a(this, this.f3188q, R.layout.view_card_transaction_history_listitem, this.f3184m);
        this.f3182k.setAdapter(this.f3183l);
        m5300d();
        this.f3188q.mo1505o();
    }

    private void m5300d() {
        this.f3181j.setText(C1354g.m4956g(this.f3186o));
        m5301e();
    }

    private void m5301e() {
        if (this.f3187p != null && this.f3187p.startsWith("http")) {
            this.f3185n.m4786a(this.f3187p, this.f3180c);
        } else if (this.f3187p != null) {
            try {
                C1216a.m4522b("imagesub", "image:  ");
                this.f3180c.setImageDrawable(Drawable.createFromStream(getParentFragment().getActivity().getAssets().open(this.f3187p), null));
            } catch (IOException e) {
            }
        }
    }

    public void m5302a(List<VCardTransaction> list) {
        this.f3184m.clear();
        this.f3184m.addAll(list);
        if (this.f3179b != null) {
            C1216a.m4522b("transactions.size()", list.size() + "");
            if (list.size() > 0) {
                C1216a.m4522b("22222222", "22222222");
                this.f3179b.setVisibility(0);
            } else {
                C1216a.m4522b("33333333", "33333333");
                this.f3179b.setVisibility(8);
            }
        }
        if (this.f3183l != null) {
            this.f3183l.notifyDataSetChanged();
        }
    }

    public void m5303b(String str) {
        this.f3186o = str;
    }

    public void m5304c(String str) {
        this.f3187p = str;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3188q = (CardTransactionHistoryActivity) getActivity();
        View inflate = layoutInflater.inflate(R.layout.activity_card_transaction_history, null);
        m5208c(R.string.title_cardlist);
        m5298b(inflate);
        return inflate;
    }
}
