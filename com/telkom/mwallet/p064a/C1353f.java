package com.telkom.mwallet.p064a;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class C1353f {
    public static void m4941a(final EditText editText) {
        if (editText != null) {
            if ((editText.getContext().getResources().getConfiguration().orientation == 2 ? 1 : null) != null) {
                editText.requestFocus();
                editText.setSelection(editText.getText().length());
                InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
                inputMethodManager.toggleSoftInput(2, 1);
                inputMethodManager.showSoftInput(editText, 2);
                return;
            }
            final MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 600.0f, 0.0f, 0);
            final MotionEvent obtain2 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 600.0f, 0.0f, 0);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    editText.setSelection(editText.getText().length());
                    editText.requestFocus();
                    editText.dispatchTouchEvent(obtain);
                    editText.dispatchTouchEvent(obtain2);
                }
            }, 200);
        }
    }

    public static void m4942b(EditText editText) {
        if (editText != null) {
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }
}
