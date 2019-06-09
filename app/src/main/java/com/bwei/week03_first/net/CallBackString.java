package com.bwei.week03_first.net;

/**
 * @Auther :Hming
 * @Date : 2019/5/27  20:42
 * @Description: ${DESCRIPTION}
 */
public interface CallBackString {
    void onSuccess(String result);

    void onError(String msg);
}
