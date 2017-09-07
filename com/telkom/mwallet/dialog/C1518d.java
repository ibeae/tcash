package com.telkom.mwallet.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import com.appsflyer.MonitorMessages;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.TelkomApplication;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.dialog.p063a.C1495b;
import com.telkom.mwallet.p064a.C1350d;

public class C1518d extends FragmentActivity {
    private static final String f3587a = C1518d.class.getSimpleName();

    public static class C1511a extends DialogFragment {
        private C1350d f3562a;
        private DatePicker f3563b;
        private int f3564c;
        private int f3565d;
        private int f3566e;
        private C1495b f3567f;
        private long f3568g = -1;

        class C15101 implements OnClickListener {
            final /* synthetic */ C1511a f3561a;

            C15101(C1511a c1511a) {
                this.f3561a = c1511a;
            }

            public void onClick(View view) {
                if (this.f3561a.f3567f != null) {
                    this.f3561a.f3567f.mo1533a(this.f3561a.f3563b.getYear(), this.f3561a.f3563b.getMonth(), this.f3561a.f3563b.getDayOfMonth());
                }
            }
        }

        public static C1511a m5642a(int i, int i2, int i3) {
            C1511a c1511a = new C1511a();
            Bundle bundle = new Bundle();
            bundle.putInt("initYear", i);
            bundle.putInt("initMonth", i2);
            bundle.putInt("initDay", i3);
            c1511a.setArguments(bundle);
            return c1511a;
        }

        public void m5644a(long j) {
            this.f3568g = j;
        }

