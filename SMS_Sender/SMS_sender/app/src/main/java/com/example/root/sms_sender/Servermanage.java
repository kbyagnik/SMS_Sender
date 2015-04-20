package com.example.root.sms_sender;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by DC on 27/3/15.
 */
public class Servermanage extends Application {

    public static final String name = Servermanage.class.getSimpleName();
    private RequestQueue queue;
    private static Servermanage manager;

    @Override
    public void onCreate() {
        super.onCreate();
        manager = this;
    }

    public static synchronized Servermanage getInstance() {
        return manager;
    }

    public RequestQueue getRequestQueue() {
        if (queue == null) {
            queue = Volley.newRequestQueue(getApplicationContext());
        }

        return queue;
    }

    public <T> void addToRequestQueue(Request<T> request, String tag) {
        request.setTag(TextUtils.isEmpty(tag) ? name : tag);
        //Log.d("aaloo",tag);
        getRequestQueue().add(request);
    }

    public <T> void addToRequestQueue(Request<T> request) {
        request.setTag(name);
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests(Object requestTag) {
        if (queue != null) {
            queue.cancelAll(requestTag);
        }
    }


}
