package com.skcc.wallet.framework.api.http.model;

public class Location {
    private double dist = 0.0d;
    private double latitude = 0.0d;
    private String locatarea = null;
    private String locatid = null;
    private String locatplace = null;
    private String locatprovince = null;
    private double longitude = 0.0d;

    public double getDist() {
        return this.dist;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLocatarea() {
        return this.locatarea;
    }

    public String getLocatid() {
        return this.locatid;
    }

    public String getLocatplace() {
        return this.locatplace;
    }

    public String getLocatprovince() {
        return this.locatprovince;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setDist(double d) {
        this.dist = d;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLocatarea(String str) {
        this.locatarea = str;
    }

    public void setLocatid(String str) {
        this.locatid = str;
    }

    public void setLocatplace(String str) {
        this.locatplace = str;
    }

    public void setLocatprovince(String str) {
        this.locatprovince = str;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }
}
