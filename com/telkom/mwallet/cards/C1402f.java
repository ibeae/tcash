package com.telkom.mwallet.cards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0087f;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.skcc.wallet.framework.api.http.model.LoyaltyCardDetail;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.C1503a;
import com.telkom.mwallet.dialog.C1518d.C1517c;
import com.telkom.mwallet.dialog.C1527g;
import com.telkom.mwallet.dialog.p063a.C1324e;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1354g;
import com.telkom.mwallet.tcash.fragment.C1386e;
import com.telkom.mwallet.view.CircleIndicatorView;
import java.util.ArrayList;
import java.util.List;

public class C1402f extends C1386e {
    private static final String f3116c = C1402f.class.getSimpleName();
    OnClickListener f3117a = new C13981(this);
    C0087f f3118b = new C13992(this);
    private Button f3119j;
    private Button f3120k;
    private Button f3121l;
    private TextView f3122m;
    private LinearLayout f3123n;
    private LinearLayout f3124o;
    private ViewPager f3125p;
    private CircleIndicatorView f3126q;
    private C1527g f3127r;
    private C1517c f3128s;
    private String f3129t;
    private List<LoyaltyCardDetail> f3130u;
    private C1395d f3131v;
    private CardListActivity f3132w;
    private C1324e f3133x = new C14003(this);
    private C1326f f3134y = new C14014(this);

    class C13981 implements OnClickListener {
        final /* synthetic */ C1402f f3112a;

        C13981(C1402f c1402f) {
            this.f3112a = c1402f;
        }

        public void onClick(View view) {
            LoyaltyCardDetail loyaltyCardDetail = (LoyaltyCardDetail) this.f3112a.f3130u.get(this.f3112a.f3125p.getCurrentItem());
            switch (view.getId()) {
                case R.id.card_list_delete:
                    this.f3112a.f3128s = C1517c.m5654a((int) R.string.will_delete_card);
                    this.f3112a.f3128s.m5656a(this.f3112a.f3134y);
                    this.f3112a.f3128s.m5657b(R.string.btn_yes);
                    this.f3112a.f3128s.m5658c(R.string.btn_no);
                    this.f3112a.f3128s.show(this.f3112a.getFragmentManager(), "notice_dialog_tag");
                    return;
                case R.id.card_list_redeem:
                    List arrayList = new ArrayList();
                    arrayList.add(this.f3112a.getString(R.string.redeem_type_qrcode));
                    arrayList.add(this.f3112a.getString(R.string.redeem_type_barcode));
                    this.f3112a.f3127r = C1527g.m5667a((int) R.string.redeem_type_select);
                    this.f3112a.f3127r.m5671a(arrayList);
                    this.f3112a.f3127r.m5670a(this.f3112a.f3133x);
                    this.f3112a.f3127r.show(this.f3112a.m5215l(), "list_dialog_tag");
                    return;
                case R.id.card_list_transaction_history_button:
                    Intent intent = new Intent(this.f3112a.getActivity(), CardTransactionHistoryActivity.class);
                    intent.putExtra("merchant_id", loyaltyCardDetail.getMerchantId());
                    intent.putExtra("card_id", loyaltyCardDetail.getLoyaltyCardNumber());
                    intent.putExtra("card_image_url", loyaltyCardDetail.getLoyaltyCardImageUrl());
                    this.f3112a.startActivity(intent);
                    return;
                case R.id.card_balance_refresh:
                    this.f3112a.m5257a(loyaltyCardDetail);
                    return;
                default:
                    return;
            }
        }
    }

    class C13992 implements C0087f {
        final /* synthetic */ C1402f f3113a;

        C13992(C1402f c1402f) {
            this.f3113a = c1402f;
        }

        public void mo1520a(int i) {
            this.f3113a.f3126q.setCurrentItem(i);
            this.f3113a.m5261b((LoyaltyCardDetail) this.f3113a.f3130u.get(i));
        }

        public void mo1521a(int i, float f, int i2) {
        }

        public void mo1522b(int i) {
        }
    }

    class C14003 implements C1324e {
        final /* synthetic */ C1402f f3114a;

        C14003(C1402f c1402f) {
            this.f3114a = c1402f;
        }

        public void mo1483a(int i) {
        }

        public void mo1484a(String str) {
            LoyaltyCardDetail loyaltyCardDetail = (LoyaltyCardDetail) this.f3114a.f3130u.get(this.f3114a.f3125p.getCurrentItem());
            C1503a c1503a = new C1503a();
            c1503a.m5629a(str);
            c1503a.m5630b(loyaltyCardDetail.getLoyaltyCardNumber());
            c1503a.show(this.f3114a.getFragmentManager(), "list_dialog_tag");
            this.f3114a.f3127r.dismiss();
        }
    }

