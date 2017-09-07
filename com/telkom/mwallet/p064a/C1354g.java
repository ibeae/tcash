package com.telkom.mwallet.p064a;

import android.widget.EditText;
import com.facebook.AppEventsConstants;
import com.skcc.wallet.core.p057a.C1216a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class C1354g {
    private static final String f2918a = C1354g.class.getSimpleName();

    public static String m4943a(int i) {
        Calendar instance = Calendar.getInstance();
        int i2 = instance.get(5);
        if (i < i2) {
            instance.add(2, 1);
        }
        instance.add(5, i - i2);
        return C1354g.m4947a(instance);
    }

    public static String m4944a(int i, int i2, int i3) {
        return i + (i2 + 1 < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO + (i2 + 1) : Integer.valueOf(i2 + 1)) + (i3 < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO + i3 : Integer.valueOf(i3));
    }

    public static String m4945a(String str) {
        if (str == null || str.length() < 8) {
            return str;
        }
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMddHHmmss").parse(str);
        } catch (ParseException e) {
            C1216a.m4522b("ParseError", "ERROR: Cannot parse \"" + str + "\":" + e.getMessage());
        }
        return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date);
    }

    public static String m4946a(String str, String str2) {
        if (str2 == null || str2.length() < 8) {
            return str2;
        }
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMddHHmmss").parse(str2);
        } catch (ParseException e) {
            C1216a.m4522b("ParseError", "ERROR: Cannot parse \"" + str2 + "\":" + e.getMessage());
        }
        return new SimpleDateFormat(str).format(date);
    }

    private static String m4947a(Calendar calendar) {
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        String str = "" + i;
        str = i2 < 10 ? str + AppEventsConstants.EVENT_PARAM_VALUE_NO + i2 : str + i2;
        return i3 < 10 ? str + AppEventsConstants.EVENT_PARAM_VALUE_NO + i3 : str + i3;
    }

    public static boolean m4948a(EditText editText) {
        return editText.getText().toString().matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
    }

    public static String m4949b(String str) {
        if (str == null || str.length() < 8) {
            return str;
        }
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(str);
        } catch (ParseException e) {
            C1216a.m4522b("ParseError", "ERROR: Cannot parse \"" + str + "\":" + e.getMessage());
        }
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

    public static boolean m4950b(EditText editText) {
        String trim = editText.getText().toString().trim();
        C1216a.m4519a("MSISDN - Utils", trim);
        if (trim.isEmpty() || trim.length() < 10) {
            return false;
        }
        if (trim.startsWith("62")) {
            editText.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO + trim.substring(2));
        } else if (trim.startsWith("+62")) {
            editText.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO + trim.substring(3));
        }
        return editText.getText().toString().matches("[0-9]{10,13}");
    }

    public static String m4951c(String str) {
        if (str == null || str.length() < 8) {
            return str;
        }
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMddHHmmss").parse(str);
        } catch (ParseException e) {
            C1216a.m4522b("ParseError", "ERROR: Cannot parse \"" + str + "\":" + e.getMessage());
        }
        return new SimpleDateFormat("dd/MM/yyyy (HH:mm:dd)").format(date);
    }

    public static boolean m4952c(EditText editText) {
        String trim = editText.getText().toString().trim();
        if (trim.isEmpty() || trim.length() < 10) {
            return false;
        }
        if (trim.startsWith("62")) {
            trim = AppEventsConstants.EVENT_PARAM_VALUE_NO + trim.substring(2);
            editText.setText(trim);
        } else if (trim.startsWith("+62")) {
            trim = AppEventsConstants.EVENT_PARAM_VALUE_NO + trim.substring(3);
            editText.setText(trim);
        }
        return !trim.startsWith("08") ? false : editText.getText().toString().matches("[0-9]{10,13}");
    }

    public static String m4953d(String str) {
        if (str == null || str.length() < 8) {
            return str;
        }
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            C1216a.m4522b("ParseError", "ERROR: Cannot parse \"" + str + "\":" + e.getMessage());
        }
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public static String m4954e(String str) {
        Date date = null;
        if (str == null || str.length() < 8) {
            return str;
        }
        try {
            date = (str.length() == 8 ? new SimpleDateFormat("yyyyMMdd") : new SimpleDateFormat("yyyyMMddHHmmss")).parse(str);
        } catch (ParseException e) {
            C1216a.m4522b("ParseError", "ERROR: Cannot parse \"" + str + "\":" + e.getMessage());
        }
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public static String m4955f(String str) {
        int i = 1;
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
        } else {
            i = 0;
        }
        return i != 0 ? "Rp -" + C1354g.m4957h(str) : "Rp " + C1354g.m4957h(str);
    }

    public static String m4956g(String str) {
        if (str == null) {
            return "";
        }
        String str2 = "";
        String trim = str.trim();
        int length = trim.length() % 4;
        if (length == 0 && trim.length() >= 4) {
            length = 4;
        }
        if (length > 0) {
            str2 = trim.substring(0, length);
            trim = trim.substring(length);
        }
        while (trim.length() > 0) {
            str2 = str2 + " " + trim.substring(0, 4);
            trim = trim.substring(4);
        }
        return str2;
    }

    public static String m4957h(String str) {
        if (str == null) {
            return "";
        }
        String str2 = "";
        String trim = str.trim();
        int length = trim.length() % 3;
        if (length == 0 && trim.length() >= 3) {
            length = 3;
        }
        if (length > 0) {
            str2 = trim.substring(0, length);
            trim = trim.substring(length);
        }
        while (trim.length() > 0) {
            str2 = str2 + "." + trim.substring(0, 3);
            trim = trim.substring(3);
        }
        return str2;
    }

    public static String m4958i(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("62")) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO + str.substring(2);
        }
        return str.startsWith("+62") ? AppEventsConstants.EVENT_PARAM_VALUE_NO + str.substring(3) : str;
    }

    public static String m4959j(String str) {
        return str == null ? "" : str.indexOf(40) > 0 ? str.substring(0, str.indexOf(40)) : str;
    }

    public static CharSequence m4960k(String str) {
        int i = 0;
        char[] cArr = new char[str.length()];
        char[] toCharArray = str.toCharArray();
        for (char c : toCharArray) {
            if ('0' <= c && c <= '9') {
                cArr[i] = c;
                i++;
            }
        }
        return new String(cArr).trim();
    }

    public static String m4961l(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        return length == 0 ? str : Character.toTitleCase(str.charAt(0)) + str.substring(1);
    }
}
