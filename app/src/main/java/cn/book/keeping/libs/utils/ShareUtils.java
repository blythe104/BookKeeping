package cn.book.keeping.libs.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yh on 16/6/9.
 */
public class ShareUtils {
    private static SharedPreferences share;
    private static SharedPreferences.Editor editor;
    private static Application mApplication;


    public static void init(Application application) {
        mApplication = application;
        check();
    }

    private ShareUtils() {

    }


    public static void check() {
        if (share == null || editor == null) {
            share = mApplication.getSharedPreferences("share", Context.MODE_APPEND);
            editor = share.edit();
        }
    }

    public static void saveString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public static String getString(String key, String normalValue) {
        return share.getString(key, normalValue);
    }

    public static void saveBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean getBoolean(String key, boolean normalValue) {
        return share.getBoolean(key, normalValue);
    }

}
