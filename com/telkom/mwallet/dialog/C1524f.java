package com.telkom.mwallet.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.p064a.C1350d;
import com.telkom.mwallet.p064a.C1354g;

public class C1524f extends DialogFragment {
    private static C1524f f3600a;
    private C1350d f3601b;
    private OnTouchListener f3602c = new C15231(this);

    class C15231 implements OnTouchListener {
        final /* synthetic */ C1524f f3599a;

        C15231(C1524f c1524f) {
            this.f3599a = c1524f;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            C1524f.f3600a.dismiss();
            return false;
        }
    }

    public static C1524f m5666a(String str, String str2, String str3, String str4) {
        f3600a = new C1524f();
        Bundle bundle = new Bundle();
        bundle.putString("date", str);
        bundle.putString("destNo", str2);
        bundle.putString("type", str3);
        bundle.putString("balance", str4);
        f3600a.setArguments(bundle);
        return f3600a;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_info, viewGroup, false);
        this.f3601b = ((C1359a) getActivity()).m4982d();
        View view = (TextView) inflate.findViewById(R.id.info_dialog_date);
        this.f3601b.m4932a(getActivity(), view, 2);
        view.setText(getArguments().getString("date"));
        view = (TextView) inflate.findViewById(R.id.info_dialog_info);
        this.f3601b.m4932a(getActivity(), view, 3);
        view.setText(getArguments().getString("destNo"));
        view = (TextView) inflate.findViewById(R.id.info_dialog_type);
        this.f3601b.m4932a(getActivity(), view, 2);
        CharSequence string = getArguments().getString("type");
        if (string == null) {
            view.setVisibility(8);
        } else {
            view.setText(string);
        }
        view = (TextView) inflate.findViewById(R.id.info_dialog_balance);
        this.f3601b.m4932a(getActivity(), view, 2);
        String string2 = getArguments().getString("balance");
        if (string == null) {
            view.setVisibility(8);
        } else {
            view.setText(C1354g.m4955f(string2));
        }
        inflate.setOnTouchListener(this.f3602c);
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
