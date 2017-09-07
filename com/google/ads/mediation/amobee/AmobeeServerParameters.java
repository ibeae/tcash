package com.google.ads.mediation.amobee;

import com.google.ads.mediation.MediationServerParameters;

public class AmobeeServerParameters extends MediationServerParameters {
    @Parameter(name = "adspace")
    public String adspace;
    @Parameter(name = "domain", required = false)
    public String domain;
}
