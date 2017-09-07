package com.telkom.mwallet.coupon;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.p031b.C1016a;
import com.google.p031b.C1178o;
import com.google.p031b.C1199m;
import com.google.p031b.C1200n;
import com.google.p031b.p036b.p037a.C1035r;
import com.skcc.wallet.core.p057a.C1216a;
import com.telkom.mwallet.C1359a;
import com.telkom.mwallet.R;
import com.telkom.mwallet.coupon.helper.C1474a;
import com.telkom.mwallet.coupon.helper.C1477d;
import com.telkom.mwallet.coupon.helper.C1481e;
import com.telkom.mwallet.coupon.helper.C1484g;
import com.telkom.mwallet.coupon.helper.C1486h;
import com.telkom.mwallet.coupon.helper.ViewfinderView;
import com.telkom.mwallet.coupon.p065a.C1437c;
import com.telkom.mwallet.coupon.p066b.C1444a.C1442a;
import com.telkom.mwallet.coupon.p066b.C1444a.C1443b;
import com.telkom.mwallet.coupon.p066b.C1445b;
import com.telkom.mwallet.coupon.p067c.C1454a;
import com.telkom.mwallet.coupon.p067c.C1455b;
import com.telkom.mwallet.dialog.C1518d.C1514b;
import com.telkom.mwallet.dialog.p063a.C1326f;
import com.telkom.mwallet.p064a.C1358h;
import com.telkom.mwallet.tcash.TCashTransferActivity;
import com.telkom.mwallet.tcash.payment.TCashOthersActivity;
import com.telkom.mwallet.tcash.purchase.TCashMerchantActivty;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import twitter4j.MediaEntity.Size;

public class C1473h extends Fragment implements Callback {
    public static final String f3462a = C1473h.class.getName();
    private static final Set<C1200n> f3463b = new HashSet(5);
    private C1484g f3464c;
    private ViewfinderView f3465d;
    private MediaPlayer f3466e;
    private C1199m f3467f;
    private boolean f3468g;
    private boolean f3469h;
    private boolean f3470i;
    private C1472a f3471j;
    private Vector<C1016a> f3472k;
    private String f3473l;
    private C1481e f3474m;
    private boolean f3475n;
    private boolean f3476o = false;
    private C1514b f3477p;
    private final OnCompletionListener f3478q = new C14681(this);
    private C1326f f3479r = new C14692(this);

    class C14681 implements OnCompletionListener {
        final /* synthetic */ C1473h f3453a;

        C14681(C1473h c1473h) {
            this.f3453a = c1473h;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    }

    class C14692 implements C1326f {
        final /* synthetic */ C1473h f3454a;

        C14692(C1473h c1473h) {
            this.f3454a = c1473h;
        }

        public void mo1485a() {
            if (this.f3454a.f3477p != null) {
                this.f3454a.f3477p.dismiss();
                this.f3454a.getActivity().finish();
            }
        }

        public void mo1486b() {
            if (this.f3454a.f3477p != null) {
                this.f3454a.f3477p.dismiss();
                this.f3454a.getActivity().finish();
            }
        }
    }

    class C14703 implements Runnable {
        final /* synthetic */ C1473h f3455a;

        C14703(C1473h c1473h) {
            this.f3455a = c1473h;
        }

        public void run() {
            this.f3455a.f3468g = true;
            this.f3455a.m5568f();
        }
    }

    private enum C1472a {
        NATIVE_APP_INTENT,
        PRODUCT_SEARCH_LINK,
        ZXING_LINK,
        NONE
    }

    static {
        f3463b.add(C1200n.ISSUE_NUMBER);
        f3463b.add(C1200n.SUGGESTED_PRICE);
        f3463b.add(C1200n.ERROR_CORRECTION_LEVEL);
        f3463b.add(C1200n.POSSIBLE_COUNTRY);
    }

