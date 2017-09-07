package com.telkom.mwallet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.telkom.mwallet.C1361c.C1360a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.TelkomApplication;
import com.telkom.mwallet.p064a.C1349c;
import java.util.ArrayList;
import java.util.List;

public class Random2of6PinEditView extends LinearLayout {
    TextWatcher f5825a = new C20051(this);
    OnFocusChangeListener f5826b = new C20062(this);
    OnKeyListener f5827c = new C20073(this);
    private List<EditText> f5828d;
    private Random2of6PinEditView f5829e = ((Random2of6PinEditView) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.view_6pin_layout, this, true).getRootView());
    private boolean f5830f = false;

    class C20051 implements TextWatcher {
        final /* synthetic */ Random2of6PinEditView f5822a;

        C20051(Random2of6PinEditView random2of6PinEditView) {
            this.f5822a = random2of6PinEditView;
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 1) {
                int i = 0;
                while (i < this.f5822a.f5828d.size()) {
                    EditText editText = (EditText) this.f5822a.f5828d.get(i);
                    if (!editText.isFocused()) {
                        i++;
                    } else if (i == this.f5822a.f5828d.size() - 1) {
                        editText.clearFocus();
                        this.f5822a.m8018a(editText);
                        return;
                    } else {
                        EditText editText2 = (EditText) this.f5822a.f5828d.get(i + 1);
                        if (editText2.getText().length() > 0) {
                            editText.clearFocus();
                            this.f5822a.m8018a(editText);
                            return;
                        }
                        editText2.requestFocus();
                        return;
                    }
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class C20062 implements OnFocusChangeListener {
        final /* synthetic */ Random2of6PinEditView f5823a;

        C20062(Random2of6PinEditView random2of6PinEditView) {
            this.f5823a = random2of6PinEditView;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                for (int i = 0; i < this.f5823a.f5828d.size(); i++) {
                    if (view.getId() == ((EditText) this.f5823a.f5828d.get(i)).getId()) {
                        ((EditText) this.f5823a.f5828d.get(i)).requestFocus();
                    } else {
                        ((EditText) this.f5823a.f5828d.get(i)).clearFocus();
                    }
                }
                if (this.f5823a.f5830f) {
                    ((EditText) this.f5823a.f5828d.get(0)).requestFocus();
                    this.f5823a.f5830f = false;
                }
            }
        }
    }

    class C20073 implements OnKeyListener {
        final /* synthetic */ Random2of6PinEditView f5824a;

        C20073(Random2of6PinEditView random2of6PinEditView) {
            this.f5824a = random2of6PinEditView;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            boolean z = true;
            boolean z2 = i == 67;
            if (keyEvent.getAction() != 0) {
                z = false;
            }
            if (z2 && r1) {
                int i2 = 0;
                while (i2 < this.f5824a.f5828d.size()) {
                    EditText editText = (EditText) this.f5824a.f5828d.get(i2);
                    if (editText.isFocused()) {
                        if (editText.getText().length() <= 0) {
                            if (editText.getText().length() <= 0 && i2 - 1 >= 0) {
                                ((EditText) this.f5824a.f5828d.get(i2 - 1)).requestFocus();
                                ((EditText) this.f5824a.f5828d.get(i2 - 1)).setText("");
                                break;
                            }
                        }
                        editText.setText("");
                        break;
                    }
                    i2++;
                }
            }
            return false;
        }
    }

    public Random2of6PinEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        EditText editText = (EditText) this.f5829e.findViewById(R.id.pin1);
        EditText editText2 = (EditText) this.f5829e.findViewById(R.id.pin2);
        EditText editText3 = (EditText) this.f5829e.findViewById(R.id.pin3);
        EditText editText4 = (EditText) this.f5829e.findViewById(R.id.pin4);
        EditText editText5 = (EditText) this.f5829e.findViewById(R.id.pin5);
        EditText editText6 = (EditText) this.f5829e.findViewById(R.id.pin6);
        this.f5828d = new ArrayList();
        this.f5828d.add(editText);
        this.f5828d.add(editText2);
        this.f5828d.add(editText3);
        this.f5828d.add(editText4);
        this.f5828d.add(editText5);
        this.f5828d.add(editText6);
        for (int i = 0; i < this.f5828d.size(); i++) {
            ((EditText) this.f5828d.get(i)).addTextChangedListener(this.f5825a);
            ((EditText) this.f5828d.get(i)).setOnFocusChangeListener(this.f5826b);
            ((EditText) this.f5828d.get(i)).setLongClickable(false);
            ((EditText) this.f5828d.get(i)).setOnKeyListener(this.f5827c);
        }
        setPinUI(attributeSet);
        m8023b();
    }

    private void m8018a(EditText editText) {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void setPinUI(AttributeSet attributeSet) {
        int i = 1;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1360a.Random2of6PinEditView);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        int i2 = dimensionPixelSize != 0 ? 1 : 0;
        if (dimensionPixelSize2 == 0) {
            i = 0;
        }
        if ((i & i2) != 0) {
            for (EditText layoutParams : this.f5828d) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams.getLayoutParams();
                layoutParams2.width = dimensionPixelSize;
                layoutParams2.height = dimensionPixelSize2;
            }
        }
    }

    public void m8022a() {
        this.f5830f = true;
    }

    public void m8023b() {
        for (int i = 0; i < this.f5828d.size(); i++) {
            ((EditText) this.f5828d.get(i)).setBackgroundResource(R.drawable.shape_edittext_token);
        }
    }

    public boolean m8024c() {
        m8023b();
        for (int i = 0; i < this.f5828d.size(); i++) {
            if (((EditText) this.f5828d.get(i)).getText().toString().equals("")) {
                ((EditText) this.f5828d.get(i)).requestFocus();
                ((EditText) this.f5828d.get(i)).setBackgroundResource(R.drawable.field_sct_red);
                return false;
            }
        }
        return true;
    }

    public String getPin() {
        String str = "";
        for (EditText text : this.f5828d) {
            str = str + text.getText().toString();
        }
        String str2 = null;
        try {
            str2 = C1349c.m4915a(((TelkomApplication) getContext().getApplicationContext()).m4745e().m4651b("SESSION_KEY", ""), str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    public List<EditText> getPinViews() {
        return this.f5828d;
    }
}
