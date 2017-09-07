package com.telkom.mwallet.p064a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class C1350d {
    private static final String f2908a = C1350d.class.getSimpleName();
    private static Typeface f2909b;
    private static Typeface f2910c;
    private static Typeface f2911d;
    private static Typeface f2912e;
    private static C1350d f2913f = null;

    private Typeface m4928a(Context context, int i) {
        switch (i) {
            case 1:
                if (f2909b == null) {
                    f2909b = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
                }
                return f2909b;
            case 2:
                if (f2910c == null) {
                    f2910c = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
                }
                return f2910c;
            case 3:
                if (f2911d == null) {
                    f2911d = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");
                }
                return f2911d;
            case 4:
                if (f2912e == null) {
                    f2912e = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");
                }
                return f2912e;
            default:
                return null;
        }
    }

    public static C1350d m4929a() {
        if (f2913f == null) {
            f2913f = new C1350d();
        }
        return f2913f;
    }

    private void m4930a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EditText) {
                ((EditText) childAt).setTypeface(f2910c);
            } else if (childAt instanceof Button) {
                ((Button) childAt).setTypeface(f2911d);
            } else if (childAt instanceof TextView) {
                ((TextView) childAt).setTypeface(f2910c);
            } else if (childAt instanceof ViewGroup) {
                m4930a((ViewGroup) childAt);
            }
        }
    }

    private void m4931a(ViewGroup viewGroup, Typeface typeface) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EditText) {
                ((EditText) childAt).setTypeface(typeface);
            } else if (childAt instanceof Button) {
                ((Button) childAt).setTypeface(typeface);
            } else if (childAt instanceof TextView) {
                ((TextView) childAt).setTypeface(typeface);
            } else if (childAt instanceof ViewGroup) {
                m4931a((ViewGroup) childAt, typeface);
            }
        }
    }

    public void m4932a(Context context, View view, int i) {
        Typeface a = m4928a(context, i);
        if (view instanceof Button) {
            ((Button) view).setTypeface(a);
        } else if (view instanceof TextView) {
            ((TextView) view).setTypeface(a);
        } else if (view instanceof EditText) {
            ((EditText) view).setTypeface(a);
        }
    }

    public void m4933a(Context context, ViewGroup viewGroup) {
        m4928a(context, 1);
        m4928a(context, 2);
        m4928a(context, 3);
        m4928a(context, 4);
        if (viewGroup != null) {
            m4930a(viewGroup);
        }
    }

    public void m4934a(Context context, ViewGroup viewGroup, int i) {
        Typeface a = m4928a(context, i);
        if (viewGroup != null) {
            m4931a(viewGroup, a);
        }
    }
}
