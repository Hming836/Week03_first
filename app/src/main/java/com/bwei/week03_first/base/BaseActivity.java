package com.bwei.week03_first.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @Auther :Hming
 * @Date : 2019/5/27  19:30
 * @Description: 抽取基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindView());
        bindLayout();
        initData();
        bindEvent();
    }

    public abstract int bindView();

    public abstract void bindLayout();

    public abstract void initData();

    public abstract void bindEvent();
}
