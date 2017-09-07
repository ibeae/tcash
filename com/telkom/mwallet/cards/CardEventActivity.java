package com.telkom.mwallet.cards;

import android.os.Bundle;
import android.os.Vibrator;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.slidingframe.SlidingFrameActivity;

public class CardEventActivity extends SlidingFrameActivity {
    private static final String f3007k = CardEventActivity.class.getSimpleName();
    private Vibrator f3008l;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1216a.m4519a(f3007k, " in onCreate >>>>>");
        setContentView(R.layout.activity_card_event);
        m5023d((int) R.string.title_cardlist);
        this.f3008l = (Vibrator) getSystemService("vibrator");
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3007k, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3007k, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3007k, " in onResume >>>>>");
        this.f3008l.vibrate(500);
    }
}
