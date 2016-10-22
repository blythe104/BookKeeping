package cn.book.keeping.libs.utils;

import android.util.Log;


/**
 * Created by yh on 16/5/25.
 */
public class LogUtils {

    public static void log(String key, String value) {
//        if (BuildConfig.DEBUG) {
            Log.d(key, value);
//        }
    }
}
