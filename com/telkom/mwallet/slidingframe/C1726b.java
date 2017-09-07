package com.telkom.mwallet.slidingframe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.AppEventsConstants;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.cards.CardListActivity;
import com.telkom.mwallet.coupon.CouponListActivity;
import com.telkom.mwallet.home.C1385b;
import com.telkom.mwallet.home.HomeActivity;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.setting.PromotionActivity;
import com.telkom.mwallet.setting.SettingMainActivity;
import com.telkom.mwallet.setting.TWalletNewsActivity;
import com.telkom.mwallet.setting.tcash.TCashFavoriteListActivity;
import com.telkom.mwallet.tcash.TCashActivity;
import com.telkom.mwallet.tcash.TCashTransactionHistoryActivity;
import com.telkom.mwallet.tcash.tap.TCashTapActivity;
import java.util.ArrayList;
import java.util.List;

public class C1726b extends C1385b {
    private List<C1724c> f4359a;
    private GridView f4360b;
    private TextView f4361c;
    private TextView f4362j;
    private TextView f4363k;
    private String f4364l;

    class C17211 implements OnClickListener {
        final /* synthetic */ C1726b f4347a;

        C17211(C1726b c1726b) {
            this.f4347a = c1726b;
        }

        public void onClick(View view) {
            Intent intent = new Intent(this.f4347a.e, TWalletNewsActivity.class);
            intent.setFlags(536870912);
            this.f4347a.startActivity(intent);
            this.f4347a.e.m5017C();
        }
    }

    protected class C1722a implements OnItemClickListener {
        final /* synthetic */ C1726b f4348a;

        protected C1722a(C1726b c1726b) {
            this.f4348a = c1726b;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent;
            switch (i) {
                case 0:
                    this.f4348a.e.m5016B();
                    this.f4348a.e.m5017C();
                    return;
                case 1:
                    if (!TCashActivity.class.getSimpleName().equals(this.f4348a.e.getClass().getSimpleName())) {
                        intent = new Intent(this.f4348a.e, TCashActivity.class);
                        break;
                    } else {
                        this.f4348a.e.m5017C();
                        return;
                    }
                case 2:
                    if (!TCashFavoriteListActivity.class.getSimpleName().equals(this.f4348a.e.getClass().getSimpleName())) {
                        intent = new Intent(this.f4348a.e, TCashFavoriteListActivity.class);
                        break;
                    } else {
                        this.f4348a.e.m5017C();
                        return;
                    }
                case 3:
                    if (CardListActivity.class.getSimpleName().equals(this.f4348a.e.getClass().getSimpleName())) {
                        this.f4348a.e.m5017C();
                        return;
                    }
                    this.f4348a.e.m5017C();
                    this.f4348a.m5213f(R.string.under_construction);
                    return;
                case 4:
                    if (!CouponListActivity.class.getSimpleName().equals(this.f4348a.e.getClass().getSimpleName())) {
                        intent = new Intent(this.f4348a.e, CouponListActivity.class);
                        break;
                    } else {
                        this.f4348a.e.m5017C();
                        return;
                    }
                case 5:
                    if (!PromotionActivity.class.getSimpleName().equals(this.f4348a.e.getClass().getSimpleName())) {
                        intent = new Intent(this.f4348a.e, PromotionActivity.class);
                        break;
                    } else {
                        this.f4348a.e.m5017C();
                        return;
                    }
                case 6:
                    if (!TCashTransactionHistoryActivity.class.getSimpleName().equals(this.f4348a.e.getClass().getSimpleName())) {
                        intent = new Intent(this.f4348a.e, TCashTransactionHistoryActivity.class);
                        break;
                    } else {
                        this.f4348a.e.m5017C();
                        return;
                    }
                case 7:
                    if (!TCashTapActivity.class.getSimpleName().equals(this.f4348a.e.getClass().getSimpleName())) {
                        intent = new Intent(this.f4348a.e, TCashTapActivity.class);
                        break;
                    } else {
                        this.f4348a.e.m5017C();
                        return;
                    }
                case 8:
                    if (!SettingMainActivity.class.getSimpleName().equals(this.f4348a.e.getClass().getSimpleName())) {
                        intent = new Intent(this.f4348a.e, SettingMainActivity.class);
                        break;
                    } else {
                        this.f4348a.e.m5017C();
                        return;
                    }
                default:
                    intent = new Intent(this.f4348a.e, HomeActivity.class);
                    break;
            }
            intent.setFlags(536870912);
            this.f4348a.startActivity(intent);
            this.f4348a.e.m5017C();
            if (!HomeActivity.class.getSimpleName().equals(this.f4348a.e.getClass().getSimpleName())) {
                this.f4348a.e.finish();
            }
        }
    }

    protected class C1723b extends ArrayAdapter<C1724c> {
        C1725d f4349a;
        final /* synthetic */ C1726b f4350b;
        private Context f4351c;
        private List<C1724c> f4352d;

