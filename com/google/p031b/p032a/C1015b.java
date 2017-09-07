package com.google.p031b.p032a;

import com.google.p031b.C1014k;
import com.google.p031b.C1016a;
import com.google.p031b.C1062c;
import com.google.p031b.C1084e;
import com.google.p031b.C1155g;
import com.google.p031b.C1178o;
import com.google.p031b.C1198j;
import com.google.p031b.C1199m;
import com.google.p031b.C1200n;
import com.google.p031b.C1201p;
import com.google.p031b.p032a.p033a.C1009a;
import com.google.p031b.p032a.p035b.C1013a;
import com.google.p031b.p034c.C1055e;
import java.util.List;
import java.util.Map;

public final class C1015b implements C1014k {
    public C1199m mo1414a(C1062c c1062c, Map<C1084e, ?> map) {
        C1011a a;
        C1178o[] e;
        C1055e a2;
        C1198j c1198j;
        C1198j e2;
        C1055e c1055e;
        C1178o[] c1178oArr;
        C1155g e3;
        C1201p c1201p;
        C1199m c1199m;
        List c;
        String d;
        C1155g c1155g;
        C1155g c1155g2 = null;
        C1013a c1013a = new C1013a(c1062c.m3899c());
        try {
            a = c1013a.m3685a(false);
            e = a.m3661e();
            try {
                a2 = new C1009a().m3658a(a);
                c1198j = null;
            } catch (C1198j e4) {
                e2 = e4;
                c1198j = e2;
                a2 = null;
                if (a2 == null) {
                    c1055e = a2;
                    c1178oArr = e;
                } else {
                    try {
                        a = c1013a.m3685a(true);
                        c1055e = new C1009a().m3658a(a);
                        c1178oArr = a.m3661e();
                    } catch (C1198j e22) {
                        if (c1198j != null) {
                            throw c1198j;
                        } else if (c1155g2 != null) {
                            throw c1155g2;
                        } else {
                            throw e22;
                        }
                    } catch (C1155g e32) {
                        if (c1198j != null) {
                            throw c1198j;
                        } else if (c1155g2 != null) {
                            throw c1155g2;
                        } else {
                            throw e32;
                        }
                    }
                }
                if (map != null) {
                    c1201p = (C1201p) map.get(C1084e.NEED_RESULT_POINT_CALLBACK);
                    if (c1201p != null) {
                        for (C1178o a3 : c1178oArr) {
                            c1201p.mo1530a(a3);
                        }
                    }
                }
                c1199m = new C1199m(c1055e.m3867b(), c1055e.m3866a(), c1178oArr, C1016a.AZTEC);
                c = c1055e.m3869c();
                if (c != null) {
                    c1199m.m4511a(C1200n.BYTE_SEGMENTS, c);
                }
                d = c1055e.m3870d();
                if (d != null) {
                    c1199m.m4511a(C1200n.ERROR_CORRECTION_LEVEL, d);
                }
                return c1199m;
            } catch (C1155g e5) {
                e32 = e5;
                c1198j = null;
                c1155g = e32;
                a2 = null;
                c1155g2 = c1155g;
                if (a2 == null) {
                    a = c1013a.m3685a(true);
                    c1055e = new C1009a().m3658a(a);
                    c1178oArr = a.m3661e();
                } else {
                    c1055e = a2;
                    c1178oArr = e;
                }
                if (map != null) {
                    c1201p = (C1201p) map.get(C1084e.NEED_RESULT_POINT_CALLBACK);
                    if (c1201p != null) {
                        while (r1 < r5) {
                            c1201p.mo1530a(a3);
                        }
                    }
                }
                c1199m = new C1199m(c1055e.m3867b(), c1055e.m3866a(), c1178oArr, C1016a.AZTEC);
                c = c1055e.m3869c();
                if (c != null) {
                    c1199m.m4511a(C1200n.BYTE_SEGMENTS, c);
                }
                d = c1055e.m3870d();
                if (d != null) {
                    c1199m.m4511a(C1200n.ERROR_CORRECTION_LEVEL, d);
                }
                return c1199m;
            }
        } catch (C1198j e6) {
            e22 = e6;
            e = null;
            c1198j = e22;
            a2 = null;
            if (a2 == null) {
                c1055e = a2;
                c1178oArr = e;
            } else {
                a = c1013a.m3685a(true);
                c1055e = new C1009a().m3658a(a);
                c1178oArr = a.m3661e();
            }
            if (map != null) {
                c1201p = (C1201p) map.get(C1084e.NEED_RESULT_POINT_CALLBACK);
                if (c1201p != null) {
                    while (r1 < r5) {
                        c1201p.mo1530a(a3);
                    }
                }
            }
            c1199m = new C1199m(c1055e.m3867b(), c1055e.m3866a(), c1178oArr, C1016a.AZTEC);
            c = c1055e.m3869c();
            if (c != null) {
                c1199m.m4511a(C1200n.BYTE_SEGMENTS, c);
            }
            d = c1055e.m3870d();
            if (d != null) {
                c1199m.m4511a(C1200n.ERROR_CORRECTION_LEVEL, d);
            }
            return c1199m;
        } catch (C1155g e7) {
            e32 = e7;
            e = null;
            c1198j = null;
            c1155g = e32;
            a2 = null;
            c1155g2 = c1155g;
            if (a2 == null) {
                a = c1013a.m3685a(true);
                c1055e = new C1009a().m3658a(a);
                c1178oArr = a.m3661e();
            } else {
                c1055e = a2;
                c1178oArr = e;
            }
            if (map != null) {
                c1201p = (C1201p) map.get(C1084e.NEED_RESULT_POINT_CALLBACK);
                if (c1201p != null) {
                    while (r1 < r5) {
                        c1201p.mo1530a(a3);
                    }
                }
            }
            c1199m = new C1199m(c1055e.m3867b(), c1055e.m3866a(), c1178oArr, C1016a.AZTEC);
            c = c1055e.m3869c();
            if (c != null) {
                c1199m.m4511a(C1200n.BYTE_SEGMENTS, c);
            }
            d = c1055e.m3870d();
            if (d != null) {
                c1199m.m4511a(C1200n.ERROR_CORRECTION_LEVEL, d);
            }
            return c1199m;
        }
        if (a2 == null) {
            a = c1013a.m3685a(true);
            c1055e = new C1009a().m3658a(a);
            c1178oArr = a.m3661e();
        } else {
            c1055e = a2;
            c1178oArr = e;
        }
        if (map != null) {
            c1201p = (C1201p) map.get(C1084e.NEED_RESULT_POINT_CALLBACK);
            if (c1201p != null) {
                while (r1 < r5) {
                    c1201p.mo1530a(a3);
                }
            }
        }
        c1199m = new C1199m(c1055e.m3867b(), c1055e.m3866a(), c1178oArr, C1016a.AZTEC);
        c = c1055e.m3869c();
        if (c != null) {
            c1199m.m4511a(C1200n.BYTE_SEGMENTS, c);
        }
        d = c1055e.m3870d();
        if (d != null) {
            c1199m.m4511a(C1200n.ERROR_CORRECTION_LEVEL, d);
        }
        return c1199m;
    }

    public void mo1415a() {
    }
}
