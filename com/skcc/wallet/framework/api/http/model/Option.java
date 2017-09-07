package com.skcc.wallet.framework.api.http.model;

public class Option {
    private String fee = null;
    private String name = null;
    private String optionId = null;
    private String type = null;

    public String getFee() {
        return this.fee;
    }

    public String getName() {
        return this.name;
    }

    public String getOptionId() {
        return this.optionId;
    }

    public String getType() {
        return this.type;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOptionId(String str) {
        this.optionId = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
