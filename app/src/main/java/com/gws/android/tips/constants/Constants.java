package com.gws.android.tips.constants;

import android.os.Environment;

import com.gws.android.tips.App;

import java.io.File;



public class Constants {


    //================= KEY ====================


    public static final String BUGLY_APPID = "d2a788a85e";
    public static final String BMOB_APPID = "3e2d45e96b4a3022ed23322061e15697";

    //================= PATH ====================

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";



}
