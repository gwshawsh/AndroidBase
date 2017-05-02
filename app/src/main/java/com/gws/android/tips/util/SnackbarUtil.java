package com.gws.android.tips.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by jara on 2017-3-24.
 */

public class SnackbarUtil {

    public static void showLong(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showShort(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }

}
