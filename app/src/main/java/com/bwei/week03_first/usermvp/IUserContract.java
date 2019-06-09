package com.bwei.week03_first.usermvp;

import com.bwei.week03_first.net.CallBackString;

/**
 * @Auther :Hming
 * @Date : 2019/5/27  20:39
 * @Description: 契约管理接口
 */
public interface IUserContract {

    public interface IUserView {
        void showData(String result);
    }

    public interface IUserModel {
        void requestData(String url, String phone, String pwd, CallBackString backString);
    }

    public interface IUserPresenter {
        void attach(IUserView view);

        void detach();

        void requestData(String url, String phone, String pwd);
    }
}
