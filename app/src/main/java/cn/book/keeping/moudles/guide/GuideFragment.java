package cn.book.keeping.moudles.guide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import cn.book.keeping.R;
import cn.book.keeping.UserInfoObj;
import cn.book.keeping.libs.fragment.BaseFragment;
import cn.book.keeping.moudles.login.LoginActivity;
import cn.book.keeping.moudles.main.MainActivity;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-20
 * Time: 11:44
 */
public class GuideFragment extends BaseFragment {
    @Override
    public void initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setContentView(R.layout.fragment_guide);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                UserInfoObj userInfoObj = new UserInfoObj();
                if (userInfoObj.isLogin()) {
                    Intent intent = new Intent(mActivity, MainActivity.class);
                    startActivity(intent);
                    mActivity.finish();
                } else {
                    Intent intent = new Intent(mActivity, LoginActivity.class);
                    startActivity(intent);
                    mActivity.finish();
                }

            }
        }, 200);

    }
}
