package com.telkom.mwallet.setting.tcash;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.TcashFavorite;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.C1522e;
import com.telkom.mwallet.dialog.C1527g;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.dialog.p063a.C1497d;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.BalanceView;
import java.util.ArrayList;
import java.util.List;

public class C1673a extends C1386e {
    public static final String f4201a = C1673a.class.getSimpleName();
    String f4202b;
    C1672a f4203c;
    C1514b f4204j;
    C1522e f4205k;
    private FragmentManager f4206l;
    private BalanceView f4207m;
    private Button f4208n;
    private ListView f4209o;
    private ScrollView f4210p;
    private List<TcashFavorite> f4211q;
    private C1527g f4212r;
    private TcashFavorite f4213s;
    private TCashFavoriteListActivity f4214t;
    private List<TcashFavorite> f4215u;
    private OnClickListener f4216v = new C16621(this);
    private C1497d f4217w = new C16632(this);
    private C1324e f4218x = new C16643(this);
    private C1326f f4219y = new C16654(this);

    class C16621 implements OnClickListener {
        final /* synthetic */ C1673a f4175a;

        C16621(C1673a c1673a) {
            this.f4175a = c1673a;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tcash_favorite_cash_in_button:
                    this.f4175a.f4214t.mo1505o();
                    return;
                default:
                    return;
            }
        }
    }

    class C16632 implements C1497d {
        final /* synthetic */ C1673a f4176a;

        C16632(C1673a c1673a) {
            this.f4176a = c1673a;
        }

        public void mo1537a() {
            if (this.f4176a.f4205k != null) {
                this.f4176a.f4205k.dismiss();
            }
        }

        public void mo1538a(String str, int i) {
            if (this.f4176a.f4205k != null) {
                this.f4176a.f4205k.dismiss();
            }
            this.f4176a.f4213s.setFavoriteMenuName(str);
            this.f4176a.f4213s.setDestinationNo(this.f4176a.g.m4651b("msisdn", ""));
            if (i > 0) {
                this.f4176a.f4213s.setStartDate(C1354g.m4943a(i));
                this.f4176a.f4213s.setPeriod(C1358h.f2930a);
            } else {
                this.f4176a.f4213s.setStartDate("");
                this.f4176a.f4213s.setPeriod("");
            }
            this.f4176a.f4214t.m6272c(this.f4176a.f4213s);
        }
    }

    class C16643 implements C1324e {
        final /* synthetic */ C1673a f4177a;

        C16643(C1673a c1673a) {
            this.f4177a = c1673a;
        }

        public void mo1483a(int i) {
            if (i == 0) {
                this.f4177a.m6338b(this.f4177a.f4213s);
            } else if (i == 1) {
                this.f4177a.f4204j = C1514b.m5648a((int) R.string.title_delete, (int) R.string.delete_message);
                this.f4177a.f4204j.m5651a(this.f4177a.f4219y);
                this.f4177a.f4204j.m5652b(R.string.delete_sure);
                this.f4177a.f4204j.show(this.f4177a.f4206l, "notice_dialog_tag");
            } else if (i == 2) {
                this.f4177a.f4214t.m6264a(this.f4177a.f4213s);
            }
            this.f4177a.f4212r.dismiss();
        }

        public void mo1484a(String str) {
        }
    }

    class C16654 implements C1326f {
        final /* synthetic */ C1673a f4178a;

        C16654(C1673a c1673a) {
            this.f4178a = c1673a;
        }

        public void mo1485a() {
            if (this.f4178a.f4204j != null) {
                this.f4178a.f4204j.dismiss();
            }
            this.f4178a.f4214t.m6270b(this.f4178a.f4213s);
        }

        public void mo1486b() {
            if (this.f4178a.f4204j != null) {
                this.f4178a.f4204j.dismiss();
            }
        }
    }

    private class C1672a extends ArrayAdapter<TcashFavorite> {
        final /* synthetic */ C1673a f4198a;
        private final LayoutInflater f4199b;
        private final int f4200c;

        class C1671a {
            LinearLayout f4189a;
            LinearLayout f4190b;
            TextView f4191c;
            TextView f4192d;
            TextView f4193e;
            Button f4194f;
            Button f4195g;
            Button f4196h;
            final /* synthetic */ C1672a f4197i;

            C1671a(C1672a c1672a) {
                this.f4197i = c1672a;
            }
        }

        public C1672a(C1673a c1673a, Context context, int i, List<TcashFavorite> list) {
            this.f4198a = c1673a;
            super(context, i, list);
            this.f4200c = i;
            this.f4199b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            C1671a c1671a;
            if (view == null) {
                view = this.f4199b.inflate(this.f4200c, viewGroup, false);
                c1671a = new C1671a(this);
                c1671a.f4189a = (LinearLayout) view.findViewById(R.id.tcash_favorite_listitem_layout);
                c1671a.f4195g = (Button) view.findViewById(R.id.tcash_favorite_listitem_edit_button);
                c1671a.f4194f = (Button) view.findViewById(R.id.tcash_favorite_listitem_proceed_button);
                c1671a.f4191c = (TextView) view.findViewById(R.id.tcash_favorite_listitem_type_textview);
                c1671a.f4192d = (TextView) view.findViewById(R.id.tcash_favorite_listitem_title_textview);
                c1671a.f4193e = (TextView) view.findViewById(R.id.tcash_favorite_listitem_balance_textview);
                c1671a.f4190b = (LinearLayout) view.findViewById(R.id.tcash_favorite_listitem_more_layout);
                c1671a.f4196h = (Button) view.findViewById(R.id.tcash_favorite_listitem_more_button);
                this.f4198a.h.m4932a(this.f4198a.e, c1671a.f4195g, 3);
                this.f4198a.h.m4932a(this.f4198a.e, c1671a.f4194f, 3);
                this.f4198a.h.m4932a(this.f4198a.e, c1671a.f4191c, 1);
                this.f4198a.h.m4932a(this.f4198a.e, c1671a.f4192d, 2);
                this.f4198a.h.m4932a(this.f4198a.e, c1671a.f4193e, 3);
                view.setTag(c1671a);
                view.setLongClickable(true);
            } else {
                c1671a = (C1671a) view.getTag();
            }
            final TcashFavorite tcashFavorite = (TcashFavorite) getItem(i);
            c1671a.f4192d.setText(tcashFavorite.getFavoriteMenuName());
            c1671a.f4193e.setText(C1354g.m4955f(String.valueOf(tcashFavorite.getAmount())));
            c1671a.f4191c.setText(this.f4198a.f4214t.m6273e(tcashFavorite.getMenuId()));
            c1671a.f4194f.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C1672a f4180b;

                public void onClick(View view) {
                    this.f4180b.f4198a.f4214t.m6264a(tcashFavorite);
                }
            });
            c1671a.f4195g.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C1672a f4182b;

                public void onClick(View view) {
                    this.f4182b.f4198a.f4213s = tcashFavorite;
                    this.f4182b.f4198a.m6338b(this.f4182b.f4198a.f4213s);
                }
            });
            c1671a.f4190b.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C1672a f4184b;

                public void onClick(View view) {
                    this.f4184b.f4198a.f4213s = (TcashFavorite) this.f4184b.f4198a.f4211q.get(i);
                    List arrayList = new ArrayList();
                    arrayList.add(this.f4184b.f4198a.getString(R.string.list_edit));
                    arrayList.add(this.f4184b.f4198a.getString(R.string.list_delete));
                    this.f4184b.f4198a.f4212r = C1527g.m5667a((int) R.string.title_favorite_long);
                    this.f4184b.f4198a.f4212r.m5671a(arrayList);
                    this.f4184b.f4198a.f4212r.m5670a(this.f4184b.f4198a.f4218x);
                    this.f4184b.f4198a.f4212r.show(this.f4184b.f4198a.f4206l, "list_dialog_tag");
                }
            });
            c1671a.f4196h.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C1672a f4186b;

                public void onClick(View view) {
                    this.f4186b.f4198a.f4213s = (TcashFavorite) this.f4186b.f4198a.f4211q.get(i);
                    List arrayList = new ArrayList();
                    arrayList.add(this.f4186b.f4198a.getString(R.string.list_edit));
                    arrayList.add(this.f4186b.f4198a.getString(R.string.list_delete));
                    this.f4186b.f4198a.f4212r = C1527g.m5667a((int) R.string.title_favorite_long);
                    this.f4186b.f4198a.f4212r.m5671a(arrayList);
                    this.f4186b.f4198a.f4212r.m5670a(this.f4186b.f4198a.f4218x);
                    this.f4186b.f4198a.f4212r.show(this.f4186b.f4198a.f4206l, "list_dialog_tag");
                }
            });
            c1671a.f4189a.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C1672a f4188b;

                public void onClick(View view) {
                    this.f4188b.f4198a.f4214t.m6264a(tcashFavorite);
                }
            });
            return view;
        }
    }

    private void m6338b(TcashFavorite tcashFavorite) {
        String startDate = tcashFavorite.getStartDate();
        int i = -1;
        if (!(startDate == null || startDate.isEmpty())) {
            i = Integer.parseInt(tcashFavorite.getStartDate().substring(6));
        }
        this.f4205k = C1522e.m5660a(i, tcashFavorite.getFavoriteMenuName());
        this.f4205k.m5664a(this.f4217w);
        this.f4205k.show(this.f4206l, "notice_dialog_tag");
    }

    public void m6355a(TcashFavorite tcashFavorite) {
        this.f4211q.remove(this.f4213s);
        this.f4203c.notifyDataSetChanged();
        if (this.f4211q == null || this.f4211q.size() == 0) {
            this.f4209o.setVisibility(8);
            this.f4210p.setVisibility(0);
        }
    }

    public void m6356a(List<TcashFavorite> list) {
        if (this.f4209o == null) {
            this.f4215u = list;
        } else if (list == null) {
            this.f4209o.setVisibility(8);
            this.f4210p.setVisibility(0);
        } else {
            this.f4209o.setVisibility(0);
            this.f4210p.setVisibility(8);
            this.f4211q.clear();
            this.f4211q.addAll(list);
            this.f4203c.notifyDataSetChanged();
        }
    }

    public void m6357b(String str) {
        this.f4202b = str;
        if (this.f4207m != null) {
            this.f4207m.setBalance(str);
            this.f4207m.setFont(this.h);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_favorite_list, null);
        m5208c(R.string.title_tcash_favorite);
        this.f4207m = (BalanceView) inflate.findViewById(R.id.tcash_balance);
        if (this.f4202b != null) {
            m6357b(this.f4202b);
        }
        this.f4214t = (TCashFavoriteListActivity) getActivity();
        this.f4206l = m5215l();
        this.f4208n = (Button) inflate.findViewById(R.id.tcash_favorite_cash_in_button);
        this.f4208n.setOnClickListener(this.f4216v);
        this.f4209o = (ListView) inflate.findViewById(R.id.tcash_favorite_list_listview);
        this.f4211q = new ArrayList();
        this.f4203c = new C1672a(this, this.e, R.layout.view_tcash_favorite_listitem, this.f4211q);
        this.f4209o.setAdapter(this.f4203c);
        this.f4210p = (ScrollView) inflate.findViewById(R.id.tcash_favorite_list_nodata_scrollview);
        this.h.m4934a(this.e, (LinearLayout) inflate.findViewById(R.id.tcash_top_layout), 3);
        if (this.f4215u != null) {
            m6356a(this.f4215u);
        }
        return inflate;
    }
}
