package com.skcc.wallet.framework.p060b;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class C1301b {
    private Map<String, Object> f2780a = new HashMap();

    public C1301b() {
        this.f2780a.put("output", "xml");
    }

    public Iterator<String> m4737a() {
        return this.f2780a.keySet().iterator();
    }

    public void m4738a(String str, String str2) {
        this.f2780a.put(str, str2);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator a = m4737a();
        while (a.hasNext()) {
            String str = (String) a.next();
            Object obj = this.f2780a.get(str);
            if (obj != null) {
                String[] strArr = obj instanceof String ? new String[]{(String) obj} : obj instanceof String[] ? (String[]) obj : null;
                int i = 0;
                while (i < strArr.length) {
                    if (strArr[i] == null || strArr[i].length() == 0) {
                        if (stringBuffer.length() == 0) {
                            stringBuffer.append(str + "=");
                        } else {
                            stringBuffer.append("&" + str + "=");
                        }
                    } else if (stringBuffer.length() == 0) {
                        stringBuffer.append(str + "=" + URLEncoder.encode(strArr[i]));
                    } else {
                        stringBuffer.append("&" + str + "=" + URLEncoder.encode(strArr[i]));
                    }
                    i++;
                }
            } else if (stringBuffer.length() == 0) {
                stringBuffer.append(str + "=");
            } else {
                stringBuffer.append("&" + str + "=");
            }
        }
        return stringBuffer.toString();
    }
}
