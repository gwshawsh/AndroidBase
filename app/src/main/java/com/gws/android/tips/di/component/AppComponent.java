package com.gws.android.tips.di.component;


import com.gws.android.tips.App;
import com.gws.android.tips.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017-3-24.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    App getContext();

}
