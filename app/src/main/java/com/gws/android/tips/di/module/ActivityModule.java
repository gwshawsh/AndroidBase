package com.gws.android.tips.di.module;

import android.app.Activity;

import com.gws.android.tips.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jiaqi on 2017/3/25.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }

}
