package com.gws.android.tips.di.component;

import android.app.Activity;

import com.gws.android.tips.di.module.FragmentModule;
import com.gws.android.tips.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by Jiaqi on 2017/3/28.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

}
