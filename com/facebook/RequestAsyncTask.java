package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

public class RequestAsyncTask extends AsyncTask<Void, Void, List<Response>> {
    private static final String TAG = RequestAsyncTask.class.getCanonicalName();
    private static Method executeOnExecutorMethod;
    private final HttpURLConnection connection;
    private Exception exception;
    private final RequestBatch requests;

    static {
        for (Method method : AsyncTask.class.getMethods()) {
            if ("executeOnExecutor".equals(method.getName())) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 2 && parameterTypes[0] == Executor.class && parameterTypes[1].isArray()) {
                    executeOnExecutorMethod = method;
                    return;
                }
            }
        }
    }

    public RequestAsyncTask(RequestBatch requestBatch) {
        this(null, requestBatch);
    }

    public RequestAsyncTask(HttpURLConnection httpURLConnection, RequestBatch requestBatch) {
        this.requests = requestBatch;
        this.connection = httpURLConnection;
    }

    public RequestAsyncTask(HttpURLConnection httpURLConnection, Collection<Request> collection) {
        this(httpURLConnection, new RequestBatch((Collection) collection));
    }

    public RequestAsyncTask(HttpURLConnection httpURLConnection, Request... requestArr) {
        this(httpURLConnection, new RequestBatch(requestArr));
    }

    public RequestAsyncTask(Collection<Request> collection) {
        this(null, new RequestBatch((Collection) collection));
    }

    public RequestAsyncTask(Request... requestArr) {
        this(null, new RequestBatch(requestArr));
    }

    protected List<Response> doInBackground(Void... voidArr) {
        try {
            return this.connection == null ? this.requests.executeAndWait() : Request.executeConnectionAndWait(this.connection, this.requests);
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }

    RequestAsyncTask executeOnSettingsExecutor() {
        if (executeOnExecutorMethod != null) {
            try {
                executeOnExecutorMethod.invoke(this, new Object[]{Settings.getExecutor(), null});
            } catch (InvocationTargetException e) {
            } catch (IllegalAccessException e2) {
            }
        } else {
            execute(new Void[0]);
        }
        return this;
    }

    protected final Exception getException() {
        return this.exception;
    }

    protected final RequestBatch getRequests() {
        return this.requests;
    }

    protected void onPostExecute(List<Response> list) {
        super.onPostExecute(list);
        if (this.exception != null) {
            Log.d(TAG, String.format("onPostExecute: exception encountered during request: %s", new Object[]{this.exception.getMessage()}));
        }
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (this.requests.getCallbackHandler() == null) {
            this.requests.setCallbackHandler(new Handler());
        }
    }

    public String toString() {
        return "{RequestAsyncTask: " + " connection: " + this.connection + ", requests: " + this.requests + "}";
    }
}
