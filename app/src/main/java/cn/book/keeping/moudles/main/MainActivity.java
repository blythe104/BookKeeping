package cn.book.keeping.moudles.main;

import android.os.Bundle;
import android.widget.Toast;

import cn.book.keeping.R;
import cn.book.keeping.libs.activity.ViewPagerActivity;
import cn.book.keeping.moudles.main.fragment.BookKeepingFragment;
import cn.book.keeping.moudles.main.fragment.BookKeepingListFragment;
import cn.book.keeping.moudles.main.fragment.MineFragment;

public class MainActivity extends ViewPagerActivity {
    private long exitTime;

    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setLayoutId(R.layout.fragment_base_bottom_tab);
        super.initViews(savedInstanceState);

    }

    @Override
    public void initFragment() {
        fragmentList.add(new BookKeepingFragment());
        fragmentList.add(new BookKeepingListFragment());
        fragmentList.add(new MineFragment());
    }
}
