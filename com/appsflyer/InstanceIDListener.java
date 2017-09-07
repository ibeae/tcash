package com.appsflyer;

import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.InstanceIDListenerService;
import java.io.IOException;

public class InstanceIDListener extends InstanceIDListenerService {
    private String _refreshedToken;
    private long _tokenTimestamp;

    public void onTokenRefresh() {
        super.onTokenRefresh();
        AFLogger.afLog("onTokenRefresh called");
        try {
            this._refreshedToken = InstanceID.getInstance(this).getToken(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.GCM_PROJECT_NUMBER), "GCM", null);
            this._tokenTimestamp = System.currentTimeMillis();
        } catch (IOException e) {
            AFLogger.afLog("Could not load registration ID");
        } catch (Throwable th) {
            AFLogger.afLog("Error registering for uninstall feature");
        }
        if (this._refreshedToken != null) {
            AFLogger.afLog("new token=" + this._refreshedToken);
            String string = AppsFlyerProperties.getInstance().getString("gcmToken");
            String string2 = AppsFlyerProperties.getInstance().getString("gcmInstanceId");
            GcmToken gcmToken = new GcmToken(AppsFlyerProperties.getInstance().getString("gcmTokenTimestamp"), string, string2);
            if (gcmToken.update(new GcmToken(this._tokenTimestamp, this._refreshedToken, string2))) {
                AppsFlyerLib.getInstance().updateServerGcmToken(gcmToken, getApplicationContext());
            }
        }
    }
}
