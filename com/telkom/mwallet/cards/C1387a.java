package com.telkom.mwallet.cards;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.p062d.C1312a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.tcash.fragment.C1386e;
import java.io.IOException;

public class C1387a extends C1386e {
    private static final String f3064b = C1387a.class.getSimpleName();
    public TextWatcher f3065a = new C13842(this);
    private CardAddDetailActivity f3066c;
    private ImageView f3067j;
    private EditText f3068k;
    private Button f3069l;
    private Button f3070m;
    private C1312a f3071n;
    private OnClickListener f3072o = new C13831(this);

    class C13831 implements OnClickListener {
        final /* synthetic */ C1387a f3054a;

        C13831(C1387a c1387a) {
            this.f3054a = c1387a;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.card_add_detail_confirm_button:
                    if (this.f3054a.m5227e()) {
                        this.f3054a.f3066c.m5058f(this.f3054a.f3068k.getText().toString().replaceAll("\\p{Space}", ""));
                        this.f3054a.f3066c.mo1505o();
                        return;
                    }
                    return;
                case R.id.card_add_detail_set_main_button:
                    if (this.f3054a.f3069l.isSelected()) {
                        this.f3054a.f3069l.setSelected(false);
                        return;
                    } else {
                        this.f3054a.f3069l.setSelected(true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    class C13842 implements TextWatcher {
        boolean f3055a = false;
        final /* synthetic */ C1387a f3056b;

        C13842(C1387a c1387a) {
            this.f3056b = c1387a;
        }

        public void afterTextChanged(Editable editable) {
            if (!this.f3055a) {
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!this.f3055a) {
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!this.f3055a) {
                boolean z;
                String str = null;
                if (charSequence.length() > 0) {
                    String replaceAll = charSequence.toString().replaceAll("\\p{Space}", "");
                    z = charSequence.length() != this.f3056b.f3068k.getSelectionStart();
                    str = replaceAll;
                } else {
                    z = false;
                }
                if (str != null) {
                    this.f3055a = true;
                    this.f3056b.f3068k.setText(this.f3056b.m5228b(str));
                    EditText c = this.f3056b.f3068k;
                    if (!z) {
                        i = this.f3056b.f3068k.length();
                    } else if (i2 != 1) {
                        i++;
                    }
                    c.setSelection(i);
                    this.f3055a = false;
                }
            }
        }
    }

    private void m5221a(String str, ImageView imageView) {
        if (str != null && str.startsWith("http")) {
            this.f3071n.m4786a(str, imageView);
        } else if (str != null) {
            try {
                C1216a.m4522b("imagesub", "image:  ");
                imageView.setImageDrawable(Drawable.createFromStream(getParentFragment().getActivity().getAssets().open(str), null));
            } catch (IOException e) {
            }
        }
    }

    private void m5222b(View view) {
        this.f3067j = (ImageView) view.findViewById(R.id.card_add_detail_imageview);
        this.f3068k = (EditText) view.findViewById(R.id.card_add_detail_number_edittext);
        this.f3069l = (Button) view.findViewById(R.id.card_add_detail_set_main_button);
        this.f3070m = (Button) view.findViewById(R.id.card_add_detail_confirm_button);
        this.f3071n = new C1312a(getActivity().getApplication());
        m5221a(this.f3066c.getIntent().getStringExtra("loyaltyCardDefaultImageUrl"), this.f3067j);
        this.f3069l.setSelected(true);
        this.f3069l.setOnClickListener(this.f3072o);
        this.f3070m.setOnClickListener(this.f3072o);
        this.f3068k.addTextChangedListener(this.f3065a);
        this.h.m4934a(this.e, (ViewGroup) view, 2);
        this.h.m4932a(this.e, this.f3070m, 3);
        this.f3068k.requestFocus();
        getActivity().getWindow().setSoftInputMode(4);
    }

    private void m5226d() {
        this.f3068k.setBackgroundResource(R.drawable.edittext_selector_bottom);
    }

    private boolean m5227e() {
        m5226d();
        if (!"".equals(this.f3068k.getText().toString().trim())) {
            return true;
        }
        this.f3068k.requestFocus();
        this.f3068k.setBackgroundResource(R.drawable.field_sct_red);
        return false;
    }

    public String m5228b(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        int length = stringBuilder.length();
        if (length == 0) {
            return "";
        }
        if (length > 4) {
            stringBuilder.insert(4, " ");
            if (length > 8) {
                stringBuilder.insert(9, " ");
            }
            if (length > 12) {
                stringBuilder.insert(14, " ");
            }
        }
        return stringBuilder.toString();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_card_add_detail, null);
        m5208c(R.string.title_card_add);
        this.f3066c = (CardAddDetailActivity) getActivity();
        m5222b(inflate);
        return inflate;
    }
}
