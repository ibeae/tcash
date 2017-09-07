package com.skcc.wallet.core.se;

import java.util.Vector;

public final class SExceptionInfo {
    public static final int ACTIVATION_CONFLICT_DETECTED = -12;
    public static final int CONDITIONS_NOT_SATISFIED = -5;
    public static final int CONNECTION_REFUSED = -20;
    public static final int INCORRECT_P1_P2 = -6;
    public static final int INCORRECT_VALUES_IN_COMMAND_DATA = -10;
    public static final int INVALID_CLASS = -8;
    public static final int INVALID_INSTRUCTION = -7;
    public static final int IO_EXCEPTION = -21;
    public static final int LOCKED = -2;
    public static final int NOT_FOUND = -17;
    public static final int NOT_OPEN_CONNECT = -16;
    public static final int NO_SE = -18;
    public static final int NO_SUCH_APPLET = -19;
    public static final int OP_FAIL_FOR_SOME_APPS = -11;
    public static final int PIN_BLOCKED = -14;
    public static final int PIN_NOT_MATCH = -15;
    public static final int REFERECED_DATA_NOT_FOUND = -9;
    public static final int SECURITY_STATUS_NOT_SATISFIED = -4;
    public static final int UNKNOWN_ERR = -1;
    public static final int WRONG_DATA_IN_DATA_FIELD = -13;
    public static final int WRONG_LENGTH_IN_LC = -3;
    public Vector<String> conflictingApps;
    public int errCode;
    public int leftPinCount;
    public String notActivatedAid;
    public Vector<String> operationFailApps;
}