        public void m5645a(C1495b c1495b) {
            this.f3567f = c1495b;
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                this.f3564c = getArguments().getInt("initYear");
                this.f3565d = getArguments().getInt("initMonth");
                this.f3566e = getArguments().getInt("initDay");
            }
            setStyle(1, 16973939);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.f3562a = ((TelkomApplication) getActivity().getApplication()).m4899j();
            View inflate = layoutInflater.inflate(R.layout.dialog_date, viewGroup, false);
            this.f3562a.m4932a(getActivity(), (TextView) inflate.findViewById(R.id.dialog_title), 3);
            this.f3563b = (DatePicker) inflate.findViewById(R.id.date_dialog_datepicker);
            this.f3563b.setScaleX(0.8f);
            this.f3563b.setScaleY(0.77f);
            if (!(this.f3564c == 0 && this.f3565d == 0 && this.f3566e == 0)) {
                this.f3563b.init(this.f3564c, this.f3565d - 1, this.f3566e, null);
            }
            if (this.f3568g > 0) {
                this.f3563b.setMaxDate(this.f3568g);
            }
            View view = (Button) inflate.findViewById(R.id.date_dialog_button_ok);
            view.setOnClickListener(new C15101(this));
            this.f3562a.m4932a(getActivity(), view, 3);
            return inflate;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
        }
    }

    public static class C1514b extends DialogFragment {
        private C1350d f3572a;
        private C1326f f3573b;
        private int f3574c;
        private int f3575d;
        private String f3576e;
        private int f3577f = -1;

        class C15121 implements OnClickListener {
            final /* synthetic */ C1514b f3569a;

            C15121(C1514b c1514b) {
                this.f3569a = c1514b;
            }

            public void onClick(View view) {
                if (this.f3569a.f3573b == null) {
                    this.f3569a.dismiss();
                } else {
                    this.f3569a.f3573b.mo1485a();
                }
            }
        }

        public static C1514b m5647a(int i) {
            C1514b c1514b = new C1514b();
            Bundle bundle = new Bundle();
            bundle.putInt("messageResId", i);
            c1514b.setArguments(bundle);
            return c1514b;
        }

        public static C1514b m5648a(int i, int i2) {
            C1514b c1514b = new C1514b();
            Bundle bundle = new Bundle();
            bundle.putInt("titleId", i);
            bundle.putInt("messageResId", i2);
            c1514b.setArguments(bundle);
            return c1514b;
        }

        public static C1514b m5649a(int i, String str) {
            C1514b c1514b = new C1514b();
            Bundle bundle = new Bundle();
            bundle.putInt("titleId", i);
            bundle.putString(MonitorMessages.MESSAGE, str);
            c1514b.setArguments(bundle);
            return c1514b;
        }

        public static C1514b m5650a(String str) {
            C1514b c1514b = new C1514b();
            Bundle bundle = new Bundle();
            bundle.putString(MonitorMessages.MESSAGE, str);
            c1514b.setArguments(bundle);
            return c1514b;
        }

        public void m5651a(C1326f c1326f) {
            this.f3573b = c1326f;
        }

        public void m5652b(int i) {
            this.f3577f = i;
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f3574c = getArguments().getInt("titleId");
            if (this.f3574c == 0) {
                this.f3574c = R.string.title_notice;
            }
            this.f3575d = getArguments().getInt("messageResId");
            this.f3576e = getArguments().getString(MonitorMessages.MESSAGE);
            setStyle(1, 16974126);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.f3572a = ((TelkomApplication) getActivity().getApplication()).m4899j();
            View inflate = layoutInflater.inflate(R.layout.dialog_notice, viewGroup, false);
            View view = (TextView) inflate.findViewById(R.id.dialog_title);
            this.f3572a.m4932a(getActivity(), view, 3);
            view.setText(this.f3574c);
            View view2 = (Button) inflate.findViewById(R.id.notice_dialog_button_ok);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.dialog_success_img);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.dialog_failed_img);
            if (this.f3574c == R.string.title_success || this.f3574c == R.string.success) {
                view2.setBackgroundResource(R.drawable.btn_common_green_selector);
                imageView.setVisibility(0);
                imageView2.setVisibility(8);
            } else if (this.f3574c == R.string.title_failed) {
                view2.setBackgroundResource(R.drawable.btn_common_orange_selector);
                imageView.setVisibility(8);
                imageView2.setVisibility(0);
            } else {
                view2.setBackgroundResource(R.drawable.btn_common_orange_selector);
                imageView.setVisibility(8);
                imageView2.setVisibility(8);
            }
            View view3 = (TextView) inflate.findViewById(R.id.notice_dialog_message);
            if (this.f3575d != 0) {
                view3.setText(this.f3575d);
            } else {
                if (this.f3576e.contains(getString(R.string.sighup_tcash_registered_msg))) {
                    view2.setBackgroundResource(R.drawable.btn_common_green_selector);
                    imageView.setVisibility(8);
                }
                view3.setText(this.f3576e);
            }
            this.f3572a.m4932a(getActivity(), view3, 2);
            view2.setOnClickListener(new C15121(this));
            if (this.f3577f > 0) {
                view2.setText(this.f3577f);
            }
            if (this.f3575d == R.string.notice_promotion) {
                view.setText(R.string.notification);
                view2.setText(R.string.done);
                final TextView textView = (TextView) inflate.findViewById(R.id.notice_dialog_link);
                textView.setText(R.string.notice_promotion_link);
                textView.setVisibility(0);
                textView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C1514b f3571b;

                    public void onClick(View view) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(textView.getText().toString()));
                        this.f3571b.startActivity(intent);
                        this.f3571b.dismiss();
                    }
                });
            }
            this.f3572a.m4932a(getActivity(), view2, 3);
            return inflate;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
        }
    }

    public static class C1517c extends DialogFragment {
        private C1350d f3580a;
        private C1326f f3581b;
        private int f3582c = R.string.title_notice;
        private int f3583d;
        private String f3584e;
        private int f3585f = -1;
        private int f3586g = -1;

        class C15151 implements OnClickListener {
            final /* synthetic */ C1517c f3578a;

            C15151(C1517c c1517c) {
                this.f3578a = c1517c;
            }

            public void onClick(View view) {
                this.f3578a.f3581b.mo1485a();
            }
        }

        class C15162 implements OnClickListener {
            final /* synthetic */ C1517c f3579a;

            C15162(C1517c c1517c) {
                this.f3579a = c1517c;
            }

            public void onClick(View view) {
                this.f3579a.f3581b.mo1486b();
            }
        }

        public static C1517c m5654a(int i) {
            C1517c c1517c = new C1517c();
            Bundle bundle = new Bundle();
            bundle.putInt("messageResId", i);
            c1517c.setArguments(bundle);
            return c1517c;
        }

        public static C1517c m5655a(int i, int i2) {
            C1517c c1517c = new C1517c();
            Bundle bundle = new Bundle();
            bundle.putInt("titleId", i);
            bundle.putInt("messageResId", i2);
            c1517c.setArguments(bundle);
            return c1517c;
        }

        public void m5656a(C1326f c1326f) {
            this.f3581b = c1326f;
        }

        public void m5657b(int i) {
            this.f3585f = i;
        }

        public void m5658c(int i) {
            this.f3586g = i;
        }

        public void onCancel(DialogInterface dialogInterface) {
            super.onCancel(dialogInterface);
            this.f3581b.mo1486b();
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f3582c = getArguments().getInt("titleId");
            if (this.f3582c == 0) {
                this.f3582c = R.string.title_notice;
            }
            this.f3583d = getArguments().getInt("messageResId");
            this.f3584e = getArguments().getString(MonitorMessages.MESSAGE);
            setStyle(1, 16974126);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.f3580a = ((TelkomApplication) getActivity().getApplication()).m4899j();
            View inflate = layoutInflater.inflate(R.layout.dialog_notice2, viewGroup, false);
            View view = (TextView) inflate.findViewById(R.id.dialog_title);
            view.setText(this.f3582c);
            this.f3580a.m4932a(getActivity(), view, 3);
            view = (TextView) inflate.findViewById(R.id.notice_dialog_message);
            if (this.f3583d != 0) {
                view.setText(this.f3583d);
            } else {
                view.setText(this.f3584e);
            }
            this.f3580a.m4932a(getActivity(), view, 2);
            view = (Button) inflate.findViewById(R.id.notice_dialog_button_ok);
            view.setOnClickListener(new C15151(this));
            if (this.f3585f > 0) {
                view.setText(this.f3585f);
            }
            View view2 = (Button) inflate.findViewById(R.id.notice_dialog_button_cancel);
            view2.setOnClickListener(new C15162(this));
            if (this.f3586g > 0) {
                view2.setText(this.f3586g);
            }
            this.f3580a.m4932a(getActivity(), view, 3);
            this.f3580a.m4932a(getActivity(), view2, 3);
            return inflate;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1216a.m4519a(f3587a, " in onDestroy >>>>>");
    }

    protected void onPause() {
        super.onPause();
        C1216a.m4519a(f3587a, " in onPause >>>>>");
    }

    protected void onResume() {
        super.onResume();
        C1216a.m4519a(f3587a, " in onResume >>>>>");
    }
}
