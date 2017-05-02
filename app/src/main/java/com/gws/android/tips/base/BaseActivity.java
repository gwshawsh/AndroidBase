package com.gws.android.tips.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gws.android.tips.App;

import javax.inject.Inject;

import butterknife.ButterKnife;



public abstract class BaseActivity<T extends Presenter> extends AppCompatActivity
        implements BaseView {

    @Inject
    protected T mPresenter;
    protected Activity mActivity;

    protected abstract void initInject();
    protected abstract int getLayout();
    protected abstract void initEventAndData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        mActivity = this;
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
        App.getInstance().addActivity(this);

        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        App.getInstance().removeActivity(this);
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.getInstance().setCurrentActivity(this);
    }



    @Override
    protected void onPause() {
        super.onPause();
        clearReferences();
    }

    private void clearReferences(){
        Activity currActivity = App.getInstance().getCurrentActivity();
        if (this.equals(currActivity))
            App.getInstance().setCurrentActivity(null);
    }
}
