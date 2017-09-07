package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.au.C0685a;
import com.google.android.gms.p027a.C0651c;
import com.google.android.gms.p027a.C0654d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class ba<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C0685a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> f987a;
    private final NETWORK_EXTRAS f988b;

    public ba(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.f987a = mediationAdapter;
        this.f988b = network_extras;
    }

    private SERVER_PARAMETERS m1654a(String str, int i, String str2) {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                dq.m2118c("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.f987a.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public C0651c mo885a() {
        if (this.f987a instanceof MediationBannerAdapter) {
            try {
                return C0654d.m1384a(((MediationBannerAdapter) this.f987a).getBannerView());
            } catch (Throwable th) {
                dq.m2118c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dq.m2120e("MediationAdapter is not a MediationBannerAdapter: " + this.f987a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void mo886a(C0651c c0651c, ai aiVar, String str, av avVar) {
        mo887a(c0651c, aiVar, str, null, avVar);
    }

    public void mo887a(C0651c c0651c, ai aiVar, String str, String str2, av avVar) {
        if (this.f987a instanceof MediationInterstitialAdapter) {
            dq.m2112a("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f987a).requestInterstitialAd(new bb(avVar), (Activity) C0654d.m1385a(c0651c), m1654a(str, aiVar.f897g, str2), bc.m1668a(aiVar), this.f988b);
            } catch (Throwable th) {
                dq.m2118c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dq.m2120e("MediationAdapter is not a MediationInterstitialAdapter: " + this.f987a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void mo888a(C0651c c0651c, al alVar, ai aiVar, String str, av avVar) {
        mo889a(c0651c, alVar, aiVar, str, null, avVar);
    }

    public void mo889a(C0651c c0651c, al alVar, ai aiVar, String str, String str2, av avVar) {
        if (this.f987a instanceof MediationBannerAdapter) {
            dq.m2112a("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.f987a).requestBannerAd(new bb(avVar), (Activity) C0654d.m1385a(c0651c), m1654a(str, aiVar.f897g, str2), bc.m1667a(alVar), bc.m1668a(aiVar), this.f988b);
            } catch (Throwable th) {
                dq.m2118c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dq.m2120e("MediationAdapter is not a MediationBannerAdapter: " + this.f987a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void mo890b() {
        if (this.f987a instanceof MediationInterstitialAdapter) {
            dq.m2112a("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f987a).showInterstitial();
            } catch (Throwable th) {
                dq.m2118c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dq.m2120e("MediationAdapter is not a MediationInterstitialAdapter: " + this.f987a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void mo891c() {
        try {
            this.f987a.destroy();
        } catch (Throwable th) {
            dq.m2118c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo892d() {
        throw new RemoteException();
    }

    public void mo893e() {
        throw new RemoteException();
    }
}
