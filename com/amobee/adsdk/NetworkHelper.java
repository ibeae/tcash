package com.amobee.adsdk;

import android.graphics.Point;
import android.support.v4.app.FragmentTransaction;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

class NetworkHelper {
    static String AMOBEE_ID = "AmobeeID";
    static String CORRELATOR = "Correlator";
    static String FRAGMENT = "Fragment";
    static String MEDIATION = "Mediation";
    static String NW = "Network";
    static String NWID = "NetworkID";
    static String NW_MAP_PARAMS = "NetworkMapParams";
    static String STATUS = "Status";
    static String STATUS_DESCRIPTION = "StatusDescription";

    class C03251 implements Runnable {
        private final /* synthetic */ String val$myUrl;

        C03251(String str) {
            this.val$myUrl = str;
        }

        public void run() {
            try {
                new DefaultHttpClient().execute(new HttpGet(this.val$myUrl)).getEntity();
            } catch (Exception e) {
                Log.m811d(AdManager.TAG, "sendNotification error");
            }
        }
    }

    private static String createRequestInter(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        AdManager instance = AdManager.getInstance();
        if (instance.getServerURL() == null || instance.getServerURL().equals("") || str == null || str.equals("")) {
            return null;
        }
        stringBuffer.append(instance.getServerURL());
        stringBuffer.append("?time=");
        stringBuffer.append(System.currentTimeMillis());
        if (str != null) {
            try {
                stringBuffer.append("&as=" + URLEncoder.encode(str));
            } catch (Exception e) {
            }
        }
        stringBuffer.append("&orientation=");
        stringBuffer.append(instance.getOrientation());
        stringBuffer.append("&tp=3");
        stringBuffer.append("&n=" + i);
        instance.parameters().setAdvertisingdId();
        for (Entry entry : instance.parameters().getParameters().entrySet()) {
            if (!((String) entry.getKey()).equals("as")) {
                try {
                    stringBuffer.append("&" + ((String) entry.getKey()) + "=" + URLEncoder.encode((String) entry.getValue()));
                } catch (Exception e2) {
                }
            }
        }
        return stringBuffer.toString();
    }

