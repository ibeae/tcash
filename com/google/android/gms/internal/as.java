package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.at.C0682a;
import java.util.Map;

public final class as extends C0682a {
    private Map<Class<? extends Object>, Object> f958a;

    private <NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> au m1592b(String str) {
        try {
            Class cls = Class.forName(str, false, as.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                return new ba(mediationAdapter, (NetworkExtras) this.f958a.get(mediationAdapter.getAdditionalParametersType()));
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new ay((com.google.android.gms.ads.mediation.MediationAdapter) cls.newInstance());
            } else {
                dq.m2120e("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
                throw new RemoteException();
            }
        } catch (Throwable th) {
            dq.m2120e("Could not instantiate mediation adapter: " + str + ". " + th.getMessage());
            RemoteException remoteException = new RemoteException();
        }
    }

    public au mo884a(String str) {
        return m1592b(str);
    }

    public void m1594a(Map<Class<? extends Object>, Object> map) {
        this.f958a = map;
    }
}
