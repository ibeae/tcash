package com.telkom.mwallet.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class C1609a implements TextWatcher {
    private EditText f3942a;
    private String f3943b;

    public C1609a(EditText editText) {
        this.f3942a = editText;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f3943b = charSequence.toString();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f3943b.equals(charSequence.toString())) {
            int length = charSequence.toString().length();
            String str = "";
            if (length > 0) {
                String str2 = str;
                for (int i4 = 0; i4 < length; i4++) {
                    char charAt = charSequence.charAt(i4);
                    if ((charAt >= '0' && charAt <= '9') || charAt == '+') {
                        str2 = str2 + charAt;
                    }
                }
                this.f3942a.setText(str2);
                if (str2.length() > 0) {
                    this.f3942a.setSelection(str2.length());
                }
            }
        }
    }
}
