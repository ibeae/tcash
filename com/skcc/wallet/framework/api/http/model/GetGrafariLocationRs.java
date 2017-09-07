package com.skcc.wallet.framework.api.http.model;

import java.util.ArrayList;

public class GetGrafariLocationRs extends ResultRs {
    private ArrayList<Location> locats;

    public ArrayList<Location> getLocations() {
        return this.locats;
    }

    public void setLocation(ArrayList<Location> arrayList) {
        this.locats = arrayList;
    }
}
