package cn.book.keeping.moudles.setting;

import android.os.Bundle;

import cn.book.keeping.libs.activity.BaseActivity;
import cn.book.keeping.moudles.setting.fragment.SettingFragment;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setFragment(new SettingFragment());
    }
}