    private void m5556a(Bitmap bitmap, C1199m c1199m) {
        int i = 0;
        C1178o[] c = c1199m.m4515c();
        if (c != null && c.length > 0) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(R.color.result_image_border));
            paint.setStrokeWidth(3.0f);
            paint.setStyle(Style.STROKE);
            canvas.drawRect(new Rect(2, 2, bitmap.getWidth() - 2, bitmap.getHeight() - 2), paint);
            paint.setColor(getResources().getColor(R.color.result_points));
            if (c.length == 2) {
                paint.setStrokeWidth(4.0f);
                C1473h.m5557a(canvas, paint, c[0], c[1]);
            } else if ((c.length == 4 && c1199m.m4516d().equals(C1016a.UPC_A)) || c1199m.m4516d().equals(C1016a.EAN_13)) {
                C1473h.m5557a(canvas, paint, c[0], c[1]);
                C1473h.m5557a(canvas, paint, c[2], c[3]);
            } else {
                paint.setStrokeWidth(10.0f);
                int length = c.length;
                while (i < length) {
                    C1178o c1178o = c[i];
                    canvas.drawPoint(c1178o.m4396a(), c1178o.m4397b(), paint);
                    i++;
                }
            }
        }
    }

    private static void m5557a(Canvas canvas, Paint paint, C1178o c1178o, C1178o c1178o2) {
        canvas.drawLine(c1178o.m4396a(), c1178o.m4397b(), c1178o2.m4396a(), c1178o2.m4397b(), paint);
    }

    private void m5558a(SurfaceHolder surfaceHolder) {
        try {
            C1437c.m5428a().m5432a(surfaceHolder);
            if (this.f3464c == null) {
                this.f3464c = new C1484g(this, this.f3472k, this.f3473l);
            }
        } catch (IOException e) {
            C1216a.m4524d(f3462a, e.toString());
            m5575m();
        } catch (Exception e2) {
            C1216a.m4520a(f3462a, "Unexpected error initializating camera", e2);
            m5575m();
        }
    }

    private void m5559a(C1199m c1199m) {
    }

    private void m5560a(C1199m c1199m, C1454a c1454a) {
        C1442a c1442a = new C1442a();
        c1442a.m5456a(c1199m.m4510a());
        c1442a.m5454a(System.currentTimeMillis());
        switch (c1454a.m5498e()) {
            case URI:
                c1442a.m5458b(C1445b.m5469c(c1199m.m4510a()));
                c1442a.m5455a(C1443b.URL);
                break;
            case TEXT:
                c1442a.m5458b(c1199m.m4510a());
                c1442a.m5455a(C1443b.TEXT);
                break;
            case SMS:
                c1442a.m5458b(C1445b.m5470d(c1199m.m4510a()));
                c1442a.m5455a(C1443b.SMS);
                break;
            case EMAIL_ADDRESS:
                c1442a.m5458b(C1445b.m5471e(c1199m.m4510a()));
                c1442a.m5455a(C1443b.EMAIL);
                break;
            case TEL:
                c1442a.m5458b(C1445b.m5472f(c1199m.m4510a()));
                c1442a.m5455a(C1443b.CALL);
                break;
            case CALENDAR:
                c1442a.m5458b(C1445b.m5467a(c1199m.m4510a()));
                c1442a.m5455a(C1443b.CALENDAR);
                break;
            case ADDRESSBOOK:
                c1442a.m5458b(C1445b.m5468b(c1199m.m4510a()));
                c1442a.m5455a(C1443b.CONTACT);
                break;
            default:
                if (!(m5572j() || m5571i())) {
                    c1442a.m5458b(c1199m.m4510a());
                    c1442a.m5455a(C1443b.TEXT);
                    break;
                }
        }
        new C1486h(getActivity()).m5601a(c1442a.m5457a());
    }

    private void m5561a(String str) {
    }

    private boolean m5562a(C1199m c1199m, C1454a c1454a, Bitmap bitmap) {
        if (c1454a.mo1526c() <= 0) {
            return false;
        }
        c1454a.mo1525a(0);
        return true;
    }

    private void m5564b(C1199m c1199m) {
        Toast.makeText(getActivity(), C1455b.m5500a(this, c1199m).m5497d(), 1).show();
    }

    private boolean m5566b(String str) {
        if (str == null) {
            return false;
        }
        String str2 = "http://";
        str2 = "https://";
        str2 = str.toLowerCase();
        return str2.startsWith("http://") || str2.startsWith("https://");
    }

    private boolean m5567e() {
        return false;
    }

    private void m5568f() {
        this.f3464c = null;
        this.f3475n = true;
        m5574l();
        SurfaceView surfaceView = (SurfaceView) getActivity().findViewById(R.id.preview_view);
        SurfaceHolder holder = surfaceView.getHolder();
        surfaceView.setVisibility(0);
        if (!this.f3468g || holder.getSurface() == null) {
            holder.addCallback(this);
            holder.setType(3);
        } else {
            m5558a(holder);
        }
        this.f3474m.m5594c();
        Intent intent = getActivity().getIntent();
        this.f3471j = C1472a.NATIVE_APP_INTENT;
        this.f3472k = C1474a.m5587a(intent);
        this.f3473l = intent.getStringExtra("CHARACTER_SET");
        PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.f3469h = true;
        if (this.f3469h && ((AudioManager) getActivity().getSystemService("audio")).getRingerMode() != 2) {
            this.f3469h = false;
        }
        m5576n();
        if (m5582c()) {
            getView().setVisibility(0);
        } else {
            getView().setVisibility(4);
        }
        m5569g();
    }

    private void m5569g() {
    }

    private void m5570h() {
        this.f3477p = C1514b.m5648a((int) R.string.title_notice, (int) R.string.unknown_error);
        this.f3477p.m5651a(this.f3479r);
        this.f3477p.setCancelable(false);
        FragmentTransaction beginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        beginTransaction.add(this.f3477p, "notice");
        try {
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean m5571i() {
        return false;
    }

    private boolean m5572j() {
        return false;
    }

    private void m5573k() {
        if (this.f3469h && this.f3466e != null) {
            this.f3466e.start();
        }
        if (this.f3470i) {
            ((Vibrator) getActivity().getSystemService("vibrator")).vibrate(200);
        }
    }

    private void m5574l() {
        this.f3465d.setVisibility(0);
        this.f3467f = null;
    }

    private void m5575m() {
        if (getActivity().hasWindowFocus()) {
            Builder builder = new Builder(getActivity(), 3);
            builder.setTitle(getString(R.string.app_name_tel));
            builder.setMessage(getString(R.string.msg_camera_framework_bug));
            builder.setPositiveButton(R.string.btn_ok, new C1477d(getActivity()));
            builder.setOnCancelListener(new C1477d(getActivity()));
            builder.show();
        }
    }

    private void m5576n() {
        if (this.f3469h && this.f3466e == null) {
            getActivity().setVolumeControlStream(3);
            this.f3466e = new MediaPlayer();
            this.f3466e.setAudioStreamType(3);
            this.f3466e.setOnCompletionListener(this.f3478q);
            AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(R.raw.scan_beep);
            try {
                this.f3466e.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.f3466e.setVolume(0.1f, 0.1f);
                this.f3466e.prepare();
            } catch (IOException e) {
                this.f3466e = null;
            }
        }
    }

    public ViewfinderView m5577a() {
        return this.f3465d;
    }

    void m5578a(long j) {
        if (getView() != null) {
            getView().postDelayed(new C14703(this), j);
        }
    }

    public void m5579a(C1199m c1199m, Bitmap bitmap) {
        this.f3474m.m5592a();
        this.f3467f = c1199m;
        C1454a a = C1455b.m5500a(this, c1199m);
        if (bitmap != null) {
            m5556a(bitmap, c1199m);
            m5573k();
            m5560a(c1199m, a);
            String c1199m2 = c1199m.toString();
            if (m5566b(c1199m2)) {
                m5561a(c1199m2);
                return;
            } else if (a.m5498e() == C1035r.TEXT) {
                String[] split = c1199m2.split("\\|");
                for (String str : split) {
                    C1216a.m4519a(f3462a, "result = " + str);
                }
                Intent intent;
                if ("TWALLET".equalsIgnoreCase(split[0])) {
                    if ("O".equalsIgnoreCase(split[1])) {
                        if (split.length == 4) {
                            intent = new Intent(getActivity(), TCashOthersActivity.class);
                            intent.putExtra("PARTNER_CODE", split[2]);
                            intent.putExtra("BILLING_CODE", split[3]);
                            startActivity(intent);
                            getActivity().finish();
                            return;
                        }
                        m5570h();
                        return;
                    } else if ("M".equalsIgnoreCase(split[1])) {
                        if (split.length == 4) {
                            intent = new Intent(getActivity(), TCashMerchantActivty.class);
                            if (this.f3476o) {
                                intent.putExtra(C1358h.f2940k, C1358h.f2943n);
                            }
                            intent.putExtra("MERCHANT_CODE", split[2]);
                            if (split[3].trim().matches("^[0-9]*$")) {
                                intent.putExtra("AMOUNT", split[3].trim());
                                startActivity(intent);
                            } else {
                                m5570h();
                            }
                            getActivity().finish();
                            return;
                        }
                        m5570h();
                        return;
                    } else if (!"P".equalsIgnoreCase(split[1])) {
                        m5570h();
                        return;
                    } else if (split.length == 4) {
                        intent = new Intent(getActivity(), TCashTransferActivity.class);
                        intent.putExtra("MSISDN", split[2]);
                        if (split[3].trim().matches("^[0-9]*$")) {
                            C1216a.m4519a(f3462a, "check fine?");
                            intent.putExtra("AMOUNT", split[3].trim());
                            startActivity(intent);
                        } else {
                            m5570h();
                        }
                        getActivity().finish();
                        return;
                    } else {
                        m5570h();
                        return;
                    }
                } else if (c1199m2.length() == 21) {
                    intent = new Intent(getActivity(), CouponListActivity.class);
                    intent.putExtra("COUPON_LIST_MODE", Size.CROP);
                    startActivity(intent);
                    return;
                } else {
                    m5570h();
                    return;
                }
            } else if (a.m5498e() == C1035r.ADDRESSBOOK) {
                m5559a(c1199m);
            } else if (!m5562a(c1199m, a, bitmap)) {
                m5564b(c1199m);
                return;
            } else {
                return;
            }
        }
        if (this.f3464c != null) {
            this.f3464c.sendEmptyMessageDelayed(R.id.restart_preview, 1500);
        }
    }

    public void m5580a(boolean z) {
        this.f3476o = z;
    }

    public Handler m5581b() {
        return this.f3464c;
    }

    boolean m5582c() {
        return 1 == getResources().getConfiguration().orientation;
    }

    public void m5583d() {
        this.f3465d.m5585a();
    }

    public void onActivityCreated(Bundle bundle) {
        C1216a.m4522b(f3462a, "onActivityCreated");
        if (!m5582c()) {
            getView().setVisibility(4);
        }
        getActivity().getWindow().addFlags(128);
        C1437c.m5429a(((C1359a) getActivity()).getApplication());
        this.f3465d = (ViewfinderView) getActivity().findViewById(R.id.viewfinder_view);
        this.f3474m = new C1481e(getActivity());
        m5578a(0);
        super.onActivityCreated(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!m5567e()) {
            getActivity().setRequestedOrientation(1);
            if (m5582c()) {
                this.f3468g = true;
                m5568f();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        getActivity().setRequestedOrientation(1);
        super.onCreate(bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, menuInflater);
        getActivity().setRequestedOrientation(1);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().setRequestedOrientation(1);
        View inflate = layoutInflater.inflate(R.layout.fragment_scanner_capture, viewGroup, false);
        if (!m5582c()) {
            inflate.setVisibility(4);
        }
        return inflate;
    }

    public void onDestroyView() {
        this.f3474m.m5595d();
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        getActivity().setRequestedOrientation(1);
        if (m5567e()) {
            m5578a(0);
        }
        super.onResume();
    }

    public void onStop() {
        C1216a.m4522b(f3462a, "onStop");
        if (this.f3464c != null) {
            this.f3464c.m5600a();
            this.f3464c = null;
        }
        this.f3474m.m5593b();
        C1437c.m5428a().m5433b();
        if (!this.f3468g) {
            ((SurfaceView) getActivity().findViewById(R.id.preview_view)).getHolder().removeCallback(this);
        }
        super.onStop();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!this.f3468g && this.f3475n) {
            m5558a(surfaceHolder);
        }
        this.f3468g = true;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C1216a.m4522b(f3462a, "surfaceDestroyed");
        this.f3468g = false;
        this.f3475n = false;
        surfaceHolder.removeCallback(this);
    }
}
