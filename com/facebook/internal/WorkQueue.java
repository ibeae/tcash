package com.facebook.internal;

import com.facebook.Settings;
import java.util.concurrent.Executor;

class WorkQueue {
    static final /* synthetic */ boolean $assertionsDisabled = (!WorkQueue.class.desiredAssertionStatus());
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    private WorkNode pendingJobs;
    private int runningCount;
    private WorkNode runningJobs;
    private final Object workLock;

    interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    private class WorkNode implements WorkItem {
        static final /* synthetic */ boolean $assertionsDisabled = (!WorkQueue.class.desiredAssertionStatus());
        private final Runnable callback;
        private boolean isRunning;
        private WorkNode next;
        private WorkNode prev;

        WorkNode(Runnable runnable) {
            this.callback = runnable;
        }

        WorkNode addToList(WorkNode workNode, boolean z) {
            if (!$assertionsDisabled && this.next != null) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.prev == null) {
                WorkNode workNode2;
                if (workNode == null) {
                    this.prev = this;
                    this.next = this;
                    workNode2 = this;
                } else {
                    this.next = workNode;
                    this.prev = workNode.prev;
                    workNode2 = this.next;
                    this.prev.next = this;
                    workNode2.prev = this;
                    workNode2 = workNode;
                }
                return z ? this : workNode2;
            } else {
                throw new AssertionError();
            }
        }

        public boolean cancel() {
            synchronized (WorkQueue.this.workLock) {
                if (isRunning()) {
                    return false;
                }
                WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
                return true;
            }
        }

        Runnable getCallback() {
            return this.callback;
        }

        WorkNode getNext() {
            return this.next;
        }

        public boolean isRunning() {
            return this.isRunning;
        }

        public void moveToFront() {
            synchronized (WorkQueue.this.workLock) {
                if (!isRunning()) {
                    WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
                    WorkQueue.this.pendingJobs = addToList(WorkQueue.this.pendingJobs, true);
                }
            }
        }

        WorkNode removeFromList(WorkNode workNode) {
            if (!$assertionsDisabled && this.next == null) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.prev != null) {
                if (workNode == this) {
                    workNode = this.next == this ? null : this.next;
                }
                this.next.prev = this.prev;
                this.prev.next = this.next;
                this.prev = null;
                this.next = null;
                return workNode;
            } else {
                throw new AssertionError();
            }
        }

        void setIsRunning(boolean z) {
            this.isRunning = z;
        }

        void verify(boolean z) {
            if (!$assertionsDisabled && this.prev.next != this) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.next.prev != this) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && isRunning() != z) {
                throw new AssertionError();
            }
        }
    }

    WorkQueue() {
        this(8);
    }

    WorkQueue(int i) {
        this(i, Settings.getExecutor());
    }

    WorkQueue(int i, Executor executor) {
        this.workLock = new Object();
        this.runningJobs = null;
        this.runningCount = 0;
        this.maxConcurrent = i;
        this.executor = executor;
    }

    private void execute(final WorkNode workNode) {
        this.executor.execute(new Runnable() {
            public void run() {
                try {
                    workNode.getCallback().run();
                } finally {
                    WorkQueue.this.finishItemAndStartNew(workNode);
                }
            }
        });
    }

    private void finishItemAndStartNew(WorkNode workNode) {
        WorkNode workNode2 = null;
        synchronized (this.workLock) {
            if (workNode != null) {
                this.runningJobs = workNode.removeFromList(this.runningJobs);
                this.runningCount--;
            }
            if (this.runningCount < this.maxConcurrent) {
                workNode2 = this.pendingJobs;
                if (workNode2 != null) {
                    this.pendingJobs = workNode2.removeFromList(this.pendingJobs);
                    this.runningJobs = workNode2.addToList(this.runningJobs, false);
                    this.runningCount++;
                    workNode2.setIsRunning(true);
                }
            }
        }
        if (workNode2 != null) {
            execute(workNode2);
        }
    }

    private void startItem() {
        finishItemAndStartNew(null);
    }

    WorkItem addActiveWorkItem(Runnable runnable) {
        return addActiveWorkItem(runnable, true);
    }

    WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        WorkItem workNode = new WorkNode(runnable);
        synchronized (this.workLock) {
            this.pendingJobs = workNode.addToList(this.pendingJobs, z);
        }
        startItem();
        return workNode;
    }

    void validate() {
        synchronized (this.workLock) {
            int i = 0;
            if (this.runningJobs != null) {
                WorkNode workNode = this.runningJobs;
                do {
                    workNode.verify(true);
                    i++;
                    workNode = workNode.getNext();
                } while (workNode != this.runningJobs);
            }
            if ($assertionsDisabled || this.runningCount == r0) {
            } else {
                throw new AssertionError();
            }
        }
    }
}
