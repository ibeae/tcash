package com.facebook;

public class FacebookGraphObjectException extends FacebookException {
    static final long serialVersionUID = 1;

    public FacebookGraphObjectException(String str) {
        super(str);
    }

    public FacebookGraphObjectException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookGraphObjectException(Throwable th) {
        super(th);
    }
}
