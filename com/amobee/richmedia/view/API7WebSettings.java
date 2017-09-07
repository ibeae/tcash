package com.amobee.richmedia.view;

import android.webkit.WebSettings;

class API7WebSettings {
    public API7WebSettings(WebSettings webSettings) {
        try {
            webSettings.setLoadWithOverviewMode(true);
            webSettings.setAllowFileAccess(true);
            webSettings.setDomStorageEnabled(true);
        } catch (Exception e) {
        }
    }
}
