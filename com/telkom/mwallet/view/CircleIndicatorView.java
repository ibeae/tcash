package com.telkom.mwallet.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.telkom.mwallet.R;
import java.util.ArrayList;
import java.util.List;

public class CircleIndicatorView extends RadioGroup {
    private ViewPager f5819a = null;
    private int f5820b = 0;
    private List<RadioButton> f5821c;

    public CircleIndicatorView(Context context) {
        super(context);
        m8014b();
    }

    public CircleIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8014b();
    }

    private void m8014b() {
        setOrientation(0);
        this.f5821c = new ArrayList();
    }

    private void m8015c() {
        if (this.f5820b < this.f5821c.size()) {
            ((RadioButton) this.f5821c.get(this.f5820b)).setChecked(true);
            return;
        }
        this.f5820b = this.f5821c.size() - 1;
        ((RadioButton) this.f5821c.get(this.f5820b)).setChecked(true);
    }

    public void m8016a() {
        removeAllViews();
        this.f5821c.removeAll(this.f5821c);
        for (int i = 0; i < this.f5819a.getAdapter().getCount(); i++) {
            View radioButton = new RadioButton(getContext());
            radioButton.setButtonDrawable(R.drawable.indicator_selector);
            radioButton.setPadding(getResources().getDimensionPixelSize(R.dimen.card_viewpager_indicator_margin), 0, getResources().getDimensionPixelSize(R.dimen.card_viewpager_indicator_margin), 0);
            radioButton.setBackground(null);
            radioButton.setEnabled(false);
            this.f5821c.add(radioButton);
            addView(radioButton);
        }
        m8015c();
    }

    public void setCurrentItem(int i) {
        this.f5820b = i;
        m8015c();
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f5819a != viewPager && viewPager.getAdapter() != null) {
            this.f5819a = viewPager;
            m8016a();
        }
    }
}
