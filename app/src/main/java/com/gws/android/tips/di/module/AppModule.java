package com.gws.android.tips.di.module;


import com.gws.android.tips.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jara on 2017-3-24.
 */

@Module
public class AppModule {

    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Singleton
    @Provides
    App providerApplicationContext() {
        return application;
    }
}