    private static String createRequestPostitial(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        AdManager instance = AdManager.getInstance();
        if (instance.getServerURL() == null) {
            return null;
        }
        stringBuffer.append(instance.getServerURL());
        stringBuffer.append("?time=");
        stringBuffer.append(System.currentTimeMillis());
        try {
            stringBuffer.append("&as=" + URLEncoder.encode(str));
        } catch (Exception e) {
        }
        stringBuffer.append("&orientation=");
        stringBuffer.append(instance.getOrientation());
        Point screenSize = instance.getScreenSize();
        double density = instance.getDensity();
        int i = 0;
        int identifier = instance.getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i = instance.getContext().getResources().getDimensionPixelSize(identifier);
        }
        stringBuffer.append("&adw=");
        stringBuffer.append((int) (((double) screenSize.x) / density));
        stringBuffer.append("&adh=");
        stringBuffer.append((int) (((double) (screenSize.y - i)) / density));
        instance.parameters().setAdvertisingdId();
        for (Entry entry : instance.parameters().getParameters().entrySet()) {
            if (!((String) entry.getKey()).equals("as")) {
                try {
                    stringBuffer.append("&" + ((String) entry.getKey()) + "=" + URLEncoder.encode((String) entry.getValue()));
                } catch (Exception e2) {
                }
            }
        }
        return stringBuffer.toString();
    }

    private static String createRequestString(String str, int i, Point point, Point point2, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        AdManager instance = AdManager.getInstance();
        if (instance.getServerURL() == null || instance.getServerURL().equals("")) {
            return null;
        }
        stringBuffer.append(instance.getServerURL());
        stringBuffer.append("?time=");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("&orientation=");
        stringBuffer.append(i);
        if (point != null) {
            stringBuffer.append("&devw=");
            stringBuffer.append(point.x);
            stringBuffer.append("&devh=");
            stringBuffer.append(point.y);
        }
        if (point2 != null) {
            stringBuffer.append("&adw=");
            stringBuffer.append(point2.x);
            stringBuffer.append("&adh=");
            stringBuffer.append(point2.y);
        }
        stringBuffer.append("&AmobeeIncNw=" + str2);
        Map parameters = instance.parameters().getParameters();
        for (Entry entry : parameters.entrySet()) {
            try {
                if (!((String) entry.getKey()).equals("as")) {
                    stringBuffer.append("&" + ((String) entry.getKey()) + "=" + URLEncoder.encode((String) entry.getValue()));
                } else if (str == null || str.equals("")) {
                    stringBuffer.append("&" + ((String) entry.getKey()) + "=" + URLEncoder.encode((String) entry.getValue()));
                } else {
                    stringBuffer.append("&as=" + URLEncoder.encode(str));
                }
            } catch (Exception e) {
            }
        }
        if (!(parameters.containsKey("as") || str == null || str.equals(""))) {
            stringBuffer.append("&as=" + URLEncoder.encode(str));
        }
        String stringBuffer2 = stringBuffer.toString();
        return !stringBuffer2.contains("&as=") ? null : stringBuffer2;
    }

    private static HashMap<String, String> doInBackground(String... strArr) {
        AdManager instance = AdManager.getInstance();
        HashMap<String, String> hashMap = new HashMap();
        try {
            String str = strArr[0];
            if (str == null) {
                return null;
            }
            Object value;
            Object value2;
            Object value3;
            Object value4;
            Object value5;
            Object value6;
            Object value7;
            HttpClient defaultHttpClient = new DefaultHttpClient();
            HttpUriRequest httpGet = new HttpGet(str);
            Parameters parameters = instance.parameters();
            if (!(parameters.getParameters().get("ua") == null || ((String) parameters.getParameters().get("ua")).equals(""))) {
                httpGet.setHeader("User-Agent", (String) parameters.getParameters().get("ua"));
            }
            HttpResponse execute = defaultHttpClient.execute(httpGet);
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            String str6 = "";
            str = "";
            str = "";
            String str7 = "";
            String str8 = "";
            if (execute.getHeaders("AMOBEE-CLIENT-NW") == null || execute.getHeaders("AMOBEE-CLIENT-NW").length <= 0) {
                String str9 = str2;
            } else {
                value = execute.getHeaders("AMOBEE-CLIENT-NW")[0].getValue();
            }
            if (execute.getHeaders("AMOBEE-NW-ID") == null || execute.getHeaders("AMOBEE-NW-ID").length <= 0) {
                str2 = str3;
            } else {
                value2 = execute.getHeaders("AMOBEE-NW-ID")[0].getValue();
            }
            if (execute.getHeaders("AMOBEE-NW-MAP_PARAMS") == null || execute.getHeaders("AMOBEE-NW-MAP_PARAMS").length <= 0) {
                str3 = str7;
            } else {
                value3 = execute.getHeaders("AMOBEE-NW-MAP_PARAMS")[0].getValue();
            }
            if (execute.getHeaders("AMOBEE-CORRELATOR") == null || execute.getHeaders("AMOBEE-CORRELATOR").length <= 0) {
                str7 = str4;
            } else {
                value4 = execute.getHeaders("AMOBEE-CORRELATOR")[0].getValue();
            }
            if (execute.getHeaders("AMOBEE-MEDIATION") == null || execute.getHeaders("AMOBEE-MEDIATION").length <= 0) {
                str4 = str5;
            } else {
                value5 = execute.getHeaders("AMOBEE-MEDIATION")[0].getValue();
            }
            if (execute.getHeaders("X-AMOBEE-AID") != null && execute.getHeaders("X-AMOBEE-AID").length > 0) {
                str8 = execute.getHeaders("X-AMOBEE-AID")[0].getValue();
                if (!(str8 == null || str8.equals(""))) {
                    instance.parameters().setAmobeeId(str8);
                }
            }
            str5 = str8;
            if (execute.getHeaders("AMOBEE-STATUS") == null || execute.getHeaders("AMOBEE-STATUS").length <= 0) {
                str8 = str6;
            } else {
                value6 = execute.getHeaders("AMOBEE-STATUS")[0].getValue();
            }
            if (execute.getHeaders("Amobee-Status-Description") == null || execute.getHeaders("Amobee-Status-Description").length <= 0) {
                str6 = str;
            } else {
                value7 = execute.getHeaders("Amobee-Status-Description")[0].getValue();
            }
            if (execute.getHeaders("Content-Type") != null && execute.getHeaders("Content-Type").length > 0) {
                execute.getHeaders("Content-Type")[0].getValue();
            }
            Header[] allHeaders = execute.getAllHeaders();
            for (int i = 0; i < allHeaders.length; i++) {
                Log.m811d(AdManager.TAG, new StringBuilder(String.valueOf(allHeaders[i].getName())).append(": ").append(allHeaders[i].getValue()).toString());
            }
            hashMap.put(NW, value);
            hashMap.put(NW_MAP_PARAMS, value3);
            hashMap.put(AMOBEE_ID, str5);
            hashMap.put(NWID, value2);
            hashMap.put(CORRELATOR, value4);
            hashMap.put(MEDIATION, value5);
            hashMap.put(STATUS, value6);
            hashMap.put(STATUS_DESCRIPTION, value7);
            InputStream content = execute.getEntity().getContent();
            str6 = readInputStream(content);
            content.close();
            hashMap.put(FRAGMENT, str6);
            Log.m814v(AdManager.TAG, "fragment is: " + str6);
            return hashMap;
        } catch (Exception e) {
            Log.m811d(AdManager.TAG, "doInBackground error");
            return null;
        }
    }

    static void doRequest(AmobeeAdPlaceholder amobeeAdPlaceholder) {
        AdManager instance = AdManager.getInstance();
        instance.parameters().setAdvertisingdId();
        if (amobeeAdPlaceholder != null && !amobeeAdPlaceholder.isResized) {
            if (amobeeAdPlaceholder.getWindowVisibility() != 8 || amobeeAdPlaceholder.firstRequest) {
                amobeeAdPlaceholder.firstRequest = false;
                HashMap hashMap = new HashMap();
                String str = "";
                try {
                    if (!(amobeeAdPlaceholder.getAdSpace() == null || amobeeAdPlaceholder.getAdSpace().equals(""))) {
                        str = amobeeAdPlaceholder.getAdSpace();
                    }
                    str = createRequestString(str, instance.getOrientation(), instance.getScreenSize(), amobeeAdPlaceholder.getAdSize(), instance.amobeeIncNW);
                    if (str == null) {
                        Log.m811d(AdManager.TAG, "can't get an ad, mandatory fields are missing.");
                        return;
                    }
                    Log.m811d(AdManager.TAG, "request is:" + str);
                    hashMap = doInBackground(str);
                    if (hashMap != null) {
                        Parser.parse(hashMap, amobeeAdPlaceholder);
                        return;
                    } else {
                        instance.getAmobeeListener().amobeeOnAdFailed(amobeeAdPlaceholder);
                        return;
                    }
                } catch (Exception e) {
                    instance.getAmobeeListener().amobeeOnAdFailed(amobeeAdPlaceholder);
                    return;
                }
            }
            amobeeAdPlaceholder.requestAdImmediately = true;
            Log.m811d("AHHHHHHHHHHHHHHHHHHHH", "AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
        }
    }

    private static String readInputStream(InputStream inputStream) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = new byte[FragmentTransaction.TRANSIT_ENTER_MASK];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return stringBuffer.toString();
            }
            stringBuffer.append(new String(bArr, 0, read));
        }
    }

    static HashMap<String, String> requestAmobeeFullScreen(String str, int i, Point point) {
        HashMap<String, String> hashMap = null;
        try {
            AdManager.getInstance();
            String createRequestString = createRequestString(str, i, point, null, AdManager.amobeeIncFullScreenNW);
            if (createRequestString == null) {
                Log.m811d(AdManager.TAG, "can't get an AmobeeFullScreen ad, mandatory fields are missing.");
            } else {
                Log.m814v(AdManager.TAG, " AmobeeFullScreen request is: " + createRequestString);
                hashMap = doInBackground(createRequestString);
            }
        } catch (Exception e) {
            Log.m811d(AdManager.TAG, "doRequest error ");
        }
        return hashMap;
    }

    static HashMap<String, String> requestInterstitial(String str, int i) {
        HashMap<String, String> hashMap = null;
        try {
            String createRequestInter = createRequestInter(str, i);
            if (createRequestInter == null) {
                Log.m814v(AdManager.TAG, "can't get an Interstitial ad, mandatory fields are missing.");
            } else {
                Log.m814v(AdManager.TAG, " interstitial request is: " + createRequestInter);
                hashMap = doInBackground(createRequestInter);
            }
        } catch (Exception e) {
        }
        return hashMap;
    }

    static HashMap<String, String> requestPostitial(String str) {
        HashMap<String, String> hashMap = null;
        try {
            Log.m814v(AdManager.TAG, "postitial request is: " + createRequestPostitial(str));
            hashMap = doInBackground(r1);
        } catch (Exception e) {
        }
        return hashMap;
    }

    public static void sendNotification(String str) {
        new Thread(new C03251(str)).start();
    }
}
