package com.telkom.mwallet.setting.twitter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.p005a.p006a.p013b.C0235c;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.setting.twitter.C1703d.C1702a;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TwitterList extends SlidingFrameActivity implements OnItemClickListener {
    public static C1697c f4231l;
    private static final Comparator<C1702a> f4232z = new C16752();
    private C1326f f4233A = new C16763(this);
    private C1326f f4234B = new C16774(this);
    ListView f4235k;
    C0235c f4236m;
    ArrayList<Object> f4237n = new ArrayList();
    C1692a f4238o = new C1692a();

    class C16741 implements OnClickListener {
        final /* synthetic */ TwitterList f4220a;

        C16741(TwitterList twitterList) {
            this.f4220a = twitterList;
        }

        public void onClick(View view) {
            if (C1703d.f4296c != null) {
                C1703d.f4296c.m6413e();
            }
            this.f4220a.finish();
        }
    }

    static class C16752 implements Comparator<C1702a> {
        private final Collator f4221a = Collator.getInstance();

        C16752() {
        }

        public int m6358a(C1702a c1702a, C1702a c1702a2) {
            return this.f4221a.compare(c1702a.f4290c, c1702a2.f4290c);
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m6358a((C1702a) obj, (C1702a) obj2);
        }
    }

    class C16763 implements C1326f {
        final /* synthetic */ TwitterList f4222a;

        C16763(TwitterList twitterList) {
            this.f4222a = twitterList;
        }

        public void mo1485a() {
            if (this.f4222a.h != null) {
                this.f4222a.h.dismiss();
            }
            this.f4222a.finish();
        }

        public void mo1486b() {
        }
    }

    class C16774 implements C1326f {
        final /* synthetic */ TwitterList f4223a;

        C16774(TwitterList twitterList) {
            this.f4223a = twitterList;
        }

        public void mo1485a() {
            if (this.f4223a.h != null) {
                this.f4223a.h.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    public class C1678a extends BaseAdapter {
        final /* synthetic */ TwitterList f4224a;
        private LayoutInflater f4225b;

        public C1678a(TwitterList twitterList, TwitterList twitterList2) {
            this.f4224a = twitterList;
            TwitterList.f4231l = null;
            if (TwitterList.f4231l == null) {
                TwitterList.f4231l = new C1697c(twitterList2);
            }
            TwitterList.f4231l.m6384a((BaseAdapter) this);
            this.f4225b = LayoutInflater.from(twitterList2);
        }

        public int getCount() {
            return this.f4224a.f4237n.size();
        }

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            C1679b c1679b;
            Object obj = this.f4224a.f4237n.get(i);
            boolean z = obj instanceof C1702a;
            View view2 = (view == null || z == ((C1679b) view.getTag()).f4226a) ? view : null;
            if (view2 == null) {
                C1679b c1679b2;
                if (z) {
                    inflate = this.f4225b.inflate(R.layout.friend_item, null);
                    c1679b = new C1679b(this.f4224a);
                    c1679b.f4226a = true;
                    c1679b.f4227b = (ImageView) inflate.findViewById(R.id.profile_pic);
                    c1679b.f4228c = (TextView) inflate.findViewById(R.id.name);
                    c1679b.f4229d = (TextView) inflate.findViewById(R.id.info);
                    c1679b2 = c1679b;
                    view2 = inflate;
                } else {
                    inflate = this.f4225b.inflate(R.layout.friend_section, null);
                    c1679b = new C1679b(this.f4224a);
                    c1679b.f4226a = false;
                    c1679b.f4228c = (TextView) inflate.findViewById(R.id.secTitle);
                    c1679b2 = c1679b;
                    view2 = inflate;
                }
                view2.setTag(c1679b2);
                inflate = view2;
                c1679b = c1679b2;
            } else {
                inflate = view2;
                c1679b = (C1679b) view2.getTag();
            }
            if (z) {
                C1702a c1702a = (C1702a) obj;
                if (TextUtils.isEmpty(c1702a.f4291d)) {
                    c1679b.f4227b.setImageResource(R.drawable.no_image);
                } else {
                    Bitmap a = TwitterList.f4231l.m6382a("" + c1702a.f4288a, c1702a.f4291d.toString());
                    if (a != null) {
                        c1679b.f4227b.setImageBitmap(a);
                    } else {
                        c1679b.f4227b.setImageResource(R.drawable.no_image);
                    }
                }
                c1679b.f4228c.setText(c1702a.f4290c);
                c1679b.f4229d.setText(c1702a.f4292e);
            } else {
                c1679b.f4228c.setText((String) obj);
            }
            return inflate;
        }
    }

    class C1679b {
        boolean f4226a;
        ImageView f4227b;
        TextView f4228c;
        TextView f4229d;
        final /* synthetic */ TwitterList f4230e;

        C1679b(TwitterList twitterList) {
            this.f4230e = twitterList;
        }
    }

    protected void mo1505o() {
        if (C1703d.f4298f.length == 0) {
            this.h = C1514b.m5647a((int) R.string.tweeter_err_nofriends);
            this.h.m5651a(this.f4233A);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
            return;
        }
        String str;
        if (C1703d.f4298f.length > C1703d.f4300i.size()) {
            str = "Not all friends are displayed";
            this.h = C1514b.m5647a((int) R.string.tweeter_err_uncomplete_list);
            this.h.m5651a(this.f4234B);
            this.h.show(getSupportFragmentManager(), "notice_dialog_tag");
        }
        Collections.sort(C1703d.f4300i, f4232z);
        String str2 = "";
        str = "";
        int i = 0;
        while (i < C1703d.f4300i.size()) {
            C1702a c1702a = (C1702a) C1703d.f4300i.get(i);
            char charAt = c1702a.f4290c.toUpperCase().charAt(0);
            String str3 = ((charAt <= 'Z' ? 1 : 0) & (charAt >= 'A' ? 1 : 0)) != 0 ? "" + c1702a.f4290c.toUpperCase().charAt(0) : "#";
            if (str2.equals(str3)) {
                str3 = str2;
            } else {
                this.f4237n.add(str3);
            }
            this.f4237n.add(c1702a);
            i++;
            str2 = str3;
        }
        this.f4235k.setOnItemClickListener(this);
        this.f4235k.setAdapter(new C1678a(this, this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m5021b((int) R.layout.sns);
        setRequestedOrientation(1);
        this.f4235k = (ListView) findViewById(R.id.friendsList);
        this.f4235k.setOnItemClickListener(this);
        this.f4236m = C0235c.m775a();
        long longExtra = getIntent().getLongExtra("USERID", -1);
        C1216a.m4522b("TWITLIST", "twitterid " + longExtra);
        if (longExtra != -1) {
            mo1505o();
            findViewById(R.id.btn_logout).setOnClickListener(new C16741(this));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object obj = this.f4237n.get(i);
        if (obj instanceof C1702a) {
            C1702a c1702a = (C1702a) obj;
            Intent intent = new Intent(this, TwitterPost.class);
            intent.putExtra("to", String.valueOf(c1702a.f4288a));
            intent.putExtra("name", String.valueOf(c1702a.f4290c));
            intent.putExtra("screenName", c1702a.f4289b);
            intent.putExtra("BODY", getIntent().getStringExtra("BODY"));
            intent.putExtra(NativeProtocol.METHOD_ARGS_IMAGE, getIntent().getStringExtra(NativeProtocol.METHOD_ARGS_IMAGE));
            startActivity(intent);
        }
    }

    protected void onResume() {
        super.onResume();
    }
}
