package com.skcc.wallet.framework.api.http.p059a;

import android.util.Xml;
import com.skcc.wallet.framework.api.http.C1249j;
import com.skcc.wallet.framework.api.http.model.GetVCardTransactionRs;
import com.skcc.wallet.framework.api.http.model.VCardTransaction;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class C1237d extends C1234a {
    private String f2627d = "transaction";
    private String f2628e = "trx_date";
    private String f2629f = "amount";

    public GetVCardTransactionRs m4552a(String str) {
        InputStream byteArrayInputStream;
        Exception e;
        Throwable th;
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            try {
                newPullParser.setInput(byteArrayInputStream, null);
                int eventType = newPullParser.getEventType();
                List arrayList = new ArrayList();
                GetVCardTransactionRs getVCardTransactionRs = null;
                Object obj = null;
                VCardTransaction vCardTransaction = null;
                for (int i = eventType; i != 1 && r3 == null; i = newPullParser.next()) {
                    String name;
                    switch (i) {
                        case 0:
                            getVCardTransactionRs = new GetVCardTransactionRs();
                            break;
                        case 2:
                            name = newPullParser.getName();
                            if (getVCardTransactionRs != null) {
                                if (!name.equalsIgnoreCase(this.b)) {
                                    if (!name.equalsIgnoreCase(this.c)) {
                                        if (!name.equalsIgnoreCase(this.f2627d)) {
                                            if (vCardTransaction != null) {
                                                if (!name.equalsIgnoreCase(this.f2628e)) {
                                                    if (!name.equalsIgnoreCase(this.f2629f)) {
                                                        break;
                                                    }
                                                    vCardTransaction.setAmount(newPullParser.nextText());
                                                    break;
                                                }
                                                vCardTransaction.setTransactionDate(newPullParser.nextText());
                                                break;
                                            }
                                            break;
                                        }
                                        vCardTransaction = new VCardTransaction();
                                        break;
                                    }
                                    getVCardTransactionRs.setMessage(newPullParser.nextText());
                                    break;
                                }
                                getVCardTransactionRs.setStatus(newPullParser.nextText());
                                break;
                            }
                            break;
                        case 3:
                            name = newPullParser.getName();
                            if (!name.equalsIgnoreCase(this.a)) {
                                if (!name.equalsIgnoreCase(this.f2627d)) {
                                    break;
                                }
                                if (vCardTransaction != null) {
                                    arrayList.add(vCardTransaction);
                                }
                                vCardTransaction = null;
                                break;
                            }
                            eventType = 1;
                            break;
                        default:
                            break;
                    }
                }
                getVCardTransactionRs.setTransactions(arrayList);
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e2) {
                    }
                }
                return getVCardTransactionRs;
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
