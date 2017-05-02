package com.gws.android.tips;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.gws.android.tips.constants.Constants;
import com.gws.android.tips.di.component.AppComponent;
import com.gws.android.tips.di.component.DaggerAppComponent;
import com.gws.android.tips.di.module.AppModule;
import com.gws.android.tips.util.BuglyUtil;
import com.squareup.leakcanary.LeakCanary;

import java.util.HashSet;
import java.util.Set;

import cn.bmob.v3.Bmob;


public class App extends Application {

    private static App instance;
    private AppComponent appComponent;
    private Set<Activity> allActivities = new HashSet<>();

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;
    private Activity mCurrentActivity;
    public static synchronized App getInstance() {
        return instance;
    }

    public static Context getContext(){
        return getInstance().getCurrentActivity();
    }
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initInjector();
        initLeakcanary();
        initScreenSize();
        initBugly();
        initBmob();
    }


    public Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    public void setCurrentActivity(@NonNull Activity mCurrentActivity) {
        this.mCurrentActivity = mCurrentActivity;
    }
    public void addActivity(Activity activity) {
        allActivities.add(activity);
    }

    public void removeActivity(Activity a) {
        allActivities.remove(a);

    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
    private void initInjector() {
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
    private void initLeakcanary(){
        LeakCanary.install(this);
        if(BuildConfig.DEBUG){

        }
    }
    private void initBugly(){
        BuglyUtil.initBugly(this);
    }
    private void initBmob(){
        Bmob.initialize(this, Constants.BMOB_APPID);
    }
    public void initScreenSize() {
        WindowManager wm = (WindowManager) this.getSystemService(WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = wm.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;

        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }

}
