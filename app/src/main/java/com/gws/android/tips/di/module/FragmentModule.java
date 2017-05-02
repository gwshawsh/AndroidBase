package com.gws.android.tips.di.module;

import android.app.Activity;
import android.app.Fragment;

import com.gws.android.tips.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jiaqi on 2017/3/28.
 */
@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        this.mFragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return mFragment.getActivity();
    }

}
