package com.skcc.wallet.framework.api.http.model;

public class Condition {
    public static final String TYPE_AID = "AID";
    public static final String TYPE_CATEGORY = "CATEGORY";
    public static final String TYPE_IS_POPULAR = "ISPOPULAR";
    public static final String TYPE_NAME = "NAME";
    public static final String VALUE_ALL = "ALL";
    public static final String VALUE_CEPAS = "CEPAS";
    public static final String VALUE_PAYMENT = "PAYMENT";
    private String type = null;
    private String value = null;

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
