package cn.book.keeping.moudles.register;

import android.os.Bundle;

import cn.book.keeping.libs.activity.BaseActivity;
import cn.book.keeping.moudles.register.fragment.RegisterFragment;

public class RegisterActivity extends BaseActivity {


    @Override
    protected void initViews(Bundle savedInstanceState) {
        setFragment(new RegisterFragment());
    }
}
