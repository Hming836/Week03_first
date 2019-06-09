package com.bwei.week03_first;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.week03_first.base.BaseActivity;
import com.bwei.week03_first.usermvp.IUserContract;
import com.bwei.week03_first.usermvp.UserPresenterImpl;

/**
 * @Auther :Hming
 * @Date : 2019/6/9  21:05
 * @Description: 登录页面
 */
public class MainActivity extends BaseActivity implements IUserContract.IUserView {
    IUserContract.IUserPresenter presenter;
    private EditText editText_phone;
    private EditText editText_pwd;
    private Button bt_login;
    private TextView tv_register;
    private String phone;
    private String pwd;

    @Override
    public int bindView() {
        return R.layout.activity_main;
    }

    @Override
    public void bindLayout() {
        editText_phone = findViewById(R.id.edit_login_phone);
        editText_pwd = findViewById(R.id.edit_login_pwd);
        bt_login = findViewById(R.id.bt_login);
        tv_register = findViewById(R.id.text_register);

    }

    @Override
    public void initData() {
        presenter = new UserPresenterImpl();
        presenter.attach(MainActivity.this);

    }

    @Override
    public void bindEvent() {
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = editText_phone.getText().toString().trim();
                pwd = editText_pwd.getText().toString().trim();
                presenter.requestData("http://172.17.8.100/small/user/v1/login", phone, pwd);
            }
        });

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ResignActivity.class));
            }
        });
    }

    @Override
    public void showData(String result) {
        Toast.makeText(this, "" + result, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}

