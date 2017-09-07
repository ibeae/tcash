package com.skcc.wallet.core.se.instance;

public class WrongPINException extends Exception {
    private static final long serialVersionUID = 1;
    private int leftPIN = 0;

    public WrongPINException(int i) {
        this.leftPIN = i;
    }

    public int getLeftPINCnt() {
        return this.leftPIN;
    }
}
