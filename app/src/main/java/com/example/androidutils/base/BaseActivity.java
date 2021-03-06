package com.example.androidutils.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/1/16.
 * Copyright (c) 2018 . All rights reserved.
 * Base activity.
 */

public abstract class BaseActivity extends AppCompatActivity {


    protected final String TAG = this.getClass().getSimpleName();

    protected Context mContext;

    /**
     * 设置布局属性
     *
     * @return
     */
    protected abstract Object setLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置布局
        if (setLayout() instanceof View) {
            setContentView((View) setLayout());
        } else if (setLayout() instanceof Integer) {
            setContentView((Integer) setLayout());
        } else {
            throw new RuntimeException("You must use the method:setLayout()");
        }

        mContext = this;

        initParamsAndValues();

        initViews();

        initData();
    }

    /**
     * init params and values
     *
     * @hide
     */
    protected abstract void initParamsAndValues();

    /**
     * init views
     *
     * @hide
     */
    protected abstract void initViews();

    /**
     * init data
     *
     * @hide
     */
    protected void initData() {

    }

    protected ActionBar initActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        return actionBar;
    }

}
