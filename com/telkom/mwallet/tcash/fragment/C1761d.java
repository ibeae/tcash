package com.telkom.mwallet.tcash.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;

public class C1761d extends DialogFragment {
    private C1359a f4536a;
    private C1514b f4537b;
    private GestureDetector f4538c = new GestureDetector(getActivity(), new C17892(this));
    private C1326f f4539d = new C17903(this);

    class C17881 implements OnTouchListener {
        final /* synthetic */ C1761d f4677a;

        C17881(C1761d c1761d) {
            this.f4677a = c1761d;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f4677a.f4538c.onTouchEvent(motionEvent);
        }
    }

    class C17892 extends SimpleOnGestureListener {
        final /* synthetic */ C1761d f4678a;

        C17892(C1761d c1761d) {
            this.f4678a = c1761d;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f4678a.dismiss();
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    class C17903 implements C1326f {
        final /* synthetic */ C1761d f4679a;

        C17903(C1761d c1761d) {
            this.f4679a = c1761d;
        }

        public void mo1485a() {
            if (this.f4679a.f4537b != null) {
                this.f4679a.f4537b.dismiss();
            }
        }

        public void mo1486b() {
        }
    }

    protected C1359a m6759a() {
        this.f4536a = (C1359a) getActivity();
        return this.f4536a;
    }

    protected void m6760a(View view) {
        view.setOnTouchListener(new C17881(this));
    }

    protected void m6761a(ViewGroup viewGroup) {
        m6759a().m4982d().m4934a(this.f4536a.getApplicationContext(), viewGroup, 2);
    }

    protected void m6762a(LinearLayout linearLayout) {
        LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        linearLayout.setLayoutParams(layoutParams);
    }

    protected void m6763a(TextView textView) {
        m6759a().m4982d().m4932a(this.f4536a.getApplicationContext(), (View) textView, 3);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!(C1797h.class.getSimpleName().equals(getClass().getSimpleName()) || C1799i.class.getSimpleName().equals(getClass().getSimpleName()))) {
            this.f4536a.m4990k();
        }
        super.onDismiss(dialogInterface);
    }

    public void startActivity(Intent intent) {
        intent.addFlags(67108864);
        super.startActivity(intent);
    }
}
