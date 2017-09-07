package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.C0658a;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.internal.au.C0685a;
import com.google.android.gms.p027a.C0651c;
import com.google.android.gms.p027a.C0654d;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public final class ay extends C0685a {
    private final MediationAdapter f982a;

    public ay(MediationAdapter mediationAdapter) {
        this.f982a = mediationAdapter;
    }

    private Bundle m1625a(String str, int i, String str2) {
        dq.m2120e("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    bundle2.putString(str3, jSONObject.getString(str3));
                }
                bundle = bundle2;
            }
            if (this.f982a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            dq.m2118c("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C0651c mo885a() {
        if (this.f982a instanceof MediationBannerAdapter) {
            try {
                return C0654d.m1384a(((MediationBannerAdapter) this.f982a).getBannerView());
            } catch (Throwable th) {
                dq.m2118c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dq.m2120e("MediationAdapter is not a MediationBannerAdapter: " + this.f982a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void mo886a(C0651c c0651c, ai aiVar, String str, av avVar) {
        mo887a(c0651c, aiVar, str, null, avVar);
    }

    public void mo887a(C0651c c0651c, ai aiVar, String str, String str2, av avVar) {
        Bundle bundle = null;
        if (this.f982a instanceof MediationInterstitialAdapter) {
            dq.m2112a("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f982a;
                ax axVar = new ax(new Date(aiVar.f892b), aiVar.f894d, aiVar.f895e != null ? new HashSet(aiVar.f895e) : null, aiVar.f896f, aiVar.f897g);
                if (aiVar.f903m != null) {
                    bundle = aiVar.f903m.getBundle(mediationInterstitialAdapter.getClass().getName());
                }
                mediationInterstitialAdapter.requestInterstitialAd((Context) C0654d.m1385a(c0651c), new az(avVar), m1625a(str, aiVar.f897g, str2), axVar, bundle);
            } catch (Throwable th) {
                dq.m2118c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dq.m2120e("MediationAdapter is not a MediationInterstitialAdapter: " + this.f982a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void mo888a(C0651c c0651c, al alVar, ai aiVar, String str, av avVar) {
        mo889a(c0651c, alVar, aiVar, str, null, avVar);
    }

    public void mo889a(C0651c c0651c, al alVar, ai aiVar, String str, String str2, av avVar) {
        Bundle bundle = null;
        if (this.f982a instanceof MediationBannerAdapter) {
            dq.m2112a("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f982a;
                ax axVar = new ax(new Date(aiVar.f892b), aiVar.f894d, aiVar.f895e != null ? new HashSet(aiVar.f895e) : null, aiVar.f896f, aiVar.f897g);
                if (aiVar.f903m != null) {
                    bundle = aiVar.f903m.getBundle(mediationBannerAdapter.getClass().getName());
                }
                mediationBannerAdapter.requestBannerAd((Context) C0654d.m1385a(c0651c), new az(avVar), m1625a(str, aiVar.f897g, str2), C0658a.m1409a(alVar.f925f, alVar.f922c, alVar.f921b), axVar, bundle);
            } catch (Throwable th) {
                dq.m2118c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dq.m2120e("MediationAdapter is not a MediationBannerAdapter: " + this.f982a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void mo890b() {
        if (this.f982a instanceof MediationInterstitialAdapter) {
            dq.m2112a("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f982a).showInterstitial();
            } catch (Throwable th) {
                dq.m2118c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dq.m2120e("MediationAdapter is not a MediationInterstitialAdapter: " + this.f982a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void mo891c() {
        try {
            this.f982a.onDestroy();
        } catch (Throwable th) {
            dq.m2118c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo892d() {
        try {
            this.f982a.onPause();
        } catch (Throwable th) {
            dq.m2118c("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo893e() {
        try {
            this.f982a.onResume();
        } catch (Throwable th) {
            dq.m2118c("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }
}
