package com.telkom.mwallet.slidingframe;

import com.skcc.wallet.framework.api.http.model.Coupon;
import java.util.ArrayList;
import java.util.List;

public class C1727c {
    private static C1727c f4365a = new C1727c();
    private List<Coupon> f4366b = new ArrayList();

    public static C1727c m6488a() {
        return f4365a;
    }

    public void m6489a(List<Coupon> list) {
        this.f4366b = list;
    }

    public List<Coupon> m6490b() {
        return this.f4366b;
    }
}
