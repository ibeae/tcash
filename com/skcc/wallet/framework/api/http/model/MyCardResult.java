package com.skcc.wallet.framework.api.http.model;

public class MyCardResult {
    public static final int OK = 1;
    private String message = null;
    private int status = 0;

    public String getMessage() {
        return this.message != null ? this.message.trim() : this.message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.status = Integer.parseInt(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
