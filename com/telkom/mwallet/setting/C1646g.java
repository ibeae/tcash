package com.telkom.mwallet.setting;

import android.content.Context;
import android.content.Intent;
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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.Notification;
import com.telkom.mwallet.R;
import com.telkom.mwallet.home.C1385b;
import com.telkom.mwallet.p064a.C1354g;
import java.util.ArrayList;
import java.util.List;

public class C1646g extends C1385b {
    public static final String f4102a = C1646g.class.getSimpleName();
    OnScrollListener f4103b = new C16432(this);
    private FragmentManager f4104c;
    private ListView f4105j;
    private ScrollView f4106k;
    private List<Notification> f4107l = new ArrayList();
    private C1645a f4108m;
    private int f4109n = 0;
    private int f4110o = 0;
    private TWalletNewsActivity f4111p;
    private OnItemClickListener f4112q = new C16421(this);

    class C16421 implements OnItemClickListener {
        final /* synthetic */ C1646g f4092a;

        C16421(C1646g c1646g) {
            this.f4092a = c1646g;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent();
            intent.setClass(this.f4092a.f4111p, TWalletNewsDetailActivity.class);
            intent.putExtra("NEWS_DATE", C1354g.m4949b(((Notification) this.f4092a.f4107l.get(i)).getCreatedDate()));
            intent.putExtra("NEWS_TITLE", ((Notification) this.f4092a.f4107l.get(i)).getTitle());
            intent.putExtra("NEWS_CONTENT", ((Notification) this.f4092a.f4107l.get(i)).getContent());
            this.f4092a.startActivityForResult(intent, 1001);
        }
    }

    class C16432 implements OnScrollListener {
        final /* synthetic */ C1646g f4093a;

        C16432(C1646g c1646g) {
            this.f4093a = c1646g;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 == i3 && this.f4093a.f4110o == 10) {
                this.f4093a.f4111p.m6176a(this.f4093a.f4109n);
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    public class C1645a extends ArrayAdapter<Notification> {
        final /* synthetic */ C1646g f4099a;
        private final LayoutInflater f4100b;
        private final int f4101c;

        class C1644a {
            RelativeLayout f4094a;
            TextView f4095b;
            TextView f4096c;
            TextView f4097d;
            final /* synthetic */ C1645a f4098e;

            C1644a(C1645a c1645a) {
                this.f4098e = c1645a;
            }
        }

        public C1645a(C1646g c1646g, Context context, int i, List<Notification> list) {
            this.f4099a = c1646g;
            super(context, i, list);
            this.f4101c = i;
            this.f4100b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C1644a c1644a;
            if (view == null) {
                view = this.f4100b.inflate(this.f4101c, viewGroup, false);
                c1644a = new C1644a(this);
                c1644a.f4094a = (RelativeLayout) view.findViewById(R.id.notification_listitem_layout);
                c1644a.f4095b = (TextView) view.findViewById(R.id.notification_listitem_date_textview);
                c1644a.f4096c = (TextView) view.findViewById(R.id.notification_listitem_title_textview);
                c1644a.f4097d = (TextView) view.findViewById(R.id.notification_listitem_description_textview);
                this.f4099a.h.m4932a(this.f4099a.f4111p, c1644a.f4095b, 2);
                this.f4099a.h.m4932a(this.f4099a.f4111p, c1644a.f4096c, 2);
                this.f4099a.h.m4932a(this.f4099a.f4111p, c1644a.f4097d, 2);
                view.setTag(c1644a);
            } else {
                c1644a = (C1644a) view.getTag();
            }
            Notification notification = (Notification) getItem(i);
            c1644a.f4095b.setText(C1354g.m4949b(notification.getCreatedDate()));
            c1644a.f4096c.setText(notification.getTitle().trim());
            c1644a.f4097d.setText(notification.getContent());
            return view;
        }
    }

    public void m6220a(List<Notification> list) {
        if (list == null || list.size() == 0) {
            this.f4110o = 0;
        } else {
            this.f4110o = list.size();
            this.f4109n++;
            this.f4107l.addAll(list);
            this.f4108m.notifyDataSetChanged();
        }
        if (this.f4107l == null || this.f4107l.size() == 0) {
            this.f4105j.setVisibility(8);
            this.f4106k.setVisibility(0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_twallet_news, null);
        m5208c(R.string.title_twallet_news);
        this.f4111p = (TWalletNewsActivity) getActivity();
        this.f4104c = m5215l();
        this.f4105j = (ListView) inflate.findViewById(R.id.twallet_news_listview);
        this.f4108m = new C1645a(this, this.f4111p, R.layout.view_notification_listitem, this.f4107l);
        this.f4105j.setAdapter(this.f4108m);
        this.f4105j.setOnItemClickListener(this.f4112q);
        this.f4105j.setOnScrollListener(this.f4103b);
        this.f4106k = (ScrollView) inflate.findViewById(R.id.twallet_news_nodata_scrollview);
        this.h.m4934a(this.f4111p, this.f4106k, 1);
        m5217n();
        this.f4107l.clear();
        this.f4111p.m6176a(0);
        return inflate;
    }
}
