package com.telkom.mwallet.tcash.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.google.android.gms.maps.C0949g;

public class TransparentSupportMapFragment extends C0949g {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        View frameLayout = new FrameLayout(getActivity());
        frameLayout.setBackgroundColor(getResources().getColor(17170445));
        ((ViewGroup) onCreateView).addView(frameLayout, new LayoutParams(-1, -1));
        return onCreateView;
    }
}
