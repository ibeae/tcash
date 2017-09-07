package com.telkom.mwallet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.telkom.mwallet.service.C1610a;

public class CardActivationCheckReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, C1610a.class));
    }
}
