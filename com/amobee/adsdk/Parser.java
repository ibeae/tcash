package com.amobee.adsdk;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class Parser {

    class C03261 implements Runnable {
        private final /* synthetic */ AdManager val$am;
        private final /* synthetic */ Context val$context;
        private final /* synthetic */ HashMap val$map;
        private final /* synthetic */ AmobeeAdPlaceholder val$placeholder;

        C03261(HashMap hashMap, AmobeeAdPlaceholder amobeeAdPlaceholder, AdManager adManager, Context context) {
            this.val$map = hashMap;
            this.val$placeholder = amobeeAdPlaceholder;
            this.val$am = adManager;
            this.val$context = context;
        }

        public void run() {
            String str = (String) this.val$map.get(NetworkHelper.NW);
            CharSequence charSequence = (String) this.val$map.get(NetworkHelper.MEDIATION);
            String str2 = (String) this.val$map.get(NetworkHelper.NWID);
            String str3 = (String) this.val$map.get(NetworkHelper.NW_MAP_PARAMS);
            String str4 = (String) this.val$map.get(NetworkHelper.CORRELATOR);
            if (str2 == null || str2.equals("") || ((str == null || str.equals("")) && (charSequence == null || charSequence.equals("")))) {
                str3 = (String) this.val$map.get(NetworkHelper.FRAGMENT);
                str = (String) this.val$map.get(NetworkHelper.STATUS);
                if (str3 != null && !str3.equals("") && str.equals("6200")) {
                    BaseAdapter currentAdapter = this.val$placeholder.getCurrentAdapter();
                    if (str3.contains("<Pulse3DFileLocation>")) {
                        Parser.createPulse3DAdapter(str4, this.val$placeholder, str3, this.val$context);
                        return;
                    } else if (currentAdapter == null || !(currentAdapter instanceof AmobeeAdapter)) {
                        currentAdapter = new AmobeeAdapter(this.val$context, this.val$am.parameters(), str3, this.val$placeholder.getBannerWidth(), this.val$placeholder.getBannerHeight());
                        this.val$placeholder.setCurrentAdapter(currentAdapter);
                        currentAdapter.adRecieved();
                        return;
                    } else {
                        ((AmobeeAdapter) currentAdapter).updateAdapter(this.val$am.parameters(), str3);
                        return;
                    }
                } else if (this.val$placeholder.getNextAdapter() == null) {
                    this.val$am.getAmobeeListener().amobeeOnAdFailed(this.val$placeholder);
                    return;
                } else {
                    return;
                }
            }
            BaseAdapter createClientAdNwAdapter = Parser.createClientAdNwAdapter(str, charSequence, (String) this.val$map.get(NetworkHelper.NWID), str3, str4, this.val$placeholder);
            if (createClientAdNwAdapter != null) {
                this.val$placeholder.setCurrentAdapter(createClientAdNwAdapter);
                return;
            }
            NetworkHelper.sendNotification(BaseAdapter.createNotificationURL(0, str4));
            if (!(str == null || str.equals(""))) {
                charSequence = str;
            }
            this.val$am.amobeeIncNW = this.val$am.amobeeIncNW.replace(charSequence, "");
            AdManager.getInstance().getAd(this.val$placeholder);
        }
    }

    static class CreateAdmobAdapterWrapper {
        CreateAdmobAdapterWrapper() {
        }

        static BaseAdapter createAdmobAdapter(String str, String str2, String str3, String str4, Context context) {
            AdManager instance = AdManager.getInstance();
            return AdManager.doesClassExist("com.google.ads.AdView") ? new AdMobAdapter(context, instance.parameters(), str3, str4) : AdManager.doesClassExist("com.google.android.gms.ads.AdView") ? new GmsAdsAdapter(context, instance.parameters(), str3, str4) : null;
        }
    }

    static class CreateGreyStripeAdapterWrapper {
        CreateGreyStripeAdapterWrapper() {
        }

        static BaseAdapter createGreyStripeAdapter(String str, String str2, String str3, String str4, Context context) {
            return new GreyStripeAdapter(context, AdManager.getInstance().parameters(), str3, str4);
        }
    }

    static class CreateMillennialAdapterWrapper {
        CreateMillennialAdapterWrapper() {
        }

        static BaseAdapter createMillennialAdapter(String str, String str2, String str3, String str4, Context context, AmobeeAdPlaceholder amobeeAdPlaceholder) {
            return new MillennialAdapter(context, AdManager.getInstance().parameters(), str3, str4, amobeeAdPlaceholder);
        }
    }

    static class CreatePulse3DAdapterWrapper {
        CreatePulse3DAdapterWrapper() {
        }

        static void createPulse3DAdapterFunc(String str, AmobeeAdPlaceholder amobeeAdPlaceholder, String str2, Context context) {
            AdManager instance = AdManager.getInstance();
            Pulse3DAdapter pulse3DAdapter;
            if (amobeeAdPlaceholder.getCurrentAdapter() instanceof Pulse3DAdapter) {
                pulse3DAdapter = (Pulse3DAdapter) amobeeAdPlaceholder.getCurrentAdapter();
                pulse3DAdapter.setCorrelator(str);
                pulse3DAdapter.setURLFromFragment(str2);
            } else if (amobeeAdPlaceholder.getNextAdapter() instanceof Pulse3DAdapter) {
                pulse3DAdapter = (Pulse3DAdapter) amobeeAdPlaceholder.getNextAdapter();
                pulse3DAdapter.setCorrelator(str);
                pulse3DAdapter.setURLFromFragment(str2);
            } else {
                BaseAdapter pulse3DAdapter2 = new Pulse3DAdapter(context, instance.parameters());
                pulse3DAdapter2.setCorrelator(str);
                amobeeAdPlaceholder.setNextAdapter(pulse3DAdapter2);
                pulse3DAdapter2.setURLFromFragment(str2);
                Log.m811d("parser - pulse3d", "ad is loading from cache: " + pulse3DAdapter2.adIsLoadingFromCache);
                boolean contains = str2.contains("&backfill=0");
                boolean contains2 = str2.contains("&backfill=1");
                if (!contains) {
                    if (!pulse3DAdapter2.adIsLoadingFromCache || contains2) {
                        instance.parameters().getParameters().remove("pulse3d");
                        instance.getAd(amobeeAdPlaceholder);
                        Log.m811d("", "is: backfill request while pulse3d ad is loading...");
                    }
                }
            }
        }
    }

    static class CreateTapJoyAdapterWrapper {
        CreateTapJoyAdapterWrapper() {
        }

        static BaseAdapter CreateTapJoyAdapter(String str, String str2, String str3, String str4, String str5, Context context) {
            AdManager instance = AdManager.getInstance();
            if (!(str4 == null || str4.equals(""))) {
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    return new TapJoyAdapter(context, instance.parameters(), str3, jSONObject.getString("secretKey"), str5);
                } catch (JSONException e) {
                    Log.m811d(AdManager.TAG, "Tapjoy json.JSONException");
                }
            }
            return null;
        }
    }

    Parser() {
    }

    static BaseAdapter createClientAdNwAdapter(String str, String str2, String str3, String str4, String str5, AmobeeAdPlaceholder amobeeAdPlaceholder) {
        AdManager.getInstance();
        Context context = amobeeAdPlaceholder.getContext();
        return (str.equals("adMob") || str2.equals("adMob")) ? CreateAdmobAdapterWrapper.createAdmobAdapter(str, str2, str3, str5, context) : (str.equals("clMmi") || str2.equals("clMmi")) ? CreateMillennialAdapterWrapper.createMillennialAdapter(str, str2, str3, str5, context, amobeeAdPlaceholder) : (str.equals("greystripe") || str2.equals("greystripe")) ? CreateGreyStripeAdapterWrapper.createGreyStripeAdapter(str, str2, str3, str5, context) : (str.equals("Tapjoy") || str2.equals("Tapjoy")) ? CreateTapJoyAdapterWrapper.CreateTapJoyAdapter(str, str2, str3, str4, str5, context) : null;
    }

    static void createPulse3DAdapter(String str, AmobeeAdPlaceholder amobeeAdPlaceholder, String str2, Context context) {
        CreatePulse3DAdapterWrapper.createPulse3DAdapterFunc(str, amobeeAdPlaceholder, str2, context);
    }

    static void parse(HashMap<String, String> hashMap, AmobeeAdPlaceholder amobeeAdPlaceholder) {
        AdManager instance = AdManager.getInstance();
        Context context = instance.getContext();
        Runnable c03261 = new C03261(hashMap, amobeeAdPlaceholder, instance, context);
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(c03261);
            return;
        }
        Log.m811d(AdManager.TAG, "context is not Activity, posting on placeholder");
        amobeeAdPlaceholder.post(c03261);
    }
}
