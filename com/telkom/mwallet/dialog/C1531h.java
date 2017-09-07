package com.telkom.mwallet.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.dialog.p063a.C1498g;
import com.telkom.mwallet.p064a.C1350d;
import com.telkom.mwallet.setting.tcash.TCashForgetPINActivity;
import com.telkom.mwallet.view.Random2of6PinEditView;

public class C1531h extends DialogFragment {
    private C1350d f3617a;
    private C1498g f3618b;
    private int f3619c = R.string.subtitle_confirmation;
    private int f3620d;
    private int f3621e = -1;
    private int f3622f = -1;
    private Random2of6PinEditView f3623g = null;
    private TextView f3624h;

    class C15281 implements OnClickListener {
        final /* synthetic */ C1531h f3614a;

        C15281(C1531h c1531h) {
            this.f3614a = c1531h;
        }

        public void onClick(View view) {
            Intent intent = new Intent(this.f3614a.getActivity(), TCashForgetPINActivity.class);
            intent.setFlags(67108864);
            this.f3614a.startActivity(intent);
        }
    }

    class C15292 implements OnClickListener {
        final /* synthetic */ C1531h f3615a;

        C15292(C1531h c1531h) {
            this.f3615a = c1531h;
        }

        public void onClick(View view) {
            if (this.f3615a.f3623g.m8024c()) {
                this.f3615a.f3618b.mo1545a(this.f3615a.f3623g.getPin());
                this.f3615a.dismiss();
            }
        }
    }

    class C15303 implements OnClickListener {
        final /* synthetic */ C1531h f3616a;

        C15303(C1531h c1531h) {
            this.f3616a = c1531h;
        }

        public void onClick(View view) {
            this.f3616a.f3618b.mo1544a();
        }
    }

    public static C1531h m5672a(int i) {
        C1531h c1531h = new C1531h();
        Bundle bundle = new Bundle();
        bundle.putInt("messageResId", i);
        c1531h.setArguments(bundle);
        return c1531h;
    }

    public void m5675a(C1498g c1498g) {
        this.f3618b = c1498g;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f3618b.mo1544a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3619c = getArguments().getInt("titleId");
        if (this.f3619c == 0) {
            this.f3619c = R.string.subtitle_confirmation;
        }
        this.f3620d = getArguments().getInt("messageResId");
        setStyle(1, 16974126);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_pin_confirm, viewGroup, false);
        this.f3617a = ((C1359a) getActivity()).m4982d();
        View view = (TextView) inflate.findViewById(R.id.dialog_title);
        view.setText(R.string.subtitle_confirmation);
        this.f3617a.m4932a(getActivity(), view, 3);
        this.f3623g = (Random2of6PinEditView) inflate.findViewById(R.id.pin_edit_view);
        view = (TextView) inflate.findViewById(R.id.notice_dialog_message);
        view.setText(this.f3620d);
        this.f3617a.m4932a(getActivity(), view, 2);
        this.f3624h = (TextView) inflate.findViewById(R.id.tcash_forget_pin_button);
        this.f3624h.setOnClickListener(new C15281(this));
        this.f3617a.m4932a(getActivity(), this.f3624h, 2);
        view = (Button) inflate.findViewById(R.id.notice_dialog_button_ok);
        view.setOnClickListener(new C15292(this));
        if (this.f3621e > 0) {
            view.setText(this.f3621e);
        }
        View view2 = (Button) inflate.findViewById(R.id.notice_dialog_button_cancel);
        view2.setOnClickListener(new C15303(this));
        if (this.f3622f > 0) {
            view2.setText(this.f3622f);
        }
        this.f3617a.m4932a(getActivity(), view, 3);
        this.f3617a.m4932a(getActivity(), view2, 3);
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
