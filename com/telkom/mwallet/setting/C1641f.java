package com.telkom.mwallet.setting;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.telkom.mwallet.R;
import com.telkom.mwallet.home.C1385b;

public class C1641f extends C1385b {
    public static final String f4088a = C1641f.class.getSimpleName();
    private FragmentManager f4089b;
    private TWalletNewsDetailActivity f4090c;
    private OnItemClickListener f4091j = new C16401(this);

    class C16401 implements OnItemClickListener {
        final /* synthetic */ C1641f f4087a;

        C16401(C1641f c1641f) {
            this.f4087a = c1641f;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_twallet_news_detail, null);
        m5208c(R.string.title_twallet_news);
        this.f4090c = (TWalletNewsDetailActivity) getActivity();
        this.f4089b = m5215l();
        CharSequence stringExtra = this.f4090c.getIntent().getStringExtra("NEWS_DATE");
        String stringExtra2 = this.f4090c.getIntent().getStringExtra("NEWS_TITLE");
        CharSequence stringExtra3 = this.f4090c.getIntent().getStringExtra("NEWS_CONTENT");
        View view = (TextView) inflate.findViewById(R.id.notification_listitem_date_textview);
        View view2 = (TextView) inflate.findViewById(R.id.notification_listitem_title_textview);
        View view3 = (TextView) inflate.findViewById(R.id.notification_listitem_description_textview);
        view.setText(stringExtra);
        view2.setText(stringExtra2.trim());
        view3.setText(stringExtra3);
        this.h.m4932a(this.f4090c, view, 2);
        this.h.m4932a(this.f4090c, view2, 2);
        this.h.m4932a(this.f4090c, view3, 2);
        return inflate;
    }
}
