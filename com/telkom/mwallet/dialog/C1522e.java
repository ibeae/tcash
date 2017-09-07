package com.telkom.mwallet.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1497d;
import com.telkom.mwallet.p064a.C1350d;

public class C1522e extends DialogFragment {
    Button f3591a;
    private C1350d f3592b;
    private NumberPicker f3593c;
    private EditText f3594d;
    private int f3595e;
    private String f3596f;
    private LinearLayout f3597g;
    private C1497d f3598h;

    class C15191 implements OnClickListener {
        final /* synthetic */ C1522e f3588a;

        C15191(C1522e c1522e) {
            this.f3588a = c1522e;
        }

        public void onClick(View view) {
            if (this.f3588a.f3591a.isSelected()) {
                this.f3588a.f3591a.setSelected(false);
                this.f3588a.f3597g.setVisibility(8);
                return;
            }
            this.f3588a.f3591a.setSelected(true);
            this.f3588a.f3597g.setVisibility(0);
        }
    }

    class C15202 implements OnClickListener {
        final /* synthetic */ C1522e f3589a;

        C15202(C1522e c1522e) {
            this.f3589a = c1522e;
        }

        public void onClick(View view) {
            if (this.f3589a.f3598h == null) {
                return;
            }
            if (this.f3589a.f3591a.isSelected()) {
                this.f3589a.f3598h.mo1538a(this.f3589a.f3594d.getText().toString(), this.f3589a.f3593c.getValue());
            } else {
                this.f3589a.f3598h.mo1538a(this.f3589a.f3594d.getText().toString(), -1);
            }
        }
    }

    class C15213 implements OnClickListener {
        final /* synthetic */ C1522e f3590a;

        C15213(C1522e c1522e) {
            this.f3590a = c1522e;
        }

        public void onClick(View view) {
            if (this.f3590a.f3598h != null) {
                this.f3590a.f3598h.mo1537a();
            }
        }
    }

    public static C1522e m5660a(int i, String str) {
        C1522e c1522e = new C1522e();
        Bundle bundle = new Bundle();
        bundle.putInt("day", i);
        bundle.putString("title", str);
        c1522e.setArguments(bundle);
        return c1522e;
    }

    public void m5664a(C1497d c1497d) {
        this.f3598h = c1497d;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f3595e = getArguments().getInt("day");
            this.f3596f = getArguments().getString("title");
        }
        setStyle(1, 16973939);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_edit_favorite, viewGroup, false);
        this.f3592b = ((C1359a) getActivity()).m4982d();
        this.f3592b.m4932a(getActivity(), (TextView) inflate.findViewById(R.id.dialog_title), 3);
        this.f3593c = (NumberPicker) inflate.findViewById(R.id.date_dialog_numberpicker);
        this.f3593c.setMinValue(1);
        this.f3593c.setMaxValue(28);
        this.f3593c.setScaleX(0.8f);
        this.f3593c.setScaleY(0.77f);
        this.f3597g = (LinearLayout) inflate.findViewById(R.id.reminder_layout);
        this.f3591a = (Button) inflate.findViewById(R.id.dialog_favorite_reminder_button);
        if (this.f3595e > 0) {
            this.f3593c.setValue(this.f3595e);
            this.f3591a.setSelected(true);
            this.f3597g.setVisibility(0);
        } else {
            this.f3591a.setSelected(false);
            this.f3597g.setVisibility(8);
        }
        this.f3591a.setOnClickListener(new C15191(this));
        this.f3594d = (EditText) inflate.findViewById(R.id.favorite_title_edittext);
        this.f3594d.setText(this.f3596f);
        View view = (TextView) inflate.findViewById(R.id.dialog_txt2);
        View view2 = (TextView) inflate.findViewById(R.id.dialog_favorite_title1);
        View view3 = (TextView) inflate.findViewById(R.id.dialog_favorite_title2);
        this.f3592b.m4932a(getActivity(), (TextView) inflate.findViewById(R.id.dialog_txt1), 2);
        this.f3592b.m4932a(getActivity(), view, 2);
        this.f3592b.m4932a(getActivity(), view2, 2);
        this.f3592b.m4932a(getActivity(), view3, 2);
        this.f3592b.m4932a(getActivity(), this.f3594d, 2);
        View view4 = (Button) inflate.findViewById(R.id.date_dialog_button_ok);
        view4.setOnClickListener(new C15202(this));
        view = (Button) inflate.findViewById(R.id.date_dialog_button_cancel);
        view.setOnClickListener(new C15213(this));
        this.f3592b.m4932a(getActivity(), view4, 3);
        this.f3592b.m4932a(getActivity(), view, 3);
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
