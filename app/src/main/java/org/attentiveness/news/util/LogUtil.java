package org.attentiveness.news.util;

import android.util.Log;

public class LogUtil {

    private static boolean mDebug = true;

    public static void d(String message) {
        d("News", message);
    }

    public static void d(String tag, String message) {
        if (mDebug) {
            Log.d(tag, message);
        }
    }

    public static void e(String message) {
        e("News", message);
    }

    public static void e(String tag, String message) {
        if (mDebug) {
            Log.e(tag, message);
        }
    }

}
