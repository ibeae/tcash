package com.facebook;

import android.os.Handler;
import com.facebook.Request.Callback;
import com.facebook.Request.OnProgressCallback;

class RequestProgress {
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;
    private final Request request;
    private final long threshold = Settings.getOnProgressThreshold();

    RequestProgress(Handler handler, Request request) {
        this.request = request;
        this.callbackHandler = handler;
    }

    void addProgress(long j) {
        this.progress += j;
        if (this.progress >= this.lastReportedProgress + this.threshold || this.progress >= this.maxProgress) {
            reportProgress();
        }
    }

    void addToMax(long j) {
        this.maxProgress += j;
    }

    long getMaxProgress() {
        return this.maxProgress;
    }

    long getProgress() {
        return this.progress;
    }

    void reportProgress() {
        if (this.progress > this.lastReportedProgress) {
            Callback callback = this.request.getCallback();
            if (this.maxProgress > 0 && (callback instanceof OnProgressCallback)) {
                final long j = this.progress;
                final long j2 = this.maxProgress;
                final OnProgressCallback onProgressCallback = (OnProgressCallback) callback;
                if (this.callbackHandler == null) {
                    onProgressCallback.onProgress(j, j2);
                } else {
                    this.callbackHandler.post(new Runnable() {
                        public void run() {
                            onProgressCallback.onProgress(j, j2);
                        }
                    });
                }
                this.lastReportedProgress = this.progress;
            }
        }
    }
}
