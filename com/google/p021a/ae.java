package com.google.p021a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;

abstract class ae implements C0513i {
    ae() {
    }

    public final String mo801a(C0607h c0607h) {
        return mo842a(c0607h.m1208a(), c0607h.m1211b(), c0607h.m1213d());
    }

    protected abstract String mo842a(String str, Type type, Collection<Annotation> collection);
}
