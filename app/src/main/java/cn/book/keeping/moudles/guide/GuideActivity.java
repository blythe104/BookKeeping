package cn.book.keeping.moudles.guide;

import android.os.Bundle;

import cn.book.keeping.libs.activity.BaseActivity;

public class GuideActivity extends BaseActivity {
    @Override
    protected void initViews(Bundle savedInstanceState) {
        setFragment(new GuideFragment());
    }
}
