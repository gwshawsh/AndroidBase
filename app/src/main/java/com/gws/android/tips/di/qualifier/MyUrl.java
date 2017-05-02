package com.gws.android.tips.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Jiaqi on 2017/3/28.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyUrl {
}
