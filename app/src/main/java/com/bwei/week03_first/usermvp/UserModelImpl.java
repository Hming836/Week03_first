package com.bwei.week03_first.usermvp;

import com.bwei.week03_first.net.CallBackString;
import com.bwei.week03_first.net.DoVolleyUtil;

/**
 * @Auther :Hming
 * @Date : 2019/5/27  20:44
 * @Description: ${DESCRIPTION}
 */
public class UserModelImpl implements IUserContract.IUserModel {

    private DoVolleyUtil util;

    @Override
    public void requestData(String url, String phone, String pwd, CallBackString backString) {
        util = DoVolleyUtil.getUtil();
        util.doVolleyPost(url, phone, pwd, backString);
    }
}
