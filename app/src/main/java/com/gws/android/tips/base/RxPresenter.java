package com.gws.android.tips.base;


import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


public class RxPresenter<T extends BaseView> implements Presenter<T> {

    protected T mView;
    protected CompositeSubscription mCompositeSubscription;

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscrebe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }



    @Override
    public void attachView(T view) {

    }

    @Override
    public void detachView() {

    }
}
