package com.gws.android.tips.di.component;

import android.app.Activity;

import com.gws.android.tips.di.module.ActivityModule;
import com.gws.android.tips.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by Administrator on 2017-3-24.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

}
