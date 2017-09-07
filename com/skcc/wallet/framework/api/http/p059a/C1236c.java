package com.skcc.wallet.framework.api.http.p059a;

import android.util.Xml;
import com.skcc.wallet.framework.api.http.C1249j;
import com.skcc.wallet.framework.api.http.model.CreateCardRs;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;

public class C1236c extends C1234a {
    private String f2625d = "card_id";
    private String f2626e = "valid_until";

    public CreateCardRs m4551a(String str) {
        InputStream byteArrayInputStream;
        Exception e;
        Throwable th;
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            try {
                newPullParser.setInput(byteArrayInputStream, null);
                Object obj = null;
                CreateCardRs createCardRs = null;
                for (int eventType = newPullParser.getEventType(); eventType != 1 && r0 == null; eventType = newPullParser.next()) {
                    switch (eventType) {
                        case 0:
                            createCardRs = new CreateCardRs();
                            break;
                        case 2:
                            String name = newPullParser.getName();
                            if (createCardRs != null) {
                                if (!name.equalsIgnoreCase(this.b)) {
                                    if (!name.equalsIgnoreCase(this.c)) {
                                        if (!name.equalsIgnoreCase(this.f2625d)) {
                                            if (!name.equalsIgnoreCase(this.f2626e)) {
                                                break;
                                            }
                                            createCardRs.setValidUntil(newPullParser.nextText());
                                            break;
                                        }
                                        createCardRs.setCardId(newPullParser.nextText());
                                        break;
                                    }
                                    createCardRs.setMessage(newPullParser.nextText());
                                    break;
                                }
                                createCardRs.setStatus(newPullParser.nextText());
                                break;
                            }
                            break;
                        case 3:
                            if (!newPullParser.getName().equalsIgnoreCase(this.a)) {
                                break;
                            }
                            int i = 1;
                            break;
                        default:
                            break;
                    }
                }
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e2) {
                    }
                }
                return createCardRs;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayInputStream = null;
            try {
                e.printStackTrace();
                throw new C1249j();
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th;
        }
    }
}
