package com.skcc.wallet.framework;

import android.app.Application;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import com.p005a.p006a.p013b.C0232b.C0229a;
import com.p005a.p006a.p013b.C0235c;
import com.p005a.p006a.p013b.C0242d.C0237a;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.framework.api.C1227c;
import com.skcc.wallet.framework.api.C1233h;
import com.skcc.wallet.framework.api.C1260j;
import com.skcc.wallet.framework.api.C1262l;
import com.skcc.wallet.framework.api.C1270p;
import com.skcc.wallet.framework.api.C1272r;
import com.skcc.wallet.framework.api.C1298u;
import com.skcc.wallet.framework.api.http.C1252m;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.annotation.ReportsCrashes;
import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;

@ReportsCrashes(customReportContent = {ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME, ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL, ReportField.CUSTOM_DATA, ReportField.STACK_TRACE, ReportField.LOGCAT}, formKey = "")
public class C1302b extends Application {
    public static final Boolean f2781a = Boolean.valueOf(false);
    private static C1298u f2782b = null;
    private static C1270p f2783c = null;
    private static C1260j f2784d = null;
    private static C1272r f2785e = null;
    private static C1227c f2786f = null;
    private static C1233h f2787g = null;
    private static C1262l f2788h = null;
    private static String f2789i = null;

    public class C1299a implements ReportSender {
        final /* synthetic */ C1302b f2779a;

        public C1299a(C1302b c1302b, String str) {
            this.f2779a = c1302b;
            C1216a.m4523c("YourOwnSender", "arg:" + str);
        }

        public void send(CrashReportData crashReportData) {
            C1216a.m4522b("YourOwnSender", "report:" + crashReportData.toString());
            this.f2779a.m4741a(crashReportData.toString());
        }
    }

    public C1298u m4739a() {
        if (f2782b == null) {
            f2782b = new C1298u(this, "W1234567870");
        }
        return f2782b;
    }

    public void m4740a(Exception exception) {
        PrintWriter printWriter;
        Throwable th;
        Writer writer;
        StringWriter stringWriter = null;
        try {
            Writer stringWriter2 = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter2);
            } catch (Throwable th2) {
                th = th2;
                printWriter = null;
                writer = stringWriter2;
                if (printWriter != null) {
                    try {
                        printWriter.close();
                    } catch (IOException e) {
                        throw th;
                    }
                }
                if (stringWriter != null) {
                    stringWriter.close();
                }
                throw th;
            }
            try {
                exception.printStackTrace(printWriter);
                String stringWriter3 = stringWriter2.toString();
                if (printWriter != null) {
                    try {
                        printWriter.close();
                    } catch (IOException e2) {
                    }
                }
                if (stringWriter2 != null) {
                    stringWriter2.close();
                }
                m4741a(stringWriter3);
            } catch (Throwable th3) {
                th = th3;
                writer = stringWriter2;
                if (printWriter != null) {
                    printWriter.close();
                }
                if (stringWriter != null) {
                    stringWriter.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            printWriter = null;
            if (printWriter != null) {
                printWriter.close();
            }
            if (stringWriter != null) {
                stringWriter.close();
            }
            throw th;
        }
    }

    public void m4741a(String str) {
        m4739a().m4683a(str);
    }

    public C1270p m4742b() {
        if (!f2781a.booleanValue()) {
            return null;
        }
        if (f2783c == null) {
            f2783c = new C1270p(this);
        }
        return f2783c;
    }

    public void m4743c() {
        if (f2783c != null) {
            f2783c = null;
        }
    }

    public C1260j m4744d() {
        if (f2784d == null) {
            String string = getSharedPreferences("prefs", 0).getString("serverUrl", null);
            if (string == null) {
                f2784d = new C1260j(this, new C1252m("corpay server", "https://mwallet.telkomsel.com/telkomsel/ci"));
            } else {
                f2784d = new C1260j(this, new C1252m("corpay server", string));
            }
            f2784d.m4621e();
        }
        return f2784d;
    }

    public C1272r m4745e() {
        if (f2785e == null) {
            f2785e = new C1272r(this);
        }
        return f2785e;
    }

    public C1227c m4746f() {
        if (f2786f == null) {
            f2786f = new C1227c(this);
        }
        return f2786f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        super.onCreate();
        if (f2781a.booleanValue()) {
            f2783c = m4742b();
        } else {
            f2783c = null;
        }
        C0235c.m775a().m776a(new C0237a(this).m800a(new C0229a().m771a(true).m773b(true).m772a()).m799a().m801b());
        Editor edit = getSharedPreferences("prefs", 0).edit();
        edit.putBoolean("isSynchFinished", false);
        edit.commit();
        ACRA.init(this);
        ACRA.getErrorReporter().setReportSender(new C1299a(this, "ACRA Sender start!"));
    }

    public void onLowMemory() {
        super.onLowMemory();
        f2787g = null;
        f2788h = null;
    }
}
