package com.google.android.gms.p027a;

import android.os.IBinder;
import com.google.android.gms.p027a.C0651c.C0653a;
import java.lang.reflect.Field;

public final class C0654d<T> extends C0653a {
    private final T f809a;

    private C0654d(T t) {
        this.f809a = t;
    }

    public static <T> C0651c m1384a(T t) {
        return new C0654d(t);
    }

    public static <T> T m1385a(C0651c c0651c) {
        if (c0651c instanceof C0654d) {
            return ((C0654d) c0651c).f809a;
        }
        IBinder asBinder = c0651c.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}
