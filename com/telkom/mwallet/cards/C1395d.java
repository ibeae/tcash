package com.telkom.mwallet.cards;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.skcc.wallet.framework.api.http.model.LoyaltyCardDetail;
import java.util.List;

public class C1395d extends FragmentStatePagerAdapter {
    private List<LoyaltyCardDetail> f3095a;

    public C1395d(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void m5245a(List<LoyaltyCardDetail> list) {
        this.f3095a = list;
    }

    public int getCount() {
        return (this.f3095a == null || this.f3095a.size() == 0) ? 1 : this.f3095a.size();
    }

    public Fragment getItem(int i) {
        if (this.f3095a == null || this.f3095a.size() == 0) {
            return new C1394c();
        }
        Fragment c1404h = new C1404h();
        c1404h.m5278a((LoyaltyCardDetail) this.f3095a.get(i));
        return c1404h;
    }

    public int getItemPosition(Object obj) {
        return -2;
    }
}
