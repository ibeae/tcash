package com.telkom.mwallet.coupon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.http.model.Coupon;
import com.skcc.wallet.framework.api.http.model.CouponDetail;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1527g;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.home.C1385b;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h.C1355a;
import com.telkom.mwallet.p064a.C1358h.C1356b;
import com.telkom.mwallet.p064a.C1358h.C1357c;
import java.util.ArrayList;
import java.util.List;
import twitter4j.MediaEntity.Size;

public class C1457c extends C1385b {
    public static final String f3394a = C1457c.class.getSimpleName();
    private List<Coupon> f3395A;
    private OnClickListener f3396B = new C14471(this);
    private C1324e f3397C = new C14482(this);
    private OnItemClickListener f3398D = new C14493(this);
    private OnScrollListener f3399E = new C14504(this);
    private final int f3400b = 0;
    private final int f3401c = 10;
    private FragmentManager f3402j;
    private Button f3403k;
    private Button f3404l;
    private Button f3405m;
    private ImageView f3406n;
    private ListView f3407o;
    private ScrollView f3408p;
    private List<Coupon> f3409q = null;
    private List<CouponDetail> f3410r = null;
    private C1452a f3411s = null;
    private C1527g f3412t;
    private int f3413u = 100;
    private String f3414v = "";
    private String f3415w = "";
    private int f3416x = 0;
    private int f3417y = 0;
    private CouponListActivity f3418z;

    class C14471 implements OnClickListener {
        final /* synthetic */ C1457c f3364a;

