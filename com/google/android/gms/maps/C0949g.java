package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.C0666c;
import com.google.android.gms.internal.ek;
import com.google.android.gms.maps.model.C0993l;
import com.google.android.gms.maps.p029a.C0868b;
import com.google.android.gms.maps.p029a.C0874d;
import com.google.android.gms.maps.p029a.ad;
import com.google.android.gms.maps.p029a.ae;
import com.google.android.gms.p027a.C0641a;
import com.google.android.gms.p027a.C0642e;
import com.google.android.gms.p027a.C0650b;
import com.google.android.gms.p027a.C0654d;

public class C0949g extends Fragment {
    private final C0948b f1886a = new C0948b(this);
    private C0943c f1887b;

    static class C0947a implements C0641a {
        private final Fragment f1881a;
        private final C0874d f1882b;

        public C0947a(Fragment fragment, C0874d c0874d) {
            this.f1882b = (C0874d) ek.m2332a((Object) c0874d);
            this.f1881a = (Fragment) ek.m2332a((Object) fragment);
        }

        public View mo1276a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) C0654d.m1385a(this.f1882b.mo1172a(C0654d.m1384a((Object) layoutInflater), C0654d.m1384a((Object) viewGroup), bundle));
            } catch (RemoteException e) {
                throw new C0993l(e);
            }
        }

        public void mo1277a() {
            try {
                this.f1882b.mo1176b();
            } catch (RemoteException e) {
                throw new C0993l(e);
            }
        }

        public void mo1278a(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f1882b.mo1175a(C0654d.m1384a((Object) activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
            } catch (RemoteException e) {
                throw new C0993l(e);
            }
        }

        public void mo1279a(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new C0993l(e);
                }
            }
            Bundle arguments = this.f1881a.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                ad.m2886a(bundle, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f1882b.mo1174a(bundle);
        }

        public void mo1280b() {
            try {
                this.f1882b.mo1178c();
            } catch (RemoteException e) {
                throw new C0993l(e);
            }
        }

        public void mo1281b(Bundle bundle) {
            try {
                this.f1882b.mo1177b(bundle);
            } catch (RemoteException e) {
                throw new C0993l(e);
            }
        }

        public void mo1282c() {
            try {
                this.f1882b.mo1179d();
            } catch (RemoteException e) {
                throw new C0993l(e);
            }
        }

        public void mo1283d() {
            try {
                this.f1882b.mo1180e();
            } catch (RemoteException e) {
                throw new C0993l(e);
            }
        }

        public void mo1284e() {
            try {
                this.f1882b.mo1181f();
            } catch (RemoteException e) {
                throw new C0993l(e);
            }
        }

        public C0874d m3249f() {
            return this.f1882b;
        }
    }

    static class C0948b extends C0650b<C0947a> {
        protected C0642e<C0947a> f1883a;
        private final Fragment f1884b;
        private Activity f1885c;

        C0948b(Fragment fragment) {
            this.f1884b = fragment;
        }

        private void m3250a(Activity activity) {
            this.f1885c = activity;
            m3253g();
        }

        protected void mo1285a(C0642e<C0947a> c0642e) {
            this.f1883a = c0642e;
            m3253g();
        }

        public void m3253g() {
            if (this.f1885c != null && this.f1883a != null && m1372a() == null) {
                try {
                    C0945e.m3235a(this.f1885c);
                    this.f1883a.mo871a(new C0947a(this.f1884b, ae.m2887a(this.f1885c).mo1256b(C0654d.m1384a(this.f1885c))));
                } catch (RemoteException e) {
                    throw new C0993l(e);
                } catch (C0666c e2) {
                }
            }
        }
    }

    protected C0874d m3254a() {
        this.f1886a.m3253g();
        return this.f1886a.m1372a() == null ? null : ((C0947a) this.f1886a.m1372a()).m3249f();
    }

    public final C0943c m3255b() {
        C0874d a = m3254a();
        if (a == null) {
            return null;
        }
        try {
            C0868b a2 = a.mo1173a();
            if (a2 == null) {
                return null;
            }
            if (this.f1887b == null || this.f1887b.m3228a().asBinder() != a2.asBinder()) {
                this.f1887b = new C0943c(a2);
            }
            return this.f1887b;
        } catch (RemoteException e) {
            throw new C0993l(e);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(C0949g.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1886a.m3250a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1886a.m1374a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f1886a.m1371a(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.f1886a.m1381e();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f1886a.m1380d();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f1886a.m3250a(activity);
        Parcelable a = GoogleMapOptions.m2820a(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", a);
        this.f1886a.m1373a(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.f1886a.m1382f();
        super.onLowMemory();
    }

    public void onPause() {
        this.f1886a.m1379c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f1886a.m1377b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(C0949g.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f1886a.m1378b(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
