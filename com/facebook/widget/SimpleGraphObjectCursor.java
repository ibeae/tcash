package com.facebook.widget;

import android.database.CursorIndexOutOfBoundsException;
import com.facebook.model.GraphObject;
import java.util.ArrayList;
import java.util.Collection;

class SimpleGraphObjectCursor<T extends GraphObject> implements GraphObjectCursor<T> {
    private boolean closed = false;
    private boolean fromCache = false;
    private ArrayList<T> graphObjects = new ArrayList();
    private boolean moreObjectsAvailable = false;
    private int pos = -1;

    SimpleGraphObjectCursor() {
    }

    SimpleGraphObjectCursor(SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
        this.pos = simpleGraphObjectCursor.pos;
        this.closed = simpleGraphObjectCursor.closed;
        this.graphObjects = new ArrayList();
        this.graphObjects.addAll(simpleGraphObjectCursor.graphObjects);
        this.fromCache = simpleGraphObjectCursor.fromCache;
    }

    public void addGraphObjects(Collection<T> collection, boolean z) {
        this.graphObjects.addAll(collection);
        this.fromCache |= z;
    }

    public boolean areMoreObjectsAvailable() {
        return this.moreObjectsAvailable;
    }

    public void close() {
        this.closed = true;
    }

    public int getCount() {
        return this.graphObjects.size();
    }

    public T getGraphObject() {
        if (this.pos < 0) {
            throw new CursorIndexOutOfBoundsException("Before first object.");
        } else if (this.pos < this.graphObjects.size()) {
            return (GraphObject) this.graphObjects.get(this.pos);
        } else {
            throw new CursorIndexOutOfBoundsException("After last object.");
        }
    }

    public int getPosition() {
        return this.pos;
    }

    public boolean isAfterLast() {
        int count = getCount();
        return count == 0 || this.pos == count;
    }

    public boolean isBeforeFirst() {
        return getCount() == 0 || this.pos == -1;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isFirst() {
        return this.pos == 0 && getCount() != 0;
    }

    public boolean isFromCache() {
        return this.fromCache;
    }

    public boolean isLast() {
        int count = getCount();
        return this.pos == count + -1 && count != 0;
    }

    public boolean move(int i) {
        return moveToPosition(this.pos + i);
    }

    public boolean moveToFirst() {
        return moveToPosition(0);
    }

    public boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    public boolean moveToNext() {
        return moveToPosition(this.pos + 1);
    }

    public boolean moveToPosition(int i) {
        int count = getCount();
        if (i >= count) {
            this.pos = count;
            return false;
        } else if (i < 0) {
            this.pos = -1;
            return false;
        } else {
            this.pos = i;
            return true;
        }
    }

    public boolean moveToPrevious() {
        return moveToPosition(this.pos - 1);
    }

    public void setFromCache(boolean z) {
        this.fromCache = z;
    }

    public void setMoreObjectsAvailable(boolean z) {
        this.moreObjectsAvailable = z;
    }
}
