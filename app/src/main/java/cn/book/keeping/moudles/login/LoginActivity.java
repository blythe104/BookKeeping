package cn.book.keeping.moudles.login;

import android.app.Activity;
import android.os.Bundle;

import cn.book.keeping.R;
import cn.book.keeping.libs.activity.BaseActivity;
import cn.book.keeping.moudles.login.fragment.LoginFragment;

public class LoginActivity extends BaseActivity {



    @Override
    protected void initViews(Bundle savedInstanceState) {
        setFragment(new LoginFragment());
    }
}
