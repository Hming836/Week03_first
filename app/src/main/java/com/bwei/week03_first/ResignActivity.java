package com.bwei.week03_first;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwei.week03_first.base.BaseActivity;
import com.bwei.week03_first.usermvp.IUserContract;
import com.bwei.week03_first.usermvp.UserPresenterImpl;

public class ResignActivity extends BaseActivity implements IUserContract.IUserView {


    private EditText et_phone, et_pwd;
    private Button bt_register;
    private IUserContract.IUserPresenter presenter;


    @Override
    public int bindView() {
        return R.layout.activity_resign;
    }

    @Override
    public void bindLayout() {
        presenter = new UserPresenterImpl();
        presenter.attach(this);
        et_phone = findViewById(R.id.edit_resign_phone);
        et_pwd = findViewById(R.id.edit_resign_pwd);
        bt_register = findViewById(R.id.bt_register);
    }

    @Override
    public void initData() {
    }

    @Override
    public void bindEvent() {
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = et_phone.getText().toString().trim();
                String pwd = et_pwd.getText().toString().trim();
                presenter.requestData("http://172.17.8.100/small/user/v1/register", phone, pwd);
            }
        });
    }

    @Override
    public void showData(String result) {
        Toast.makeText(this, "" + result, Toast.LENGTH_SHORT).show();
    }
}
