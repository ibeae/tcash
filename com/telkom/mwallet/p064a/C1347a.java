package com.telkom.mwallet.p064a;

import android.content.Context;
import android.support.v4.view.C0136d;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;

public class C1347a {
    private static C1347a f2903c = new C1347a();
    C0136d f2904a;
    ScrollView f2905b;

    class C13441 implements OnTouchListener {
        final /* synthetic */ C1347a f2900a;

        C13441(C1347a c1347a) {
            this.f2900a = c1347a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f2900a.f2904a.m448a(motionEvent);
        }
    }

    class C13462 extends SimpleOnGestureListener {
        final /* synthetic */ C1347a f2902a;

        class C13451 implements Runnable {
            final /* synthetic */ C13462 f2901a;

            C13451(C13462 c13462) {
                this.f2901a = c13462;
            }

            public void run() {
                Log.d("AutoScroll", "touched edittext");
                this.f2901a.f2902a.f2905b.smoothScrollTo(0, this.f2901a.f2902a.f2905b.getBottom());
            }
        }

        C13462(C1347a c1347a) {
            this.f2902a = c1347a;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (this.f2902a.f2905b != null) {
                this.f2902a.f2905b.postDelayed(new C13451(this), 350);
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    private C1347a() {
    }

    private C0136d m4908a(Context context) {
        return new C0136d(context, new C13462(this));
    }

    private ScrollView m4909a(View view) {
        ScrollView scrollView = null;
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ScrollView) {
                scrollView = (ScrollView) parent;
            }
        }
        return scrollView;
    }

    public static C1347a m4910a() {
        return f2903c;
    }

    public void m4911a(ScrollView scrollView, List<EditText> list) {
        if (scrollView != null && list != null && !list.isEmpty()) {
            this.f2905b = scrollView;
            this.f2904a = m4908a(this.f2905b.getContext());
            for (EditText onTouchListener : list) {
                onTouchListener.setOnTouchListener(new C13441(this));
            }
        }
    }

    public void m4912a(List<EditText> list) {
        if (list != null && !list.isEmpty()) {
            m4911a(m4909a((View) list.get(0)), (List) list);
        }
    }

    public void m4913a(List<EditText> list, EditText... editTextArr) {
        List arrayList;
        if (list == null) {
            arrayList = new ArrayList();
        }
        for (Object add : editTextArr) {
            arrayList.add(add);
        }
        m4912a(arrayList);
    }

    public void m4914a(EditText... editTextArr) {
        List arrayList = new ArrayList();
        for (Object add : editTextArr) {
            arrayList.add(add);
        }
        m4912a(arrayList);
    }
}
