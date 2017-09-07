package com.amobee.adsdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.webkit.WebView;
import com.facebook.AppEventsConstants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class Parameters {
    static final String ANDROID_ADVERTISING_ID_PARAMTER = "androidaid";
    static String EXCLUDE_KEYWORD = "nk";
    static final String GOOGLE_ADVERTISING_ID_PKG = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    static String KEYWORD = "kw";
    private static final String SDK_VERSION = "3.5.5";
    private static final String TAG = "Amobee Parameters";
    private String[] ReservedWordsname = new String[]{"n", "as", "ua", "time", "t", "tp", "sver", "aid", "type", "test", "ira", "i", "category", "null", "AmobeeIncNw", ANDROID_ADVERTISING_ID_PARAMTER};
    private String advertisingId = null;
    Location lastKnownLocation = null;
    Context mContext;
    private Map<String, String> m_parameters;
    private SharedPreferences prefs;
    boolean shouldSendAdvertisingId = true;

    private static class AndroidAidClass {
        private AndroidAidClass() {
        }

        static void setAndroidAid(Parameters parameters) {
            try {
                Info b = AdvertisingIdClient.m1415b(parameters.mContext);
                parameters.advertisingId = b.m1411a();
                parameters.m_parameters.put(Parameters.ANDROID_ADVERTISING_ID_PARAMTER, parameters.advertisingId);
                if (b.m1412b()) {
                    parameters.m_parameters.put("isLAT", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
            } catch (NoClassDefFoundError e) {
                Log.m811d(Parameters.TAG, "getAdvertisingId - " + e);
            } catch (Exception e2) {
                Log.m811d(Parameters.TAG, "getAdvertisingId - " + e2);
            }
        }
    }

    public enum Gender {
        Male,
        Female
    }

    Parameters(Context context) {
        this.mContext = context;
        this.m_parameters = new HashMap();
        this.prefs = this.mContext.getSharedPreferences("amobeePref", 0);
        String string = this.prefs.getString("amobeeId", "");
        if (!(string == null || string == "")) {
            this.m_parameters.put("aid", string);
        }
        this.m_parameters.put("mu", "xhtml");
        this.m_parameters.put("ua", new WebView(context).getSettings().getUserAgentString());
        this.m_parameters.put("stype", "Android");
        this.m_parameters.put("sver", SDK_VERSION);
        if (AdManager.pulse3dSupport) {
            this.m_parameters.put("pulse3d", AdManager.pulse3dVersionString);
        }
    }

    static boolean doesClassExist(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean reservedWord(String str) {
        for (String equalsIgnoreCase : this.ReservedWordsname) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                Log.m811d(AdManager.TAG, "setTargetingParameter: Can't set " + str + ", as it is a reserved word.");
                return true;
            }
        }
        return false;
    }

    private int searchKeyword(String str, String str2) {
        if (getKeywords(str2) != null) {
            for (int i = 0; i < getKeywords(str2).length; i++) {
                if (getKeywords(str2)[i].equals(str)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void addKeyword(String str) {
        if (!this.m_parameters.containsKey("kw")) {
            this.m_parameters.put("kw", str);
        } else if (searchKeyword(str, KEYWORD) == -1) {
            this.m_parameters.put("kw", new StringBuilder(String.valueOf((String) this.m_parameters.get("kw"))).append("|").append(str).toString());
        }
    }

    public void excludeKeyword(String str) {
        if (!this.m_parameters.containsKey("nk")) {
            this.m_parameters.put("nk", str);
        } else if (searchKeyword(str, EXCLUDE_KEYWORD) == -1) {
            this.m_parameters.put("nk", new StringBuilder(String.valueOf((String) this.m_parameters.get("nk"))).append("|").append(str).toString());
        }
    }

    public String getAdSpace() {
        return (String) this.m_parameters.get("as");
    }

    public String getAge() {
        return (String) this.m_parameters.get("age");
    }

    public String getCountryCode() {
        return (String) this.m_parameters.get("co");
    }

    public String getDma() {
        return (String) this.m_parameters.get("dma");
    }

    public Date getDob() {
        String str = (String) this.m_parameters.get("dob");
        if (str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("ddMMyyyy").parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    public String getGender() {
        return (String) this.m_parameters.get("ge");
    }

    public String[] getKeywords(String str) {
        String str2 = (String) this.m_parameters.get(str);
        return (str2 == null || str2.equals("")) ? null : str2.split("\\|");
    }

    public String getLat() {
        return (String) this.m_parameters.get("lat");
    }

    public Location getLocation() {
        Location location = new Location("admob");
        try {
            location.setLatitude(Double.parseDouble((String) this.m_parameters.get("lat")));
            location.setLongitude(Double.parseDouble((String) this.m_parameters.get("long")));
            return location;
        } catch (Exception e) {
            return null;
        }
    }

    public String getLong() {
        return (String) this.m_parameters.get("long");
    }

    public Map<String, String> getParameters() {
        return this.m_parameters;
    }

    public String getPartner() {
        return (String) this.m_parameters.get("prt");
    }

    public String getStateCode() {
        return (String) this.m_parameters.get("st");
    }

    public String getZip() {
        return (String) this.m_parameters.get("zip");
    }

    public void removeExcludeKeyword(String str) {
        if (this.m_parameters.containsKey("nk") && getKeywords("nk") != null) {
            if (getKeywords(EXCLUDE_KEYWORD).length == 1 && getKeywords(EXCLUDE_KEYWORD)[0].equals(str)) {
                this.m_parameters.remove("nk");
            } else if (getKeywords(EXCLUDE_KEYWORD)[getKeywords(EXCLUDE_KEYWORD).length - 1].equals(str)) {
                this.m_parameters.put("nk", ((String) this.m_parameters.get("nk")).replace("|" + str, ""));
            } else {
                this.m_parameters.put("nk", ((String) this.m_parameters.get("nk")).replace(new StringBuilder(String.valueOf(str)).append("|").toString(), ""));
            }
        }
    }

    public void removeKeyword(String str) {
        if (this.m_parameters.containsKey("kw") && getKeywords("kw") != null) {
            if (getKeywords(KEYWORD).length == 1 && getKeywords(KEYWORD)[0].equals(str)) {
                this.m_parameters.remove("kw");
            } else if (getKeywords(KEYWORD)[getKeywords(KEYWORD).length - 1].equals(str)) {
                this.m_parameters.put("kw", ((String) this.m_parameters.get("kw")).replace("|" + str, ""));
            } else {
                this.m_parameters.put("kw", ((String) this.m_parameters.get("kw")).replace(new StringBuilder(String.valueOf(str)).append("|").toString(), ""));
            }
        }
    }

    public void setAdSpace(String str) {
        this.m_parameters.put("as", str);
    }

    synchronized void setAdvertisingdId() {
        if (!this.shouldSendAdvertisingId) {
            this.m_parameters.remove(ANDROID_ADVERTISING_ID_PARAMTER);
            this.m_parameters.remove("isLAT");
            this.advertisingId = null;
        } else if (this.advertisingId == null && doesClassExist(GOOGLE_ADVERTISING_ID_PKG)) {
            AndroidAidClass.setAndroidAid(this);
        }
    }

    public void setAge(int i) {
        this.m_parameters.put("age", Integer.toString(i));
    }

    synchronized void setAmobeeId(String str) {
        if (!str.equals(this.m_parameters.get("aid"))) {
            this.prefs.edit().putString("amobeeId", str).commit();
            if (this.m_parameters.get("aid") != null) {
                this.m_parameters.remove("aid");
            }
            this.m_parameters.put("aid", str);
        }
    }

    public void setCountryCode(String str) {
        this.m_parameters.put("co", str);
    }

    public void setDma(String str) {
        this.m_parameters.put("dma", str);
    }

    public void setDob(Date date) {
        if (date != null) {
            String format = new SimpleDateFormat("ddMMyyyy").format(date);
            if (format != null && !format.equals("")) {
                this.m_parameters.put("dob", format);
            }
        }
    }

    public void setGender(Gender gender) {
        this.m_parameters.put("ge", gender == Gender.Male ? "m" : "f");
    }

    public void setLocation(Location location) {
        this.lastKnownLocation = location;
        this.m_parameters.put("lat", Double.toString(location.getLatitude()));
        this.m_parameters.put("long", Double.toString(location.getLongitude()));
    }

    public void setPartner(String str) {
        this.m_parameters.put("prt", str);
    }

    public void setStateCode(String str) {
        this.m_parameters.put("st", str);
    }

    public void setTargetingParameter(String str, String str2) {
        if (!reservedWord(str)) {
            this.m_parameters.put(str, str2);
        }
    }

    public void setTest(boolean z) {
        this.m_parameters.put("ts", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public void setZip(String str) {
        this.m_parameters.put("zip", str);
    }
}
