package com.telkom.mwallet.tcash.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.C0941a;
import com.google.android.gms.maps.C0943c;
import com.google.android.gms.maps.C0949g;
import com.google.android.gms.maps.model.MarkerOptions;
import com.telkom.mwallet.R;
import com.telkom.mwallet.home.C1385b;

public class C1795g extends C1385b {
    private static final String f4701a = C1795g.class.getSimpleName();
    private C0943c f4702b;

    public void m6886a(C0941a c0941a) {
        this.f4702b.m3230a(c0941a);
    }

    public void m6887a(MarkerOptions markerOptions) {
        this.f4702b.m3229a(markerOptions);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_tcash_map, null);
        m5209d(getActivity().getIntent().getIntExtra("TCASH_MAP_TITLE", R.string.title_tcash_find_retail_store));
        this.f4702b = ((C0949g) m5215l().findFragmentById(R.id.tcash_map_mapview)).m3255b();
        this.f4702b.m3231a(true);
        return inflate;
    }
}
