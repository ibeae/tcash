package com.p005a.p006a.p013b.p014a.p015a;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class C0215d<E> extends AbstractQueue<E> implements C0214a<E>, Serializable {
    transient C0220c<E> f295a;
    transient C0220c<E> f296b;
    final ReentrantLock f297c;
    private transient int f298d;
    private final int f299e;
    private final Condition f300f;
    private final Condition f301g;

    private abstract class C0218a implements Iterator<E> {
        C0220c<E> f302a;
        E f303b;
        final /* synthetic */ C0215d f304c;
        private C0220c<E> f305d;

        C0218a(C0215d c0215d) {
            this.f304c = c0215d;
            ReentrantLock reentrantLock = c0215d.f297c;
            reentrantLock.lock();
            try {
                this.f302a = mo264a();
                this.f303b = this.f302a == null ? null : this.f302a.f307a;
            } finally {
                reentrantLock.unlock();
            }
        }

        private C0220c<E> m735b(C0220c<E> c0220c) {
            while (true) {
                C0220c<E> a = mo265a(c0220c);
                if (a == null) {
                    return null;
                }
                if (a.f307a != null) {
                    return a;
                }
                if (a == c0220c) {
                    return mo264a();
                }
                c0220c = a;
            }
        }

        abstract C0220c<E> mo264a();

        abstract C0220c<E> mo265a(C0220c<E> c0220c);

        void m738b() {
            ReentrantLock reentrantLock = this.f304c.f297c;
            reentrantLock.lock();
            try {
                this.f302a = m735b(this.f302a);
                this.f303b = this.f302a == null ? null : this.f302a.f307a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public boolean hasNext() {
            return this.f302a != null;
        }

        public E next() {
            if (this.f302a == null) {
                throw new NoSuchElementException();
            }
            this.f305d = this.f302a;
            E e = this.f303b;
            m738b();
            return e;
        }

        public void remove() {
            C0220c c0220c = this.f305d;
            if (c0220c == null) {
                throw new IllegalStateException();
            }
            this.f305d = null;
            ReentrantLock reentrantLock = this.f304c.f297c;
            reentrantLock.lock();
            try {
                if (c0220c.f307a != null) {
                    this.f304c.m724a(c0220c);
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
            }
        }
    }

    private class C0219b extends C0218a {
        final /* synthetic */ C0215d f306d;

        private C0219b(C0215d c0215d) {
            this.f306d = c0215d;
            super(c0215d);
        }

        C0220c<E> mo264a() {
            return this.f306d.f295a;
        }

        C0220c<E> mo265a(C0220c<E> c0220c) {
            return c0220c.f309c;
        }
    }

    static final class C0220c<E> {
        E f307a;
        C0220c<E> f308b;
        C0220c<E> f309c;

        C0220c(E e) {
            this.f307a = e;
        }
    }

    public C0215d() {
        this(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public C0215d(int i) {
        this.f297c = new ReentrantLock();
        this.f300f = this.f297c.newCondition();
        this.f301g = this.f297c.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.f299e = i;
    }

    private boolean m718b(C0220c<E> c0220c) {
        if (this.f298d >= this.f299e) {
            return false;
        }
        C0220c c0220c2 = this.f295a;
        c0220c.f309c = c0220c2;
        this.f295a = c0220c;
        if (this.f296b == null) {
            this.f296b = c0220c;
        } else {
            c0220c2.f308b = c0220c;
        }
        this.f298d++;
        this.f300f.signal();
        return true;
    }

    private boolean m719c(C0220c<E> c0220c) {
        if (this.f298d >= this.f299e) {
            return false;
        }
        C0220c c0220c2 = this.f296b;
        c0220c.f308b = c0220c2;
        this.f296b = c0220c;
        if (this.f295a == null) {
            this.f295a = c0220c;
        } else {
            c0220c2.f309c = c0220c;
        }
        this.f298d++;
        this.f300f.signal();
        return true;
    }

    private E m720f() {
        C0220c c0220c = this.f295a;
        if (c0220c == null) {
            return null;
        }
        C0220c c0220c2 = c0220c.f309c;
        E e = c0220c.f307a;
        c0220c.f307a = null;
        c0220c.f309c = c0220c;
        this.f295a = c0220c2;
        if (c0220c2 == null) {
            this.f296b = null;
        } else {
            c0220c2.f308b = null;
        }
        this.f298d--;
        this.f301g.signal();
        return e;
    }

    private E m721g() {
        C0220c c0220c = this.f296b;
        if (c0220c == null) {
            return null;
        }
        C0220c c0220c2 = c0220c.f308b;
        E e = c0220c.f307a;
        c0220c.f307a = null;
        c0220c.f308b = c0220c;
        this.f296b = c0220c2;
        if (c0220c2 == null) {
            this.f295a = null;
        } else {
            c0220c2.f309c = null;
        }
        this.f298d--;
        this.f301g.signal();
        return e;
    }

    public E m722a() {
        E b = m727b();
        if (b != null) {
            return b;
        }
        throw new NoSuchElementException();
    }

    public E m723a(long j, TimeUnit timeUnit) {
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lockInterruptibly();
        long j2 = toNanos;
        while (true) {
            try {
                E f = m720f();
                if (f != null) {
                    reentrantLock.unlock();
                    return f;
                } else if (j2 <= 0) {
                    break;
                } else {
                    j2 = this.f300f.awaitNanos(j2);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return null;
    }

    void m724a(C0220c<E> c0220c) {
        C0220c c0220c2 = c0220c.f308b;
        C0220c c0220c3 = c0220c.f309c;
        if (c0220c2 == null) {
            m720f();
        } else if (c0220c3 == null) {
            m721g();
        } else {
            c0220c2.f309c = c0220c3;
            c0220c3.f308b = c0220c2;
            c0220c.f307a = null;
            this.f298d--;
            this.f301g.signal();
        }
    }

    public void m725a(E e) {
        if (!m730c((Object) e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public boolean m726a(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        C0220c c0220c = new C0220c(e);
        long toNanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lockInterruptibly();
        while (!m719c(c0220c)) {
            try {
                if (toNanos <= 0) {
                    return false;
                }
                toNanos = this.f301g.awaitNanos(toNanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public boolean add(E e) {
        m725a((Object) e);
        return true;
    }

    public E m727b() {
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        try {
            E f = m720f();
            return f;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean m728b(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C0220c c0220c = new C0220c(e);
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        try {
            boolean b = m718b(c0220c);
            return b;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E m729c() {
        E f;
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        while (true) {
            try {
                f = m720f();
                if (f != null) {
                    break;
                }
                this.f300f.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        return f;
    }

    public boolean m730c(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C0220c c0220c = new C0220c(e);
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        try {
            boolean c = m719c(c0220c);
            return c;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void clear() {
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        try {
            C0220c c0220c = this.f295a;
            while (c0220c != null) {
                c0220c.f307a = null;
                C0220c c0220c2 = c0220c.f309c;
                c0220c.f308b = null;
                c0220c.f309c = null;
                c0220c = c0220c2;
            }
            this.f296b = null;
            this.f295a = null;
            this.f298d = 0;
            this.f301g.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        try {
            for (C0220c c0220c = this.f295a; c0220c != null; c0220c = c0220c.f309c) {
                if (obj.equals(c0220c.f307a)) {
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E m731d() {
        E e = m733e();
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    public void m732d(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C0220c c0220c = new C0220c(e);
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        while (!m719c(c0220c)) {
            try {
                this.f301g.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        } else if (collection == this) {
            throw new IllegalArgumentException();
        } else {
            ReentrantLock reentrantLock = this.f297c;
            reentrantLock.lock();
            try {
                int min = Math.min(i, this.f298d);
                for (int i2 = 0; i2 < min; i2++) {
                    collection.add(this.f295a.f307a);
                    m720f();
                }
                return min;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E m733e() {
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        try {
            E e = this.f295a == null ? null : this.f295a.f307a;
            reentrantLock.unlock();
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    public boolean m734e(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        try {
            for (C0220c c0220c = this.f295a; c0220c != null; c0220c = c0220c.f309c) {
                if (obj.equals(c0220c.f307a)) {
                    m724a(c0220c);
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E element() {
        return m731d();
    }

    public Iterator<E> iterator() {
        return new C0219b();
    }

    public boolean offer(E e) {
        return m730c((Object) e);
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return m726a(e, j, timeUnit);
    }

    public E peek() {
        return m733e();
    }

    public E poll() {
        return m727b();
    }

    public E poll(long j, TimeUnit timeUnit) {
        return m723a(j, timeUnit);
    }

    public void put(E e) {
        m732d(e);
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        try {
            int i = this.f299e - this.f298d;
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E remove() {
        return m722a();
    }

    public boolean remove(Object obj) {
        return m734e(obj);
    }

    public int size() {
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        try {
            int i = this.f298d;
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E take() {
        return m729c();
    }

    public Object[] toArray() {
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.f298d];
            int i = 0;
            C0220c c0220c = this.f295a;
            while (c0220c != null) {
                int i2 = i + 1;
                objArr[i] = c0220c.f307a;
                c0220c = c0220c.f309c;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        try {
            if (tArr.length < this.f298d) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f298d);
            }
            int i = 0;
            C0220c c0220c = this.f295a;
            while (c0220c != null) {
                int i2 = i + 1;
                tArr[i] = c0220c.f307a;
                c0220c = c0220c.f309c;
                i = i2;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            reentrantLock.unlock();
            return tArr;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    public String toString() {
        ReentrantLock reentrantLock = this.f297c;
        reentrantLock.lock();
        try {
            String str;
            C0220c c0220c = this.f295a;
            if (c0220c == null) {
                str = "[]";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('[');
                C0220c c0220c2 = c0220c;
                while (true) {
                    Object obj = c0220c2.f307a;
                    if (obj == this) {
                        obj = "(this Collection)";
                    }
                    stringBuilder.append(obj);
                    c0220c = c0220c2.f309c;
                    if (c0220c == null) {
                        break;
                    }
                    stringBuilder.append(',').append(' ');
                    c0220c2 = c0220c;
                }
                str = stringBuilder.append(']').toString();
                reentrantLock.unlock();
            }
            return str;
        } finally {
            reentrantLock.unlock();
        }
    }
}
