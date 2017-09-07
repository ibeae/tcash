package com.telkom.mwallet.tcash.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.TcashTransaction;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1524f;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.TCashTransactionHistoryActivity;
import java.util.ArrayList;
import java.util.List;

public class C1810l extends C1386e {
    private static final String f4786b = C1810l.class.getSimpleName();
    OnScrollListener f4787a = new C18072(this);
    private FragmentManager f4788c;
    private ListView f4789j;
    private ScrollView f4790k;
    private List<TcashTransaction> f4791l = new ArrayList();
    private C1809a f4792m;
    private int f4793n = 0;
    private int f4794o = 0;
    private TCashTransactionHistoryActivity f4795p;
    private OnItemClickListener f4796q = new C18061(this);

    class C18061 implements OnItemClickListener {
        final /* synthetic */ C1810l f4773a;

        C18061(C1810l c1810l) {
            this.f4773a = c1810l;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TcashTransaction tcashTransaction = (TcashTransaction) this.f4773a.f4791l.get(i);
            C1524f.m5666a(C1354g.m4945a(tcashTransaction.getTransactionDate()), tcashTransaction.getInfo(), tcashTransaction.getType(), tcashTransaction.getAmount()).show(this.f4773a.f4788c, "notice_dialog_tag");
        }
    }

    class C18072 implements OnScrollListener {
        int f4774a;
        int f4775b;
        final /* synthetic */ C1810l f4776c;

        C18072(C1810l c1810l) {
            this.f4776c = c1810l;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.f4774a = i + i2;
            this.f4775b = i3;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && this.f4774a == this.f4775b && this.f4776c.f4794o == 10) {
                this.f4776c.f4795p.m6608a(this.f4776c.f4793n);
            }
        }
    }

    public class C1809a extends ArrayAdapter<TcashTransaction> {
        final /* synthetic */ C1810l f4783a;
        private final LayoutInflater f4784b;
        private final int f4785c;

        class C1808a {
            LinearLayout f4777a;
            TextView f4778b;
            TextView f4779c;
            TextView f4780d;
            TextView f4781e;
            final /* synthetic */ C1809a f4782f;

            C1808a(C1809a c1809a) {
                this.f4782f = c1809a;
            }
        }

        public C1809a(C1810l c1810l, Context context, int i, List<TcashTransaction> list) {
            this.f4783a = c1810l;
            super(context, i, list);
            this.f4785c = i;
            this.f4784b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C1808a c1808a;
            if (view == null) {
                view = this.f4784b.inflate(this.f4785c, viewGroup, false);
                c1808a = new C1808a(this);
                c1808a.f4777a = (LinearLayout) view.findViewById(R.id.tcash_transaction_history_listitem_layout);
                c1808a.f4778b = (TextView) view.findViewById(R.id.tcash_transaction_history_listitem_date_textview);
                c1808a.f4779c = (TextView) view.findViewById(R.id.tcash_transaction_history_listitem_amount_textview);
                c1808a.f4780d = (TextView) view.findViewById(R.id.tcash_transaction_history_listitem_amount_fraction_textview);
                c1808a.f4781e = (TextView) view.findViewById(R.id.tcash_transaction_history_listitem_description_textview);
                this.f4783a.h.m4932a(this.f4783a.f4795p, c1808a.f4778b, 1);
                this.f4783a.h.m4932a(this.f4783a.f4795p, c1808a.f4779c, 1);
                this.f4783a.h.m4932a(this.f4783a.f4795p, c1808a.f4780d, 1);
                this.f4783a.h.m4932a(this.f4783a.f4795p, c1808a.f4781e, 3);
                view.setTag(c1808a);
            } else {
                c1808a = (C1808a) view.getTag();
            }
            TcashTransaction tcashTransaction = (TcashTransaction) getItem(i);
            if (tcashTransaction != null) {
                c1808a.f4778b.setText(C1354g.m4945a(tcashTransaction.getTransactionDate()));
                c1808a.f4780d.setText(tcashTransaction.getType());
                c1808a.f4781e.setText(tcashTransaction.getInfo());
                c1808a.f4779c.setText(C1354g.m4955f(tcashTransaction.getAmount()));
            }
            return view;
        }
    }

    public void m6933a(List<TcashTransaction> list) {
        if (list == null || list.size() == 0) {
            this.f4794o = 0;
        } else {
            this.f4794o = list.size();
            this.f4793n++;
            this.f4791l.addAll(list);
            this.f4792m.notifyDataSetChanged();
        }
        if (this.f4791l == null || this.f4791l.size() == 0) {
            this.f4789j.setVisibility(8);
            this.f4790k.setVisibility(0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_transaction_history, null);
        m5209d((int) R.string.title_tcash_history);
        this.f4795p = (TCashTransactionHistoryActivity) getActivity();
        this.f4788c = m5215l();
        this.f4789j = (ListView) inflate.findViewById(R.id.tcash_transaction_history_listview);
        this.f4790k = (ScrollView) inflate.findViewById(R.id.tcash_transaction_history_nodata_scrollview);
        this.f4792m = new C1809a(this, this.f4795p, R.layout.view_tcash_transaction_history_listitem, this.f4791l);
        this.f4789j.setAdapter(this.f4792m);
        this.f4789j.setOnItemClickListener(this.f4796q);
        this.f4789j.setOnScrollListener(this.f4787a);
        this.h.m4934a(this.f4795p, this.f4790k, 1);
        m5217n();
        this.f4791l.clear();
        this.f4795p.m6608a(0);
        return inflate;
    }
}
