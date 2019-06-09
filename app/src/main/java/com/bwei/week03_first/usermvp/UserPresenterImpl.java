package com.bwei.week03_first.usermvp;

import com.bwei.week03_first.net.CallBackString;

/**
 * @Auther :Hming
 * @Date : 2019/5/27  21:06
 * @Description: ${DESCRIPTION}
 */
public class UserPresenterImpl implements IUserContract.IUserPresenter {
    IUserContract.IUserModel model;
    IUserContract.IUserView view;

    @Override
    public void attach(IUserContract.IUserView view) {
        this.view = view;
        model = new UserModelImpl();
    }

    @Override
    public void detach() {
        if (view != null) {
            view = null;
        }
        if (model != null) {
            model = null;
        }
        System.gc();
    }

    @Override
    public void requestData(String url, String phone, String pwd) {
        model.requestData(url, phone, pwd, new CallBackString() {
            @Override
            public void onSuccess(String result) {
                view.showData(result);
            }

            @Override
            public void onError(String msg) {
                //view.showData(msg);
            }
        });
    }
}
