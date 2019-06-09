package com.bwei.week03_first.net;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @Auther :Hming
 * @Date : 2019/5/27  20:45
 * @Description: ${DESCRIPTION}
 */
public class MyApplication extends Application {

    private static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getQueue() {
        return queue;
    }
}
