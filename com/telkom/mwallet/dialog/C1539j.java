package com.telkom.mwallet.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1500i;
import com.telkom.mwallet.p064a.C1350d;

public class C1539j extends DialogFragment {
    private C1350d f3642a;
    private NumberPicker f3643b;
    private int f3644c;
    private C1500i f3645d;

    class C15371 implements OnClickListener {
        final /* synthetic */ C1539j f3640a;

        C15371(C1539j c1539j) {
            this.f3640a = c1539j;
        }

        public void onClick(View view) {
            if (this.f3640a.f3645d != null) {
                this.f3640a.f3645d.mo1547a(this.f3640a.f3643b.getValue());
            }
        }
    }

    class C15382 implements OnClickListener {
        final /* synthetic */ C1539j f3641a;

        C15382(C1539j c1539j) {
            this.f3641a = c1539j;
        }

        public void onClick(View view) {
            if (this.f3641a.f3645d != null) {
                this.f3641a.f3645d.mo1546a();
            }
        }
    }

    public static C1539j m5687a() {
        return new C1539j();
    }

    public static C1539j m5688a(int i) {
        C1539j c1539j = new C1539j();
        Bundle bundle = new Bundle();
        bundle.putInt("day", i);
        c1539j.setArguments(bundle);
        return c1539j;
    }

    public void m5690a(C1500i c1500i) {
        this.f3645d = c1500i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
        if (getArguments() != null) {
            this.f3644c = getArguments().getInt("day");
        }
        setStyle(1, 16973939);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_reminder, viewGroup, false);
        this.f3642a = ((C1359a) getActivity()).m4982d();
        this.f3642a.m4932a(getActivity(), (TextView) inflate.findViewById(R.id.dialog_title), 3);
        this.f3643b = (NumberPicker) inflate.findViewById(R.id.date_dialog_numberpicker);
        this.f3643b.setMinValue(1);
        this.f3643b.setMaxValue(28);
        this.f3643b.setValue(this.f3644c);
        this.f3643b.setScaleX(0.8f);
        this.f3643b.setScaleY(0.77f);
        View view = (TextView) inflate.findViewById(R.id.dialog_txt2);
        this.f3642a.m4932a(getActivity(), (TextView) inflate.findViewById(R.id.dialog_txt1), 2);
        this.f3642a.m4932a(getActivity(), view, 2);
        View view2 = (Button) inflate.findViewById(R.id.date_dialog_button_ok);
        view2.setOnClickListener(new C15371(this));
        view = (Button) inflate.findViewById(R.id.date_dialog_button_cancel);
        view.setOnClickListener(new C15382(this));
        this.f3642a.m4932a(getActivity(), view2, 3);
        this.f3642a.m4932a(getActivity(), view, 3);
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
