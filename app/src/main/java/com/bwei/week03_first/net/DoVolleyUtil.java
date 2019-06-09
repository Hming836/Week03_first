package com.bwei.week03_first.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther :Hming
 * @Date : 2019/6/9  20:47
 * @Description: ${DESCRIPTION}
 */
public class DoVolleyUtil {
    // 单例模式（懒汉式）
    private DoVolleyUtil() {
    }

    private static DoVolleyUtil util;

    public synchronized static DoVolleyUtil getUtil() {
        if (util == null) {
            util = new DoVolleyUtil();
        }
        return util;
    }

    // 判断网络
    public Boolean isNetWork(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null) {
            return info.isConnected();
        }
        return false;
    }

    // GET请求
    public void doVolleyGet(String url, final CallBackString backString) {
        StringRequest requestGet = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                backString.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                backString.onError(error.getMessage());
            }
        });
        requestGet.setTag("get");
        MyApplication.getQueue().add(requestGet);
    }

    // POST请求
    public void doVolleyPost(String url, String phone, String pwd, final CallBackString backString) {
        final Map<String, String> param = new HashMap<>();
        // 记着点  别把键写错了
        param.put("phone", "" + phone);
        param.put("pwd", "" + pwd);
        StringRequest requestPost = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                backString.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                backString.onError(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return param;
            }
        };
        requestPost.setTag("post");
        MyApplication.getQueue().add(requestPost);
    }

}