    class C14014 implements C1326f {
        final /* synthetic */ C1402f f3115a;

        C14014(C1402f c1402f) {
            this.f3115a = c1402f;
        }

        public void mo1485a() {
            if (this.f3115a.f3128s != null) {
                this.f3115a.f3128s.dismiss();
            }
            LoyaltyCardDetail loyaltyCardDetail = (LoyaltyCardDetail) this.f3115a.f3130u.get(this.f3115a.f3125p.getCurrentItem());
            if (loyaltyCardDetail != null) {
                this.f3115a.f3132w.m5167a(loyaltyCardDetail.getLoyaltyCardInstanceId(), loyaltyCardDetail.getLoyaltyCardProfileNo(), loyaltyCardDetail.getMerchantId());
            }
        }

        public void mo1486b() {
            if (this.f3115a.f3128s != null) {
                this.f3115a.f3128s.dismiss();
            }
        }
    }

    private void m5257a(LoyaltyCardDetail loyaltyCardDetail) {
        if (loyaltyCardDetail != null) {
            this.f3132w.m5166a(loyaltyCardDetail.getLoyaltyCardNumber(), loyaltyCardDetail.getMerchantId());
        }
    }

    private void m5260b(View view) {
        this.f3125p = (ViewPager) view.findViewById(R.id.card_list_viewpager);
        this.f3126q = (CircleIndicatorView) view.findViewById(R.id.card_list_indicator);
        this.f3119j = (Button) view.findViewById(R.id.card_list_transaction_history_button);
        this.f3120k = (Button) view.findViewById(R.id.card_list_redeem);
        this.f3121l = (Button) view.findViewById(R.id.card_list_delete);
        this.f3122m = (TextView) view.findViewById(R.id.card_list_balance_txt);
        this.f3123n = (LinearLayout) view.findViewById(R.id.card_list_empty_linear);
        this.f3124o = (LinearLayout) view.findViewById(R.id.card_list_action_menu_linear);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.card_balance_refresh);
        this.f3131v = new C1395d(getChildFragmentManager());
        this.f3125p.setAdapter(this.f3131v);
        this.f3125p.setOffscreenPageLimit(2);
        this.f3125p.setClipToPadding(false);
        this.f3125p.setOnPageChangeListener(this.f3118b);
        this.f3126q.setViewPager(this.f3125p);
        this.f3119j.setOnClickListener(this.f3117a);
        this.f3120k.setOnClickListener(this.f3117a);
        this.f3121l.setOnClickListener(this.f3117a);
        imageButton.setOnClickListener(this.f3117a);
    }

    private void m5261b(LoyaltyCardDetail loyaltyCardDetail) {
        if (loyaltyCardDetail != null) {
            String b = this.i.m4538b(loyaltyCardDetail.getLoyaltyCardNumber(), "");
            if (b == null || b.length() == 0) {
                this.f3132w.m5166a(loyaltyCardDetail.getLoyaltyCardNumber(), loyaltyCardDetail.getMerchantId());
            } else {
                m5271b(b);
            }
        }
    }

    public void m5270a(List<LoyaltyCardDetail> list) {
        this.f3130u = list;
        if (this.f3125p != null && this.f3131v != null) {
            this.f3125p.setVisibility(0);
            this.f3126q.setVisibility(0);
            this.f3131v.m5245a(list);
            this.f3131v.notifyDataSetChanged();
            this.f3126q.m8016a();
            if (this.f3130u == null || this.f3130u.size() <= 0) {
                this.f3123n.setVisibility(0);
                this.f3124o.setVisibility(8);
            } else {
                if (this.f3129t != null && this.f3129t.length() != 0) {
                    for (int i = 0; i < this.f3130u.size(); i++) {
                        if (this.f3129t.equals(((LoyaltyCardDetail) list.get(i)).getLoyaltyCardNumber())) {
                            this.f3125p.setCurrentItem(i);
                            break;
                        }
                    }
                }
                m5261b((LoyaltyCardDetail) list.get(this.f3125p.getCurrentItem()));
                this.f3123n.setVisibility(8);
                this.f3124o.setVisibility(0);
            }
            this.f3129t = "";
        }
    }

    public void m5271b(String str) {
        if (this.f3122m != null) {
            this.f3122m.setText(C1354g.m4957h(str));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3132w = (CardListActivity) getActivity();
        this.f3129t = this.f3132w.getIntent().getStringExtra("card_id");
        View inflate = layoutInflater.inflate(R.layout.activity_card_list, null);
        m5208c(R.string.title_cardlist);
        m5260b(inflate);
        return inflate;
    }
}