        public C1723b(C1726b c1726b, Context context, int i, List<C1724c> list) {
            this.f4350b = c1726b;
            super(context, i, list);
            this.f4351c = context;
            this.f4352d = list;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater) this.f4351c.getSystemService("layout_inflater")).inflate(R.layout.view_frame_drawer_left_menu_listitem, null);
                this.f4349a = new C1725d();
                this.f4349a.f4356a = (ImageView) view.findViewById(R.id.navi_item_img);
                this.f4349a.f4357b = (TextView) view.findViewById(R.id.navi_item_title);
                view.setTag(this.f4349a);
            } else {
                this.f4349a = (C1725d) view.getTag();
            }
            this.f4349a.f4356a.setImageResource(((C1724c) this.f4352d.get(i)).f4354b);
            this.f4349a.f4357b.setText(((C1724c) this.f4352d.get(i)).f4355c);
            this.f4350b.h.m4932a(this.f4350b.e, this.f4349a.f4357b, 2);
            return view;
        }
    }

    private class C1724c {
        final /* synthetic */ C1726b f4353a;
        private int f4354b;
        private String f4355c;

        private C1724c(C1726b c1726b, int i, String str) {
            this.f4353a = c1726b;
            this.f4354b = i;
            this.f4355c = str;
        }
    }

    private class C1725d {
        ImageView f4356a;
        TextView f4357b;
        final /* synthetic */ C1726b f4358c;

        private C1725d(C1726b c1726b) {
            this.f4358c = c1726b;
        }
    }

    private void m6456c(String str) {
        C1216a.m4522b("COUNT", "displayInboxCount " + str);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
            this.f4362j.setVisibility(8);
            return;
        }
        this.f4362j.setVisibility(0);
        this.f4362j.setText(str);
    }

    private String m6461g() {
        if (this.e == null) {
            this.e = (SlidingFrameActivity) getActivity();
        }
        if (this.g == null) {
            this.g = this.e.m4984e();
        }
        return this.g.m4651b("msisdn", "");
    }

    private String m6463h() {
        if (this.e == null) {
            this.e = (SlidingFrameActivity) getActivity();
        }
        if (this.g == null) {
            this.g = this.e.m4984e();
        }
        String b = this.g.m4651b("user_info_firstname", "");
        String b2 = this.g.m4651b("user_info_lastname", "");
        C1216a.m4519a("BaseFragment", "name = " + b + " " + b2);
        return C1354g.m4961l(b) + " " + C1354g.m4961l(b2);
    }

    private void m6465i() {
        if (this.e == null) {
            this.e = (SlidingFrameActivity) getActivity();
        }
        if (this.d == null) {
            this.d = this.e.m5027y();
        }
    }

    public void mo1490a(String str, Object obj) {
        C1216a.m4519a("BaseFragment", "onSuccessNetwork");
        this.g.m4647a("time for update", System.currentTimeMillis());
    }

    public void m6484b(String str) {
        this.f4364l = str;
        C1216a.m4519a("BaseFragment", str);
        if ("FULL_SERVICE".equalsIgnoreCase(str)) {
            this.f4363k.setText(R.string.full_service);
        } else if ("BASIC_SERVICE".equalsIgnoreCase(str)) {
            this.f4363k.setText(R.string.basic_service);
        } else {
            this.f4363k.setText(R.string.basic_service);
        }
    }

    public void m6485d() {
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    void m6486e() {
        this.f4359a = new ArrayList();
        this.f4359a.add(new C1724c(R.drawable.img_navmenu01, getString(R.string.navi_menu_home)));
        this.f4359a.add(new C1724c(R.drawable.img_navmenu02, getString(R.string.str_tcash)));
        this.f4359a.add(new C1724c(R.drawable.img_navmenu03, getString(R.string.navi_menu_favorite)));
        this.f4359a.add(new C1724c(R.drawable.img_navmenu04, getString(R.string.navi_menu_card)));
        this.f4359a.add(new C1724c(R.drawable.img_navmenu05, getString(R.string.navi_menu_coupons)));
        this.f4359a.add(new C1724c(R.drawable.img_navmenu06, getString(R.string.navi_menu_promotion)));
        this.f4359a.add(new C1724c(R.drawable.ic_sidemenu_history, getString(R.string.navi_menu_history)));
        this.f4359a.add(new C1724c(R.drawable.img_navmenu09, getString(R.string.tcash_tap)));
        this.f4359a.add(new C1724c(R.drawable.img_navmenu07, getString(R.string.navi_menu_setting)));
    }

    public void m6487f() {
        long b = this.g.m4650b(C1358h.f2935f, -1);
        if (b <= 0) {
            m6465i();
        } else if (System.currentTimeMillis() - b > 108000000) {
            m6465i();
        } else {
            m6456c(this.g.m4651b(C1358h.f2934e, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m6486e();
        View inflate = layoutInflater.inflate(R.layout.slide_menu_navi, null);
        this.f4360b = (GridView) inflate.findViewById(R.id.drawer_menu);
        this.f4360b.setAdapter(new C1723b(this, getActivity(), R.layout.view_frame_drawer_left_menu_listitem, this.f4359a));
        this.f4360b.setOnItemClickListener(new C1722a(this));
        View view = (TextView) inflate.findViewById(R.id.navi_user_phonenum);
        this.f4361c = (TextView) inflate.findViewById(R.id.navi_user_name);
        this.f4362j = (TextView) inflate.findViewById(R.id.index_new_count);
        this.f4363k = (TextView) inflate.findViewById(R.id.tvKyc);
        m6484b(this.g.m4651b("TCASH_STATUS", ""));
        view.setText(m6461g());
        View view2 = (TextView) inflate.findViewById(R.id.inbox_title);
        ((LinearLayout) inflate.findViewById(R.id.inbox_linear)).setOnClickListener(new C17211(this));
        if (this.e == null) {
            this.e = (SlidingFrameActivity) getActivity();
        }
        if (this.h == null) {
            this.h = this.e.m4982d();
        }
        this.h.m4932a(getActivity(), this.f4361c, 3);
        this.h.m4932a(getActivity(), view, 1);
        this.h.m4932a(getActivity(), view2, 2);
        m6456c(this.g.m4651b(C1358h.f2934e, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        return inflate;
    }

    public void onResume() {
        super.onResume();
        C1216a.m4519a("BaseFragment", "onResume");
        this.f4361c.setText(m6463h());
    }
}
