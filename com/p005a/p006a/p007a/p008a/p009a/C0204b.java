package com.p005a.p006a.p007a.p008a.p009a;

import com.p005a.p006a.p007a.p008a.C0202c;
import com.p005a.p006a.p007a.p008a.p010b.C0206a;
import com.p005a.p006a.p013b.C0227a;
import com.p005a.p006a.p020c.C0245a;
import java.io.File;

public class C0204b extends C0202c {
    public C0204b(File file, int i) {
        this(file, C0227a.m743a(), i);
    }

    public C0204b(File file, C0206a c0206a, int i) {
        super(file, c0206a, i);
        if (i < 2097152) {
            C0245a.m805c("You set too small disc cache size (less than %1$d Mb)", Integer.valueOf(2));
        }
    }

    protected int mo261a(File file) {
        return (int) file.length();
    }
}
