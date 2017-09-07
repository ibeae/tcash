package com.skcc.wallet.framework.api.http.model;

import java.io.Serializable;

public class NameData implements Serializable {
    private static final long serialVersionUID = 7549708971016567690L;
    private String data;
    private String name;

    public String getData() {
        return this.data;
    }

    public String getName() {
        return this.name;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
