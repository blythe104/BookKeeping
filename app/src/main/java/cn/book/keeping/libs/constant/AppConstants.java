package cn.book.keeping.libs.constant;


/**
 * Created by yh on 16/6/17.
 */
public interface AppConstants {
    interface BmobKey {
        String KEY = "dc25d1bd3a3c24bafd212b9b1f57f67d";
    }

    interface ShareKey {
        String IS_FIRST_OPEN = "is_first_open";
    }

    interface URL {
        String BASE_URL = "";//BuildConfig.BASE_URL;
        String LOGIN = BASE_URL + "login";
    }

    String ClientType = "android";
}
