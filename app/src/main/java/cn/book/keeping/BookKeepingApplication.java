package cn.book.keeping;

import android.app.Application;

import cn.bmob.v3.Bmob;
import cn.book.keeping.libs.utils.ShareUtils;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-20
 * Time: 10:31
 */
public class BookKeepingApplication extends Application {
    public static String APPID = "fcc484faede5f0b0fe73e79633b28ef8 ";
    @Override
    public void onCreate() {
        super.onCreate();
        ShareUtils.init(this);
        Bmob.initialize(this, APPID);
    }
}
