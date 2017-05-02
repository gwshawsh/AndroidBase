package com.gws.android.tips.base;

/**
 * Created by Jiaqi on 2017/3/25.
 */

public interface Presenter<T extends BaseView> {

    void attachView(T view);
    void detachView();

}
