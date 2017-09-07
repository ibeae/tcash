package com.skcc.wallet.core.se;

public class SException extends Exception {
    private static final long serialVersionUID = -7835821509359725817L;
    private SExceptionInfo info;

    public SException() {
        this.info = null;
    }

    public SException(int i) {
        this.info = null;
        this.info = new SExceptionInfo();
        this.info.errCode = i;
    }

    public SException(SExceptionInfo sExceptionInfo) {
        this.info = null;
        this.info = sExceptionInfo;
    }

    public SException(String str) {
        super(str);
        this.info = null;
    }

    public SExceptionInfo getInformation() {
        return this.info;
    }

    public void setInfo(SExceptionInfo sExceptionInfo) {
    }
}
