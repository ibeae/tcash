package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class bi extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private final dt f1029a;
    private final MediaController f1030b;
    private final C0706a f1031c = new C0706a(this);
    private final VideoView f1032d;
    private long f1033e;
    private String f1034f;

    private static final class C0706a {
        private final Runnable f1027a;
        private volatile boolean f1028b = false;

        public C0706a(final bi biVar) {
            this.f1027a = new Runnable(this) {
                final /* synthetic */ C0706a f1025b;
                private final WeakReference<bi> f1026c = new WeakReference(biVar);

                public void run() {
                    bi biVar = (bi) this.f1026c.get();
                    if (!this.f1025b.f1028b && biVar != null) {
                        biVar.m1727e();
                        this.f1025b.m1714b();
                    }
                }
            };
        }

        public void m1713a() {
            this.f1028b = true;
            dp.f1344a.removeCallbacks(this.f1027a);
        }

        public void m1714b() {
            dp.f1344a.postDelayed(this.f1027a, 250);
        }
    }

    public bi(Context context, dt dtVar) {
        super(context);
        this.f1029a = dtVar;
        this.f1032d = new VideoView(context);
        addView(this.f1032d, new LayoutParams(-1, -1, 17));
        this.f1030b = new MediaController(context);
        this.f1031c.m1714b();
        this.f1032d.setOnCompletionListener(this);
        this.f1032d.setOnPreparedListener(this);
        this.f1032d.setOnErrorListener(this);
    }

    private static void m1715a(dt dtVar, String str) {
        m1718a(dtVar, str, new HashMap(1));
    }

    public static void m1716a(dt dtVar, String str, String str2) {
        Object obj = str2 == null ? 1 : null;
        Map hashMap = new HashMap(obj != null ? 2 : 3);
        hashMap.put("what", str);
        if (obj == null) {
            hashMap.put("extra", str2);
        }
        m1718a(dtVar, "error", hashMap);
    }

    private static void m1717a(dt dtVar, String str, String str2, String str3) {
        Map hashMap = new HashMap(2);
        hashMap.put(str2, str3);
        m1718a(dtVar, str, hashMap);
    }

    private static void m1718a(dt dtVar, String str, Map<String, String> map) {
        map.put("event", str);
        dtVar.m2134a("onVideoEvent", (Map) map);
    }

    public void m1719a() {
        this.f1031c.m1713a();
        this.f1032d.stopPlayback();
    }

    public void m1720a(int i) {
        this.f1032d.seekTo(i);
    }

    public void m1721a(MotionEvent motionEvent) {
        this.f1032d.dispatchTouchEvent(motionEvent);
    }

    public void m1722a(String str) {
        this.f1034f = str;
    }

    public void m1723a(boolean z) {
        if (z) {
            this.f1032d.setMediaController(this.f1030b);
            return;
        }
        this.f1030b.hide();
        this.f1032d.setMediaController(null);
    }

    public void m1724b() {
        if (TextUtils.isEmpty(this.f1034f)) {
            m1716a(this.f1029a, "no_src", null);
        } else {
            this.f1032d.setVideoPath(this.f1034f);
        }
    }

    public void m1725c() {
        this.f1032d.pause();
    }

    public void m1726d() {
        this.f1032d.start();
    }

    public void m1727e() {
        long currentPosition = (long) this.f1032d.getCurrentPosition();
        if (this.f1033e != currentPosition) {
            m1717a(this.f1029a, "timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
            this.f1033e = currentPosition;
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m1715a(this.f1029a, "ended");
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        m1716a(this.f1029a, String.valueOf(i), String.valueOf(i2));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        m1717a(this.f1029a, "canplaythrough", "duration", String.valueOf(((float) this.f1032d.getDuration()) / 1000.0f));
    }
}
