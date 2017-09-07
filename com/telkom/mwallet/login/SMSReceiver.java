package com.telkom.mwallet.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.telkom.mwallet.R;

public class SMSReceiver extends BroadcastReceiver {
    private C1604b f3839a;

    public SMSReceiver(C1604b c1604b) {
        this.f3839a = c1604b;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                Object[] objArr = (Object[]) extras.get("pdus");
                if (objArr != null) {
                    String str = "";
                    str = "";
                    SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                    CharSequence string = context.getString(R.string.smshead_en);
                    CharSequence string2 = context.getString(R.string.smshead_id);
                    for (int i = 0; i < objArr.length; i++) {
                        smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i]);
                        str = smsMessageArr[i].getDisplayMessageBody();
                        if (str.contains(string) || str.contains(string2)) {
                            this.f3839a.mo1534a(str);
                            return;
                        }
                    }
                }
            }
        }
    }
}
