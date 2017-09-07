package com.google.p031b.p045f;

import java.util.ArrayList;
import java.util.List;
import twitter4j.HttpResponseCode;

final class C1125h {
    private final List<int[]> f2402a = new ArrayList();
    private final List<String> f2403b = new ArrayList();

    C1125h() {
    }

    private synchronized void m4148a() {
        if (this.f2402a.isEmpty()) {
            m4149a(new int[]{0, 19}, "US/CA");
            m4149a(new int[]{30, 39}, "US");
            m4149a(new int[]{60, 139}, "US/CA");
            m4149a(new int[]{HttpResponseCode.MULTIPLE_CHOICES, 379}, "FR");
            m4149a(new int[]{380}, "BG");
            m4149a(new int[]{383}, "SI");
            m4149a(new int[]{385}, "HR");
            m4149a(new int[]{387}, "BA");
            m4149a(new int[]{HttpResponseCode.BAD_REQUEST, 440}, "DE");
            m4149a(new int[]{450, 459}, "JP");
            m4149a(new int[]{460, 469}, "RU");
            m4149a(new int[]{471}, "TW");
            m4149a(new int[]{474}, "EE");
            m4149a(new int[]{475}, "LV");
            m4149a(new int[]{476}, "AZ");
            m4149a(new int[]{477}, "LT");
            m4149a(new int[]{478}, "UZ");
            m4149a(new int[]{479}, "LK");
            m4149a(new int[]{480}, "PH");
            m4149a(new int[]{481}, "BY");
            m4149a(new int[]{482}, "UA");
            m4149a(new int[]{484}, "MD");
            m4149a(new int[]{485}, "AM");
            m4149a(new int[]{486}, "GE");
            m4149a(new int[]{487}, "KZ");
            m4149a(new int[]{489}, "HK");
            m4149a(new int[]{490, 499}, "JP");
            m4149a(new int[]{HttpResponseCode.INTERNAL_SERVER_ERROR, 509}, "GB");
            m4149a(new int[]{520}, "GR");
            m4149a(new int[]{528}, "LB");
            m4149a(new int[]{529}, "CY");
            m4149a(new int[]{531}, "MK");
            m4149a(new int[]{535}, "MT");
            m4149a(new int[]{539}, "IE");
            m4149a(new int[]{540, 549}, "BE/LU");
            m4149a(new int[]{560}, "PT");
            m4149a(new int[]{569}, "IS");
            m4149a(new int[]{570, 579}, "DK");
            m4149a(new int[]{590}, "PL");
            m4149a(new int[]{594}, "RO");
            m4149a(new int[]{599}, "HU");
            m4149a(new int[]{600, 601}, "ZA");
            m4149a(new int[]{603}, "GH");
            m4149a(new int[]{608}, "BH");
            m4149a(new int[]{609}, "MU");
            m4149a(new int[]{611}, "MA");
            m4149a(new int[]{613}, "DZ");
            m4149a(new int[]{616}, "KE");
            m4149a(new int[]{618}, "CI");
            m4149a(new int[]{619}, "TN");
            m4149a(new int[]{621}, "SY");
            m4149a(new int[]{622}, "EG");
            m4149a(new int[]{624}, "LY");
            m4149a(new int[]{625}, "JO");
            m4149a(new int[]{626}, "IR");
            m4149a(new int[]{627}, "KW");
            m4149a(new int[]{628}, "SA");
            m4149a(new int[]{629}, "AE");
            m4149a(new int[]{640, 649}, "FI");
            m4149a(new int[]{690, 695}, "CN");
            m4149a(new int[]{700, 709}, "NO");
            m4149a(new int[]{729}, "IL");
            m4149a(new int[]{730, 739}, "SE");
            m4149a(new int[]{740}, "GT");
            m4149a(new int[]{741}, "SV");
            m4149a(new int[]{742}, "HN");
            m4149a(new int[]{743}, "NI");
            m4149a(new int[]{744}, "CR");
            m4149a(new int[]{745}, "PA");
            m4149a(new int[]{746}, "DO");
            m4149a(new int[]{750}, "MX");
            m4149a(new int[]{754, 755}, "CA");
            m4149a(new int[]{759}, "VE");
            m4149a(new int[]{760, 769}, "CH");
            m4149a(new int[]{770}, "CO");
            m4149a(new int[]{773}, "UY");
            m4149a(new int[]{775}, "PE");
            m4149a(new int[]{777}, "BO");
            m4149a(new int[]{779}, "AR");
            m4149a(new int[]{780}, "CL");
            m4149a(new int[]{784}, "PY");
            m4149a(new int[]{785}, "PE");
            m4149a(new int[]{786}, "EC");
            m4149a(new int[]{789, 790}, "BR");
            m4149a(new int[]{800, 839}, "IT");
            m4149a(new int[]{840, 849}, "ES");
            m4149a(new int[]{850}, "CU");
            m4149a(new int[]{858}, "SK");
            m4149a(new int[]{859}, "CZ");
            m4149a(new int[]{860}, "YU");
            m4149a(new int[]{865}, "MN");
            m4149a(new int[]{867}, "KP");
            m4149a(new int[]{868, 869}, "TR");
            m4149a(new int[]{870, 879}, "NL");
            m4149a(new int[]{880}, "KR");
            m4149a(new int[]{885}, "TH");
            m4149a(new int[]{888}, "SG");
            m4149a(new int[]{890}, "IN");
            m4149a(new int[]{893}, "VN");
            m4149a(new int[]{896}, "PK");
            m4149a(new int[]{899}, "ID");
            m4149a(new int[]{900, 919}, "AT");
            m4149a(new int[]{930, 939}, "AU");
            m4149a(new int[]{940, 949}, "AZ");
            m4149a(new int[]{955}, "MY");
            m4149a(new int[]{958}, "MO");
        }
    }

    private void m4149a(int[] iArr, String str) {
        this.f2402a.add(iArr);
        this.f2403b.add(str);
    }

    String m4150a(String str) {
        m4148a();
        int parseInt = Integer.parseInt(str.substring(0, 3));
        int size = this.f2402a.size();
        for (int i = 0; i < size; i++) {
            int[] iArr = (int[]) this.f2402a.get(i);
            int i2 = iArr[0];
            if (parseInt < i2) {
                return null;
            }
            if (parseInt <= (iArr.length == 1 ? i2 : iArr[1])) {
                return (String) this.f2403b.get(i);
            }
        }
        return null;
    }
}