        C14471(C1457c c1457c) {
            this.f3364a = c1457c;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.couponlist_couponlist_button:
                    if (this.f3364a.f3413u == 100) {
                        this.f3364a.f3418z.m5390e(C1355a.f2919a);
                    }
                    this.f3364a.f3413u = 100;
                    this.f3364a.f3418z.m5392p();
                    this.f3364a.f3404l.setSelected(true);
                    this.f3364a.f3403k.setSelected(false);
                    this.f3364a.f3406n.setEnabled(true);
                    this.f3364a.f3405m.setEnabled(false);
                    this.f3364a.h.m4932a(this.f3364a.f3418z, this.f3364a.f3404l, 3);
                    this.f3364a.h.m4932a(this.f3364a.f3418z, this.f3364a.f3403k, 2);
                    return;
                case R.id.couponlist_couponlist_picker_imageview:
                    this.f3364a.f3412t.show(this.f3364a.f3402j, "list_dialog_tag");
                    return;
                case R.id.couponlist_mycoupon_button:
                    if (this.f3364a.f3413u != Size.CROP) {
                        this.f3364a.f3413u = Size.CROP;
                        this.f3364a.f3418z.mo1505o();
                        this.f3364a.f3404l.setSelected(false);
                        this.f3364a.f3403k.setSelected(true);
                        this.f3364a.f3406n.setEnabled(false);
                        this.f3364a.f3405m.setEnabled(true);
                        this.f3364a.h.m4932a(this.f3364a.f3418z, this.f3364a.f3403k, 3);
                        this.f3364a.h.m4932a(this.f3364a.f3418z, this.f3364a.f3404l, 2);
                        return;
                    }
                    return;
                case R.id.couponlist_mycoupon_picker_button:
                    this.f3364a.f3412t.show(this.f3364a.f3402j, "list_dialog_tag");
                    return;
                default:
                    return;
            }
        }
    }

    class C14482 implements C1324e {
        final /* synthetic */ C1457c f3365a;

        C14482(C1457c c1457c) {
            this.f3365a = c1457c;
        }

        public void mo1483a(int i) {
        }

        public void mo1484a(String str) {
            if (this.f3365a.f3412t != null) {
                this.f3365a.f3412t.dismiss();
            }
            if ("Nearby".equals(str)) {
                this.f3365a.f3418z.m5390e(C1355a.f2920b);
            } else if ("Latest".equals(str)) {
                this.f3365a.f3418z.m5390e(C1355a.f2921c);
            }
            this.f3365a.f3418z.m5392p();
        }
    }

    class C14493 implements OnItemClickListener {
        final /* synthetic */ C1457c f3366a;

        C14493(C1457c c1457c) {
            this.f3366a = c1457c;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f3366a.m5521a(i);
        }
    }

    class C14504 implements OnScrollListener {
        int f3367a;
        int f3368b;
        final /* synthetic */ C1457c f3369c;

        C14504(C1457c c1457c) {
            this.f3369c = c1457c;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.f3367a = i + i2;
            this.f3368b = i3;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && this.f3367a == this.f3368b) {
                C1216a.m4519a(C1457c.f3394a, "totalItem : " + this.f3368b + ", startNumber : " + this.f3369c.f3416x);
                if (this.f3369c.f3417y == 10 && this.f3369c.f3413u != Size.CROP && this.f3369c.f3413u == 100) {
                    this.f3369c.f3418z.m5383a(this.f3369c.f3416x);
                }
            }
        }
    }

    private class C1452a extends ArrayAdapter<Coupon> {
        final /* synthetic */ C1457c f3375a;
        private final LayoutInflater f3376b;
        private final int f3377c;
        private List<?> f3378d;

        class C1451a {
            ImageView f3370a;
            TextView f3371b;
            TextView f3372c;
            TextView f3373d;
            final /* synthetic */ C1452a f3374e;

            C1451a(C1452a c1452a) {
                this.f3374e = c1452a;
            }
        }

        public C1452a(C1457c c1457c, Context context, int i) {
            this.f3375a = c1457c;
            super(context, i);
            this.f3377c = i;
            this.f3376b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        protected void m5491a(List<?> list) {
            this.f3378d = list;
        }

        public int getCount() {
            return this.f3378d == null ? 0 : this.f3378d.size();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C1451a c1451a;
            if (view == null) {
                view = this.f3376b.inflate(this.f3377c, viewGroup, false);
                C1451a c1451a2 = new C1451a(this);
                c1451a2.f3370a = (ImageView) view.findViewById(R.id.coupon_listitem_imageview);
                c1451a2.f3371b = (TextView) view.findViewById(R.id.coupon_listitem_title);
                c1451a2.f3372c = (TextView) view.findViewById(R.id.coupon_listitem_desc);
                c1451a2.f3373d = (TextView) view.findViewById(R.id.coupon_listitem_date);
                view.setTag(c1451a2);
                c1451a = c1451a2;
            } else {
                c1451a = (C1451a) view.getTag();
            }
            String str = "";
            String str2 = "";
            String str3 = "";
            Coupon coupon = (Coupon) this.f3378d.get(i);
            if (coupon.getCampaignEndDate() != null) {
                str = C1354g.m4954e(coupon.getCampaignEndDate());
                if (coupon instanceof CouponDetail) {
                    str2 = C1354g.m4954e(((CouponDetail) coupon).getRedeemDtim());
                    str3 = C1354g.m4954e(((CouponDetail) coupon).getCouponExpiryDate());
                }
                c1451a.f3373d.setVisibility(0);
            }
            c1451a.f3371b.setText(coupon.getCampaignTitle());
            c1451a.f3372c.setText(coupon.getCampaignShortDescription());
            c1451a.f3373d.setText("Expires on " + str);
            c1451a.f3373d.setTextColor(this.f3375a.getResources().getColor(R.color.n_darkgray));
            this.f3375a.h.m4932a(this.f3375a.f3418z, c1451a.f3371b, 3);
            this.f3375a.h.m4932a(this.f3375a.f3418z, c1451a.f3372c, 1);
            this.f3375a.h.m4932a(this.f3375a.f3418z, c1451a.f3373d, 1);
            C1216a.m4522b(C1457c.f3394a, " coupon item name " + coupon.getCampaignTitle());
            this.f3375a.f3418z.m5386a(coupon.getCouponImageUrl(), c1451a.f3370a);
            if (C1356b.f2922a.equals(coupon.getCouponStatus())) {
                String couponUserStatus = coupon.getCouponUserStatus();
                if (couponUserStatus == null || couponUserStatus.isEmpty() || couponUserStatus.equals(C1357c.f2927c)) {
                    c1451a.f3373d.setText("Expires on " + str);
                    c1451a.f3373d.setTextColor(this.f3375a.getResources().getColor(R.color.n_darkgray));
                } else if (!(couponUserStatus.equals(C1357c.f2925a) || couponUserStatus.equals(C1357c.f2929e))) {
                    if (couponUserStatus.equals(C1357c.f2926b)) {
                        c1451a.f3373d.setText("Redeemed on " + str2);
                        c1451a.f3373d.setTextColor(this.f3375a.getResources().getColor(R.color.n_green));
                    } else {
                        c1451a.f3373d.setText("Expired on " + str3);
                        c1451a.f3373d.setTextColor(this.f3375a.getResources().getColor(R.color.n_red));
                    }
                }
            } else if (C1356b.f2923b.equals(coupon.getCouponStatus())) {
                if (C1357c.f2926b.equals(coupon.getCouponUserStatus())) {
                    c1451a.f3373d.setText("Redeemed on " + str2);
                    c1451a.f3373d.setTextColor(this.f3375a.getResources().getColor(R.color.n_green));
                } else {
                    c1451a.f3373d.setText("Expires on " + str);
                    c1451a.f3373d.setTextColor(this.f3375a.getResources().getColor(R.color.n_darkgray));
                }
            } else if (C1356b.f2924c.equals(coupon.getCouponStatus())) {
                c1451a.f3373d.setText("Redeemed on " + str3);
                c1451a.f3373d.setTextColor(this.f3375a.getResources().getColor(R.color.n_green));
            }
            return view;
        }
    }

    protected void m5521a(int i) {
        Intent intent = new Intent(this.f3418z, CouponDetailActivity.class);
        intent.putExtra("COUPONMODE", this.f3413u);
        intent.putExtra("COUPONINDEX", i);
        if (this.f3413u == 100) {
            Coupon coupon = (Coupon) this.f3409q.get(i);
            intent.putExtra("CampaignId", coupon.getCampaignId());
            intent.putExtra("MerchantId", coupon.getMerchantId());
            intent.putExtra("couponProfileNo", coupon.getCouponProfileNo());
        } else if (this.f3410r != null) {
            CouponDetail couponDetail = (CouponDetail) this.f3410r.get(i);
            intent.putExtra("CampaignId", couponDetail.getCampaignId());
            intent.putExtra("MerchantId", couponDetail.getMerchantId());
            intent.putExtra("couponProfileNo", couponDetail.getCouponProfileNo());
        } else {
            return;
        }
        startActivity(intent);
    }

    public void m5522a(List<CouponDetail> list) {
        this.f3410r.clear();
        if (list == null) {
            this.f3417y = 0;
        } else {
            this.f3417y = list.size();
            this.f3410r.addAll(list);
        }
        if (list == null && this.f3417y == 0) {
            this.f3407o.setVisibility(8);
            this.f3408p.setVisibility(0);
        } else {
            this.f3407o.setVisibility(0);
            this.f3408p.setVisibility(8);
        }
        this.f3411s.m5491a(this.f3410r);
        this.f3411s.notifyDataSetChanged();
    }

    public void m5523b(int i) {
        this.f3407o.setSelection(i);
    }

    public void m5524b(List<Coupon> list) {
        if (this.f3407o == null) {
            this.f3395A = list;
            return;
        }
        if (list == null) {
            this.f3417y = 0;
        } else {
            this.f3417y = list.size();
            this.f3409q.addAll(list);
            this.f3416x++;
        }
        if (list == null && this.f3417y == 0) {
            m5218o();
            this.f3409q.clear();
            this.f3411s.m5491a(this.f3409q);
            this.f3411s.notifyDataSetChanged();
            this.f3407o.setVisibility(8);
            this.f3408p.setVisibility(0);
            return;
        }
        this.f3407o.setVisibility(0);
        this.f3408p.setVisibility(8);
        this.f3411s.m5491a(this.f3409q);
        this.f3411s.notifyDataSetChanged();
    }

    void m5525d() {
        this.f3413u = Size.CROP;
        if (!(this.f3410r == null || this.f3410r.size() == 0)) {
            m5523b(0);
        }
        this.f3404l.setSelected(false);
        this.f3403k.setSelected(true);
        this.f3406n.setEnabled(false);
        this.f3405m.setEnabled(true);
        this.h.m4932a(this.f3418z, this.f3403k, 3);
        this.h.m4932a(this.f3418z, this.f3404l, 1);
        this.f3410r.clear();
    }

    void m5526e() {
        this.f3416x = 0;
        if (!(this.f3409q == null || this.f3409q.size() == 0)) {
            m5523b(0);
        }
        this.f3409q.clear();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_coupon_list, null);
        m5208c(R.string.title_couponlist);
        this.f3418z = (CouponListActivity) getActivity();
        m5201a(inflate);
        this.f3402j = m5215l();
        this.f3404l = (Button) inflate.findViewById(R.id.couponlist_couponlist_button);
        this.f3406n = (ImageView) inflate.findViewById(R.id.couponlist_couponlist_picker_imageview);
        this.f3403k = (Button) inflate.findViewById(R.id.couponlist_mycoupon_button);
        this.f3405m = (Button) inflate.findViewById(R.id.couponlist_mycoupon_picker_button);
        this.f3404l.setOnClickListener(this.f3396B);
        this.f3406n.setOnClickListener(this.f3396B);
        this.f3403k.setOnClickListener(this.f3396B);
        this.f3405m.setOnClickListener(this.f3396B);
        this.f3404l.setSelected(true);
        this.f3407o = (ListView) inflate.findViewById(R.id.couponlist_listview);
        this.f3408p = (ScrollView) inflate.findViewById(R.id.couponlist_nodata_scrollview);
        this.f3411s = new C1452a(this, this.f3418z, R.layout.view_coupon_listitem);
        this.f3407o.setAdapter(this.f3411s);
        this.f3407o.setOnScrollListener(this.f3399E);
        this.f3407o.setOnItemClickListener(this.f3398D);
        this.f3409q = new ArrayList();
        this.f3410r = new ArrayList();
        this.f3412t = C1527g.m5667a((int) R.string.title_list_dialog);
        List arrayList = new ArrayList();
        arrayList.add(getString(R.string.list_dialog_coupon_item1));
        arrayList.add(getString(R.string.list_dialog_coupon_item2));
        this.f3412t.m5671a(arrayList);
        this.f3412t.m5670a(this.f3397C);
        this.h.m4932a(this.f3418z, this.f3404l, 3);
        this.h.m4932a(this.f3418z, this.f3403k, 2);
        if (this.f3395A != null) {
            m5524b(this.f3395A);
        }
        return inflate;
    }
}
