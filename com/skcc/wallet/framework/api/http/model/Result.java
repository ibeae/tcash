package com.skcc.wallet.framework.api.http.model;

public class Result {
    public static final int OK = 0;
    private int code = 0;
    private String message = null;
    private String stringCode = null;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message != null ? this.message.trim() : this.message;
    }

    public String getStringCode() {
        return this.stringCode;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStringCode(String str) {
        this.stringCode = str;
    }
}
